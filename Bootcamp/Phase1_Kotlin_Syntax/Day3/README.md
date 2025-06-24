
````markdown
# Day 3: Kotlin 널 안정성 실습

## ✅ 실습 목표
- Kotlin의 핵심 개념인 **널 안정성(Null Safety)** 의 작동 원리 이해
- nullable 타입 선언, 안전한 호출, 기본값 처리, 예외 발생 흐름 등을 실습
- null 가능성을 코드 수준에서 명확히 표현하고 방어적으로 처리하는 방법 학습

---

## 🗂️ 실습 항목 요약

### 📌 주요 문법 실습

#### 1. nullable 타입 선언 (`String?`)
```kotlin
var nickname: String? = "Ali"
nickname = null
````

#### 2. 안전한 접근 (`?.`, `?:`)

```kotlin
val length = nickname?.length
val displayName = nickname ?: "손님"
```

#### 3. let 블록 사용

```kotlin
nickname?.let {
    println("환영합니다, $it 님!")
}
```

#### 4. 강제 호출 `!!` (예외 유발)

```kotlin
val danger: String? = null
// println(danger!!.length) // NullPointerException 발생 가능
```

---

## 📚 관련 파일

* `NullSafety.kt`: 널 안정성 관련 실습 코드
* `Day3_Summary.md`: 학습 개념 요약 및 코드 예시 설명
* `Day3_QA.md`: 관련 문법에 대한 개념 정리 및 질문/답변 모음

```


