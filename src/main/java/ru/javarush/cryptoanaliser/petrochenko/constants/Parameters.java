package ru.javarush.cryptoanaliser.petrochenko.constants;

public class Parameters {


    public static String[] encodeArgs = new String[]{"ENCODE", "text1.txt", "encrypted.txt", "123"};
    public static String[] decodeArgs = new String[]{"DECODE", "encrypted.txt", "decrypted.txt", "123"};
    public static String[] brootforceArgs = new String[]{"BROOTFORCE", "text1.txt", "encrypted.txt"};
    public static String[] analiserArgs = new String[]{"ANALYZE", "encrypted.txt", "decoded.txt", "dict.txt"};
    public static String[] getParameters;

    public String[] getParameters(String command){
        String []arg = new String[0];
        if(command.equals("encode")){
            arg = new String[]{"text1.txt", "encrpted.txt","0"};
        } else if (command.equals("decode")) {
            arg = new String[]{"encrypted.txt", "decrypted.txt","0"};
        } else if (command.equals("brootforce")) {
            arg = new String[]{"encrypted.txt", "decrypted.txt","0"};
        }
      return  arg;
    }

}
