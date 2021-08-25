package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurityPreferences = SecurityPreferences(this)

        //deixando a actionbar invisivel
        if(supportActionBar != null){
            supportActionBar!!.hide()
        }

        //chamando função do click no botão salvar
        buttonSave.setOnClickListener(this)

        verifyName()

        val securityPreferences = SecurityPreferences(this)
        securityPreferences.storeString("","")
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    private fun verifyName() {
       val nome = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        if(nome != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    //função de click no botão salvar nome
    override fun onClick(view: View?) {
        val id = view?.id
        if(id == R.id.buttonSave){
            handleSave()

        }
    }

    private fun handleSave() {
        val nome = editNome.text.toString()

        //direcionando o usuário para a activity main
        if(nome != ""){
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, nome)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }else{
            //exibindo uma msg de erro
            Toast.makeText(this, "Informe seu nome!!!", Toast.LENGTH_SHORT).show()
        }
    }
}