public class NotificacionEmail implements Notificacion {

    @Override
    public void enviarRecordatorio(CitaMedica cita) {

        System.out.println("=================================");
        System.out.println("      RECORDATORIO DE CITA");
        System.out.println("=================================");
        System.out.println("Paciente: "
                + cita.getPaciente().getNombreCompleto());
        System.out.println("Médico: "
                + cita.getMedico().getNombre());
        System.out.println("Especialidad: "
                + cita.getMedico().getEspecialidad());
        System.out.println("Fecha y hora: "
                + cita.getFechaHora());
        System.out.println("Recordatorio enviado por correo electrónico.");
        System.out.println("=================================");
    }
}