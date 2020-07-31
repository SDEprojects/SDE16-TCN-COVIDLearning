package com.rjmj.capstone.engine;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    private Scanner scanner;

    private ArrayList<String> searchSynonyms;
    private ArrayList<String> moveSynonyms;
    private ArrayList<String> useSynonyms;
    private ArrayList<String> takeSynonyms;
    private ArrayList<String> talkSynonyms;

    private String searchFileTitle;
    private String moveFileTitle;
    private String useFileTitle;
    private String takeFileTitle;
    private String talkFileTitle;

    private File searchFile;
    private File moveFile;
    private File useFile;
    private File takeFile;
    private File talkFile;

    private BufferedReader searchReader;
    private BufferedReader moveReader;
    private BufferedReader useReader;
    private BufferedReader takeReader;
    private BufferedReader talkReader;

    public Parser() throws IOException {
        scanner = new Scanner(System.in);

        searchSynonyms = new ArrayList<>();
        moveSynonyms = new ArrayList<>();
        useSynonyms = new ArrayList<>();
        takeSynonyms = new ArrayList<>();
        talkSynonyms = new ArrayList<>();

        searchFileTitle = "searchSynonyms.txt";
        moveFileTitle = "moveSynonyms.txt";
        useFileTitle = "useSynonyms.txt";
        takeFileTitle = "takeSynonyms.txt";
        talkFileTitle = "talkSynonyms.txt";

        searchReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/" + searchFileTitle)));
        moveReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/" + moveFileTitle)));
        useReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/" + useFileTitle)));
        talkReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/" + talkFileTitle)));
        takeReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/" + takeFileTitle)));

        instantiateSearchSynonymArray();
        instantiateMoveSynonymArray();
        instantiateUseSynonymArray();
        instantiateTakeSynonymArray();
        instantiateTalkSynonymArray();
    }


    private void instantiateSearchSynonymArray() throws IOException {
        try {
            while (searchReader.ready()) searchSynonyms.add(searchReader.readLine());
        } finally {
            System.out.println("Search array populated!");
        }
    }

    private void instantiateMoveSynonymArray() throws IOException {
        try {
            while (moveReader.ready()) moveSynonyms.add(moveReader.readLine());
        } finally {
            System.out.println("Move array populated!");
        }
    }

    private void instantiateUseSynonymArray() throws IOException {
        try {
            while (useReader.ready()) useSynonyms.add(useReader.readLine());
        } finally {
            System.out.println("Use array populated!");
        }
    }

    private void instantiateTakeSynonymArray() throws IOException {
        try {
            while (takeReader.ready()) takeSynonyms.add(takeReader.readLine());
        } finally {
            System.out.println("Take array populated!");
        }
    }

    private void instantiateTalkSynonymArray() throws IOException {
        try {
            while (talkReader.ready()) talkSynonyms.add(talkReader.readLine());
        } finally {
            System.out.println("Talk array populated!");
        }
    }


    public Boolean isSearchSynonym(String word) {
        return searchSynonyms.contains(word.toLowerCase());
    }

    public Boolean isMoveSynonym(String word) {
        return moveSynonyms.contains(word.toLowerCase());
    }

    public Boolean isUseSynonym(String word) {
        return useSynonyms.contains(word.toLowerCase());
    }

    public Boolean isTakeSynonym(String word) {
        return takeSynonyms.contains(word.toLowerCase());
    }

    public Boolean isTalkSynonym(String word) {
        return talkSynonyms.contains(word.toLowerCase());
    }

}
