# Java 기본형과 표현 방식 요약

## 1. 기본형(Primitive Type) 개요

- Java에서 데이터를 저장할 때 가장 기본이 되는 타입을 **기본형(primitive type)** 이라고 한다.
- 총 8종류가 있으며, 실제 값을 메모리에 직접 저장한다.
- **기본형 변수는 논리, 문자, 정수, 실수형**으로 구분된다:

| 타입 | 크기 | 표현 범위 | 기본값 |
|------|------|-----------------------------|--------|
| boolean | 1 byte | true / false | false |
| byte    | 1 byte | -128 ~ 127               | 0 |
| short   | 2 byte | -32,768 ~ 32,767         | 0 |
| int     | 4 byte | -2,147,483,648 ~ 2,147,483,647 | 0 |
| long    | 8 byte | ±9,223,372,036,854,775,807 | 0L |
| float   | 4 byte | ±3.4 × 10³⁸ (7자리 정밀도) | 0.0F |
| double  | 8 byte | ±1.7 × 10³⁰⁸ (15자리 정밀도) | 0.0 |
| char    | 2 byte | 0 ~ 65,535 (Unicode)      | '\u0000' |

---

## 2. 기본형의 분류와 크기

| 분류     | 1byte | 2byte | 4byte | 8byte |
|----------|-------|-------|-------|--------|
| 논리형   | boolean |       |       |        |
| 문자형   |         | char  |       |        |
| 정수형   | byte   | short | int   | long   |
| 실수형   |         |       | float | double |

- **논리형**: 조건식, 참/거짓 계산 (boolean)
- **문자형**: 한 글자 문자 저장 (char). 여러 글자는 String 사용
- **정수형**: 주로 `int`, `long` 사용. `byte`는 이진 데이터 다룰 때
  - 기본 타입은 `int`
- **실수형**: `float`, `double`
  - 기본 타입은 `double`

---

## 3. 표현 범위 계산

- n비트로 표현 가능한 값 개수: `2ⁿ`
- 부호 없는 정수 범위: `0 ~ 2ⁿ - 1`
- 부호 있는 정수 범위: `-2ⁿ⁻¹ ~ 2ⁿ⁻¹ - 1`

예시:
- 8bit → `2⁸ = 256`개
- 부호 있는 8bit: `-128 ~ 127`
- 부호 없는 8bit: `0 ~ 255`

---

## 4. 실수형의 정밀도

| 타입   | 표현 범위           | 정밀도 | 크기 |
|--------|--------------------|--------|------|
| float  | ±1.4E-45 ~ ±3.4E38  | 7자리  | 32bit (4byte) |
| double | ±4.9E-324 ~ ±1.8E308| 15자리 | 64bit (8byte) |

- 실수형은 정수처럼 정확히 저장되지 않음 → **정밀도 개념 등장**
- 부동소수점 IEEE 754 형식 사용:
  - float: S(1) + E(8) + M(23)
  - double: S(1) + E(11) + M(52)
- 표현 방식: `±M × 2^E`

---

## 5. 메모리에 값 저장 방식

- 모든 값은 **2진수**로 변환되어 저장된다.
- 예: `byte b = 3;` → 메모리에 `00000011`(2진수)로 저장됨
- 타입마다 **저장되는 형식(비트 수)** 이 정해져 있어, 그에 따라 표현 범위도 달라진다.

---

## 6. 문자의 저장 구조

- 문자는 아스키코드 또는 유니코드를 이용해 숫자로 매핑되어 저장된다.

### 아스키 코드
- 7비트로 128개 문자 표현
- 알파벳, 숫자, 특수기호 등 포함

### 유니코드
- 각국 언어를 모두 표현할 수 있도록 만든 국제 표준
- 16bit로 최대 65,536자 표현 가능
- Java의 `char`는 유니코드 기반 (부호 없음)

### 예: 문자 저장 방식
```java
char c = 'A'; // 아스키 코드로 65에 해당
```
- 메모리에는 `00000000 01000001` (2byte)로 저장됨

---

## 7. 정수형 오버플로우

