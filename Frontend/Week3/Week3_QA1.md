# Week3_QA1.md

## Q1: 코드 문제인지, 브라우저 설정 문제인지 어떻게 구분하나요?
- HTML에서 `<script>`가 정상 실행되지 않는 문제는 브라우저 보안 설정(Snap vs Flatpak)이나 잘못된 `<script>` 위치, 문법 오류로 인한 문제일 수 있습니다.
- 테스트 HTML 파일에서 alert가 정상적으로 뜨는 경우, 브라우저 설정 문제는 아닐 가능성이 큽니다. 오히려 코드 자체 문제일 확률이 높습니다.

---

## Q2: `onclick="hey"`가 작동하지 않는 이유는?
- 함수 호출 시 괄호가 빠졌기 때문입니다.
  ```html
  <button onclick="hey">  <!-- 잘못된 예 -->
  <button onclick="hey()"> <!-- 올바른 예 -->
  ```
---

## Q3: `makeCard()` 함수 내 `let image = $('$image').val();` 가 작동하지 않는 이유는?
- `$image` → `#image`로 수정해야 합니다.
  ```js
  let image = $('#image').val(); // 아이디 선택자 앞에 # 필요
  ```

---

## Q4: 모든 값이 image 값만 나오는 이유는?
- 다음 코드에서 `image` 값만 반복 참조하고 있음.
  ```js
  let image = $('#image').val();
  let title = $('#image').val();
  let content = $('#image').val();
  let date = $('#image').val();
  ```
- 수정:
  ```js
  let image = $('#image').val();
  let title = $('#title').val();
  let content = $('#content').val();
  let date = $('#date').val();
  ```

---

## Q5: `$('#card')`에서 `$('#')`의 의미는?
- `$()`는 jQuery 함수입니다.
- `'#card'`는 id가 `card`인 요소를 선택한다는 의미입니다.
  → `$('#card')`는 `<div id="card">` 요소를 가리킵니다.

---

## Q6: `console.log()`에 `title`만 안 나오는 이유는?
- HTML 상 input의 `id="title"`로 되어 있어야 하고,
- JS에서도 `$('#title').val()`로 정확히 선택해야 함.
- 중복된 `id`나 잘못된 선택자가 있을 경우 `undefined`가 출력됨.

---

## Q7: `let temp_html` 템플릿에서 이미지가 나오지 않는 이유?
- 이미지 `src`에서 다음과 같이 잘못된 문자열이 있음:
  ```js
  <img src="${https://...}"   // 잘못된 사용
  ```
- 문자열로 처리해야 하므로 다음처럼 수정해야 함:
  ```js
  <img src="${image}" 
  ```

- 또 하나의 오타:
  ```js
  <p class="card-text">$[comment}</p> // 잘못된 사용
  <p class="card-text">${comment}</p> // 올바른 사용
  ```

---

## Q8: `makecard()`로 생성한 이미지가 안 붙는 이유?
- 주로 다음 중 하나일 가능성이 큼:
  1. `image` 변수가 잘못된 값을 가지고 있음
  2. 백틱(```) 템플릿 안에서 `${image}`가 아닌 잘못된 표현 사용
  3. `.append(temp_html)` 대상 `#card`가 존재하지 않음

---

## Q9: `let`의 의미는?
- ES6 이후 도입된 변수 선언 키워드.
- `var`와 유사하나, 블록 스코프를 가짐.
- 같은 이름으로 재선언 불가 (`let x = 1; let x = 2;` → 에러).

---

## Q10: HTML, CSS, JS에서 `;` 언제 쓰는가?
- **JS (자바스크립트)**:
  - 문장 종료 시 세미콜론(`;`) 사용.
  - 세미콜론 생략 가능하나, 습관적으로 붙이는 것이 안정적.

- **CSS**:
  - 속성 선언마다 `;`로 구분:
    ```css
    color: red;
    background-color: blue;
    ```

- **HTML**:
  - 세미콜론은 문장 종료 용도가 아님. HTML 엔티티에서만 사용됨:
    ```html
    &nbsp; &lt; &gt;
    ```

---

## Q11: 백틱(``) vs 작은 따옴표(`'`)의 차이
- 작은따옴표 `'문자열'` 또는 큰따옴표 `"문자열"`은 일반 문자열.
- 백틱은 **템플릿 리터럴**:
  - `${변수}` 형태로 변수 삽입 가능.
  - 여러 줄 문자열도 표현 가능.
  ```js
  let name = '홍길동';
  console.log(`안녕하세요, ${name}님`); // 변수 삽입 가능
  ```

---

## Q12: `.val()`의 의미는?
- jQuery 함수.
  - `$('#input').val()` → 입력창의 **값을 가져오기**
  - `$('#input').val("값")` → 입력창의 **값을 설정하기**

---