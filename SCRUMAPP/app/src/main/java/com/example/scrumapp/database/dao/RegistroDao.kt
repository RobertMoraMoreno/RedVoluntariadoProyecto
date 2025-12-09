package com.example.scrumapp.database.dao

import androidx.room.*
import com.example.scrumapp.database.entities.Registro

@Dao
interface RegistroDao {
    @Insert
    suspend fun insertarRegistro(registro: Registro): Long

    @Query("SELECT * FROM registros WHERE voluntarioId = :volId")
    suspend fun obtenerRegistrosPorVoluntario(volId: Int): List<Registro>

    @Query("SELECT * FROM registros WHERE proyectoId = :proyId")
    suspend fun obtenerRegistrosPorProyecto(proyId: Int): List<Registro>

    @Update
    suspend fun actualizarRegistro(registro: Registro)

    @Delete
    suspend fun eliminarRegistro(registro: Registro)
}