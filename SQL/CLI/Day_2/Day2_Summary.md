# Day 2: SQL 제약조건 실습 요약

## ✅ 학습 개요

이번 실습에서는 MySQL에서 데이터 무결성을 유지하기 위한 "제약조건(Constraints)"을 직접 작성하고 테스트했다. 테이블 생성 시 어떤 규칙을 줄 수 있으며, 어떤 상황에서 오류가 발생하는지를 실습을 통해 확인했다.

---

## 🔧 제약조건이란?

\*\*제약조건(CONSTRAINT)\*\*은 테이블에 입력되는 데이터의 정확성과 일관성을 보장하기 위해 사용하는 규칙이다.

### 주요 제약조건 정리:

| 제약조건          | 설명                                                           |
| ------------- | ------------------------------------------------------------ |
| `NOT NULL`    | 해당 컬럼에 절대로 NULL 값을 허용하지 않음 (비워둘 수 없음)                        |
| `DEFAULT`     | 값을 입력하지 않으면 자동으로 들어가는 기본값 설정                                 |
| `UNIQUE`      | 테이블 내에서 중복된 값을 허용하지 않음 (고유값)                                 |
| `PRIMARY KEY` | 한 테이블에서 각 행(row)을 유일하게 식별하는 키 (자동으로 NOT NULL + UNIQUE 속성 포함) |
| `FOREIGN KEY` | 다른 테이블의 PRIMARY KEY를 참조하여 테이블 간 관계를 설정함                      |

---

## 🧱 1. 테이블 생성 및 제약조건 설정

### users 테이블 구조

```sql
CREATE TABLE users (
    id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL DEFAULT '',
    age INT DEFAULT 0,
    CONSTRAINT unique_email UNIQUE (email),
    CONSTRAINT pk_users PRIMARY KEY (id)
);
```

* `id`: 각 사용자 고유 식별자, NULL 불가, PRIMARY KEY
* `name`: 사용자 이름, 필수 입력
* `email`: 이메일 주소, 고유해야 하며 비워둘 수 없음, 기본값은 빈 문자열
* `age`: 나이, 입력하지 않으면 0으로 설정됨

### orders 테이블 구조

```sql
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    user_id INT,
    product VARCHAR(100),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
```

* `order_id`: 주문 번호, 고유한 값 (PRIMARY KEY)
* `user_id`: 주문한 사용자 ID, `users(id)`를 참조 (FOREIGN KEY)
* `product`: 주문한 제품명

---

## 🧪 2. 제약조건 테스트

### ✅ UNIQUE 제약조건 테스트

```sql
-- 성공: 새로운 이메일
INSERT INTO users (id, name, email) VALUES (3, 'CHARLIE', 'charlie@example.com');

-- 실패: 같은 이메일로 중복 입력 시도
INSERT INTO users (id, name, email) VALUES (4, 'DAVID', 'charlie@example.com');
-- 결과: ERROR 1062 - Duplicate entry 'charlie@example.com' for key 'users.unique_email'
```

### ✅ FOREIGN KEY 제약조건 테스트

```sql
-- 성공: user_id = 2 는 실제 users 테이블에 존재
INSERT INTO orders (order_id, user_id, product)
VALUES (1001, 2, 'Mechanical Keyboard');

-- 실패: user_id = 999 는 존재하지 않음
INSERT INTO orders (order_id, user_id, product)
VALUES (1002, 999, 'Gaming Mouse');
-- 결과: ERROR 1452 - Cannot add or update a child row: a foreign key constraint fails
```

---

## 📌 새로 등장한 명령어/개념 정리

| 명령어 / 개념                     | 설명                          |
| ---------------------------- | --------------------------- |
| `CREATE TABLE`               | 새로운 테이블 생성                  |
| `ALTER TABLE`                | 기존 테이블의 구조를 수정 (제약조건 추가 등)  |
| `INSERT INTO ... VALUES ...` | 테이블에 새 데이터를 삽입              |
| `SHOW TABLES;`               | 현재 데이터베이스의 모든 테이블 목록 확인     |
| `DESC 테이블명;`                 | 테이블 구조(컬럼과 속성) 간단히 확인       |
| `SHOW CREATE TABLE 테이블명 \G;` | 전체 테이블 생성 SQL을 확인 (제약조건 포함) |

---

## 📚 정리

이번 실습을 통해 단순히 데이터를 저장하는 것을 넘어서, **데이터의 유효성을 자동으로 검증하는 구조**를 만들 수 있다는 점을 배웠다. 제약조건은 개발자가 서버 로직에서 실수하지 않아도 되게 하는 "안전망"의 역할을 한다. 실무에서는 이 구조를 기반으로 웹서버(Spring, Django 등)에서 사용자 입력을 받아 SQL로 저장하는 방식으로 연결된다.

다음 단계에서는 실무에서 자주 사용되는 JOIN, GROUP BY, TRANSACTION 등의 개념을 실습하며 데이터베이스 활용도를 높일 예정이다.
