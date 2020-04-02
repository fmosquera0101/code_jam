
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class MinimumScalarProduct {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = Integer.parseInt(in.nextLine());
        for (int i = 0; i < t ; i++) {
            int n = Integer.parseInt(in.nextLine());
            List<Integer> vector1 = Arrays.stream(in.nextLine().split(" "))
                    .map( numb -> Integer.parseInt(numb)).collect(Collectors.toList());
            List<Integer> vector2 = Arrays.stream(in.nextLine().split(" "))
                    .map( numb -> Integer.parseInt(numb)).collect(Collectors.toList());
            Collections.sort(vector1);
            Collections.sort(vector2, Comparator.reverseOrder());

            int minScaPro = 0;
            for (int j = 0; j < n; j++) {
                minScaPro += vector1.get(i) * vector2.get(i);
            }
            System.out.println("Case #"+t+": "+minScaPro);

        }
    }
}
