# Sistema-de-Gesti-n-Hospitalaria

## Descripción

El **Sistema de Gestión Hospitalaria** es una aplicación desarrollada en Java que permite administrar pacientes, médicos y citas médicas dentro de un hospital.

El sistema funciona completamente **por consola**, permitiendo al usuario interactuar mediante un menú de opciones para gestionar las diferentes funcionalidades.

El sistema permite registrar información de pacientes y médicos, agendar citas médicas, verificar la disponibilidad de los médicos, cancelar citas y generar recordatorios mediante correo electrónico.

---

## Funcionalidades

El sistema cuenta con las siguientes funcionalidades:

- Registrar y consultar pacientes.
- Registrar y consultar médicos.
- Agendar citas médicas.
- Verificar la disponibilidad de los médicos.
- Evitar citas simultáneas para un mismo médico.
- Establecer una duración fija de 30 minutos para las citas.
- Cancelar citas médicas.
- Consultar las citas registradas.
- Generar recordatorios de citas.
- Enviar recordatorios mediante correo electrónico.
- Validar datos para evitar información inválida.

---

## Estructura del proyecto

```text
SistemaGestionHospitalaria/
├── src/
│   ├── Main.java
│   │   → Clase principal del programa y menú de opciones
│   │
│   ├── Paciente.java
│   │   → Modelo de los pacientes y sus datos clínicos
│   │
│   ├── Medico.java
│   │   → Modelo de los médicos y sus especialidades
│   │
│   ├── CitaMedica.java
│   │   → Representa las citas entre pacientes y médicos
│   │
│   ├── SistemaHospitalario.java
│   │   → Gestiona las citas, disponibilidad y recordatorios
│   │
│   ├── Notificacion.java
│   │   → Interfaz para definir el envío de notificaciones
│   │
│   └── NotificacionEmail.java
│       → Implementación de las notificaciones por correo electrónico
│
├── README.md
└── LICENSE
```
## Interfaz

La aplicación funciona mediante una **interfaz de consola (CLI)**.  
El usuario interactúa con el sistema a través de un menú de opciones mostrado directamente en la terminal.

### Menú principal

```text
========================================
     SISTEMA DE GESTIÓN HOSPITALARIA
========================================

1. Agendar cita
2. Ver citas
3. Cancelar cita
4. Generar recordatorios
5. Ver pacientes
6. Ver médicos
7. Salir
```
---
## Clases principales
## Paciente

Representa a un paciente del hospital.

Contiene:

Identificador.
Nombre completo.
Edad.
Lista de alergias.
Historial clínico.

También permite agregar alergias y validar que los datos ingresados sean correctos.

## Médico

Representa a un médico del hospital.

Contiene:

Identificador.
Nombre.
Especialidad.
## CitaMedica

Representa una cita entre un paciente y un médico.

Contiene:

Paciente.
Médico.
Fecha y hora.
Duración de 30 minutos.

Además, permite comprobar si una cita se solapa con otra cita del mismo médico.

## SistemaHospitalario

Es la clase encargada de gestionar las citas médicas.

Permite:

Agendar citas.
Verificar disponibilidad.
Cancelar citas.
Generar recordatorios.
Consultar las citas registradas.

## Notificacion

Es una interfaz que define el método utilizado para enviar recordatorios de las citas.

## NotificacionEmail

Implementa la interfaz Notificacion y representa el mecanismo de envío de recordatorios mediante correo electrónico.

## Main

Es la clase principal del programa. Contiene el menú de interacción con el usuario y permite ejecutar las diferentes funcionalidades del sistema.

## Principios de Programación Orientada a Objetos
---
**El proyecto aplica los cuatro pilares principales de la Programación Orientada a Objetos:**

## Encapsulamiento

Los atributos de las clases se encuentran definidos como private y se utilizan métodos para acceder o modificar la información.

## Abstracción

Se utiliza la interfaz Notificacion para definir el comportamiento general de las notificaciones sin depender directamente de una implementación específica.

## Polimorfismo

La interfaz Notificacion permite trabajar con diferentes mecanismos de notificación.

Por ejemplo:

Notificacion notificacion = new NotificacionEmail();

De esta forma, el sistema trabaja con la interfaz y no directamente con una implementación concreta.

## Modularidad

El sistema está dividido en diferentes clases, donde cada una tiene una responsabilidad específica.

## Validaciones

El sistema cuenta con validaciones para evitar datos incorrectos.

Entre ellas:

- El ID debe ser mayor que cero.
- El nombre no puede estar vacío.
- La especialidad no puede estar vacía.
- La edad no puede ser negativa.
- Las alergias no pueden estar vacías.
- El paciente y el médico no pueden ser nulos.
- La fecha de una cita no puede estar en el pasado.
- No se permiten citas simultáneas para el mismo médico.
