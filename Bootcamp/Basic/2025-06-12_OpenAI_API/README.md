# GPT CLI 예습 실습 정리

이 저장소는 OpenAI의 GPT API를 **CLI 환경에서 직접 호출**하는 실습 내용을 정리한 것입니다.

## ✅ 주요 구성

- `ask.sh` : 터미널에서 질문 → 응답 출력
- `ask_save.sh` : 응답을 자동으로 `.txt` 파일로 저장
- `gpt_logs/` : 저장된 응답 로그 모음

## 📁 구조 예시

```
/home/h/
├── ask.sh
├── ask_save.sh
└── gpt_logs/
    ├── log_20250611_154823.txt
    └── ...
```

## 📌 실습 포인트

- OpenAI API 키 사용법
- `curl` + `jq`로 GPT 응답 받아 파싱하기
- WSL에서 파일 저장 → Windows 탐색기로 열기
- 실무 자동화 스크립트 작성

## 🔗 참고

- OpenAI API 문서: https://platform.openai.com/docs
- 사용량 확인: https://platform.openai.com/account/usage
