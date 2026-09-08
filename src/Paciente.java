import java.util.ArrayList;
import java.util.List;

public class Paciente {

    private int id;
    private String nombreCompleto;
    private int edad;
    private List<String> alergias;
    private String historialClinico;

    public Paciente(int id, String nombreCompleto, int edad, String historialClinico) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0.");
        }

        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }

        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.alergias = new ArrayList<>();
        this.historialClinico = historialClinico;
    }

    public void agregarAlergia(String alergia) {
        if (alergia == null || alergia.trim().isEmpty()) {
            throw new IllegalArgumentException("La alergia no puede estar vacía.");
        }

        alergias.add(alergia);
    }

    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public String getHistorialClinico() {
        return historialClinico;
    }

    public void setNombreCompleto(String nombreCompleto) {
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        this.nombreCompleto = nombreCompleto;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }

        this.edad = edad;
    }
}