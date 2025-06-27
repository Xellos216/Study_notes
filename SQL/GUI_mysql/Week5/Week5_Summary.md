# Week5 Summary: SQL 심화 실습 정리

이번 주차에서는 SQL로 실무 데이터 분석을 보다 효율적으로 수행하기 위한 고급 문법들을 학습하였습니다. 특히 이상치 처리, 피벗 테이블 구현, 윈도우 함수(Window Function), 날짜 포맷 처리 등 Excel에서 하던 업무를 SQL로 대체하는 실습에 집중하였습니다.

---

## 1. Subquery & JOIN 복습
- **Subquery (서브쿼리)**: 하나의 쿼리 안에 또 다른 쿼리를 넣어 사용합니다.
  ```sql
  SELECT name FROM (SELECT * FROM users) AS sub;
  ```
- **JOIN**: 여러 테이블을 공통된 키를 기준으로 결합합니다.
  - INNER JOIN: 양쪽 테이블에 모두 존재하는 데이터만 반환
  - LEFT JOIN: 왼쪽 테이블을 기준으로 오른쪽 테이블을 붙이며, 오른쪽에 값이 없으면 NULL

---

## 2. 값이 없을 때 처리
### 문제 상황
- 결측값(NULL), "Not given"과 같은 이상값 존재
- JOIN 후 오른쪽 테이블에 값이 없어 NULL이 나오는 경우

### 해결 방법
1. **연산에서 제외하기 (IF + NULL)**
   ```sql
   AVG(IF(rating <> 'Not given', rating, NULL))
   ```

2. **JOIN 시 NULL 제거**
   ```sql
   LEFT JOIN ... ON ...
   WHERE b.customer_id IS NOT NULL
   ```

3. **NULL 값을 다른 값으로 대체 (COALESCE)**
   ```sql
   COALESCE(age, 20) -- age가 NULL일 경우 20으로 대체
   ```

---

## 3. 상식적이지 않은 값 처리
### 예시
- 2세 고객, 1970년 결제일 등

### 해결 방법
- 조건문(CASE WHEN)을 통해 범위 지정
  ```sql
  CASE 
    WHEN age < 15 THEN 15
    WHEN age > 80 THEN 80
    ELSE age
  END AS adjusted_age
  ```

---

## 4. Pivot Table 구현 (SQL로 엑셀 피벗 대체)
### 핵심 아이디어
- `IF` + `MAX` 조합을 통해 행을 열로 변환
- 특정 조건의 집계값을 열 형태로 나열

### 예시 1: 시간대별 주문 건수
```sql
SELECT restaurant_name,
       MAX(IF(hh='15', cnt_order, 0)) AS "15시",
       ...
FROM (
    SELECT a.restaurant_name, SUBSTRING(b.time,1,2) hh, COUNT(*) cnt_order
    FROM food_orders a INNER JOIN payments b ON a.order_id = b.order_id
    WHERE SUBSTRING(b.time,1,2) BETWEEN 15 AND 20
    GROUP BY 1,2
) AS t
GROUP BY 1
ORDER BY `20시` DESC;
```

### 예시 2: 성별·연령대별 주문 건수
- 나이를 구간화하고, gender 별로 분리하여 열로 만듦

```sql
SELECT age_group,
       MAX(IF(gender='male', order_count, 0)) AS male,
       MAX(IF(gender='female', order_count, 0)) AS female
FROM (
    SELECT CASE
             WHEN age BETWEEN 10 AND 19 THEN 10
             WHEN age BETWEEN 20 AND 29 THEN 20
             ...
           END AS age_group,
           gender,
           COUNT(*) AS order_count
    FROM food_orders a INNER JOIN customers b ON a.customer_id = b.customer_id
    WHERE age BETWEEN 10 AND 59
    GROUP BY 1, 2
) AS t
GROUP BY 1
ORDER BY age_group;
```

---

## 5. Window Function
- 하나의 그룹 내에서 행별로 계산을 수행할 수 있는 고급 SQL 기능
- `OVER (PARTITION BY ... ORDER BY ...)` 문법 사용

### (1) RANK()
- 그룹 내 순위 부여
```sql
RANK() OVER (PARTITION BY cuisine_type ORDER BY order_count DESC)
```
- 실습: 음식타입별 주문건수 상위 3개 음식점 조회

### (2) SUM()
- 누적합 또는 비율 계산
```sql
SUM(order_count) OVER (PARTITION BY cuisine_type ORDER BY order_count)
```
- 실습: 음식타입별 음식점의 누적 주문건수와 합계 계산

---

## 6. 날짜 포맷과 조건
### 날짜 타입 처리
- 문자열 → 날짜 타입 변환
  ```sql
  DATE(date)
  ```

### 날짜 포맷 변경
```sql
DATE_FORMAT(DATE(date), '%Y') AS year,
DATE_FORMAT(DATE(date), '%m') AS month,
DATE_FORMAT(DATE(date), '%w') AS weekday
```

### 특정 월 조건 걸기
```sql
WHERE DATE_FORMAT(DATE(date), '%m') = '03'
```

---

## 7. HW 정답 요약
- 음식 타입별로 연령대별 주문 건수 집계
- Pivot 형식으로 출력 (10대~50대)
```sql
SELECT cuisine_type,
       MAX(IF(age=10, order_count, 0)) AS "10대",
       ...
FROM (
    SELECT cuisine_type,
           CASE
             WHEN age BETWEEN 10 AND 19 THEN 10
             ...
           END AS age,
           COUNT(*) AS order_count
    FROM food_orders a INNER JOIN customers b ON a.customer_id = b.customer_id
    WHERE age BETWEEN 10 AND 59
    GROUP BY 1,2
) AS t
GROUP BY 1
```
