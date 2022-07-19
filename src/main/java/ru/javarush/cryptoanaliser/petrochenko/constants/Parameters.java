package ru.javarush.cryptoanaliser.petrochenko.constants;

public class Parameters {
    public static String[] encodeArgs = new String[]{"ENCODE", "text.txt", "encrypted.txt", "123"};
    public static String[] decodeArgs = new String[]{"DECODE", "encrypted.txt", "decrypted.txt", "123"};
    public static String[] brootforceArgs = new String[]{"BROOTFORCE", "text.txt", "encrypted.txt"};
    public static String[] analiserArgs = new String[]{"ANALYZE", "encrypted.txt", "decoded.txt", "dict.txt"};

}
