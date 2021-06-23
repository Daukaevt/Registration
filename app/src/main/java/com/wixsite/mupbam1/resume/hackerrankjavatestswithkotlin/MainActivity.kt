package com.wixsite.mupbam1.resume.hackerrankjavatestswithkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.wixsite.mupbam1.resume.hackerrankjavatestswithkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun init() = with(binding){
        val messageArr = intent.getStringArrayListExtra("key")
        var name1 = messageArr?.get(0)
        if (name1 == null) {
            name.text = "CHUVASYA"
        }
        else name.text = name1
    }

    fun signIn (view: View) = with(binding){
        init()
        if (!TextUtils.isEmpty(edLogin.getText().toString()) && !TextUtils.isEmpty(edPassword.getText().toString())){
            imageView.setVisibility(View.VISIBLE)
            name.setVisibility(View.VISIBLE)
        }
        else Toast.makeText(applicationContext, "Пустое поле", Toast.LENGTH_SHORT).show()
    }

    fun signOut (view: View)= with(binding){
        ActReg()
    }
    fun ActReg() {
       val ActRegIntent = Intent(this, MainActivity2::class.java)
    //    Log.d("MyLog", "ActRegIntent")          чтобы не забыть
        startActivity(ActRegIntent)
    }
}