# Week2\_QA1: HTML/CSS/Bootstrap Q\&A 정리

## Q1: 왜 폰트가 적용되지 않나요?

**원인:**

* 처음에는 `Nothing You Could Do` 폰트만 `@import` 하고 적용했으나, 해당 폰트는 **영문 전용**으로, 한글은 적용되지 않음.

**해결:**

* "Noto Sans KR"과 같이 한글 지원 폰트를 함께 지정하면 혼합 적용 가능.

```css
font-family: "Nothing You Could Do", "Noto Sans KR", sans-serif;
```

---

## Q2: 카드 간격이 이상하게 나옵니다

**원인:**

* `.row` 아래 자식 요소가 `col`로 감싸져 있지 않으면 **부트스트랩 그리드 시스템이 깨짐**

**해결:**

* 모든 카드(`.card`)는 반드시 `<div class="col">...</div>`로 감싸야 `g-4` (gap) 간격이 제대로 적용됨.

---

## Q3: `col`이 뭐죠?

**답변:**

* 부트스트랩의 **그리드 시스템**에서 열(column)을 의미.
* `.row`로 묶인 행(row) 내부에서 `.col`은 콘텐츠의 너비를 자동 계산하여 배치함.
* 반응형 클래스도 지원 (`col-md-6`, `col-lg-4` 등)

---

## Q4: 부트스트랩(Bootstrap)이란?

**정의:**

* 트위터 개발자들이 만든 **HTML/CSS/JS UI 프레임워크**
* 레이아웃, 버튼, 폼 등 미리 정의된 클래스를 제공해 빠르게 웹사이트를 만들 수 있게 해줌.

**저작권 문제:**

* MIT 라이선스로 배포됨 → 상업적 사용 포함하여 자유롭게 사용 가능

**공식 문서:** [https://getbootstrap.com/](https://getbootstrap.com/)

---

## Q5: `<div>`가 너무 헷갈려요. 정리하는 팁은?

### ✔ 추천 방법

1. VSCode 확장 기능: `Auto Rename Tag`, `Highlight Matching Tag`
2. Emmet 단축코드 활용: `div.card>img+div.card-body>h5+p+p`
3. 코드 접기 단축키: `Ctrl + Shift + [` 또는 `]`
4. 명확한 class 네이밍: `main-wrapper`, `form-box`, `card-container` 등으로 구조 구분

---

## Q6: 중앙 폼에 글자가 안 보여요

**원인:**

* `<label for="...">`과 `input id="...">`가 정확히 연결되지 않았거나, HTML 구조가 깨져 있었음

**해결:**

* `<label>`이 연결된 대상의 `id`가 고유해야 하며, 중복되어선 안 됨 (동일 `id` 두 번 쓰지 않기)
* `<div>`를 잘못 닫으면 구조 전체가 깨져 UI가 이상해짐

---

## Q7: 배경 사진이 늘어나 있어요

**원인:**

* `.main` 영역 내에서 `form` 박스 구조가 **`.container-fluid` 밖**에 위치하거나
* 여는/닫는 `<div>`가 어긋나면서 내부 요소 크기를 잘못 계산함

**해결:**

* `<div>` 구조 확인 후 잘 닫고 감싸는지 점검
* `.container-fluid py-5` 내부에 폼도 포함되도록 이동하면 높이 계산이 정확히 이루어짐

```html
<div class="container-fluid py-5">
    <h1>...</h1>
    <p>...</p>
    <div class="mypostingbox">...</div>
</div>
```

---

## ✅ 기타 팁 요약

* `row` 안엔 항상 `col`
* `@import` 폰트는 영문/한글 여부 구분
* Bootstrap은 자유롭게 사용 가능한 CSS 프레임워크
* `<div>` 구조는 코드 폴딩 or Emmet으로 보완

---

