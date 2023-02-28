
package com.example.taller1


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.*
import java.text.FieldPosition



class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {


    var selectedLanguageFromSpinner : String = ""

    override fun onCreate (savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // GUESS GAME Button
        val playButtonListener:Button = findViewById(R.id.GuessGameButtonID)
        playButtonListener.setOnClickListener {
            guessGameClick()
        }

        // RANDOM GREET Button
        val randomGreetButtonListener:Button = findViewById (R.id.RandomGreetButtonID)
        randomGreetButtonListener.setOnClickListener {
            randomGreetClick()
        }

        // COUNTRIES Button
        val countriesButtonListener:Button = findViewById (R.id.CountriesButtonID)
        countriesButtonListener.setOnClickListener {
            countriesClick()
        }

    }

    fun guessGameClick ( ) {

        val limitNumberEditText:EditText = findViewById ( R.id.NumberRangeEditTextID )
        val limitNumberEditTextValue = limitNumberEditText.text.toString()

        if ( limitNumberEditTextValue.isNotEmpty() && limitNumberEditTextValue.toInt() in 1..1000 ) {
            // && limitNumberEditTextValue.toRegex().matches("[0-9]+")

            val intent = Intent(this, GuessGame::class.java)
            intent.putExtra("limitNumberEditText_Value", limitNumberEditTextValue)
            startActivity(intent)

        } else {

            Toast.makeText (applicationContext,"Incorrect input!",Toast.LENGTH_LONG).show()

        }

    }

    fun randomGreetClick ( ) {

        val languagesSpinner:Spinner = findViewById (R.id.CountriesListSpinnerID)
        languagesSpinner.onItemSelectedListener = this

        val selectedLanguageIntent = Intent(this,RandomGreet::class.java)
        selectedLanguageIntent.putExtra("selectedLanguage",this.selectedLanguageFromSpinner)
        startActivity(selectedLanguageIntent)

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {

        this.selectedLanguageFromSpinner = parent?.selectedItem.toString()

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    fun countriesClick ( ) {

        val countriesButtonIntent = Intent (this,Countries::class.java)
        startActivity(countriesButtonIntent)

    }


}
