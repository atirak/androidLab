package buu.informatics.s59160624.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160624.aboutme.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            donebutton.setOnClickListener {
                addNickname(it)
            }
            nicknameText.setOnClickListener {
                updateNickname(it)
            }
        }

    }
    private fun updateNickname (view: View) {

        binding.apply {
            nicknameedit.visibility = View.VISIBLE
            nicknameText.visibility =  View.GONE


           donebutton.visibility = View.VISIBLE

            nicknameedit.requestFocus()

            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.showSoftInput(nicknameedit, 0)
        }


    }
    private fun addNickname(view: View) {
        binding.apply {
           nicknameText.text = nicknameedit.text
          nicknameedit.visibility = View.GONE
          nicknameText.visibility = View.VISIBLE


           donebutton.visibility = View.GONE

            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }
}
