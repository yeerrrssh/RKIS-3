package ru.cinema.second;


/**
 * Интерфейс экрана кинотеатра
 */
public interface ScreenController {
    /**
     * Включает экран
     */
    void turnOn();

    /**
     * Выключает экран
     */
    void turnOff();

    /**
     * Задаёт необходимую громкость
     */
    void setVolume(double volume);

    /**
     * Получает текущую громкость
     */
    double getVolume();
}
