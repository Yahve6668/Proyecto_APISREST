/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq;

/**
 *
 * @author prendamex
 */
public class Pelicula {
    
    private String titulo;
    private String anio;
    private String poster;
    private String categoria;
    private String duracion;
    private String fehcal;
    private String Actors;
    private String director;
    private String domina;
    private String id; 
    private String des;
    public Pelicula(){
    
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    
    public Pelicula(String titulo, String anio, String poster, String categoria, String duracion, String fehcal, String Actors, String director, String domina,String id,String des) {
        this.titulo = titulo;
        this.anio = anio;
        this.poster = poster;
        this.categoria = categoria;
        this.duracion = duracion;
        this.fehcal = fehcal;
        this.Actors = Actors;
        this.director = director;
        this.domina = domina;
        this.id=id;
        this.des=des;
    }
    
    
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", anio=" + anio + ", poster=" + poster + ", categoria=" + categoria + ", duracion=" + duracion + ", fehcal=" + fehcal + ", Actors=" + Actors + ", director=" + director + ", domina=" + domina + '}';
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFehcal() {
        return fehcal;
    }

    public void setFehcal(String fehcal) {
        this.fehcal = fehcal;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String Actors) {
        this.Actors = Actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDomina() {
        return domina;
    }

    public void setDomina(String domina) {
        this.domina = domina;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

   
}
