
# 📅 2025-06-10 예습 정리: Docker 개념 및 실습

## ✅ 오늘 학습한 주제
- Docker의 개념 이해
- 컨테이너와 이미지의 차이 학습
- Dockerfile을 통한 이미지 빌드 실습
- `curl` 포함된 Ubuntu 컨테이너 생성 및 테스트
- 실습 과정 중 질문과 개념 정리

---

## 📘 학습한 개념 요약

### 🔹 Docker란?
- 컨테이너 기반 가상화 기술
- 무겁고 느린 VM과 달리, OS 위에서 격리된 환경을 빠르게 실행
- 앱, 테스트 환경 등을 격리하여 실행 가능

### 🔹 컨테이너(Container)
- 이미지로부터 실행된 '실행 환경 인스턴스'
- 작고 빠르며, 격리된 공간에서 독립적으로 실행됨

### 🔹 이미지(Image)
- 컨테이너의 설계도
- OS, 명령어, 실행 정보 등을 포함한 스냅샷
- Dockerfile로 직접 정의 가능

### 🔹 Dockerfile
- 이미지를 자동으로 빌드하기 위한 설정 파일
- FROM, RUN, CMD 등을 통해 이미지 내용 정의

---

## 🧪 실습 중 사용한 명령어

```bash
# 버전 확인 및 실행
docker --version
sudo docker run -it ubuntu /bin/bash

# 컨테이너 상태 확인
sudo docker ps
sudo docker ps -a

# 컨테이너 중지 및 삭제
sudo docker stop <컨테이너 ID>
sudo docker rm <컨테이너 ID>

# 이미지 확인 및 삭제
sudo docker images
sudo docker rmi <이미지명>

# Dockerfile 작성 후 빌드
nano Dockerfile
sudo docker build -t ubuntu-curl .
sudo docker run -it ubuntu-curl

# 컨테이너 내부에서 실행
curl https://example.com
```

---

## 🧱 실습한 Dockerfile 내용

```Dockerfile
FROM ubuntu:latest
RUN apt update && apt install -y curl
CMD ["/bin/bash"]
```

---

## ❓ 실습 중 나왔던 주요 질문 & 해설

1. **Docker가 뭐하는 앤지 모르겠어.**
   - → 격리된 실행환경(컨테이너)을 만들어주는 도구. 빠르고 가벼움.

2. **왜 컨테이너라고 하는 거야? 그냥 명칭이야?**
   - → OS 커널 수준에서 격리된 공간. VM보다 작고 빠름.

3. **이 Docker를 내 우분투에서 실행해서 뭘 할 수 있는 거야?**
   - → 웹서버, DB, 해킹 실습 환경 등 격리된 실험 공간으로 활용 가능.

4. **이미지를 빌드한다는게 무슨 말인지 모르겠어.**
   - → 컨테이너를 만들기 위한 설계도(이미지)를 Dockerfile로 생성하는 것.

5. **Dockerfile 안의 내용이 뭘 해주는 건지 모르겠어.**
   - → FROM: 베이스 이미지 지정  
   - → RUN: 실행할 명령어 (ex: 패키지 설치)  
   - → CMD: 컨테이너 실행 시 기본 명령어 지정

6. **Docker는 VMware 같은 가상 머신이야?**
   - → 구조는 비슷하지만 훨씬 가볍고 빠름. GUI 없이 CLI로 동작하는 게 핵심.

---

## 📦 실습 결과 요약

- `ubuntu` 컨테이너 실행 → 내부에서 `apt update`, `curl` 확인
- Dockerfile 작성 및 커스텀 이미지(`ubuntu-curl`) 생성
- 생성된 이미지로 컨테이너 실행 후 `curl https://example.com` 성공
