package dto;

public class StudentDto {
    private String nombre;
    private String email;

    public StudentDto(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public StudentDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
