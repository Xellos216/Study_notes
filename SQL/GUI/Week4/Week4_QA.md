# Week4_QA.md

## ✅ Q1: GROUP BY vs ORDER BY 개념 정리

### 차이점 요약

| 항목           | GROUP BY                          | ORDER BY                   |
|----------------|-----------------------------------|----------------------------|
| 목적           | 행을 그룹핑 (집계 목적)          | 결과 정렬                 |
| 주로 함께 쓰는 것 | COUNT, SUM, AVG 등 집계 함수     | ASC/DESC                  |
| 사용 위치       | SELECT 이후, ORDER BY 이전        | 쿼리 맨 마지막            |
| 결과 변화       | 행 수 줄어듦                      | 행 순서만 바뀜            |

### 확인용 문제
`food_orders` 테이블에서 각 음식점별 평균 주문 금액을 구하고, 그 결과를 평균 금액 높은 순으로 정렬하는 쿼리를 작성하시오.

---

## ✅ Q2: count(*)은 뭘 세는가? 그룹별 합계는?

### 개념
- `count(*)`: 그룹 내 **전체 행 수**
- 특정 컬럼을 기준으로 집계하려면:  
  - `count(distinct restaurant_name)`
  - `sum(quantity)`

### 예시 쿼리
```sql
select cuisine_type,
       count(distinct restaurant_name) as num_of_restaurants,
       sum(quantity) as total_quantity
from food_orders
group by cuisine_type;
```

---

## ✅ Q3: case + group + substr로 수수료율 계산 쿼리 검수

### 문제점
- 외부 SELECT에서 서브쿼리 alias 컬럼명 오타 있음
  - `addr` → `ad`
  - `count_ad` → 실제 컬럼명과 불일치

### 수정된 쿼리
```sql
select
    ad,
    total_quantity,
    count_ad,
    case
        when count_ad >= 5 and total_quantity >= 30 then 0.005
        when count_ad >= 5 and total_quantity <  30 then 0.008
        when count_ad <  5 and total_quantity >= 30 then 0.01
        when count_ad <  5 and total_quantity <  30 then 0.02
    end as rate
from (
    select substr(addr, 1, 2) as ad,
           sum(quantity) as total_quantity,
           count(distinct restaurant_name) as count_ad
    from food_orders
    group by ad
) a;
```

---

## ✅ Q4: JOIN 쓸 때 ORDER BY 안 되는 이유?

- `;` 세미콜론이 **중간에 잘못 들어감**
- `;`는 쿼리 종료를 의미하므로, 이후 `order by`는 **두 번째 쿼리로 인식되어 문법 오류 발생**

✅ 수정 쿼리:
```sql
select ...
from food_orders a
left join customers b on a.customer_id = b.customer_id
order by b.age asc;
```

---

## ✅ Q5: 세미콜론 `;` 꼭 써야 하나요?

### 요약
| 상황 | `;` 필요 여부 |
|------|----------------|
| 쿼리 하나 실행 | ❌ 생략 가능 |
| 여러 쿼리 실행 또는 스크립트 | ✅ 필수 |

- 한 줄짜리 실행에는 생략 가능하지만,
- 습관적으로 붙여두는 것이 **스크립트화 시 안전**

---

## ✅ Q6: DISTINCT의 역할은?

- 결과에서 **중복된 행 전체(row)** 를 제거
- `DISTINCT name` → 이름이 같은 행만 제거가 아니라, **전체 컬럼 조합이 중복**일 때만 제거됨

---

## ✅ Q7: 왜 메인 쿼리에서는 `f.price` 안 써도 되는가?

- 서브쿼리에서 만든 컬럼은 **별칭 테이블(a)의 컬럼**
- 메인 쿼리에서는 그 컬럼을 그냥 `price`, `sale`처럼 사용할 수 있음 (필요 시 `a.price`도 가능)

---

## ✅ Q8: 식당별 평균 주문 금액과 평균 연령을 기반으로 Segmentation 하기

### 조건
- 평균 금액 기준:  
  `<= 5천`, `<=1만`, `<=3만`, `초과`
- 평균 나이 기준:  
  `20대 이하`, `30대`, `40대`, `50대 이상`

### 정답 쿼리
```sql
select *
from (
  select
    restaurant_name,
    case 
      when price <= 5000 then 'price_5000'
      when price <= 10000 then 'price_10000'
      when price <= 30000 then 'price_30000'
      else 'price_over'
    end as price_group,
    case 
      when age < 30 then 'age_20'
      when age between 30 and 39 then 'age_30'
      when age between 40 and 49 then 'age_40'
      else 'age_50'
    end as age_group
  from (
    select
      f.restaurant_name,
      avg(f.price) as price,
      avg(c.age) as age
    from food_orders f
    inner join customers c on f.customer_id = c.customer_id
    group by f.restaurant_name
  ) a
) final
where age_group is not null
order by restaurant_name;
```
