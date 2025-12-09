package com.example.scrumapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.scrumapp.database.dao.IncidenciaDao
import com.example.scrumapp.database.dao.ProyectoDao
import com.example.scrumapp.database.dao.RegistroDao
import com.example.scrumapp.database.dao.UsuarioDao
import com.example.scrumapp.database.entities.Incidencia
import com.example.scrumapp.database.entities.Proyecto
import com.example.scrumapp.database.entities.Registro
import com.example.scrumapp.database.entities.Usuario

@Database(
    entities = [
        Usuario::class,
        Proyecto::class,
        Registro::class,
        Incidencia::class
    ],
    version = 2,  // ⬅️ Cambia de 1 a 2
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    abstract fun proyectoDao(): ProyectoDao
    abstract fun registroDao(): RegistroDao
    abstract fun incidenciaDao(): IncidenciaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "voluntariado_database"
                )
                    .fallbackToDestructiveMigration()  // ← AÑADE ESTA LÍNEA
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
}