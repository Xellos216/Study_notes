# Day 2 학습 요약 (Kotlin 기초 문법 - 함수 및 클래스/객체 기초)

## 1. 환경 설정 및 프로젝트 관리 (CLI 중심)

* **Gradle 설치 및 문제 해결**:
    * `sudo apt install gradle` 시 구버전이 설치되어 JDK 17과 호환성 문제가 발생.
    * **SDKMAN! (`sdk install gradle`)** 을 통해 최신 버전의 Gradle을 설치하여 문제 해결. (실무에서 다양한 SDK 버전 관리에 유용)
* **`gradle init` 명령**: CLI에서 Kotlin 애플리케이션 프로젝트를 생성하는 방법 학습 및 실습.
    * Application 타입, Kotlin 언어, JDK 17, JUnit Jupiter 테스트 프레임워크 선택.
    * 실무에서도 자동화 스크립트 작성 시 `gradle init`과 같은 CLI 명령어가 중요함을 인지.
* **IntelliJ IDEA 실행 및 프로젝트 열기**:
    * `nohup idea . &` 명령을 통해 터미널 종료 후에도 IDEA가 백그라운드에서 실행되도록 학습.
    * 새로운 프로젝트 파일 생성 시 IDE의 인덱싱 과정 이해 (코드 자동 완성, 오류 감지 등 핵심 기능 지원).
    * 새로운 `.kt` 파일 생성 시 Git에 추가 여부 팝업 확인 (`Add` 선택).

## 2. 함수 (Functions)

Kotlin에서 함수를 정의하고 사용하는 다양한 방법 학습.

* **함수 선언 (`fun` 키워드)**:
    함수를 정의할 때 `fun` 키워드를 사용하며, 매개변수와 반환 타입을 명시합니다.
    ```kotlin
    fun functionName(param1: Type1, param2: Type2): ReturnType {
        // 함수의 본문
        return result
    }

    // 예시: 반환값과 매개변수 없는 함수
    fun sayHello() {
        println("안녕하세요!")
    }

    // 예시: 매개변수가 있고 반환값 있는 함수
    fun add(a: Int, b: Int): Int {
        return a + b
    }
    ```
* **함수 호출**: 정의된 함수를 이름과 인자를 통해 실행합니다.
    ```kotlin
    sayHello() // 함수 호출
    val result = add(10, 20) // 인자와 함께 함수 호출
    ```
* **`Unit` 반환 타입**: 함수가 아무 값도 반환하지 않을 때 사용하며, 보통 생략 가능합니다 (`Java의 void와 유사`).
    ```kotlin
    fun doSomething(): Unit { // Unit 명시
        println("작업 수행")
    }

    fun doAnotherThing() { // Unit 생략 (더 흔함)
        println("다른 작업 수행")
    }
    ```
* **단일 표현식 함수 (Single-Expression Functions)**: 함수 본문이 단일 표현식일 경우 중괄호 `{}`와 `return` 키워드 생략하고 등호 `=`를 사용하여 간결하게 표현합니다. 반환 타입도 컴파일러가 추론할 수 있으면 생략 가능합니다.
    ```kotlin
    fun multiply(x: Int, y: Int): Int = x * y // 명시적 반환 타입
    fun divide(x: Int, y: Int) = x / y // 반환 타입 추론 (Int)
    ```
* **기본값 매개변수 (Default Arguments)**: 함수의 매개변수에 기본값을 지정하여 호출 시 해당 매개변수에 값을 전달하지 않아도 기본값이 사용됩니다. 함수 오버로딩을 줄이는 효과가 있습니다.
    ```kotlin
    fun introduce(name: String, age: Int = 30, city: String = "Seoul") {
        println("이름: $name, 나이: $age, 도시: $city")
    }

    // 호출 예시:
    // introduce("김철수") // age=30, city="Seoul" 사용
    // introduce("이영희", 25) // city="Seoul" 사용
    // introduce("박민수", 28, "Busan") // 모든 값 명시
    ```
* **이름 붙은 인자 (Named Arguments)**: 함수 호출 시 매개변수의 이름을 직접 지정하여 인자를 전달할 수 있어 가독성을 높입니다. 특히 매개변수가 많거나 기본값 매개변수와 혼합될 때 유용합니다.
    ```kotlin
    introduce(city = "Jeju", name = "이지은", age = 22) // 순서와 상관없이 호출
    introduce(name = "정우성", city = "New York") // 특정 매개변수만 지정
    ```
* **함수 오버로딩 (Function Overloading)**: 동일한 이름을 가진 함수를 여러 개 정의할 수 있으나, 매개변수의 **개수나 타입이 달라야** 합니다.
    ```kotlin
    fun greet() { // 매개변수 없음
        println("안녕하세요, 손님!")
    }

    fun greet(name: String) { // String 타입 매개변수 1개
        println("안녕하세요, $name 님!")
    }

    fun greet(name: String, age: Int) { // String, Int 타입 매개변수 2개
        println("안녕하세요, $name 님 ($age 세)!")
    }
    ```
* **지역 함수 (Local Functions)**: 함수 안에 다른 함수를 정의하는 것으로, 외부 함수의 스코프 내에서만 호출 가능하고 외부 함수의 변수에 접근할 수 있습니다. 특정 함수 내에서만 필요한 보조 로직을 캡슐화할 때 유용합니다.
    ```kotlin
    fun calculateAndPrintSum(a: Int, b: Int) {
        fun sumAndMultiply(x: Int, y: Int, multiplier: Int): Int { // 지역 함수
            return (x + y) * multiplier
        }
        val result = sumAndMultiply(a, b, 2)
        println("$a 와 $b 의 합을 2배한 값: $result")
    }
    ```

## 3. 클래스와 객체 (Classes and Objects) 기초

객체 지향 프로그래밍의 기본 개념인 클래스와 객체 학습 시작.

* **클래스 (Class)**: 객체의 설계도. 속성(데이터)과 메소드(행동) 정의.
    ```kotlin
    class Car {
        var brand: String = "Unknown" // 속성
        fun start() { /* ... */ } // 메소드
    }
    ```
* **객체 (Object)**: 클래스의 실제 인스턴스. `val myCar = Car()`처럼 생성자 호출로 생성.
* **기본 생성자 (Primary Constructor)**: 클래스 헤더에 선언되어 객체 생성 시 초기 속성 설정.
    ```kotlin
    class Person(val name: String, var age: Int) { /* ... */ }
    ```
* **보조 생성자 (Secondary Constructor)**: `constructor` 키워드 사용. 여러 초기화 방식이나 추가 로직 필요 시 사용. `this()`를 통해 기본 생성자를 호출해야 함.
    ```kotlin
    class Student(val name: String, val entryYear: Int) { // 기본 생성자
        constructor(name: String, grade: String) : this(name, 2025) { /* ... */ } // 보조 생성자
    }
    ```
    * **`Conflicting overloads` 오류 해결**: 동일한 시그니처(매개변수 타입 조합)의 생성자 충돌 문제를 해결하기 위해 기본 생성자의 매개변수 타입을 변경하여 시그니처를 고유하게 만듦.
* **초기화 블록 (`init` 블록)**: 객체 초기화 시 기본 생성자나 보조 생성자 호출에 상관없이 공통으로 실행되는 코드 블록.
    ```kotlin
    class Student(...) {
        init {
            println("객체가 초기화되었습니다.")
        }
    }
    ```
