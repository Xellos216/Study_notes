
# Git에서 `git clone`과 `git pull`의 차이와 사용 상황 정리

## ✅ 1. 로컬 → 원격 vs 원격 → 로컬

### 🔁 너의 일반적인 흐름 (로컬 → 원격)

```bash
# 로컬에서 작업 시작
git init
git add .
git commit -m "처음 커밋"

# GitHub에 빈 레포 생성 후
git remote add origin [URL]
git push -u origin main
```

📌 이건 **“내가 만든 로컬 프로젝트를 GitHub에 처음 올리는 흐름”**이다.

---

### 🔁 `git clone`의 흐름 (원격 → 로컬)

```bash
git clone https://github.com/username/project.git
```

📌 이건 **“이미 존재하는 GitHub 레포를 내 컴퓨터로 복사해오는 흐름”**이다.

---

## ✅ 2. `git clone`은 언제 자주 쓰나?

| 상황 | 설명 |
|------|------|
| ✅ 협업 프로젝트 참여 | 다른 사람이 만든 레포를 가져와서 작업할 때 |
| ✅ 오픈소스 수정 | GitHub에 공개된 코드를 로컬에서 수정하고자 할 때 |
| ✅ 다른 기기에서 작업 | 같은 프로젝트를 노트북/회사 컴퓨터 등에서 열 때 |
| ✅ GitHub Pages 수정 | 이미 배포된 사이트를 고치려면 먼저 clone 필요 |
| ✅ 복구 | 기존 로컬 폴더가 날아간 후 다시 받아올 때 |

---

## ✅ 3. `git clone` vs `git pull`

| 항목 | `git clone` | `git pull` |
|------|-------------|-------------|
| 목적 | 원격 레포 전체 복사 | 원격 레포 최신 내용만 반영 |
| 사용 시점 | 레포가 로컬에 없을 때 | 이미 클론해둔 레포가 있을 때 |
| 내부 동작 | `.git` 폴더 포함 전체 구조 복사 | `git fetch` + `git merge` 자동 실행 |
| 비유 | 프로젝트를 **처음 통째로 가져오기** | 프로젝트를 **최신 상태로 갱신하기** |

---

## 🔄 요약 흐름

```bash
# 📥 처음 받을 땐
git clone URL

# 🔄 이후 업데이트할 땐
cd 프로젝트
git pull
```

---

## ✅ 최종 요약 정리

| 개념 | 설명 |
|------|------|
| `git clone` | GitHub 등 원격 저장소를 처음 복제할 때 사용 |
| `git pull` | 기존에 clone한 로컬 저장소를 최신 상태로 유지 |
| 로컬 → 원격 업로드 | `git init → add → commit → push` |
| 자주 쓰는 상황 | 협업, 오픈소스, GitHub Pages 수정, 복구 등 |

> 🔐 즉, `clone`은 처음 가져오는 것, `pull`은 가져온 뒤 최신 상태를 유지하는 것!

