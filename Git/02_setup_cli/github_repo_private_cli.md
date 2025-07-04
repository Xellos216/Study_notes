# 07_github_repo_private_cli.md

## ✅ 목표

- GitHub 레포지토리를 **웹이 아닌 CLI (`gh`)로 생성**하는 방법 실습
- 레포를 **비공개(private)** 로 설정하여 외부 노출 방지
- CLI 환경에서 레포 생성 + 최초 커밋 + 푸시까지 한번에 처리

---

## 🧭 전제 상황

- 로컬 디렉토리 이름: `Traffix/`
- 해당 프로젝트는 **포트폴리오용**으로 추후 공개 예정이므로, 초기에 비공개로 유지 필요
- 기존에는 GitHub 웹 UI로만 레포를 만들어왔음

---

## 🚀 실습 절차

### 1. 로컬 Git 저장소 초기화
```bash
cd ~/git_repos/Traffix
git init
```

### 2. 초기 커밋 준비
```bash
git add .
git commit -m "초기 커밋: Traffix 프로젝트 시작"
```

### 3. 비공개 레포 생성 및 push
```bash
gh repo create Traffix --private --source=. --remote=origin --push
```

옵션 설명:

| 옵션 | 의미 |
|------|------|
| `--private` | 비공개 레포로 생성 (🔒 외부에서 안 보임) |
| `--source=.` | 현재 폴더의 내용을 GitHub에 업로드할 소스로 사용 |
| `--remote=origin` | 자동으로 원격 설정 (`git remote add origin ...`) |
| `--push` | 커밋된 내용을 즉시 GitHub에 반영 |

---

## 🔐 결과 확인

- GitHub 웹에서 브랜치 오른쪽에 🔒 표시 확인
- 브라우저 자동 실행:
```bash
gh repo view --web
```

---

## 📌 추가 정리

- GitHub에서 기본 브랜치를 `main`으로 설정하는 경우:
```bash
git config --global init.defaultBranch main
```

- 공개 전환은 GitHub 웹사이트 `Settings → Danger zone` 에서만 가능

---

✅ Traffix는 성공적으로 비공개 레포로 생성 및 푸시되었으며, CLI 기반 워크플로우를 처음부터 끝까지 적용함.
