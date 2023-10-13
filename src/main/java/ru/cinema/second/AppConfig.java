package ru.cinema.second;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;


/**
 *  Класс конфигурации
 */
@Configuration
@ComponentScan("ru.cinema")
public class AppConfig {
    /**
     * Минимальная громкость
     */
    @Value("${minVolume}")
    private double minVolume;

    /**
     * Максимальная громкость
     */
    @Value("${maxVolume}")
    private double maxVolume;

    /**
     * Ширина экрана
     */
    @Value("${width}")
    private double width;

    /**
     * Высота экрана
     */
    @Value("${height}")
    private double height;

    /**
     * Тип экрана
     */
    @Value("${screenType}")
    private String screenType;

    /**
     * Определяет bean Cinema и внедряет значения из внешних свойств
     *
     * @return Bean Cinema
     */
    @Bean
    public ScreenController cinema(){
        Cinema cinema = new Cinema(minVolume, maxVolume);
        cinema.setWidth(width);
        cinema.setHeight(height);
        cinema.setScreenType(screenType);
        return cinema;
    }

    /**
     * Определяет bean CinemaWorker, зависящий от bean Cinema
     *
     * @return Bean CinemaWorker
     */
    @Bean
    public CinemaWorker cinemaWorker(){
        return new CinemaWorker(cinema());
    }
}
