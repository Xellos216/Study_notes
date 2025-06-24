# Ubuntu 수동 설치 프로그램 제거 실습 (`nProtect nosintgdmn` 예제)

- 날짜: 2025-06-22
- 환경: Ubuntu 기반 데스크탑 (MATE)
- 대상 프로그램: `nProtect Online Security for Linux`
- 설치 경로: `/usr/local/nProtect`
- 실행 서비스: `nosintgdmn.service`

---

## ✅ 문제 상황

- `nProtect` 키보드 보안 프로그램이 설치되어 있었으나,
  - GUI (제어판, Synaptic 등)에서 보이지 않음
  - 자동 실행되며, 백그라운드 프로세스로 상주
- 표준 패키지 관리 도구(apt/snap/flatpak)로 설치되지 않음

---

## 🔍 진단 과정

```bash
# 서비스 상태 확인
systemctl list-units | grep -i nprotect

# 프로세스/파일 위치 탐색
whereis nosintgdmn
sudo find / -name "*nosintgdmn*" 2>/dev/null
```

---

## 🧹 제거 단계 요약

1. 서비스 중지 및 비활성화
```bash
sudo systemctl stop nosintgdmn.service
sudo systemctl disable nosintgdmn.service
```

2. 프로그램 디렉토리 삭제
```bash
sudo rm -rf "/usr/local/nProtect"
```

3. systemd 서비스 파일 제거
```bash
sudo rm -f /usr/lib/systemd/system/nosintgdmn.service
```

4. init.d 및 rc.d 등록 스크립트 제거
```bash
sudo rm -f /etc/init.d/nosintgdmn
sudo rm -f /etc/rc*.d/K01nosintgdmn
```

5. systemd 데몬 재로딩
```bash
sudo systemctl daemon-reload
```

---

## 💡 학습 포인트

- 대부분의 리눅스 사용자는 명령어를 외우기보다 시스템 구조를 이해하고 `패턴`으로 해결
- GUI에 보이지 않는 프로그램은 `/opt`, `/usr/local`, `systemd/init.d` 구조를 의심
- 실습은 보고서처럼 기록하면 반복 학습보다 효율적

---

## ✅ 참고 명령어 정리

```bash
ps aux | grep -i [keyword]
whereis [명령어]
dpkg -l | grep [패키지명]
systemctl list-units | grep -i [서비스명]
find / -name "[이름]" 2>/dev/null
```
