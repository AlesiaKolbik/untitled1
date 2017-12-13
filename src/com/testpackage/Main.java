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
        word = word.trim();
        ArrayList<String> arrayOfWords = split(stringOfSymbols);
        ArrayList<String> matches = findMatchesOfWords(arrayOfWords, word);
        System.out.println(resultMatches(matches));
    }

    private static ArrayList<String> split(String string) {
        String separator = " ";
        ArrayList<String> words = new ArrayList<>(1000);
        for (int i = 0; i < string.length(); i++) {
            int beginIndex = findStartIndexNextWord(string, i, separator);
            int endIndex = findLastIndexNextWord(string, beginIndex, separator);
            String word = getNextWord(string, beginIndex, endIndex);
            words.add(word);
            i = endIndex;
        }
        return words;
    }

    private static int findStartIndexNextWord(String string, int index, String separator) {
        while (separator.contains(String.valueOf(string.charAt(index)))) {
            index++;
        }
        return index;
    }

    private static int findLastIndexNextWord(String string, int index, String separator) {
        while (!separator.contains(String.valueOf(string.charAt(index)))) {
            index++;
            if (index == string.length() - 1)
                break;
        }
        return index;
    }

    private static String getNextWord(String string, int beginIndex, int endIndex) {
        StringBuilder word = new StringBuilder();
        for (int i = beginIndex; i < endIndex; i++) {
            word.append(string.charAt(i));
        }
        return word.toString();
    }

    private static ArrayList<String> findMatchesOfWords(ArrayList array, String word) {
        ArrayList<String> matches = new ArrayList<>();
        for (Object item : array) {
            String wordFromArray = String.valueOf(item);
            int lengthWordInArray = wordFromArray.length();
            int lengthWord = word.length();
            if (lengthWord == lengthWordInArray) {
                matches.add(wordFromArray);
            }
        }
        return matches;
    }

    private static String resultMatches(ArrayList<String> matches) {
        StringBuilder result = new StringBuilder();
        if (matches.size() == 0)
            result = new StringBuilder("Совпадений не найдено");
        else
            for (String match : matches) {
                result.append(match).append(" ");
            }
        return result.toString();
    }
}