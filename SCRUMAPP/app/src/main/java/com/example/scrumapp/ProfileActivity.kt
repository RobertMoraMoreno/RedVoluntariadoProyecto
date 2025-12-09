package com.example.scrumapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.scrumapp.database.AppDatabase
import com.example.scrumapp.utils.SessionManager
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ProfileActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase
    private lateinit var sessionManager: SessionManager
    private lateinit var tvNombre: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvRol: TextView
    private lateinit var tvCiudad: TextView
    private lateinit var tvFechaRegistro: TextView
    private lateinit var btnEditarPerfil: Button
    private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        database = AppDatabase.getDatabase(this)
        sessionManager = SessionManager(this)

        tvNombre = findViewById(R.id.tvNombre)
        tvEmail = findViewById(R.id.tvEmail)
        tvRol = findViewById(R.id.tvRol)
        tvCiudad = findViewById(R.id.tvCiudad)
        tvFechaRegistro = findViewById(R.id.tvFechaRegistro)
        btnEditarPerfil = findViewById(R.id.btnEditarPerfil)
        btnVolver = findViewById(R.id.btnVolver)

        cargarPerfil()

        btnEditarPerfil.setOnClickListener {
            startActivity(Intent(this, EditProfileActivity::class.java))
            finish()
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        cargarPerfil()
    }

    private fun cargarPerfil() {
        val session = sessionManager.getSession() ?: return

        lifecycleScope.launch {
            val usuario = database.usuarioDao().obtenerUsuarioPorId(session.userId)
            usuario?.let {
                runOnUiThread {
                    tvNombre.text = it.nombre
                    tvEmail.text = it.email

                    val rolEmoji = if (it.rol == "voluntario") "🙋" else "🏢"
                    tvRol.text = "$rolEmoji ${it.rol.replaceFirstChar { char -> char.uppercase() }}"

                    tvCiudad.text = "📍 ${it.ciudad}"

                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    tvFechaRegistro.text = "Registrado: ${sdf.format(Date(it.fechaRegistro))}"
                }
            }
        }
    }
}