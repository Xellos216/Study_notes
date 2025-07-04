# GitHub Pages (`.github.io`) vs GitHub Repository 정리

## 1. GitHub Repository란?

- 주소 예시: `https://github.com/사용자명/레포명`
- 용도: 코드, 마크다운 파일, 프로젝트 버전 관리
- 특징:
  - `.md` 파일로 정리한 학습 노트, 코드 등을 저장
  - 개발자 친화적인 인터페이스
  - 폴더/파일 구조 기반
- 대표 활용 예시:
  - `Day1_Summary.md`, `Day2_QA.md`, `README.md` 등 학습 정리
  - 코드 실습 기록 및 제출용 저장소

---

## 2. GitHub Pages란? (`https://username.github.io`)

- 용도: 정적 웹사이트 호스팅 (포트폴리오, 블로그 등)
- 보여지는 형식: `.md`나 `.html` 파일을 웹사이트처럼 보여줌
- 특징:
  - 일반 사용자도 보기 쉬운 UI (HTML 스타일 렌더링)
  - 테마 설정 가능 (`jekyll` 기반)
- 주소 예시:
  - `https://Xellos216.github.io`

---

## 3. 두 방식의 차이

| 항목 | GitHub Repository | GitHub Pages (`.io`) |
|------|-------------------|------------------------|
| 접근 방식 | 코드/문서 중심 | 웹사이트처럼 보임 |
| 대상 | 개발자 중심 | 일반인 포함 누구나 보기 쉽게 |
| 커스터마이징 | 거의 없음 | 테마, 레이아웃 설정 가능 |
| 활용 목적 | 코드 저장, 실습 공유 | 포트폴리오, 발표용 정리 등 |

---

## 4. GitHub Pages 사용 방법 (개념 요약)

### 1) 전용 레포 만들기
- 이름: `username.github.io`
- 예: `Xellos216.github.io`

### 2) 파일 준비
- HTML 파일 또는 `.md` 파일 + Jekyll 설정
- 가장 간단한 형태는 `index.html` 하나만 있어도 작동

### 3) Pages 설정
- 레포에서 `Settings > Pages` 이동
- `Deploy from a branch` → 보통 `main` 선택
- 저장하면 자동 배포

### 4) 테마 설정 예시 (`_config.yml` 파일)
```yml
theme: jekyll-theme-minimal
title: Xellos216's Notes
description: 코딩캠프 실습 정리


---

다음은 위에서 설명한 내용을 `.md` 파일로 저장하기 적합한 **Markdown 형식**입니다.
파일 이름은 예를 들어 `Git_Core_Commands.md` 또는 `git_핵심명령어정리.md`로 저장하면 좋습니다.

```markdown


# 📘 Git 핵심 명령어 정리

---

## ✅ 1. `git pull`: 원격 변경사항을 로컬로 가져와 병합

### 🔹 정의
원격 저장소의 변경 사항을 **가져오고(fetch)**, **현재 브랜치와 병합(merge or rebase)** 하는 명령어

### 🔹 내부 동작
```

git pull = git fetch + git merge

```

### 🔹 주요 특징
- 병합 또는 재배치 방식으로 로컬과 원격의 커밋 이력을 통합
- 로컬 변경사항은 자동 삭제되지 않음
- 충돌(conflict) 발생 시 직접 해결 필요

---

## 🔁 2. `git reset`: 커밋 기록 또는 작업 디렉토리를 과거 상태로 되돌림

### 🔹 정의
브랜치 포인터(head)를 이전 커밋으로 되돌리거나,  
작업 내용 자체를 되돌리는 명령어

### 🔹 주요 옵션

| 옵션 | 설명 |
|------|------|
| `--soft`  | 커밋만 취소, 파일은 staging 상태 유지 |
| `--mixed` | 커밋 + staging 취소 (기본값) |
| `--hard`  | 커밋 + staging + 작업파일까지 모두 되돌림 (위험) |

### 🔹 예시
```

git reset --hard HEAD\~1

```

---

## ↩️ 3. `git revert`: 특정 커밋의 반대 변경을 새 커밋으로 적용

### 🔹 정의
이전 커밋을 취소하지 않고,  
그 반대 동작을 **새로운 커밋**으로 생성하여 롤백

