package com.rjmj.capstone;

public interface ExceptionMessage {

    public default void somethingWentWrong(Exception e){
        System.out.println("****** Something went wrong ******");
        System.out.println("Place: " + getClass().getName());
        System.out.println("Exception message : " + e.getMessage());
    }

}
