package com.example.scrumapp.database.dao

import androidx.room.*
import com.example.scrumapp.database.entities.Incidencia

@Dao
interface IncidenciaDao {
    @Insert
    suspend fun insertarIncidencia(incidencia: Incidencia): Long

    @Query("SELECT * FROM incidencias WHERE estado != 'resuelta'")
    suspend fun obtenerIncidenciasAbiertas(): List<Incidencia>

    @Query("SELECT * FROM incidencias WHERE usuarioId = :userId")
    suspend fun obtenerIncidenciasPorUsuario(userId: Int): List<Incidencia>

    @Update
    suspend fun actualizarIncidencia(incidencia: Incidencia)

    @Delete
    suspend fun eliminarIncidencia(incidencia: Incidencia)
}