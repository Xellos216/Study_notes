# Week2 Summary - 웹개발 A to Z

## 🔥 2주차 배울 것

- **HTML**은 뼈대, **CSS**는 꾸미기, **Javascript**는 **움직이기**!
- Javascript는 웹을 동적으로 작동시키는 핵심 언어.
- 실생활 예시: 모바일 청첩장을 만들어 사용자 인터랙션 처리 가능
- 예시 기능:
  - 버튼 클릭 시 사진 바뀜
  - 스크롤 시 요소 변경
  - 요청 전송 및 응답 처리 등

## 🧠 자바스크립트 배우기 전에!

- 지난 1주차 학습 내용(HTML, CSS, Bootstrap) 복습
- 복습용 미니 프로젝트: **스파르타플릭스**
  - 추억앨범 구조와 매우 유사
  - 기본 뼈대 구성, 부트스트랩 활용

## 🎬 [스파르타플릭스] 프로젝트 1 - 상단 만들기

- 폴더 구조: `sparta/spartaflix/index.html`
- 템플릿 구성:
  - Bootstrap CDN 연결
  - 배경 이미지 설정
  - 구글 폰트 적용
  - nav bar 구성
  - 로그인 / 회원가입 버튼 구성
- 참고 링크:
  - Bootstrap: https://getbootstrap.com/docs/5.3/getting-started/introduction/
  - 배경 이미지: Netflix API 링크
  - 킹덤 설명 텍스트 포함

## 🧩 [스파르타플릭스] 프로젝트 2 - 카드 추가하기

1. 카드 구성:
   - Bootstrap Card 컴포넌트 복사 및 커스터마이징
   - 포스터 이미지 삽입
   - `.row-cols-md-3 g-4` → `.row-cols-md-4 g-4`로 조정
2. 카드 내용 수정:
   - 영화 제목, 코멘트 작성
   - 별점은 `<p>` 태그 내 ⭐️⭐️⭐️

## 📝 [스파르타플릭스] 프로젝트 3 - 포스팅 박스 만들기

- 입력 폼 구성:
  - 입력창(제목, 추천 이유)
  - 장르 선택 드롭다운
  - 기록 버튼
- 주요 CSS:
  - `box-shadow: 0px 0px 3px 0px gray;`
  - `padding: 20px;`
- Bootstrap 참고 요소:
  - Forms > Floating Labels
  - Input group
  - Buttons > Variants

## 💡 Javascript에 대해

### ✔ 왜 사용하는가?

- 클라이언트와 서버 간 동작 정의
- 사용자 인터랙션 구현 (클릭, 입력, 반응 등)
- 표준화된 동적 웹 개발 언어로 자리 잡음

### ✔ Java vs Javascript?

- 아무 관련 없음 (이름만 비슷함)

### ✔ 활용성

- 프론트엔드 + 백엔드 통합 개발 가능 (Node.js 등)
- 다양한 플랫폼(IoT, 게임, 앱 등)에 응용 가능
- 필수적인 웹 기술로 광범위하게 사용됨

---

👉 이후에는 Javascript 기초문법을 학습하고, JQuery 활용으로 이어집니다.

## 🧪 Javascript 기초문법 1 - 출력과 개발자 도구 사용

- `console.log()` 함수: 콘솔에 텍스트 또는 값 출력
- 실행 위치: 브라우저 → 우클릭 → '검사' → 'Console' 탭 확인
- 버튼 클릭과 연결: `<button onclick="hey()">`로 함수 호출

```javascript
function hey() {
  console.log('안녕하세요');
}
```

---

## 🧮 Javascript 기초문법 1 - 변수 & 연산

- `let` 키워드로 변수 선언  
  - 예: `let a = 2; let b = 'Bob';`
- 문자열은 작은 따옴표(‘ ’) 또는 큰 따옴표(“ ”)로 감쌈
- 숫자 연산: `+`, `-`, `*`, `/`, `%` 등
- 문자열 + 문자열 → 연결됨

```javascript
let a = 2;
let b = 3;
console.log(a + b); // 5

let c = '대한';
let d = '민국';
console.log(c + d); // 대한민국
```

---

## 📦 Javascript 기초문법 2 - 배열 & 딕셔너리

### ✅ 배열 (Array)

- 순서대로 값을 나열한 자료형
- 인덱스는 0부터 시작

```javascript
let a = ['사과', '수박', '딸기', '참외'];
console.log(a[0]); // 사과
console.log(a.length); // 4
```

### ✅ 딕셔너리 (Object)

- 키-값 쌍으로 이루어진 자료 구조

