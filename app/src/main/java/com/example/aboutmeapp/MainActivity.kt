package com.example.aboutmeapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutmeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aleks Haecky")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }

    }

    private fun addNickname(view: View) {
        binding.apply {
            nicknameText.text = nicknameEdit.text.toString()//nimmy
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

    }


    private fun updateNickname(view: View) {
        binding.apply{
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE
            nicknameEdit.text.clear()
            nicknameEdit.requestFocus()
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)
    }

}
