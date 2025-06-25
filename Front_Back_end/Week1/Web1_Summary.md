
# Web1_Summary.md

## 1-1. 1주차 오늘 배울 것

### 🔹 학습 목표
- HTML과 CSS를 활용해 **웹 페이지의 뼈대와 디자인 구성**하기
- Bootstrap을 통해 빠르게 UI를 꾸며보기

### 🔹 1~5주차 전체 구성 개요
| 주차 | 학습 내용 |
|------|----------|
| 1주차 | HTML/CSS/Bootstrap |
| 2주차 | JavaScript 기본 문법 및 동작 이해 |
| 3주차 | jQuery, Fetch |
| 4주차 | Firebase & Firestore |
| 5주차 | Github 배포, 고급 기능(Python 맛보기 등)

---

## 1-2. 웹 브라우저 작동 원리

### 🔸 핵심 개념
- 웹 브라우저는 **서버에 요청**을 보내고, 받은 HTML을 **화면에 그리는 역할**을 수행
- 개발자 도구로 **웹 페이지의 HTML 구조와 API 응답**을 확인할 수 있음

### 🔸 브라우저 작동 순서 요약
1. 사용자가 주소 입력
2. 브라우저가 서버에 요청
3. 서버는 HTML, CSS, JS 혹은 JSON 등의 응답 전달
4. 브라우저가 받은 응답을 기반으로 렌더링

### 🔸 클라이언트와 서버
- HTML 파일이 직접 응답으로 오는 경우도 있지만,
- API를 통해 JSON 데이터만 받고, JavaScript로 페이지를 구성하는 경우도 많음

```json
{
  "RESULT": {
    "CODE": "INFO-000",
    "MESSAGE": "정상 처리되었습니다"
  },
  "list_total_count": 1,
  "row": [
    {
      "MSRDT": "202004241900",
      "MSRRGN_NM": "은평구",
      "PM10": 30
    }
  ]
}
```

---

## 1-3. 코딩 환경 세팅하기

### 🔸 에디터: VS Code
- Microsoft의 대표적인 코드 편집기
- **HTML, CSS, JS 실습에 최적화**
- 추천 확장 기능: `Live Server` (HTML 파일을 실시간 미리보기 가능)

---

## 1-4. HTML 기초

### 🔸 폴더 및 파일 생성 실습
```
/sparta/frontend/tags.html
```

### 🔸 HTML과 CSS의 개념
- HTML: **페이지의 뼈대**를 구성하는 언어
- CSS: 해당 뼈대의 **스타일과 레이아웃**을 꾸미는 언어

---

## 1-5. 로그인 페이지 만들기

### 🔸 예시 코드
```html
<h1 class="mytitle">로그인 페이지</h1>
<button class="mybtn">로그인하기</button>
```

---

## 1-6. CSS 기초

### 🔸 주요 속성
- 배경: background-color, background-image
- 크기: width, height
- 글꼴: font-size, color, font-family
- 여백: margin, padding
- 정렬: text-align, display

---

## 1-7~1-8. 자주 쓰는 CSS

### 🔸 margin vs padding 비교
- margin: 외부 여백
- padding: 내부 여백

---

## 1-9. 구글폰트 적용하기

### 🔸 예시 코드
```css
@import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap');
* {
  font-family: 'Gowun Dodum', sans-serif;
}
```

---

## 1-10. Bootstrap 적용하기

### 🔸 CDN 적용
```html
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
```

---

## 1-11. [추억앨범] 프로젝트 1

### 🔸 카드 레이아웃 구성
- `row-cols-md-4` 클래스 활용해 4개 카드 한 줄 정렬

---

## 1-12. [추억앨범] 프로젝트 2

### 🔸 포스팅 입력 박스 추가
```css
.mypostingbox {
  width: 500px;
  margin: 20px auto;
  padding: 20px;
  box-shadow: 0px 0px 3px 0px blue;
}
```

### 🔸 폼 구성 예시
```html
<input type="email" class="form-control" placeholder="앨범 이메일" />
<input type="text" class="form-control" placeholder="앨범 제목" />
<textarea class="form-control" placeholder="앨범 내용"></textarea>
```

---
