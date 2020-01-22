package fr.epita.theghibilquizapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import okio.IOException
import retrofit2.converter.gson.GsonConverterFactory


class QuizPageActivity : AppCompatActivity(), MultiChoiceAdapter.OnListItemClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var appLogo: ImageView
    lateinit var question : TextView
    var choiceAdapter: MultiChoiceAdapter? = null
    lateinit var catItems: List<Film>

    var movieName = "Grave of the Fireflies"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv_multiple_choice)
        appLogo = findViewById(R.id.app_logo)
        appLogo.setImageResource(R.drawable.app_icon)
        question = findViewById(R.id.lbl_question)
        question.text = "Which one of these characters can be found in the movie" + movieName


        parepareData()

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        choiceAdapter = MultiChoiceAdapter(items = catItems)
        recyclerView.adapter = choiceAdapter
        choiceAdapter?.setOnItemClickListener(this)

        requestFilms()
    }

    private fun requestFilms() {
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url("https://ghibliapi.herokuapp.com/films")
             .build()

        //Api call
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: java.io.IOException) {
                Log.d("error", e.message)
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call, response: Response) {
//                Log.d("response", response.toString())
             }
        })
    }

    override fun onItemClicked(choice: Film) {
        var myIntent = Intent(this, AnswerActivity::class.java)

        startActivity(myIntent)
    }


    fun parepareData() {
        catItems = ArrayList()
        (catItems as ArrayList<Film>).add(Film("1", "Ashitaka", "", "", "", "", ""))
        (catItems as ArrayList<Film>).add(Film("2", "San", "", "", "", "", ""))
        (catItems as ArrayList<Film>).add(Film("3", "Eboshi", "", "Eboshi", "", "", ""))
        (catItems as ArrayList<Film>).add(Film("4", "Jigo", "", "", "", "", ""))
        (catItems as ArrayList<Film>).add(Film("5", "Hayao Miyazaki", "", "", "", "", ""))


    }
}

