package co.com.fredymosquera.round2019.qualification;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CodeJamLotteryProblem {

    public static void main(String[] args) {
        InputStream inputStream = new CodeJamLotteryProblem().getClass().getClassLoader().getResourceAsStream("CodeJamLotteryProblem_input_file.txt");

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));

            int t = Integer.parseInt(in.nextLine());
            for (int i = 1; i <= t; i++) {
                final String N = "4";
                final String NUMBER = "940";
                List<String> listA = Arrays.stream(NUMBER.split("")).collect(Collectors.toList());
                List<String> listB = listA.stream().map(num -> "0").collect(Collectors.toList());
                for (int j = 0; j < listA.size(); j++) {
                    if (N.equals(listA.get(i))) {
                        listB.set(i, "2");
                        listA.set(i, "2");
                    }
                }

                System.out.println("Case#" + t + ": " + listA.stream().collect(Collectors.joining()) + " " + listB.stream().collect(Collectors.joining()));
            }
        }

}