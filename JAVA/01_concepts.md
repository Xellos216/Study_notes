# Summary: Programming Language History and Java Introduction

## 1. 컴퓨터와 언어의 관계
- 컴퓨터는 오직 0과 1만 이해한다.
- 사람은 추상적인 개념과 문장으로 사고하지만, 컴퓨터는 단순한 명령과 계산만 수행한다.
- 그래서 인간의 언어를 기계가 이해할 수 있도록 **중간 언어**가 필요하며, 이를 위한 첫 단계가 "기계어"이다.

## 2. 기계어 → 어셈블리어 → 고급언어
### (1) 기계어
- 예: `01010101 0000000000000101 00010001`
- 사람이 이해하기 어려움 → 기계가 직접 실행할 수 있음

### (2) 어셈블리어
- 기계어에 대응되는 약속된 기호들 (ex. `add`, `mov`, `push`)
- CPU마다 어셈블리어 문법이 다름 (호환 불가)
- 코드 가독성은 올라갔지만 여전히 사람이 작성하기엔 불편

### (3) 문제점
- 애드삭에서 유니박으로 옮기려면 어셈블리어까지 다시 배워야 했음
- 소프트웨어 이식성 부족 (번역 불가, 실행 불가)

## 3. 고급언어의 등장: C언어
- C언어는 하나의 소스코드로 여러 기종(CPU)에서 컴파일만 바꾸면 실행 가능
- 고급언어 → 각 운영체제에 맞는 C컴파일러로 번역
  - Windows → Windows용 컴파일러
  - Linux → Linux용 컴파일러
  - Mac → Mac용 컴파일러
- 장점: 한 번 작성한 코드를 다양한 OS에서 실행할 수 있음
- 단점: 각 OS의 특성 때문에 세부 수정을 요구할 수 있음 (예: `int`의 크기 등)

## 4. 객체지향 언어의 등장: Java
- Java는 **객체지향 언어**이다. 모든 것은 클래스 내부에 있어야 한다.
- Java의 핵심: 모든 실행은 클래스 내부에서 이루어짐
- C++는 클래스 없이도 개발 가능하지만, Java는 반드시 클래스 기반 구조여야 함

```java
public class Student {
    private String name;
    private int age;

    public void study() {
        System.out.println("공부");
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.study();
    }
}
```

## 5. Java의 장점
- Java는 단 **하나의 소스 파일**만 작성하면 **모든 OS에서 실행 가능**
- 이유: JVM(Java Virtual Machine)이 중간에서 기계어로 번역해줌
- 다음 학습 주제: **JVM의 원리와 구조**

