# 🌱 Red de Voluntariado Ambiental

Aplicación móvil Android nativa que conecta voluntarios con organizaciones locales de proyectos ambientales. Sistema 100% local con SQLite, sin servicios en la nube.

---

## 📋 Descripción

**Red de Voluntariado Ambiental** es una plataforma móvil diseñada para facilitar la participación ciudadana en proyectos de conservación y protección del medio ambiente. La aplicación permite a voluntarios descubrir y unirse a iniciativas ambientales locales, mientras que las organizaciones pueden publicar y gestionar sus proyectos de forma sencilla.

### 🎯 Objetivos del Proyecto

- Facilitar el registro y participación de voluntarios en actividades ambientales
- Proporcionar a organizaciones una herramienta para publicar y gestionar proyectos
- Crear una comunidad local comprometida con el desarrollo sostenible
- Ofrecer una solución completamente local sin dependencia de servicios en la nube

### 🌍 Alineación con los ODS (Objetivos de Desarrollo Sostenible)

- **ODS 13:** Acción por el clima
- **ODS 15:** Vida de ecosistemas terrestres
- **ODS 17:** Alianzas para lograr los objetivos

---

## ✨ Características Principales

### Para Voluntarios 🙋
- ✅ Registro rápido y sencillo con validación de datos
- 🔐 Inicio de sesión seguro con hashing SHA-256
- 📋 Exploración de proyectos ambientales locales
- 👤 Perfil personalizado con historial de participación
- ✏️ Edición de datos personales
- 📊 Seguimiento de horas de voluntariado
- 🔔 Recordatorios de proyectos inscritos (próximamente)

### Para Organizaciones 🏢
- 🆕 Registro como organización ambiental
- ➕ Publicación de proyectos con detalles completos
- 👥 Gestión de inscripciones de voluntarios
- ✅ Confirmación de asistencia de participantes
- 📈 Estadísticas de impacto (kg de residuos, árboles plantados)
- 📄 Generación de informes de actividad (próximamente)

### Para Administradores ⚙️
- 🔍 Supervisión completa del sistema
- 👨‍💼 Gestión de usuarios y organizaciones
- 🛠 Seguimiento y resolución de incidencias
- 📊 Panel de control con métricas clave

---

## 🛠️ Tecnologías Utilizadas

### Lenguaje y Framework
- **Kotlin** - Lenguaje de programación principal
- **Android SDK** - Framework de desarrollo
- **Material Design 3** - Sistema de diseño de interfaz

### Base de Datos
- **SQLite** - Base de datos local
- **Room** - ORM para Android
- **Coroutines** - Programación asíncrona

### Arquitectura
- **MVVM** (en progreso) - Patrón de arquitectura
- **Repository Pattern** - Capa de abstracción de datos
- **LiveData** (próximamente) - Datos observables

### Seguridad
- **SHA-256** - Hashing de contraseñas
- **SharedPreferences** - Gestión de sesión local
- **Validaciones** - Email, contraseñas, formularios

---

## 🗂️ Arquitectura del Proyecto

```
app/
├── src/main/java/com/example/scrumapp/
│   ├── database/
│   │   ├── entities/          # Modelos de datos (Usuario, Proyecto, etc.)
│   │   ├── dao/               # Data Access Objects
│   │   └── AppDatabase.kt     # Configuración de Room
│   │
│   ├── utils/
│   │   ├── SecurityUtils.kt   # Hashing de contraseñas
│   │   ├── SessionManager.kt  # Gestión de sesión
│   │   └── ValidationUtils.kt # Validaciones de formularios
│   │
│   ├── MainActivity.kt         # Activity launcher
│   ├── LoginActivity.kt        # Inicio de sesión
│   ├── RegisterActivity.kt     # Registro de usuarios
│   ├── HomeActivity.kt         # Pantalla principal
│   ├── ProfileActivity.kt      # Perfil de usuario
│   └── EditProfileActivity.kt  # Edición de perfil
│
├── res/
│   ├── layout/                # Layouts XML
│   ├── values/                # Recursos (strings, colors, themes)
│   └── drawable/              # Imágenes y recursos gráficos
│
└── AndroidManifest.xml        # Configuración de la app
```

---

## 🗄️ Modelo de Base de Datos

### Entidades Principales

#### Usuarios
```kotlin
- id (PK)
- nombre
- email (UNIQUE)
- password (hashed)
- rol (voluntario/organizacion/admin)
- ciudad
- telefono (opcional)
- fechaRegistro
```

#### Proyectos
```kotlin
- id (PK)
- titulo
- descripcion
- ubicacion
- fechaInicio
- fechaFin
- horasEstimadas
- organizacionId (FK → Usuarios)
- estado (activo/completado/cancelado)
- kgResiduos (opcional)
- arbolesPlantados (opcional)
```

#### Registros (Inscripciones)
```kotlin
- id (PK)
- voluntarioId (FK → Usuarios)
- proyectoId (FK → Proyectos)
- fechaInscripcion
- asistenciaConfirmada (boolean)
- horasRealizadas (opcional)
```

#### Incidencias
```kotlin
- id (PK)
- usuarioId (FK → Usuarios)
- titulo
- descripcion
- prioridad (baja/media/alta)
- estado (abierta/en_proceso/resuelta)
- fechaCreacion
- fechaResolucion (opcional)
```

---

## 🚀 Instalación y Configuración

### Requisitos Previos
- Android Studio Hedgehog | 2023.1.1 o superior
- JDK 17
- Android SDK API 24+ (Android 7.0 Nougat)
- Gradle 8.9

