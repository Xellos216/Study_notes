package org.example

// 1. main 함수 (애플리케이션의 시작점)
fun main() {
    println("Hello World!") // 기존 코드 (있다면)

    // 함수 호출 예제
    println("\n--- 기본 함수 호출 실습 ---")
    // 여기는 sayHello() 호출 부분입니다. 함수 정의와 이름이 일치해야 합니다.
    sayHello() // sayHello 함수 호출

    greet("김철수") // greet 함수 호출, "김철수"를 name 매개변수에 전달
    greet("이영희")

    val sum = add(10, 20) // and 함수 호출, 반환된 값을 sum 변수에 저장
    println("10 + 20 = $sum")

    val anotherSum = add(5, 7)
    println("5 + 7 = $anotherSum")

    println("\n--- 함수 오버로딩 실습 ---")
    greet() // 매개변수 없는 greet 호출
    greet("이서진") // 이름만 있는 greet 호출 (기존 함수)
    greet("박준형", 40) // 이름과 나이 있는 greet 호출

println("\n--- 지역 함수 실습 ---")
calculateAndPrintsum(10, 5)
calculateAndPrintsum(3, 7)
}


// 이 아래 위에서 정의한 함수들을 그대로 둡니다.
fun sayHello() {
    println("안녕하세요, Kotlin 함수입니다!")
}

// 이름을 매개변수로 받고 메세지를 출력하는 함수
fun greet(name: String) {
    println("안녕하세요, $name 님!")
}

// 두 수를 더하고 결과를 반환하는 함수 (일반 방식)
fun add(a: Int, b: Int): Int {
    return a + b
}

// 두 숫자를 곱하는 단일 표현식 함수
fun multiply(x: Int, y: Int) = x * y //

// 문자열을 대문자로 바꾸는 단일 표현식 함수
fun uppercase(text: String) = text.uppercase()

// Unit (반환 값 없음) 타입을 반환하는 단일 표현식 함수 (side effect)
fun printMessage(message: String) = println(message)

// 기본값 매개변수를 가진 함수
fun introduce(name: String, age: Int = 30, city: String = "Seoul") {
    println("이름: $name, 나이: $age, 도시: $city")
}

// Unit을 명시적으로 반환하는 함수
fun doSomething(): Unit {
    println("무언가를 하고 있습니다.")
}

// Unit 반환 타입을 생략한 함수 (가장 흔한 방식)
fun doAnotherThing() {
    println("또 다른 무언가를 하고 있습니다.")
}

// 이름을 매개변수로 받는 greet 함수 (이미 정의됨)
// fun greet(name: String) {
//     println("안녕하세요, $name 님!")
// }

// 매개변수가 없는 greet 함수 (오버로딩)
fun greet() {
    println("안녕하세요, 손님!")
}

// 이름과 나이를 매개변수로 받는 greet 함수 (오버로딩)
fun greet(name: String, age: Int) {
    println("안녕하세요, $name 님 ($age 세)!")
}

fun calculateAndPrintsum(a: Int, b: Int) {
    // 지역 함수 정의: 이 함수 calculateAndPrintSum 내부에서만 사용 가능
    fun sumAndMultiply(x: Int, y: Int, multiplier: Int): Int {
        return (x + y) * multiplier
    }

    val result = sumAndMultiply(a, b, 2) // 지역 함수 호출
    println("$a 와 $b 의 합을 2배 한 값: $result")

    val anotherResult = sumAndMultiply(1, 2, 5) // 외부 함수의 다른 변수에도 접근 가능
    println("1과 2의 합을 5배한 값: $anotherResult")
}