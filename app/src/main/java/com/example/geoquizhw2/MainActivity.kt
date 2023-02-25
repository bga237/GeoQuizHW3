package com.example.geoquizhw2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import com.example.geoquizhw2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    //EX 1
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
    //EX 3
    private var correctAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate (Bundle?) called") //EX 1

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.trueButton.setOnClickListener {
            binding.trueButton.isEnabled = false
            binding.falseButton.isEnabled = false

            val snackBar = Snackbar.make(
                it,
                "Correct",
                Snackbar.LENGTH_LONG)
            snackBar.show()
        }

        binding.falseButton.setOnClickListener {
            binding.trueButton.isEnabled = false
            binding.falseButton.isEnabled = false

            if (questionBank[currentIndex].answer) {
                correctAnswers++
            }
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
            binding.trueButton.isEnabled = true
            binding.falseButton.isEnabled = true
            updateQuestion()
        }

        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            binding.trueButton.isEnabled = true
            binding.falseButton.isEnabled = true
            updateQuestion()
        }
        binding.previousButton.setOnClickListener{
            currentIndex = (currentIndex - 1) % questionBank.size
            binding.trueButton.isEnabled = true
            binding.falseButton.isEnabled = true
            updateQuestion()
        }

            //currentIndex = 0

        updateQuestion()
        // call to the function
    }
    private fun getScorePercentage(): Int {
        val totalQuestions = questionBank.size
        val score = correctAnswers
        return ((score.toDouble() / totalQuestions) * 100).toInt()
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionText.setText(questionTextResId)
        // setting text to resource id

        if (currentIndex == questionBank.size -1) {
            val scorePercent = getScorePercentage()
            val message = "Your score: ${scorePercent}%"
            val snackBar = Snackbar.make(
                binding.root,
                message,
                //String.format("Your score: $scorePercent%", scorePercent),
                Snackbar.LENGTH_SHORT
            )
            //toast.setGravity(Gravity.CENTER, 0, 0)
            snackBar.show()

            correctAnswers = 0

        }
    }

    //EX 1
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }
}