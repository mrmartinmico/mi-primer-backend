package org.example;

import org.example.model.Videojuego;
import org.example.repository.VideojuegoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner ejecutarAlArranque(VideojuegoRepository repo) {
        return args -> {
            // Guardamos tres videojuegos de prueba en nuestra base de datos H2
            repo.save(new Videojuego("The Legend of Zelda: Tears of the Kingdom", "Nintendo Switch", 2023));
            repo.save(new Videojuego("Elden Ring", "PlayStation 5", 2022));
            repo.save(new Videojuego("Cyberpunk 2077", "PC", 2020));
            repo.save(new Videojuego("Minecraft", "PC", 2011));
            repo.save(new Videojuego("Gran Turismo 7", "PlayStation 5", 2022));
            System.out.println(">> ¡Videojuegos de prueba cargados con éxito en la base de datos! <<");
        };
    }
}
