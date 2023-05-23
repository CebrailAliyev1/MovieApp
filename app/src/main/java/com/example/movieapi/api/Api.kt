package com.example.movieapi.api






import com.example.movieapi.model.Movie
import com.example.movieapi.model.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("movie/popular")
    fun getMovies(@Query("api_key")key:String): Call<Results>
    @GET("movie/upcoming")
    fun getMovies2(@Query("api_key")key:String) :Call<Results>


    fun getSearch(@Query("api_key")key: String):Call<Results>

}