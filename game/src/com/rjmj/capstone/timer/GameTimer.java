package com.rjmj.capstone.timer;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class GameTimer implements Runnable{
    JFrame frame;
    Thread thread=null;
    int hours=0, minutes=0, seconds=0;
    String timeString = "";
    JButton button;

    public GameTimer(){
        frame=new JFrame();

        thread = new Thread(this);
        thread.start();

        button=new JButton();
        button.setBounds(100,100,100,50);

        frame.add(button);
        frame.setSize(300,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void run() {
        try {
            while (true) {

                Calendar cal = Calendar.getInstance();
                hours = cal.get( Calendar.HOUR_OF_DAY );
                if ( hours > 12 ) hours -= 12;

                minutes = cal.get( Calendar.MINUTE );
                seconds = cal.get( Calendar.SECOND );

                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                Date date = cal.getTime();
                timeString = formatter.format( date );

                printTime();

                thread.sleep( 1000 );  // interval given in milliseconds
            }
        }
        catch (Exception e) { }
    }

    public GameTimer printTime(){
        button.setText(timeString);
        return null;
    }

    /*    public static void main(String[] args) {
            new DigitalWatch();

*/
}





