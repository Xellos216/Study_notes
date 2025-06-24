# 📅 2025-06-07 JavaScript 기초 예습 정리

## ✅ 오늘 학습한 주제

- var, let, const 변수 선언 통합 실습
- 함수 선언식 vs 함수 표현식 비교
- DOM 요소 선택 과 내용 변경
- 이벤트 리스너(예: 버튼 클릭)
- 간단한 계산기(더하기/곱하기/나누기) 구현
- 구구단 출력자 작성

---

## 토론시 Q&A 정보(학습 중 제기)

### ▶ Q1. `dan`은 문법이야?
- A: 아니야! `dan`은 개발자가 지정한 변수 이름이야.
- JavaScript에서 변수 이름은 자신이 의미를 담은 이름이면 되기 때문에, `dan`도, `x`도, `applePie`도 가능.

### ▶ Q2. `let i = 1;`에서 `;` 무엇이야?
- A: `let i = 1` 은 변수 i를 1로 초기화 하는 것.
- `;` 은 JavaScript에서 “이명은 끝”을 나타내는 구분자 (statement separator)야.
- for문의 구조가 ‘초기화 ; 조건 ; 반복효과’ 로 구성되고, 매 번째 명령을 구분해야 해.

### ▶ Q3. `const` 함수도 표현식 함수야?
- A: 다른 JavaScript 개발자가 `const` 로 한 함수 선언은 표현식 함수가 맞아.
- 예: `const greet = function() {...}` 또는 `() => {...}` 는 무작위 변수에 함수 담은 것 밖에 없으므로, 표현식 함수로 불리는 것이 맞음.

### ▶ Q4. `generateBtn`은 무엇이야?
- A: HTML에서 `<button id="generateBtn">`로 적용된 버튼의 id 값이고,
  JavaScript에서 `document.getElementById("generateBtn")`로 다룰수있게 변수로 가지고 온 것.
- DOM의 포인터에 자동으로 접근하는 해당 요소가 바로 구현됨.

---

## 학습 주제 변수 / DOM / 이벤트 / 계산기 요약

### ✨ 사용한 대표적인 JavaScript 문법

```javascript
// 1. 변수 선언
let x = 10;
const y = 5;

// 2. 함수 선언식 vs 표현식
function greet() {
  console.log("hello");
}
const sayHi = function() {
  console.log("hi");
};

// 3. DOM 선택 + 변경
const title = document.getElementById("title");
title.innerText = "변경된 제목!";

// 4. 이벤트 클릭
btn.addEventListener("click", () => {
  console.log("버튼 클릭!");
});

// 5. 계산기 구현
const n1 = Number(document.getElementById("num1").value);
const n2 = Number(document.getElementById("num2").value);
const sum = n1 + n2;
result.innerText = `결과: ${sum}`;

// 6. 구구단 출력
for (let i = 1; i <= 9; i++) {
  const li = document.createElement("li");
  li.innerText = `${dan} x ${i} = ${dan * i}`;
  output.appendChild(li);
}
```

---

## 학습 풀이 결과

| 단계 | 사유 | 지향 |
|--------|----------------------|----------|
| Step 1 | var/let/const 비교 | 변수 의미, 스코프 이해 |
| Step 2 | 함수 선언식 vs 표현식 | 함수 형식과 호이스팅 이해 |
| Step 3 | DOM 요소 선택/변경 | HTML 요소와 JS 연결 |
| Step 4 | 버튼 클릭 이벤트 | 사용자 사항 처리 시작 |
| Step 5 | 계산기 추가 (곱하기, 나누기) | 입력-클릭-출력 탐색 |
| Step 6 | 구구단 출력 | 순환 반복문 적용 |

---

## 학습 풀이 완료상황: ✅ 참 잘했어!
