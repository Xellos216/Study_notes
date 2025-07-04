---

# 03_gh_repo_create.md

# CLI로 GitHub 레포 만들고 초기 커밋 푸시하기

## ✅ 작업 흐름 요약

1. 로컬에서 먼저 Git 저장소 생성
```bash
git init
```

2. README.md 파일 작성 및 첫 커밋
```bash
git add README.md
git commit -m "Add: README.md"
```

3. GitHub CLI로 레포지토리 생성 + 연결 + 푸시
```bash
gh repo create Github_Git_Study --public --source=. --remote=origin --push
```

## ✅ 옵션 설명

| 옵션 | 의미 |
|------|------|
| `--public` | 공개 레포로 생성 |
| `--source=.` | 현재 폴더의 내용을 GitHub에 업로드할 소스로 사용 |
| `--remote=origin` | 자동으로 remote 설정 (git remote add origin ...) |
| `--push` | 커밋된 내용을 GitHub로 즉시 푸시 |

## ✅ 결과
- GitHub에 레포 자동 생성
- 원격(origin) 연결 완료
- 첫 커밋까지 자동 푸시 완료

## ⚠️ 주의
- `gh repo create --source=.` 를 사용하려면 반드시 먼저 `git init` 해야 함

## 💡 추가 팁: git init 시 기본 브랜치를 main으로 고정하려면
- git config --global init.defaultBranch main

---

# 08_gh_repo_CLI.md

# 📁 GitHub CLI 관련 정리 (.gh 사용)

## 1. GitHub CLI로 리포지토리 생성하기

```bash
gh repo create <repo-name> --public
```

옵션:
- `--private`: 비공개 리포로 생성
- `--public`: 공개 리포로 생성
- `--source .`: 현재 디렉토리 기준으로 생성
- `--remote origin`: 원격 저장소 이름 설정
- `--push`: 최초 커밋을 푸시

예시:
```bash
gh repo create Dev_Study --public --source=. --remote=origin --push
```

---

## 2. GitHub CLI로 리포지토리 공개 여부 변경

```bash
# Public → Private
gh repo edit --visibility private

# Private → Public
gh repo edit --visibility public
```

### 주의
- 현재 디렉토리가 해당 리포지토리 루트일 경우만 정상 동작
- 또는 `--repo` 옵션으로 직접 지정 가능:

```bash
gh repo edit --repo Xellos216/Dev_Study --visibility private
```

---

## 3. gh 인증 확인

```bash
gh auth status
```

## 4. gh 로그인 (최초 1회 필요 시)

```bash
gh auth login
```

---

## 5. 참고: Git 명령어로 초기 푸시 흐름

```bash
cd <프로젝트_폴더>
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/<사용자명>/<레포명>.git
git push -u origin main
```

---