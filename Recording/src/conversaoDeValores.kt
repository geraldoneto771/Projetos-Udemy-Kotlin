/**
Type Bit
Double 64
Float 32
Long 64
Int 32
Short 16
Byte 8
Boolean ?
String ?
char ?
 */

/**
Lembrando sobre unidades de medida
1 Byte = 8 bits
1 kilobyte (kB) = 1024 bytes
1 megabyte (MB) = 1024 kilobytes
1 gigabyte (GB) = 1024 megabytes
 */
fun main() {

    /*val l1 Long = 100
    teste(1 * l1)*/

    /*val n1: Double = Double.MAX_VALUE
    val b1: Byte = 100

    println(b1.toShort())
    println(b1.toLong())
    println(b1.toFloat())
    println(b1.toDouble())*/

    /*println("19".toInt())
    println("19".toFloat())
    println("19".toDouble())*/

    /*sempre colocar a excessão
    mais expecifica primeiro visto que o e: exception é
    mais generico*/
    try {
        println("csad".toInt())

    } catch(e: NumberFormatException) {
        println("Esse valor não é um numero!")
    }
    catch (e: Exception) {
        println("Algo de errado ocorreu")
    } finally {
        // finally serve para verificar erros na
            // abertura de banco de dados, arquivos
                // que estão em uso etc.
                    //feche o arquivo caso tenha dado erro de exceção
        println("finally")
    }


}