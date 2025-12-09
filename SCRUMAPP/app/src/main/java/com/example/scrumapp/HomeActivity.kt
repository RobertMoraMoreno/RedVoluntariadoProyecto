package com.example.scrumapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.scrumapp.utils.SessionManager

class HomeActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var tvWelcome: TextView
    private lateinit var btnVerProyectos: Button
    private lateinit var btnCrearProyecto: Button
    private lateinit var btnMiPerfil: Button
    private lateinit var btnMisProyectos: Button
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sessionManager = SessionManager(this)

        tvWelcome = findViewById(R.id.tvWelcome)
        btnVerProyectos = findViewById(R.id.btnVerProyectos)
        btnCrearProyecto = findViewById(R.id.btnCrearProyecto)
        btnMiPerfil = findViewById(R.id.btnMiPerfil)
        btnMisProyectos = findViewById(R.id.btnMisProyectos)
        btnLogout = findViewById(R.id.btnLogout)

        val session = sessionManager.getSession()
        tvWelcome.text = "Bienvenido, ${session?.email ?: "Usuario"}"

        // Mostrar botón Crear Proyecto solo para organizaciones
        if (session?.rol == "organizacion") {
            btnCrearProyecto.visibility = View.VISIBLE
        } else {
            btnCrearProyecto.visibility = View.GONE
        }

        btnVerProyectos.setOnClickListener {
            Toast.makeText(this, "Funcionalidad disponible en Sprint #4", Toast.LENGTH_SHORT).show()
        }

        btnCrearProyecto.setOnClickListener {
            Toast.makeText(this, "Funcionalidad disponible en Sprint #5", Toast.LENGTH_SHORT).show()
        }

        btnMiPerfil.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        btnMisProyectos.setOnClickListener {
            Toast.makeText(this, "Funcionalidad disponible en Sprint #7", Toast.LENGTH_SHORT).show()
        }

        btnLogout.setOnClickListener {
            sessionManager.clearSession()
            Toast.makeText(this, "Sesión cerrada", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}