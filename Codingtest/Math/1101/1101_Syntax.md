# 1101_Syntax.md

## ✅ 1. `input()` – 입력 받기

- 사용자 또는 테스트 케이스 입력을 한 줄씩 받음
- 문자열로 입력되기 때문에 `int()`로 감싸 숫자로 변환 필요

```python
T = int(input())
x, y = map(int, input().split())
```

---

## ✅ 2. `map()` – 일괄 처리

- 여러 값을 한꺼번에 정수형으로 변환할 때 사용

```python
x, y = map(int, input().split())
```

---

## ✅ 3. `math.sqrt()` – 제곱근 함수

- `math` 모듈에서 제공
- 소수점이 나올 수 있으므로 `int()`로 감싸 정수부만 사용

```python
import math
n = int(math.sqrt(d))
```

---

## ✅ 4. `if-elif-else` – 조건 분기

- `d` 값의 범위에 따라 실행 분기

```python
if d == n ** 2:
    ...
elif d <= n * (n + 1):
    ...
else:
    ...
```

---

## ✅ 5. `for _ in range(T)` – 반복문

- 테스트케이스 T번 반복하며 각각의 x, y 입력 처리

```python
for _ in range(T):
    ...
```

---

## 🧠 요약표

| 문법              | 설명                                | 예시                           |
|------------------|-------------------------------------|--------------------------------|
| `input()`        | 사용자 입력                          | `T = int(input())`             |
| `map()`          | 다수 입력을 정수로 변환               | `map(int, input().split())`    |
| `math.sqrt()`    | 제곱근 계산 (정수형으로 변환)         | `int(math.sqrt(d))`            |
| `if-elif-else`   | 조건 분기                            | `if d == n**2:`                |
| `for in range()` | T번 반복 처리                        | `for _ in range(T):`           |