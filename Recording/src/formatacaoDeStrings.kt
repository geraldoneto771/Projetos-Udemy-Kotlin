fun main() {

    val frase = "Kotlin é uma linguagem"
    val caracteristica = " Show"
    val idade = 10
    //concatenação simples de 2 ou mais variáveis
    println(frase + caracteristica + idade)
    //concatenação de texto + variável
    println ("Kotlin é uma linguagem " + caracteristica)
    //concatenação de texto junto a $ (cifrão) e variável, forma mais limpa
    //.length informa o tamanho da variável
    println ("Kotlin é uma linguagem ${caracteristica.length}")


    val str = "String muito grande " +
            " nais textos, " +
            " mais textos"

    val str2 = """Vários textos
        |em linhas diferentes
        |sem se preocupar em utilizar o +""".trimMargin()

        println(str)
    println(str2)

}