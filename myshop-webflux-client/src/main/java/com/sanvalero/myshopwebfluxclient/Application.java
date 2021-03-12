package com.sanvalero.myshopwebfluxclient;

import com.sanvalero.myshopwebfluxclient.domain.Product;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executors;

/**
 * Ejemplo de consumo de una API con WebFlux
 * Dos consumidores obtiene una lista de recursos. Uno de ellos realiza una operación muy costosa en tiempo
 * con cada item
 *
 * @author Santiago Faci
 * @version Curso 2020-2021
 */
public class Application {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create("http://localhost:8081");
        Flux<Product> productsFlux = webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Product.class);

        productsFlux.doOnError((System.out::println))
                .subscribeOn(Schedulers.fromExecutor(Executors.newCachedThreadPool()))
                .doOnComplete(() -> System.out.println("Terminado"))
                .subscribe((product) -> {
                    // Simulamos una operación costosa en tiempo
                    try {
                        System.out.println("Haciendo algo con " + product.getName() + " . . .");
                        Thread.sleep(5000);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }

                    System.out.println("Consumidor 1: " + product.getName());
                });

        productsFlux.doOnError((System.out::println))
                .subscribeOn(Schedulers.fromExecutor(Executors.newCachedThreadPool()))
                .doOnComplete(() -> System.out.println("Terminado"))
                .subscribe((product) -> System.out.println("Consumidor 2: " + product.getName()));

        System.out.println(productsFlux.count().block());

        System.out.println("Listo");
    }
}
