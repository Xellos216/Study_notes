package org.example

// Car 클래스 정의
class Car {
    // 속성 (Properties)
    var brand: String = "Unknown" // 브랜드 (문자열)
    var year: Int = 2020          // 생산 연도 (정수)

    // 메소드 (Methods)
    fun start() {
        println("${brand} 자동차가 시동을 겁니다.")
    }

    fun drive() {
        println("${brand} 자동차 운전 중입니다.")
    }
}

// Person 클래스 정의 (기본 생성자 포함)
class Person(val name: String, var age: Int) { // name과 age가 주 생성자의 매개변수이자 동시에 클새스 속성이 됨
    fun introduce() {
        println("안녕하세요, 제 이름은 ${name}이고, ${age}살입니다.")
    }

    fun birthday() {
        age++ // age는 var이므로 변경 가능
        println("생일 축하합니다! 이제 ${age}살이 되었습니다.")
    }
}

class Student(val name: String, var entryYear: Int) { // 기본 생성자를 (이름, 입학년도)로 변경
    var studentId: String = "S-" + entryYear.toString() + (1000..9999).random().toString() // 학번은 자동 생성
    var grade: String = "Freshman" // 추가 속성

    // 초기화 블록: 기본 생성자나 보조 생성자 호출 시 모두 실행됨
    init {
        println("학생 ${name}이(가) 등록되었습니다. 학번: ${studentId}")
    }

    // 보조 생성자 1: 이름과 학년만으로 생성 (입학년도는 현재 연도 2025 사용)
    constructor(name: String, grade: String) : this(name, 2025) { // 주 생성자 호출 시 입학년도 2025 전달
        this.grade = grade // 추가 속성 초기화
        println("보조 생성자 1 호출됨: ${name} (${grade} 학년)")
    }

    // 보조 생성자 2: 이름만으로 생성 (학번과 학년 모두 기본값 또는 자동 생성)
    constructor(name: String) : this(name, 2025) { // 주 생성자 호출 시 입학년도 2025 전달
        this.grade = grade
        println("보조 생성자 2 호출됨: ${name}")
    }

    fun getInfo() {
        println("이름: ${name}, 학번: ${studentId}, 학년: ${grade}")
    }
}


// main 함수: 클래스를 사용하여 객체를 만들고 속성을 설정하여 메소드를 호출합니다.
fun main() {
    println("--- 클래스와 객체 실습: Car ---")

    // Car 클래스의 객체 (인스턴스) 생성
    val myCar = Car()

    // 객체의 속성 설정 (값 할당)
    myCar.brand = "Hyundai"
    myCar.year = 2023

    // 객체의 속성 출력
    println("내 차 브랜드: ${myCar.brand}")
    println("내 차 생산 연도: ${myCar.year}")

    // 객체의 메소드 호출
    myCar.start()
    myCar.drive()

    println("\n--- 다른 Car 객체 생성 ---")
    val yourCar = Car()
    yourCar.brand = "Kia"
    yourCar.year = 2022
    println("너의 차 브랜드: ${yourCar.brand}")
    yourCar.drive()

    // Person 클래스의 객체 생성 시 초기 값 전달
    val person1 = Person("김민수", 25)
    person1.introduce()
    person1.birthday() // 나이 증가
    person1.introduce()

    val person2 = Person("박지민", 30)
    person2.introduce()

    println("\n--- 클래스와 객체 실습: Student (생성자) ---")

    // 1. 기본 생성자로 Student 객체 생성
    val student1 = Student("김철수", "2023001")
    student1.getInfo()

    println("----")

    // 2. 이름과 학년으로 보조 생성자를 사용하여 Student 객체 생성
    val student2 = Student("이영희", "Sophomore")
    student2.getInfo()

    println("----")

    // 3. 이름만으로 보조 생성자를 사용하여 Student 객체 생성
    val student3 = Student("박민수")
    student3.getInfo()
}

