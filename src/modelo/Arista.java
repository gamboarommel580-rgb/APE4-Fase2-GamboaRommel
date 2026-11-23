package modelo;

import enums.TipoRelacion;

/**
 * Nodo de la lista de relaciones de una persona (arista del grafo).
 * Solo guarda hacia quien va; el origen es el vertice en cuya lista esta.
 *
 *   [destino | tipo | sig] --> siguiente relacion de la misma persona
 */
public class Arista {

    private final Vertice destino;     // persona a la que apunta la relacion
    private final TipoRelacion tipo;   // AMISTAD o SEGUIR
    private Arista sig;                // siguiente relacion; null si es la ultima

    public Arista(Vertice destino, TipoRelacion tipo) {
        this.destino = destino;
        this.tipo = tipo;
    }

    public Vertice getDestino() {
        return destino;
    }

    public TipoRelacion getTipo() {
        return tipo;
    }

    public Arista getSig() {
        return sig;
    }

    // Se cambia al insertar al inicio y cuando la arista anterior "se salta" a esta al quitar
    public void setSig(Arista sig) {
        this.sig = sig;
    }
}
