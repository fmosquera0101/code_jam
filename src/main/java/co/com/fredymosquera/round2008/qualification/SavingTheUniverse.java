package co.com.fredymosquera.round2008.qualification;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SavingTheUniverse {

    public static void main(String[] args) throws FileNotFoundException {
       // Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        Scanner in = new Scanner(new BufferedReader(new FileReader("/Users/fredymosquera/Documents/learning/google_codejam/code_jam/A-small-practice.in")));

        int n  = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= n ; i++) {

            int s = Integer.parseInt(in.nextLine());
            List<String> searchEngines = new ArrayList<>(s);
            for (int j = 1; j <= s; j++) {
                searchEngines.add(in.nextLine());
            }

            int q = Integer.parseInt(in.nextLine());
            List<String> queries = new ArrayList<>(q);
            for (int j = 1; j <= q ; j++) {
                queries.add(in.nextLine());
            }

            long min = searchEngines.stream()
                    .map(
                            engine -> queries.stream()
                                    .filter( query -> query.equals(engine))
                    )
                    .map(c -> c.count())
                    .min(Long::compare).get();

            System.out.println("Case #"+i+": "+min);
        }




    }
}
