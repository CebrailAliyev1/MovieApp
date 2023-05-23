package com.example.movieapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapi.databinding.ActivityMainBinding
import com.example.movieapi.model.Results
import com.example.movieapi.network.Constants
import com.example.movieapi.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       binding.reycylerview2.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
    getMovies()
        getMovies2()

    }
    fun getMovies(){
        val call: Call<Results> = RetrofitClient.getRetrofitInstance()?.getApi()?.getMovies(Constants.key)!!
        call?.enqueue(object : Callback<Results> {
            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                val newsList: Results = response?.body() as Results
               binding.recyclerView.adapter= com.example.movieapi.adapter.Adapter(newsList.results)

            }
            override fun onFailure(call: Call<Results>, t: Throwable?) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
                Log.e("dwjnw", t!!.message.toString())
            }
        })
    }

    fun getMovies2(){
        val call: Call<Results> = RetrofitClient.getRetrofitInstance()?.getApi()?.getMovies2(Constants.key)!!
        call?.enqueue(object : Callback<Results> {
            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                val newsList: Results = response?.body() as Results
                binding.reycylerview2.adapter= com.example.movieapi.adapter.Adapter2(newsList.results)

            }
            override fun onFailure(call: Call<Results>, t: Throwable?) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
                Log.e("dwjnw", t!!.message.toString())
            }
        })
    }


}