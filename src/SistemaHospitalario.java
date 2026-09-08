import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaHospitalario {

    private List<CitaMedica> citas;
    private Notificacion notificacion;

    public SistemaHospitalario(Notificacion notificacion) {

        if (notificacion == null) {
            throw new IllegalArgumentException(
                    "El sistema necesita un mecanismo de notificación."
            );
        }

        this.citas = new ArrayList<>();
        this.notificacion = notificacion;
    }

    public boolean agendarCita(
            Paciente paciente,
            Medico medico,
            LocalDateTime fechaHora) {

        try {

            CitaMedica nuevaCita =
                    new CitaMedica(paciente, medico, fechaHora);

            // Verificar que el médico esté disponible
            for (CitaMedica cita : citas) {

                if (cita.solapaCon(nuevaCita)) {

                    System.out.println(
                            "No se puede agendar la cita."
                    );

                    System.out.println(
                            "El médico ya tiene una cita en ese horario."
                    );

                    return false;
                }
            }

            citas.add(nuevaCita);

            System.out.println(
                    "Cita agendada correctamente."
            );

            return true;

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

            return false;
        }
    }

    public boolean verificarDisponibilidad(
            Medico medico,
            LocalDateTime fechaHora) {

        if (medico == null || fechaHora == null) {
            return false;
        }

        for (CitaMedica cita : citas) {

            // Si la cita pertenece al mismo médico
            // y se solapa con el horario indicado
            if (cita.getMedico().getId() == medico.getId()) {

                LocalDateTime inicioCita =
                        cita.getFechaHora();

                LocalDateTime finCita =
                        cita.getFechaFin();

                LocalDateTime finNuevaCita =
                        fechaHora.plusMinutes(
                                CitaMedica.DURACION_MINUTOS
                        );

                if (fechaHora.isBefore(finCita)
                        && inicioCita.isBefore(finNuevaCita)) {

                    return false;
                }
            }
        }

        return true;
    }

    public void cancelarCita(CitaMedica cita) {

        if (cita == null) {

            System.out.println(
                    "La cita no puede ser nula."
            );

            return;
        }

        if (citas.remove(cita)) {

            System.out.println(
                    "Cita cancelada correctamente."
            );

        } else {

            System.out.println(
                    "La cita no se encuentra registrada."
            );
        }
    }

    public void generarRecordatorios() {

    if (citas.isEmpty()) {

        System.out.println(
                "No hay citas registradas."
        );

        return;
    }

    for (CitaMedica cita : citas) {

        notificacion.enviarRecordatorio(cita);
    }
}

    public List<CitaMedica> getCitas() {

        // Devolvemos una copia para proteger
        // la lista interna del sistema.
        return new ArrayList<>(citas);
    }
}