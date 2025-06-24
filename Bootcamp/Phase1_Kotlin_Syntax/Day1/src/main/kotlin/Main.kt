package org.example

fun main() {
    // 1. val (읽기 전용/immutable) 변수 선언
    val myName = "H"
    val currentYear = 2025
    val piValue = 3.14159 // Double 타입 (소수점 있는 숫자)

    println("안녕하세요, 제 이름은 $myName 입니다.") // 문자열 템플릿 사용
    println("현재 연도는 $currentYear 년입니다.")
    println("원주율 값은 $piValue 입니다.")

    // 2. var (변경 가능/mutable) 변수 선언 및 값 변경
    var currentStatus = "Kotlin 학습 중"
    println("현재 상태 : $currentStatus")

    currentStatus = "IntelliJ IDEA 적응 중" // var 변수는 값을 변경 가능함
    println("변경 후 상태: $currentStatus")

    var coffeeCount = 0
    println("마신 커피 잔 수: $currentStatus")
    coffeeCount += 1
    println("한 잔 더! 총 마신 커피 잔 수: $coffeeCount")

    // 3.Boolean 타입 변수 선언
    val isSunny = true
    println("오늘 날씨는 화창한가요? $isSunny")

    // 4. if/else 조건문 사용 예제
    val age = 20 // 이 값을 바꿔가면서 실행해보세요.

    if (age >= 19) {
        println("나이: $age -> 성인입니다.")
    } else {
        println("나이: $age -> 미성년자입니다.")
    }

    val temperature = 25 // 이 값을 바꿔 가면서 실행해보세요.

    if (temperature > 30) {
        println("온도: $temperature -> 매우 덥습니다.")
    } else if (temperature > 20) { //20 초과 30 이하
        println("온도: $temperature -> 쾌적한 날씨입니다.")
    } else {
        println("온도: $temperature -> 시원합니다.")
    }

    // 5. when 조건문 사용 예제 (Kotlin의 강력한 기능)
    val dayofWeek = 3 // 1:월, 2:화, ..., 7:일. 이 값을 바꿔가면서 실행해보세요.

    when (dayofWeek) {
        1 -> println("요일: $dayofWeek -> 월요일입니다.")
        2 -> println("요일: $dayofWeek -> 화요일입니다.")
        3 -> println("요일: $dayofWeek -> 수요일입니다.")
        in 4..5 -> println("요일: $dayofWeek -> 목요일 또는 금요일입니다.") // 범위 지정
        6, 7 -> println("요일: $dayofWeek -> 주말입니다.") // 여러 값 지정
        else -> println("요일: $dayofWeek -> 알 수 없는 요일입니다.")
    }

    val score = 85 // 이 값을 바꿔가면서 실행해보세요.

    when (score) {
        in 90..100 -> println("점수: $score -> A 학점")
        in 80..89 -> println("점수: $score -> B 학점")
        in 70..79 -> println("점수: $score -> C 학점")
        else -> println("점수: $score -> F학점")
    }

    // when 문은 표현식으로도 사용 가능 (값을 반환)
    val grade = when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "F"
    }
    println("최종 학점은 $grade 입니다.")

    // 6. for 반복문 사용 예제
    println("\n--- for 반복문 ---") // 출력 구분을 위한 줄 추가

    // 1부터 5까지 출력 (정수 범위)
    for (i in 1..5) { //1부터 5까지 포함시
        println("for 루피 (1..5): $i")
    }

    println("-----")

    // 5부터 1까지 역순으로 출력
    for (i in 5 downTo 1) { // 5부터 1까지 역순으로
        println("for 루프 (5 downTo 1): $i")
    }

    println("-----")

    // 1부터 10까지 2씩 증가하며 출력 (단계별 증가하며)
    for (i in 1..10 step 2) { // 1, 3, 5, 7, 9 출력
        println("for 루프 (1..10 step 2): $i")
    }

    println("-----")

    // 컬렉션(List) 순회
    val programmingLanguages = listOf("Kotlin", "Java", "Python", "JavaScript") //
    println("좋아하는 프로그래밍 언어:")
    for (lang in programmingLanguages) {
        println("- $lang")
    }

    // 인덱스와 함께 컬렉션 순회 (forEachIndexed)
    programmingLanguages.forEachIndexed { index, lang ->
        println("인덱스 $index: $lang")
    }

    // 7.while 반복문 사용 예제
    println("|n--- while 반복문 ---") // 출력 구분을 위한 줄 추가

    var counter = 0
    while (counter < 3) {
        println("while 루프: $counter")
        counter++ // counter = counter + 1 과 동일
    }

    println("-----")

    //do-while 반복문 예제 (조건을 나중에 검사, 최소 한 번 실행 보장)
    var userInput: String // 사용자 입력을 받을 변수

    do {
        println("이름을 입력하세요 (종료하려면 'exit' 입력): ")
        // Vscode의 input ()과 유사하게, Kotlin은 readln() 함수를 사용합니다.
        // 이 부분은 Intellij IDEA의 'Run' 탭 콘솔에서는 입력이 불가능합니다.
        // 반드시 'Terminal' 탭을 열고 './gradlew run' 명령으로 실행해야 입력 가능합니다.
        userInput = readlnOrNull() ?: "" // readlnOrNull()은 null을 반환할 수 있으므로,
        if (userInput != "exit") {
            println("환영합니다, $userInput 님!")
        }
    }while (userInput != "exit") // 'exit'이 아니면 계속 반복
    println("프로그램을 종료합니다.")
}


