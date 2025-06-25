# Week3_Summary_Rewritten.md

> ✅ 목적: 복습용으로 내용을 간단하고 기억 위주로 정리  
> ✅ 대상: jQuery 조작 + fetch 통신 개념 및 실습 흐름

---

## 01. jQuery 복습 + 실습

- 기존에 배운 `.text()`, `.html()`, `.append()` 사용법 다시 확인
- `.toggle()`을 활용한 버튼 클릭 시 보이기/숨기기 실습

```javascript
function togglePostBox() {
  $('#post-box').toggle();  // id="post-box" 영역을 토글
}
```

- 버튼에 연결: `<button onclick="togglePostBox()">`

---

## 02. 서버와 클라이언트 구조 이해

- 클라이언트: 사용자의 브라우저 (요청을 보냄)
- 서버: 요청을 받고, 처리 후 응답을 보냄
- 통신은 HTTP 기반 (GET/POST)

---

## 03. fetch 기본 문법 학습

```javascript
fetch("요청 URL", {
  method: "POST",
  headers: { "Content-Type": "application/json" },
  body: JSON.stringify({ name: "홍길동", age: 20 })
})
.then(res => res.json())
.then(data => {
  console.log(data);
});
```

- `fetch()`는 비동기 통신 함수
- `.then()`으로 응답을 받고 `.json()`으로 데이터 추출

---

## 04. fetch 실습 1: 버튼 클릭 → 서버로 POST 요청 보내기

- 입력값(제목, 이미지, 코멘트 등)을 가져와서 객체로 만들고 fetch로 전송
- 서버에서 응답을 받으면 콘솔에 확인

```javascript
let data = {
  title: $('#title').val(),
  image: $('#img').val(),
  comment: $('#comment').val()
};

fetch("/movie", {
  method: "POST",
  headers: { "Content-Type": "application/json" },
  body: JSON.stringify(data)
})
.then(res => res.json())
.then(data => {
  alert(data["msg"]);  // 성공 메시지 출력
});
```

---

## 05. fetch 실습 2: 서버에서 영화 데이터 받아와 카드로 출력

- GET 요청을 보내서 영화 목록을 받아옴
- 받아온 데이터를 `.forEach()`로 순회하며 카드 생성

```javascript
fetch("/movie")
  .then(res => res.json())
  .then(data => {
    data.forEach(movie => {
      let html = `<div class="card">...</div>`;
      $('#movie-list').append(html);
    });
  });
```

---

## 06. fetch 실습 3: 조건문 활용 (성인/청소년 분류)

```javascript
if (age >= 20) {
  console.log("성인입니다");
} else {
  console.log("청소년입니다");
}
```

- 영화 정보 중 나이 정보를 기준으로 출력 내용 분기

---

## 07. 실제 공공 API 사용 예시 (서울시 OpenAPI)

```javascript
fetch("https://api.seoul.go.kr/air_quality")
  .then(res => res.json())
  .then(data => {
    let 미세먼지 = data['row'][0]['PM10'];
    $('#dust').text(미세먼지);
  });
```

- 실시간 데이터 사용법 익힘
- JSON 구조에서 필요한 필드를 꺼내 사용하는 연습 포함

---

## 8. [추억앨범] Fetch 적용

- 목표: 서울의 실시간 대기 정보를 받아와 웹 페이지에 표시
- 적용 UI: 사용자 입력 폼 + 실시간 데이터 연동 (IDEX_NM 값 표시)

### 주요 개념 정리

- `fetch()`로 API에서 데이터 받아오기
- `$(document).ready()`를 통해 페이지 로딩 후 fetch 실행
- 응답(response)을 `.json()`으로 파싱
- 특정 key (`RealtimeCityAir` → `row` → `[0]` → `IDEX_NM`)를 찾아 출력

### 예시 코드

```javascript
$(document).ready(function () {
  let url = "http://spartacodingclub.shop/sparta_api/seoulair";
  fetch(url).then(res => res.json()).then(data => {
    let mise = data['RealtimeCityAir']['row'][0]['IDEX_NM'];
    $('#msg').text(mise);
  });
});
```

---

## 9. [스파르타플릭스] Fetch 적용

- 목표: 서울의 실시간 기온(temp)을 받아와 페이지에 표시
- 적용 UI: 스파르타플릭스 페이지 상단 텍스트에 삽입

### 주요 개념 정리

- `fetch()`로 OpenAPI에서 기온 데이터 호출
- `$(document).ready()`에서 자동 실행
- 응답을 `.json()`으로 파싱 후 `temp` 키에서 값 추출
- `<span id="msg">` 영역에 삽입

### 예시 코드

```javascript
$(document).ready(function () {
  let url = "http://spartacodingclub.shop/sparta_api/weather/seoul";
  fetch(url).then(res => res.json()).then(data => {
    let temp = data['temp'];
    $('#msg').text(temp);
  });
});
```

---

✅ *실시간 데이터를 가져와 DOM에 반영하는 기본 패턴은 위 두 예시를 통해 완전히 이해할 수 있어야 한다.*

## ✅ 요약 마무리

- `jQuery`로 조작 → `fetch()`로 요청 → `then()`으로 응답 처리 → DOM에 출력
- 실습 구조를 기억할 것:
  1. 입력 받기
  2. fetch 요청 보내기 (POST or GET)
  3. 응답 받아 `.forEach()`나 조건문으로 처리
  4. `.append()`로 결과 출력

