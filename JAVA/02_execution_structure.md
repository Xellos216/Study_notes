# Java 실행 구조 핵심 개념 5가지 정리

이 문서는 Java 프로그램이 실행되는 구조를 이해하기 위한 5가지 핵심 개념을 입문자 관점에서 체계적으로 정리한 학습 노트입니다.

---

## 1. JDK / JRE / JVM 차이

### 📌 개념 요약

| 구성 요소 | 역할 | 포함 관계 |
|-----------|------|-----------|
| **JVM (Java Virtual Machine)** | 자바 바이트코드를 해석하고 실행하는 가상 머신 | JRE에 포함 |
| **JRE (Java Runtime Environment)** | JVM + 표준 라이브러리 (자바 실행 환경) | JDK에 포함 |
| **JDK (Java Development Kit)** | JRE + 컴파일러(`javac`) 등 개발 도구 | 최상위 개발 툴킷 |

즉, 개발자는 JDK가 필요하고, 실행만 하는 유저는 JRE로 충분합니다.

### 📊 도식

```
┌────────────────────────────┐
│           JDK              │
│  ┌──────────────────────┐  │
│  │         JRE          │  │
│  │  ┌───────────────┐   │  │
│  │  │     JVM       │   │  │
│  │  └───────────────┘   │  │
│  └──────────────────────┘  │
│ + javac, javadoc 등 개발 도구 │
└────────────────────────────┘
```

### 🛠️ 실무 중요성
- 배포 서버에는 JDK 대신 JRE만 설치해도 됨.
- Java 8로 컴파일된 `.class` 파일은 Java 11 JVM에서 실행 가능하지만, 반대는 안 됨.
- JDK 버전 관리 도구 (SDKMAN, asdf) 사용 빈번.

### 💻 코드 예시

```java
// Hello.java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, JVM!");
    }
}
```

```bash
javac Hello.java  # 컴파일
java Hello        # JVM으로 실행
```

### ✅ 복습 퀴즈 & 정답

1. JDK, JRE, JVM의 포함 관계는?  
   → **JDK > JRE > JVM**

2. 개발자가 필요한 구성 요소는?  
   → **JDK** (컴파일 도구 포함)

3. `javac`는 어떤 역할을 하나요?  
   → **Java 소스코드를 바이트코드로 컴파일**

---

## 2. Java 실행 구조 (컴파일 → 실행)

### 📌 개념 요약

Java는 컴파일과 인터프리터 방식이 결합된 언어입니다. 실행 구조는 다음과 같습니다:

```
1. Hello.java  (소스코드)
↓ javac
2. Hello.class (바이트코드)
↓ java
3. JVM 실행 → 콘솔 출력
```

### 📊 도식

```
┌────────────┐   javac   ┌─────────────┐   JVM   ┌────────────┐
│ Hello.java │ ───────▶ │ Hello.class │ ─────▶ │ 출력 결과 │
└────────────┘           └─────────────┘         └────────────┘
```

### 🛠️ 실무 중요성
- `.class` 파일만으로 실행 가능 → 배포 유리
- 인터프리터 방식이라 실행은 느릴 수 있으나, JIT로 보완
- 플랫폼 독립성: 어떤 OS든 JVM만 있으면 실행 가능

### 💻 예시 실행

```bash
javac Hello.java     # 컴파일
java Hello           # 실행
```

출력: `Hello, JVM!`

### ✅ 복습 퀴즈 & 정답

1. `.java`를 `.class`로 바꾸는 명령어는?  
   → **javac**

2. `.class`를 실행하는 주체는?  
   → **JVM**

3. Java가 플랫폼 독립적인 이유는?  
   → **JVM이 각 OS 위에서 바이트코드를 실행하므로**

---

## 3. JVM 메모리 구조

### 📌 개념 요약

JVM은 Java 프로그램 실행 중 다양한 데이터를 다음과 같은 영역에 나누어 저장합니다:

| 영역 | 내용 |
|------|------|
| Heap | 객체 인스턴스 저장 (new 사용 시) |
| Stack | 지역 변수, 메서드 호출 스택 |
| Method Area | 클래스 정보, static 변수 |
| PC Register | 현재 실행 중인 명령어 위치 |
| Native Stack | JNI 등 네이티브 호출 처리 |

