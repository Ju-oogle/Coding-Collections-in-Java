/* 
clase Pelicula con el titulo, director y duración de la película (en horas)
 */
package COLEj4;

/**
 *
 * @author Admin
 */
public class Pelicula {
    private String titulo, director;
    private Integer duracionHs;

    public Pelicula() {
    }

    public Pelicula(String titulo, String director, Integer duracionHs) {
        this.titulo = titulo;
        this.director = director;
        this.duracionHs = duracionHs;
    }

    public Integer getDuracionHs() {
        return duracionHs;
    }

    public void setDuracionHs(Integer duracionHs) {
        this.duracionHs = duracionHs;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    @Override
    public String toString() {
        return "Titulo de la pelicula: " + titulo + "\nDirector: " + director + "\nDuracion: " + duracionHs+" minutos";
    }
 
}
