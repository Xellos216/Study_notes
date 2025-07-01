# SQL Week1 Summary (CLI 기반)

## 1. SQL이란?

- SQL은 **데이터베이스와 대화하기 위한 언어**입니다.
- 일상에서 “A를 주시겠어요?”라고 요청하듯, SQL은 DB에 데이터를 요청하거나 조작할 때 사용하는 ‘질문’ 또는 ‘명령’입니다.
- 데이터베이스에 데이터를 요청하는 행위를 "Query"라고 하며, SQL은 이러한 Query를 작성하는 데 사용됩니다.

---

## 2. MySQL 환경에서의 데이터베이스, 테이블, 컬럼 이해

### 데이터베이스란?
- 데이터를 저장하는 **큰 폴더** 개념입니다.
- MySQL에서는 `CREATE DATABASE`, `USE DB명` 등을 통해 DB를 생성하고 사용할 수 있습니다.

### 테이블이란?
- 데이터가 저장되는 **엑셀과 유사한 형태의 구조**입니다. 행(Row)과 열(Column)로 이루어져 있습니다.
- 테이블은 데이터의 **구조(schema)** 를 정의하고 있으며, 각 열(Column)은 **컬럼명과 데이터 타입**을 가집니다.

예시 (MySQL 기준):
```sql
CREATE TABLE customers (
    customer_id INT,
    name VARCHAR(50),
    email VARCHAR(100),
    gender VARCHAR(10),
    age INT
);
```

---

## 3. SELECT & FROM: 데이터 조회의 기본

### SELECT / FROM 문법
```sql
SELECT *
FROM 테이블명;
```

- `SELECT`: 어떤 데이터를 볼 것인지 지정
- `*`: 모든 컬럼 선택
- `FROM`: 어느 테이블에서 가져올지 지정

예시:
```sql
SELECT *
FROM food_orders;
```

---

## 4. 원하는 컬럼만 선택하기

전체 컬럼이 아닌 **일부만 선택**할 수 있습니다.

```sql
SELECT order_id, restaurant_name
FROM food_orders;
```

- `*` 대신 컬럼명을 직접 명시함으로써 **불필요한 정보 제거** 가능

---

## 5. 컬럼에 별칭(alias) 주기

컬럼명이 길거나 이해하기 어렵다면 **별칭**을 지정하여 보기 좋게 만들 수 있습니다.

### 별칭 지정 방법:
```sql
SELECT 컬럼명 AS 별칭
FROM 테이블명;
```
혹은
```sql
SELECT 컬럼명 "별칭"
FROM 테이블명;
```

예시:
```sql
SELECT order_id AS ord_no,
       restaurant_name AS "식당 이름"
FROM food_orders;
```

---

## 6. [실습] 컬럼 선택 & 별칭 지정

### 예제 1
```sql
SELECT order_id AS ord_no,
       price AS "가격",
       quantity AS "수량"
FROM food_orders;
```

### 예제 2
```sql
SELECT name AS "이름",
       email AS "e-mail"
FROM customers;
```

- 결과적으로, CLI 환경에서도 컬럼명에 한글 또는 영문 별칭을 사용해 **가독성을 향상**시킬 수 있습니다.


---

## 7. WHERE 조건절: 원하는 데이터만 필터링

```sql
SELECT *
FROM 테이블명
WHERE 조건;
```

예시:
```sql
SELECT *
 FROM customers
WHERE age = 21;
```

- 숫자는 그대로, 문자열은 작은 따옴표로 감싸야 함
```sql
SELECT *
FROM customers
WHERE gender = 'female';
```

---

## 8. 비교 연산자

조건에 따라 데이터를 비교해서 필터링할 수 있음

| 연산자 | 의미           | 예시                    |
|--------|----------------|-------------------------|
| =      | 같다           | age = 21                |
| <>     | 같지 않다      | gender <> 'female'      |
| >      | 크다           | age > 21                |
| >=     | 크거나 같다    | age >= 21               |
| <      | 작다           | age < 21                |
| <=     | 작거나 같다    | age <= 21               |

예시:
```sql
SELECT *
FROM customers
WHERE age < 21;
```

---

## 9. 다양한 조건 표현식: BETWEEN, IN, LIKE

### 🔹 BETWEEN: 특정 범위
```sql
SELECT *
FROM food_orders
WHERE price BETWEEN 20000 AND 30000;
```

### 🔹 IN: 여러 값 중 포함
```sql
SELECT *
FROM customers
WHERE age IN (15, 21, 31);
```

### 🔹 LIKE: 유사한 문자열 검색
- 시작하는 값: `'김%'`
- 포함하는 값: `'%Next%'`
- 끝나는 값: `'%일'`

```sql
SELECT *
FROM customers
WHERE name LIKE '김%';
```

---

## 10. 논리 연산자 (AND, OR, NOT)

조건을 조합하여 여러 조건을 동시에 체크할 수 있음

| 연산자 | 의미   | 예시 |
|--------|--------|------|
| AND    | 그리고 | age > 20 AND gender = 'female' |
| OR     | 또는   | age > 20 OR gender = 'female' |
| NOT    | 아니다 | NOT gender = 'female' |

예시:
```sql
SELECT *
FROM food_orders
WHERE cuisine_type = 'Korean' AND price >= 30000;
```

```sql
SELECT *
FROM payments
WHERE pay_type = 'card' OR vat <= 0.2;
```
