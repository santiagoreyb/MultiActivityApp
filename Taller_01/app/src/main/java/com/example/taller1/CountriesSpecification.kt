
package com.example.taller1


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.net.URL
import java.nio.file.Files
import java.nio.file.Paths


class CountriesSpecification : AppCompatActivity() {


    override fun onCreate (savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView (R.layout.specification_activity)

        val infoSelectedCountryIntent:Array<String> = intent.getStringArrayExtra("countryInfo") as Array<String>

        setCountryInfo(infoSelectedCountryIntent)

    }

    private fun setCountryInfo ( strings:Array<String> ) {

        val textViewToSetCapital:TextView = findViewById (R.id.CapitalTextViewID)
        textViewToSetCapital.text = strings[0]

        val textViewToSetName:TextView = findViewById (R.id.CountryName01TextViewID)
        textViewToSetName.text = strings[1]

        val textViewToSetNameInt:TextView = findViewById (R.id.CountryName02TextViewID)
        textViewToSetNameInt.text = strings[2]

        val textViewToSetInitials:TextView = findViewById (R.id.CountryInitialsTextViewID)
        textViewToSetInitials.text = strings[3]

    }


}
