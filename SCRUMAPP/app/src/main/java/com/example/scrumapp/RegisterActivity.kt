package com.example.scrumapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.scrumapp.database.AppDatabase
import com.example.scrumapp.database.entities.Usuario
import com.example.scrumapp.utils.SecurityUtils
import com.example.scrumapp.utils.ValidationUtils
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase
    private lateinit var etNombre: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var etConfirmPassword: TextInputEditText
    private lateinit var etCiudad: TextInputEditText
    private lateinit var spinnerRol: Spinner
    private lateinit var btnRegistrar: Button
    private lateinit var tvLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        database = AppDatabase.getDatabase(this)

        etNombre = findViewById(R.id.etNombre)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        etCiudad = findViewById(R.id.etCiudad)
        spinnerRol = findViewById(R.id.spinnerRol)
        btnRegistrar = findViewById(R.id.btnRegistrar)
        tvLogin = findViewById(R.id.tvLogin)

        setupSpinner()

        btnRegistrar.setOnClickListener {
            registrarUsuario()
        }

        tvLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun setupSpinner() {
        val roles = arrayOf("voluntario", "organizacion")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, roles)
        spinnerRol.adapter = adapter
    }

    private fun registrarUsuario() {
        val nombre = etNombre.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()
        val ciudad = etCiudad.text.toString().trim()
        val rol = spinnerRol.selectedItem.toString()

        if (nombre.isEmpty()) {
            Toast.makeText(this, "El nombre es obligatorio", Toast.LENGTH_SHORT).show()
            return
        }

        if (!ValidationUtils.isValidEmail(email)) {
            Toast.makeText(this, "Email inválido", Toast.LENGTH_SHORT).show()
            return
        }

        if (!ValidationUtils.isValidPassword(password)) {
            Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show()
            return
        }

        if (!ValidationUtils.arePasswordsMatching(password, confirmPassword)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return
        }

        if (ciudad.isEmpty()) {
            Toast.makeText(this, "La ciudad es obligatoria", Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {
            try {
                val existingUser = database.usuarioDao().obtenerUsuarioPorEmail(email)
                if (existingUser != null) {
                    runOnUiThread {
                        Toast.makeText(this@RegisterActivity, "El email ya está registrado", Toast.LENGTH_SHORT).show()
                    }
                    return@launch
                }

                val hashedPassword = SecurityUtils.hashPassword(password)
                val usuario = Usuario(
                    nombre = nombre,
                    email = email,
                    password = hashedPassword,
                    rol = rol,
                    ciudad = ciudad
                )

                database.usuarioDao().insertarUsuario(usuario)

                runOnUiThread {
                    Toast.makeText(this@RegisterActivity, "✅ Registro exitoso", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                    finish()
                }
            } catch (e: Exception) {
                runOnUiThread {
                    Toast.makeText(this@RegisterActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}