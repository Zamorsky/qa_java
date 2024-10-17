package com.example;

import java.util.List;

// Класс Feline, который расширяет класс Animal и реализует интерфейс Predator
public class Feline extends Animal implements Predator {

    // Переопределение метода eatMeat из интерфейса Predator
    @Override
    public List<String> eatMeat() throws Exception {
        // Метод вызывает getFood() из класса Animal, передавая тип "Хищник"
        // getFood возвращает список еды для хищников (например, "Животные", "Птицы", "Рыба")
        return getFood("Хищник");
    }

    // Переопределение метода getFamily из класса Animal
    @Override
    public String getFamily() {
        // Метод возвращает строку "Кошачьи", которая обозначает семейство
        return "Кошачьи";
    }

    // Метод возвращает количество котят (по умолчанию 1)
    public int getKittens() {
        // Вызывает перегруженный метод getKittens(), передавая 1 как количество котят
        return getKittens(1);
    }

    // Перегруженный метод, который принимает параметр kittensCount
    public int getKittens(int kittensCount) {
        // Возвращает количество котят, переданное в метод
        return kittensCount;
    }

}
