package collections

fun main() {

    // 불변 리스트 (Immutable List)
    val fruits = listOf("Apple", "Banana", "Orange")
    // fruits.add("Grape") // X 오류: 불변 리스트는 수정 불가

    // 가변 리스트 (Mutable List)
    val mutableFruits = mutableListOf("Apple", "Banana")
    mutableFruits.add("Grape")
    println(mutableFruits) // [Apple, Banana, Grape]

    // 불변 Set
    val number = setOf(1, 2, 3, 2) // 중복 제거됨 -> [1, 2, 3]

    // 가변 Set
    val mutableNumbers = mutableSetOf(1, 2)
    mutableNumbers.add(3)
    println(mutableNumbers) // [1, 2, 3]

    // 불변 Map
    val countryCodes = mapOf("KR" to "Korea", "US" to "USA")

    // 가변 Map
    val mutableMap = mutableMapOf("KR" to "Korea")
    mutableMap["JP"] = "Japan"
    println(mutableMap) // {KR = Korea, JP = Japan}


// --------------------
// 2단계 : 컬렉션 주요 메서드 실습
// --------------------

    val colors = listOf("Red", "Green", "Blue")

    println(colors[0])    // 인덱스로 접근 -> Red
    println(colors.contains("Green"))    // 포함 여부 -> true
    println(colors.indexOf("Blue"))    // 위치 찾기 -> 2

    val items = setOf("A", "B", "C", "A")
    println(items.size) // 중복 제거된 원소 수 -> 3
    println("A" in items) // 포함 여부 -> ture

    val ages = mapOf("Tom" to 29, "Jane" to 31)
    println(ages["Jane"])    // 31
    println(ages.containsKey("Tom"))    // True
    println(ages.keys)    // [Tom, Jane]
    println(ages.values)    // [29, 31]


// -------------------
// 3단계: 컬렉션 + 고차 함수 실습
// -------------------

    val names = listOf("Eunji", "Minho", "Jisoo")

    names.forEach { name ->
        println("안녕하세요, $name 님!")}

    val numbers = listOf(1, 2, 3)
    val squared = numbers.map {it * it } // [1, 4, 9]
    println(squared)

    val words = listOf("apple", "banana", "kiwi", "avocado")
    val aWords = words.filter { it.startsWith("a")} // ["apple", "avocado"]
    println(aWords)

    val scores = listOf(70, 85, 90, 45, 100)

    println(scores.count {it >= 80 })    // 3
    println(scores.any { it < 50})    // true
    println(scores.all { it >= 60 })    // false
    println(scores.find { it == 100})    // 100
}