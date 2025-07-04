# GitHub CLI 명령어 기반 GitHub 관리 워크플로우

## ✅ 기본 환경
- OS: Ubuntu or Parrot
- 인증 방식: SSH
- CLI 툴: `git`, `gh`

---

## 🧭 핵심 명령어 흐름

### 🔐 인증

```bash
gh auth login
gh auth status
```

### 📦 레포 생성

```bash
git init
gh repo create [레포명] --public --source=. --remote=origin --push
```

### 🔄 커밋 & 푸시

```bash
git add .
git commit -m "설명"
git push
```

### 🌐 웹에서 열기

```bash
gh repo view --web
```

---

## 🌿 PR 및 브랜치 흐름

```bash
git checkout -b feature/login
git push -u origin feature/login

gh pr create --base main --head feature/login --title "로그인 기능" --body "내용"
gh pr view --web
```

---

## 🧼 기타 관리 명령

```bash
gh repo list
gh issue list
gh pr list
gh repo delete 사용자명/레포명 --confirm
```

---

## 📌 상황별 워크플로우 요약

| 작업 목적 | 추천 명령어 |
|-----------|-------------|
| 새 레포 만들고 첫 푸시 | `gh repo create ... --source=. --push` |
| PR 생성 및 웹 확인 | `gh pr create`, `gh pr view --web` |
| GitHub 없이 CLI만으로 사용 | 가능, `gh`로 대부분 대체 |

---
