package co.com.fredymosquera.round2008.round1a;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class MinimumScalarProduct {

    public static void main(String[] args) throws FileNotFoundException {

       // Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner in = new Scanner(new BufferedReader(new FileReader("/Users/fredymosquera/Documents/learning/google_codejam/code_jam/src/main/java/co/com/fredymosquera/round2008/round1a/input_file_MinimumScalarProduct.txt")));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t ; i++) {
            int n = Integer.parseInt(in.nextLine());
            List<Long> vector1 = Arrays.stream(in.nextLine().split(" "))
                    .map( numb -> Long.parseLong(numb)).collect(Collectors.toList());

            List<Long> vector2 = Arrays.stream(in.nextLine().split(" "))
                    .map( numb -> Long.parseLong(numb)).collect(Collectors.toList());
            Collections.sort(vector1);
            Collections.sort(vector2, Comparator.reverseOrder());

            Long minScaPro = 0l;
            for (int j = 0; j < n; j++) {
                minScaPro += vector1.get(j) * vector2.get(j);
            }
            System.out.println("Case #"+i+": "+minScaPro);
            
        }
    }
}
