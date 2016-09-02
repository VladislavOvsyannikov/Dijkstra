import java.io.File;
import java.io.IOException;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        int size;
        int matrix[][];
        int source;

        Scanner in = null;
        try {
            in = new Scanner(new File("in.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        size = in.nextInt();
        matrix = new int[size + 1][size + 1];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                matrix[i][j] = in.nextInt();
                if (i == j) {
                    matrix[i][j] = 0;
                }
                if (matrix[i][j] == 0) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        source = in.nextInt();
        in.close();

//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("Введите число вершин");
//        size = scan.nextInt();
//
//        matrix = new int[size + 1][size + 1];
//        System.out.println("Введите матрицу для графа");
//        for (int i = 1; i <= size; i++) {
//            for (int j = 1; j <= size; j++) {
//                matrix[i][j] = scan.nextInt();
//                if (i == j) {
//                    matrix[i][j] = 0;
//                }
//                if (matrix[i][j] == 0) {
//                    matrix[i][j] = Integer.MAX_VALUE;
//                }
//            }
//        }
//
//        System.out.println("Введите начальную вершину ");
//        source = scan.nextInt();

        Dijkstra Algorithm = new Dijkstra(size, matrix);
        Algorithm.dijkstra_algorithm(source);

        System.out.println("Отсортированный путь ко всем вершинам: ");
        for (int i = 1; i < Algorithm.distances.length; i++) {
            if (Algorithm.distances[i]!=Integer.MAX_VALUE) {
                System.out.println(source + " -> " + i + " Стоимость: " + Algorithm.distances[i]);
            }
            else {
                System.out.println(source + " -> " + i + " Нет пути ");
            }
        }
//        scan.close();
    }
}