# GitHub Desktop AppImage 설치 중 겪은 문제와 해결

## 🧩 초기 상황
- GitHub Desktop을 리눅스에서 실행하려고 `.AppImage` 파일 다운로드
- 여러 오류 발생

---

## ❌ 오류 1: `Exec format error`

### 원인
- ARM64용 AppImage를 다운로드해서 x86_64 시스템에서 실행 불가

### 해결
- GitHub Release 페이지에서 `x86_64` 또는 `amd64` 포함된 AppImage 다운로드

---

## ❌ 오류 2: `libfuse.so.2` not found

### 원인
- FUSE 라이브러리 미설치

### 해결
```bash
sudo apt install libfuse2
```

---

## ❌ 오류 3: `GetVSyncParametersIfAvailable()` 관련 경고

### 원인
- GPU 가속 문제 (Wayland, 드라이버 등)

### 해결
- 아래처럼 GPU 비활성화 실행
```bash
./GitHubDesktop-*.AppImage --disable-gpu
```

또는 AppImage 압축 해제 후 직접 실행
```bash
./GitHubDesktop-*.AppImage --appimage-extract
cd squashfs-root
./AppRun --disable-gpu
```

---

## ✅ 결론
- 리눅스에서 GitHub Desktop은 호환성이 떨어질 수 있음
- 가능하면 GitHub CLI + VSCode 조합 사용 권장
