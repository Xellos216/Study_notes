# 11_github_collaboration_pull_sync.md

## ✅ 주제: 팀원이 GitHub에 직접 올린 파일을 로컬에 반영하는 방법

---

## 🧭 상황

- GitHub 협업 레포에서 팀원이 웹으로 새로운 파일(`js.html`)을 커밋함
- 내 로컬 저장소에는 아직 이 커밋이 반영되지 않음
- 그대로 작업을 이어갈 경우 충돌(conflict) 발생 가능성 있음

---

## ✅ 해결 방법: 원격 레포에서 로컬로 동기화 (Pull)

```bash
git pull origin main
```

- `origin`: 원격 저장소 이름 (기본값)
- `main`: 병합할 브랜치 이름
- 이 명령은 **GitHub 원격 저장소의 최신 변경사항을 내 로컬 저장소로 가져옴**

---

## 🔄 동기화 워크플로우

```bash
# 1. 현재 브랜치 확인 (보통 main이어야 함)
git branch

# 2. 원격 변경사항 가져오기
git pull origin main

# 3. 변경 내용 확인
ls
```

동기화가 완료되면 팀원이 만든 `js.html` 파일이 로컬에도 반영됨.

---

## ⚠️ 충돌(conflict)이 발생한 경우

1. `git pull` 중 충돌 경고 메시지 발생
2. `git status`로 충돌 파일 확인
3. 파일 내부 `<<<<<<<`, `=======`, `>>>>>>>` 블록 수동 해결
4. 해결 후:

```bash
git add <파일명>
git commit
git push
```

---

## ✅ 요약

| 상황 | 해야 할 일 |
|------|--------------|
| 팀원이 웹에서 커밋함 | `git pull origin main` |
| 로컬에만 있던 커밋 있음 | pull → 충돌 해결 필요 |
| 최신 상태 유지 | 주기적으로 `git pull` 수행 |

---

## 📌 실무 팁

- 협업 중이라면 `push` 전 반드시 `pull`로 동기화 여부 확인
- VSCode 또는 `git status`를 자주 확인해 충돌 위험 사전에 파악

---

✅ 이번 실습에서는 팀원이 추가한 `js.html`을 내 로컬에 동기화하며 협업의 기본 흐름인 `pull → edit → commit → push`를 실습했다.
