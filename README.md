# APE 4 · Fase 2 · Red social con grafo dinámico

Estructura de Datos, 3.er semestre de Software, FISEI-UTA. Docente: Ing. José Caiza, Mg.
Estudiante: Gamboa Araujo Rommel Fabricio.

Red social "Conexión Ambato" representada con una multilista de nodos propios (`Vertice` y `Arista`), sin `HashMap`, `HashSet`, `ArrayList` ni `LinkedList`. La amistad es no dirigida (dos aristas) y seguir es dirigido (una arista).

## Ejecución (PowerShell, Java 11 o superior)

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse -Filter *.java src).FullName
java -cp out pruebas.PruebasRedSocial
java -cp out app.ConexionAmbato
java -cp out app.Main
java -cp out app.Menu
```

| Programa | Qué hace |
|---|---|
| `pruebas.PruebasRedSocial` | 65 pruebas automatizadas; debe terminar en `65/65 pruebas OK` |
| `app.ConexionAmbato` | Secuencia de comprobación de la guía (Tabla 3) con los usuarios A01 a A06 |
| `app.Main` | Demo de alta, amistades, seguir, quitar amistad y baja |
| `app.Menu` | Menú de consola para probar a mano |

## Estructura

```
src/
  enums/    TipoRelacion.java       AMISTAD (no dirigida) y SEGUIR (dirigida)
  modelo/   Persona.java, Vertice.java, Arista.java
  negocio/  RedSocial.java          todas las operaciones
  app/      ConexionAmbato.java, Main.java, Menu.java
  pruebas/  PruebasRedSocial.java
docs/
  Contrato_operaciones.md
```

## Operaciones y costo

| Operación | Costo |
|---|---|
| `registrarPersona` | O(V) |
| `eliminarPersona` | O(V + A) |
| `agregarAmistad` / `seguir` | O(V + grado) |
| `eliminarAmistad` / `dejarDeSeguir` | O(V + grado) |
| `listarAmigos` / `listarSeguidos` / `contarAmigos` | O(V + grado) |
| `listarSeguidores` | O(V + A) |
| `mostrarRed` | O(V + A) |

V es el número de personas y A el de aristas guardadas (cada amistad son dos).
