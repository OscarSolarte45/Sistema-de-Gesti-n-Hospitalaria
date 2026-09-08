import java.time.LocalDateTime;

public class CitaMedica {

    private Paciente paciente;
    private Medico medico;
    private LocalDateTime fechaHora;

    public static final int DURACION_MINUTOS = 30;

    public CitaMedica(Paciente paciente, Medico medico, LocalDateTime fechaHora) {

        if (paciente == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo.");
        }

        if (medico == null) {
            throw new IllegalArgumentException("El médico no puede ser nulo.");
        }

        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora no pueden ser nulas.");
        }

        if (fechaHora.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException(
                "La fecha de la cita no puede estar en el pasado."
            );
        }

        this.paciente = paciente;
        this.medico = medico;
        this.fechaHora = fechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public LocalDateTime getFechaFin() {
        return fechaHora.plusMinutes(DURACION_MINUTOS);
    }

    public boolean solapaCon(CitaMedica otraCita) {

        if (otraCita == null) {
            return false;
        }

        // Solo comprobamos solapamiento si es el mismo médico
        if (this.medico.getId() != otraCita.medico.getId()) {
            return false;
        }

        LocalDateTime inicio1 = this.fechaHora;
        LocalDateTime fin1 = this.getFechaFin();

        LocalDateTime inicio2 = otraCita.fechaHora;
        LocalDateTime fin2 = otraCita.getFechaFin();

        return inicio1.isBefore(fin2) && inicio2.isBefore(fin1);
    }
}