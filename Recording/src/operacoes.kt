fun main() {

    println("2 + 2 = ${2 + 2}")
    println("2 - 2 = ${2 - 2}")
    println("2 / 2 = ${2 / 2}")
    println("2 * 2 = ${2 * 2}")
    println("10 % 4 = ${10 % 2}")
    println("10 % 2 = ${10 % 2}")

    var numero = 10

    // ++ ou -- depois da variavel o valor acrescenta somente depois
    println("numero++ = ${numero++}")
    println("numero-- = ${numero--}")

    // ++ ou -- antes da variavel o valor já acrescenta no mesmo intante
    println("++numero = ${++numero}")
    println("--numero = ${--numero}")

    numero += 2
    println("numero+= 2 = $numero")

    numero -= 2
    println("numero-= 2 = $numero")

    numero /= 2
    println("numero/= 2  = $numero")

    numero *= 2
    println("numero*= 2 = $numero")

    numero %= 3
    println("numero%= 3 = $numero")


}

