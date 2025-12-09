package com.example.scrumapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "registros",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["id"],
            childColumns = ["voluntarioId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Proyecto::class,
            parentColumns = ["id"],
            childColumns = ["proyectoId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Registro(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val voluntarioId: Int,
    val proyectoId: Int,
    val fechaInscripcion: Long = System.currentTimeMillis(),
    val asistenciaConfirmada: Boolean = false,
    val horasRealizadas: Int? = null
)