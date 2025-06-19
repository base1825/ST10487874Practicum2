package da.co.varsitycollege.st10487874.practicum2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
// receive data from mainActivity
        val songtitle=intent.getStringArrayListExtra("songtitle")
        val ArtistName= intent.getStringArrayListExtra("ArtistName")
        val Rating= intent.getStringArrayListExtra("Rating")
        val comments=intent.getStringArrayListExtra("comments")
        // VIEWS
        val detailButton=findViewById<AppCompatButton>(R.id.detailButton)
        val avegButton= findViewById<AppCompatButton>(R.id.avegButton)
        val backButton= findViewById<AppCompatButton>(R.id.backButton)
        val container = findViewById<LinearLayout>(R.id.scrollLinearLayout)
// back to the main activity
        backButton.setOnClickListener {
            finish()
        }
        avegButton.setOnClickListener {
            fun calculateAverageRating(Rating: Array<Double>): Double {
                if (Rating.isEmpty()) {

                }
                val sum = Rating.sum()
                return sum / Rating.size
            }

        }

        // checking if data is not null if (songtitle.isNotEmpty() && ArtistName.isNotEmpty() && Rating.isNotEmpty()&& comments.isNotEmpty()) {
// create parent layout for each song
        if (songtitle != null) {
            for (i in songtitle.indices)

                detailButton.setOnClickListener {  // make the detail button display all details
                    val songtitleLayout = LinearLayout(this).apply {
                        orientation = LinearLayout.VERTICAL
                        setPadding(32, 24, 32, 24)

                        layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        ).apply {
                            setMargins(24, 16, 24, 16)
                        }
                    }

                    // textview for songs names
                    val songtitleText = TextView(this).apply {
                        text = songtitle[i]
                        textSize = 30f

                    }
                    // textView for artist name
                    val artistNameText = TextView(this).apply {
                        text = "Artist: ${ArtistName?.get(i)}"
                        textSize = 24f

                    }
                    // textView for Ratings
                    val RatingText = TextView(this).apply {
                        text = "Rating: ${Rating?.get(i)}"
                        textSize = 18f


                    }
                    // textVIEW FOR Comment
                    val commentText = TextView(this).apply {
                        text = "Comment: ${comments?.get(i)}"
                        textSize = 18f
                    }


                    // add the textviews to the songstitle layout
                    songtitleLayout.addView(songtitleText)
                    songtitleLayout.addView(artistNameText)
                    songtitleLayout.addView( RatingText)
                    songtitleLayout.addView(commentText)


                    // Add the song layout  container
                    container.addView(songtitleLayout)
                }
        }




    }
}