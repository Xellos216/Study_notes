## 📘 Week4 Summary: Subquery & Join (상세)

---

### ✅ 수업 핵심 목표
- **Subquery**: 여러 번의 계산을 하나의 SQL 문 안에서 수행하고, 그 결과를 다시 활용하는 방식 학습
- **Join**: 서로 다른 테이블의 데이터를 하나로 결합해 분석 및 연산하는 기법 학습

---

### 1. 문자 포맷 변경 & 조건문 복습
- 문자열 다루기
  - `REPLACE(str, from, to)`: 문자열 대체
  - `SUBSTRING(str, start, length)`: 특정 부분 추출
  - `CONCAT(str1, str2, ...)`: 문자열 합치기
- 조건문
  - `IF(condition, true_result, false_result)`
  - `CASE WHEN ... THEN ... ELSE ... END`

---

### 2. Subquery 개념 및 활용

**Subquery란?**
- 쿼리 안에 포함된 또 다른 쿼리
- 주로 연산 결과를 중간 저장하거나 필터링 조건으로 활용

**예시**
```sql
select order_id, restaurant_name, if(over_time>=0, over_time, 0) over_time
from (
    select order_id, restaurant_name, food_preparation_time - 25 as over_time
    from food_orders
) a;
```

---

### 3. Subquery 실습: User Segmentation + 수수료 계산

**목표**: 평균 단가에 따라 음식점을 구분하고, 그룹별 수수료 부과

**예시 쿼리 요약**
```sql
select restaurant_name, price_per_plate * ratio_of_add as 수수료
from (
    select restaurant_name,
           case 
             when price_per_plate < 5000 then 0.005
             when price_per_plate < 20000 then 0.01
             when price_per_plate < 30000 then 0.02
             else 0.03
           end as ratio_of_add,
           price_per_plate
    from (
        select restaurant_name, avg(price/quantity) as price_per_plate
        from food_orders
        group by restaurant_name
    ) a
) b;
```

---

### 4. Subquery 실습 2: 지역 & 평균 배달시간 기반 구간화

**포인트**
- 주소에서 지역 정보만 추출: `SUBSTRING(addr, 1, 2)`
- 평균 배달시간으로 구간 나누기

---

### 5. 복잡한 Subquery 연산

- 조건별 수수료율 부여 (예: 음식점 수 ≥5, 주문 ≥30 → 수수료율 0.05%)
- 주문 수량과 금액에 따라 할인율 적용

---

### 6. JOIN 기본 개념

- `LEFT JOIN`: 기준 테이블은 모두 출력, 대응되는 값이 없으면 NULL
- `INNER JOIN`: 양쪽 테이블 모두에 값이 있을 때만 출력

**예시**
```sql
select a.order_id, a.restaurant_name, b.name, b.age
from food_orders a
left join customers b on a.customer_id = b.customer_id;
```

---

### 7. JOIN 실습

- 주문 + 고객 정보 → 고객별 주문 식당 확인
- 주문 + 결제 정보 → 결제 수단 및 수수료율 확인
- 음식 가격 × 수수료율 → 실제 수수료 계산

---

### 8. 실습: 나이 기반 할인율 적용

```sql
select cuisine_type,
       sum(price) as 원래가격,
       sum(price) - sum(discount_price) as 할인적용가격,
       sum(discount_price) as 할인금액
from (
    select a.cuisine_type,
           a.price,
           a.price * ((b.age - 50) * 0.005) as discount_price
    from food_orders a
    inner join customers b on a.customer_id = b.customer_id
    where b.age >= 50
) t
group by cuisine_type
order by 할인금액 desc;
```

---

### 9. HW: 평균 주문 금액 & 주문자 연령 기반 그룹화

- 금액 기준 그룹: 5천 / 1만 / 3만 / 3만 초과
- 연령 기준 그룹: 20대 이하 / 30대 / 40대 / 50대 이상

**예시**
```sql
select restaurant_name,
       case when price <=5000 then 'price_group1'
            when price <=10000 then 'price_group2'
            when price <=30000 then 'price_group3'
            else 'price_group4' end as price_group,
       case when age <30 then 'age_group1'
            when age between 30 and 39 then 'age_group2'
            when age between 40 and 49 then 'age_group3'
            else 'age_group4' end as age_group
from (
    select a.restaurant_name, avg(price) as price, avg(age) as age
    from food_orders a
    inner join customers b on a.customer_id = b.customer_id
    group by a.restaurant_name
) t;
```
