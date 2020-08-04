package com.rjmj.capstone.engine;

import junit.framework.TestCase;

import java.io.IOException;

public class ParserTest extends TestCase {
    private final Parser parser = new Parser();

    private final String skedaddle = "skedaddle";
    private final String advance = "advance";
    private final String move = "move";
    private final String walk = "walk";
    private final String run = "run";
    private final String go = "go";
    private final String flee = "flee";
    private final String enter = "enter";
    private final String travel = "travel";
    private final String scoot = "scoot";
    private final String fly = "fly";
    private final String lurch = "lurch";
    private final String mosey = "mosey";

    private final String search = "search";
    private final String look = "look";
    private final String explore = "explore";
    private final String examine = "examine";
    private final String inspect = "inspect";
    private final String view = "view";
    private final String hunt = "hunt";
    private final String pursue = "pursue";
    private final String research = "research";
    private final String rummage = "rummage";
    private final String peruse = "peruse";

    private final String take = "take";
    private final String grab = "grab";
    private final String acquire = "acquire";
    private final String get = "get";
    private final String add = "add";
    private final String pick = "pick";
    private final String select = "select";

    private final String chat = "chat";
    private final String talk = "talk";
    private final String speak = "speak";
    private final String converse = "converse";
    private final String discuss = "discuss";
    private final String mingle = "mingle";
    private final String chitchat = "chit-chat";
    private final String engage = "engage";

    private final String use = "use";
    private final String open = "open";
    private final String read = "read";
    private final String fire = "fire";
    private final String write = "write";

    private final String alphabet = "alphabet";
    private final String newYorkCity = "New York City";
    private final String inconceivable = "inconceivable";
    private final String whale = "whale";
    private final String enormous = "enormous";
    private final String modernism = "modernism";
    private final String modelT = "Model T";
    private final String celery = "celery";
    private final String blue = "blue";


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