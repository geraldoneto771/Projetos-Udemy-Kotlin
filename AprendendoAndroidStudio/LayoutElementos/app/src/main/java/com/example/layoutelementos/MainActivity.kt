package com.example.layoutelementos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkColor.setOnClickListener{
            //Lógica
            if (checkColor.isChecked) {
                imgAndroid.setColorFilter(resources.getColor(R.color.red))
            }else{
                imgAndroid.setColorFilter(resources.getColor(R.color.black))
            }
        }

    }

}
