# Day 3: SQL JOIN 실습 Q&A 정리

## ❓ Q1. SELECT 문에서 u, o, p는 무엇을 의미하나요?

```sql
SELECT 
    u.name AS 회원명,
    p.name AS 상품명,
    o.quantity
FROM orders_v2 o
INNER JOIN users u ON o.user_id = u.id
INNER JOIN products p ON o.product_id = p.product_id;
```

### ✅ A.

`u`, `o`, `p`는 각각 테이블의 **별칭(alias)** 입니다:

- `o` → `orders_v2` 테이블
- `u` → `users` 테이블
- `p` → `products` 테이블

이 별칭을 통해 쿼리에서 각 테이블을 간결하게 참조할 수 있습니다.

---

## ❓ Q2. INNER / LEFT / RIGHT JOIN은 왜 그렇게 동작하나요?

### ✅ A.

각 JOIN은 **"누가 기준이냐"**에 따라 포함되는 행이 달라집니다. 단순히 외우는 게 아니라 구조적으로 정해진 동작 방식입니다.

---

### 🔹 INNER JOIN: 교집합만 출력

- **조건을 만족하는 데이터(양쪽 테이블에 모두 존재하는 값)** 만 결과에 포함
- 예: 주문이 있는 회원만 보고 싶을 때

---

### 🔹 LEFT JOIN: 왼쪽 기준 전체 + 오른쪽 매칭

```sql
FROM users u
LEFT JOIN orders_v2 o ON ...
```

- 모든 회원은 결과에 포함
- 주문이 없는 회원은 `NULL`로 표시됨
- 예: "주문 안 한 회원 포함 전체 목록"을 보고 싶을 때

---

### 🔹 RIGHT JOIN: 오른쪽 기준 전체 + 왼쪽 매칭

```sql
FROM products p
RIGHT JOIN orders_v2 o ON ...
```

- 모든 주문은 결과에 포함
- 주문된 상품 정보가 없으면 `NULL`
- 예: "전체 주문 기준으로 상품 매칭 여부" 확인

---

### 📌 핵심 요약

| JOIN 종류    | 기준 테이블   | 포함 범위              | 용도 예시                        |
|--------------|----------------|-------------------------|-----------------------------------|
| `INNER JOIN` | 공통 기준       | 양쪽 테이블 모두 일치   | 실제 주문 내역 추출              |
| `LEFT JOIN`  | 왼쪽 테이블     | 왼쪽 전부 + 오른쪽 일부 | 전체 회원 중 미주문자 확인       |
| `RIGHT JOIN` | 오른쪽 테이블   | 오른쪽 전부 + 왼쪽 일부 | 전체 주문 기준 상품/회원 분석    |
