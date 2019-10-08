import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FlyingSafelyApp {

    public static void main(String[] args){
        File file = new File("F.in");
        try {
            Scanner scnr = new Scanner(file);
            int testCases = scnr.nextInt();
            for(int i = 0; i < testCases; i++){
                int cities = scnr.nextInt();
                Graph g = new Graph();
                for(int k = 0; k < cities; k++){
                    Vertex<String> v = new Vertex<>(""+(k+1));
                    g.addVertex(v);
                }
                int pilots = scnr.nextInt();
                for(int j = 0; j < pilots; j++){
                    int src = scnr.nextInt() - 1;
                    int dest = scnr.nextInt() - 1;
                    g.addEdge(src, dest);

                }
                System.out.println(g.DFS());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found!");
        }

    }
}
