package com.example.adda247_assignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adda247_assignment.R
import com.example.adda247_assignment.data.repository.APIrequest
import com.example.adda247_assignment.ui.adapter.Adapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception


const val BASE_URL="https://gorest.co.in/"

class MainActivity : AppCompatActivity() {




    private var namessList = mutableListOf<String>()
    private var emailsList = mutableListOf<String>()
    private var gendersList = mutableListOf<String>()
    private var statusesList = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeapirequest()
    }
    private fun setupRecyclerview(){
        rv_recyclerView.layoutManager=LinearLayoutManager(applicationContext)
        rv_recyclerView.adapter=
            Adapter(
                namessList,
                emailsList,
                gendersList,
                statusesList
            )
    }

    private fun addToList(name:String, email:String, gender:String, status:String){
        namessList.add(name)
        emailsList.add(email)
        gendersList.add(gender)
        statusesList.add(status)
    }

    private fun makeapirequest() {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIrequest::class.java)

        GlobalScope.launch(Dispatchers.IO) {



            try {
                val response=api.getUsers()

                for(info in response.data){
                    Log.i("MainActivity","Result = $info  ")
                    addToList(info.name,info.email,info.gender,info.status)

                }
                withContext(Dispatchers.Main){
                    setupRecyclerview()
                }
            }
            catch (e: Exception){
                Log.e("MainActivity", e.toString())
            }

        }
    }
}