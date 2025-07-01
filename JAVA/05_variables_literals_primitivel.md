# Java 변수 기초 - 상수, 기본형/참조형, 문자와 문자열

이 문서는 Java 변수 관련 기초 개념 중 다음 세 가지를 다룹니다:

1. 상수와 리터럴  
2. 기본형과 참조형  
3. 문자와 문자열

입문자의 시선에서 개념 요약 → 비교표/도식 → 코드 예시 → 실무 중요성 → 복습 퀴즈 순으로 정리했습니다.

---

## 1. 상수와 리터럴

### 📌 개념 요약

- **리터럴**: 코드에 직접 입력된 고정된 값.  
  예: `10`, `"Java"`, `'A'`, `true`, `3.14` 등

- **상수**: 한 번 저장하면 바꿀 수 없는 변수 → `final` 키워드 사용  
  예: `final double PI = 3.14;`

리터럴은 값 그 자체이고, 상수는 "이름이 붙은 고정값"입니다.

### 📊 비교표

| 항목       | 설명                          | 예시                   |
|------------|-------------------------------|------------------------|
| 리터럴     | 코드에 직접 쓴 고정된 값       | `5`, `"Java"`, `true` |
| 변수       | 값을 저장하는 공간             | `int x = 5;`          |
| 상수       | 변경할 수 없는 변수            | `final double PI = 3.14;` |

### 💻 예제 코드

```java
public class LiteralAndConstant {
    public static void main(String[] args) {
        int number = 10;
        final double PI = 3.1415;
        final String GREETING = "Hello, Java!";

        System.out.println("정수: " + number);
        System.out.println("원주율: " + PI);
        System.out.println(GREETING);
    }
}
```

### 🛠️ 실무 중요성

- 가독성 향상: `MAX_USERS` 같은 이름이 `100`보다 명확함
- 하드코딩 방지: 반복되는 값을 상수로 추출
- 상수는 대문자 + 언더스코어로 명명 (`FINAL_VALUE`)

### ✅ 복습 퀴즈

1. 다음 중 "리터럴"에 해당하는 것은? → `C. 3`  
2. 상수를 선언할 때 사용하는 키워드는? → `final`  
3. 상수 이름은 어떤 스타일로 작성하나요? → 영어 대문자 + 밑줄

---

## 2. 기본형과 참조형

### 📌 개념 요약

Java 변수는 크게 두 가지로 나뉩니다:

- **기본형**: 값 자체를 저장 → `int`, `double`, `char`, `boolean` 등  
- **참조형**: 객체의 주소를 저장 → `String`, 배열, 클래스 등

### 📊 비교표

| 항목       | 기본형                        | 참조형                         |
|------------|-------------------------------|--------------------------------|
| 저장 내용  | 실제 값                        | 객체의 주소                    |
| null 저장  | 불가                            | 가능                           |
| 예시       | `int`, `char`, `double` 등     | `String`, 배열, 클래스 등       |

### 💻 예제 코드

```java
public class PrimitiveVsReference {
    public static void main(String[] args) {
        int a = 10;
        int b = a;
        b = 20;

        String s1 = "Java";
        String s2 = s1;
        s2 = "Python";

        System.out.println("a: " + a);   // 10
        System.out.println("b: " + b);   // 20
        System.out.println("s1: " + s1); // Java
        System.out.println("s2: " + s2); // Python
    }
}
```

### 🛠️ 실무 중요성

- 기본형은 **값 복사**, 참조형은 **주소 복사**
- 참조형은 `null` 가능 → `NullPointerException` 주의
- 문자열 비교는 `==` 대신 `equals()` 사용

### ✅ 복습 퀴즈

1. 다음 중 참조형 타입은? → `C. String`  
2. 기본형 변수 간 대입은 어떤 방식인가요? → `값 복사`  
3. 참조형에서 null을 대입하면? → 참조 없음 → 예외 가능

---

## 3. 문자와 문자열

### 📌 개념 요약

- **`char`**: 문자 하나 저장 (기본형) → `'A'`, `'가'`  
- **`String`**: 문자열 저장 (참조형) → `"Hello"`, `"Java"`

### 📊 비교표

| 항목       | char                       | String                         |
|------------|----------------------------|--------------------------------|
| 자료형 종류 | 기본형                      | 참조형                         |
| 크기       | 2 byte (UTF-16)             | 문자열 길이에 따라 다름        |
| 비교 방식  | `==` 사용 가능              | `equals()` 사용해야 정확함     |

### 💻 예제 코드

```java
public class CharAndString {
    public static void main(String[] args) {
        char ch = 'A';
        String str1 = "Java";
        String str2 = new String("Java");

        System.out.println("char: " + ch);
        System.out.println("String1: " + str1);
        System.out.println("String2: " + str2);

        System.out.println("str1 == str2: " + (str1 == str2));         // false
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true
    }
}
```

### 🛠️ 실무 중요성

- `'A'` vs `"A"`: 문자와 문자열은 다름 → 문법 오류 주의
- 문자열 비교는 `equals()` 사용 필수
- 문자열은 불변 → 성능 고려 시 `StringBuilder` 활용

### ✅ 복습 퀴즈

1. `'A'`와 `"A"`의 차이 → 문자 vs 문자열  
2. 문자열 비교는 왜 `==` 대신 `equals()`를 써야 하나요? → 주소 비교 vs 값 비교  
3. 출력 결과 예측:
```java
String a = "hello";
String b = new String("hello");

System.out.println(a == b);        // false
System.out.println(a.equals(b));  // true
```

---

📌 이 문서는 Java 변수 기초 학습의 기반이 되는 내용을 다루며, 향후 연산자, 제어문, 객체지향 개념과 연결됩니다.