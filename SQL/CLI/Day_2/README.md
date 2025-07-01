# Day 2: SQL 제약조건 실습

## ✅ 실습 목표
- 제약조건(CONSTRAINTS)의 개념과 실제 작동 방식 이해
- SQL로 테이블 설계 및 데이터 무결성 보장 실습

---

## 🗂️ 실습 항목 요약

### 📌 테이블 생성

#### users 테이블
```sql
CREATE TABLE users (
    id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL DEFAULT '',
    age INT DEFAULT 0,
    CONSTRAINT unique_email UNIQUE (email),
    CONSTRAINT pk_users PRIMARY KEY (id)
);

#### orders 테이블
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    user_id INT,
    product VARCHAR(100),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
