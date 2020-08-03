package com.rjmj.capstone.engine;

import junit.framework.TestCase;

import java.io.IOException;

public class ParserTest extends TestCase {
    private Parser parser = new Parser();

    private String skedaddle = "skedaddle";
    private String advance = "advance";
    private String move = "move";
    private String walk = "walk";
    private String run = "run";
    private String go = "go";
    private String flee = "flee";
    private String enter = "enter";
    private String travel = "travel";
    private String scoot = "scoot";
    private String fly = "fly";
    private String lurch = "lurch";
    private String mosey = "mosey";

    private String search = "search";
    private String look = "look";
    private String explore = "explore";
    private String examine = "examine";
    private String inspect = "inspect";
    private String view = "view";
    private String hunt = "hunt";
    private String pursue = "pursue";
    private String research = "research";
    private String rummage = "rummage";
    private String peruse = "peruse";

    private String take = "take";
    private String grab = "grab";
    private String acquire = "acquire";
    private String get = "get";
    private String add = "add";
    private String pick = "pick";
    private String select = "select";

    private String chat = "chat";
    private String talk = "talk";
    private String speak = "speak";
    private String converse = "converse";
    private String discuss = "discuss";
    private String mingle = "mingle";
    private String chitchat = "chit-chat";
    private String engage = "engage";

    private String use = "use";
    private String open = "open";
    private String read = "read";
    private String fire = "fire";
    private String write = "write";

    private String alphabet = "alphabet";
    private String newYorkCity = "New York City";
    private String inconceivable = "inconceivable";
    private String whale = "whale";
    private String enormous = "enormous";
    private String modernism = "modernism";
    private String modelT = "Model T";
    private String celery = "celery";
    private String blue = "blue";


    public void testIsTakeSynonym() {
        assertTrue(parser.isTakeSynonym(take));
        assertTrue(parser.isTakeSynonym(grab));
        assertTrue(parser.isTakeSynonym(acquire));
        assertTrue(parser.isTakeSynonym(get));
        assertTrue(parser.isTakeSynonym(select));
        assertTrue(parser.isTakeSynonym(add));
        assertTrue(parser.isTakeSynonym(pick));

        assertFalse(parser.isTakeSynonym(alphabet));
        assertFalse(parser.isTakeSynonym(read));
        assertFalse(parser.isTakeSynonym(explore));
        assertFalse(parser.isTakeSynonym(engage));
        assertFalse(parser.isTakeSynonym(converse));
        assertFalse(parser.isTakeSynonym(travel));
        assertFalse(parser.isTakeSynonym(blue));
        assertFalse(parser.isTakeSynonym(inconceivable));
    }



    public void testIsTalkSynonym() {
        assertTrue(parser.isTalkSynonym(chitchat));
        assertTrue(parser.isTalkSynonym(chat));
        assertTrue(parser.isTalkSynonym(talk));
        assertTrue(parser.isTalkSynonym(speak));
        assertTrue(parser.isTalkSynonym(converse));
        assertTrue(parser.isTalkSynonym(discuss));
        assertTrue(parser.isTalkSynonym(mingle));
        assertTrue(parser.isTalkSynonym(engage));

        assertFalse(parser.isTalkSynonym(get));
        assertFalse(parser.isTalkSynonym(read));
        assertFalse(parser.isTalkSynonym(whale));
        assertFalse(parser.isTalkSynonym(grab));
        assertFalse(parser.isTalkSynonym(pick));
        assertFalse(parser.isTalkSynonym(select));
        assertFalse(parser.isTalkSynonym(move));
        assertFalse(parser.isTalkSynonym(flee));
        assertFalse(parser.isTalkSynonym(modernism));
    }

    public void testIsUseSynonym() {
        assertTrue(parser.isUseSynonym(use));
        assertTrue(parser.isUseSynonym(open));
        assertTrue(parser.isUseSynonym(read));
        assertTrue(parser.isUseSynonym(fire));
        assertTrue(parser.isUseSynonym(write));

        assertFalse(parser.isUseSynonym(alphabet));
        assertFalse(parser.isUseSynonym(newYorkCity));
        assertFalse(parser.isUseSynonym(inconceivable));
        assertFalse(parser.isUseSynonym(enormous));
        assertFalse(parser.isUseSynonym(celery));
        assertFalse(parser.isUseSynonym(blue));
        assertFalse(parser.isUseSynonym(lurch));
        assertFalse(parser.isUseSynonym(add));
        assertFalse(parser.isUseSynonym(pick));
        assertFalse(parser.isUseSynonym(search));
    }

    public void testIsSearchSynonym() {
        assertTrue(parser.isSearchSynonym(search));
        assertTrue(parser.isSearchSynonym(research));
        assertTrue(parser.isSearchSynonym(examine));
        assertTrue(parser.isSearchSynonym(pursue));
        assertTrue(parser.isSearchSynonym(peruse));
        assertTrue(parser.isSearchSynonym(hunt));
        assertTrue(parser.isSearchSynonym(inspect));
        assertTrue(parser.isSearchSynonym(view));
        assertTrue(parser.isSearchSynonym(explore));
        assertTrue(parser.isSearchSynonym(look));
        assertTrue(parser.isSearchSynonym(rummage));

        assertFalse(parser.isSearchSynonym(whale));
        assertFalse(parser.isSearchSynonym(alphabet));
        assertFalse(parser.isSearchSynonym(chitchat));
        assertFalse(parser.isSearchSynonym(flee));
        assertFalse(parser.isSearchSynonym(travel));
        assertFalse(parser.isSearchSynonym(inconceivable));
        assertFalse(parser.isSearchSynonym(newYorkCity));
        assertFalse(parser.isSearchSynonym(modelT));
        assertFalse(parser.isSearchSynonym(read));
        assertFalse(parser.isSearchSynonym(fire));
        assertFalse(parser.isSearchSynonym(lurch));
    }

    public void testIsMoveSynonym() {
        assertTrue(parser.isMoveSynonym(skedaddle));
        assertTrue(parser.isMoveSynonym(advance));
        assertTrue(parser.isMoveSynonym(move));
        assertTrue(parser.isMoveSynonym(walk));
        assertTrue(parser.isMoveSynonym(run));
        assertTrue(parser.isMoveSynonym(go));
        assertTrue(parser.isMoveSynonym(flee));
        assertTrue(parser.isMoveSynonym(enter));
        assertTrue(parser.isMoveSynonym(travel));
        assertTrue(parser.isMoveSynonym(scoot));
        assertTrue(parser.isMoveSynonym(fly));
        assertTrue(parser.isMoveSynonym(lurch));
        assertTrue(parser.isMoveSynonym(mosey));

        assertFalse(parser.isMoveSynonym(blue));
        assertFalse(parser.isMoveSynonym(celery));
        assertFalse(parser.isMoveSynonym(modernism));
        assertFalse(parser.isMoveSynonym(newYorkCity));
        assertFalse(parser.isMoveSynonym(whale));
        assertFalse(parser.isMoveSynonym(enormous));
        assertFalse(parser.isMoveSynonym(inconceivable));
        assertFalse(parser.isMoveSynonym(get));
        assertFalse(parser.isMoveSynonym(chitchat));
        assertFalse(parser.isMoveSynonym(alphabet));
    }

    public ParserTest() throws IOException {
    }
}