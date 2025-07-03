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