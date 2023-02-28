
package com.example.taller1


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream



class Countries : AppCompatActivity() {


    override fun onCreate (savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView (R.layout.countries_activity)

        val countriesArray = fromJsonArrayToArray(loadJsonElementsIntoJsonArray("nombre_pais"))

        loadJsonElementsIntoListView(countriesArray).onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick ( parent:AdapterView<*>? , view:View? , pos:Int , id:Long ) {

                val countryIntent = Intent(baseContext,CountriesSpecification::class.java)

                val generalInfoCountry = getInfo(countriesArray,pos)
                countryIntent.putExtra("countryInfo",generalInfoCountry)

                startActivity(countryIntent)

            }

        }

    }

    private fun loadJSONFromAsset ( ) : String {

        val json: String?

        try {

            val istream: InputStream = assets.open ("paises.json")
            val size: Int = istream.available()
            val buffer = ByteArray (size)
            istream.read(buffer)
            istream.close()
            json = String(buffer, Charsets.UTF_8)

        } catch (ex: IOException) {

            ex.printStackTrace()
            return ""

        }

        return json

    }

    private fun loadJsonElementsIntoJsonArray ( fieldSelection:String ) : JSONArray {

        val json = JSONObject(loadJSONFromAsset())

        val paisesJsonArray = json.getJSONArray("paises")

        for (i in 0 until paisesJsonArray.length()) {
            val jsonObject = paisesJsonArray.getJSONObject(i)
            val field = jsonObject.getString(fieldSelection)
            paisesJsonArray.put(i,field)
        }

        return paisesJsonArray
    }

    private fun fromJsonArrayToArray ( paisesJsonArray:JSONArray ) : Array<String> {

        return Array(paisesJsonArray.length()) { paisesJsonArray.getString(it) }

    }

    private fun loadJsonElementsIntoListView ( countriesArray:Array<String> ) : ListView {

        // LOADING JSON ARRAY into LISTVIEW
        val adapter = ArrayAdapter(this , android.R.layout.simple_list_item_1 , countriesArray)
        val listView:ListView = findViewById(R.id.CountriesListID)
        listView.adapter = adapter

        return listView
    }

    private fun getInfo ( countriesArray:Array<String> , pos:Int ) : Array<String> {

        val infoCountryArray = arrayOf<String>("Capital","Name_01","Name_02","Initials")

        val capitalsArray = fromJsonArrayToArray(loadJsonElementsIntoJsonArray("capital"))
        val countriesIntArray = fromJsonArrayToArray(loadJsonElementsIntoJsonArray("nombre_pais_int"))
        val initialsArray = fromJsonArrayToArray(loadJsonElementsIntoJsonArray("sigla"))

        infoCountryArray[0] = capitalsArray[pos]
        infoCountryArray[1] = countriesArray[pos]
        infoCountryArray[2] = countriesIntArray[pos]
        infoCountryArray[3] = initialsArray[pos]

        return infoCountryArray
    }


}
