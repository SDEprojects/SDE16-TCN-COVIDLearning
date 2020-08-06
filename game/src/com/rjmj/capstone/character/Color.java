package com.rjmj.capstone.character;

import java.text.MessageFormat;

public interface Color {

    String ANSI_RESET = "\u001B[0m";
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_PURPLE = "\u001B[35m";
    String ANSI_GREEN = "\u001B[32m";

    /**
     * Coloring the fonts
     * {0}:ANSI_CYAN, {1}:ANSI_RED, {2}:ANSI_BLUE, {3}:ANSI_RESET, {4}:ANSI_PURPLE
     */
    public default String textPainter(String text) {
        return MessageFormat.format(
                text,
                ANSI_CYAN,
                ANSI_RED,
                ANSI_BLUE,
                ANSI_RESET,
                ANSI_PURPLE);
    }

}
