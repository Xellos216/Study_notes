# 2025.6.8 Git & GitHub 기초 실습 정보 정리

## 학습 가능 내용
- Git 버전관리 기능 이해
- Git CLI의 기본 명령어 실습
- GitHub에서 원격 저장소와 연동, push 실습
- .gitignore 파일 방지
- README.md 작성을 통해 보관적인 프로젝트 설명 담기
- 브랜치 만들고 치고, PR통해 버전 읽기, 충돌 테스트

---

## 1. 로컬 저장소 생성 과 기능 실습
```bash
mkdir git-practice
cd git-practice
git init
echo "# Git 어느 것" > README.md
git add README.md
git commit -m "처음 세트 작성"
```

## 2. GitHub에서 원격 저장소 생성 및 연결
```bash
gh repo create git-practice --public --source=. --remote=origin --push
```
> 필요없이 gh CLI 설치 및 연결 해석 방법 실습

---

## 3. .gitignore 실습
```bash
echo "mysecret.txt" > mysecret.txt
echo "mysecret.txt" > .gitignore
git add .
git commit -m ".gitignore 설정"
git push
```
> GitHub에서 mysecret.txt가 올라가지 않음 확인

## 4. README.md 작성 및 push
```markdown
# Git 어느 프로젝트
- Git init, add, commit, push
- .gitignore 사용
- Markdown 문서 작성 실습
```
```bash
git add README.md
git commit -m "README.md 내용 추가"
git push
```

---

## 5. 브랜치와 PR에 대한 기능 이해

### 생각 항목 정리
- “브랜치”는 Git에서 수정되는 개발 건의 ‘가상 가지’와 같은 것
- 만들어서 다수의 방향으로 수정 한 후 버전되는 main에 합칠 수 있다
- GitHub에서 PR(Pull Request)를 생성하면 같이 활동하는 팀원이 모두 수정 탐사가다 가능
- 메인에 읽기적으로 버전을 추가하면, 고침 버전 역시도 당장 볼 수 있다

### 사용된 브랜치 실습 흐름
```bash
# 기준 브랜치
 git checkout -b conflict-base

# 각 브랜치별 내용 추가
 git checkout -b conflict-main
 git commit -m "main 등장 수정"

 git checkout conflict-base
 git checkout -b conflict-branch
 git commit -m "conflict-branch 수정"

# 충돌 유도
 git checkout conflict-main
 git merge conflict-branch    # 충돌 발생
```

### 충돌 해결
```bash
# <<<<<<<, =======, >>>>>>> 보고 수정
 git add README.md
 git commit -m "충돌 해결"
```

---

## 6. GitHub에 push 및 PR 생성
```bash
git push --set-upstream origin conflict-main
```
> GitHub 웹에서 Compare & pull request 클릭 → 내용 작성 → Create PR

병합 후 GitHub에서 PR 페이지에 `Merged` 표시 모음

---

## 7. 브랜치 목록 확인 및 삭제
```bash
# 브랜치 목록 확인
 git branch          # 로컬
 git branch -r       # 원격
 git branch -a       # 전체

# 브랜치 삭제
 git branch -D conflict-test conflict-base conflict-branch conflict-main feature/update-readme
 git push origin --delete conflict-test conflict-base conflict-branch conflict-main feature/update-readme
```

---

## 모든 명령어 정리
```bash
# 초기화
mkdir git-practice
cd git-practice
git init

echo "내용" > 파일명
git add .
git commit -m "메시지"

# 원격 연결 & 푸시
gh repo create ...
git remote add origin URL
git push -u origin main

# 브랜치
git checkout -b 브랜치명
git branch -d/-D 브랜치명
git push origin --delete 브랜치명

# 병합 및 충돌 해결
git merge 브랜치명
(수정 후)
git add 파일명
git commit -m "충돌 해결"

# 로그
 git log --oneline --graph --all
```

---

## 정리 메모
- 브랜치는 협업을 위한 독립된 실험 공간이다
- main 브랜치 보호를 위해 별도 브랜치에서 작업 후 병합
- 충돌은 같은 줄을 다르게 수정할 때 발생하며, 수동 해결이 필요
- PR은 협업 커뮤니케이션 도구이자 코드 변경 승인 절차이다
- 병합 후엔 브랜치를 수동 삭제하여 저장소를 깔끔하게 유지할 수 있다

---

## 8. 에러 사례 및 해결법: push 오류

### ❗ 발생한 에러 메시지
```bash
! [rejected]        main -> main (fetch first)
error: failed to push some refs to 'https://github.com/Xellos216/git-practice.git'
hint: Updates were rejected because the remote contains work that you do not have locally.
```

### ✅ 원인
- 원격 저장소(GitHub)의 `main` 브랜치가 로컬보다 더 최신 상태임
- 즉, GitHub에서 직접 파일을 수정했거나 PR이 merge된 후 로컬에서 `pull` 없이 `push`를 시도한 경우

### 🛠️ 해결 방법
```bash
git pull --rebase origin main
git push origin main
```

- `pull --rebase`: 원격 변경사항을 내 변경 위로 얹음 (히스토리 깔끔하게 유지)
- 이후 push가 정상적으로 동작함

### 🔁 왜 rebase를 사용하는가?
- 일반 `pull`은 merge 커밋이 생김
- `--rebase`는 커밋을 직렬로 정리해 히스토리가 깔끔하게 유지됨

---

