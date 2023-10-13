package ru.cinema.second;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

/**
 * Главный класс
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Main {
    /**
     * Точка входа в программу
     *
     * @param args Аргументы коммандной строки
     */
    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        CinemaWorker cinemaWorker = (CinemaWorker) context.getBean("cinemaWorker");

        cinemaWorker.show();
    }
}
