# Part 02. 연산자 - Math 클래스, 비교/논리/비트 연산자

---

## 📐 Math 클래스

Java의 `Math` 클래스는 수학 계산에 필요한 메서드를 제공합니다.

| 메서드 | 설명 |
|--------|------|
| `round()` | 소수점 첫째 자리에서 반올림한 **정수값 반환** |
| `ceil()`  | 올림값 반환 (double) |
| `floor()` | 내림값 반환 (double) |
| `abs()`   | 절대값 반환 (int, double 모두 지원) |

```java
class Operator5_1 {
    public static void main(String[] args) {
        long result = Math.round(3.645678);
        System.out.println("result = " + result); // 4

        double pi = 3.141592;
        double shortPi = Math.round(pi * 1000) / 1000.0;
        System.out.println(shortPi); // 3.142

        double pi2 = 3.141592;
        System.out.println("(int)(pi2 * 1000) = " + (int)(pi2 * 1000));
        System.out.println("(int)(pi2 * 1000) / 1000.0 = " + (int)(pi2 * 1000) / 1000.0);
    }
}
```

---

## ➗ 나머지 연산자 `%`

- 나누고 남은 **나머지 값을 반환**
- 정수에서만 사용 가능 (`0으로 나눌 수 없음`)
- 부호는 무시됨

```java
class Operator5_3 {
    public static void main(String[] args) {
        int x = 10, y = 8;
        System.out.println(x / y);   // 몫
        System.out.println(x % y);   // 나머지

        int n = 3, z = -3;
        System.out.println("x % n = " + x % n);
        System.out.println("x % z = " + x % z);
    }
}
```

---

## 🧮 비교 연산자

| 연산자 | 설명 |
|--------|------|
| `==`   | 같음 |
| `!=`   | 다름 |
| `>`    | 왼쪽 > 오른쪽 |
| `>=`   | 왼쪽 ≥ 오른쪽 |
| `<`    | 왼쪽 < 오른쪽 |
| `<=`   | 왼쪽 ≤ 오른쪽 |

→ 두 값을 비교해서 `true` 또는 `false` 반환

---

## 🆚 문자열 비교

- 문자열 비교 시 `==` 대신 **`.equals()`** 사용해야 함!

```java
class Operator6_2 {
    public static void main(String[] args) {
        String s1 = "사랑";
        String s2 = "사랑";

        System.out.println(s1 == s2); // true
        System.out.println(s1.equals(s2)); // true

        String s3 = new String("사랑");
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s3)); // true
    }
}
```

---

## ✅ 논리 연산자 (`&&`, `||`, `!`)

| 연산자 | 의미 |
|--------|------|
| `&&`   | AND: 둘 다 true일 때 true |
| `||`   | OR: 둘 중 하나라도 true면 true |
| `!`    | NOT: true → false, false → true

```java
class Operator7_1 {
    public static void main(String[] args) {
        char ch1 = 'a', ch2 = 'B';

        boolean result1 = ch1 > 'A' && ch2 < 'C';
        boolean result2 = ch1 == 'A' && ch2 < 'C';
        boolean result3 = ch1 > 'A' || ch2 < 'C';
        boolean result4 = ch1 < 'A' || ch2 > 'C';

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);
        System.out.println("!result4 = " + !result4);

        int num = 10;
        boolean result5 = num % 2 == 0 && num % 3 == 0;
        boolean result6 = num % 2 == 0 || num % 3 == 0;
        System.out.println("2와 3의 공배수인가? " + result5);
        System.out.println("2 또는 3의 배수인가? " + result6);
    }
}
```

---

## 🧠 비트 연산자 (`&`, `|`, `^`, `~`, `<<`, `>>`, `>>>`)

| 연산자 | 설명 |
|--------|------|
| `&`    | AND (각 비트 모두 1 → 1) |
| `|`    | OR (하나라도 1 → 1) |
| `^`    | XOR (다르면 1) |
| `~`    | NOT (비트 반전) |
| `<<`   | 왼쪽 시프트 |
| `>>`   | 오른쪽 시프트 |
| `>>>`  | 부호 무시하고 오른쪽 시프트

```java
class Operator7_2 {
    public static void main(String[] args) {
        int num1 = 8, num2 = -8;

        System.out.println("num1 & num2 = " + (num1 & num2));
        System.out.println("num1 | num2 = " + (num1 | num2));
        System.out.println("num1 ^ num2 = " + (num1 ^ num2));
        System.out.println("~num1 = " + ~num1);
        System.out.println("num1 << 2 = " + (num1 << 2));
        System.out.println("num2 >> 2 = " + (num2 >> 2));
        System.out.println("num2 >>> 2 = " + (num2 >>> 2));
    }
}
```

---

## 🧾 2진수의 음수 표현

Java에서 음수는 **2의 보수** 방식으로 표현됨

- `1의 보수`: 모든 비트 반전 (1 ↔ 0)
- `2의 보수`: 1의 보수 + 1
- 예: `-13` = `11110011` (8비트 기준)
- `-9` = `11110111`

---

# Part 02. 연산자 - 조건 연산자 & 대입 연산자

---

## ✅ 조건 연산자 (삼항 연산자)

형식:  
```java
조건식 ? 반환값1 : 반환값2
```

- 조건식이 `true` → 반환값1  
- 조건식이 `false` → 반환값2

```java
class Operator8_1 {
    public static void main(String[] args) {
        int num1 = 5, num2 = 7;
        int result;

        result = num1 - num2 > 0 ? num1 : num2;
        System.out.println("두 정수 중 더 큰 수는 " + result + "입니다.");
        // 출력: 7
    }
}
```

---

## 📝 대입 연산자

| 연산자 | 설명 |
|--------|------|
| `=`    | 오른쪽 값을 왼쪽에 저장 |
| `+=`   | 왼쪽에 오른쪽 값을 더함 후 저장 |
| `-=`   | 왼쪽에서 오른쪽 값을 뺀 후 저장 |
| `*=`   | 곱한 후 저장 |
| `/=`   | 나눈 후 저장 |
| `%=`   | 나머지 연산 후 저장 |
| `&=`   | 비트 AND 후 저장 |
| `|=`   | 비트 OR 후 저장 |
| `^=`   | 비트 XOR 후 저장 |
| `<<=`  | 왼쪽 시프트 후 저장 |
| `>>=`  | 부호 유지하며 오른쪽 시프트 후 저장 |
| `>>>=` | 부호 무시하고 오른쪽 시프트 후 저장 |

---

## 💡 대입 연산자 예시

```java
class Operator8_2 {
    public static void main(String[] args) {
        int num1 = 7, num2 = 7, num3 = 7;

        num1 = num1 - 3;
        num2 -= 3;
        num3 =- 3;  // 실수 주의! num3 = -3

        System.out.println("- 연산자에 의한 결과 : " + num1); // 4
        System.out.println("-= 연산자에 의한 결과 : " + num2); // 4
        System.out.println("=- 연산자에 의한 결과 : " + num3); // -3
    }
}
```

> `=-` 는 `= (-)`의 의미이므로, 값이 음수로 대입되는 것에 주의해야 합니다.


