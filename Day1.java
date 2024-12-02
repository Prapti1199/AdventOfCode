package Advent_Of_Code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;


public class Day1 {

    public static void calculateDistance(ArrayList<Integer> col1, ArrayList<Integer> col2){
        int result = 0;

        int length1 = col1.size();
        int length2 = col2.size();

        if(length2 != length1){
            System.out.println("Answer of calculateDistance : " + result);
        } else{
            for(int i=0; i<length2; i++){
                result += Math.abs(col1.get(i) - col2.get(i));
            }
        }

        System.out.println("Answer of calculateDistance : " + result);

    }

    public static void similarityScore(ArrayList<Integer> col1, ArrayList<Integer> col2){

        long result = 0;

        for(Integer nCol1 : col1){
            long count = col2.stream()
                    .takeWhile(value -> value <= nCol1)
                    .filter(value -> value.equals(nCol1))
                    .count();
            result = result + (nCol1*count);
        }
        System.out.println("Answer of similarityScore: " + result);

    }


        public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Integer> col1 = new ArrayList<>();
        ArrayList<Integer> col2 = new ArrayList<>();

        // Taking input from cmd
    /*
       Scanner sc = new Scanner(System.in);
       while(true) {
            String line = sc.nextLine();
            if (line.isEmpty()){
                break;
            }
            String[] num = line.split("   ");
            col1.add(Integer.parseInt(num[0]));
            col2.add(Integer.parseInt(num[1]));

        }

     */
        // Taking input from file

        Scanner sc = new Scanner(new File("src/Advent_Of_Code/day1_input.txt"));
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if (line.isEmpty()){
                break;
            }
            String[] num = line.split("   ");
            col1.add(Integer.parseInt(num[0]));
            col2.add(Integer.parseInt(num[1]));
        }


        Collections.sort(col1);
        Collections.sort(col2);
        Day1.calculateDistance(col1, col2);
        Day1.similarityScore(col1, col2);

    }
}
