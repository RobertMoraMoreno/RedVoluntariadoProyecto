package com.example.scrumapp.database.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "usuarios",
    indices = [Index(value = ["email"], unique = true)]  // Email único
)
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val email: String,
    val password: String,
    val rol: String, // "voluntario", "organizacion", "admin"
    val ciudad: String,
    val telefono: String? = null,
    val fechaRegistro: Long = System.currentTimeMillis()
)