### 📊 도식

```
┌────────────────────────────┐
│         JVM 메모리 구조         │
├────────────┬─────────────┤
│  Method Area       │ ← 클래스, static 정보
├────────────┴─────────────┤
│         Heap                  │ ← 객체 저장소
├────────────┬─────────────┤
│     Stack (Thread별)     │ ← 메서드 호출, 지역 변수
├────────────┴─────────────┤
│ PC Register / Native Stack │
└────────────────────────────┘
```

### 🛠️ 실무 중요성
- 메모리 오류 디버깅 (`OutOfMemoryError`, `StackOverflowError`)
- GC 동작 원리 이해에 기반
- 서버 JVM 메모리 설정 (`-Xmx`, `-Xms`) 필요

### 💻 코드 예시

```java
int a = 10; // Stack
String s = new String("hello"); // Heap
```

### ✅ 복습 퀴즈 & 정답

1. 지역 변수는 어느 영역에 저장되나요?  
   → **Stack**

2. 재귀 함수가 멈추지 않을 때 발생하는 오류는?  
   → **StackOverflowError**

3. JVM의 Heap 메모리 크기를 설정하는 옵션은?  
   → **-Xms (초기 크기), -Xmx (최대 크기)**

---

## 4. JIT 컴파일러 & GC

### 📌 개념 요약

- **JIT (Just-In-Time Compiler)**: JVM이 자주 실행되는 바이트코드를 실행 중에 네이티브 코드로 컴파일 → 성능 향상
- **GC (Garbage Collector)**: 참조되지 않는 객체를 자동으로 Heap에서 제거 → 메모리 누수 방지

### 📊 도식

```
.class → JVM → 인터프리트 실행
       → JIT 컴파일 → 네이티브 코드
       → GC가 Heap의 미사용 객체 제거
```

### 🛠️ 실무 중요성

| 기능 | 실무에서의 활용 |
|------|----------------|
| JIT | 서버가 오래 켜져 있을수록 성능이 좋아짐 |
| GC | 메모리 자동 관리 → 직접 free 할 필요 없음 |
| GC 튜닝 | `-XX:+UseG1GC`, `-XX:+PrintGCDetails` 등 활용 |

### 💻 코드 예시 (GC 유발)

```java
for (int i = 0; i < 10_000_000; i++) {
    String temp = new String("temp");
}
```

→ 수많은 객체가 생성되고 버려짐 → GC가 회수

### ✅ 복습 퀴즈 & 정답

1. JIT은 언제 동작하나요?  
   → **실행 중 (Just-In-Time)**

2. GC는 어떤 메모리 영역을 관리하나요?  
   → **Heap (객체 영역)**

3. Java에서 메모리 해제를 직접 하지 않아도 되는 이유는?  
   → **GC가 자동 회수**

---

## 5. Reflection

### 📌 개념 요약

**리플렉션**은 실행 중 클래스, 메서드, 필드 정보에 접근하고 객체를 조작할 수 있게 해주는 기능입니다.

```java
Class<?> c = Class.forName("MyClass");
Object obj = c.getDeclaredConstructor().newInstance();
Method m = c.getMethod("hello");
m.invoke(obj);
```

### 📊 도식

```
Class.forName("클래스명")
→ 생성자 접근 → 객체 생성
→ 메서드 접근 → 실행
→ 필드 접근 → 값 수정
```

### 🛠️ 실무 중요성

| 활용 분야 | 설명 |
|-----------|------|
| Spring Framework | 의존성 주입, 애노테이션 분석 |
| JPA / Hibernate | 엔티티 필드 분석 → SQL 자동 생성 |
| JUnit | 테스트 메서드 자동 실행 |
| Jackson / Gson | JSON ↔ 객체 매핑 시 필드 정보 사용 |

### ✅ 복습 퀴즈 & 정답

1. Reflection은 어떤 정보를 런타임에 조작할 수 있나요?  
   → **클래스, 메서드, 생성자, 필드**

2. Spring에서 Reflection이 사용되는 대표적인 예는?  
   → **빈 생성, 의존성 주입, 애노테이션 처리**

3. 남용 시 단점은?  
   → **성능 저하, 보안 이슈, 디버깅 어려움**

---