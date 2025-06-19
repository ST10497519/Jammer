package za.co.varsitycollege.st10497519.jammer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.LayoutInflater

class MainActivity : AppCompatActivity() {

    val titles = ArrayList<String>()
    val artists = ArrayList<String>()
    val ratings = ArrayList<Float>()
    val comments = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val detailbutton = findViewById<Button>(R.id.detailButton)
        detailbutton.setOnClickListener {
            showDetailDialog()
        }
        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            val intent = Intent(this, Details::class.java)

            for (i in titles.indices) {
                intent.putExtra("title${i + 1}", titles[i])
                intent.putExtra("artist${i + 1}", artists[i])
                intent.putExtra("rating${i + 1}", ratings[i].toString())
                intent.putExtra("comment${i + 1}", comments[i])
            }
            startActivity(intent)
        }

        val exitButton = findViewById<Button>(R.id.exitButton)

        exitButton.setOnClickListener {
            finishAffinity()

        }
    }

    fun showDetailDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.activity_main, null)
        val titleEditText = dialogView.findViewById<EditText>(R.id.titleEditText)
        val artistEditText = dialogView.findViewById<EditText>(R.id.artistEditText)
        val ratingBar = dialogView.findViewById<RatingBar>(R.id.ratingBar)
        val commentEditText =
            dialogView.findViewById<EditText>(R.id.commentEditText)


        AlertDialog.Builder(this)
            .setTitle("Enter Song Title")
            .setView(dialogView)
            .setPositiveButton("Submit") { _, _ ->
                val title = titleEditText.text.toString()
                val artist = artistEditText.text.toString()
                val rating = ratingBar.rating
                val comment = commentEditText.text.toString()

                titles.add(title)
                artists.add(artist)
                ratings.add(rating)
                comments.add(comment)

                Toast.makeText(this, "Review submitted!", Toast.LENGTH_SHORT).show()
            }

            .setNegativeButton("Cancel", null)
            .show()

    }
}










