# Day 3: SQL JOIN 실습

## ✅ 실습 목표
- INNER / LEFT / RIGHT JOIN의 개념과 차이 이해
- 관계형 테이블에서 JOIN을 통한 데이터 연결 실습

---

## 🗂️ 실습 항목 요약

### 📌 테이블 생성 및 관계 설정

#### users 테이블
```sql
CREATE TABLE users (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    age INT DEFAULT 0
);
```

#### products 테이블
```sql
CREATE TABLE products (
    product_id INT PRIMARY KEY,
    name VARCHAR(100),
    price INT NOT NULL
);
```

#### orders_v2 테이블
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

### 📌 JOIN 실습

- `INNER JOIN`: 주문 내역이 존재하는 경우만 출력
- `LEFT JOIN`: 전체 회원 + 주문 여부 확인
- `RIGHT JOIN`: 전체 주문 기준 + 상품/회원 연결 확인

---

### 📌 실습 예시 쿼리

```sql
SELECT u.name, p.name, o.quantity
FROM orders_v2 o
INNER JOIN users u ON o.user_id = u.id
INNER JOIN products p ON o.product_id = p.product_id;
```

---

## 🔄 다음 목표: GROUP BY / HAVING / 집계 함수 실습 (Day 4 예정)
