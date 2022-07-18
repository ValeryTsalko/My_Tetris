package com.example.ttttttttttttttttttttttt

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ttttttttttttttttttttttt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var appPreferences: AppPreferences? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        appPreferences = AppPreferences(this)

        val animation = AnimationUtils.loadAnimation(this, R.anim.alpha)
        binding.gameTitle.startAnimation(animation)

        binding.tvHighScore.text = "${appPreferences!!.getHighScore()}"
        binding.btnExit.setOnClickListener(this::onButtonExitClick)
        binding.btnNewGame.setOnClickListener(this::onButtonNewGameClick)
        binding.btnResetScore.setOnClickListener(this::onButtonResetScore)

    }

    private fun onButtonExitClick(view: View) { // преобразутеся в лямбду, которую мы передаем в листенер
        System.exit(0)
    }


    private fun onButtonNewGameClick(view: View) {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    private fun onButtonResetScore(view: View) {
        appPreferences?.clearHighScore()
        Toast.makeText(this, "Score successfully reset", Toast.LENGTH_SHORT).show()
        binding.tvHighScore.text = "${appPreferences?.getHighScore()}"
    }
}