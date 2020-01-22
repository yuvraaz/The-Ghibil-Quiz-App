package fr.epita.theghibilquizapp

import retrofit2.http.GET

interface CarService {
    @GET("films")
     fun getFilms(): List<Film?>

    @GET("people")
    fun getFilmCharacters(): List<Character?>

}