### Pasos de Instalación

1. **Clonar el repositorio**
```bash
git clone https://github.com/RobertMoraMoreno/red-voluntariado-ambiental.git
cd red-voluntariado-ambiental
```

2. **Abrir en Android Studio**
- File → Open → Selecciona la carpeta del proyecto
- Espera a que Gradle sincronice las dependencias

3. **Configurar el emulador o dispositivo**
- AVD Manager → Create Virtual Device (API 24+)
- O conecta un dispositivo Android físico con USB Debugging

4. **Ejecutar la aplicación**
- Click en el botón Run ▶️
- Selecciona el dispositivo/emulador
- Espera a que se compile e instale

---

## 📦 Dependencias Principales

```kotlin
dependencies {
    // Android Core
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    
    // Room Database
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
}
```

---

## 🧪 Testing

### Pruebas Manuales Realizadas

✅ **Autenticación**
- Registro de usuario con validaciones
- Login con credenciales correctas/incorrectas
- Persistencia de sesión
- Logout

✅ **Gestión de Perfil**
- Visualización de datos
- Edición de información personal
- Validación de campos obligatorios

✅ **Base de Datos**
- Inserción de datos
- Consultas con filtros
- Actualización de registros
- Prevención de duplicados (email único)

### Próximos Tests
- [ ] Tests unitarios con JUnit
- [ ] Tests de UI con Espresso
- [ ] Tests de integración

---

## 📅 Roadmap y Desarrollo

### ✅ Sprint #1 (Completado)
- Implementación de base de datos SQLite con Room
- Creación de 4 tablas relacionales
- DAOs con operaciones CRUD
- Datos de prueba funcionales

### ✅ Sprint #2 (Completado)
- Interfaz gráfica con Material Design 3
- Validación de emails únicos
- Gestión de datos de prueba
- Sistema de limpieza de BD

### ✅ Sprint #3 (Completado)
- Sistema completo de autenticación
- Hashing de contraseñas (SHA-256)
- Gestión de sesión con SharedPreferences
- Pantallas de perfil y edición

### 🔄 Sprint #4 (En progreso)
- Listado de proyectos con RecyclerView
- Adapter personalizado
- Vista de detalle de proyecto
- Filtros básicos por ciudad

### 📋 Sprint #5 (Planificado)
- Creación de proyectos (Organizaciones)
- Formulario completo con validaciones
- Gestión de imágenes (próximamente)

### 📋 Sprint #6 (Planificado)
- Inscripción a proyectos
- Confirmación de asistencia
- Sistema de notificaciones

### 📋 Sprint #7 (Planificado)
- Vista "Mis Proyectos"
- Historial de participación
- Generación de certificados PDF

### 📋 Sprint #8 (Planificado)
- Depuración final
- Optimizaciones de rendimiento
- Preparación para producción

---

## 🤝 Contribuir

¡Las contribuciones son bienvenidas! Si deseas colaborar:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

### Guía de Estilo
- Seguir las convenciones de Kotlin
- Comentar código complejo
- Mantener la arquitectura existente
- Añadir tests cuando sea posible

---

## 📝 Changelog

### [v0.3.0] - 2025-12-09 (Sprint #3)
#### Added
- Sistema completo de autenticación (Login/Registro)
- Hashing de contraseñas con SHA-256
- Gestión de sesión persistente
- Pantallas de perfil y edición
- Validaciones de formularios en tiempo real

### [v0.2.0] - 2025-12-02 (Sprint #2)
#### Added
- Interfaz gráfica con Material Design 3
- Índice único en email de usuarios
- Sistema de gestión de datos de prueba
- Botones funcionales para visualización

### [v0.1.0] - 2025-11-25 (Sprint #1)
#### Added
- Base de datos SQLite con Room
- 4 tablas relacionales (Usuarios, Proyectos, Registros, Incidencias)
- DAOs con operaciones CRUD completas
- Arquitectura inicial del proyecto

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo [LICENSE](LICENSE) para más detalles.

```
MIT License

Copyright (c) 2025 Roberto Mora Moreno

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
```

---

## 👤 Autor

**Roberto Mora Moreno**
- 🎓 Desarrollo de Aplicaciones Multiplataforma (DAM2)
- 👨‍🏫 Tutor: Eduard Lereu
- 📧 Email: robertomoramoreno3@gmail.com
- 🔗 GitHub: [@RobertMoraMoreno](https://github.com/RobertMoraMoreno)

---

## 🙏 Agradecimientos

- **Eduard Lereu** - Tutor y mentor del proyecto
- **Material Design** - Sistema de diseño de Google
- **Android Developers** - Documentación y recursos
- **Kotlin Community** - Soporte y mejores prácticas

---

## 📞 Contacto y Soporte

Si tienes preguntas, sugerencias o encuentras algún bug:

- 🐛 Abre un [Issue](https://github.com/RobertMoraMoreno/red-voluntariado-ambiental/issues)
- 💬 Inicia una [Discussion](https://github.com/RobertMoraMoreno/red-voluntariado-ambiental/discussions)
- 📧 Envía un email a: robertomoramoreno3@gmail.com

---

## 🌟 Estrellas y Forks

Si este proyecto te resulta útil, ¡considera darle una estrella ⭐ en GitHub!

---

<div align="center">

**🌱 Hecho con 💚 para el planeta**

[⬆️ Volver arriba](#-red-de-voluntariado-ambiental)

</div>
