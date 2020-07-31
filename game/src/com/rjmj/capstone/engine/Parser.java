package com.rjmj.capstone.engine;

import java.io.*;
import java.util.ArrayList;

public class Parser {
    private UserInput input = new UserInput();

    private ArrayList<String> searchSynonyms;
    private ArrayList<String> moveSynonyms;
    private ArrayList<String> useSynonyms;

    private String searchFileTitle;
    private String moveFileTitle;
    private String useFileTitle;

    private File searchFile;
    private File moveFile;
    private File useFile;

    private BufferedReader searchReader;
    private BufferedReader moveReader;
    private BufferedReader useReader;

    public Parser() throws IOException {
        searchSynonyms = new ArrayList<>();
        moveSynonyms = new ArrayList<>();
        useSynonyms = new ArrayList<>();

        searchFileTitle = "searchSynonyms.txt";
        moveFileTitle = "moveSynonyms.txt";
        useFileTitle = "useSynonyms.txt";

        searchFile = new File(getClass().getClassLoader().getResource(searchFileTitle).getFile());
        moveFile = new File(getClass().getClassLoader().getResource(moveFileTitle).getFile());
        useFile = new File(getClass().getClassLoader().getResource(useFileTitle).getFile());

        searchReader = new BufferedReader(new FileReader(searchFile));
        moveReader = new BufferedReader(new FileReader(moveFile));
        useReader = new BufferedReader(new FileReader(useFile));

        instantiateSearchSynonymArray();
        instantiateMoveSynonymArray();
        instantiateUseSynonymArray();
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


    //this pardner prompts the player for precepts (lol... it gets commands)
    public String[] getParsedUserInput(String question) {
        String command = input.getInput(question);
        return command.toLowerCase().split("\\s+", 2);
    }

    public ArrayList<String> getSearchSynonyms() {
        return searchSynonyms;
    }

    public ArrayList<String> getMoveSynonyms() {
        return moveSynonyms;
    }

    public ArrayList<String> getUseSynonyms() {
        return useSynonyms;
    }

}
