# Day 4: 실습 중 Q&A 정리

---

## ❓ main() 함수가 있는데도 실행이 안 돼요

**✅ A.** Kotlin 프로젝트에서는 `main()` 함수가 반드시 `src/main/kotlin` 경로 안에 있어야 실행 대상으로 인식된다.  
또한 Gradle 기반 프로젝트라면, 프로젝트 루트(`settings.gradle.kts`가 있는 곳)를 IntelliJ에서 열어야 Gradle이 모든 모듈을 인식할 수 있다.

---

## ❓ package collections인데 실행이 안 됐던 이유는?

**✅ A.** Kotlin은 `package` 선언과 실제 폴더 경로가 반드시 일치해야 한다.  
예: `package collections`라고 선언했다면 → 해당 파일은 반드시 `collections/` 폴더에 있어야 한다.

---

## ❓ .kt.kt 파일은 왜 실행이 안 되나요?

**✅ A.** 확장자가 `.kt.kt`이면 IntelliJ가 Kotlin 파일로 올바르게 인식하지 못할 수 있다.  
→ 반드시 `.kt` 하나로 끝나야 한다.

---

## ❓ mutableMapOf("KR", to "Korea")가 오류인 이유?

**✅ A.** `to`는 중위 연산자로 `"KR" to "Korea"`처럼 하나의 표현식으로 써야 한다.  
`"KR", to "Korea"`처럼 쓰면 문법 오류 발생.

---

## ❓ println 안에 있는 게 주석인 줄 알았는데 출력돼요

**✅ A.** `//` 로 시작하는 부분만 주석이고, `println(...)`은 실행문이다.  
→ `println(squared)`가 실행돼서 `[1, 4, 9]`가 출력된 것.

---

## ❓ filter로 "a"를 걸렀는데 왜 "kiwi"는 사라졌나요?

**✅ A.** `filter { it.startsWith("a") }`는 `"a"`로 시작하는 단어만 남긴다.  
`"kiwi"`는 `"k"`로 시작하므로 조건을 만족하지 않아 제거됨.

---

## ❓ count, any, all, find 각각 무슨 의미인가요?

| 함수 | 설명 |
|------|------|
| `count { 조건 }` | 조건을 만족하는 원소의 개수 |
| `any { 조건 }`   | 하나라도 만족하면 true |
| `all { 조건 }`   | 전부 만족해야 true |
| `find { 조건 }`  | 조건을 만족하는 첫 번째 원소 반환 (없으면 null) |

---

## ❓ val과 var의 차이는 뭔가요?

| 키워드 | 의미 | 값 변경 |
|--------|------|----------|
| `val` | value (불변) | ❌ 값 변경 불가 |
| `var` | variable (가변) | ✅ 값 변경 가능 |

Kotlin에서는 가능한 한 `val`을 쓰는 게 권장된다.

---

## ❓ scores, words, names 같은 이름들은 문법이에요?

**✅ A.** 아니요. 전부 사용자가 자유롭게 정한 변수 이름이다.  
문법적인 키워드는 `val`, `var`, `listOf`, `mapOf` 등이 해당된다.

---
