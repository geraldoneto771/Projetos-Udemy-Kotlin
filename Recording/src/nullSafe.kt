fun main() {
    //? - é quando a variavel pode ser nula
    // definir como nula é mais seguro do que vazia
    val str: String? = null

    //caso a variavel for nula, trate ela como nula
    println(str?.length)

    /*if (str != null){
        println(str.length)
    }else{
        println("")
    }*/

    //rode mesmo se for da erro
    println(str!!.length)
}