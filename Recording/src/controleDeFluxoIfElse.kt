fun calculabonusCargo1(cargo: String, salario: Float): Float {
    //  Gerente Junior, Gerente Senior, Coordenador
    val bonus: Float

    if (cargo == "Coordenador") {
        bonus = salario * 0.2f
    } else if (cargo == "Gerente Junior") {
        bonus = salario * 0.5f

    } else {
        bonus = salario * 2
    }
    return bonus
}

fun calculabonusCargo2(cargo: String, salario: Float): Float {
    //  Gerente Junior, Gerente Senior, Coordenador

    return if (cargo == "Coordenador") {
        salario * 0.2f
    } else if (cargo == "Gerente Junior") {
        salario * 0.5f

    } else {
        salario * 2
    }
}



fun maiorDeIdade(idade: Int): Boolean {
    return idade >= 18
}

fun main() {
    println("BONUS: ")
    println(calculabonusCargo1("Coordenador", 1000f))

    println(calculabonusCargo1("Gerente Junior", 1000f))
    println(calculabonusCargo1("Gerente Senior", 1000f))

    println(maiorDeIdade(7))


    // operador ternário
    val valor = 10
    // String str = valor == 10 ? "Sim" :  "Não";
    val str = if (valor == 10) "Sim" else "Não"




}

