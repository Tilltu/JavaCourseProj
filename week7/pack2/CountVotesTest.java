package mystring.pack2;

import  mystring.pack1.*;
import  java.util.*;

public class CountVotesTest {
    public static void main (String[] args) {
        int i;
        String input;
        String regex = "[^a-zA-Z]";
        Scanner in   = new Scanner(System.in);
        CountVotes countVotes = new CountVotes();
        ArrayList<String[]> src = new ArrayList<>();//= new String[100];

        for(i = 0;i < 10;i++) {
            input = in.nextLine();
            src.add(input.split(regex));
        }
        countVotes.addVotes(src);
        countVotes.printCandidate();
        in.close();
    }
}
