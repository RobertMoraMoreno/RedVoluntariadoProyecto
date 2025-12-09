package com.example.scrumapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "proyectos")
data class Proyecto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val titulo: String,
    val descripcion: String,
    val ubicacion: String,
    val fechaInicio: Long,
    val fechaFin: Long,
    val horasEstimadas: Int,
    val organizacionId: Int,
    val estado: String = "activo",
    val kgResiduos: Int? = null,
    val arbolesPlantados: Int? = null
)