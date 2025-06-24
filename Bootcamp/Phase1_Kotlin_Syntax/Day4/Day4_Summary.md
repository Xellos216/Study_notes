# Day 4: Kotlin 컬렉션 + 고차 함수 실습 요약

## ✅ 학습 개요

오늘은 Kotlin의 컬렉션(`List`, `Set`, `Map`)과 람다식 기반의 고차 함수(`forEach`, `map`, `filter`, `count`, `any`, `all`, `find`)를 중심으로 실습을 진행했다.  
각 컬렉션의 불변/가변 특성, 주요 메서드 사용법, 람다 표현식과 함께 사용하는 고차 함수의 동작 원리를 익히는 데 중점을 두었다.

---

## 🧱 1단계: 컬렉션 기본 문법 실습

### 🔸 List
- 순서가 있는 데이터 모음
- `listOf()` → 불변 리스트 (추가/수정 불가)
- `mutableListOf()` → 가변 리스트 (추가/수정 가능)

```kotlin
val fruits = listOf("Apple", "Banana", "Orange")          // 불변 List
val mutableFruits = mutableListOf("Apple", "Banana")      // 가변 List
mutableFruits.add("Grape")                                // 추가 가능
```

### 🔸 Set
- 중복을 허용하지 않는 데이터 모음
- 순서는 보장되지 않음

```kotlin
val numbers = setOf(1, 2, 3, 2)             // [1, 2, 3]
val mutableNumbers = mutableSetOf(1, 2)
mutableNumbers.add(3)                      // [1, 2, 3]
```

### 🔸 Map
- Key-Value 쌍으로 구성된 컬렉션
- `mapOf()` → 불변 Map
- `mutableMapOf()` → 가변 Map

```kotlin
val countryCodes = mapOf("KR" to "Korea", "US" to "USA")
val mutableMap = mutableMapOf("KR" to "Korea")
mutableMap["JP"] = "Japan"
```

---

## 🧩 2단계: 각 컬렉션 주요 메서드 실습

### 🔸 List 메서드
```kotlin
val colors = listOf("Red", "Green", "Blue")
colors[0]                  // 인덱스 접근 → Red
colors.contains("Green")  // 포함 여부 → true
colors.indexOf("Blue")    // 위치 찾기 → 2
```

### 🔸 Set 메서드
```kotlin
val items = setOf("A", "B", "C", "A")
items.size                // 중복 제거된 원소 수 → 3
"A" in items              // 포함 여부 → true
```

### 🔸 Map 메서드
```kotlin
val ages = mapOf("Tom" to 29, "Jane" to 31)
ages["Jane"]              // 값 접근 → 31
ages.containsKey("Tom")   // true
ages.keys                 // [Tom, Jane]
ages.values               // [29, 31]
```

---

## 🔁 3단계: 람다식 + 고차 함수 실습

### 🔹 람다식이란?
- 함수처럼 사용되는 **익명 함수 표현식**
- `{ 매개변수 -> 실행문 }` 형태
- `it` 키워드로 매개변수 생략 가능 (1개인 경우)

### 🔹 고차 함수란?
- 함수를 **인자로 받거나**, **함수를 반환하는 함수**
- Kotlin 컬렉션과 함께 자주 사용됨

```kotlin
val names = listOf("Eunji", "Minho", "Jisoo")
names.forEach { println("안녕하세요, $it 님!") }

val numbers = listOf(1, 2, 3)
val squared = numbers.map { it * it }            // [1, 4, 9]

val words = listOf("apple", "banana", "kiwi", "avocado")
val aWords = words.filter { it.startsWith("a") } // ["apple", "avocado"]

val scores = listOf(70, 85, 90, 45, 100)
scores.count { it >= 80 }      // 3
scores.any { it < 50 }         // true
scores.all { it >= 60 }        // false
scores.find { it == 100 }      // 100
```

---
