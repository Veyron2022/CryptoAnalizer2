package ru.javarush.cryptoanaliser.petrochenko.Util;

import java.nio.file.Path;

public class PathChoice {
    public static Path txtPath = Path.of(PathFinder.getRoot()+"text.txt");
    public static Path encryptedPath = Path.of(PathFinder.getRoot()+"text.txt");
    public static Path decryptedPath = Path.of(PathFinder.getRoot()+"text.txt");
    public static Path decodedPath = Path.of(PathFinder.getRoot()+"text.txt");

}
