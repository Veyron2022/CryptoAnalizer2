package ru.javarush.cryptoanaliser.petrochenko;

public class Menu {
    private String command;
    private String inputPath;
    private String outputPath;
    private String dictFile;
    private String key;

    public Menu(){
        System.out.println(MainMenu.mainManu);
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public void setDictFile(String dictFile) {
        this.dictFile = dictFile;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCommand() {
        return command;
    }

    public String getInputPath() {
        return inputPath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getDictFile() {
        return dictFile;
    }

    public String getKey() {
        return key;
    }

}
