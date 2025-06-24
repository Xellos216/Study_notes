# Week3_QA2.md

## Q1: 첫 fetch 코드 작성 후 출력이 undefined로 나오는 문제

**문제 상황**  
- 콘솔 오류: `ReferenceError: data is not defined`  
- 이유: `.then(data => {...})` 내부에서 `data`가 정의되기 전에 외부에서 사용되고 있었음.  

**해결 방법**  
- 모든 fetch 후속 처리는 `.then()` 블록 안에서 수행해야 함.  
- 바깥에서 `data` 사용 시 ReferenceError 발생.

---

## Q2: `console.log(data)` 찍었는데 안 보임

**확인한 내용**  
- fetch URL을 직접 브라우저에서 접근해보니 데이터 정상 출력  
- 문제는 비동기 흐름을 이해하지 못하고 fetch 외부에서 `data`를 쓰려 했기 때문  
- `.then()` 내부에서만 `data`가 유효함

---

## Q3: 강의 코드와 동일하게 작성했는데 작동 안 함

**코드**  
```javascript
let url = 'http://spartacodingclub.shop/sparta_api/seoulair';
fetch(url).then(res => res.json()).then(data => {
    let rows = data['RealtimeCityAir']['row'];
    ...
});
```

**문제 해결 사항**  
- 콘솔 오류: `ReferenceError: data is not defined`  
- 해결: `data`는 `.then(data => {...})` 안에서만 사용해야 하며, 외부에서 접근하면 오류 발생

---

## Q4: VSCode에서 들여쓰기 가이드/괄호 색상 안 보임

**설정 상태**  
- settings.json 및 GUI에서 다음 항목 활성화 완료:
  - `editor.guides.indentation`
  - `editor.guides.highlightActiveIndentation`
  - `editor.bracketPairColorization.enabled`

**문제 원인 및 확인 사항**  
- VSCode 우분투 버전에서 테마 또는 Extension에 따라 시각적으로 표시되지 않을 수 있음
- 해결 방법:
  - **VSCode를 완전히 재시작**
  - **테마를 변경하여 표시되는지 확인**
  - `Bracket Pair Colorizer 2` 확장 설치해보는 것도 고려

---

## Q5: 실시간 미세먼지 API 연동 코드 검수 요청

**문제**  
```javascript
let gu_mvl = a['IDEX_MVL'];
if (gu_mise > 40) { // ← gu_mise 정의되지 않음
```

**해결**  
- 변수명 오류 → `gu_mise`가 아니라 `gu_mvl`로 통일해야 함
- 수정 후:
```javascript
if (gu_mvl > 40) {
    ...
}
```

---

## Q6: 전체 코드 해석 요청

```js
function q1() {
    let url = 'http://spartacodingclub.shop/sparta_api/seoulair'; // 1. URL 변수 선언
    $('#names-q1').empty();                                       // 2. 기존 목록 지우기

    fetch(url)                                                    // 3. URL로 요청
        .then(res => res.json())                                  // 4. 응답을 JSON으로 파싱
        .then(data => {
            let rows = data['RealtimeCityAir']['row'];            // 5. 데이터 배열 추출
            rows.forEach(a => {                                   // 6. 각 데이터 순회
                let gu_name = a['MSRSTE_NM'];                      // 7. 구 이름 추출
                let gu_mvl = a['IDEX_MVL'];                        // 8. 미세먼지 수치 추출

                let temp_html = ``;
                if (gu_mvl > 40) {
                    temp_html = `<li class="bad">${gu_name} : ${gu_mvl}</li>`; // 9. 40 초과 시 빨간색
                } else {
                    temp_html = `<li>${gu_name} : ${gu_mvl}</li>`;             // 10. 아니면 일반색
                }
                $('#names-q1').append(temp_html);                  // 11. DOM에 추가
            });
        });
}
```

---

## Q7: 상단 네비바 UI 수정 위치 문의

**수정하고 싶은 부분 (스크린샷 기준)**  
- `Spartafilx`, `홈`, `시리즈`, `영화`, `내가 찜한 스토리`, 검색창, Login, Sign-up 버튼 등

**코드 내 위치**  
```html
<header class="p-3 text-bg-dark">
  <div class="container">
    ...
    <ul class="nav col-12 col-lg-auto ...">
        <li><a href="#" class="nav-link px-2 text-danger">Spartafilx</a></li>
        <li><a href="#" class="nav-link px-2 text-white">홈</a></li>
        ...
    </ul>
    ...
  </div>
</header>
```

이 `<header>` 블록 내부의 `<ul>`, `<form>`, `<div>` 등을 수정하면 원하는 UI 수정 가능

---

## Q8: `<span id="msg"></span>`의 역할

**위치**
```html
<li><a href="#" class="nav-link px-2 text-white">현재 기온 : <span id="msg">모름</span></a></li>
```

**해석**
- `span`은 **실시간 데이터를 삽입할 자리**  
- `id="msg"`인 이 요소는 `$('#msg').text(temp);` 코드에 의해 온도 정보로 바뀜

**컴퓨터식 해석**
- "span 박스를 만들고 → id를 msg로 붙여라 → 기본값은 '모름'으로 설정해라"
- "fetch로 받아온 데이터를 → msg라는 id를 가진 요소에 텍스트로 삽입해라"

---
