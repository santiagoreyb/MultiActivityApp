
package com.example.taller1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView


// imports



class RandomGreet : AppCompatActivity() {


    override fun onCreate (savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.random_greet_activity)

        val selectedLanguageFromSpinner = intent.getStringExtra ("selectedLanguage").toString()

        val textViewToSet:TextView = findViewById (R.id.GreetingMessageID)
        textViewToSet.text = randomGreetMessageMethod(selectedLanguageFromSpinner)

    }

    private fun randomGreetMessageMethod (msg:String ) : String {

        return if (msg == "English") {
            "Hi"
        } else if (msg == "Français") {
            "Salut"
        } else if (msg == "Русский") {
            "Привет"
        } else if (msg == "中国人") {
            "你好"
        } else {
            "Hola"
        }

    }


}