- 정수형 타입은 최소값~최댓값 범위를 넘어서면 **값이 순환**됨

```java
short sMin = -32768;
short sMax = 32767;

System.out.println((short)(sMax + 1)); // -32768
System.out.println((short)(sMin - 1)); // 32767
```

- char(부호 없음)도 최대값 넘으면 순환

---

## 8. 문자 ↔ 숫자 변환

- 숫자 → 문자: `숫자 + '0'` → 문자
- 문자 → 숫자: `'문자' - '0'` → 숫자

```java
int num = 5;
char ch = '5';

System.out.println((char)(num + '0')); // '5'
System.out.println(ch - '0');          // 5
System.out.println(ch - '0' + 1);      // 6
```

---

## 9. 숫자 ↔ 문자열 변환

- 숫자 → 문자열: `숫자 + ""`
- 문자 → 문자열: `문자 + ""`

```java
int num = 5;
char ch = '5';

System.out.println(num + "");  // "5"
System.out.println(ch + "");   // "5"
System.out.println(ch + "" + "8"); // "58"
```

---

## 10. 문자열 ↔ 숫자 변환

- 문자열 → 숫자:
  - `Integer.parseInt("100")`
  - `Double.parseDouble("3.14")`
- 문자열 → 문자:
  - `"abc".charAt(0)` → 'a'

```java
String str1 = "100";
String str2 = "3.14";

System.out.println(Integer.parseInt(str1)); // 100
System.out.println(Double.parseDouble(str2)); // 3.14

System.out.println(str1.charAt(0)); // '1'
```

---

## 11. 참조형 (Reference Type)

- 기본형을 제외한 나머지 타입
  - 예: `String`, `Date`, `Scanner`, 사용자 정의 클래스 등
- 변수는 실제 값이 아닌 **객체의 메모리 주소**를 저장
- null: 어떤 객체의 주소도 없다는 뜻
- 기본적으로 **4byte** 공간을 사용 (JVM 64bit 환경에서는 8byte)

```java
Date date = new Date();  // 참조형 변수 선언 및 객체 생성
System.out.println(date); // Wed Jan 11 20:54:45 KST 2023
```

---

> 📘 이 확장 문단은 문자열 처리 및 참조형에 대한 시각 자료를 기반으로 작성되었습니다.


## 12. 문자 vs 문자열

- `char`는 문자 1개만 저장 가능, `String`은 문자열(0개 이상 문자) 저장 가능
- 빈 문자는 `char ch = '';` 불가능하지만, 빈 문자열은 `String s = "";`로 가능
- 문자열 생성 방식:
  - `"문자열"`: 문자열 풀(Pool)에 저장
  - `new String("문자열")`: 힙 메모리에 별도 저장 (추천 방식 아님)

```java
char ch1 = 'A';
String s1 = "ABC";
String s2 = ""; // 빈 문자열
String s3 = "A"; // 문자 하나인 문자열

String ss1 = "AB";
String ss2 = new String("AB");

System.out.println("ss1 = " + ss1);
System.out.println("ss2 = " + ss2);
```

---

## 13. 문자열 결합과 연산 순서

- `+` 연산은 문자열이 포함되면 모두 문자열 결합으로 처리
- 순서에 따라 숫자 연산 결과가 달라질 수 있음

```java
String s1 = "A" + "B"; // "AB"

String s2 = "" + 7; // "7"
String s3 = "" + 7 + 7; // "77" (문자열 결합)
String s4 = 7 + 7 + ""; // "14" (덧셈 후 문자열)
```

---

## 14. 두 변수의 값 교환

- Java는 기본적으로 **값에 의한 전달(Call by Value)** 만 가능
- 두 변수의 값을 교환하려면 중간 변수(`tmp`)가 필요함

```java
int a = 10, b = 20;
int tmp;

tmp = a;  // tmp = 10
a = b;    // a = 20
b = tmp;  // b = 10

System.out.println("a = " + a); // 20
System.out.println("b = " + b); // 10
```

> 📘 참고: 객체 참조형(배열 등)에서는 참조 주소가 복사되기 때문에 동작 방식이 다름