### 🔹 예시
```

git revert HEAD

```

### 🔹 특징
- 히스토리를 보존하며 안전하게 되돌림
- 협업 중일 때 적합

---

## 🔀 4. `git merge`: 두 브랜치의 변경사항을 하나로 합침

### 🔹 정의
현재 브랜치와 다른 브랜치의 변경사항을 병합

### 🔹 예시
```

git checkout main
git merge feature/login

```

### 🔹 결과
- 병합 커밋 생성됨
- 커밋 이력이 분기 구조를 유지함

---

## 🔁 5. `git rebase`: 커밋 이력을 선형으로 재정렬

### 🔹 정의
특정 브랜치의 커밋을 **다른 브랜치의 마지막 커밋 뒤로 다시 적용**

### 🔹 예시
```

git checkout feature
git rebase main

```

### 🔹 merge vs rebase 비교

| 항목 | `merge` | `rebase` |
|------|---------|----------|
| 이력 모양 | 병합 커밋 포함 (분기) | 선형 정리 |
| 원래 커밋 보존 | O | X (새 커밋 생성) |
| 협업 추천도 | 안전 | 위험 (공유 커밋에 사용 X) |

---

## 📥 6. `git stash`: 작업 중인 변경사항을 임시로 숨김

### 🔹 정의
아직 커밋하지 않은 변경사항을 **임시 저장(stash)** 하고,  
작업 디렉토리를 깨끗한 상태로 되돌림

### 🔹 예시
```

git stash           # 임시 저장
git stash list      # stash 목록 보기
git stash pop       # 가장 최근 stash 복원

```

### 🔹 특징
- 브랜치 전환 전에 임시 보관할 때 유용
- 여러 개 쌓아두고 개별 복원도 가능

---

## 🧾 전체 비교 요약

| 명령어 | 핵심 기능 | 위험도 | 히스토리 보존 | 주요 사용 목적 |
|--------|-----------|--------|----------------|----------------|
| `pull`  | 원격과 병합 | 낮음  | O | 최신 동기화 |
| `reset` | 커밋/작업 되돌림 | 높음 (`--hard`) | X (옵션에 따라) | 강제 롤백 |
| `revert`| 반대 커밋 생성 | 낮음  | O | 안전한 롤백 |
| `merge` | 브랜치 병합 | 보통  | O | 기능 통합 |
| `rebase`| 커밋 재배치 | 중간~높음 | X | 깔끔한 이력 정리 |
| `stash` | 변경사항 임시 저장 | 없음 | N/A | 작업 보류 |

---

```

---

```markdown
# Git SSH 및 파일 이름 변경 관련 오류 정리 (QA)

---

## ❓ Q1: `git push` 했더니 이런 오류가 났어요.

```

[git@github.com](mailto:git@github.com)\:Xellos216/SQL.Study.git does not appear to be a git repository
fatal: Could not read from remote repository.

```

### ✅ A1: 원인은 **레포지토리 주소 오타**예요.

- `SQL.Study.git`처럼 **`.`(dot)** 을 사용했는데,
- 실제로 만든 레포는 `SQL_Study.git` (**언더바 `_`**)였어요.
- GitHub은 `.`, `_`, `-`를 **완전히 다른 문자**로 취급해요.
  → 이름이 정확히 일치해야만 동작함.

---

## ❓ Q2: 그럼 이 오류는 왜 생기는 거예요?

```

fatal: Could not read from remote repository.
Please make sure you have the correct access rights and the repository exists.

````

### ✅ A2: 보통 이 오류는 두 가지 중 하나 때문에 발생해요.

1. **레포지토리 이름이 잘못되었거나 존재하지 않음**
2. **SSH 인증에 실패했을 경우**

→ 이번에는 SSH 인증은 성공했고, **URL 오타**가 원인이었어요.

---

## ✅ Q3: 해결 절차는 어떻게 되나요?

1. 기존 리모트 삭제:
```bash
git remote remove origin
````

2. 정확한 주소로 다시 등록:

```bash
git remote add origin git@github.com:Xellos216/SQL_Study.git
```

3. 푸시:

```bash
git push -u origin main
```

---

## ✅ Q4: SSH 인증은 어떻게 확인하나요?

