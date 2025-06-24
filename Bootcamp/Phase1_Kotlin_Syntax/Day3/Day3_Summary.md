````markdown
# Day 3: Kotlin 널 안정성 (Null Safety) 실습 요약

## ✅ 학습 개요

이번 실습에서는 Kotlin의 핵심 개념 중 하나인 **널 안정성(Null Safety)** 을 학습했다. Kotlin은 `NullPointerException`을 컴파일 타임에서 방지할 수 있도록 언어 차원에서 null 처리 문법을 제공한다. 다양한 연산자(`?`, `?:`, `!!`, `?.let`)를 통해 안전하게 nullable 데이터를 다루는 방법을 실습했다.

---

## 🔧 널 안정성이란?

널 안정성은 **null로 인한 런타임 오류를 방지하기 위한 Kotlin의 기능**이다. Java에서는 null 값을 가진 객체에 접근하면 `NullPointerException`이 발생하지만, Kotlin은 nullable 타입을 명시적으로 구분하여 이러한 문제를 원천 차단한다.

### 주요 키워드/연산자 정리:

| 문법            | 설명                                                           |
|----------------|----------------------------------------------------------------|
| `String?`      | null이 허용되는 문자열 타입                                      |
| `?.`           | null이 아닐 때만 안전하게 호출 (safe call)                       |
| `?:`           | null일 경우 기본값을 반환 (엘비스 연산자)                         |
| `!!`           | null이 아님을 보장하되, null이면 예외 발생 (절대 지양)             |
| `?.let {}`     | null이 아닐 경우에만 특정 블록 실행 (안전한 실행 블록)            |

---

## 🧱 1. 코드 실습 요약

```kotlin
var nickname: String? = "Ali"
println("nickname 길이: ${nickname?.length}") // 안전 호출

nickname = null
println("nickname 길이: ${nickname?.length}") // null 출력됨

val displayName = nickname ?: "손님"
println("환영합니다, $displayName 님!") // null이면 "손님"

val danger: String? = null
// println(danger!!.length) // NPE 발생! -> 주석 처리로 방지

val title: String? = "개발자"
title?.let {
    println("직함은 $it 입니다.") // null이 아닐 때만 실행
}
````

---

## 📌 새로 등장한 문법/개념 정리

| 문법 / 개념          | 설명                                |
| ---------------- | --------------------------------- |
| `nullable 타입`    | 타입 뒤에 `?`를 붙여 null 가능성을 명시함       |
| `safe call (?.)` | 객체가 null이 아닐 경우에만 속성/메서드 접근       |
| `Elvis (?:)`     | 좌측 값이 null이면 우측 기본값 반환            |
| `!!.length`      | null 아님을 강제 단정 (null이면 런타임 예외 발생) |
| `?.let {}`       | null이 아닌 경우에만 특정 로직을 실행할 때 사용     |

---

## 📚 정리

Kotlin의 널 안정성 문법은 null로 인한 런타임 오류를 줄이기 위한 강력한 장치이다.
nullable 변수는 `?`를 통해 타입에 명시적으로 표현되며, 이를 안전하게 다루기 위해 `?.`, `?:`, `let`, 그리고 지양해야 할 `!!` 연산자 등이 제공된다. 이번 실습을 통해 null을 둘러싼 다양한 상황을 예제 코드로 직접 확인하고 안전한 프로그래밍 습관을 익혔다.

다음 단계에서는 Kotlin의 **컬렉션(List, Set, Map)** 을 학습하고, null 안전성과 함께 사용할 수 있는 고차 함수들도 실습할 예정이다.

```

---

