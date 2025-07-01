# Java 변수와 리터럴

## 1. 변수란?

- 변수는 단 하나의 값을 저장할 수 있는 **메모리 공간**을 의미한다.
- 변수 공간은 **메모리 주소**에 의해 구분되며, 사람이 사용하기 쉽게 하기 위해 해당 주소에 **이름(변수명)** 을 부여해 사용한다.
- 변수에 값을 저장하거나 읽을 때는 메모리 주소 대신 **변수명**을 사용한다.
- 메모리 공간은 기본적으로 1byte 단위로 구성되며, 주소가 붙는다.

## 2. 변수의 선언 및 타입

- 변수를 사용하기 위해서는 메모리 공간을 확보해야 하며, 이를 위해 **변수 선언**이 필요하다.
- 선언 형식: `자료형 변수명;` 또는 `자료형 변수1, 변수2;`
- 기본 자료형별 메모리 크기:
  - `byte`: 1 byte = 8 bits
  - `short`: 2 bytes = 16 bits
  - `int`: 4 bytes = 32 bits
  - `long`: 8 bytes = 64 bits

### 예제
```java
class Variable1_1 {
    boolean flag;
    char grade;
    byte val;
    short sval;
    int num;
    long price;
    float tax;
    double score;
}
```

## 3. 변수 이름 규칙

- 길이에 제한 없음
- 예약어 사용 불가 (예: `true`, `class`)
- 숫자로 시작 불가
- 특수문자 `_`, `$`만 허용

## 4. 변수 이름 표기법

- Camel Case: `varTest`
- Snake Case: `var_test`
- Pascal Case: `VarTest` (클래스명에 주로 사용)
- Kebab Case: 사용 불가 (`var-test`)

## 5. 변수 초기화

- 변수에 값을 저장하는 과정
- 형식: `자료형 변수명 = 값;` 또는 `자료형 변수명1 = 값1, 변수명2 = 값2;`

### 예제
```java
class Variable1_2 {
    public static void main(String[] args) {
        boolean flag = false;
        char grade = 'A';
        byte val = 127;
        short sval = 128;
        int num = 32768;
        long price = 2_147_483_648L;
        float tax = 3.14f;
        double score = 3.14159265358979;
    }
}
```

## 6. 변수 값 읽기

- 저장된 값을 활용하는 과정

```java
int age = 23;
int year = age + 2000;
System.out.println(year); // 2023

age = age + 1;
System.out.println(age); // 24
```

## 7. 변수의 종류

- **클래스 변수** (`static`)
- **인스턴스 변수**
- **지역 변수** (메서드 내부 선언)

```java
class Variable1_4 {
    static int classVal = 100;
    int instanceVal = 200;

    public static void main(String[] args) {
        int num = 300;
        System.out.println("int = " + num);

        Variable1_4 obj = new Variable1_4();
        System.out.println("instanceVal = " + obj.instanceVal);

        System.out.println("classVal = " + classVal);
        System.out.println("Main.classVal = " + Variable1_4.classVal);
    }
}
```

## 8. 상수와 리터럴

### 상수
- 한 번만 값 저장 가능
- 선언: `final 자료형 변수명 = 값;`

```java
final int finalScore = 100;
```

### 리터럴
- 코드 내에 직접 표기된 고정 값 (예: `100`, `true`, `'A'`, `"Hello"`)

## 9. 리터럴의 접두사와 접미사

- 접두사:
  - `0b` (2진수), `0` (8진수), `0x` (16진수)
- 접미사:
  - `L` (long), `F` (float), `D` (double)

### 예제
```java
int ob = 0b0101;
int oct = 0100;
int hex = 0x100;

long price = 2_147_483_648L;
float tax = 3.14f;
double score = 3.14159265358979d;
```

## 10. 변수와 리터럴의 타입 불일치

- 변수의 타입이 리터럴보다 작으면 **에러 발생**
- 예외: byte/short 변수에 int 리터럴 저장은 OK (단, 범위 내일 때)

```java
int i = 'A';          // OK ('A' → 65)
float f = 3.14f;      // OK
float f2 = 3.14;      // Error (double → float)
```

---

> 📘 참고: 이 문서는 이미지 기반 자료를 재구성한 요약 정리본입니다.
