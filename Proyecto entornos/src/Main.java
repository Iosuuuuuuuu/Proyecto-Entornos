
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

static final int MAX_TAREAS = 10;
static String[] titulos = new String[MAX_TAREAS];
static String[] descripciones = new String[MAX_TAREAS];
static String[] fechasVencimiento = new String[MAX_TAREAS];
static int contador = 0;


public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String opcion;

    do {
        System.out.println("\nMenú de Gestión de Tareas:");
        System.out.println("1. Registrar tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Actualizar tarea");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
        opcion = reader.readLine();

        switch (opcion) {
            case "1":
                System.out.print("Título: ");
                String titulo = reader.readLine();
                System.out.print("Descripción: ");
                String descripcion = reader.readLine();
                System.out.print("Fecha de vencimiento (YYYY-MM-DD): ");
                String fechaVencimiento = reader.readLine();
                registrarTarea(titulo, descripcion, fechaVencimiento);
                break;
            case "2":
                listarTareas();
                break;
            case "3":
                System.out.print("Título de la tarea a actualizar: ");
                String tituloActualizar = reader.readLine();
                System.out.print("Nueva descripción (deja en blanco para no cambiar): ");
                String nuevaDescripcion = reader.readLine();
                System.out.print("Nueva fecha de vencimiento (YYYY-MM-DD, deja en blanco para no cambiar): ");
                String nuevaFechaVencimiento = reader.readLine();
                actualizarTarea(tituloActualizar, nuevaDescripcion.isEmpty() ? null : nuevaDescripcion, nuevaFechaVencimiento.isEmpty() ? null : nuevaFechaVencimiento);
                break;
            case "4":
                System.out.print("Título de la tarea a eliminar: ");
                String tituloEliminar = reader.readLine();
                eliminarTarea(tituloEliminar);
                break;
            case "5":
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
        }
    } while (!opcion.equals("5"));

    public static void registrarTarea(String titulo, String descripcion, String fechaVencimiento) {
        if (contador < MAX_TAREAS) {
            titulos[contador] = titulo;
            descripciones[contador] = descripcion;
            fechasVencimiento[contador] = fechaVencimiento;
            contador++;
            System.out.println("Tarea '" + titulo + "' registrada.");
        } else {
            System.out.println("No se pueden registrar más tareas. Límite alcanzado.");
        }
    }

    public static void listarTareas() {
        if (contador == 0) {
            System.out.println("No hay tareas registradas.");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println("Título: " + titulos[i] + ", Descripción: " + descripciones[i] + ", Fecha de vencimiento: " + fechasVencimiento[i]);
            }
        }
    }


}

