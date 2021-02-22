package com.sanvalero.introrxjava;

import com.sanvalero.introrxjava.domain.Book;
import io.reactivex.rxjava3.core.Observable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // Una secuencia de valores
        // Dos observadores se suscriben
        Observable<String> values = Observable.just("Una", "Dos", "Tres");
        values.subscribe(
                value -> System.out.println("Value: " + value),
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("The end!")
        );
        values.subscribe(System.out::println);

        // Una secuencia de valores con un solo elemento
        // Dos observadores se suscriben
        Observable<Long> moreValues = Observable.just(System.currentTimeMillis());
        moreValues.subscribe(System.out::println);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        moreValues.subscribe(System.out::println);

        // Una secuencia aplazada (defer) de valores
        // Dos observadores se suscriben
        Observable<Long> moreMoreValues = Observable.defer(() -> Observable.just(System.currentTimeMillis()));
        moreMoreValues.subscribe(System.out::println);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        moreMoreValues.subscribe(System.out::println);

        // Secuencia creada a partir de una colección, para procesar elemento a elemento
        List<Book> books = new ArrayList<>();
        books.add(new Book("Secuestrado", "Libro de aventuras", 500, "Aventuras", LocalDate.now()));
        books.add(new Book("Tom Sawyer", "Libro", 450, "Aventuras", LocalDate.now()));
        Observable<Book> bookObservable = Observable.fromArray(books.toArray(new Book[0]));
        bookObservable.subscribe(System.out::println);

        // Podemos "reducir" la secuencia de elementos observados
        bookObservable.filter(book -> book.getPageCount() > 450)
                .subscribe(System.out::println);

        // Y también transformar
        bookObservable.map(Book::getTitle)
                .subscribe(System.out::println);

        // También podemos concatenar dos secuencias
        Observable<Integer> range1 = Observable.range(1, 10);
        Observable<Integer> range2 = Observable.range(11, 10);
        Observable.concat(range1, range2)
                .subscribe(System.out::println);
    }
}
