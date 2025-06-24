## 1. **HTML (HyperText Markup Language)**

### 개념:

* **웹페이지의 뼈대를 구성하는 마크업 언어**
* 텍스트, 이미지, 링크, 버튼 등을 **구조화**하는 데 사용

### 특징:

* **마크업 언어**: 논리적 구조를 표현 (예: 제목, 문단, 표 등)
* `.html` 확장자를 가진 파일로 작성
* **브라우저가 해석**해서 사용자에게 보이는 웹페이지가 됨

### 주요 태그 예시:

```html
<h1>제목</h1>
<p>본문입니다</p>
<a href="https://example.com">링크</a>
<img src="image.jpg" alt="이미지">
```

---

## 2. **CSS (Cascading Style Sheets)**

### 개념:

* **HTML에 디자인을 적용**하는 언어
* 글씨 크기, 색상, 여백, 정렬, 애니메이션 등 **시각적 표현** 담당

### 특징:

* HTML과 **분리된 디자인 역할**
* `.css` 확장자로 별도 파일 작성 가능
* 같은 HTML 구조에 다양한 디자인을 적용할 수 있음

### 예시:

```css
h1 {
  color: blue;
  font-size: 30px;
}

p {
  margin: 10px;
}
```

---

## 3. **Java**

### 개념:

* **객체지향 프로그래밍 언어**
* 강력하고 안정적인 **백엔드 서버, 안드로이드 앱, 금융 시스템**에 사용됨

### 특징:

* 플랫폼 독립성: **JVM(Java Virtual Machine)** 위에서 실행됨 (`Write once, run anywhere`)
* 정적 타입 언어 (변수에 자료형을 명확히 선언)
* 보안성과 대규모 시스템에 적합

### 간단한 코드 예시:

```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
```

---

## 4. **JavaScript**

### 개념:

* 웹페이지에 **동적인 기능을 부여**하는 스크립트 언어
* HTML과 CSS로 만든 페이지에 **이벤트 처리, 인터랙션, 로직** 추가

### 특징:

* 클라이언트 측에서 실행됨 (브라우저가 해석)
* DOM 조작, 이벤트 처리, API 호출 등에 강함
* ES6+ 이후 모던 문법 등장 → `let`, `const`, 화살표 함수 등

### 예시:

```javascript
document.getElementById("btn").addEventListener("click", function() {
  alert("버튼이 눌렸습니다!");
});
```

---

## 5. **Kotlin**

### 개념:

* **JetBrains에서 개발한 현대적인 프로그래밍 언어**
* Java보다 간결하고 안전한 문법을 지향
* **Android 공식 언어**로 채택됨 (Java 완전 호환)

### 특징:

* **Null 안정성** 제공 (`?`, `!!` 등)
* 람다식, 고차 함수 등 현대적인 기능 포함
* Java 코드와 **100% 상호 운용 가능**

### 예시:

```kotlin
fun main() {
    val name: String? = "Kotlin"
    println("Hello, $name!")
}
```

---

## 6. **IntelliJ IDEA**

### 개념:

* **JetBrains에서 만든 프로그래밍 통합 개발 환경(IDE)**
* Java, Kotlin, Spring 등 다양한 언어와 프레임워크에 최적화

### 특징:

* 강력한 자동완성, 디버깅, 리팩토링 기능
* Maven, Gradle 등 빌드 시스템 연동
* Git 연동, 테스트, UI 디자인 등 **통합 개발 경험** 제공

### 사용 용도:

* Kotlin/Java 기반의 **웹/모바일/서버 개발**에 주로 사용됨
* Android Studio도 IntelliJ 기반

---

## 요약 비교표:

| 기술                | 역할/용도             | 주 사용 분야           |
| ----------------- | ----------------- | ----------------- |
| **HTML**          | 웹 페이지 구조          | 프론트엔드             |
| **CSS**           | 스타일/디자인           | 프론트엔드             |
| **Java**          | 객체지향 백엔드/앱 개발     | 서버, 안드로이드, 금융     |
| **JavaScript**    | 웹페이지에 동적 기능 부여    | 프론트엔드, 웹앱         |
| **Kotlin**        | Java보다 간결한 JVM 언어 | Android, 서버 개발    |
| **IntelliJ IDEA** | 개발 도구(IDE)        | Java/Kotlin 프로그래밍 |

---
