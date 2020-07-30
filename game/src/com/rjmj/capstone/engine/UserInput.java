package com.rjmj.capstone.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInput {
//    File file = new File("/Users/michaellennerblom/tlg-cap/capstone/game/src/com/rjmj/capstone/engine/input.txt");
    Scanner sc = new Scanner(System.in);

    public String getInput(String question){
        System.out.println(question);
        String userChoice = sc.nextLine().toLowerCase().trim();
        return userChoice;
    }
}

//    public static void main(String[] args) {
//
//        try {
//            System.out.print("Enter the file name with extension : ");
//
//            Scanner input = new Scanner(System.in);
//
//            File file = new File(input.nextLine());
//
//            input = new Scanner(file);
//
//
//            while (input.hasNextLine()) {
//                String line = input.nextLine();
//                System.out.println(line);
//            }
//            input.close();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//}
//import java.io.File;
//        import java.io.FileNotFoundException;
//        import java.util.Scanner;
//
//public class insertionSort {
//
//    public static void main(String[] args) {
//
//        File file = new File("10_Random");
//
//        try {
//
//            Scanner sc = new Scanner(file);
//
//            while (sc.hasNextLine()) {
//                int i = sc.nextInt();
//                System.out.println(i);
//            }
//            sc.close();
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}
