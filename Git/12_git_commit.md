# 12_git_add_vs_commit.md

## ✅ 주제: git add 없이 commit하면 왜 아무 일도 안 일어날까?

---

## 🧭 상황 설명

```bash
git commit -m "Add: 임홍민"
```

→ 그런데 아무 커밋도 발생하지 않고 아래와 같은 메시지가 출력됨:

```
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  modified:   Version_3.html

no changes added to commit (use "git add" and/or "git commit -a")
```

---

## ❗ 원인

Git은 **수정된 파일을 커밋하려면 반드시 먼저 `git add`로 staging** 해야 함.

- `git add` = "이 파일을 커밋할 준비 완료!"
- `git commit` = "staged(추가된) 파일만 커밋하겠다"

따라서 수정만 하고 `add`를 하지 않으면 `commit`이 아무것도 반영하지 않음

---

## ✅ 해결 방법

### 🔹 방법 1: 해당 파일만 스테이징
```bash
git add Version_3.html
git commit -m "Add: 임홍민"
```

### 🔹 방법 2: 수정된 모든 tracked 파일 커밋
```bash
git commit -am "Add: 임홍민"
```

> ⚠️ 단, `-a`는 **추적된(tracked)** 파일만 커밋함  
> → 새로 만든 파일(`git add` 한 번도 안 한 파일)은 포함되지 않음

---

## 🧪 추천 워크플로우

```bash
git status             # 상태 확인
git add .              # 모든 변경 스테이징
git commit -m "메시지" # 커밋
git push               # 푸시
```

또는

```bash
git commit -am "메시지"  # 수정된 파일만 바로 커밋
```

---

## 📝 정리

| 명령어 | 설명 |
|--------|------|
| `git add <file>` | 파일을 커밋 대기(staged) 상태로 전환 |
| `git commit -m` | staged 파일만 커밋 |
| `git commit -am` | 수정된 tracked 파일은 자동 add + 커밋 |
| `git status` | 현재 상태 점검 |

---

✅ 이번 실습에서는 `git add` 없이 commit 했을 때 아무런 변화가 없었던 이유를 이해하고,  
올바른 커밋 흐름을 다시 정리했다.
