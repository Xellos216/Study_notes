# Git 병합 전략 개념 정리

## 1. `git pull` vs `git pull --rebase`

| 명령어                 | 병합 방식  | 커밋 이력           | 특징 및 장점                |
| ------------------- | ------ | --------------- | ---------------------- |
| `git pull`          | merge  | merge commit 생성 | 변경 이력이 분기/병합 구조로 명확    |
| `git pull --rebase` | rebase | 직선형 커밋 이력 유지    | 커밋이 깔끔하게 정렬되어 이력 파악 용이 |

* `git pull` = `git fetch` + `git merge`
* `git pull --rebase` = `git fetch` + `git rebase`

> `pull`은 원격 저장소 변경사항을 로컬 브랜치에 반영하는 명령이다.
> `--rebase` 옵션은 병합 커밋 없이 이력을 깔끔하게 만든다.

---

## 2. `merge` vs `rebase` 실습 시나리오

### A. `merge`

```bash
# main 브랜치에서 수정
git checkout main
echo "main edit" >> file.txt
git commit -am "edit on main"

# feature 브랜치에서 수정
git checkout feature
echo "feature edit" >> file.txt
git commit -am "edit on feature"

# 병합
git checkout main
git merge feature
```

* 결과: 병합 커밋이 생기고, 커밋 이력에 분기 흔적이 남음

---

### B. `rebase`

```bash
# feature 브랜치를 main 기준으로 재배치
git checkout feature
git rebase main
```

* 결과: feature의 커밋이 main 커밋 이후로 이어짐 (직선형 이력)

---

## 3. 충돌(conflict) 해결 절차

### ⚠️ 충돌 발생 시 예시

```bash
git merge feature
# 또는
git rebase main
```

```text
CONFLICT (content): Merge conflict in file.txt
```

### ✅ 해결 순서

1. 충돌된 파일 열기 (예: `file.txt`)

```text
<<<<<<< HEAD
main 내용
=======
feature 내용
>>>>>>> feature
```

2. 원하는 내용만 남기고 수동 수정 후 저장
3. 충돌 해결 완료 처리

```bash
git add file.txt
git commit            # (merge인 경우)
git rebase --continue # (rebase인 경우)
```

---

## 4. 실전 명령어 요약

```bash
# 원격 변경사항 가져오기
git fetch origin

git pull origin main             # merge 방식
git pull origin main --rebase   # rebase 방식

# 브랜치 병합
git merge <브랜치명>

git rebase <브랜치명>
git rebase --continue            # 충돌 후 재개

# 스테이징 & 커밋 & 푸시
git add .
git commit -m "메시지"
git push origin main
```

---

## 5. 정리 요약

| 상황                | 추천 방식               |
| ----------------- | ------------------- |
| 이력 추적이 중요하거나 협업 중 | `git merge`         |
| 혼자 작업 중이고 이력을 깔끔히 | `git rebase`        |
| 원격 변경사항 먼저 적용 필요  | `git pull --rebase` |

> 병합 전략은 상황에 따라 다르며, 협업 여부, 이력 가독성 등을 고려하여 선택해야 한다.