```javascript
let a = {'name': '영수', 'age': 27};
console.log(a['name']); // 영수
```

- 딕셔너리를 배열처럼 묶어 사용 가능:

```javascript
let a = [
  {'name': 'A', 'age': 27},
  {'name': 'B', 'age': 15},
  {'name': 'C', 'age': 20}
];
console.log(a[0]['name']); // A
```

### ✅ 왜 필요한가?

- 정보를 순서대로, 또는 키로 빠르게 찾기 위해 사용
- 다양한 데이터를 묶어서 관리 가능

---

## 🧰 Javascript 기초문법 2 - 기본 함수 활용

- 내장 함수 예시:
  - 문자열 나누기: `split()`
  - 산술 연산: `+`, `-`, `*`, `/`

```javascript
let result = 'sparta@gmail.com'.split('@');
console.log(result[0]); // 'sparta'
console.log(result[1]); // 'gmail.com'
```

---

## 🔁 Javascript 기초문법 3 - 반복문 & 조건문

### ✅ 반복문: forEach

```javascript
let fruits = ['사과', '배', '감'];
fruits.forEach(a => {
  console.log(a);
});
```

### ✅ 조건문: if ~ else

```javascript
let age = 24;
if (age > 20) {
  console.log('성인입니다');
} else {
  console.log('청소년입니다');
}
```

### ✅ 반복 + 조건

```javascript
let ages = [12, 15, 20, 25, 17, 37, 24];
ages.forEach((a) => {
  if (a >= 20) {
    console.log('성인입니다');
  } else {
    console.log('청소년입니다');
  }
});
```

---

🔎 **보충 개념**  
- `let`: 블록 스코프 변수 선언 키워드 (중복 선언 불가)  
- `console.log()`: 디버깅을 위한 출력 함수  
- `forEach()`: 배열 순회용 고차함수  
- `split()`: 문자열을 분할하여 배열로 반환하는 메서드  
- 조건문과 반복문은 로직 제어의 핵심 구조로, 이후 DOM 제어나 이벤트 처리에 필수적으로 연결됨

## 🖱️ Javascript 활용문법 (DOM 조작)

### ✅ 함수 연결 및 Alert

- `onclick`으로 버튼에 함수 연결 가능
- `alert()` 함수는 사용자에게 알림창 띄움

```javascript
function hey() {
  alert('안녕!');
}
```

- HTML 예시:
```html
<button onclick="hey()">영화 기록하기</button>
```

---

### ✅ HTML 조작: document 객체

- `document.getElementById('id명').style.color = 'red'`
  → 특정 요소 스타일 변경
- `document`는 브라우저 전체 HTML 문서를 의미

---

## 🌐 JQuery 시작하기

### ✅ JQuery란?

- Javascript를 간결하고 쉽게 사용할 수 있도록 만든 JS 라이브러리
- 기본 문법을 단축형으로 표현 가능

### ✅ JS vs JQuery 비교

```javascript
// JS
document.getElementById('hello').innerHTML = '안녕';
// JQuery
$('#hello').html('안녕');
```

---

## 🛠 JQuery 연습하기

### ✅ JQuery 문법 예시

```javascript
let a = ['사과', '배', '감'];
$('#q1').text(a[1]); // 배
```

```javascript
let b = {'name': '영수', 'age': 30};
$('#q2').text(b['name']); // 영수
```

```javascript
let c = [
  {'name': '철수', 'age': 30},
  {'name': '영희', 'age': 28},
];
$('#q3').text(c[1]['age']); // 28
```

---

### ✅ 반복문 + JQuery 적용

```javascript
let fruits = ['사과', '배', '감'];
let temp_html = '';
fruits.forEach((a) => {
  temp_html += `<p>${a}</p>`;
});
$('#q1').append(temp_html);
```

- `.append()` : 기존 HTML 내용 뒤에 새 요소 추가
- `.empty()` : 기존 내용 비우기

---

### ✅ 객체 리스트 다루기

```javascript
let people = [
  {'name': '영수', 'age': 26},
  {'name': '철수', 'age': 30}
];

let temp_html = '';
people.forEach((p) => {
  temp_html += `<p>${p.name}은 ${p.age}살입니다</p>`;
});
$('#q2').append(temp_html);
```

---

📌 **Tip**
- JQuery에서 `$()`는 요소를 선택하는 대표 문법
- `.text()`, `.html()`, `.append()`, `.empty()` 등 다양한 메서드를 함께 학습

---

📄 전체 HTML 실습 코드 및 스크립트는 별도 예제로 정리 가능

