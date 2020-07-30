package com.rjmj.capstone.room;

import com.rjmj.capstone.engines.MovementEngine;
import com.rjmj.capstone.player.Color;
import com.rjmj.capstone.player.Recipe;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameTextArt {
    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private MovementEngine movementEngine = new MovementEngine();

    public void winningArtDisplay() {
        System.out.println(ANSI_GREEN + "_______________________________________________________\n" +
                "|  You have now won the game!!!!                      |\n" +
                "|  Thank you for playing!                             |\n" +
                "|                                                     |\n" +
                "|        https://github.com/Capstone-RJMJ/capstone    |\n" +
                "|_____________________________________________________|\n");

        System.exit(1);
    }

    public void introArt() {
        System.out.println(ANSI_BLUE + "\n" +
                "                                                                                                                                                                                      \n" +
                " @@@@@@   @@@@@@@   @@@@@@@   @@@@@@@   @@@@@@@@  @@@  @@@  @@@@@@@  @@@   @@@@@@@  @@@@@@@@   @@@@@@   @@@  @@@  @@@  @@@@@@@                                                        \n" +
                "@@@@@@@@  @@@@@@@@  @@@@@@@@  @@@@@@@@  @@@@@@@@  @@@@ @@@  @@@@@@@  @@@  @@@@@@@@  @@@@@@@@  @@@@@@@   @@@  @@@  @@@  @@@@@@@@                                                       \n" +
                "@@!  @@@  @@!  @@@  @@!  @@@  @@!  @@@  @@!       @@!@!@@@    @@!    @@!  !@@       @@!       !@@       @@!  @@@  @@!  @@!  @@@                                                       \n" +
                "!@!  @!@  !@!  @!@  !@!  @!@  !@!  @!@  !@!       !@!!@!@!    !@!    !@!  !@!       !@!       !@!       !@!  @!@  !@!  !@!  @!@                                                       \n" +
                "@!@!@!@!  @!@@!@!   @!@@!@!   @!@!!@!   @!!!:!    @!@ !!@!    @!!    !!@  !@!       @!!!:!    !!@@!!    @!@!@!@!  !!@  @!@@!@!                                                        \n" +
                "!!!@!!!!  !!@!!!    !!@!!!    !!@!@!    !!!!!:    !@!  !!!    !!!    !!!  !!!       !!!!!:     !!@!!!   !!!@!!!!  !!!  !!@!!!                                                         \n" +
                "!!:  !!!  !!:       !!:       !!: :!!   !!:       !!:  !!!    !!:    !!:  :!!       !!:            !:!  !!:  !!!  !!:  !!:                                                            \n" +
                ":!:  !:!  :!:       :!:       :!:  !:!  :!:       :!:  !:!    :!:    :!:  :!:       :!:           !:!   :!:  !:!  :!:  :!:                                                            \n" +
                "::   :::   ::        ::       ::   :::   :: ::::   ::   ::     ::     ::   ::: :::   :: ::::  :::: ::   ::   :::   ::   ::                                                            \n" +
                " :   : :   :         :         :   : :  : :: ::   ::    :      :     :     :: :: :  : :: ::   :: : :     :   : :  :     :                                                             \n" +
                "                                                                                                                                                                                      \n" +
                "                                                                                                                                                                                      \n" +
                "@@@@@@@@   @@@@@@    @@@@@@@   @@@@@@   @@@@@@@   @@@@@@@@     @@@@@@@@  @@@@@@@    @@@@@@   @@@@@@@@@@       @@@@@@@   @@@@@@   @@@  @@@  @@@  @@@@@@@                @@@   @@@@@@   \n" +
                "@@@@@@@@  @@@@@@@   @@@@@@@@  @@@@@@@@  @@@@@@@@  @@@@@@@@     @@@@@@@@  @@@@@@@@  @@@@@@@@  @@@@@@@@@@@     @@@@@@@@  @@@@@@@@  @@@  @@@  @@@  @@@@@@@@              @@@@  @@@@@@@@  \n" +
                "@@!       !@@       !@@       @@!  @@@  @@!  @@@  @@!          @@!       @@!  @@@  @@!  @@@  @@! @@! @@!     !@@       @@!  @@@  @@!  @@@  @@!  @@!  @@@             @@@!!  @@!  @@@  \n" +
                "!@!       !@!       !@!       !@!  @!@  !@!  @!@  !@!          !@!       !@!  @!@  !@!  @!@  !@! !@! !@!     !@!       !@!  @!@  !@!  @!@  !@!  !@!  @!@               !@!  !@!  @!@  \n" +
                "@!!!:!    !!@@!!    !@!       @!@!@!@!  @!@@!@!   @!!!:!       @!!!:!    @!@!!@!   @!@  !@!  @!! !!@ @!@     !@!       @!@  !@!  @!@  !@!  !!@  @!@  !@!  @!@!@!@!@    @!@  !!@!!@!!  \n" +
                "!!!!!:     !!@!!!   !!!       !!!@!!!!  !!@!!!    !!!!!:       !!!!!:    !!@!@!    !@!  !!!  !@!   ! !@!     !!!       !@!  !!!  !@!  !!!  !!!  !@!  !!!  !!!@!@!!!    !@!    !!@!!!  \n" +
                "!!:            !:!  :!!       !!:  !!!  !!:       !!:          !!:       !!: :!!   !!:  !!!  !!:     !!:     :!!       !!:  !!!  :!:  !!:  !!:  !!:  !!!               !!:       !!!  \n" +
                ":!:           !:!   :!:       :!:  !:!  :!:       :!:          :!:       :!:  !:!  :!:  !:!  :!:     :!:     :!:       :!:  !:!   ::!!:!   :!:  :!:  !:!               :!:       !:!  \n" +
                " :: ::::  :::: ::    ::: :::  ::   :::   ::        :: ::::      ::       ::   :::  ::::: ::  :::     ::       ::: :::  ::::: ::    ::::     ::   :::: ::               :::  ::::: ::  \n" +
                ": :: ::   :: : :     :: :: :   :   : :   :        : :: ::       :         :   : :   : :  :    :      :        :: :: :   : :  :      :      :    :: :  :                 ::   : :  :   \n" +
                "                                                                                                                                                                                      \n" +
                "                                                                                                                                                                                      \n" +
                ANSI_RESET);
    }

    public void introTextDelayed() {
            System.out.println(ANSI_CYAN + "________________________________________________________\n" +
                    "|   Welcome to Apprenticeship, Escape from COVID-19    |\n" +
                    "|   This game was developed as a Capstone Project for  |\n" +
                    "|   the TLG Learning SDE Training Course.              |\n" +
                    "|                                                      |\n" +
                    "|   Start the Game           [Command: Start]          |\n" +
                    "|   Read the Intro           [Command: Intro]          |\n" +
                    "|   Play the Tutorial        [Command: Tutorial]       |\n" +
                    "|   Exit this Program        [Command: Exit]           |\n" +
                    "|                                                      |\n" +
                    "|  Developed by Michael Lennerblom, Josh Jensen and    |\n" +
                    "|  RJ Smith. https://github.com/Capstone-RJMJ/capstone |\n" +
                    "|______________________________________________________|\n" + ANSI_RESET);
    }

    public void introText() throws InterruptedException {
        String[] infoText = {
                ANSI_BLUE,
                "Welcome to the Apprenticeship!  Your journey has been hard, but I will help you",
                "You have been intentionally injected with CoVID.  Luckily the vaccine ingredients",
                "are located in this Mansion.  If you fail to properly mix and administer the vaccine",
                "within 10 minutes you will die.",
                "To move around, you simply will type 'Up' 'Back' 'Left' and 'Right' as applicable.",
                ANSI_RESET
        };

        for (String messages : infoText) {
            Thread.sleep(650);
            System.out.println(messages);
        }
    }

// Display art https://www.asciiart.eu/buildings-and-places/other

    public static String bathroomDisplay() {
        return (ANSI_WHITE + "________________________________________________________\n" +
                "                                                         |\n" +
                "                                            __________   |\n" +
                "                           _    __    _    |          |  |\n" +
                "                          /_\\  /  \\  /_\\   |          |  |\n" +
                "                          =|= | // | =|=   |          |  |\n" +
                "                           !   \\__/   !    |          |  |\n" +
                "                                 _         |          |  |\n" +
                " ___               ___          //'        |          |  |\n" +
                "[___]       _   :=|   |=:   __T_||_T__     |p=        |  |\n" +
                "|  ~|     =)_)=   |   |    [__________]    |          |  |\n" +
                "|   |      (_(    |xXx|     \\_      _/     |          |  |\n" +
                "|   |      )_)    \"\"\"\"\"       \\    /       |          |  |\n" +
                "\\___|                          |  |        |          |  |\n" +
                " |  `========,                 |  |        |          |  |\n" +
                "__`.        .'_________________|  |________|__________lc_|\n" +
                "    `.    .'                  (____)                      \\\n" +
                "    _|    |_...             .;;;;;;;;.                     \\\n" +
                "   (________);;;;          :;;;;;;;;;;:                     \\\n" +
                "        :::::::'            '::::::::'                       \\\n" +
                "|_____________________________________________________________\n" + ANSI_RESET);
    }

    public static String labDisplay() {
        return  (ANSI_YELLOW + "__ _____ ____ _____ ______ _______ _____ ______ ______ ______ ___\n" +
                "__]_____]____]_____]______]_______]_____]______]______]______]___]\n" +
                "             _                       _______  |||\"||;;|.||##||=|||\n" +
                "  _                           _     |   *  3| |||-|| =|-||==||+|||\n" +
                "  ____________       _              |       | |||_||__|_||__||_|||\n" +
                "|`.   --__     `.        _______    |       | ||================||\n" +
                "|  `._____________`.  .'|.-----.|   _ ======| ||| | -|&|^^|!!|-|||\n" +
                "|   | .-----------.| |  ||     ||  (o))   _ | ||| |**|=|+-|##|=|||\n" +
                "|   | |  .-------.|| |  ||     ||  /||   / \\`._|  .-.|_|__|__|_|||\n" +
                "|   | |  |       |||_`..|'_____'| //||___\\_/.'\\| (( ))==========||\n" +
                "|   | |`.|  ==== ||| | `---------(o)||         \\  /-'-=|+|.-|-'|||\n" +
                "|`. | |`.|_______|||/|______________||__.--._ (o)/|=|;:|-|&&|&&|||\n" +
                "|  `|_|===========||_|                 (____)-.'(o)_|__|_|__|__|||\n" +
                "|   | |  .-------.||                           `._\\=============||\n" +
                "|   | |  |       |||                             `.     |       ||\n" +
                "|   | |`.|  ==== |||`._____________________________`.  o|o      ||\n" +
                "|`. | |`.|_______||| |._.----------------.__.-------.|__|_______||\n" +
                "|  `|_|===========|| || '----------------'  | .---. ||  __\n" +
                "|   | |  .-------.|| ||               |     |_______||.'\\.'.\n" +
                "|   | |  |       ||| || ______________|     | .---. ||'.__.'\n" +
                "|   | |`.|  ==== ||| ||                `.   |_______|||  _ |\n" +
                " `. | |`.|_______||| ||                  `. | .---. |||_  ||\n" +
                "   `|_|========LGB||`||                    `|_______|||____|\n" +
                "                       `.                    `.\n" +
                "                         `.____________________`.\n" + ANSI_RESET);
    }

    public static String kitchenDisplay() {
        return (ANSI_YELLOW + "_____________________________________________________\n" +
                "____________________________________________________\\\\\n" +
                "|.-------.-------.|_.----._.----._|.-------.-------.\\\\\\\n" +
                "|]       |       [|       .       |]       |       [ \\\\\\\n" +
                "||       |       ||     .':'.     ||       |       |  |\\\\\n" +
                "||       |       ||    .' : '.    ||       |       |  |\\\\\\\n" +
                "||     (O|O)     ||   .'  :  '.   ||     (O|O)     |  | \\\\\\\n" +
                "||       |       ||  .'===:==='.  ||       |       | O|  |\\\\\n" +
                "||       |       ||=='    :    '==||       |       |  |  |\\\\\\\n" +
                "|]       |       [|  )    :    (  |]       |       [  |O | \\\\\\\n" +
                "||_______|_______||\"\" ____:_____\"\"||_______|_______|  |  |  |\\\\\n" +
                "'-----------------'_______________'----------------'  |  |  |\\\\\\\n" +
                "|.--------.  |    '---------------'  (o)______)(0)  \\ |  |  | \\\\\\\n" +
                "||        |::|_________________________________())___\\|  | O|  \\\\\\______\n" +
                "||        |::|-----______*!*______-------------))( .'.\\  |  |   | _____ |\n" +
                "||________|::|  _ /       '       \\  _        _   (__.'\\ |  |O  ||     ||\n" +
                "|____________| _  \\_______________/     _           (_.'\\|  |   ||  _  ||\n" +
                " ___________________________________________      _  (___\\  |   ||     ||\n" +
                "||.-----.|.------.|.-.-.--.--.-.-.||.-----.||\\   _        \\ |   ||     ||\n" +
                "||| === ||| ==== ||| | |  |  | | |||| === ||| \\     _      \\|   ||    _||\n" +
                "||'-----'|'------'|'-'-'--'--'-'-'||'-----'||. \\          _ \\   ||     ||\n" +
                "||.-----.|.------.|.------.------.||.-----.|| `|\\       _    \\  || _   ||\n" +
                "||| === |||      |||      |      |||| === |||\\ | \\  _         \\ ||_____||\n" +
                "||'-----'|]      ||]      |      [||'-----'|| \\|. \\        _   \\|_______|\n" +
                "||.-----.||    (O|||    (O|O)    |||.-----.||  | `|\\                   ||\n" +
                "||| === |||      |||      |      |||| === |||  |\\ | \\__________________||\n" +
                "|||     ||]      ||]      |      [|||     ||| O| \\|. |  _____________  ||\n" +
                "||'-----'||______|||______|______|||'-----'||  |  | `| |             | ||\n" +
                "||LGB____|________|_______________||_______||  |O |\\ | |   _         | ||\n" +
                "''-----------------------------------------' \\ |  | \\| |          _  | ||\n" +
                "   ____                 _______               \\|  |  | |       _     | ||\n" +
                "           _________                  ______   \\  |O | |             | ||\n" +
                "                                                \\ |  | |   _      _  | ||\n" +
                "                                _________        \\|  | |             | ||\n" +
                "      ___________        __                       \\  | | _        _  | ||\n" +
                "    __                              _________      \\ | |_____________| ||\n" +
                "               ___________                          \\|_________________||" + ANSI_RESET);
    }

    public void recipeArt(Recipe recipe) {
        System.out.println("Zach has given you the recipe to mix the vaccine!");
        List<String> arr = new ArrayList<>();
        for(Color color : recipe.getColorMix()){
            String clr = color.toString().toUpperCase();
            if(clr.equals("RED")){
                clr = "RED ";
                arr.add(clr);
            }
            else {
                arr.add(clr);
            }
        }
        String color1 = arr.get(0);
        String color2 = arr.get(1);
        String color3 = arr.get(2);
        System.out.println("        _________   _________\n" +
                "   ____/      452\\ /     453 \\____\n" +
                " /| ------------- |  ------------ |\\\n" +
                "||| ------------- | ------------- |||\n" +
                "||| -----" + color1 + "---- | ------------- |||\n" +
                "||| ------- ----- | ------------- |||\n" +
                "||| -----" + color2 + "---- | ------------- |||\n" +
                "||| ----------- - | ------------- |||\n" +
                "|||  ---" + color3 + "----- | ----------    |||\n" +
                "||| ------------- |  ------------ |||\n" +
                "||| ------------- | ------------- |||\n" +
                "||| ------------- | ------ -----  |||\n" +
                "||| ------------  | ------------- |||\n" +
                "|||_____________  |  _____________|||\n" +
                "L/_____/--------\\\\_//W-------\\_____\\J");
    }

    public void mapDisplay() {
        System.out.println(ANSI_GREEN +
 ANSI_RESET + ANSI_BLUE +"+----------------------+" +ANSI_RESET + ANSI_RED + "             +--------------------+\n"+
 ANSI_RESET + ANSI_BLUE +"|                      |" +ANSI_RESET + ANSI_RED + "             |                    |\n"+
 ANSI_RESET + ANSI_BLUE +"|    Dining Room       |" +ANSI_RESET + ANSI_RED + "             |                    |\n"+
 ANSI_RESET + ANSI_BLUE +"|                      "+ANSI_RESET + ANSI_CYAN +"+-------------+" +ANSI_RESET + ANSI_RED + "                    |\n"+
 ANSI_RESET + ANSI_BLUE +"|                      "+ANSI_RESET + ANSI_CYAN +"|    Hall     |" +ANSI_RESET + ANSI_RED + "     Ball Room      |\n"+
 ANSI_RESET + ANSI_BLUE +"|                      "+ANSI_RESET + ANSI_CYAN +"+-------------+" +ANSI_RESET + ANSI_RED + "                    |\n"+
 ANSI_RESET + ANSI_BLUE +"|                      "+ANSI_RESET + ANSI_YELLOW +"|             |" +ANSI_RESET + ANSI_PURPLE + "                    +------------------------------------------+\n"+
 ANSI_RESET + ANSI_BLUE +"|                      "+ANSI_RESET + ANSI_YELLOW +"|             |" +ANSI_RESET + ANSI_RED + " " +ANSI_RESET + ANSI_PURPLE + "                   |                                          |\n"+
 ANSI_RESET + ANSI_BLUE +"|                      "+ANSI_RESET + ANSI_YELLOW +"|             |" +ANSI_RESET + ANSI_RED + " " +ANSI_RESET + ANSI_PURPLE + "                   |                                          |\n"+
 ANSI_RESET + ANSI_BLUE +"+----------------------+" +ANSI_RESET + ANSI_RED + "             +--------------------+" +ANSI_RESET + ANSI_PURPLE + "                                          |\n"+
 ANSI_RESET + ANSI_YELLOW +"                       |             | " +ANSI_RESET + ANSI_PURPLE + "                   |                                          |\n"+
 ANSI_RESET + ANSI_YELLOW +"                       |             |  " +ANSI_RESET + ANSI_PURPLE + "                  |             Movie Room                   |\n"+
 ANSI_RESET + ANSI_YELLOW +"                       |             |  " +ANSI_RESET + ANSI_PURPLE + "                  |                                          |\n"+
 ANSI_RESET + ANSI_BLACK +"     +-----------------+"+ ANSI_RESET + ANSI_YELLOW +"             |  " +ANSI_RESET + ANSI_PURPLE + "                  |                                          |\n"+
 ANSI_RESET + ANSI_BLACK +"     |                 |"+ ANSI_RESET + ANSI_YELLOW +"   Kitchen   |  " +ANSI_RESET + ANSI_PURPLE + "                  |               "+ANSI_RESET + ANSI_WHITE +"|---|                      |\n"+
 ANSI_RESET + ANSI_BLACK +"     |   Bathroom      |"+ ANSI_RESET + ANSI_YELLOW +"             |  " +ANSI_RESET + ANSI_PURPLE + "                  |               "               +ANSI_RESET + ANSI_WHITE +"|---|"+ANSI_RESET + ANSI_PURPLE + "                      |\n"+
 ANSI_RESET + ANSI_BLACK +"     +-----------------+"+ ANSI_RESET + ANSI_YELLOW +"-------------+  " +ANSI_RESET + ANSI_PURPLE + "                  +---------------"+ANSI_RESET + ANSI_WHITE +"|---|"+ANSI_RESET + ANSI_PURPLE +"----------------------+\n"+
 ANSI_RESET + ANSI_BLUE +"                                 +----------------+"+ANSI_RESET + ANSI_WHITE +"                       |---|\n"+
 ANSI_RESET + ANSI_BLUE +"                                 |                |"+ANSI_RESET + ANSI_WHITE +"                       |---|\n" +
 ANSI_RESET + ANSI_BLUE +"                                 |                |"+ANSI_RESET + ANSI_WHITE +"                       |---|\n"+
 ANSI_RESET + ANSI_BLUE +"                                 |                |"+ANSI_RESET + ANSI_WHITE +"                       |---|\n"+
 ANSI_RESET + ANSI_BLUE +"                                 |     Bedroom    "+ANSI_RESET + ANSI_CYAN +"+-----------------------+   |\n"+
 ANSI_RESET + ANSI_BLUE +"                                 |                "+ANSI_RESET + ANSI_CYAN +"|           Down Stairs     |\n"+
 ANSI_RESET + ANSI_BLUE +"                                 |                "+ANSI_RESET + ANSI_CYAN +"|              Hall         |\n"+
 ANSI_RESET + ANSI_BLUE +"                                 |                "+ANSI_RESET + ANSI_CYAN +"+---------------------------+\n"+
 ANSI_RESET + ANSI_BLUE +"                                 |                |\n"+
 ANSI_RESET + ANSI_BLUE +"                                 |                |\n"+
 ANSI_RESET + ANSI_BLUE +"                                 |                |\n"+
 ANSI_RESET + ANSI_BLUE +"                                 +--+-----------+-+\n"+
 ANSI_RESET + ANSI_RED +"                                    |           |\n"+
 ANSI_RESET + ANSI_PURPLE +"                        +-----------+"+ ANSI_RESET + ANSI_RED +"  Library  "+ ANSI_RESET + ANSI_YELLOW +"+----------+\n"+
 ANSI_RESET + ANSI_PURPLE +"                        |           |           " + ANSI_RESET + ANSI_YELLOW +          "|          |\n"+
 ANSI_RESET + ANSI_PURPLE +"                        |  Cave     "+ ANSI_RESET + ANSI_RED +"+-----------+" + ANSI_RESET + ANSI_YELLOW +         "   Lab    |\n"+
 ANSI_RESET + ANSI_PURPLE +"                        |           |           " + ANSI_RESET + ANSI_YELLOW +          "|          |\n"+
 ANSI_RESET + ANSI_PURPLE +"                        |           |           " + ANSI_RESET + ANSI_YELLOW +          "|          |\n"+
 ANSI_RESET + ANSI_PURPLE +"                        +-----------+           " + ANSI_RESET + ANSI_YELLOW +          "+----------+\n"+
"                                                                                                                                             \n" + ANSI_RESET);
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_CYAN + "Type back to return." + ANSI_RESET);
        scanner.next();
        movementEngine.clearScreen();
    }

}
