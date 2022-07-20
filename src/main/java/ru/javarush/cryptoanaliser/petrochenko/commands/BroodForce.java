package ru.javarush.cryptoanaliser.petrochenko.commands;

import ru.javarush.cryptoanaliser.petrochenko.Exceptions.ApplicationException;
import ru.javarush.cryptoanaliser.petrochenko.constants.Strings;
import ru.javarush.cryptoanaliser.petrochenko.controller.Commands;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BroodForce {
    public BroodForce(String[] parameters) throws IOException {
        char[] alphabet = Strings.ALPHABET.toCharArray();
        Path pathFrom = Path.of(Commands.parameters[0]);
        Path pathTo = Path.of(Commands.parameters[1]);
        List<String> strings2 = new ArrayList<>();
        try {
            WordSearch wordSearch = new WordSearch();
            for (int i = 0; i < alphabet.length; i++) {
                parameters[2] = String.valueOf(i);
                DecoderOne decoderOne = new DecoderOne(parameters);
                boolean bool  = wordSearch.wordSearch(parameters[1]);
                if(bool) break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}