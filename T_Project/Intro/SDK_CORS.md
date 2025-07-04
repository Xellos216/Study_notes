
# Firebase Storage, CORS, fetch() 그리고 관련 구성요소 정리

## 📦 1. Google Cloud SDK란?

### ✅ 개념
Google Cloud SDK는 Google Cloud Platform(GCP)의 리소스들을 명령어 기반으로 관리할 수 있도록 해주는 도구 모음이다. 설치하면 터미널에서 다음과 같은 명령어를 사용할 수 있게 된다:
- `gcloud`: GCP 프로젝트 생성, Firebase 초기화, IAM 설정 등
- `gsutil`: Firebase Storage(Cloud Storage)의 파일 업로드/다운로드/CORS 설정
- `bq`: BigQuery 쿼리 실행 (데이터 분석용)

### 💡 비유
- Google Cloud는 ‘클라우드 창고’라면,
- SDK는 그 창고를 관리하는 관리자 리모컨이다.
- 창고 문을 열거나, 파일을 넣고 빼거나, 설정을 바꾸려면 이 리모컨이 필요하다.

---

## 🪣 2. Firebase Storage와 버킷(bucket)

### ✅ 개념
Firebase Storage는 이미지, 영상 등의 **파일을 저장**하는 클라우드 서비스이고, `버킷(bucket)`은 그 저장 공간의 단위이다. 하나의 Firebase 프로젝트에는 보통 하나의 기본 버킷이 생성된다.

### 🔗 버킷 주소 예시
- 예: `sparta-162c6.firebasestorage.app`
  - `sparta-162c6`: Firebase 프로젝트 ID 또는 버킷 이름
  - `.firebasestorage.app`: Firebase에서 제공하는 기본 도메인

### 💡 비유
버킷은 온라인에 있는 ‘사진첩’ 또는 ‘파일 양동이’이다. 
- 우리는 여기에 이미지, 프로필 사진 등을 넣고
- 웹페이지에서는 이 양동이에 들어 있는 파일을 꺼내 사용한다.

---

## 🔐 3. cors.json이란?

### ✅ 개념
`cors.json`은 **CORS (Cross-Origin Resource Sharing)** 설정을 담은 파일이다.

웹페이지가 자신의 도메인(origin) 이외의 주소에서 데이터를 요청할 경우, 브라우저는 보안상 해당 요청을 차단할 수 있다. 이를 방지하기 위해, 서버(=Firebase Storage)는 특정 출처(origin)로부터 오는 요청을 허용한다고 미리 설정해야 한다.

### 💡 비유
버킷에 출입 허가증을 붙이는 것과 같다. `cors.json`은
- 어떤 사이트(origin)가
- 어떤 방식(method)으로
- 얼마 동안(maxAge) 요청해도 되는지를
미리 정의해 둔 허가증이다.

### ✅ 예시

```json
[
  {
    "origin": ["https://xellos216.github.io"],
    "method": ["GET", "POST", "PUT"],
    "maxAgeSeconds": 3600
  }
]
```

→ 이 설정은 `https://xellos216.github.io`에서 오는 GET, POST, PUT 요청을 허용한다.

---

## ⚙️ 4. 명령어: `gsutil cors set cors.json gs://sparta-162c6.firebasestorage.app`

### ✅ 설명
- `gsutil`: Firebase Storage 관리 명령어
- `cors set cors.json`: cors.json의 내용을 해당 버킷에 적용
- `gs://...`: GCS에서 사용하는 버킷 경로 형식

즉, 이 명령어는 해당 버킷에 출입 허가증(cors.json)을 붙여주는 행동이다.

---

## 🔁 5. 내 코드에 fetch()는 없는데, 왜 CORS가 필요했을까?

### ✅ 답: Firebase SDK 함수 내부에서 **fetch를 사용**하고 있기 때문이다.

### 📌 코드 예시
```javascript
const snapshot = await uploadBytes(storageRef, file);
const url = await getDownloadURL(snapshot.ref);
```

- `uploadBytes(...)`: 파일을 Firebase Storage에 업로드 (내부적으로 fetch 또는 XMLHttpRequest 사용)
- `getDownloadURL(...)`: 업로드한 파일의 공개 URL을 받아옴 (내부적으로 HTTP GET 요청 발생)

### 💡 정리
- 브라우저는 `xellos216.github.io` → `firebase storage`로 요청이 가면 무조건 CORS를 검사한다.
- Storage가 사전에 “이 도메인은 허용”이라는 설정이 없다면 → CORS 에러 발생.
- 따라서 `fetch()`를 **직접 쓰지 않아도**, Firebase SDK를 통해 Storage를 사용하면 CORS 설정이 반드시 필요하다.

---

## 📌 Firestore와 Firebase Storage 차이

| 항목 | Firestore | Firebase Storage |
|------|-----------|------------------|
| 역할 | 구조화된 데이터 저장 (NoSQL DB) | 이미지, 파일 등 큰 파일 저장소 |
| 비유 | 구글 시트, Excel | 구글 드라이브 |
| 예시 | 사용자 이름, MBTI, 자기소개 등 | 프로필 이미지, 커버 사진 등 |
| 관련 함수 | `getFirestore`, `collection`, `addDoc` 등 | `getStorage`, `uploadBytes`, `getDownloadURL` 등 |

---

## ✅ 최종 요약

- `Google Cloud SDK`는 클라우드 작업을 명령어로 하기 위한 도구 모음이다.
- `Firebase Storage`의 버킷은 클라우드 파일 저장소다.
- `cors.json`은 외부 도메인에서 Storage에 접근할 수 있도록 허용해주는 설정이다.
- `gsutil cors set` 명령은 그 설정을 실제 버킷에 적용하는 과정이다.
- 직접 fetch()를 쓰지 않아도 Firebase의 SDK가 내부적으로 fetch를 사용하므로, CORS 설정은 꼭 필요하다.

