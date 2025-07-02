# Part 02. 연산자 - 증감, 형변환, 산술 연산자

## ✅ 증감 연산자 (`++`, `--`)

- `++` : 피연산자의 값을 1 증가시킴  
- `--` : 피연산자의 값을 1 감소시킴

| 타입   | 설명                              | 예시           |
|--------|-----------------------------------|----------------|
| 전위형 | 값이 **참조되기 전에** 증가/감소 | `k = ++j;`     |
| 후위형 | 값이 **참조된 후에** 증가/감소   | `k = j++;`     |

> 증감 연산자가 **단독으로 사용될 경우** 전위/후위 차이는 없음  
> 예: `++k;`, `k++;` → 결과 동일

```java
class Operator2_1 {
    public static void main(String[] args) {
        int k = 0, j = 3;

        // 후위형
        k = j++;
        System.out.println("k = j++;, k = " + k);
        System.out.println("k = j++;, j = " + j);

        // 값 초기화
        k = 0;
        j = 3;

        // 전위형
        k = ++j;
        System.out.println("k = ++j;, k = " + k);
        System.out.println("k = ++j;, j = " + j);
    }
}
```

---

## ➕ 부호 연산자 (`+`, `-`)

- `-` : 피연산자의 부호를 반대로 바꿈  
- `+` : 아무 일도 하지 않음 (거의 사용 안 함)

```java
class Operator2_2 {
    public static void main(String[] args) {
        int i = -10;
        i = +i;
        System.out.println("i = +i; = " + i);

        i = -10;
        i = -i;
        System.out.println("i = -i; = " + i);
    }
}
```

---

## 🔁 형변환 연산자 `(타입)`

- 변수나 리터럴의 **타입을 명시적으로 변환**할 때 사용

| 변환        | 수식         | 결과   |
|-------------|--------------|--------|
| int → char  | `(char)65`   | `'A'`  |
| char → int  | `(int)'A'`   | `65`   |
| float → int | `(int)1.6f`  | `1`    |
| int → float | `(float)10`  | `10.0f`|

```java
class Operator3_1 {
    public static void main(String[] args) {
        int i = 65, num = 10;
        char ch = 'A';
        float f = 1.6f;

        System.out.println("(char)i = " + (char)i);
        System.out.println("(int)ch = " + (int)ch);
        System.out.println("(int)f = " + (int)f);
        System.out.println("(float)num = " + (float)num);
    }
}
```

---

## 🧠 자동 형변환

> "기존 값을 최대한 보존할 수 있는 타입으로 자동 형변환됨"

- `float f = 1234;` → OK (int → float)
- `int i = 3.14f;` → Error (float → int: 손실 있음)
- `int i = (int)3.14f;` → 명시적 형변환 필요

```java
class Operator3_2 {
    public static void main(String[] args) {
        int i = (int)3.14f;
        System.out.println("i = " + i);

        byte b = 100;
        System.out.println("b = " + b);

        int num = 100;
        byte b2 = (byte) num;
        System.out.println("b2 = " + b2);

        byte b3 = (byte) 1000;
        System.out.println("b3 = " + b3);
    }
}
```

---

## ➕ 사칙 연산자와 산술변환

### ✴️ 덧셈, 뺄셈, 곱셈, 나눗셈

```java
class Operator4_1 {
    public static void main(String[] args) {
        int a = 10, b = 4;

        System.out.print("a + b = ");
        System.out.println(a + b);

        System.out.print("a - b = ");
        System.out.println(a - b);

        System.out.print("a * b = ");
        System.out.println(a * b);

        System.out.print("a / b = ");
        System.out.println(a / b); // 정수 나눗셈

        System.out.print("a / (float)b = ");
        System.out.println(a / (float)b); // 실수 나눗셈
    }
}
```

---

## 🔁 산술변환 (타입 통일 규칙)

연산 전 **피연산자의 타입을 일치**시키는 것

### 1. 타입 일치

- `long + int → long + long → long`  
- `float + int → float + float → float`  
- `double + float → double + double → double`

### 2. `int`보다 작은 타입 → 자동 `int` 변환

- `byte + short`, `char + short` → `int`

```java
class Operator4_2 {
    public static void main(String[] args) {
        char ch = '2';
        System.out.println(ch - '0');  // 문자 연산

        int a = 1_000_000;
        int b = 2_000_000;

        long l = (long) a * b;
        System.out.println("l = " + l);
    }
}
```