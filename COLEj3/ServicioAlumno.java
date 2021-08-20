package COLEj3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ServicioAlumno {

    private Scanner leer;
    //aca creo mi Coleccion de Objetos Alumnos
    private ArrayList<Alumno> alumnosList;

    /**
     * constructor sin parametros (o vacio) pero que instacia el scanner y la
     * lista
     */
    public ServicioAlumno() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.alumnosList = new ArrayList();
    }
/**
 * Metodo de clase Alumno que solicita nombre y crea un array de notas.
 * Guarda la información en un Array de alumnos
 * @return alumno
 */


    private Alumno creaAlumno() {

        System.out.println("Ingrese el nombre del Alumno");
        String nombre = leer.next().toUpperCase();
        
        ArrayList<Integer> notas = new ArrayList<>(3);
        System.out.println("Ingrese las 3 notas de este alumno");
        int nota1 = leer.nextInt();
        notas.add(nota1);
        int nota2 = leer.nextInt();
        notas.add(nota2);
        int nota3 = leer.nextInt();
        notas.add(nota3);

        Alumno a1 = new Alumno(nombre, notas);
        alumnosList.add(a1);

        return a1;
    }

    /**
     * Metodo que llamo desde el main, crea alumnos y ofrece seguir creandolos o bien finalizar el proceso.
     */
    public void crearAlumnos() {
        char option;
        //Hacer...
        do {
            creaAlumno();//llamo al metodo privado que pide los datos al usuario
            System.out.println("Desea agregar otro Alumno?"
                    + " Presione 'S' para Continuar o 'N' para Salir");
            option = leer.next().toUpperCase().charAt(0);
        } while (option != 'N');//Mientras option sea distinta de N
    }

    
    public void notaFinal() {
        System.out.println("Ingrese el nombre del alumno del que quiere recibir información: ");
        String buscado = leer.next().toUpperCase();
        
        Iterator<Alumno> it = alumnosList.iterator();//Iterator con la lista de alumnos
        int acumulaNotas = 0;//variable para acumular las notas
        
        while (it.hasNext()) {
            Alumno aux = it.next();//Objeto auxiliar de la clase Alumno donde voy a ir asignando las iteraciones de it            
            if (aux.getNombre().equals(buscado)) {//comparo si el nombre del objeto auxiliar es igual al nombre "buscado"
                ArrayList<Integer> notasAux = aux.getNotas();//cuando encuentra el nombre crea una Array auxiliar para asignar las
                for (Integer notaFinal : notasAux) {
                    acumulaNotas += notaFinal;//notas del alumno encontrado y asi poder recorrer y sumar las notas
                }
                System.out.println("La nota final promedio de: " + aux.getNombre() + " es: " + (float) acumulaNotas / 3);
            }
        }
        if (acumulaNotas == 0) {
            System.out.println("No se encontró el Alumno");
        }
    }

}

