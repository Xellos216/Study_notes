# 📚 2025-06-12 예습 정리: CLI에서의 OpenAI API 사용법

---

## ✅ 학습 주제

- CLI 환경에서 OpenAI API를 직접 호출하여 요약, 번역, 자동화 등 실전 활용 실습 진행
- `curl` + `jq` + bash 스크립트로 API 호출 → 응답 저장 및 관리 자동화 구성

---

## ✅ 실습 명령어 전체 정리

```bash
# 환경 구성
export OPENAI_API_KEY="sk-..."   # OpenAI API 키 설정
mkdir -p ~/gpt_logs              # 로그 저장 폴더 생성

# 기본 API 호출
curl https://api.openai.com/v1/chat/completions \
  -H "Authorization: Bearer $OPENAI_API_KEY" \
  -H "Content-Type: application/json" \
  -d '{
        "model": "gpt-3.5-turbo",
        "messages": [{"role": "user", "content": "GPT는 어떻게 작동하나요?"}],
        "temperature": 0.7
      }' > gpt_response.json

# 응답 파싱
cat gpt_response.json | jq '.choices[0].message.content'

# 자동화 스크립트 (ask.sh)
./ask.sh "GPT-4와 GPT-3.5의 차이점은?"

# 로그 저장 스크립트 (ask_save.sh)
./ask_save.sh "WSL의 장점 3가지 알려줘"

# 로그 열기
explorer.exe $(wslpath -w ~/gpt_logs)

# alias 등록
echo "alias gptlog='explorer.exe \$(wslpath -w ~/gpt_logs)'" >> ~/.bashrc
source ~/.bashrc
gptlog
```

---

## ✅ 중간 실습 파일 구조

```
/home/h/
├── ask.sh
├── ask_save.sh
├── gpt_response.json
├── result.txt
└── gpt_logs/
    └── log_20250611_154823.txt
```

---

## ✅ 질문 & 답변 모음

### Q1. ChatGPT Plus인데 왜 API 결제 또 해야 해?

- ChatGPT Plus는 웹 UI 전용 ($20/월)
- OpenAI API는 curl, Python 등으로 호출할 수 있는 **개별 요금제 (종량제)**
- 서로 별개임

---

### Q2. API 키만 등록하면 돈 나가?

- 아니, 무료 $5 크레딧이 먼저 소진됨
- Auto Recharge가 꺼져 있으면 $0에서 자동 차단됨

---

### Q3. CLI로 쓰는 이유?

- **웹 GPT는 수동**
- **API는 자동화 / 백엔드 연동 / 실시간 호출 / 코드 통합**에 최적화
- DevOps, 보안, 마케팅, 고객지원에서 유용

---

### Q4. null, json 개념?

- JSON은 데이터 구조 표현 방식 (key-value)
- `null`은 "값이 없음"을 의미 (Python의 `None`과 유사)

---

### Q5. 저장된 파일 어디 갔어?

- `/home/h/`는 WSL 안의 디렉토리
- Windows에서는 `\wsl$\Ubuntu-22.04\home\h` 경로로 접근 가능

---

## ✅ 실무 활용 팁 요약

| 목적 | 추천 경로 |
|------|-----------|
| WSL CLI 실습 | `/home/h/gpt_logs` |
| Windows에서 확인/수정 | `/mnt/c/Users/yourname/Documents/GPT` |
| GitHub 커밋용 정리 | `~/gpt_notes/*.md` |

---

## ✅ alias 팁

```bash
# bashrc에 등록
echo "alias gptlog='explorer.exe \$(wslpath -w ~/gpt_logs)'" >> ~/.bashrc
source ~/.bashrc

# 사용
gptlog
```

---

## ✅ 사용 예시 자동화 스크립트

`ask_save.sh` 예시:

```bash
#!/bin/bash
PROMPT="$1"
DATE=$(date +"%Y%m%d_%H%M%S")
mkdir -p "$HOME/gpt_logs"

curl https://api.openai.com/v1/chat/completions \
  -s \
  -H "Authorization: Bearer $OPENAI_API_KEY" \
  -H "Content-Type: application/json" \
  -d "{
        \"model\": \"gpt-3.5-turbo\",
        \"messages\": [{\"role\": \"user\", \"content\": \"$PROMPT\"}],
        \"temperature\": 0.7
      }" | jq -r '.choices[0].message.content' > "$HOME/gpt_logs/log_$DATE.txt"

echo "✅ 결과가 $HOME/gpt_logs/log_$DATE.txt 로 저장되었습니다."
```

---
---

## 📌 Git 사용 관련 추가 Q&A 정리 (2025-06-11)

### 1. `git config --global user.name`은 왜 1회만 설정하나요?
- `--global` 옵션은 전체 사용자 계정에 적용되므로 한 번만 설정해도 모든 Git 프로젝트에 자동 반영됩니다.
- 특정 프로젝트에서만 별도로 설정하려면 `--global` 없이 사용하세요.

```bash
git config user.name "Project Specific Name"
```

---

### 2. `.git` 폴더란?
- `git init`을 실행하면 생성되며, 해당 폴더가 있는 디렉토리는 Git이 버전 관리를 수행하는 저장소로 인식됩니다.
- 내부에는 commit 기록, 설정, 브랜치 정보 등이 저장됩니다.
- 삭제 시 Git 추적이 중단됩니다.

---

### 3. `git branch -M main`, `git push -u origin main` 뜻은?

- `git branch -M main`:
  - 브랜치 이름을 `main`으로 강제 변경합니다. (기존 `master` → `main`)

- `git push -u origin main`:
  - `-u` 옵션은 현재 로컬 브랜치(`main`)를 원격 저장소의 `main` 브랜치와 연결합니다.
  - 다음부터는 `git push`만 입력해도 연결된 브랜치로 자동 푸시됩니다.

---

### 4. `git remote set-url origin ...`은 무슨 의미인가요?
- 원격 저장소 주소(=origin)의 URL을 변경하는 명령어입니다.
- 주로 HTTPS에서 SSH로 전환하거나, 저장소 주소가 변경되었을 때 사용합니다.

```bash
git remote set-url origin git@github.com:YourName/RepoName.git
```

---

### 5. SSH vs HTTPS 차이

| 항목       | HTTPS 인증                         | SSH 인증                                     |
|------------|------------------------------------|----------------------------------------------|
| 로그인 방식 | 사용자명 + PAT (토큰)              | 로컬에 있는 SSH 키로 자동 인증               |
| 편의성     | 토큰 복붙해야 함 (가끔 번거로움)    | 한 번 설정해두면 비번 없이 자동 인증         |
| 보안성     | 토큰이 유출되면 위험                | 개인키/공개키 분리되어 상대적으로 더 안전     |
| 속도       | 약간 느릴 수 있음                  | 더 빠르고 안정적임 (특히 대용량 push 시)     |
| 추천 용도  | 빠른 단발성, 공용 컴퓨터            | 장기 사용, 개인 개발환경, 자동화 스크립트용  |

✅ GitHub 권장 방식은 SSH입니다. 다만 초보자는 HTTPS가 더 직관적일 수 있습니다.

---