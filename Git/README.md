# Git & GitHub CLI 실습 노트

이 문서는 Git과 GitHub CLI(`gh`)에 대한 실습 기반 학습 내용을 정리한 자료 모음입니다.  
각 주제는 실제 명령어 사용 예시와 함께 단계별로 정리되어 있으며,  
협업, 배포, CLI 워크플로우 등 실무에 필요한 내용을 폭넓게 다룹니다.

---

## 📦 목적 및 활용

- Git 기본 개념 및 커밋 구조 이해
- GitHub CLI (`gh`) 설치 및 인증, 레포지토리 생성 실습
- Pull Request, Fork, 협업 워크플로우 학습
- GitHub Pages를 통한 정적 사이트 배포 실습
- 실전 중심으로 오류 해결 및 명령어 흐름 문서화

---

## 📁 디렉토리 구성

각 디렉토리는 실습 주제에 따라 다음과 같이 나뉩니다:

- `01_basics`: Git/GitHub 기초 개념
- `02_setup_cli`: CLI 환경 설정 & 인증
- `03_gh_commands`: GitHub CLI 명령어 실습
- `04_collaboration`: 협업, PR, Fork 등
- `05_deploy`: GitHub Pages 배포 관련
- `06_reference`: 기타 참고 자료

각 폴더 안의 `.md` 파일들은 독립적으로 작성되며, 지속적으로 추가됩니다.

---

## 🛠 권장 환경

- OS: Ubuntu, WSL2, 또는 Parrot 기반 CLI 환경
- 인증 방식: SSH 키 기반 GitHub 연결
- GitHub CLI 버전: 최신 Stable (`gh version`으로 확인)

---

## 🧭 목표

"GitHub에서 CLI만으로 실전 워크플로우를 다룰 수 있다"는 **자신감 있는 상태**가 최종 목표입니다.  
문서 하나하나를 따라가다 보면, 나중에 스스로 문제 해결이 가능할 만큼 실력이 쌓입니다.

---