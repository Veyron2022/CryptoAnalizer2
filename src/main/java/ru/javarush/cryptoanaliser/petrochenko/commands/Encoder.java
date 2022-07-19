package ru.javarush.cryptoanaliser.petrochenko.commands;

import ru.javarush.cryptoanaliser.petrochenko.Exceptions.ApplicationException;
import ru.javarush.cryptoanaliser.petrochenko.Util.PathFinder;
import ru.javarush.cryptoanaliser.petrochenko.constants.Parameters;
import ru.javarush.cryptoanaliser.petrochenko.constants.Strings;
import ru.javarush.cryptoanaliser.petrochenko.controller.GetCommand;
import ru.javarush.cryptoanaliser.petrochenko.entity.Result;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Encoder {
        public Result Encode(String[] parameters) {
            parameters = Parameters.decodeArgs;
            Path txtFile = Path.of(PathFinder.getRoot() + Parameters.encodeArgs[1]);
            Path encryptedFile = Path.of(PathFinder.getRoot() + Parameters.encodeArgs[2]);
            int key = Integer.parseInt(Parameters.encodeArgs[3]);
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
                            if (stringToChar[i]==alphabet[j]) {
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
                    writer.write(s + "\n");
                }
            } catch (IOException e) {
                throw new ApplicationException("IO error", e);
            }


            return new Result();
          //  return new Result(ResultCode.OK, "read all bytes" + txtFile);

        }
    }


