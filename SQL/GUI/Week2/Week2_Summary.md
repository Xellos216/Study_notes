
# ✅ SQL GUI 실습 Day 2 Summary (Week2)

## 📌 학습 목표
- SQL 기본 구조와 연산 함수 학습  
- 조건에 맞는 데이터 필터링 및 정렬  
- `GROUP BY`, `ORDER BY`로 실무형 데이터 통계 추출

---

## 1. SQL 문 기본 구조 복습
```sql
SELECT 컬럼명
FROM 테이블명
WHERE 조건
GROUP BY 컬럼명
ORDER BY 컬럼명;
```

- WHERE 조건 연산자: `=`, `<>`, `>`, `<`, `>=`, `<=`
- 다중 조건: `AND`, `OR`, `NOT`
- 다중 값 조건: `IN`, `BETWEEN`, `LIKE`

---

## 2. 집계 함수 (Aggregate Functions)

| 함수      | 설명     |
|-----------|----------|
| `SUM()`   | 합계     |
| `AVG()`   | 평균     |
| `COUNT()` | 개수     |
| `MIN()`   | 최소값   |
| `MAX()`   | 최대값   |

**예시**
```sql
SELECT
  SUM(price),
  AVG(delivery_time),
  COUNT(*)
FROM food_orders;
```

---

## 3. 실습 예제 정리

### ① 조건 필터링 (WHERE) + 집계
```sql
SELECT COUNT(order_id) AS count_of_orders
FROM food_orders
WHERE price >= 30000;
```

### ② 특정 조건 평균 구하기
```sql
SELECT AVG(price) AS average_price
FROM food_orders
WHERE cuisine_type = 'Korean';
```

### ③ 범주별 합계 구하기 (GROUP BY)
```sql
SELECT cuisine_type, SUM(price) AS sum_of_price
FROM food_orders
GROUP BY cuisine_type;
```

### ④ 음식점별 최대 주문금액 (GROUP BY + MAX)
```sql
SELECT restaurant_name, MAX(price) AS "최대 주문금액"
FROM food_orders
GROUP BY restaurant_name;
```

### ⑤ 음식점별 최대 주문금액 + 정렬
```sql
SELECT restaurant_name, MAX(price) AS "최대 주문금액"
FROM food_orders
GROUP BY restaurant_name
ORDER BY MAX(price) DESC;
```

### ⑥ 고객 이름 오름차순 정렬
```sql
SELECT * 
FROM customers
ORDER BY name;
```

---

## 4. 복합 구조 예시

```sql
SELECT cuisine_type,
       MIN(price) AS min_price,
       MAX(price) AS max_price
FROM food_orders
GROUP BY cuisine_type
ORDER BY MIN(price) DESC;
```

---

## 5. SQL 문 완성형 구조
```sql
SELECT ...
FROM ...
WHERE ...
GROUP BY ...
ORDER BY ...;
```
