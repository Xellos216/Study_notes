# Github Pages 배포 가이드 (Team_Intro)

본 문서는 `Version_04.html`을 기반으로 만든 팀 소개 웹페이지를 **GitHub Pages**를 통해 배포한 과정을 정리한 것입니다.

---

## ✅ 1단계. Public 레포 생성

- 레포 이름: `Team_Intro`
- 설정: `Public`, README는 생성하지 않음
- GitHub 자동 제공 주소 예상: `https://Xellos216.github.io/Team_Intro`

---

## ✅ 2단계. 로컬에서 HTML 복사

```bash
cd ~/git_repos
mkdir git_page
cd git_page
git clone git@github.com:Xellos216/Team_Intro.git
cd Team_Intro

# 기존 협업 레포에서 최종 HTML 복사 (이름 변경)
cp ../../BC_Miniproject/Version_04.html ./index.html

# default 이미지도 함께 복사
cp ../../BC_Miniproject/default.png .
```

---

## ✅ 3단계. Git 커밋 & 푸시

```bash
git add .
git commit -m "Deploy team page"
git push origin main
```

---

## ✅ 4단계. GitHub Pages 설정

1. GitHub → Team_Intro 레포 → [Settings]
2. 왼쪽 메뉴에서 **Pages** 클릭
3. Source: `Deploy from a branch`
4. Branch: `main`, Folder: `/ (root)` → 저장
5. 몇 초 후 배포 주소 생성됨

---

## 📌 참고 사항

- 반드시 파일 이름은 `index.html`로 설정해야 루트 페이지에서 바로 열림
- Firebase 기능이 포함되어 있어 Firestore/Storage 연결 확인 필요
- 이미지 로딩 오류 방지를 위해 `default.png`도 반드시 포함
- SSH 방식 사용 시 clone 주소는 `git@github.com:Xellos216/Team_Intro.git`

---

## ✅ 배포 주소

> 🔗 https://Xellos216.github.io/Team_Intro (설정 후 수 분 내 활성화됨)
