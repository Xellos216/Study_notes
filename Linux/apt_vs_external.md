# apt install만으로 되는 경우 vs 외부 저장소 추가가 필요한 경우

리눅스에서 `sudo apt install`로 대부분의 도구를 설치할 수 있지만, 어떤 도구들은 복잡한 설치 과정을 요구한다. 이 문서는 그 차이를 이해하고, 왜 외부 저장소 등록이 필요한지를 설명한다.

---

## ✅ 1. 일반적인 경우: `sudo apt install`만으로 되는 패키지

- Ubuntu **공식 저장소에 이미 등록된 패키지**
- 예시:
  - `curl`, `git`, `python3`, `vim`, `docker.io` 등
- `apt` 명령이 직접 설치 경로와 버전 정보를 알고 있기 때문에, 별도 설정 없이 설치 가능

---

## ❗ 2. 복잡한 과정이 필요한 경우: 외부 저장소 등록

- Google Cloud SDK, Node.js LTS, Docker CE, Visual Studio Code 등은 Ubuntu 기본 저장소에 없음
- 사용자가 직접 외부 저장소를 등록하고 GPG 키를 추가해야 함

### 🔹 예시: Google Cloud SDK 설치 과정

```bash
# 1. 패키지 받을 외부 저장소 등록
echo "deb [signed-by=/usr/share/keyrings/cloud.google.gpg] http://packages.cloud.google.com/apt cloud-sdk main" \
  | sudo tee /etc/apt/sources.list.d/google-cloud-sdk.list > /dev/null

# 2. 신뢰할 수 있는 출처(GPG 키) 등록
curl https://packages.cloud.google.com/apt/doc/apt-key.gpg \
  | sudo apt-key --keyring /usr/share/keyrings/cloud.google.gpg add -

# 3. 저장소 갱신 후 설치
sudo apt update
sudo apt install google-cloud-sdk
```

---

## 📦 왜 이런 과정이 필요한가?

외부 저장소는 Ubuntu가 기본적으로 신뢰하지 않기 때문에, **사용자가 수동으로 등록**해야 한다.

| 구성요소 | 설명 |
|----------|------|
| `.list` 파일 | 새로운 저장소 주소를 `/etc/apt/sources.list.d/`에 추가 |
| GPG 키 | 해당 저장소의 서명 키를 등록해 보안 보장 |
| `apt update` | 새 저장소를 읽고 패키지 목록 갱신 |

---

## 🎓 비유로 이해하면

| 단계 | 비유 |
|------|------|
| `sudo apt install` | 마트에서 바로 물건 사기 |
| 저장소 등록 + GPG 키 | 외부 공급업체 등록하고, 신원 확인 후 주문 허용 |

---

## 🤔 외워야 할까?

❌ 외울 필요 없다. 실무에서도 대부분 **공식 문서를 복사해 사용**함.  
✅ 중요한 건 흐름을 이해하고, 어떤 도구들이 외부 저장소를 필요로 하는지 감 잡는 것.

---

## ✅ 요약 정리

| 구분 | 의미 | 외워야 하나 |
|------|------|---------------|
| `sudo apt install` | 공식 저장소 패키지 설치 | ✅ |
| `echo ... | tee` | 외부 저장소 등록 | ❌ |
| `curl ... | apt-key add` | GPG 키 등록 | ❌ |
| `apt update` 후 설치 | 새 저장소에서 설치 | ✅ |

---

## 📁 추천 저장 위치

```bash
./git_repos/Study_notes/Linux/apt_vs_external.md
```
