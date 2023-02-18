package com.example.geoquizhw2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.geoquizhw2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.trueButton.setOnClickListener {
            val snackBar = Snackbar.make(
                it,
                "Correct",
                Snackbar.LENGTH_LONG
            )
            snackBar.show()
        }
        binding.falseButton.setOnClickListener {
            val snackBar = Snackbar.make(
                it,
                "Incorrect",
                Snackbar.LENGTH_LONG
            )

            snackBar.setTextColor(Color.BLACK)
            snackBar.setBackgroundTint(Color.RED)
            snackBar.show()

        }
        binding.questionText.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }
        binding.nextButton.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            //val questionTextResId = questionBank[currentIndex].textResId
            //binding.questionText.setText(questionTextResId)
            updateQuestion()

        }
        binding.previousButton.setOnClickListener{
            currentIndex = (currentIndex - 1) % questionBank.size
            //val questionTextResId = questionBank[currentIndex].textResId
            //binding.questionText.setText(questionTextResId)
            updateQuestion()

        }

        updateQuestion()
        // call to the function
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionText.setText(questionTextResId)
        // setting text to resource id
    }
}