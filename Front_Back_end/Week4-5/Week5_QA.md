# Week5_QA.md

## Q1. Firebase 데이터를 불러오지 못하는 이유가 무엇이었나요?

### 문제 상황:
Firebase에 연결은 되었지만 HTML에서 작성한 코드대로 카드가 렌더링되지 않았음.

### 원인 분석:
- `#image`, `#movie` 등의 속성명을 `row['#image']`처럼 '#'을 포함한 이름으로 작성했으나, Firebase에 실제 저장된 필드명은 `image`, `movie` 등 '#'이 없는 이름이었음.
- JavaScript에서 불러올 때도 `row['image']`처럼 '#' 없이 호출해야 정상 작동함.

### 해결 방법:
- Firebase의 필드명과 JavaScript 코드의 변수명을 일치시킴.
- HTML form input의 id는 `#image`처럼 '#'을 붙여 호출하지만, Firebase에서 저장할 때는 키 이름에서 '#'을 제거해야 함.

---

## Q2. Firebase 실시간 데이터베이스와 Firestore의 차이는?

### Firestore:
- 문서(Document)와 컬렉션(Collection) 기반의 NoSQL 데이터베이스.
- 확장성과 복잡한 구조 설계에 유리함.

### Realtime Database:
- JSON 트리 기반의 실시간 데이터베이스.
- 데이터 구조가 단순하고 실시간 처리에 유리함.

> 대부분의 신규 프로젝트에서는 Firestore를 사용함.

---

## Q3. `#`이 붙은 것과 안 붙은 것의 차이는 무엇인가요?

- `#image`는 HTML에서 `id="image"`인 요소를 선택하기 위한 **jQuery/CSS 선택자**.
- Firebase에 저장할 때는 문자열 키로 `'image'`를 사용해야 하며, 여기에 `#`을 붙이지 않음.
- 따라서, jQuery 코드에서는 `$('#image')`처럼 `#`을 붙이고,
  Firebase에서 불러올 때는 `row['image']`처럼 `#` 없이 사용해야 함.

---

## Q4. GitHub Pages 기능은 왜 존재하나요?

- GitHub는 원래 **소스코드 버전관리**를 위한 플랫폼이지만,
- 간단한 정적 웹사이트(HTML/CSS/JS로 구성)를 빠르게 배포할 수 있도록 `GitHub Pages` 기능을 제공함.
- 특히 웹 포트폴리오, 수업 결과물, 프로젝트 소개 페이지 등을 손쉽게 배포 가능.

> 즉, 깃허브 운영진이 실용성을 높이기 위해 넣어둔 기능이지만, 실제로 많이 쓰인다.

---

## Q5. GitHub에 HTML을 올릴 때 Firebase API Key가 노출되면 문제가 생기나요?

- **Firebase API Key는 공개되어도 보안상 큰 문제가 없는 키**임.
- 하지만, Firestore에 쓰기 권한까지 있는 경우, 누구나 데이터를 추가하거나 삭제할 수 있음.
- 따라서, 보안 규칙(Firebase Rules)을 반드시 설정해서 권한을 제한해야 함.

```js
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /Movies/{document} {
      allow read, write: if false;  // 테스트 시에는 true로
    }
  }
}
```

> 배포 전엔 반드시 `write` 권한을 제한해야 함.

---

## Q6. 백엔드 서버는 단순히 DB를 저장하고 불러오는 기능만 하나요?

- 전혀 아님. 백엔드는 데이터 처리뿐만 아니라 다양한 로직을 담당함.
- 예시:
  - 로그인 인증
  - 사용자 권한 관리
  - 결제 처리
  - 파일 업로드/다운로드
  - 스케줄 관리
  - 요청 필터링/제한

> 즉, 사용자가 요청한 것을 처리하는 모든 비즈니스 로직이 백엔드 서버의 역할.

---

## Q7. 예를 들어, 수강신청 사이트에서 트래픽 관리 같은 것도 백엔드가 하나요?

- 맞음. 예를 들어,
  - 일정 트래픽 초과 시 "대기열"을 만드는 기능
  - 순차적인 접속 허용
  - 중복 신청 방지 등은 백엔드에서 처리해야 함.
- Firebase 같은 BaaS(Backend-as-a-Service) 서비스는 이런 복잡한 제어가 어려움.
- 그래서 직접 Node.js, Python 등으로 **백엔드 서버를 구축**해야 하는 상황도 많음.

---

## Q8. 백엔드 개발 시 파이썬을 많이 사용하나요?

- Python은 웹 백엔드에서도 많이 사용됨.
- 대표적인 프레임워크: Django, Flask
- 장점:
  - 간결한 문법
  - 빠른 개발 속도
  - AI/데이터 처리와의 궁합

> 단, 대규모 웹 서비스에서는 Node.js, Java, Go 등도 많이 쓰임.

---

## Q9. 내 Firefox에는 Copy selector 메뉴가 없던데 왜 그런가요?

- Chrome은 'Copy selector' 기능이 기본 제공됨.
- Firefox는 기본적으로 제공되지 않음.
- Firefox에서 비슷한 기능을 쓰려면:
  1. **요소 우클릭 → Inspect (검사)**
  2. 개발자 도구에서 해당 요소 우클릭 → "Copy → CSS Selector" 클릭

> 단, 버전에 따라 메뉴명이 다를 수 있으며, 확장 프로그램으로 기능을 추가할 수도 있음.

---

## Q10. Firefox에서 CSS Selector를 복사하려면?

1. 해당 요소 우클릭 → 검사(Inspect)
2. 개발자 도구의 HTML 탭에서 해당 요소 우클릭
3. `Copy → CSS Selector` 선택

이 기능이 없다면 Firefox 버전 확인 또는 [Selector Gadget](https://selectorgadget.com/) 같은 확장기능 사용 가능.

---

## Q11. Firebase key를 GitHub Pages로 배포해도 되는 이유는?

- **API Key 자체는 공개 키**로 간주되어 노출되어도 괜찮음.
- 그러나 읽기/쓰기 권한을 **보안 규칙으로 제한하지 않으면**, 누구나 데이터 수정 가능.

> 핵심은 "Firebase 보안 규칙을 설정했는가?"에 달려 있음.