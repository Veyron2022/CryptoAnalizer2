package ru.javarush.cryptoanaliser.petrochenko.commands;

import ru.javarush.cryptoanaliser.petrochenko.Util.PathFinder;
import ru.javarush.cryptoanaliser.petrochenko.constants.Strings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BroodForce {
    public BroodForce() {

        Path txtFile = Path.of(PathFinder.getRoot()+"encoded.txt");
        Path encryptedFile = Path.of(PathFinder.getRoot()+"decoded.txt");
        int key = Strings.ALPHABET.toCharArray().length-1;
        Map<Character,Integer> alphabetMap=new HashMap<>();
        char[]chars = Strings.ALPHABET.toCharArray();
        for (char aChar : chars) {
            alphabetMap.put(aChar, 0);
        }
        try {
            List<String> strings = Files.readAllLines(txtFile);
            for (String string : strings) {
                String txt = string.toLowerCase();
                char[]stringToCHar = txt.toCharArray();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }
}
