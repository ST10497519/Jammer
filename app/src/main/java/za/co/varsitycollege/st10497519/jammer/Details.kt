package za.co.varsitycollege.st10497519.jammer

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Details : AppCompatActivity() {

    var songListView = findViewById<ListView>(R.id.songListView)
    var songList = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        songListView = findViewById<ListView>(R.id.songListView)
        songList = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, songList)
        songListView.adapter = adapter

        val songCount = 4
        for (i in 1..songCount) {
            val title = intent.getStringExtra("title$i")
            val artist = intent.getStringExtra("artist$i")
            val rating = intent.getFloatExtra("rating$i", 0.0f)
            val comment = intent.getStringExtra("comment$i")

            songList.add("Title: $title")
            songList.add("Artist: $artist")
            songList.add("Rating: $rating")
            songList.add("Comment: $comment")
            songList.add("")

        }

        val displayButton = findViewById<Button>(R.id.displayButton)
        val averageButton = findViewById<Button>(R.id.averageButton)
        val returnButton = findViewById<Button>(R.id.returnButton)

        }
        }
