# Bootcamp_Prestudy_3

> 목표: Kotlin & Spring 백엔드 부트캠프에서 사용하는 SQL과 데이터 모델링 사전 예습

---

## ✅ 기초

- MySQL 또는 PostgreSQL 설치  
- CLI에서 DB 접속 및 기초 명령 실행  
- 테이블 생성 및 기본 제약조건 실습  

---

## 📚 심화

- 여러 테이블 관계 설정 (복수 FOREIGN KEY)  
- JOIN 실습 (INNER, LEFT, RIGHT, FULL)  
- GROUP BY, HAVING, 집계 함수  
- 서브쿼리  
- INDEX와 성능  
- 트랜잭션과 롤백  

---

## 🧠 Spring 연동 준비

- JDBC, JPA에서 SQL이 어떻게 작동하는지 이해  
- Entity ↔ Table 매핑 연습  

---

## 📂 디렉터리 구조 예시

```
Bootcamp_Prestudy_3/
├── Day_1/
│   ├── day1_dump.sql
│   ├── Day1_Summary.md
│   ├── Day1_QA.md
│   └── README.md
├── Day_2/
│   ├── day2_dump.sql
│   ├── Day2_Summary.md
│   ├── Day2_QA.md
│   └── README.md
└── README.md
```

---

## ✍️ 작성 및 정리 원칙

- 각 Day별 폴더에는 다음 4가지 파일 포함:
  - SQL dump (`dayN_dump.sql`)
  - 학습 개념 요약 (`DayN_Summary.md`)
  - Q&A 기반 실무 연결 (`DayN_QA.md`)
  - 간략 개요 (`README.md`)

- 실습은 항상 CLI에서 직접 진행하며,  
  `tree`, `nano`, `mysqldump`, `git` 등을 병행 사용

---

## ✅ 정리 목적

이 저장소는 SQL을 단순히 암기하는 것이 아니라,  
**실제 백엔드 서비스에서 어떤 역할을 하는지 체감하며 학습하는 것**을 목표로 한다.  

데이터 무결성과 관계형 설계 개념을 충분히 실습한 뒤,  
Spring 환경에서 이 구조가 어떻게 활용되는지까지 연결될 예정이다.
