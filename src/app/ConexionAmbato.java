package app;

import negocio.RedSocial;

/**
 * Caso de la guia APE 4 Fase 2: red "Conexion Ambato".
 * Ejecuta la secuencia de comprobacion de la Tabla 3 con los datos de la Fase 1.
 * Ejecutar: java -cp out app.ConexionAmbato
 */
public class ConexionAmbato {

    private static RedSocial red = new RedSocial();

    // Convierte "a05, a01" en "Camila, Sofia" para leer la salida con nombres
    private static String nombres(String usuarios) {
        if (usuarios == null) {
            return "null (no existe)";
        }
        if (usuarios.isEmpty()) {
            return "(ninguno)";
        }
        StringBuilder sb = new StringBuilder();
        for (String u : usuarios.split(", ")) {
            sb.append(sb.length() == 0 ? "" : ", ").append(red.nombreDe(u));
        }
        return sb.toString();
    }

    private static void grados() {
        String[] codigos = {"A01", "A02", "A03", "A04", "A05", "A06"};
        StringBuilder sb = new StringBuilder("Grados:");
        for (String c : codigos) {
            if (red.existePersona(c)) {
                sb.append(' ').append(c).append('=').append(red.contarAmigos(c));
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        //PASO 1: registrar A01-A06 y las cinco amistades de la Fase 1
        System.out.println("=== Paso 1: registrar A01-A06 y las cinco amistades ===");
        String[][] usuarios = {{"A01", "Sofia"}, {"A02", "Mateo"}, {"A03", "Valeria"},
                               {"A04", "Andres"}, {"A05", "Camila"}, {"A06", "Diego"}};
        for (String[] u : usuarios) {
            System.out.println("registrarPersona(" + u[0] + ", " + u[1] + ") -> " + red.registrarPersona(u[0], u[1]));
        }
        String[][] amistades = {{"A01", "A02"}, {"A02", "A03"}, {"A03", "A04"}, {"A04", "A01"}, {"A04", "A05"}};
        for (String[] a : amistades) {
            System.out.println("agregarAmistad(" + a[0] + ", " + a[1] + ") -> " + red.agregarAmistad(a[0], a[1]));
        }
        System.out.println(red.mostrarRed());
        System.out.println("Usuarios: " + red.totalPersonas() + " | amistades: " + red.totalAmistades());
        grados();

        //PASO 2 y 3: relaciones dirigidas de seguimiento
        System.out.println();
        System.out.println("=== Paso 2: seguir(A02, A01) ===");
        System.out.println("seguir(A02, A01) -> " + red.seguir("A02", "A01"));
        System.out.println("listarSeguidores(A01) = " + nombres(red.listarSeguidores("A01")));
        System.out.println();
        System.out.println("=== Paso 3: seguir(A06, A01) ===");
        System.out.println("seguir(A06, A01) -> " + red.seguir("A06", "A01"));
        System.out.println("listarSeguidores(A01) = " + nombres(red.listarSeguidores("A01")));
        System.out.println("listarSeguidos(A06)   = " + nombres(red.listarSeguidos("A06"))
                + " | contarAmigos(A06) = " + red.contarAmigos("A06"));

        //PASO 4: vecinos de Andres
        System.out.println();
        System.out.println("=== Paso 4: listarAmigos(A04) ===");
        System.out.println("listarAmigos(A04) = " + nombres(red.listarAmigos("A04"))
                + " | contarAmigos(A04) = " + red.contarAmigos("A04"));

        //PASO 5: quitar la amistad Andres - Camila de los dos lados
        System.out.println();
        System.out.println("=== Paso 5: eliminarAmistad(A04, A05) ===");
        System.out.println("eliminarAmistad(A04, A05) -> " + red.eliminarAmistad("A04", "A05"));
        System.out.println("sonAmigos(A04, A05) = " + red.sonAmigos("A04", "A05")
                + " | sonAmigos(A05, A04) = " + red.sonAmigos("A05", "A04"));
        System.out.println("listarAmigos(A04) = " + nombres(red.listarAmigos("A04")));
        System.out.println("listarAmigos(A05) = " + nombres(red.listarAmigos("A05")));

        //PASO 6: baja de Sofia limpiando todas las referencias
        System.out.println();
        System.out.println("=== Paso 6: eliminarPersona(A01) ===");
        System.out.println("eliminarPersona(A01) -> " + red.eliminarPersona("A01"));
        System.out.println(red.mostrarRed());
        System.out.println("listarAmigos(A02) = " + nombres(red.listarAmigos("A02")));
        System.out.println("listarSeguidos(A06) = " + nombres(red.listarSeguidos("A06")));
        System.out.println("listarAmigos(A01) = " + nombres(red.listarAmigos("A01"))
                + " | contarAmigos(A01) = " + red.contarAmigos("A01"));
        System.out.println("Usuarios: " + red.totalPersonas() + " | amistades: " + red.totalAmistades()
                + " | seguimientos: " + red.totalSeguimientos());

        //PASO 7 y 8: casos que deben rechazarse
        System.out.println();
        System.out.println("=== Paso 7: registrarPersona(A02, otro nombre) ===");
        System.out.println("registrarPersona(A02, Martin) -> " + red.registrarPersona("A02", "Martin")
                + " | nombre sigue siendo: " + red.nombreDe("A02"));
        System.out.println("registrarPersona(a02, Martin) -> " + red.registrarPersona("a02", "Martin"));
        System.out.println();
        System.out.println("=== Paso 8: agregarAmistad(A03, A03) ===");
        System.out.println("agregarAmistad(A03, A03) -> " + red.agregarAmistad("A03", "A03"));
    }
}
