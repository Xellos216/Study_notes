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

