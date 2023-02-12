package com.example.geoquizhw2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

private lateinit var trueButton: Button
    private lateinit var falseButton: Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        trueButton.setOnClickListener {
            val snackBar = Snackbar.make(
                it,
                "Correct",
                Snackbar.LENGTH_LONG
            )
            snackBar.show()
        }
        falseButton.setOnClickListener {
            val snackBar = Snackbar.make(
                it,
                "Incorrect",
                Snackbar.LENGTH_LONG
            )

            snackBar.setTextColor(Color.BLACK)
            snackBar.setBackgroundTint(Color.RED)
            snackBar.show()
        }
    }
}