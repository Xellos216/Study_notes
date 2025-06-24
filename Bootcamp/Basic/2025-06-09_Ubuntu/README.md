
# 📘 Ubuntu & Docker 실습 정리 - 2025.06.10

이 저장소는 Ubuntu Desktop 환경 설정 및 Docker 예습 실습 내용을 포함합니다.  
DevOps 부트캠프 예습 과정의 일부로, 리눅스 명령어와 시스템 설정, GRUB 커스터마이징, 한글 입력기 설정, Docker 컨테이너 실행 및 이미지 빌드 등을 다룹니다.

---

## 📂 포함 파일

- `linux_basic_commands_2025-06-10.md`  
  → Ubuntu 기본 명령어 + 시스템 설정 실습 요약 마크다운
- `2025-06-11-docker-summary.md`  
  → Docker 기본 개념, 명령어 실습, 이미지 빌드 정리

---

## 📌 Ubuntu 실습 내용 요약 (2025-06-10)

### ✅ GRUB 커스터마이징
- `grub-customizer`를 활용한 GUI 기반 설정
- 부팅 순서: Windows → Ubuntu
- recovery mode, UEFI 항목 숨김
- GRUB 배경 이미지 변경

### ✅ Flameshot 설정
- 자동 실행 등록
- 단축키 설정 (`flameshot gui`)
- Wayland 이슈 → X11 세션 전환 팁 포함

### ✅ IBus 한글 입력기 설정
- `ibus-hangul`, `fonts-nanum` 설치
- `im-config -n ibus` 적용

### ✅ Linux 명령어 실습
- `ls`, `cd`, `pwd`, `mkdir`, `rm`
- `htop`, `df -h`, `free -h`, `systemctl status`

---

## 📌 Docker 실습 내용 요약 (2025-06-10)

### 🧱 실습 목표

- Docker의 개념과 동작 방식 이해
- 컨테이너와 이미지의 차이 학습
- Dockerfile 작성 및 이미지 빌드 실습
- `curl`이 포함된 우분투 컨테이너 실행 테스트

### 🧪 사용한 명령어

```bash
docker --version
sudo docker run -it ubuntu /bin/bash
sudo docker ps
sudo docker stop <CONTAINER_ID>
sudo docker rm <CONTAINER_ID>
sudo docker images
sudo docker rmi <IMAGE_NAME>
sudo docker build -t ubuntu-curl .
sudo docker run -it ubuntu-curl
curl https://example.com
```

### 📄 Dockerfile 예시

```Dockerfile
FROM ubuntu:latest
RUN apt update && apt install -y curl
CMD ["/bin/bash"]
```

### ❓ 학습 중 주요 질문 정리

- Docker와 VMware의 차이점은?
- 왜 "컨테이너"라고 부르는가?
- 이미지란 무엇이고, 왜 빌드하는가?
- Dockerfile에 적는 지시어는 어떤 역할을 하나?

---

## 🔐 GitHub SSH 키 인증 정리

### ✅ 왜 HTTPS보다 SSH가 편한가?

- PAT 입력이 필요 없는 비밀번호 없는 인증 방식
- 여러 repo에서 반복 인증 없이 push 가능

### ✅ SSH 방식의 장점

| 항목 | 설명 |
|------|------|
| 🔁 인증 반복 없음 | `git push`, `git pull` 시 토큰 불필요 |
| 🔐 보안성 ↑ | 키 기반 인증으로 brute force 방지 |
| 💻 로컬 Git 계정과 깔끔하게 연동 | 여러 repo 간 편리한 사용 가능 |

```bash
git remote set-url origin git@github.com:사용자명/저장소명.git
```

---

## 🗓️ 작성일: 2025-06-10
