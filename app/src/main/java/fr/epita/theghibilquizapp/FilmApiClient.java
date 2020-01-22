package fr.epita.theghibilquizapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FilmApiClient {
    public static final String baseurl = "https://ghibliapi.herokuapp.com/";
    public Retrofit getClient() {
        return new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}