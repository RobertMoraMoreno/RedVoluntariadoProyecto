package com.example.scrumapp.database.dao

import androidx.room.*
import com.example.scrumapp.database.entities.Proyecto

@Dao
interface ProyectoDao {
    @Insert
    suspend fun insertarProyecto(proyecto: Proyecto): Long

    @Query("SELECT * FROM proyectos WHERE id = :id")
    suspend fun obtenerProyectoPorId(id: Int): Proyecto?

    @Query("SELECT * FROM proyectos WHERE estado = 'activo'")
    suspend fun obtenerProyectosActivos(): List<Proyecto>

    @Query("SELECT * FROM proyectos WHERE organizacionId = :orgId")
    suspend fun obtenerProyectosPorOrganizacion(orgId: Int): List<Proyecto>

    @Update
    suspend fun actualizarProyecto(proyecto: Proyecto)

    @Delete
    suspend fun eliminarProyecto(proyecto: Proyecto)
}