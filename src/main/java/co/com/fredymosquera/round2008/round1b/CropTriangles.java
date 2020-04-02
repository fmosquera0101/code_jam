package co.com.fredymosquera.round2008.round1b;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CropTriangles {

    public static void main(String[] args) {
        InputStream inputStream = new CropTriangles().getClass().getClassLoader().getResourceAsStream("A-small-practice_cropTriangles.in");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        int N = Integer.parseInt(in.nextLine());
        for (int i = 0; i < N; i++) {
            String line = in.nextLine();
            List<Integer> numbers = Arrays.asList(line.split(" "))
                    .stream()
                    .map(val -> Integer.parseInt(val))
                    .collect(Collectors.toList());

            int n = numbers.get(0);
            int A = numbers.get(1);
            int B = numbers.get(2);
            int C = numbers.get(3);
            int D = numbers.get(4);
            int X0 = numbers.get(5);
            int Y0 = numbers.get(6);
            int M = numbers.get(7);

            int X = X0;
            int Y = Y0;
            List<Point> points = new ArrayList<>();
            points.add(new Point(X, Y));
            for (int j = 1; j < n ; j++) {
                X = (A * X + B) % M;
                Y = (C * Y + D) % M;
               points.add(new Point(X, Y));
            }

            List<List<Point>> comb = new ArrayList<>();
            List<Point> pointConcat = new ArrayList<>();
            int k = 3;
            combine(points, pointConcat,0, points.size() ,k, comb);


            List<Triangle> triangles =
            comb.stream()
                    .map(c -> c.stream())
                    .map(sc -> new Triangle(sc.collect(Collectors.toList())))
                    .collect(Collectors.toList());
            

            long result =
            triangles.stream()
                    .filter(triangle -> triangle.isTriangle())
                    .filter(triangle ->
                            points.stream()
                            .filter(point -> triangle.center.x == point.x && triangle.center.y == point.y)
                            .findFirst().isPresent()
                            )
                    .count();

            System.out.println("Case #"+i+": "+result);



        }

    }

    private static void combine(List<Point> points, List<Point> pointCon, int i, int n, int k, List<List<Point>> out){

        if(k > n){
            return;
        }
        if(k == 0){
            out.add(pointCon);
            return;
        }
        for (int j = i; j < n ; j++) {
            combine(points, Stream.concat(pointCon.stream(), Stream.of(points.get(j))).collect(Collectors.toList()), j + 1, n, k - 1, out );
        }


    }
    private static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point(" + x + "," + y + ')';
        }
    }
    private static class Triangle{
        private List<Point> points;
        private Point center;
        private boolean isTriangle;
        public Triangle(List<Point> points){
            if(points.size() != 3){
                throw new IllegalArgumentException("Triangle has to be composed of a list of 3 points");
            }
            this.points = points;
            this.center = center();
            this.isTriangle = isTriangle();
        }

        public boolean isTriangle(){
            int  delta = (int)area();
            if(delta >= 0){
                return  true;
            }
            return false;
        }

        public double area(){
            Point p1 = points.get(0);
            Point p2 = points.get(1);
            Point p3 = points.get(2);
            return getArea(p1, p2, p3);
        }

        private double getArea(Point p1, Point p2, Point p3) {
            return 0.5*(p1.x*(p2.y - p3.y) + p2.x*(p3.y -p1.y) + p3.x*(p1.y - p2.y));
        }

        private Point center(){
            Point p1 = points.get(0);
            Point p2 = points.get(1);
            Point p3 = points.get(2);
            return new Point((p1.x + p2.x + p3.x)/3, (p1.y + p2.y + p3.y)/3);
        }

        private Point getCenter(){
            return center;
        }

        public boolean isInside(Point point){
            Point p1 = points.get(0);
            Point p2 = points.get(1);
            Point p3 = points.get(2);

            double a = getArea(p1, p2, p3);
            double b = getArea(point, p2, p3);
            double c = getArea(p1, point, p3);
            double d = getArea(p1, p2, point);
            return (a == b + c + d);
        }


        @Override
        public String toString() {
            return "Triangle{" +
                    "points=" + points +
                    ", center=" + center +
                    ", isTriangle=" + isTriangle +
                    '}';
        }
    }
}
