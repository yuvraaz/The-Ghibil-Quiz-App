package fr.epita.theghibilquizapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import okio.IOException


class QuizPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
                Log.d("response", response.toString())
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}

