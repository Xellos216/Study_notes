# 10_github_personal_vs_org.md

## ✅ 주제: GitHub Personal Repository vs Organization Repository 차이

GitHub에서 저장소는 크게 두 가지 유형으로 나뉩니다:

- **Personal Repository**: 개인 계정 소유 (`github.com/username/repo`)
- **Organization Repository**: 조직 계정 소유 (`github.com/orgname/repo`)

---

## 📌 주요 비교 항목

| 항목 | Personal Repository | Organization Repository |
|------|----------------------|---------------------------|
| 소유자 | 개인 계정 | 조직 계정 (팀, 회사, 커뮤니티 등) |
| 권한 관리 | Collaborator 수동 초대 | 팀 기반 권한 분리 가능 |
| 예시 주소 | `github.com/user/repo` | `github.com/org/repo` |
| 사용 목적 | 학습, 포트폴리오, 개인 프로젝트 | 협업, 기업 프로젝트, 오픈소스 운영 등 |
| 삭제 가능자 | 본인 | 관리자만 가능 |
| GitHub Actions / Secrets 공유 | 계정 단위 | 조직 단위로 공유 가능 |

---

## 🧩 개인 계정 레포 특징

- 모든 설정을 소유자(본인)가 직접 관리
- 협업하려면 매번 수동 초대 필요
- 작은 개인 프로젝트, 학습용 레포에 적합
- 포트폴리오 용도로 가장 많이 사용됨

---

## 🏢 Organization 레포 특징

- 팀을 구성하고 팀 단위로 권한 부여 가능
- 기업/커뮤니티/부트캠프 등 **단체 프로젝트 관리**에 적합
- GitHub Teams, 프로젝트 관리, 이슈 템플릿 등 지원
- GitHub Actions, Secrets 등을 조직 전체에서 재사용 가능

---

## 🔐 보안 측면 차이

| 항목 | 개인 | 조직 |
|------|------|------|
| 권한 부여 | 수동 초대 | 팀 단위 설정 |
| 이중 인증 강제 | 불가 | 조직 설정 가능 |
| 로그 추적 | 거의 불가 | Audit log 제공 (Pro/Team 이상) |

---

## ✅ 언제 조직 레포가 유리한가?

- 팀 프로젝트, 과제 제출, 스터디 관리
- 코드베이스를 개인이 아닌 “조직 소속”으로 남기고 싶을 때
- 권한을 체계적으로 분리하고 싶을 때
- 협업자 교체나 팀 이동이 자주 있을 때

---

## 📝 결론

> 개인 레포는 학습과 정리에 적합하고,  
> 조직 레포는 협업과 배포, 구조적 관리에 강하다.

추후 오픈소스 프로젝트나 팀 프로젝트가 생긴다면  
**Organization 생성 → 팀 구성 → 역할 분리**로 확장하는 것을 추천한다.
