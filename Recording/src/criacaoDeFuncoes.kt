fun calculo(a: Int, b: Int, c: Int) {
    print("O resultado da função calculo é: ")
    println("$a + $b * $c = ${a + b * c}")
}

fun hello(nome: String) : String{
   return "Olá, $nome"
}

//função de uma única linha
fun hello2(nome: String) = "Olá, $nome"

fun soma (a: Int, b: Int) = a + b

fun main() {

    val a = 10
    val b = 20
    val c = 30

    calculo(a, b, c)

   println (hello ("Geraldo"))
    println ("O resultado da função soma é: " + soma(2, 3))
}