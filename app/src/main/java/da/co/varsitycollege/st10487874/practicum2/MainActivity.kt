package da.co.varsitycollege.st10487874.practicum2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val addButton = findViewById<AppCompatButton>(R.id.addButton)
        val exitButton= findViewById<AppCompatButton>(R.id.exitButton)
        val nextButton= findViewById<AppCompatButton>(R.id.nextButton)
        val editText= findViewById<EditText>(R.id.editTextText)
        val text2= findViewById<EditText>(R.id.Text2)
        val text3= findViewById<EditText>(R.id.Text3)
        val text4= findViewById<EditText>(R.id.Text4)
        val songtitle=  mutableListOf<String>()
        val ArtistName=  mutableListOf<String>()
        val Rating=  mutableListOf<String>()
        val comments=  mutableListOf<String>()

        addButton.setOnClickListener{
            val userInput1 =editText.text.toString().trim().lowercase()
            val userInput2=text2.text.toString().trim().lowercase()
            val userInput3= text3.text.toString().trim().lowercase()
            val userInput4= text4.text.toString().trim().lowercase()
        }
        nextButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        val intent= Intent(this,SecondActivity::class.java)
        intent.putStringArrayListExtra("song", ArrayList(songtitle))
        intent.putStringArrayListExtra("artist",ArrayList(ArtistName))
        intent.putStringArrayListExtra("rating",ArrayList(Rating))
        intent.putStringArrayListExtra("comment", ArrayList(comments))
        startActivity(intent)

        exitButton.setOnClickListener {
            finish()
        }

    }
}