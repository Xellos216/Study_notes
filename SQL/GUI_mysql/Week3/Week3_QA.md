# ❓ SQL 3주차 실습 QA 정리

---

### ✅ Q1. WHERE에서 rating 조건을 안 쓰면 왜 에러가 나나요?

- `WHERE rating`만 쓰면 **불완전한 조건**이라 에러 발생
- `WHERE rating = 1` 같이 **비교 연산자**를 명확히 써야 함
- 또한 `GROUP BY AVG(price)`처럼 **집계함수는 그룹 기준이 될 수 없음**

**✅ 수정 예시**:
```sql
SELECT rating, AVG(price)
FROM food_orders
WHERE rating = 1
GROUP BY rating;
```

---

### ✅ Q2. 수량이 1인 주문의 음식 종류별 평균 가격 구하기

```sql
SELECT cuisine_type, quantity, AVG(price) AS avg_price
FROM food_orders
WHERE quantity = 1
GROUP BY cuisine_type
ORDER BY cuisine_type;
```

- `quantity = 1`이라면 GROUP BY 외의 컬럼도 문제 없음

---

### ✅ Q3. CASE문에서 에러가 나는 이유?

- 조건절 괄호 미완성
- 큰따옴표(`"`) 사용 → 문자열은 `'`로 감싸야 함

**✅ 수정 예시**:
```sql
CASE
  WHEN (age BETWEEN 10 AND 19 AND gender = 'male') THEN '10대 남성'
```

---

### ✅ Q4. 성별로 묶고 나이 오름차순 정렬하려면?

```sql
ORDER BY gender, age;
```

- `GROUP BY`는 묶어서 요약하고 `ORDER BY`는 정렬만 한다는 차이 이해

---

### ✅ Q5. GROUP BY를 쓰면 왜 데이터가 줄어드나요?

- `GROUP BY`는 **묶어서 하나로 요약**
- `ORDER BY`는 **데이터 전체 유지하며 정렬만**

---

### ✅ Q6. 성별은 내림차순, 나이는 오름차순 정렬?

```sql
ORDER BY gender DESC, age ASC;
```

---

### ✅ Q7. CASE문에서 문법 오류 발생한 이유

- `WHEN` 절 끝에 쉼표(,) 쓰면 안 됨
- 작은따옴표/괄호 누락 오류

**✅ 수정 예시**:
```sql
CASE
  WHEN delivery_time > 25 AND delivery_time <= 30 THEN ...
```

---

### ✅ Q8. 주소 기준 같은 지역끼리 정렬하려면?

```sql
ORDER BY SUBSTRING(addr, 1, 2), delivery_time;
```

---

### ✅ Q9. 배달 수수료가 같은 주문들의 건수를 구하려면?

```sql
SELECT 배달_수수료, COUNT(*) AS 주문_건수
FROM (
  SELECT IF(...) * IF(...) AS 배달_수수료
  FROM food_orders
) AS temp
GROUP BY 배달_수수료;
```

---

### ✅ Q10. 서브쿼리 alias에 '따옴표' 쓰면 안 되는 이유?

- `'배달 수수료'` → 문자열
- `배달_수수료` 또는 `AS \`배달 수수료\``처럼 써야 함

---

### ✅ Q11. `COUNT(*)`에서 `*`의 의미?

- `COUNT(*)`은 **존재하는 모든 행 수**
- `COUNT(column)`은 **NULL이 아닌 값만 셈**

---

### ✅ Q12. 언제 `'문자열'` vs `컬럼명`?

| 예시 | 의미 |
|------|------|
| `'서울'` | 문자열 리터럴 |
| `price` | 컬럼명 |
| `AS \`배달 수수료\`` | 공백 포함된 별칭 (MySQL은 백틱 사용) |

---

### ✅ Q13. 배달 지연 여부를 판단하는 조건 만들기

**문제 조건**:
- 주중: 25분 이상이면 '늦음'
- 주말: 30분 이상이면 '늦음'

**✅ 정답 예시**:
```sql
SELECT
  order_id AS '주문 번호',
  day_of_the_week AS '주문 시기',
  delivery_time AS '배달 시간',
  CASE
    WHEN day_of_the_week = 'Weekday' AND delivery_time >= 25 THEN '늦음'
    WHEN day_of_the_week = 'Weekend' AND delivery_time >= 30 THEN '늦음'
    ELSE '정상'
  END AS '지연 여부'
FROM food_orders;
```
