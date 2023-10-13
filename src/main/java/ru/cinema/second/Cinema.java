package ru.cinema.second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Класс кинотеатра
 */
@Component("cinema")
public class Cinema implements ScreenController {
    /**
     * Включен ли экран
     */
    private boolean isOn;

    /**
     * Текущая громкость
     */
    private double volume;

    /**
     * Минимальная громкость
     */
    private final double minVolume;

    /**
     * Максимальная громкость
     */
    private final double maxVolume;

    /**
     * Ширина экрана
     */
    private double width;

    /**
     * Высота экрана
     */
    private double height;

    /**
     * Тип экрана
     */
    private String screenType;

    /**
     * Конструктор кинотеатра
     *
     * @param minVolume Минимальная громкость
     * @param maxVolume Максимальная громкость
     */
    public Cinema(double minVolume, double maxVolume) {
        this.isOn = false;
        if (minVolume > maxVolume) {
            throw new IllegalArgumentException("Минимальный уровень громкости не может быть больше максимального");
        }
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
        this.volume = 0;
    }

    /**
     * Запускает работу экрана в кинотеатре
     */
    public void turnOn() {
        this.isOn = true;
        System.out.println("Экран включен.");
    }

    /**
     * Выключает экран в кинотеатре
     */
    public void turnOff() {
        this.isOn = false;
        System.out.println("Экран выключен.");
    }

    /**
     * Устанавливает уровень звука
     *
     * @param volume Уровень громкости
     */
    public void setVolume(double volume) {
        if (isOn) {
            if (volume < minVolume) {
                this.volume = minVolume;
                System.out.println("Громкость должна быть в пределах от " + minVolume + " до " + maxVolume +
                        ". Установлена минимальная громкость (звук выключен).");
            } else if (volume > maxVolume) {
                this.volume = maxVolume;
                System.out.println("Громкость должна быть в пределах от " + minVolume + " до " + maxVolume +
                        ". Установлена максимальная громкость (" + maxVolume + ").");
            } else {
                this.volume = volume;
                System.out.println("Установлена громкость: " + volume + ".");
            }
        } else {
            System.out.println("Экран выключен. Невозможно настроить громкость.");
        }
    }

    /**
     * Возвращает уровень громкости
     *
     * @return Текущий уровень громкости
     */
    public double getVolume() {
        if (isOn) {
            System.out.println("Текущий уровень громкости: " + this.volume + ".");
            return this.volume;
        } else {
            System.out.println("Экран выключен. Громкость не настроена.");
            return 0;
        }
    }

    /**
     * Задаёт ширину экрана
     *
     * @param width Ширина экрана
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Возвращает ширину экрана
     *
     * @return Ширина экрана
     */
    public double getWidth() {
        return width;
    }

    /**
     * Задаёт высоту экрана
     *
     * @param height Высота экрана
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Возвращает высоту экрана
     *
     * @return Высота экрана
     */
    public double getHeight() {
        return height;
    }

    /**
     * Задаёт тип экрана
     *
     * @param screenType Тип экрана
     */
    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    /**
     * Возвращает тип экрана
     *
     * @return Тип экрана
     */
    public String getScreenType() {
        return screenType;
    }

    /**
     * Инициализация объекта Cinema
     */
    @PostConstruct
    public void init(){
        System.out.println("Инициализация объекта кинотеатра");
    }

    /**
     * Уничтожение объекта Cinema
     */
    @PreDestroy
    public void destroy(){
        System.out.println("Уничтожение объекта кинотеатра");
    }
}
