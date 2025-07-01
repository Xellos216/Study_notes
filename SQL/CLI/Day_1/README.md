# SQL Pre-Study - Day 1

## 📘 목적
Kotlin & Spring 백엔드 개발 부트캠프 예습 차원에서 MySQL을 활용한 관계형 DB 기초 개념과 실습 능력 향상을 목표로 합니다.

---

## 🧰 실습 환경
- 운영체제: Ubuntu 22.04
- DBMS: MySQL 8.x
- 실습 방식: CLI 기반 SQL 명령어 입력

---

## 📚 진행 내용 (Day 1)
- MySQL 사용자 계정 생성
- testdb 생성 및 users 테이블 구축
- 기본 CRUD 실습: INSERT, SELECT, UPDATE, DELETE
- SQL 명령어 및 데이터베이스 개념 Q&A

---

## 📦 포함 파일
- `sql_day1.md`: 실습 내용 정리
- `sql_day1_QA.md`: 학습 중 Q&A 정리
- `testdb_day1_dump.sql`: 실습 결과 DB 백업 (옵션)

---

## ▶️ 실행 방법
```bash
mysql -u h -p
USE testdb;
SELECT * FROM users;

---

## 다음 실습 (Day 2)
제약조건 (NOT NULL, UNIQUE, DEFAULT)
기본키 / 외래키
두 테이블 간 관계 설계
