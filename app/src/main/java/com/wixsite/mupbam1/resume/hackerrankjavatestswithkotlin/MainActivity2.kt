package com.wixsite.mupbam1.resume.hackerrankjavatestswithkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.wixsite.mupbam1.resume.hackerrankjavatestswithkotlin.databinding.ActivityMain2Binding
import com.wixsite.mupbam1.resume.hackerrankjavatestswithkotlin.databinding.ActivityMainBinding
import kotlin.concurrent.thread

val namesArrayList = ArrayList<String>()
class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    var name1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        var imBlueberry: View? = null
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun Reg (view: View) = with(binding) {
        if (btnReg.text == "Registration"
            && edConrirm.text.toString() == edPassword2.text.toString()
            && !TextUtils.isEmpty(edLogin2.getText().toString())
            && !TextUtils.isEmpty(edPassword2.getText().toString())
            && !TextUtils.isEmpty(edConrirm.getText().toString())
            && !TextUtils.isEmpty(edName.getText().toString())){
                name1 = edName.text.toString()
                namesArrayList.add(name1!!)
                Log.d("MyLog", "$namesArrayList[0]")
            imBlueberry.setVisibility(View.VISIBLE)
            combackIntent()
            }
            else {
            Toast.makeText(applicationContext, "Пароль не совпадает или есть пустые поля", Toast.LENGTH_SHORT).show()
            }
    }

    fun combackIntent(){
        val intent = Intent(this, MainActivity::class.java)
        val message = namesArrayList
        intent.putStringArrayListExtra("key", message)
        startActivity(intent)
    }
}