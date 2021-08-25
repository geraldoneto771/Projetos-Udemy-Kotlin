fun main() {

    /*if (expr1 && expr2) {
        // Código
    }
    if (expr1 || expr2) {
        // Código
    }
    if (!expr1) {
        // Código
    }
    if ((expr1 && expr2) || expr3 || expr4 ) {
        // Código
    }*/


    // Operador Elvis ?:
    val test: Int? = null
    val op: Int = test ?: 100
    println(op)


}