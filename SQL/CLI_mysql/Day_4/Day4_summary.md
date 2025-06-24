# ✅ Day\_4 Summary: SQL Aggregation, GROUP BY, HAVING

이번 학습에서는 실무에서 자주 사용되는 **집계 함수**, **GROUP BY**, **HAVING** 절을 중심으로 실습을 진행하였다.

---

## 🔹 1. 회원별 총 주문 수량

```sql
SELECT
  u.name AS user_name,                      -- 회원 이름을 user_name으로 표시
  SUM(o.quantity) AS total_quantity        -- 주문 수량 합계를 total_quantity로 표시
FROM
  users u                                  -- users 테이블을 u로 별칭 지정
JOIN
  orders_v2 o ON u.id = o.user_id          -- 회원 ID 기준으로 조인
GROUP BY
  u.id;                                    -- 회원별로 그룹화하여 집계
```

---

## 🔹 2. 상품별 판매량 합계

```sql
SELECT
  p.name AS product_name,                  -- 상품 이름을 product_name으로 표시
  SUM(o.quantity) AS total_sold            -- 주문된 수량 총합을 total_sold로 표시
FROM
  products p                               -- products 테이블을 p로 별칭 지정
JOIN
  orders_v2 o ON p.product_id = o.product_id  -- 상품 ID 기준으로 조인
GROUP BY
  p.product_id;                            -- 상품별로 그룹화하여 집계
```

---

## 🔹 3. HAVING 절로 조건 필터링

```sql
SELECT
  p.name AS product_name,
  SUM(o.quantity) AS total_sold
FROM
  products p
JOIN
  orders_v2 o ON p.product_id = o.product_id
GROUP BY
  p.product_id
HAVING
  total_sold >= 2;                         -- 판매량이 2개 이상인 상품만 필터링
```

🔸 `HAVING`은 `GROUP BY` 이후 집계된 결과를 조건으로 걸 때 사용하며, `WHERE`은 집계 이전 조건 필터링에 사용된다.

---

## 🔹 4. 집계 함수 총정리

```sql
SELECT
  p.name AS product_name,
  COUNT(o.order_id) AS order_count,        -- 주문된 횟수
  SUM(o.quantity) AS total_quantity,       -- 총 주문 수량
  AVG(o.quantity) AS avg_quantity,         -- 평균 주문 수량
  MAX(o.quantity) AS max_quantity,         -- 최대 주문 수량
  MIN(o.quantity) AS min_quantity          -- 최소 주문 수량
FROM
  products p
JOIN
  orders_v2 o ON p.product_id = o.product_id
GROUP BY
  p.product_id;
```

---

## ✅ 개념 요약

* **GROUP BY**: 특정 컬럼을 기준으로 결과를 그룹화함
* **HAVING**: 그룹화된 집계 결과에 조건을 걸 때 사용
* **집계 함수**:

  * `COUNT()`: 갯수 세기
  * `SUM()`: 합계
  * `AVG()`: 평균
  * `MAX()`, `MIN()`: 최대값, 최소값

이후 실무 확장으로는 `GROUP BY + 날짜`, `JOIN + 다대일 관계`, `LIMIT`, `윈도우 함수` 등으로 이어질 수 있다.