## 6. Java 설치 (Ubuntu 기준 추가)
### ✅ Ubuntu에서 Java 설치
```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

### ✅ 설치 확인
```bash
java -version
javac -version
```

### ✅ 환경변수 설정 (선택적)
`/etc/environment` 또는 `~/.bashrc` 에 다음 추가:
```bash
JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"
PATH="$JAVA_HOME/bin:$PATH"
```
적용:
```bash
source ~/.bashrc
```

## 7. Java 환경설정 요약 (GitBook 기반 정리)
### 7.1 Java 버전 종류
- Java는 LTS(Long-Term Support)와 non-LTS로 나뉨
- 교육 환경에서는 **Java 17 LTS**를 사용

### 7.2 JDK vs JRE
- **JDK(Java Development Kit)**: 개발용, 컴파일러 포함, OpenJDK 권장
- **JRE(Java Runtime Environment)**: 실행 전용, JVM 포함

### 7.3 Oracle JDK 이슈
- Oracle JDK는 상용화됨 → **라이선스 회피 목적**으로 OpenJDK 또는 Zulu JDK 권장

## 8. IntelliJ 설치 및 설정
### 8.1 설치
- JetBrains의 Java 전용 IDE, Ultimate 버전 권장 (교육용 무료 제공)
- 한글판보다는 **영문판** 사용 권장

### 8.2 프로젝트 생성
1. `New Project` → `Empty Project` → 이름 입력 (예: `chap01`)
2. 프로젝트 생성 후 구조 확인

### 8.3 폰트 변경
- Preferences → Editor > Font
- **고정폭 글꼴(Monospaced)** 사용 권장
- 추천 글꼴: IBM Plex, D2Coding, Hack, DejaVu, Anonymous Pro

## 9. 첫 Java 코드 작성하기
### 9.1 Java 파일 생성
1. `chap01` 디렉토리에서 `New > Java Class` 클릭
2. 파일명은 대문자로 시작 (예: `Hello`)

### 9.2 main 함수 작성
```java
public class Hello {
    public static void main(String[] args) {
        // 실행 코드
    }
}
```
- 프로그램 진입점은 항상 `main()` 함수

### 9.3 "Hello, Sparta!" 출력 예제
```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Sparta!");
    }
}
```
- `System.out.println()`은 콘솔 출력용 함수
- **세미콜론(;) 생략 금지**, Python과 다르게 라인 종료 기호임
- IntelliJ에서는 `▶` 실행 버튼을 눌러 콘솔에 바로 출력 가능

### 9.4 IntelliJ 자동완성 기능
- `sout` 입력 시 자동으로 `System.out.println();` 코드 완성 가능
- 다양한 `soutm`, `soutp`, `soutv` 등의 출력 템플릿도 제공

## 10. 용어 정리
| 용어 | 설명 |
|------|------|
| 기계어 | 컴퓨터가 직접 이해하고 실행할 수 있는 0과 1의 명령어 |
| 어셈블리어 | 기계어를 사람이 읽을 수 있게 기호화한 저급 언어 |
| 고급언어 | 사람이 쓰기 편하도록 설계된 언어 (예: C, Java) |
| 컴파일러 | 고급언어를 기계어로 바꿔주는 프로그램 |
| JVM | Java 프로그램을 실행 가능한 기계어로 변환하는 가상 머신 |
| JDK | Java 개발 도구 키트 (컴파일러 포함) |
| JRE | Java 실행 도구 (JVM 포함, 개발용 아님) |

## 11. JVM과 Java 실행 구조

### 11.1 JDK, JRE, JVM 관계
- **JDK (Java Development Kit)**: Java 개발 도구 모음 (javac, java, javadoc 등 포함)
- **JRE (Java Runtime Environment)**: Java 실행 환경 (JVM + Class Library)
- **JVM (Java Virtual Machine)**: 자바 바이트코드를 실제 실행하는 가상 컴퓨터
- 관계 구조: `JDK ⊃ JRE ⊃ JVM`

### 11.2 Java의 호환성과 철학
- Java의 철학: **Write Once, Run Anywhere**
- 하나의 `.java` 파일 → `.class`로 컴파일 → 어떤 OS에서도 JVM만 있다면 실행 가능
- 반면 C언어는 OS별로 다른 목적 파일을 만들어야 함 (즉, Java는 OS 독립적임)

### 11.3 Java의 실행 과정
1. 개발자가 `.java` 소스 파일 작성
2. `javac` 컴파일러로 `.class` 바이트코드 생성
3. JVM의 Class Loader가 `.class` 로딩
4. Execution Engine이 해석 또는 JIT 컴파일하여 실행

### 11.4 Class Loader 구성
- 로딩(Loading): 클래스 로드
- 링크(Linking): Verify, Prepare, Resolve 수행
- 초기화(Initialization): static 초기화 코드 수행

### 11.5 Execution (실행 엔진)
- **Interpreter**: 바이트코드를 한 줄씩 해석 (느림)
- **JIT(Just-In-Time) Compiler**: 한 번에 컴파일 후 캐시 → 속도 향상
- **Garbage Collector**: 사용되지 않는 메모리 자동 해제

### 11.6 Compile 언어 vs Interpreter 언어
| 항목 | Compile 언어 | Interpreter 언어 |
|------|----------------|--------------------|
| 방식 | 전체 컴파일 후 실행 | 한 줄씩 번역하며 실행 |
| 실행 속도 | 빠름 | 느림 |
| 예시 | C, Java, C++ | Python, JS, Ruby |
| 목적 파일 | 존재함 (`.class`, `.exe`) | 없음 |
- Java는 `.class`를 생성하므로 Compile 언어지만, JVM에서 해석되므로 Interpreter 언어 특성도 가짐

### 11.7 JVM 구성 개요
- **Class Loader Subsystem**: 로딩, 링크, 초기화
- **Runtime Data Areas**:
  - Method Area
  - Heap
  - Stack
  - PC Register
  - Native Method Stack
- **Execution Engine**: Interpreter, JIT Compiler

### 11.8 Runtime Data Areas 상세
#### 1. Method Area (메서드/클래스 정보)
- 클래스의 구조 정보와 상수 풀(Runtime Constant Pool) 저장
- 모든 Thread에서 공유됨

#### 2. Heap Area (객체 저장소)
- 인스턴스가 생성되는 공간
- GC(Garbage Collector)가 메모리를 자동 관리
- Generation 구조: Eden, Survivor, Old, Permanent(Metaspace)

#### 3. Stack Area (메서드 호출 스택)
- 각 Thread마다 독립된 Stack 존재
- Stack Frame: 메서드 호출 시 할당되는 메모리 블록
- 지역변수, 매개변수 저장

#### 4. PC Register (명령어 주소 레지스터)
- 현재 Thread가 어떤 명령어를 실행 중인지 기록하는 레지스터

#### 5. Native Method Stack
- C, C++ 등 Java 외 언어로 작성된 네이티브 메서드용 스택
- Java의 JNI(Java Native Interface)를 통해 접근

---

## 12. 프로세스, 스레드, 리플렉션

### 12.1 프로세스 (Process)
- 실행 중인 프로그램을 의미
- 운영체제가 메모리 공간을 할당하여 관리
- 메모리, 자원, 스레드 등으로 구성됨

### 12.2 스레드 (Thread)
- 프로세스 내에서 실제 작업을 수행하는 실행 단위
- 하나의 프로세스 내에 여러 개의 스레드가 존재할 수 있음 → 멀티스레드 프로세스 (multi-threaded process)

### 12.3 리플렉션 (Reflection)
- 객체를 통해 클래스의 정보를 분석해내는 프로그래밍 방식
- 컴파일 타임에 알 수 없었던 클래스 정보를 런타임에 역으로 파악해 사용할 수 있음
- 예: 바이트코드를 기반으로 클래스 이름, 필드, 메소드 등을 런타임에 동적으로 접근 가능

---

