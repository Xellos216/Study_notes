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

