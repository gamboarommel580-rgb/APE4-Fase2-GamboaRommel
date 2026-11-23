package modelo;

/**
 * Nodo de la lista de personas (vertice del grafo).
 * De cada vertice cuelga su propia lista de aristas: eso es lo que hace a la estructura una multilista.
 *
 *   [persona | aristas | sig]
 *                 |        +--> siguiente persona de la red
 *                 +--> primera relacion de esta persona
 */
public class Vertice {

    private final Persona persona;
    private Arista aristas;   // primera relacion; null si la persona no tiene ninguna
    private Vertice sig;      // siguiente persona; null si es la ultima

    public Vertice(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public Arista getAristas() {
        return aristas;
    }

    // Se usa al insertar al inicio de la lista de relaciones y al quitar la primera
    public void setAristas(Arista aristas) {
        this.aristas = aristas;
    }

    public Vertice getSig() {
        return sig;
    }

    // Se usa al insertar una persona al inicio y al desenlazarla en eliminarPersona
    public void setSig(Vertice sig) {
        this.sig = sig;
    }
}