```bash
ssh -T git@github.com
```

출력 예시:

```
Hi Xellos216! You've successfully authenticated...
```

---

## ❓ Q5: 로컬에서 `Bootcamp_Prestudy_2.md` 파일 이름을 바꿨는데,

푸시한 뒤에도 **원격에 예전 파일(`Bootcamp_Prestudy_2.md`)이 남아있는 이유는 뭔가요?**

### ✅ A5: Git은 **파일 이름 변경을 추적하려면** `git mv`나 `git rm + git add`를 통해

**명시적으로 변경 사실을 알려줘야** 합니다.

* 단순히 파일명을 OS에서 바꾸기만 하면 Git은 다음처럼 해석합니다:

  * "새 파일이 생겼군." (`Bootcamp_Prestudy.md`)
  * "하지만 이전 파일은 삭제됐다는 신호를 못 받았네?" → 그대로 남겨둠

---

## ✅ Q6: 이름 변경이 제대로 반영되도록 하려면?

### 방법 1: 이름 바꾸기 전에 Git에게 직접 알려주기 (권장)

```bash
git mv Bootcamp_Prestudy_2.md Bootcamp_Prestudy.md
git commit -m "Rename file"
git push
```

### 방법 2: 이미 이름을 바꿨다면

```bash
git add Bootcamp_Prestudy.md
git rm Bootcamp_Prestudy_2.md
git commit -m "Rename file manually"
git push
```

---

## 🧠 요약

| 항목               | 설명                                            |
| ---------------- | --------------------------------------------- |
| SSH 인증 오류        | 실제로는 URL 오타가 원인이었음                            |
| Git에서 이름 바꾸기     | `git mv` 또는 `git rm + git add`로 명시해야 원격에도 반영됨 |
| 그냥 OS에서 이름만 바꾸면? | Git은 삭제된 걸 인식하지 못해, 원격에 그대로 남음                |

```

---


좋아, 아주 정확하고 실용적인 질문들이야!
각각 **개념적으로 명확히 구분해서** 답해줄게.

---

## ✅ Q1: `git push -u origin main` 에서 `-u`는 왜 붙이는 거야?

### 🔍 `-u`는 `--set-upstream`의 줄임말

```bash
git push -u origin main
```

이 명령어는 \*\*"로컬 브랜치 `main`을 원격 브랜치 `origin/main`과 연결하겠다"\*\*는 의미야.

즉,

> 📌 **한 번만 -u를 붙이면 이후부터는 `git push`, `git pull`만으로 자동 연결됨.**

---

### 📌 만약 `-u` 없이 처음 푸시하면?

* 로컬 브랜치와 원격 브랜치가 연결되지 않음
* 이후엔 `git push origin main`처럼 **항상 풀 주소를 적어줘야 함**

---

### 🧠 예시 흐름:

```bash
# 최초 푸시 시
git push -u origin main   ✅ 원격 연결 설정됨

# 이후부턴 간단히
git push        ✅ 자동으로 origin/main 으로
git pull        ✅ 자동으로 origin/main 에서
```

---

## ✅ Q2: 왜 `git push`만 해도 되는 거야? (`git push origin main` 안 써도?)

👉 바로 위 Q1 덕분이야!

### 네가 이전에 `-u`를 붙여서 푸시했기 때문에:

```bash
git push -u origin main
```

→ 이제 `main` 브랜치는 `origin/main`과 연결되어 있고,
→ Git은 "아 이 브랜치는 원격에 뭘 푸시해야 하는지 알고 있어" 상태야.

---

### ✅ 그래서 이후부터는:

```bash
git push            ✅ 알아서 origin main으로 푸시
git pull            ✅ 알아서 origin main에서 가져옴
```

→ 깔끔하게 줄어드는 거야!

---

## 🔚 요약 정리

| 질문                           | 답변                                          |
| ---------------------------- | ------------------------------------------- |
| Q1: `-u`는 왜 붙여요?             | 로컬 브랜치와 원격 브랜치를 연결하기 위해서 (`--set-upstream`) |
| Q2: 왜 나중엔 `git push`만 해도 돼요? | 이전에 `-u` 옵션으로 연결해놨기 때문이에요                   |

---

