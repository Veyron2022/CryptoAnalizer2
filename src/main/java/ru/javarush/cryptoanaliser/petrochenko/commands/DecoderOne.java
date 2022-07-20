package ru.javarush.cryptoanaliser.petrochenko.commands;

import org.w3c.dom.ls.LSOutput;
import ru.javarush.cryptoanaliser.petrochenko.Exceptions.ApplicationException;
import ru.javarush.cryptoanaliser.petrochenko.Util.PathFinder;
import ru.javarush.cryptoanaliser.petrochenko.constants.Messeges;
import ru.javarush.cryptoanaliser.petrochenko.constants.Strings;
import ru.javarush.cryptoanaliser.petrochenko.controller.Commands;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecoderOne {
    public DecoderOne(String[]parameters) {
        parameters = Commands.parameters;
        Path path = Path.of(parameters[0]);
        Path path1 = Path.of(parameters[1]);
        int key = Integer.parseInt(parameters[2]);
        char[] alphabet = Strings.ALPHABET.toCharArray();
        List<String> strings2 = new ArrayList<>();
        if (key > alphabet.length - 1) {
            key = key % alphabet.length;
        }
        try {
            List<String> strings = Files.readAllLines(path);
            for (String string : strings) {
                String txt = string.toLowerCase();
                char[] stringToChar = txt.toCharArray();
                for (int i = 0; i < stringToChar.length; i++) {
                    for (int j = 0; j < alphabet.length; j++) {
                        if (stringToChar[i] == alphabet[j]) {
                            if ((j - key) >= 0) {
                                stringToChar[i] = alphabet[j - key];
                                break;
                            } else {
                                int n = j - key + alphabet.length;
                                stringToChar[i] = alphabet[n];
                                break;
                            }
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (int k = 0; k < stringToChar.length; k++) {
                    stringBuilder.append(stringToChar[k]);
                }
                strings2.add(stringBuilder.toString());
            }
        } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }

        try (FileWriter writer = new FileWriter(String.valueOf(path1))) {
            for (String s : strings2) {
                writer.write(s+"\n");
            }  } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }
    }
}
