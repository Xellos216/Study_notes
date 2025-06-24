# 🧑‍💻 WSL + GitHub 통합 리포 정리 과정

## ✅ 1. 어떤 문제였는가?

GitHub 리포지터리에서 `2025-06-05_Python` 폴더에 접속하려 하자 다음과 같은 오류가 발생했습니다:

> 404 - page not found

- 로컬에는 파일이 존재하지만 GitHub에서 해당 디렉토리가 보이지 않음
- `git status` 상에서는 변경 사항도 없고 clean 상태였음

## ✅ 2. 어떻게 해결했는가?

문제의 원인은 `2025-06-05_Python` 디렉토리 안에 **`.git` 폴더가 포함되어 있었던 것**입니다.

### 🪓 문제 해결 단계 요약

1. `Practice_1.py is in submodule` 에러 발생 → **Git은 이 폴더를 'submodule'로 인식 중**
2. 실제로는 다른 리포를 통합하면서 `.git` 폴더까지 들어와 버린 것
3. 다음 절차로 해결:

```bash
# 1. 서브모듈 제거 (Git의 추적 대상에서 삭제)
git rm --cached 2025-06-05_Python

# 2. 폴더 내부의 .git 제거 (서브모듈 인식 원천 제거)
rm -rf 2025-06-05_Python/.git

# 3. 일반 폴더로 다시 추가 및 푸시
git add 2025-06-05_Python
git commit -m "Fix: remove submodule and add as normal folder"
git push origin main
```

4. 이후 GitHub에서 정상적으로 디렉토리 및 파일 확인됨

## ✅ 3. 등장한 개념 정리

| 개념 | 설명 |
|------|------|
| **Submodule** | Git 리포 안에 또 다른 Git 리포를 포함시키는 기능. `.git` 폴더가 내부에 있을 때 자동으로 인식됨 |
| **Working tree clean** | 현재 로컬 상태와 Git이 추적하는 상태가 동일함을 의미 |
| **git rm --cached** | 파일 또는 폴더를 **로컬에서는 유지하되 Git의 추적에서는 제거** |
| **rebase** | 원격 변경 사항을 깔끔하게 현재 브랜치 위로 얹는 Git의 통합 전략 |
| **404 GitHub 디렉토리 에러** | GitHub에는 폴더 자체를 올리지 않음. 내부 파일이 Git에 의해 추적되지 않으면 폴더도 표시되지 않음 |

---

📅 정리일: 2025-06-11
