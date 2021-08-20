package COLEj1Ej2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ServicioPerro {

    Perro perro = new Perro();

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private ArrayList<Perro> perros = new ArrayList<>();

    public Perro crearPerro() {

        System.out.println("Nombre: ");
        String nombre = leer.next();

        System.out.println("Raza");
        String raza = leer.next();

        return new Perro(nombre, raza);
    }

    public void agregaPerro(Perro p) {
        perros.add(p);
    }

    public void fabricaPerros() {
        Perro perroCreado = crearPerro();
        agregaPerro(perroCreado);
        System.out.println(perroCreado.toString());
    }

    public void mostrarPerros() {
        System.out.println("Los perros actuales de la lista Perros, son:");
        System.out.println("");
        for (Perro aux : perros) {
            System.out.println(aux.toString());  //.ts para que imprima la data
        }
        System.out.println("");
        System.out.println("La cantidad de elementos es: " + perros.size());
    }

    public void menu() {
        System.out.println("---- MENU ----\n");
        System.out.println("(1). Registrar perro\n"
                + "(2). Mostrar la info registrada\n"
                + "(3). Buscar un perro determinado\n"
                + "(4). Buscar y eliminar un perro determinado\n"
                + "(5). Salir\n"
                + " "
                + "---- Escoja una opción----\n");
    }

    public int elegirOpc() {

        int choice;
        do {
            choice = leer.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println("Selección inválida, intente nuevamente: ");
            }
        } while (choice < 1 || choice > 5);
        return choice;
    }

    public int repite() {
        int rta = -1;

        do {
            System.out.println("Para continuar marque (1). , para salir marque (0).");
            System.out.println("Desea continuar?");
            rta = leer.nextInt();

            if (rta == 1) {
                System.out.println("");
                ejecutarMenu();
                System.out.println("");
            } else {
                System.out.println("Ha seleccionado salir.\nGracias por utilizar nuestros servicios");
            }
        } while (rta != 0);
        return rta;
    }

    /*
* Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le
* pedirá un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista.
* Si el perro está en la lista, se eliminará el perro que ingresó el usuario y se mostrará
* la lista ordenada. Si el perro no se encuentra en la lista, se le informará al usuario
* y se mostrará la lista ordenada.
     */
    public String eligePerro() {
        System.out.println("Ingresa el nombre del perro que quieres que busque: ");
        String choice = leer.next();
        return choice;
    }

    public void buscaNombre() {
        String choice = eligePerro();
        int encontrado = 0;
        Iterator<Perro> it = perros.iterator();

        while (it.hasNext()) {
            Perro aux = it.next();
            if (aux.getNombre().equals(choice)) {
                encontrado++;
            }
        }
        if (encontrado >= 1) {
            System.out.println(choice + " ha sido encontrado.");
        } else {
            System.out.println(choice + " no ha sido encontrado.");

        }
    }

    public void buscaBorra() {
        String choice = eligePerro();
        int eliminado = 0;
        Iterator<Perro> it = perros.iterator();

        while (it.hasNext()) {
            Perro aux = it.next();
            if (aux.getNombre().equals(choice)) {
                it.remove();
                eliminado++;
            }
        }
        if (eliminado >= 1) {
            System.out.println(choice + " ha sido eliminado");
        } else {
            System.out.println(choice + " no ha podido ser eliminado");
        }

    }

    public void otraOpcion() {
        System.out.println("Escoge otra opción del menu: ");
    }

    public void ejecutarMenu() {
        menu();
        int choice;
        int salir = -1;

        do {
            choice = elegirOpc();
            switch (choice) {

                case 1:
                    fabricaPerros();
                    salir = repite();
                    otraOpcion();
                    break;
                case 2:
                    mostrarPerros();
                    otraOpcion();
                    break;
                case 3:
                    buscaNombre();
                    otraOpcion();
                    break;
                case 4:
                    buscaBorra();
                    otraOpcion();
                    break;
                case 5:
                    System.out.println("Gracias por utilizar ntros servicios");
                    salir = 0;
                    break;
            }
        } while (choice != 5 || salir == 0);
    }

}
