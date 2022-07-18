package com.example.ttttttttttttttttttttttt

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(context: Context) {

    var prefsData: SharedPreferences = context.getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE)

    fun saveHighScore(highScore: Int) {
        prefsData.edit().putInt("HIGH_SCORE", highScore).apply()
    }

    fun getHighScore() : Int {
     return prefsData.getInt("HIGH_SCORE", 0)
    }

    fun clearHighScore() {
        saveHighScore(0)
    }
}