package ru.javarush.cryptoanaliser.petrochenko.controller;

import ru.javarush.cryptoanaliser.petrochenko.Exceptions.ApplicationException;
import ru.javarush.cryptoanaliser.petrochenko.commands.DecoderOne;
import ru.javarush.cryptoanaliser.petrochenko.commands.EncoderOne;

import java.util.Scanner;

public class MainController {
    public MainController() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if(answer.equals("1")){
            EncoderOne encoderOne = new EncoderOne();
        }else if(answer.equals("2")){
            DecoderOne decoderOne = new DecoderOne();
        }else if(answer.equals("5")){
            throw new RuntimeException("Выход");
        }
    }
}
