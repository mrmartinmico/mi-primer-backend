package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Le dice a Spring que esta clase representa una tabla en la base de datos
public class Videojuego {

    @Id // Define que este atributo será la Llave Primaria (ID único)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Hace que el ID sea autoincremental (1, 2, 3...)
    private Long id;

    private String titulo;
    private String plataforma;
    private int anyoLanzamiento;

    // --- CONSTRUCTORES ---
    public Videojuego() {
        // El constructor vacío es obligatorio para que Hibernate funcione correctamente
    }

    public Videojuego(String titulo, String plataforma, int anyoLanzamiento) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.anyoLanzamiento = anyoLanzamiento;
    }

    // --- GETTERS Y SETTERS (Esenciales para el encapsulamiento) ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getAnyoLanzamiento() {
        return anyoLanzamiento;
    }

    public void setAnyoLanzamiento(int anyoLanzamiento) {
        this.anyoLanzamiento = anyoLanzamiento;
    }
}