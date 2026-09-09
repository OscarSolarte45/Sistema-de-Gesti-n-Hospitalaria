import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Paciente> listaPacientes= new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
                // Crear pacientes
                    Paciente paciente1 = new Paciente(
                            1,
                            "Carlos Pérez",
                            25,
                            "Sin antecedentes importantes"

                    );
                
                            paciente1.agregarAlergia("Penicilina");

                            listaPacientes.add(paciente1);
                    
                
                    // Crear pacientes
                    Paciente paciente2 = new Paciente(
                            1,
                            "Nicolas Solano",
                            45,
                            "Hipertencion"

                    );
                
                            paciente2.agregarAlergia("nuez");

                            listaPacientes.add(paciente2);
                
                    
                  
                    // Crear médicos
                    Medico medico1 = new Medico(
                            101,
                            "Dr. Juan Rodríguez",
                            "Cardiología"
                    );
                    
                    Medico medico2 = new Medico(
                            102,
                            "Dra. Ana Martínez",
                            "Pediatría"
                    );

                    Medico medico3 = new Medico(
                            103,
                            "Dr. Cristian Ortiz",
                            "Neurologo"
                    );
                    

                    // Crear sistema de notificación
                    Notificacion notificacion = new NotificacionEmail();
                    
                    // Crear sistema hospitalario
                    SistemaHospitalario sistema =
                            new SistemaHospitalario(notificacion);
                    
                    int opcion;
                    
                    do {
                        
                        System.out.println("\n=================================");
                        System.out.println("     SISTEMA DE GESTIÓN");
                        System.out.println("          HOSPITALARIA");
                        System.out.println("=================================");
                        System.out.println("1. Agendar cita");
                        System.out.println("2. Ver citas");
                        System.out.println("3. Cancelar cita");
                        System.out.println("4. Generar recordatorios");
                        System.out.println("5. Ver pacientes");
                        System.out.println("6. Ver médicos");
                        System.out.println("7. Salir");
                        System.out.println("=================================");
                        System.out.print("Seleccione una opción: ");
                        
                        opcion = scanner.nextInt();
                        
                        OUTER:
                        switch (opcion) {
                            case 1 -> {
                                System.out.println("\n===== AGENDAR CITA =====");
                                System.out.println("Seleccione el paciente:");
                                System.out.println("1. Carlos Pérez");
                                System.out.print("Opción: ");
                                int pacienteSeleccionado =
                                        scanner.nextInt();
                                if (pacienteSeleccionado != 1) {
                                    System.out.println(
                                            "Paciente no válido."
                                    );
                                    break;
                                }
                                System.out.println("\nSeleccione el médico:");
                                System.out.println(
                                        "1. Dr. Juan Rodríguez - Cardiología"
                                );
                                System.out.println(
                                        "2. Dra. Ana Martínez - Pediatría"
                                );
                                System.out.print("Opción: ");
                                int medicoSeleccionado =
                                        scanner.nextInt();
                                Medico medicoElegido;
                                switch (medicoSeleccionado) {
                                    case 1 -> medicoElegido = medico1;
                                    case 2 -> medicoElegido = medico2;
                                    default -> {
                                        System.out.println(
                                                "Médico no válido."
                                        );  break OUTER;
                                }
                                }
                                System.out.println(
                                        "\nSe creará una cita de 30 minutos."
                                );
                                LocalDateTime fechaCita =
                                        LocalDateTime.now()
                                                .plusHours(24)
                                                .withSecond(0)
                                                .withNano(0);
                                sistema.agendarCita(
                                        paciente1,
                                        medicoElegido,
                                        fechaCita
                                );
                            }
                            case 2 -> {
                                System.out.println(
                                        "\n===== CITAS REGISTRADAS ====="
                                );
                                
                                if (sistema.getCitas().isEmpty()) {
                                    
                                    System.out.println(
                                            "No hay citas registradas."
                                    );
                                    
                                } else {
                                    
                                    for (CitaMedica cita :
                                            sistema.getCitas()) {
                                        
                                        System.out.println(
                                                "Paciente: "
                                                        + cita.getPaciente()
                                                                .getNombreCompleto()
                                        );
                                        
                                        System.out.println(
                                                "Médico: "
                                                        + cita.getMedico()
                                                                .getNombre()
                                        );
                                        
                                        System.out.println(
                                                "Especialidad: "
                                                        + cita.getMedico()
                                                                .getEspecialidad()
                                        );
                                        
                                        System.out.println(
                                                "Inicio: "
                                                        + cita.getFechaHora()
                                        );
                                        
                                        System.out.println(
                                                "Fin: "
                                                        + cita.getFechaFin()
                                        );
                                        
                                        System.out.println(
                                                "-----------------------------"
                                        );
                                    }
                                }
                            }
                            case 3 -> {
                                System.out.println(
                                        "\n===== CANCELAR CITA ====="
                                );
                                
                                if (sistema.getCitas().isEmpty()) {
                                    
                                    System.out.println(
                                            "No hay citas para cancelar."
                                    );

                                } else {
                                    
                                    for (int i = 0;
                                            i < sistema.getCitas().size();
                                            i++) {
                                        
                                        CitaMedica cita =
                                                sistema.getCitas().get(i);
                                        
                                        System.out.println(
                                                (i + 1) + ". "
                                                        + cita.getPaciente()
                                                                .getNombreCompleto()
                                                        + " - "
                                                        + cita.getMedico()
                                                                .getNombre()
                                                        + " - "
                                                        + cita.getFechaHora()
                                        );
                                    }
                                    
                                    System.out.print(
                                            "Seleccione la cita: "
                                    );
                                    
                                    int numeroCita =
                                            scanner.nextInt();
                                    
                                    if (numeroCita >= 1 &&
                                            numeroCita <=
                                            sistema.getCitas().size()) {
                                        
                                        CitaMedica citaCancelar =
                                                sistema.getCitas()
                                                        .get(numeroCita - 1);
                                        
                                        sistema.cancelarCita(
                                                citaCancelar
                                        );
                                        
                                    } else {
                                        
                                        System.out.println(
                                                "Número de cita no válido."
                                        );
                                    }
                                }
                            }
                            case 4 -> {
                                System.out.println(
                                        "\n===== RECORDATORIOS ====="
                                );
                                
                                sistema.generarRecordatorios();
                            }
                            case 5 -> {
                                System.out.println(
                                        "\n===== PACIENTES ====="
                                );
                                
                                System.out.println(
                                        "ID: " + paciente1.getId()
                                );
                                
                                System.out.println(
                                        "Nombre: "
                                                + paciente1.getNombreCompleto()
                                );
                                
                                System.out.println(
                                        "Edad: "
                                                + paciente1.getEdad()
                                );
                                
                                System.out.println(
                                        "Alergias: "
                                                + paciente1.getAlergias()
                                );
                                
                                System.out.println(
                                        "Historial clínico: "
                                                + paciente1.getHistorialClinico()
                                );
                            }
                            case 6 -> {
                                System.out.println(
                                        "\n===== MÉDICOS ====="
                                );
                                
                                System.out.println(
                                        "ID: " + medico1.getId()
                                );
                                
                                System.out.println(
                                        "Nombre: " + medico1.getNombre()
                                );
                                
                                System.out.println(
                                        "Especialidad: "
                                                + medico1.getEspecialidad()
                                );
                                
                                System.out.println(
                                        "\nID: " + medico2.getId()
                                );
                                
                                System.out.println(
                                        "Nombre: " + medico2.getNombre()
                                );
                                
                                System.out.println(
                                        "Especialidad: "
                                                + medico2.getEspecialidad()
                                );
                            }
                            case 7 -> {
                                System.out.println(
                                        "\nSaliendo del sistema..."
                                );
                                
                                System.out.println(
                                        "¡Gracias por utilizar el sistema!"
                                );
                            }
                            default -> System.out.println(
                                        "Opción no válida."
                                );
                        }
                        
                    } while (opcion != 7);
        }
        }
    }
