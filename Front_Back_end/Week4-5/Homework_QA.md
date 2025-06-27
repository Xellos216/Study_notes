# Firebase 연동 코드 비교: 정상 작동 vs 비정상 작동

## ✅ 1. 공통 구조
- 모두 Firebase Firestore 사용
- `<script type="module">`로 Firebase SDK 9.x ES Module 방식 도입
- Firestore의 `collection()`, `getDocs()`, `addDoc()` 사용

---

## ✅ 2. 첫 번째 코드 (`나만의 추억 앨범`)
- **즉시 실행 async 함수 없음**: `await getDocs()`가 모듈 최상단에 위치
  - ✅ ES Module 스코프에서는 허용됨
- **버튼 클릭 이벤트**가 `$('#postingbtn').click()`로 DOM 렌더링 후 등록됨
- **입력값 필드의 id와 이벤트 핸들러가 일치** (예: `#image`, `#title`, `#content`, `#date`)
- **카드 append 대상(`id="card"`)이 명확히 존재**
- ✅ 결과적으로 Firebase에서 데이터 읽기/쓰기 모두 정상 작동

---

## ❌ 3. 두 번째 코드 (`푸드파이터`)
- **`async () => { ... }` 함수가 실행되지 않음**
  - ❌ 선언만 있고 즉시 실행하지 않아 `getDocs()`도 호출 안 됨
- **카드 출력 대상(`.row-cols-3`)에 id 없음**, 입력란과 혼동될 가능성 존재
- **이벤트 핸들러 내에서 HTML 요소 ID 불일치**
  - 예: `#floatingInput`, `#foodTitle`, `#floatingTextarea` → 코드에서는 `title_input`, `comment_input`로 예상
- **Firebase 설정 객체 미기입 상태**
- **카드 HTML 생성 로직(`tempHtml`)이 정의되지 않은 채 append만 호출됨**

---

## ✅ 4. 결론
| 항목 | 첫 번째 코드 | 두 번째 코드 |
|------|--------------|--------------|
| `await` 위치 | 모듈 최상단 허용 위치 | ❌ 실행되지 않는 함수식 |
| 카드 append 대상 | `id="card"` 존재 | ❌ 대상 명확하지 않음 |
| 이벤트 바인딩 | jQuery → DOM 렌더 후 실행 | ❌ 바인딩 전 DOM 로드 여부 불확실 |
| 필드 ID 일치 | ✅ 모두 일치 | ❌ 코드와 HTML 불일치 |
| Firebase 설정 | ✅ 존재 | ⚠ 미입력 상태 (주석처리됨) |
| 카드 출력 | 정상 출력 | 실패 |

---

## ✅ 5. 개선 팁
- 모듈 스코프에서는 `await` 사용 가능하지만 **즉시 실행 async 함수**로 감싸는 것이 안전
- 입력 필드의 `id`와 JS 코드가 반드시 **1:1 매칭**되어야 함
- `.append()` 대상은 **입력 form이 아닌, 카드 리스트 전용 container**여야 함
- Firebase 설정이 없으면 `initializeApp()`에서 런타임 오류 발생
