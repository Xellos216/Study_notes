# 📅 2025-06-10
## Ubuntu 기본 명령어 실습 정리

### 🗂️ 1. 디렉토리 및 파일 명령어
- `ls -al`: 현재 디렉토리의 파일과 폴더 전체 목록 및 권한 확인
- `cd Documents`: 디렉토리 이동 (대소문자 구분 주의)
- `pwd`: 현재 경로 출력
- `mkdir Test`: 새로운 폴더 생성
- `rm -r Test`: 폴더 및 하위 항목 삭제

### 🔐 2. 시스템 정보 및 리소스 확인
- `ps aux`: 모든 프로세스 출력
- `htop`: 실시간 CPU/메모리 상태 보기
- `df -h`: 디스크 공간 사용량 확인
- `free -h`: 메모리 사용 상태 확인

### ⚠️ 3. 시스템 서비스 관련
- `sudo systemctl status ssh`: ssh 서비스 상태 확인 (결과: service could not be found)

---

### 💬 실습 중 메모
- `cd documents` → 오류 발생 (`Documents`로 대소문자 맞춰야 접근 가능)
- `htop` 실행 후 `top`처럼 CPU/메모리 확인 가능, `q`로 종료
- `systemctl status ssh`는 ssh 서버가 설치되어 있지 않아 실패

---

### 🧰 4. Ubuntu Desktop 환경 설정 정리

#### 🔹 GRUB 커스터마이징
- `grub-customizer` 설치 후 GUI로 설정
- Windows 항목 이름을 "Windows 11"로 변경
- 부팅 순서: Windows → Ubuntu로 변경
- recovery mode, UEFI 메뉴 숨김
- 배경 이미지 변경 완료 (`/boot/grub/my_background.png` 사용)

#### 🔹 Flameshot 스크린샷 설정
- `flameshot` 설치 및 `Startup Applications`에 자동 실행 등록
- 단축키: `flameshot gui` → `Shift + Print`로 영역 캡처
- Wayland에서 문제 발생 시 X11 세션으로 로그인 전환

#### 🔹 한글 입력기 설정 (IBus)
- `sudo apt install ibus ibus-hangul fonts-nanum`
- `im-config -n ibus` 후 재부팅
- 한영 전환키: `Shift + Space` 또는 `한/영` 설정

#### 🔹 기본 유틸리티 설치
- `curl`, `vim`, `gnome-disk-utility`, `htop`, `gparted` 설치
- `sudo apt install curl vim gnome-disk-utility htop gparted`

#### 🔹 파일 관리자(Caja) 설정
- 숨김파일 보기 단축키: `Ctrl + H` 또는 `gsettings` 명령어
- 폴더 색상 및 아이콘: 우클릭 → “배경 및 아이콘” 메뉴 사용
