# GitHub CLI 설치 및 SSH 인증 과정 정리

## ✅ GitHub CLI 설치

```bash
sudo apt update
sudo apt install gh
```

## ✅ `gh auth login` 단계별 흐름

1. `gh auth login` 실행
2. 로그인할 도메인 선택 → 기본은 `GitHub.com`
3. Git 작업용 프로토콜 선택
   - `HTTPS`: 간편하지만 토큰 인증 필요
   - `SSH`: 키페어 기반, 자동화에 적합
4. SSH 공개키 자동 업로드 (`~/.ssh/id_ed25519.pub`)
   - GitHub에 이미 등록되어 있으면 `Skip`

## ✅ 인증 방식 선택

- `Login with a web browser`: 권장
   - 브라우저 열리고 1회 코드 입력으로 인증됨
- `Paste an authentication token`: 수동 토큰 입력

## ✅ 로그인 확인

```bash
gh auth status
```

### 예시 출력
```
✓ Logged in to github.com as Xellos216
✓ Git operations for github.com configured to use ssh protocol
✓ Token: ***********
```

## ✅ 인증 후 가능한 명령 예시
- `gh repo create`
- `gh repo view --web`
- `gh pr create`, `gh issue list`
