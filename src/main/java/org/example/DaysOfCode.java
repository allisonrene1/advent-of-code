package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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


//    3   4
//            4   3
//            2   5
//            1   3
//            3   9
//            3   3
//    For these example lists, here is the process of finding the similarity score:
//
//    The first number in the left list is 3. It appears in the right list three times, so the similarity score
//    increases by 3 * 3 = 9.
//    The second number in the left list is 4. It appears in the right list once, so the similarity score
//    increases by 4 * 1 = 4.
//    The third number in the left list is 2. It does not appear in the right list, so the similarity score
//    does not increase (2 * 0 = 0).
//    The fourth number, 1, also does not appear in the right list.
//    The fifth number, 3, appears in the right list three times; the similarity score increases by 9.
//    The last number, 3, appears in the right list three times; the similarity score again increases by 9.
//    So, for these example lists, the similarity score at the end of this process is 31 (9 + 4 + 0 + 0 + 9 + 9).



    public int similarityScore(List<Integer> leftList, List<Integer> rightList) {

        Map<Integer, Integer> rightCount = new HashMap<>();
        for (int num : rightList) {
            rightCount.put(num, rightCount.getOrDefault(num, 0) + 1);
        }

        int similarityScore = 0;
        for (int num : leftList) {
            int countInRight = rightCount.getOrDefault(num, 0);
            similarityScore += num * countInRight;
        }

        return similarityScore;

    }



    public static void main(String[] args) {

        DaysOfCode daysOfCode = new DaysOfCode();

//
//        List<Integer> leftList = new ArrayList<>(Arrays.asList(3, 4, 2, 1, 3, 3));
//        List<Integer> rightList = new ArrayList<>(Arrays.asList(4, 3, 5, 3, 9, 3));
//        int finalResult = daysOfCode.similarityScore(leftList, rightList);
//        System.out.println(finalResult);


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



        try {
            List<Integer> leftList1 = new ArrayList<>();
            List<Integer> rightList1 = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] numbers = line.trim().split("\\s+");
                if (numbers.length != 2) {
                    throw new IllegalArgumentException("Each line can only have 2 numbers");
                }

                leftList1.add(Integer.parseInt(numbers[0]));
                rightList1.add(Integer.parseInt(numbers[1]));
            }

            reader.close();

            int theSimilarityScore = daysOfCode.similarityScore(leftList1, rightList1);
            System.out.println("The similarity score: " + theSimilarityScore);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing numbers: " + e.getMessage());
        }



    }



}