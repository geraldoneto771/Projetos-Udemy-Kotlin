fun main() {
    //chamando a função operação
    operacao(2,3,"Soma")

}
fun operacao (a: Int, b: Int, c: String) {

    //When - caso for, faça
    when (c) {
        // caso C seja Soma chame
        "Soma" -> return println("O resultado da soma de $a + $b é: ${a + b}")
        // caso C seja Subtração chame
        "Subtração" -> return println("O resultado da subtração de $a - $b é: ${a - b}")
        // caso C seja qualquer outra operação chame
        else -> {
            return println("Operação incorreta")
        }
    }
}








    /*when {
        a > 0 && b > 0 -> {
            println("Variaveis maiores que zero")
        }
    }
    // range - intervalo de valor - .. 1..10 ou 1..100
    when  {
       a in 1..99 && b > 0 -> {
            println("Seculo")
        }
    }
}*/

