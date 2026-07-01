package org.example.controller;

import org.example.model.Videojuego;
import org.example.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoController {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    // 1. OBTENER TODOS LOS VIDEOJUEGOS
    @GetMapping
    public List<Videojuego> obtenerTodos() {
        return videojuegoRepository.findAll();
    }

    // 2. OBTENER UN VIDEOJUEGO POR ID (GET http://localhost:8080/api/videojuegos/2)
    @GetMapping("/{id}")
    public ResponseEntity<Videojuego> obtenerPorId(@PathVariable Long id) {
        return videojuegoRepository.findById(id)
                .map(videojuego -> ResponseEntity.ok().body(videojuego))
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. CREAR UN NUEVO VIDEOJUEGO
    @PostMapping
    public Videojuego guardarVideojuego(@RequestBody Videojuego videojuego) {
        return videojuegoRepository.save(videojuego);
    }

    // 4. ACTUALIZAR UN VIDEOJUEGO EXISTENTE (PUT http://localhost:8080/api/videojuegos/3)
    @PutMapping("/{id}")
    public ResponseEntity<Videojuego> actualizarVideojuego(@PathVariable Long id, @RequestBody Videojuego videojuegoDetalles) {
        return videojuegoRepository.findById(id)
                .map(videojuego -> {
                    videojuego.setTitulo(videojuegoDetalles.getTitulo());
                    videojuego.setPlataforma(videojuegoDetalles.getPlataforma());
                    videojuego.setAnyoLanzamiento(videojuegoDetalles.getAnyoLanzamiento());
                    Videojuego actualizado = videojuegoRepository.save(videojuego);
                    return ResponseEntity.ok().body(actualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    // 5. BORRAR UN VIDEOJUEGO (DELETE http://localhost:8080/api/videojuegos/1)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVideojuego(@PathVariable Long id) {
        return videojuegoRepository.findById(id)
                .map(videojuego -> {
                    videojuegoRepository.delete(videojuego);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}