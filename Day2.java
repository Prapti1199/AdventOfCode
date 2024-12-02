package Advent_Of_Code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Day2 {
    public static void part1(ArrayList<ArrayList<Integer>> numArray) throws FileNotFoundException {

        int nSafe = 0;
        for(int i=0; i<numArray.size(); i++) {
            if (Day2.validate(numArray.get(i))) {
                nSafe += 1;
            }
        }
        System.out.println("Part 1:  " + nSafe);

    }

    public  static boolean validate(ArrayList<Integer> nums){
        if(nums.size()<2) return true;

        boolean isIncreasing = IntStream.range(0, nums.size()-1).allMatch(i -> nums.get(i) < nums.get(i+1));
        boolean isDecreasing = IntStream.range(0, nums.size()-1).allMatch(i -> nums.get(i) > nums.get(i+1));

        boolean isValidDiff = IntStream.range(0, nums.size()-1).allMatch(
                i -> {
                    int diff = Math.abs(nums.get(i) - nums.get(i + 1));
                    return diff >= 1 && diff <= 3;
                }
        );

        return (isDecreasing || isIncreasing) && isValidDiff;



    }

    public  static boolean fix(ArrayList<Integer> nums){

        for(int i=0; i<nums.size(); i++){
            ArrayList<Integer> temp = (ArrayList<Integer>) nums.clone();
            temp.remove(i);
            if(Day2.validate(temp)){
                return true;
            }
        }
        return false;

    }
    public  static  void part2(ArrayList<ArrayList<Integer>> numArray) throws FileNotFoundException {
        int nSafe = 0;

        for(int i=0; i<numArray.size(); i++){
            if(Day2.validate(numArray.get(i))){
                nSafe += 1;
            } else if(Day2.fix(numArray.get(i))) {
                nSafe += 1;
            }
        }
        System.out.println("Part 2 : " + nSafe);

    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Advent_Of_Code/day2_input.txt"));
        ArrayList<ArrayList<Integer>> numArray = new ArrayList<>();
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] nums  = s.split(" ");
            ArrayList<Integer> num = new ArrayList<>();
            for(String n : nums){
                num.add(Integer.parseInt(n));
            }
            numArray.add(num);
        }

        Day2.part1(numArray);
        Day2.part2(numArray);


    }
}
