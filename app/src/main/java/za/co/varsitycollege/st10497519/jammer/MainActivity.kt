package za.co.varsitycollege.st10497519.jammer

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val detailbutton = findViewById<Button>(R.id.detailButton)
        val exitButton = findViewById<Button>(R.id.exitButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        detailbutton.setOnClickListener {
            showDialog()
        }
        }
    fun showDialog() {
        val dialogView = Layoutinflater.from(this).inflate(R.layout.activity_details, null)
        val titleEditText = dialogView.findViewById<EditText>(R.id.titleEditText)
        val artistEditText = dialogView.findViewById<EditText>(R.id.artistEditText)
        val ratingBar = dialogView.findViewById<RatingBar>(R.id.ratingBar)
        val commentEditText = dialogView.findViewById<EditText>(R.id.commentEditText)

        AlertDialog.Builder(this)
            .setTitle("Enter Song Title")
            .setView(dialogView)
            .setPositiveButton("Submit") { _, _ ->
                val title = titleEditText.text.toString()
                val artist = artistEditText.text.toString()
                val rating = ratingBar.rating
                val comment = commentEditText.text.toString()

                val musicReview = MusicReview(title, artist, rating, comment)
                Toast.makeText(this, "Review Submitted", Toast.LENGTH_SHORT).show()

                    .setNegativeButton("Cancel") { _, _ ->}
                    .show()
    }
    }