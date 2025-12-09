package com.example.scrumapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "incidencias")
data class Incidencia(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val usuarioId: Int,
    val titulo: String,
    val descripcion: String,
    val prioridad: String = "media",
    val estado: String = "abierta",
    val fechaCreacion: Long = System.currentTimeMillis(),
    val fechaResolucion: Long? = null
)