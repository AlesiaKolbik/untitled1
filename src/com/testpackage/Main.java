package com.testpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        System.out.println("Введите строку слов, разделенных пробелами:");
        String stringOfSymbols = sca.nextLine();
        Scanner sca2 = new Scanner(System.in);
        System.out.println("Введите слово:");
        String word = sca2.nextLine();
        word.trim();
        ArrayList<String> arrayOfWords = new ArrayList<>(1000);
        fillToArray(stringOfSymbols, arrayOfWords);
        int numberOfMismatches=0;
        for (int i = 0; i < arrayOfWords.size(); i++) {
            int lengthWordInArray = arrayOfWords.get(i).length();  //длинна слова в массиве
            int lengthWord=word.length();    //длинна заданного слова
            if (lengthWord == lengthWordInArray) {
                System.out.println(arrayOfWords.get(i));
            }
            else {
                numberOfMismatches++;
            }
            if(numberOfMismatches==arrayOfWords.size())
                System.out.println("Совпадений со словом " + word + " не найдено.");
        }


    }

    public static void fillToArray(String string, ArrayList<String> resultArray) {
        String word = "";
        int indexArray = 0;
        for (int i = 0; i < string.length(); i++) {
            boolean isSpace = String.valueOf(' ').contains(String.valueOf(string.charAt(i)));
            if (!isSpace) {
                word+=string.charAt(i);
                if (i == (string.length() - 1)) {
                    resultArray.add(indexArray, word);
                }
            }
            else {
                if ((string.charAt(0) != ' ') ||( string.charAt(i - 1) != ' ')) {
                    resultArray.add(indexArray, word);
                    word = "";
                    indexArray++;
                }
            }
        }
    }
}
