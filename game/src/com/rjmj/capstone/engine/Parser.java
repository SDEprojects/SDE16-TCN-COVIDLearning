package com.rjmj.capstone.engine;

import com.rjmj.capstone.ExceptionMessage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser implements ExceptionMessage {
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

    public Parser() {
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


    private void instantiateSearchSynonymArray() {
        try {
            while (searchReader.ready()) searchSynonyms.add(searchReader.readLine());
        }
        catch(Exception e){
            somethingWentWrong(e);
            System.out.println("Please check at : while (searchReader.ready()) searchSynonyms.add(searchReader.readLine());");
        }
        finally {

        }
    }

    private void instantiateMoveSynonymArray() {
        try {
            while (moveReader.ready()) moveSynonyms.add(moveReader.readLine());
        }
        catch(Exception e){
            somethingWentWrong(e);
            System.out.println("Please check at : while (searchReader.ready()) searchSynonyms.add(searchReader.readLine());");
        }
        finally {
        }
    }

    private void instantiateUseSynonymArray(){
        try {
            while (useReader.ready()) useSynonyms.add(useReader.readLine());
        }
        catch(Exception e){
            somethingWentWrong(e);
            System.out.println("Please check at : while (searchReader.ready()) searchSynonyms.add(searchReader.readLine());");
        }
        finally {

        }
    }

    private void instantiateTakeSynonymArray() {
        try {
            while (takeReader.ready()) takeSynonyms.add(takeReader.readLine());
        }
        catch(Exception e){
            somethingWentWrong(e);
            System.out.println("Please check at : while (searchReader.ready()) searchSynonyms.add(searchReader.readLine());");
        }
        finally {
        }
    }

    private void instantiateTalkSynonymArray() {
        try {
            while (talkReader.ready()) talkSynonyms.add(talkReader.readLine());
        }
        catch(Exception e){
            somethingWentWrong(e);
            System.out.println("Please check at : while (searchReader.ready()) searchSynonyms.add(searchReader.readLine());");
        }
        finally {

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
