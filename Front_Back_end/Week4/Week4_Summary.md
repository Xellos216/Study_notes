# 📘 Week 4 Summary: Firebase & Firestore 기초

## ✅ 1. 4주차 개요
- 이제까지 만든 프론트엔드에 **백엔드 연결**을 시작.
- 백엔드는 사용자의 요청을 받고 응답을 주는 서버 영역이며, 이번 주차에서는 **Firebase 기반 백엔드**를 다룸.
- 프론트엔드: HTML, CSS, JS
- 백엔드: SERVER, DB, API

---

## ✅ 2. Firebase 시작하기
- Firebase는 **Google이 제공하는 서버리스 백엔드 플랫폼**.
- 서버를 직접 만들지 않아도, 웹 서비스를 출시 가능.
- 프론트엔드 코드만으로도 백엔드 기능을 사용할 수 있음.
- 구성:
  - 개발 코드 1: 프론트엔드 → 서버로 데이터 전송
  - 개발 코드 2: 서버(파이어베이스) → DB 저장

---

## ✅ 3. 데이터베이스 개념
- 데이터베이스(DB)란? 데이터를 잘 **보관/검색**하기 위해 정리하는 공간.
- 데이터베이스는 크게 두 가지로 나뉨:
  - 관계형 데이터베이스(SQL): 정형 데이터, 은행/대기업
  - 비관계형 데이터베이스(NoSQL): 유연한 구조, 스타트업
- 이번 실습에서는 **클라우드 NoSQL DB인 Firestore** 사용

---

## ✅ 4. Firestore Database 시작하기
- Firestore는 Google의 **NoSQL 클라우드 데이터베이스**.
- 구성 개념:
  - **Collection**: 문서들의 모음 (예: albums)
  - **Document**: 한 개의 데이터 단위 (예: 앨범 1개)
  - **Field**: 문서 내 데이터 속성 (예: title, content, date)

```js
// Firestore 초기 세팅 코드 요약
import { initializeApp } from "firebase/app";
import { getFirestore, collection, addDoc, getDocs } from "firebase/firestore";

const firebaseConfig = {
  // 설정 정보
};

const app = initializeApp(firebaseConfig);
const db = getFirestore(app);
```

---

## ✅ 5. Firestore에 데이터 넣기 (`addDoc`)
- 사용자 입력을 받아 Firestore DB에 저장
- 입력 필드: 앨범 이미지, 제목, 날짜, 내용
- 저장 성공 시 `alert()` 메시지 표시
- 저장 후 새로고침: `window.location.reload()`

---

## ✅ 6. Firestore에서 데이터 가져오기 (`getDocs`)
- `getDocs` 함수로 Firestore의 데이터를 읽어옴
- 가져온 데이터를 HTML 카드 형태로 동적 생성
- 카드에 삽입할 정보: 이미지, 날짜, 제목, 내용
- HTML에서 카드 구조를 미리 만들고, `append`로 붙임
- **형식이 다른 document**는 필터링해서 제외


---

## ✅ 7. 기능 정리: 앨범 카드 불러오기 전체 흐름

- **첫 번째:** Firebase 설정 및 Firestore 세팅 완료
- **두 번째:** 사용자가 입력한 데이터를 변수에 담고, Firestore에 저장 (`addDoc`)
- **세 번째:** Firestore에서 데이터를 읽고 (`getDocs`), HTML 카드로 구성하여 브라우저에 표시

전체 흐름:
프론트엔드 → Firebase → Firestore  
FireStore에서 다시 프론트로 데이터 반환 → HTML 카드로 렌더링
