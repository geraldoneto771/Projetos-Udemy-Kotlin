package com.example.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*pegando o id do botao calcular e chamando a função onclick nele e passando um
        contrutor com this, chamando a função override Onclick */
        buttonCalculate.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        //salvando o id do xml clicado em uma variavel
        val id = view.id
        //se o id do botão for buttonCalculate chame a função calcular
        if (id == R.id.buttonCalculate) {
            /*chamando a função calcular com a lógica do calculo*/
            calculate()
        }
        //chamando uma notificação

    }

    //função com a lógica de calculo
    private fun calculate() {
        if (validationOK()) {
            try {
                //guardando os valores do campo de texto nas variaveis
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                //guardando o resultado do calculo em uma variavel
                val totalValue = (distance * price) / autonomy
                //alterando o valor do Textview para o valor da variavel totalValue
                textTotalValue.text = " R$ ${"%.2f".format(totalValue)}"
            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.informe_valores_validos), Toast.LENGTH_LONG)
                    .show()
            }
        } else {
            Toast.makeText(this, getString(R.string.preencha_todos_campos), Toast.LENGTH_LONG)
                .show()
        }

    }

    //função para validar a entrada de dados se possui ou não entrada de dados
    private fun validationOK(): Boolean {
        return (editDistance.text.toString() != ""
                && editPrice.text.toString() != ""
                && editAutonomy.text.toString() != ""
                && editAutonomy.text.toString() != "0")

    }
}