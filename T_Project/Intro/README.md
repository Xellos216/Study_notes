# 🧑‍💻 Bootcamp Team Introduction

2025년 7월 1일부터 시작된 백엔드 부트캠프 팀의 첫 번째 미니 프로젝트입니다.  
이 프로젝트는 팀원 각자의 간단한 프로필을 정리하여, 서로를 소개하고 첫 인사를 나누는 웹페이지를 만드는 것을 목표로 합니다.

## 🔍 프로젝트 개요

- **주제:** 팀원 소개용 정적 웹페이지 제작
- **목적:** 자신에 대한 소개와 정보, 깃허브 링크 등을 공유하여 팀워크 형성에 도움
- **기술 스택:** HTML / CSS / Firebase(Firestore DB, Storage, Authentication) / GitHub Pages

## 💡 주요 기능

- 팀원 1명당 하나의 소개 카드
- 이름, 사진, 한마디, MBTI, 자기소개, 취미, GitHub 프로필 링크 포함
- 카드 모달 형태로 팀원 소개
- 팀원 데이터 CRUD(Create, Read, Update, Delete) 기능 구현
- Firebase 등을 활용한 정보 등록 기능(정형/비정형 데이터)
- 카드 추가 또는 수정(삭제) 시 인증번호를 통한 간단한 보안 기능
- Firebase Authentication을 통해 접속한 사용자 식별

## 📁 디렉토리 구조

```
T_Project/
└── Intro/
    ├── cors.json
    ├── Firebase_rule_notes.md
    ├── SDK_CORS.md
    ├── README.md
    ├── Version_ChangeLog.md
    ├── png/               # 참고 이미지 저장 폴더
    └── version/           # 각 버전별 HTML 파일 저장 폴더
```

## 🚀 배포

- **GitHub Pages:**  
  (예시) https://your-github-id.github.io/your-repo/

## 🙋 팀원 목록

| 이름 | 관심 기술 | GitHub |
|------|-----------|--------|
| 백도현 | JAVA, Spring, REACT, MySQL | https://github.com/8646066468 |
| 임홍민 | JAVA, Spring, Kotlin | https://github.com/Xellos216/ |
| 김민형 | React, Tailwind, Python, Java, Spring, MySQL  | https://github.com/MinHyeongK |

## ✨ 향후 계획

- [✅] Firebase 연동하여 실시간 정보 입력 구현
- [✅] 슬라이드 UI 개선 (1명씩 보여주고 좌우 전환)
- [✅] GitHub 배포 후 URL 공유
- [✅] 반응형 디자인 마무리
