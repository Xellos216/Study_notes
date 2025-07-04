---

# 12_git_commit.md

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

---

# 13_git_commit_message.md

# Git 커밋 메시지 수정 및 활용 요약

이번 세션에서는 Git에서 커밋 메시지를 수정하거나 보완하는 여러 방법을 실습했습니다. 아래는 상황별로 사용할 수 있는 명령어와 주의사항을 정리한 내용입니다.

---

## 1. 최근 커밋 메시지 수정

- **명령어**:
  ```bash
  git commit --amend
  ```
- **설명**: 가장 최근 커밋 메시지를 수정합니다. 이미 원격 저장소에 push 한 상태라면 `--force` 푸시가 필요합니다.

---

## 2. 과거 커밋 메시지 수정 (여러 개 중간 커밋 포함)

- **명령어**:
  ```bash
  git rebase -i HEAD~n
  ```
- **설명**: 과거 `n`개의 커밋 중 원하는 커밋의 `pick`을 `reword`로 바꾸어 메시지를 수정합니다. 이후 강제 푸시 필요:
  ```bash
  git push origin main --force
  ```

---

## 3. 변경 사항 없이 커밋 메시지 남기기

- **명령어**:
  ```bash
  git commit --allow-empty -m "원하는 메시지"
  ```
- **설명**: 실제 파일 변경이 없어도 메시지만을 기록하기 위한 "빈 커밋"을 생성합니다.

---

## 4. 파일 내용은 그대로 두고 커밋 메시지만 추가하고 싶을 때

- **명령어**:
  ```bash
  git add 파일명
  git commit --allow-empty -m "보완용 메시지"
  ```
- **설명**: 파일은 변경되지 않았지만 보완용 메시지를 남기고 싶을 때 사용합니다. `--allow-empty` 덕분에 Git은 커밋을 생성합니다.

---

## 5. GitHub에서 파일 옆에 보이는 메시지를 바꾸려면?

- **설명**: GitHub UI의 파일 리스트에 보이는 커밋 메시지는 해당 파일이 "처음 추가된 커밋"의 메시지를 표시합니다.
- 따라서 이 메시지를 바꾸려면, 그 **원래 커밋 자체를 rebase로 수정**해야 합니다.
- 방법:
  ```bash
  git rebase -i HEAD~n
  # 해당 커밋을 reword → 원하는 메시지로 변경
  git push origin main --force
  ```

---

## 6. 강제 푸시 (rebase 또는 amend 후 필요)

- **명령어**:
  ```bash
  git push origin main --force
  ```
- **주의**: 이미 push한 커밋의 히스토리를 바꾸는 것이므로, 협업 중인 저장소라면 꼭 팀원과 공유 후 진행해야 합니다.

---

## ✅ 정리

- 커밋 메시지를 정확히 바꾸려면 `rebase`.
- 단순히 메시지를 추가하고 싶다면 `--allow-empty` 커밋.
- GitHub UI 메시지를 바꾸려면 "처음 추가된 커밋"을 수정해야 함.
- push 이후 커밋 수정을 했을 경우 `--force` 푸시 필수.