package ru.javarush.cryptoanaliser.petrochenko;

import ru.javarush.cryptoanaliser.petrochenko.constants.MainMenu;
import ru.javarush.cryptoanaliser.petrochenko.controller.Commands;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        System.out.print(MainMenu.mainManu);
        Commands commands = new Commands();
    }
}
