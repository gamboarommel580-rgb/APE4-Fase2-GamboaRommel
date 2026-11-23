package enums;

/**
 * Los dos tipos de relacion que hay en la red.
 * AMISTAD es no dirigida: se guarda como dos aristas, una en la lista de cada persona.
 * SEGUIR es dirigida: se guarda como una sola arista, en la lista de quien sigue.
 */
public enum TipoRelacion {
    AMISTAD,
    SEGUIR
}
