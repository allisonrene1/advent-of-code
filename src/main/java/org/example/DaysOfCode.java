package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DaysOfCode {

//
//             3   4
//            4   3
//            2   5
//            1   3
//            3   9
//            3   3


//    In the example list above, the pairs and distances would be as follows:
//
//    The smallest number in the left list is 1, and the smallest number in the right list is 3.
//    The distance between them is 2.
//    The second-smallest number in the left list is 2, and the second-smallest number in the right list is another 3.
//    The distance between them is 1.
//    The third-smallest number in both lists is 3, so the distance between them is 0.
//    The next numbers to pair up are 3 and 4, a distance of 1.
//    The fifth-smallest numbers in each list are 3 and 5, a distance of 2.
//    Finally, the largest number in the left list is 4, while the largest number in the right list is 9;
//    these are a distance 5 apart.
//    To find the total distance between the left list and the right list, add up the distances between
//    all the pairs you found.
//    In the example above, this is 2 + 1 + 0 + 1 + 2 + 5, a total distance of 11!



    public int distanceBetweenLists(List<Integer> leftList, List<Integer> rightList) {

        int finalResult = 0;

        Collections.sort(leftList);
        Collections.sort(rightList);
        

        for(int i = 0; i < leftList.size(); i++) {

            finalResult = finalResult + Math.abs(leftList.get(i) - rightList.get(i));

        }

        return finalResult;

    };



    public static void main(String[] args) {

        DaysOfCode daysOfCode = new DaysOfCode();


        String filePath = "C:\\Users\\18478\\Desktop\\allison-dev\\continuing-education\\advent-of-code\\src\\main\\java\\org\\example\\numbers.txt";

        try {
            List<Integer> leftList = new ArrayList<>();
            List<Integer> rightList = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] numbers = line.trim().split("\\s+");
                if (numbers.length != 2) {
                    throw new IllegalArgumentException("Each line can only have 2 numbers");
                }

                leftList.add(Integer.parseInt(numbers[0]));
                rightList.add(Integer.parseInt(numbers[1]));
            }

            reader.close();

            int theTotalDistance = daysOfCode.distanceBetweenLists(leftList, rightList);
            System.out.println("Total Distance: " + theTotalDistance);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing numbers: " + e.getMessage());
        }



    }



}