package buu.informatics.s59160624.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.donebutton).setOnClickListener {
            addNickname(it)
        }
        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }
    }
    private fun updateNickname (view: View) {
        val editText = findViewById<EditText>(R.id.nicknameedit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        editText.visibility = View.VISIBLE
        nicknameTextView.visibility =  View.GONE

        val donebutton = findViewById<Button>(R.id.donebutton)
        donebutton.visibility = View.VISIBLE

        editText.requestFocus()

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(editText, 0)
    }
    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nicknameedit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        val donebutton = findViewById<Button>(R.id.donebutton)
        donebutton.visibility = View.GONE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
