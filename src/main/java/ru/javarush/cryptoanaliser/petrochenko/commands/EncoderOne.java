package ru.javarush.cryptoanaliser.petrochenko.commands;

import ru.javarush.cryptoanaliser.petrochenko.Exceptions.ApplicationException;
import ru.javarush.cryptoanaliser.petrochenko.Util.PathFinder;
import ru.javarush.cryptoanaliser.petrochenko.constants.Messeges;
import ru.javarush.cryptoanaliser.petrochenko.constants.Strings;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EncoderOne {

    public EncoderOne() {
        System.out.println(Messeges.intKey);
        Scanner scanner = new Scanner(System.in);
        //String[] parameters = new String[]{"text.txt", "encrypted.txt"};
        //Path txtFile = Path.of("D:\\Programmer\\texts\\text.txt");
        Path txtFile = Path.of(PathFinder.getRoot()+"text.txt");
        Path encryptedFile = Path.of(PathFinder.getRoot()+"encoded.txt");
       // Path encryptedFile = Path.of("D:\\Programmer\\texts\\encoded.txt");
        int key = scanner.nextInt();
        char[] alphabet = Strings.ALPHABET.toCharArray();
        List<String> strings2 = new ArrayList<>();
        if (key >= alphabet.length) {
            key = key % alphabet.length;
        }
        try {
            List<String> strings = Files.readAllLines(txtFile);
            for (String string : strings) {
                String str = string.toLowerCase();
                char[] stringToChar = str.toCharArray();
                for (int i = 0; i < stringToChar.length; i++) {
                    for (int j = 0; j < alphabet.length; j++) {
                        if (stringToChar[i] == alphabet[j]) {
                            if ((j + key) < alphabet.length) {
                                stringToChar[i] = alphabet[j + key];
                                break;
                            } else {
                                int n = j + key - alphabet.length;
                                stringToChar[i] = alphabet[n];
                                break;
                            }
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (int k = 0; k < stringToChar.length - 1; k++) {
                    stringBuilder.append(stringToChar[k]);
                }
                strings2.add(stringBuilder.toString());
            }
        } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }
        try (FileWriter writer = new FileWriter(String.valueOf(encryptedFile))) {
            for (String s : strings2) {
                writer.write(s);
            }
        } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }
    }
}

