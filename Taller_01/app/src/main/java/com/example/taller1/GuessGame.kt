
package com.example.taller1


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast



class GuessGame : AppCompatActivity() {


    override fun onCreate (savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.guess_game_activity)

        // GETTING MAIN'S INTENT
        val limitNumberFromIntent = intent.getStringExtra ("limitNumberEditText_Value")

        // Toast.makeText(applicationContext,limitNumber_fromIntent.toString(),Toast.LENGTH_LONG).show()

        // TOP MESSAGE
        val textViewToSet:TextView = findViewById (R.id.GuessNumberTextViewID)
        val guessNumberMessage = "Guess a number between 0 and "
        textViewToSet.text = guessNumberMessage; textViewToSet.append(limitNumberFromIntent)

        // RANDOM NUMBER GENERATOR
        val randomNumberToGuess = (0..limitNumberFromIntent.toString().toInt()).random()

        // Toast.makeText(applicationContext,randomNumberToGuess.toString(),Toast.LENGTH_LONG).show()

        var attemptsCounter = 0
        val playButtonListener:Button = findViewById (R.id.PlayButtonID)

        playButtonListener.setOnClickListener {

            // GETTING USER (NUMBER) INPUT
            val attemptedNumberEditText:EditText = findViewById (R.id.NumberHintEditTextID)
            val insertedNumber = attemptedNumberEditText.text.toString().toInt()

            // MODIFYING MESSAGE
            val messageTextView:TextView = findViewById (R.id.MessageTextViewID)

            if ( insertedNumber > randomNumberToGuess ) {

                val messageToSetTextView = "Inserted number: $insertedNumber. Incorrect number. The number to guess is lower."
                messageTextView.text = messageToSetTextView

            } else if ( insertedNumber < randomNumberToGuess ) {

                val messageToSetTextView = "Inserted number: $insertedNumber. Incorrect number. The number to guess is higher."
                messageTextView.text = messageToSetTextView

            } else {

                val messageToSetTextView = "Inserted number: $insertedNumber. ALL RIGHT! Uv guessed the correct number."
                messageTextView.text = messageToSetTextView

            }

            // MODIFYING COUNTER
            attemptsCounter++
            val counterTextView:TextView = findViewById (R.id.CounterTextViewID)
            counterTextView.text = attemptsCounter.toString()

        }

    }


}
