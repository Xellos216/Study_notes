# SQL Day 1 - 기본 CRUD 실습 (Ubuntu + MySQL)

## 🗓️ 학습 목표
- MySQL 설치 및 사용자 계정 생성
- 데이터베이스 및 테이블 생성
- INSERT / SELECT / UPDATE / DELETE 기초 실습

---

## ✅ 실습 내용

### 1. 사용자 생성 및 접속
```sql
CREATE USER 'h'@'localhost' IDENTIFIED BY 'h';
GRANT ALL PRIVILEGES ON *.* TO 'h'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;

mysql -u h -p

CREATE DATABASE testdb;
USE testdb;

2. 데이터베이스 및 테이블 생성
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50),
  email VARCHAR(100),
  age INT
);

3. 데이터 삽입
INSERT INTO users (name, email, age) VALUES
('홍길동', 'hong@example.com', 30),
('김철수', 'kim@example.com', 25),
('이영희', 'lee@example.com', 28);

4. 데이터 조회
SELECT * FROM users;
SELECT name, age FROM users WHERE age > 26;

5. 데이터 수정 및 삭제
UPDATE users SET age = 31 WHERE name = '홍길동';
DELETE FROM users WHERE name = '김철수';

6. 최종 상태 확인
SELECT * FROM users;

