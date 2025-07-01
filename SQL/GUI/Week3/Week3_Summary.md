# 🧠 Summary: [KDC] 엑셀보다 쉬운 SQL - 3주차

## 📌 핵심 목표
- **문자 데이터 가공**: `REPLACE`, `SUBSTRING`, `CONCAT` 등으로 워딩 수정
- **조건문 활용**: `IF`, `CASE`를 통한 조건별 처리
- **데이터 타입 오류 대응**: `CAST`로 타입 명시
- **업무용 실습**: Group by, 조건분기, 수수료 계산 등 실전 적용

---

## 1. 문자 가공 함수 정리

| 함수 | 기능 | 예시 |
|------|------|------|
| `REPLACE(str, from_str, to_str)` | 특정 문자 치환 | `replace(addr, '문곡리', '문가리')` |
| `SUBSTRING(str, pos, len)` 또는 `SUBSTR()` | 원하는 위치의 문자 추출 | `substr(addr, 1, 2)` |
| `CONCAT(str1, str2, ...)` | 여러 문자 이어 붙이기 | `concat('[', substr(addr,1,2), '] ', restaurant_name)` |

---

## 2. 조건문: IF / CASE

### IF 문
```sql
if(조건, 값1, 값2)
```
- 예시: `if(cuisine_type = 'Korean', '한식', '기타')`

### CASE 문
```sql
case
    when 조건1 then 결과1
    when 조건2 then 결과2
    else 기본값
end
```
- 다중 조건 분기 가능
- 복잡한 그룹 분류 시 사용 (예: 연령별/성별 분류)

---

## 3. 실습 예시 정리

### ① 서울 지역 음식 타입별 평균 금액
```sql
select substr(addr, 1, 2) as 지역, cuisine_type, avg(price)
from food_orders
where addr like '%서울%'
group by 1, 2
```

### ② 이메일 도메인별 고객 분석
```sql
select substr(email, 10) as 도메인, count(*), avg(age)
from customers
group by 1
```

### ③ User Segmentation 예시
```sql
case
    when age between 10 and 19 and gender = 'male' then '10대 남자'
    ...
end
```

---

## 4. 데이터 타입 오류 대응

- 문자열 → 숫자: `CAST(... AS DECIMAL)`
- 숫자 → 문자열: `CAST(... AS CHAR)`
- 예시:
```sql
--숫자로 변경
cast(if(rating='Not given', '1', rating) as decimal) 

--문자로 변경
concat(restaurant_name, '-', cast(order_id as char))
```

---

## 5. 실무형 계산 예시

### 배달 수수료 계산
```sql
case
    when delivery_time > 30 then price * 0.1 * (if(addr like '%서울%', 1.1, 1))
    ...
end
```

### 할증료 계산 (요일 & 음식 수량 기준)
```sql
if(day_of_the_week='Weekday', 3000, 3500) * if(quantity > 3, 1.2, 1)
```

---

## 📝 숙제 예시

### 평일/주말 기준 배달 지연 여부
```sql
case
    when day_of_the_week='Weekday' and delivery_time>=25 then 'Late'
    when day_of_the_week='Weekend' and delivery_time>=30 then 'Late'
    else 'On-time'
end
```
