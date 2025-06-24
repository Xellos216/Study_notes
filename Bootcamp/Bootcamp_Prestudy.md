---

# 📚 Kotlin & Spring 부트캠프 예습 가이드

이 가이드는 Kotlin & Spring 백엔드 개발 입문자를 위한 학습 로드맵입니다. 기존에 학습했던 CLI, Git, Docker 등의 지식을 활용하여 효과적인 학습을 돕습니다.

---

## 🎯 학습 목표

Kotlin 언어의 기본 문법을 익히고, Spring 프레임워크를 활용하여 간단한 웹 애플리케이션 및 REST API 개발의 기초를 다집니다.

---

## 💡 학습 계획 (단계별)

### **Phase 1: Kotlin 기초 문법 (3~5일)**

* **주요 학습 내용:** 변수, 조건문, 반복문, 함수, 클래스/객체, **널 안정성**, 컬렉션, 고차 함수.
* **중요성:** Spring 개발의 기본 언어이므로, Kotlin 문법에 대한 탄탄한 이해가 필수입니다.
* **실습:** 콘솔 기반 **TODO 리스트** 또는 **간단한 계산기** 앱을 만들어보세요.

---

### **Phase 2: Spring Core & IoC/DI (3~4일)**

* **주요 학습 내용:** Spring Framework 개요, **IoC/DI 개념**, Bean, `@Component`, `@Autowired`, `@Configuration`, `@Bean`, **Spring Boot 소개**.
* **중요성:** Spring의 근간이 되는 원리이며, 모든 Spring 애플리케이션 개발에 적용됩니다.
* **실습:** `MessageService` 예제처럼 간단한 **DI(의존성 주입) 예제**를 직접 구현해보고, `@Component`와 `@Bean`을 활용하여 Spring 컨테이너에 객체를 등록하는 연습을 합니다.

---

### **Phase 3: Spring Web (MVC) 및 REST API (4~6일)**

* **주요 학습 내용:** Spring Web MVC, **RESTful API**, `@Controller`, `@RestController`, 요청/응답 처리 (`@RequestParam`, `@RequestBody` 등).
* **중요성:** 웹 서비스 개발의 핵심이며, 백엔드 개발의 주된 결과물입니다.
* **실습:** **간단한 게시판 REST API**를 만들어보고, Postman/cURL로 API를 테스트하며 작동을 확인합니다.

---

### **Phase 4: 데이터베이스 연동 기초 (JPA / Spring Data JPA) (4~5일)**

* **주요 학습 내용:** 관계형 DB 개념, JDBC 개요, **JPA & Spring Data JPA**, 엔티티, `JpaRepository`, H2 Database.
* **중요성:** 대부분의 백엔드 앱이 데이터를 다루며, Spring 생태계에서 가장 효율적인 DB 연동 방식입니다.
* **실습:** Phase 3의 게시판 API에 **H2 데이터베이스와 Spring Data JPA**를 연동하여 실제 데이터를 CRUD(생성, 조회, 수정, 삭제) 해봅니다.

---

## 🛠️ 개발 환경 설정

1.  **JDK (Java Development Kit) 설치:** **Java 17 이상** 버전 (OpenAdoptium Temurin 권장).
2.  **IntelliJ IDEA 설치:** (Ultimate Edition 권장, 학생 라이선스 활용) - Kotlin 및 Spring 개발에 최적화된 IDE.
3.  **Postman 또는 Insomnia:** 개발한 REST API 테스트를 위한 도구.

---

## 🚀 학습 전략 및 팁

* **Hands-on 코딩:** 직접 코드를 작성하고 실행하며 오류를 해결하는 것이 가장 중요합니다.
* **작은 단위로 시작:** 개념 하나씩, 기능 하나씩 구현하며 차근차근 나아갑니다.
* **디버깅 활용:** IntelliJ IDEA의 디버깅 기능으로 코드 흐름을 파악하고 문제를 해결합니다.
* **Git/GitHub 활용:** 각 단계별로 커밋하고 푸시하여 버전 관리를 꾸준히 하며, 포트폴리오를 만들어 갑니다.
* **Docker 활용:** 최종적으로 만든 Spring Boot 앱을 Docker 이미지로 빌드하고 실행해보는 연습도 좋습니다.

---

