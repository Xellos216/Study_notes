# ✅ 해결 방법: "항상 빈 페이지로 열리도록" GNOME Text Editor 설정하는 법

Ubuntu에서 GNOME Text Editor(기본 텍스트 편집기)가 이전에 열었던 파일들을 자동으로 복원하는 기능을 끄고, 항상 빈 페이지로 시작하도록 설정하려면 다음과 같이 사용자 정의 `.desktop` 실행 파일을 수정해야 합니다.

---

## 🔧 Step 1. 기본 실행 파일 복사

```bash
cp /usr/share/applications/org.gnome.TextEditor.desktop ~/.local/share/applications/
```

- 시스템 전체 설정을 건드리지 않고 사용자 계정 기준으로만 수정됩니다.

---

## 🔧 Step 2. 복사한 `.desktop` 파일 수정

```bash
nano ~/.local/share/applications/org.gnome.TextEditor.desktop
```

### 아래 항목 찾기:

```ini
Exec=gnome-text-editor %U
```

### 다음과 같이 수정:

```ini
Exec=gnome-text-editor --new-window %U
```

- `--new-window` 옵션을 추가하면 항상 빈 창으로 실행됩니다.

---

## 🔧 Step 3. Dock 아이콘도 수정된 설정으로 고정

1. 기존 Dock에 있는 GNOME Text Editor 아이콘 제거
2. 수정된 `.desktop` 파일을 **드래그하여 바탕화면 또는 Dock에 고정**
3. 이후 아이콘 클릭 시 항상 빈 페이지로 실행됩니다.

---

## ✅ 요약

| 항목 | 설명 |
|------|------|
| 적용 대상 | GNOME Text Editor (Ubuntu 기본 텍스트 편집기) |
| 목적 | 이전 세션 복원 방지, 항상 빈 페이지로 시작 |
| 핵심 변경 | `.desktop` 실행파일의 `Exec` 항목에 `--new-window` 옵션 추가 |

---

## 🧪 참고

- `gnome-text-editor`는 Ubuntu 22.04 이상에서 `gedit`를 대체한 기본 텍스트 에디터입니다.
- 해당 설정은 GUI로는 불가능하며 `.desktop` 파일 수정을 통해서만 가능합니다.
