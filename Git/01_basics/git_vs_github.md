# Git과 GitHub의 개념 차이

## ✅ Git이란?
- Git은 로컬에서 소스코드를 버전 관리하기 위한 **분산 버전 관리 시스템(DVCS)**이다.
- `git init`, `git add`, `git commit` 등의 명령어로 로컬에서 코드의 변경 내역을 추적하고 저장할 수 있다.
- 인터넷 없이도 버전 관리를 수행할 수 있다.

## ✅ GitHub란?
- GitHub는 Git 저장소를 **클라우드에서 호스팅**해주는 플랫폼이다.
- 원격 저장소를 만들어 다른 사람과 협업하거나, 백업용으로 사용 가능.
- GitHub는 Git의 클라우드 확장판이라 볼 수 있으며, 웹 인터페이스와 이슈/PR 관리 기능 등을 제공한다.

## ✅ 핵심 차이
| 항목 | Git | GitHub |
|------|-----|--------|
| 범위 | 로컬 버전 관리 | 원격 저장소 플랫폼 |
| 설치 필요 | 필요 (로컬 사용) | 웹 기반 (CLI 사용 시 `gh`) |
| 독립 사용 | 가능 | Git 필요 |
| 대표 명령어 | `git init`, `git commit` | `gh repo create`, PR, issue 등 |

## ✅ 연결 흐름
1. `git init`으로 로컬 Git 저장소 생성
2. `git remote add origin <URL>`로 GitHub 연결
3. `git push`로 로컬 → 원격 푸시
