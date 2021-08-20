/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COLEj4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ServicioPelicula {

    private static Scanner leer;

    //aca creo mi Coleccion de Objetos Pelicula
    private static ArrayList<Pelicula> misPelis;

    //constructor vacio pero con instanciacion del scanner y la lista
    public ServicioPelicula() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.misPelis = new ArrayList();
    }

//String titulo, String director, Integer duracionHs
    private Pelicula creaPeli() {
        System.out.println("Cual es el titulo de la Pelicula?");
        String titis = leer.next();
        System.out.println("Quien fue el Director?");
        String mandamas = leer.next();
        System.out.println("Cuanto dura la Peli en minutos?");
        Integer hs = leer.nextInt();
        //Agrego la pelicula creada a la coleccion de peliculas
        return new Pelicula(titis, mandamas, hs);
    }

    public void misPelis() {
        char op;
        do {
            misPelis.add(creaPeli());
            System.out.println("Desea agregar otra pelicula? S/N");
            op = leer.next().toUpperCase().charAt(0);
        } while (op != 'N');

    }
//Mostrar en pantalla todas las películas.    

    public void mostrarPeliculas() {
        System.out.println("** Mostrar en pantalla todas las películas **");
        misPelis.forEach(aux -> {
            System.out.println(aux);
        });
    }

//Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
    public void mostrarPeliculasde1Hs() {
        System.out.println("** Mostrar en pantalla todas las películas con una duración mayor a 1 hora **");
        misPelis.stream().filter(peli -> (peli.getDuracionHs() > 60)).forEachOrdered(peli -> {
            System.out.println(peli);
        });
        System.out.println("");
    }
//Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en pantalla.        

    public void ordenarPeliPorDuracionMayor() {
        System.out.println("** Mostrar películas de acuerdo a su duración de mayor a menor **");
        Collections.sort(misPelis, Comparadores.porDuracionMayor);//Ordena la Coleccion misPelis con el Comparador porDuracionMayor

        misPelis.forEach(peli -> {
            System.out.println(peli);
        });//muestra lo ordenado
        System.out.println("");
    }

//Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en pantalla.
    public void ordenarPeliPorDuracionMenor() {
        System.out.println("** Mostrar películas de acuerdo a su duración de menor a mayor **");
        Collections.sort(misPelis, Comparadores.porDuracionMenor);//ordena con el Comparator porDuracionMenor

        misPelis.forEach(peli -> {
            System.out.println(peli);
        });//muestra lo ordenado
        System.out.println("");
    }

//Ordenar las películas por titulo, alfabéticamente y mostrarlo en pantalla.    
    public void ordenarPeliPorTitulo() {
        System.out.println("** Mostrar las peliculas ordenadas por el Titulo alfabeticamente **");
        Collections.sort(misPelis, Comparadores.porTitulo);//ordena con el Comparator porTitulo

        misPelis.forEach(peli -> {
            System.out.println(peli);
        });//muestra lo ordenado
        System.out.println("");
    }

//Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.    
    public void ordenarPeliPorDirector() {
        System.out.println("** Mostrar las Peliculas ordenadas por el Director alfabeticamente");
        Collections.sort(misPelis, Comparadores.porDirector);//ordena con el Comparator porDirector

        misPelis.forEach(peli -> {
            System.out.println(peli);
        });//muestra lo ordenado
        System.out.println("");
    }

}
