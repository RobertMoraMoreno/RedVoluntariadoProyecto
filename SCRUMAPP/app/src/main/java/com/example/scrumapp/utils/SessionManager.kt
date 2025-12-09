package com.example.scrumapp.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE

data class UserSession(
    val userId: Int,
    val email: String,
    val rol: String
)

class SessionManager(private val context: Context) {
    private val prefs = context.getSharedPreferences("user_session", MODE_PRIVATE)

    fun saveSession(userId: Int, email: String, rol: String) {
        prefs.edit().apply {
            putInt("user_id", userId)
            putString("email", email)
            putString("rol", rol)
            putBoolean("is_logged_in", true)
            apply()
        }
    }

    fun getSession(): UserSession? {
        if (!isLoggedIn()) return null
        return UserSession(
            userId = prefs.getInt("user_id", -1),
            email = prefs.getString("email", "") ?: "",
            rol = prefs.getString("rol", "") ?: ""
        )
    }

    fun clearSession() {
        prefs.edit().clear().apply()
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean("is_logged_in", false)
    }
}