package ru.javarush.cryptoanaliser.petrochenko.entity;


import ru.javarush.cryptoanaliser.petrochenko.controller.Commands;
import ru.javarush.cryptoanaliser.petrochenko.controller.GetCommand;

public class Result {

    public Result() {
        System.out.println("File" + Commands.parameters[0] + Commands.command + "to directory"+Commands.parameters[1]);

        }
}
