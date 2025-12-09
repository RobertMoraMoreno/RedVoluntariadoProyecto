package com.example.scrumapp.database.dao

import androidx.room.*
import com.example.scrumapp.database.entities.Usuario

@Dao
interface UsuarioDao {
    @Insert
    suspend fun insertarUsuario(usuario: Usuario): Long

    @Query("SELECT * FROM usuarios WHERE id = :id")
    suspend fun obtenerUsuarioPorId(id: Int): Usuario?

    @Query("SELECT * FROM usuarios WHERE email = :email")
    suspend fun obtenerUsuarioPorEmail(email: String): Usuario?

    @Query("SELECT * FROM usuarios")
    suspend fun obtenerTodosUsuarios(): List<Usuario>

    @Update
    suspend fun actualizarUsuario(usuario: Usuario)

    @Delete
    suspend fun eliminarUsuario(usuario: Usuario)
}