package ru.javarush.cryptoanaliser.petrochenko.constants;

import java.util.HashMap;
import java.util.Map;

public class Strings {
    private static final String rus = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";
    // private static final String eng = "qwertyuiopasdfghjklzxcvbnm";
    private static final String cyphers = "1234567890";
    private static final String symbols = ",./:@'!_-=+`;][{} &*|%#?\n";

    public static String ALPHABET = rus + cyphers + symbols;
    public char[] alphabet = ALPHABET.toCharArray();

    public char[] getAlphabet() {
        return alphabet;
    }


public Map<Character, Integer>getAlphabetMap(char[] chars){
    Map<Character, Integer>map = new HashMap<>();
       chars = alphabet;
    for (int i = 0; i < chars.length; i++) {
        map.put(chars[i],0);
    }
    return  map;
}




}
