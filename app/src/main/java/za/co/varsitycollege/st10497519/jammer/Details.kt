package za.co.varsitycollege.st10497519.jammer

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//ST10497519 Garrit Ievers

class Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        val displayButton = findViewById<Button>(R.id.displayButton)
        val averageButton = findViewById<Button>(R.id.averageButton)
        val returnButton = findViewById<Button>(R.id.returnButton)

        var songListView = findViewById<ListView>(R.id.songListView)
        lateinit var songList: ArrayList<String>
        lateinit var adapter: ArrayAdapter<String>

        songListView = findViewById<ListView>(R.id.songListView)
        songList = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, songList)
        songListView.adapter = adapter

        val maxSongsToShow = 4
        val actualSongs = (1..maxSongsToShow).filter {
            intent.getStringExtra("title$it")?.isNotEmpty() == true
        }
        // Display the songs
        displayButton.setOnClickListener {
            songList.clear()
            for (i in actualSongs) {
                val title = intent.getStringExtra("title$i") ?: continue
                val artist = intent.getStringExtra("artist$i") ?: ""
                val rating = intent.getStringExtra("rating$i") ?: ""
                val comment = intent.getStringExtra("comment$i") ?: ""
                // Add the song details to the list
                songList.add("Title: $title")
                songList.add("Artist: $artist")
                songList.add("Rating: $rating")
                songList.add("Comment: $comment")
                songList.add("")
            }

            adapter?.notifyDataSetChanged()
            // Set up the buttons
            returnButton.setOnClickListener {
                finish()
            }
            // Calculate the average rating
            averageButton.setOnClickListener {
                var totalRating = 0.0
                var songCount = 0
                // Iterate through the songs
                for (i in actualSongs) {
                    val ratingString = intent.getStringExtra("rating$i")
                    val rating = ratingString?.toDoubleOrNull()
                    // Calculate the total rating
                    if (rating != null) {
                        totalRating = rating
                        songCount++
                    }
                }

                val average = if (songCount > 0) totalRating / songCount else 0.0
                // Display the average rating
                Toast.makeText(this, "Average rating: %.2f".format(average), Toast.LENGTH_SHORT).show()
            }

        }
    }
}





