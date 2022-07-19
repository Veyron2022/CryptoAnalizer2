package ru.javarush.cryptoanaliser.petrochenko.controller;

public class GetCommand {
    public static String command;
    public GetCommand(String string) {
        if (string.equals("1")){
            command = "encode";
        } else if (string.equals("2")) {
            command="decoded";
        }
    }
    public String getCommand() {
        return command.toUpperCase();
    }
}
