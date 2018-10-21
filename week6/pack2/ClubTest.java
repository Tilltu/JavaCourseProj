package pack2;
import  pack1.Club;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;

public class ClubTest {
    public static void printA(HashSet<Club> club_A) {
        System.out.println("Member of A : ");
        for (Club person : club_A
             ) {
            System.out.println(person.name);
        }

    }
    public static void printB(HashSet<Club> club_B) {
        System.out.println("Member of B : ");
        for (Club person : club_B
        ) {
            System.out.println(person.name);
        }
    }
    public static void printAandB(HashSet<Club> club_A, HashSet<Club> club_B) {
        System.out.println("Member of both A and B : ");
        HashSet<Club> cross = new HashSet<>();
        for (Club person : club_A
             ) {
            if(club_B.contains(person)) {
                cross.add(person);
                System.out.println(person.name);
            }
        }

    }
    public static void printOnlyA(HashSet<Club> club_A, HashSet<Club> club_B) {
        System.out.println("Member of A only : ");
        for (Club person : club_A
             ) {
            if(!(club_B.contains(person))) {
                System.out.println(person.name);
            }
        }
    }
    public static void printOnlyB(HashSet<Club> club_A, HashSet<Club> club_B) {
        System.out.println("Member of B only : ");
        for (Club person : club_B
             ) {
            if(!(club_A.contains(person))) {
                System.out.println(person.name);
            }
        }
    }
    public static void main(String [] args) {
        HashSet<Club> clubs_A = new HashSet<>();
        HashSet<Club> clubs_B = new HashSet<>();
        Scanner in          = new Scanner(System.in);
        int i;
        String name, club;

        for(i = 0; i < 6;i++) {
            name   = in.next();
            club   = in.next();
            Club o = new Club();
            o.setClub(club);
            o.setName(name);
            //System.out.println(name + "  " + club);
            if(club.equals("A")) {
                clubs_A.add(o);
            }
            else if(club.equals("B")) {
                clubs_B.add(o);
            }
        }

        System.out.println(clubs_A + "  " + clubs_B);

        printA(clubs_A);
        printB(clubs_B);
        printAandB(clubs_A, clubs_B);
        printOnlyA(clubs_A, clubs_B);
        printOnlyB(clubs_A, clubs_B);
    }
}

/*
张三 A
李四 A
陈六 A
李四 B
王五 B
蔡九 B
*/