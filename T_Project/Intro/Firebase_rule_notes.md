# Firebase 관련 학습 및 실습 정리

---

## 1. Firestore 보안 규칙 설정

### 📌 배경  
초기에는 Firestore 보안 규칙이 모든 사용자에게 `read`, `write` 권한을 허용하는 상태였으며, 이는 의도하지 않은 외부 조작의 위험이 있음.

### 🚨 초기 설정 (보안 미설정 상태)
```js
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /Team_8/{docId} {
      allow read, write: if true;
    }
  }
}
```

- 누구나 인증 없이 데이터를 쓰고 지울 수 있음
- 실서비스에선 **치명적인 보안 취약점**

### ✅ 수정된 설정 (익명 인증 기반 보안 강화)
```js
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /Team_8/{docId} {
      allow read: if true;
      allow write: if request.auth != null;
    }
    match /settings/{docId} {
      allow read, write: if false;
    }
  }
}
```

- 익명 로그인 등으로 인증된 사용자만 쓰기 가능
- settings 컬렉션은 완전 차단 (인증번호 저장용)

---

## 2. Firebase 인증 방식: 익명 로그인 적용

### 🔐 사용 목적
Firestore 쓰기를 위해 `request.auth != null` 조건을 충족시킬 필요가 있음 → 익명 로그인(`signInAnonymously`)을 통해 최소한의 인증 상태 유지

### ✅ 코드 예시
```js
import { getAuth, signInAnonymously } from "firebase/auth";

const auth = getAuth();
signInAnonymously()
  .then(() => console.log("✅ 익명 로그인 완료"))
  .catch((error) => console.error("❌ 로그인 실패:", error));
```

### 🔍 확인 방법
브라우저 콘솔에서 `✅ 익명 로그인 완료` 메시지가 뜨면 정상

---

## 3. 실 서비스에서의 인증 처리 흐름

### 🔄 실행 흐름 요약
1. Firebase 프로젝트 설정 후 익명 로그인 활성화
2. `getAuth() + signInAnonymously()` 실행
3. 인증된 상태에서 Firestore `addDoc`, `updateDoc`, `deleteDoc` 가능
4. 보안 규칙이 인증된 사용자만 쓰기 허용하도록 설정되어야 작동

### ⚠️ 주의
- `signInAnonymously()` 코드를 빠뜨리면 Firestore 쓰기 불가능 (403 에러)
- 로그인 되지 않은 상태에서는 Firestore 쓰기 요청 거부됨

---

## 4. settings 컬렉션 보안 적용 이유

### 🔐 역할
- 인증번호(비밀번호) 등 민감한 설정 저장
- 일반 사용자 노출 필요 없음

### ✅ 보안 규칙
```js
match /settings/{docId} {
  allow read, write: if false;
}
```

- 관리 목적의 설정이므로 완전 차단 처리
- 필요 시 서버 측에서만 접근하는 방식 권장

---

이 정리는 Firebase 실습을 통해 보안 규칙 구성, 인증 흐름, 실무 적용의 기초를 학습한 결과를 기반으로 하며, 익명 인증을 활용한 안전한 Firestore 사용 방식에 초점을 맞춤.
