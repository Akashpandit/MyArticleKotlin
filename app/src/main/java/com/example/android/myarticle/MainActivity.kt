package com.example.android.myarticle

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

//import android.support.v7.widget.ShareActionProvider
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.done_button1).setOnClickListener {
            addTopic(it)
        }
        findViewById<Button>(R.id.done_button2).setOnClickListener {
            addArticle(it)
        }
        findViewById<Button>(R.id.done_button3).setOnClickListener {
            addAuthor(it)
        }
        findViewById<TextView>(R.id.article_text).setOnClickListener {
            updateArticle(it)
        }
        findViewById<TextView>(R.id.author_text).setOnClickListener {
            updateAuthor(it)
        }
        //Sharing Option
        share_button.setOnClickListener {
            //Get text from TextView and store in variable "s"
            val p = usertopic_text.text.toString() + "\n "
            val q = article_text.text.toString() + "\n "
            val r = "Author : " + author_text.text.toString() + "\n "
            val s=p+q+r
            //Intent to share the text
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, s);
            startActivity(Intent.createChooser(shareIntent,"Share via"))
        }


    }
    private fun addTopic(view: View) {
        val editText = findViewById<EditText>(R.id.topic_edit)
        val nicknameTextView = findViewById<TextView>(R.id.usertopic_text)
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
    }
    private fun addArticle(view: View) {
        val editText = findViewById<EditText>(R.id.article_edit)
        val nicknameTextView = findViewById<TextView>(R.id.article_text)
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }
    private fun addAuthor(view: View) {
        val editText = findViewById<EditText>(R.id.author_edit)
        val nicknameTextView = findViewById<TextView>(R.id.author_text)
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
    private fun updateArticle (view: View) {
        val editText = findViewById<EditText>(R.id.article_edit)
        val doneButton = findViewById<Button>(R.id.done_button2)
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE
        // Set the focus to the edit text.
        editText.requestFocus()
        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)

    }
    private fun updateAuthor (view: View) {
        val editText = findViewById<EditText>(R.id.author_edit)
        val doneButton = findViewById<Button>(R.id.done_button3)
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE
        // Set the focus to the edit text.
        editText.requestFocus()
        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)

    }

}