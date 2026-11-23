package modelo;

/**
 * Datos de una persona de la red. No sabe nada de relaciones;
 * eso lo guarda el Vertice que la contiene.
 */
public class Persona {

    private final String usuario;   // clave unica, se guarda en minusculas (A01 y a01 son la misma)
    private final String nombre;    // nombre visible, por ejemplo "Sofia"

    public Persona(String usuario, String nombre) {
        this.usuario = usuario;
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    // Formato que usa mostrarRed: "a01 (Sofia)"
    @Override
    public String toString() {
        return usuario + " (" + nombre + ")";
    }
}
