package eafit.edu.ds1.recursion;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class GymTester {
    public static void main(String[] args) throws
            FileNotFoundException {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter the name of the file containing the map: ");
        String mapfile = scnr.nextLine();
        Gym labyrinth = new Gym(mapfile);

        System.out.println(labyrinth);

        GymWalker walker = new GymWalker(labyrinth);

        if(walker.traverse(0,0)){
            System.out.println("The gym is walkable!");
        }else{
            System.out.println("It's a trap!");
        }

        System.out.println(labyrinth);

    }
}
