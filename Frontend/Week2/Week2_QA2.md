# Week2_QA2.md

자바스크립트 강의 Q&A 정리 (with 실습 코드 해석)

---

## Q1: `console.log()`는 왜 쓰는가?

- `console.log()`는 **브라우저 개발자 도구(F12)**의 `Console` 탭에서 확인할 수 있는 **디버깅용 출력 함수**입니다.
- 웹페이지에 표시되는 것은 아니고, **개발자 자신이 코드가 제대로 동작하는지 확인하기 위해** 내부 데이터를 출력할 때 주로 사용합니다.
- 예시:
  ```js
  let name = 'bob';
  let age = 30;
  console.log(name + age);  // 콘솔 창에 bob30 출력됨
  ```

---

## Q2: `forEach`라는 함수는 존재하는가?

- `forEach()`는 **배열(Array)** 전용 메서드입니다.
- 배열 안의 각 요소를 하나씩 꺼내서 **콜백 함수 내부에서 실행**시킬 수 있도록 도와줍니다.
- 사용 전에는 반드시 배열인지 확인해야 합니다.

오류 예시:
```js
Array.forEach(a => { console.log(a); });
```
> ❌ `Array`는 배열 인스턴스가 아니라 배열 생성자라 에러 발생

정상 예시:
```js
let ages = [15, 30, 28];
ages.forEach(a => {
  console.log(a);  // 배열 안의 숫자들이 하나씩 출력됨
});
```

---

## Q3: `forEach(a => {...})`에서 `a`는 무엇인가?

- `a`는 **배열 안의 각 요소를 순서대로 대표하는 변수명**입니다.
- 반복문이 돌면서 배열 안의 값들이 `a`에 하나씩 대입됩니다.

예시:
```js
let ages = [15, 30, 7];

ages.forEach(a => {
  if (a < 20) {
    console.log('청소년입니다.');
  } else {
    console.log('성인입니다.');
  }
});
```
- 해석: 배열 안의 숫자(나이)를 하나씩 `a`에 담아서, `a`가 20보다 작으면 청소년, 아니면 성인이라고 출력

---

## Q4: 다음 함수는 어떤 역할을 하는가?

```js
function checkResult() {
  let fruits = ['사과', '배', '감', '귤', '수박'];
  $('#q1').empty();  // q1 영역 비우기

  fruits.forEach(a => {
    let temp_html = `<p>${a}</p>`;  // <p>사과</p> 식으로 생성됨
    $('#q1').append(temp_html);     // q1 영역에 하나씩 추가
  });
}
```

- 해석:
  - `fruits` 배열에 있는 과일 이름을 하나씩 꺼내서 `<p>` 태그로 감싼 뒤,
  - id가 `q1`인 영역 안에 하나씩 추가해서 출력함

---

## Q5: 다음 함수는 어떤 역할을 하는가?

```js
function checkResult() {
  let people = [
    { 'name': '서연', 'age': 24 },
    { 'name': '연아', 'age': 30 },
    { 'name': '하준', 'age': 12 },
    { 'name': '서연', 'age': 15 },
    { 'name': '지용', 'age': 18 },
    { 'name': '예지', 'age': 36 }
  ];

  $('#q2').empty();  // 기존 내용 비우기

  people.forEach(a => {
    let name = a['name'];
    let age = a['age'];
    let temp_html = `<p>${name}는 ${age}살입니다.</p>`;
    $('#q2').append(temp_html);
  });
}
```

- 해석:
  - `people` 배열은 이름과 나이가 담긴 객체 리스트입니다.
  - 각각의 사람 이름과 나이를 꺼내서, `이름은 나이살입니다.` 형식으로 HTML `<p>` 태그를 만든 뒤,
  - id가 `q2`인 곳에 출력합니다.
