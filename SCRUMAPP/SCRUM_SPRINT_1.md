# SCRUM - Aplicación Móvil de Voluntariado

## INFORMACIÓN DEL SPRINT

### Sprint #2: Interfaz de Usuario y Autenticación

| Campo | Valor |
|-------|-------|
| **Nombre del Proyecto** | Aplicación móvil local en Kotlin |
| **Sprint Nº** | Sprint #2 |
| **Duración del Sprint** | 25/11/2025 – 02/12/2025 (1 semana) |
| **Objetivo del Sprint** | TBD (Por definir) |
| **Scrum Master** | Roberto Mora |
| **Product Owner** | Roberto Mora |
| **Equipo de desarrollo** | Roberto Mora |
| **Profesor/Tutor** | Eduard Lereu |

---

## ESTADO DEL SPRINT ANTERIOR (Sprint #1)

### ✅ Logros del Sprint #1
- ✅ 4 Tablas creadas y funcionando (Usuarios, Proyectos, Registros, Incidencias)
- ✅ Base de datos SQLite local operativa con Room ORM
- ✅ Todos los DAOs implementados (UsuarioDao, ProyectoDao, RegistroDao, IncidenciaDao)
- ✅ Datos de prueba insertados correctamente
- ✅ Sin errores en compilación
- ✅ Documentación completa
- ✅ Corrección de conflictos de paquetes (com.example.scrumapp)
- ✅ AppDatabase configurada correctamente
- ✅ MainActivity con pruebas automáticas funcionales

### 📋 Cambios Realizados en Sprint #1
1. Corregidos todos los errores de paquetes en archivos Kotlin
2. Agregados imports de Room a todas las entidades
3. Sincronización de dependencias de Gradle
4. Validación completa sin errores de compilación

---

## SPRINT BACKLOG - SPRINT #2

### Historias de Usuario

| ID | Historia de Usuario | Prioridad | Estimación | Estado | Responsable | Criterios de Aceptación |
|---|---|---|---|---|---|---|
| **US-05** | TBD | - | - | Por definir | Roberto | TBD |
| **US-06** | TBD | - | - | Por definir | Roberto | TBD |
| **US-07** | TBD | - | - | Por definir | Roberto | TBD |
| **US-08** | TBD | - | - | Por definir | Roberto | TBD |

---

## SEGUIMIENTO DIARIO - SPRINT #2

### Día 1 (25/11/2025)
- **Qué hice:** Análisis de requisitos del Sprint #2 y planificación de tareas. Revisión del código del Sprint #1.
- **Qué haré hoy:** Empezar con la creación de la interfaz de login
- **Dificultades:** Ninguna crítica

### Día 2 (26/11/2025)
- **Qué hice:** Diseño del layout de login (activity_login.xml) y registro de usuarios. Implementación de la interfaz de autenticación.
- **Qué haré hoy:** Conectar el formulario de login con la base de datos
- **Dificultades:** Ajustes en el diseño responsivo de la interfaz

### Día 3 (27/11/2025)
- **Qué hice:** Implementación de validación de credenciales en LoginActivity. Conexión con UsuarioDao para verificar email y contraseña.
- **Qué haré hoy:** Crear la pantalla principal después del login
- **Dificultades:** Gestión de corrutinas para consultas asincrónicas en el login

### Día 4 (28/11/2025)
- **Qué hice:** Desarrollo de MainActivity mejorada con navegación. Creación del menú principal con opciones para proyectos, mis inscripciones e incidencias.
- **Qué haré hoy:** Implementar pantalla de listado de proyectos
- **Dificultades:** Configuración de RecyclerView y adapters

### Día 5 (29/11/2025)
- **Qué hice:** Creación de ProyectoListActivity con RecyclerView. Implementación de adapter para mostrar lista de proyectos activos desde la BD.
- **Qué haré hoy:** Crear formulario para inscribirse a proyectos
- **Dificultades:** Optimización de consultas a la base de datos

### Día 6 (30/11/2025)
- **Qué hice:** Implementación de ProyectoDetalleActivity con botón de inscripción. Integración con RegistroDao para guardar inscripción del usuario.
- **Qué haré hoy:** Testing y ajustes finales
- **Dificultades:** Validación de inscripciones duplicadas

### Día 7 (01/12/2025)
- **Qué hice:** Testing completo de flujo de login, navegación y inscripción a proyectos. Corrección de bugs menores encontrados en pruebas.
- **Qué haré hoy:** Preparar demo para el profesor
- **Dificultades:** Ninguna crítica

---

## REVISIÓN DEL SPRINT #2

| Aspecto | Resultado |
|---------|-----------|
| **Historias completadas** | TBD |
| **Funcionalidades logradas** | TBD |
| **Dificultades encontradas** | TBD |
| **Demo realizada** | TBD |
| **Fecha de la demo** | TBD |
| **Asistentes** | TBD |

---

## RETROSPECTIVA DEL SPRINT #2

### Qué salió bien ✅
- TBD

### Qué mejorar 🔄
- TBD

### Acciones para el siguiente Sprint 📋
- TBD

---

## NOTAS Y OBSERVACIONES

### Sprint #1 - Conclusiones
El Sprint #1 fue exitoso. Se completaron todas las historias de usuario planificadas:
- La estructura de base de datos fue bien diseñada
- La implementación de Room ORM fue correcta
- Se resolvieron todos los conflictos de configuración
- El equipo trabajó de forma efectiva

### Sprint #2 - Próximos Pasos
(Por definir según feedback del profesor y nuevas prioridades)

---

**Última actualización:** 29 de Noviembre de 2025  
**Equipo:** Roberto Mora  
**Profesor:** Eduard Lereu
