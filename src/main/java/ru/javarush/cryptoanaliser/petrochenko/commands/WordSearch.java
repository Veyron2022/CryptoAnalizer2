package ru.javarush.cryptoanaliser.petrochenko.commands;

public class WordSearch {
    public String []containsArray = {", ", ". ","не","нет"};


    public int wordSearch(String string){
    int count = 0;
    for (int i = 0; i < containsArray.length; i++) {
        if(string.contains(containsArray[i])){
            count++;
                    }
    }
    return count;
}

}
