// 파일명 : NullSafety.kt
fun main() {
    // 널 안정성 실습 코
    val name: String = "Alice"
    // name = null // X 오류 발생 (non-null 타입)

    var nickname: String? = "Ali"
    println("nickname 길이: ${nickname?.length}") // 안전 호출

    nickname = null
    println("nickname 길이: ${nickname?.length}") // null 출력

    var displayName = nickname ?: "손님"
    println("환영합니다, $displayName 님!") // null 일 경우 "손님"

    val title: String? = "개발자"
    title?.let {
        println("직함은 $it 입니다.") // null 아닐 때만 실행
    }

    val danger: String? = null
    // println(danger!1.length) // X 강제 호출시 NPE 발생!
}