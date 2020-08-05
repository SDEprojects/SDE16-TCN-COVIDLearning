package com.rjmj.capstone.room;

import com.rjmj.capstone.player.Player;

import java.util.Scanner;

public class StoryDiningRoom implements StoryRoom{

    Scanner scanner;
    private String nextAction, name;
  //  private int option= 0;
    StoryHall hall = new StoryHall();
    GameTextArt gameTextArt = new GameTextArt();
    Player player = new Player();

    @Override
    public void enter(Scanner scanner) throws InterruptedException {
        this.scanner = scanner;
        // System.out.println("You are in DINING ROOM now");
        diningIntro();

        System.out.println("IF YOU DON'T WANT TO DIE, SEARCH AND FIND THE KEYS\n\nREMEMBER! TO SEARCH YOU NEED TO EXPLORE THE DINING ROOM." +
                "\n\nYOU'VE GOTTA DO IT IF YOU WANT TO LIVE\n\nPress Enter");

        freeAns();
        exploreDiningRoom();
    }


    private void freeAns(){
        String action = scanner.nextLine();
        setNextAction(action);
    }




    /**
     * Set Action (e.g. "talk", "move right") <- This can be user input
     *
     * */


    private void setNextAction(String nextAction){
        this.nextAction = nextAction;
    }

    @Override
    public String getNextAction() {
        return nextAction;
    }

    public void diningIntro() throws InterruptedException {
        String[] diningIntroText = {
                "\u001B[35m",
               "You are in the Dining room because you are dying of thirst.",
                "There's no trace of water or food you see a glass on the table half filled with a liquid.",
                "You find it fishy but you take a chance and drink.",
                "Now you feel horrible with sudden fever, coughing and sweating, the fear of COVID virus is haunting you.",
                "You are regretting the decision of drinking the liquid and badly looking around for some HELP!!",
                "You are struggling to breath you feel half dead but you don't want to give up suddenly you hear some noises from the next room.",
                "You are dying to seek help! You reach out to the door to open but your luck isn't favouring you today.The room is LOCKED!!!"
                ,
                "\u001B[0m"
        };

        for (String messages : diningIntroText) {
            Thread.sleep(1000);
            System.out.println(messages);
        }
    }


    private void exploreDiningRoom () throws InterruptedException {
        System.out.println("\n\nTo explore the Dining room you have the below options:\n\n- Type \"0\" : Examine the glass\n\n- Type \"1\" : Break the door\n\n- Type \"2\" : Wait for 10 minutes and die\n\n- Type \"3\" : Give up");
        int option;
        //Scanner selection = new Scanner();
        option = scanner.nextInt();
       String selection = scanner.nextLine();
        switch (option) {
            case 0:
                System.out.println("GOOD CHOICE!YOU FOUND THE CLUE IN THE NOTE GLUED AT THE BOTTOM OF THE GLASS.\n\n YOU FOUND THE KEYS HIDDEN UNDER THE DINING TABLE.\n\n YOU ARE IN HALL NOW!!");
              //  hall.introText();
                hall.enter(scanner);
                break;
            case 1:
                System.out.println("COMMON!! ARE YOU SERIOUS!! YOU ARE NOT THAT STRONG RIGHT NOW!\n TRY A DIFFERENT OPTION:");
                break;
            case 2:
                System.out.println("PLEASE DIE IF YOU WISH SO!!");
                break;
            case 3:
                System.out.println("YOU ARE A COWARD!!");
                gameTextArt.introTextDelayed();
                break;
            default:
                throw new IllegalStateException("you can choose only the above options:" + option);

        }

    }


    }




