package ru.javarush.cryptoanaliser.petrochenko.controller;

import ru.javarush.cryptoanaliser.petrochenko.Util.PathChoice;
import ru.javarush.cryptoanaliser.petrochenko.commands.BroodForce;
import ru.javarush.cryptoanaliser.petrochenko.commands.DecoderOne;
import ru.javarush.cryptoanaliser.petrochenko.commands.EncoderOne;

import java.util.Scanner;

public class Commands {
    public static String[] parameters;
    public static String command;

    public Commands() {
        Scanner console = new Scanner(System.in);
        command = console.nextLine();
        if (command.equals("1")) {
            System.out.println("Enter key");
            String key = console.nextLine();
            parameters = new String[]{String.valueOf(PathChoice.txtPath), String.valueOf(PathChoice.encryptedPath), key};
        } else if (command.equals("2")) {
            System.out.println("Enter key");
            String key = console.nextLine();
            parameters = new String[]{String.valueOf(PathChoice.encryptedPath), String.valueOf(PathChoice.decryptedPath), key};
        } else if (command.equals("3")) {
            String key = "0";
            parameters = new String[]{String.valueOf(PathChoice.encryptedPath), String.valueOf(PathChoice.decodedPath), key};
        }

        if (command.equals("1")) {
            new EncoderOne(parameters);
        } else if (command.equals("2")) {
            new DecoderOne(parameters);
        } else if (command.equals("3")) {
            new BroodForce(parameters);
        }

    }
}
