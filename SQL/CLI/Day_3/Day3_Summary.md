# Day 3: SQL JOIN 실습 요약

## ✅ 학습 개요

이번 실습에서는 MySQL에서 관계형 데이터 간 연결을 위한 **JOIN**을 직접 작성하고, 그 동작 방식을 테스트했다. 특히 `INNER JOIN`, `LEFT JOIN`, `RIGHT JOIN`의 차이를 비교하면서 결과를 눈으로 확인했다.

---

## 🔧 JOIN 이란?

`JOIN`은 여러 테이블을 연결해 하나의 결과로 출력하는 SQL 문법이다.

---

## 🧱 실습한 테이블

### users 테이블
```sql
CREATE TABLE users (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    age INT DEFAULT 0
);
```

### products 테이블
```sql
CREATE TABLE products (
    product_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price INT NOT NULL
);
```

### orders_v2 테이블
```sql
CREATE TABLE orders_v2 (
    order_id INT PRIMARY KEY,
    user_id INT,
    product_id INT,
    quantity INT DEFAULT 1,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);
```

---

## 🧪 JOIN 실습

### ✅ INNER JOIN

```sql
SELECT u.name, p.name, o.quantity
FROM orders_v2 o
INNER JOIN users u ON o.user_id = u.id
INNER JOIN products p ON o.product_id = p.product_id;
```

→ 조건을 만족하는 행만 결과로 출력 (교집합)

---

### ✅ LEFT JOIN

```sql
SELECT u.name, p.name, o.quantity
FROM users u
LEFT JOIN orders_v2 o ON u.id = o.user_id
LEFT JOIN products p ON o.product_id = p.product_id;
```

→ 모든 회원을 포함하며, 주문이 없는 회원은 `NULL`

---

### ✅ RIGHT JOIN

```sql
SELECT p.name, u.name, o.quantity
FROM products p
RIGHT JOIN orders_v2 o ON p.product_id = o.product_id
RIGHT JOIN users u ON o.user_id = u.id;
```

→ 모든 주문을 기준으로 출력하며, 매칭 안 되는 항목은 `NULL`

---

### JOIN 시각화 요약 (기준: users, orders_v2, products)

1. INNER JOIN
┌───────────────┬───────────────┐
│     users     │   orders_v2   │
│  (회원 전체)  │ (주문 내역)   │
├───────────────┴───────────────┤
│ ❗ user_id가 일치하는 행만    │
│     → 주문이 있는 회원만     │
└──────────────────────────────┘

결과: 주문한 회원 + 주문한 상품만

예:
- 홍길동 (주문 O)
- BOB (주문 O)
- CHARLIE (주문 X → 결과에 없음)

---

2. LEFT JOIN
┌───────────────┬───────────────┐
│     users     │   orders_v2   │
│  (기준 테이블)│               │
├───────────────┴───────────────┤
│ ✅ 모든 회원은 무조건 포함     │
│    ❗ 주문이 없으면 NULL로 표시│
└──────────────────────────────┘

결과: 전체 회원 + 주문 여부 확인

예:
- 홍길동 ✅
- BOB ✅
- CHARLIE ❌ (NULL)

→ "누가 주문 안 했는지" 볼 때 유용

---

3. RIGHT JOIN
┌───────────────┬───────────────┐
│   products    │   orders_v2   │
│ (or users 등) │ (기준 테이블) │
├───────────────┴───────────────┤
│ ✅ 모든 주문은 무조건 포함     │
│    ❗ 연결 안 되면 NULL 표시   │
└──────────────────────────────┘

결과: 전체 주문 + 연결된 회원/상품 여부

예:
- 주문한 상품 ✅
- 주문에 매칭 안 된 회원/상품 ❌ (NULL)

→ "주문 데이터 중심 분석"에 유리


## 📚 핵심 요약

| JOIN 종류    | 기준 테이블   | 포함 범위              | 용도 예시                        |
|--------------|----------------|-------------------------|-----------------------------------|
| `INNER JOIN` | 공통 기준       | 양쪽 테이블 모두 일치   | 실제 주문 내역 추출              |
| `LEFT JOIN`  | 왼쪽 테이블     | 왼쪽 전부 + 오른쪽 일부 | 전체 회원 중 미주문자 확인       |
| `RIGHT JOIN` | 오른쪽 테이블   | 오른쪽 전부 + 왼쪽 일부 | 전체 주문 기준 상품/회원 분석    |
