package com.testpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        System.out.println("Введите предложение:");
        String stringOfSymbols = sca.nextLine();
        Scanner sca2 = new Scanner(System.in);
        System.out.println("Введите слово:");
        String word = sca2.nextLine();
        ArrayList<String> arrayOfWords = new ArrayList<>(1000);
        transformStringToArray(stringOfSymbols,arrayOfWords);
        for (int i = 0; i <= arrayOfWords.size(); i++) {
            int lengthWordInArray = arrayOfWords.get(i).length();
            if (word.length() == lengthWordInArray) {
                System.out.println(arrayOfWords.get(i));
            } else {
                System.out.println("Совпадений со словом " + word + " не найдено.");
            }
        }


    }

    public static void transformStringToArray(String string, ArrayList<String> resultArray) {
        String word = "";
        int index=0;
        for (int i = 0; i < string.length(); i++) {
            boolean isContainsSpace=String.valueOf(' ').contains(string.charAt(i));
            if (isContainsSpace ==false){
                if (i == (string.length() - 1)) {
                    resultArray.add(index,word);
                }
            } else {
                if (!(string.charAt(0) == ' ' ))
                    resultArray.add(index,word);
                    word = "";
                    index++;
                }
            }
        }
    }
