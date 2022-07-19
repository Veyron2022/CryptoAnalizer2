package ru.javarush.cryptoanaliser.petrochenko.controller;

import ru.javarush.cryptoanaliser.petrochenko.commands.DecoderOne;
import ru.javarush.cryptoanaliser.petrochenko.commands.EncoderOne;

public enum Actions {
    ENCODE(new EncoderOne()),
    DECODE(new DecoderOne());


//    ANALYZE(new Analizer()),
//    BROOTFORCE(new Brootforce());


//    String[] Actions(EncoderOne encoderOne) {
//        return new String[]{"text.txt", "encrypted.txt", "123"};
//    }

    Actions(DecoderOne decoderOne) {
    }

    Actions(EncoderOne encoderOne) {

    }
}
