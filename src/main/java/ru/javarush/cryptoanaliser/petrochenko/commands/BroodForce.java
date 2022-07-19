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
    public BroodForce(String[] parameters) {
        char[] alphabet = Strings.ALPHABET.toCharArray();
        Path pathFrom = Path.of(Commands.parameters[0]);
        Path pathTo = Path.of(Commands.parameters[1]);
        List<String> strings2 = new ArrayList<>();
        WordSearch wordSearch = new WordSearch();
        int key = Integer.parseInt(Commands.parameters[2]);
        for (int i = alphabet.length - 1; i >= 0; i--) {
            Commands.parameters[2] = String.valueOf(i);
            try {
                List<String> strings = Files.readAllLines(pathFrom);
                int count = 0;
                for (String string : strings) {
                    String txt = string.toLowerCase();
                    count = count + wordSearch.wordSearch(string);
                    if (count > 10) {
                        key = i;
                        break;
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Commands.parameters[2] = String.valueOf(key);
            try {
                List<String> strings = Files.readAllLines(pathFrom);
                for (String string : strings) {
                    String txt = string.toLowerCase();
                    char[] stringToChar = txt.toCharArray();
                    for (int k = 0; k < stringToChar.length; k++) {
                        for (int j = 0; j < alphabet.length; j++) {
                            if (stringToChar[k] == alphabet[j]) {
                                if ((j - key) >= 0) {
                                    stringToChar[k] = alphabet[j - key];
                                    break;
                                } else {
                                    int n = j - key + alphabet.length;
                                    stringToChar[k] = alphabet[n];
                                    break;
                                }
                            }
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int l = 0; l < stringToChar.length; l++) {
                        stringBuilder.append(stringToChar[l]);
                    }
                    strings2.add(stringBuilder.toString());
                }
            } catch (IOException e) {
                throw new ApplicationException("IO error", e);
            }

            try (FileWriter writer = new FileWriter(String.valueOf(pathTo))) {
                for (String s : strings2) {
                    writer.write(s + "\n");
                }
            } catch (IOException e) {
                throw new ApplicationException("IO error", e);

            }
        }
    }
}
