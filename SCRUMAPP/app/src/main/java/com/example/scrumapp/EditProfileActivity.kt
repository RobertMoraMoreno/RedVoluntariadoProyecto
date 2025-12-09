package com.example.scrumapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.scrumapp.database.AppDatabase
import com.example.scrumapp.utils.SessionManager
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch

class EditProfileActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase
    private lateinit var sessionManager: SessionManager
    private lateinit var etNombre: TextInputEditText
    private lateinit var etTelefono: TextInputEditText
    private lateinit var etCiudad: TextInputEditText
    private lateinit var btnGuardar: Button
    private lateinit var btnCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        database = AppDatabase.getDatabase(this)
        sessionManager = SessionManager(this)

        etNombre = findViewById(R.id.etNombre)
        etTelefono = findViewById(R.id.etTelefono)
        etCiudad = findViewById(R.id.etCiudad)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnCancelar = findViewById(R.id.btnCancelar)

        cargarDatos()

        btnGuardar.setOnClickListener {
            guardarCambios()
        }

        btnCancelar.setOnClickListener {
            finish()
        }
    }

    private fun cargarDatos() {
        val session = sessionManager.getSession() ?: return

        lifecycleScope.launch {
            val usuario = database.usuarioDao().obtenerUsuarioPorId(session.userId)
            usuario?.let {
                runOnUiThread {
                    etNombre.setText(it.nombre)
                    etTelefono.setText(it.telefono ?: "")
                    etCiudad.setText(it.ciudad)
                }
            }
        }
    }

    private fun guardarCambios() {
        val nombre = etNombre.text.toString().trim()
        val telefono = etTelefono.text.toString().trim()
        val ciudad = etCiudad.text.toString().trim()

        if (nombre.isEmpty() || ciudad.isEmpty()) {
            Toast.makeText(this, "Nombre y ciudad son obligatorios", Toast.LENGTH_SHORT).show()
            return
        }

        val session = sessionManager.getSession() ?: return

        lifecycleScope.launch {
            val usuario = database.usuarioDao().obtenerUsuarioPorId(session.userId)
            usuario?.let {
                val usuarioActualizado = it.copy(
                    nombre = nombre,
                    telefono = telefono.ifEmpty { null },
                    ciudad = ciudad
                )
                database.usuarioDao().actualizarUsuario(usuarioActualizado)

                runOnUiThread {
                    Toast.makeText(this@EditProfileActivity, "✅ Perfil actualizado", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@EditProfileActivity, ProfileActivity::class.java))
                    finish()
                }
            }
        }
    }
}