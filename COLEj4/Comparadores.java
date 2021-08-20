/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COLEj4;

import java.util.Comparator;
/**
 *
 * @author Admin
 */
public class Comparadores {
    
//Comparator con su declaracion estandar
    //Compara las películas por titulo, alfabéticamente.
    public static Comparator<Pelicula> porTitulo = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula o1, Pelicula o2) {
            return o2.getTitulo().compareTo(o1.getTitulo());
        }
    };

//Comparadores declarados con expresion Lambda
    //Compara las películas de acuerdo a su duración de mayor a menor.        
    public static Comparator<Pelicula> porDuracionMayor = (Pelicula o1, Pelicula o2) -> o2.getDuracionHs().compareTo(o1.getDuracionHs());
    //Compara las películas de acuerdo a su duración de menor a mayor.
    public static Comparator<Pelicula> porDuracionMenor = (Pelicula o1, Pelicula o2) -> o1.getDuracionHs().compareTo(o2.getDuracionHs());
    //Compara Peliculas por el Director, alfabeticamente.
    public static Comparator<Pelicula> porDirector = (Pelicula o1, Pelicula o2) -> o1.getDirector().compareTo(o2.getDirector());

}
