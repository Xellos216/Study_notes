---

# 16_pull_request_issue.md

# Pull Request vs Issue (GitHub 협업 흐름 정리)

GitHub에서 협업 시 사용하는 대표적인 두 기능인 **Pull Request (PR)**와 **Issue**의 차이점과 실제 협업 흐름을 정리한 문서입니다.

---

## ✅ Pull Request (PR)

- **목적**: 코드 변경 사항을 리뷰 및 병합 요청
- **사용 시점**: 기능 브랜치에서 작업을 마친 뒤 `main` 등에 병합하고 싶을 때
- **기능 요약**:
  - 코드 리뷰 요청 가능
  - 리뷰어 지정 가능
  - 병합(Merge) 시점 제어 가능
  - 특정 Issue를 닫도록 연결 가능 (`Closes #1`)

---

## ✅ Issue

- **목적**: 해결해야 할 작업, 버그, 의문점 등을 기록하고 추적
- **사용 시점**: 작업을 시작하기 전에 해야 할 일을 목록화할 때
- **기능 요약**:
  - 각 항목에 번호(#) 부여
  - 할당자, 라벨, 마일스톤 지정 가능
  - 코드 변경 없이도 아이디어/의문점만 등록 가능
  - PR과 연결되어 자동 종료 가능

---

## 🧩 두 기능의 관계

| 구분 | Issue | Pull Request |
|------|-------|--------------|
| 목적 | 작업 요청 | 작업 결과 제안 |
| 내용 | 해야 할 일 | 실제 코드 변경 |
| 예시 | API 키 분리 필요 | API 키 분리 기능 구현 |
| 연결 방법 | PR에서 `Closes #이슈번호`로 참조 | 자동으로 이슈 닫힘 |

---

## 📌 현재 상황

- ✅ **PR #2**: `수정사항 반영+주석 추가`  
  → 실제 코드 변경이 반영된 PR (리뷰 및 병합 전 상태)

- ✅ **Issue #1**: `APIkey 분리, 의문점 TODO로 정리`  
  → 해결해야 할 할 일과 의문점 목록 (작업 전 정리용, 아직 열린 상태)

---

## 🔜 다음에 해야 할 일 (실무 흐름)

1. **PR 리뷰 진행**  
   - 리뷰어가 코드를 확인하고, 필요 시 코멘트
   - 충돌(conflict)이 발생했으므로 먼저 `Resolve conflicts` 필요

2. **코드 수정 후 재커밋**  
   - 충돌 해결 및 코멘트 반영 후, 다시 커밋/푸시

3. **PR 병합(Merge)**  
   - 리뷰 통과되면 병합 → 관련된 Issue 자동 종료 (`Closes #1` 명시했을 경우)

4. **Issue 정리**  
   - PR에서 해결한 이슈는 수동 또는 자동으로 닫힘

---

---

# 17_merge_conflict_and_linking.md

# 17. Merge Conflict 확인 & PR-Issue 연결 흐름 정리

GitHub에서 협업할 때 자주 겪는 상황인 **병합 충돌(Conflict)** 확인 방법과,  
**Pull Request와 Issue를 자동으로 연결하는 방법**에 대해 한 문서로 정리합니다.

---

## 🔍 Part 1. Merge Conflict 여부 확인

### ✅ 병합 대상 확인 방법

Pull Request 화면 상단에서 다음과 같이 표시됩니다:

> `user wants to merge N commits into main from feature-branch`

| 항목 | 의미 |
|------|------|
| `main` | 병합 대상 브랜치 (기준 브랜치, base) |
| `feature-branch` | 작업한 브랜치 (변경 내용이 있는 브랜치, compare) |

---

### ✅ 병합 충돌 발생 여부 확인

- GitHub PR 화면 중간에 다음 메시지가 뜸:

| 메시지 | 의미 |
|--------|------|
| ✅ `No conflicts with base branch` | 충돌 없이 병합 가능 |
| ❌ `This branch has conflicts that must be resolved` | 병합 전에 충돌 해결 필요 |

---

### ✅ 충돌 시 로컬에서 해결하기

```bash
git checkout main
git pull origin main
git checkout feature-branch
git merge main         # 이때 충돌 발생 가능
# 충돌 해결 후
git add .
git commit -m "Resolve conflict"
git push origin feature-branch
```

---

## 🔗 Part 2. PR과 Issue 자동 연결 방법

### ✅ PR에서 Issue 자동 종료시키기

PR 본문에 다음과 같이 작성:

```md
Closes #이슈번호
Fixes #3
Resolves #1
```

→ PR이 **병합(Merge)** 되면 해당 이슈는 자동으로 닫힘

---

### ✅ 자동 닫힘 확인 포인트

- PR을 열 때 본문에 `Closes #3`가 포함되어야 함
- PR이 merge된 후, 이슈 상태가 **Closed**로 전환됨

---

### ✅ 연결 안 했으면 수동으로 닫기

- GitHub > Issue > `Close issue` 클릭

---

## 📌 실무에서의 추천 흐름

1. 작업 전 `Issue`를 생성해 해야 할 작업 정의
2. 기능 브랜치에서 작업 후 `PR` 생성
3. PR 설명에 `Closes #이슈번호` 명시
4. PR Merge 시 자동으로 연결된 Issue 닫힘
5. 안 닫히면 수동 확인 후 정리

---