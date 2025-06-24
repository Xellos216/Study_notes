1. nano 편집기를 사용하여 생성 (초보자에게 더 친숙)
nano는 사용하기 쉬운 터미널 기반 텍스트 편집기입니다.

Kotlin_basic_1 프로젝트 루트 디렉토리로 이동
Bash

cd ~/git_repos/Kotlin/Kotlin_Phase_1/Kotlin_basic_1

nano로 .gitignore 파일 열기/생성

Bash
nano .gitignore

이 명령어를 실행하면 nano 편집기가 열리면서 .gitignore 파일을 생성하거나, 이미 있다면 그 내용을 보여줍니다.

내용 붙여넣기:
이전에 제가 드린 .gitignore 내용을 복사하여 nano 편집기 창에 붙여넣습니다. (WSL/Ubuntu 터미널에서는 마우스 우클릭으로 붙여넣기가 됩니다.)

# IntelliJ IDEA files
.idea/
*.iml
*.ipr
*.iws

# Gradle
.gradle/
build/
.gradle-version
!gradle/wrapper/gradle-wrapper.jar # Gradle Wrapper는 포함 (버전 일관성)

# Kotlin
*.class
*.jar
*.war
*.kapt.
*.kotlin_module
.kotlin/

저장 및 종료:
파일을 저장하려면 Ctrl 키와 O 키를 동시에 누릅니다 (화면 하단에 "File Name to Write: .gitignore"라고 뜨면 Enter 키를 누릅니다).
nano 편집기를 종료하려면 Ctrl 키와 X 키를 동시에 누릅니다.

2. vim 편집기를 사용하여 생성 (숙련자용)

vim은 강력하지만 사용법이 다소 복잡할 수 있습니다. 이미 익숙하시다면 사용하셔도 좋습니다.
Kotlin_basic_1 프로젝트 루트 디렉토리로 이동

Bash
cd ~/git_repos/Kotlin/Kotlin_Phase_1/Kotlin_basic_1

vim으로 .gitignore 파일 열기/생성

Bash
vim .gitignore

내용 입력 모드로 전환: i 키를 눌러 입력(INSERT) 모드로 전환합니다.
내용 붙여넣기: 위에 드린 .gitignore 내용을 붙여넣습니다.
입력 모드 종료: Esc 키를 누릅니다.
저장 및 종료: :wq를 입력하고 Enter 키를 누릅니다. (저장하지 않고 종료는 :q!)
