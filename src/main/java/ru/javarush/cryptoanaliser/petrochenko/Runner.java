package ru.javarush.cryptoanaliser.petrochenko;

import ru.javarush.cryptoanaliser.petrochenko.constants.MainMenu;
import ru.javarush.cryptoanaliser.petrochenko.controller.Commands;

public class Runner {
    public static void main(String[] args) {
        System.out.println(MainMenu.mainManu);
        Commands commands = new Commands();
    }
}
