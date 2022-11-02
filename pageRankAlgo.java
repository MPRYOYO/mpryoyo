package DWMCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Edge {
    int src;     // source vertex
    int nbr;     // neighbour
    int wt;      // weight

    public Edge(int src, int nbr, int wt) {
        this.nbr = nbr;
        this.src = src;
        this.wt = wt;
    }

    public Edge(int src, int nbr) {
        this.nbr = nbr;
        this.src = src;
    }

    public Edge() {
    }

}


public class pageRankAlgo {

    public static void pageRankAlgo(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num of Vertex: ");
        int n = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0;i<graph.length;i++) graph[i] = new ArrayList<>();
        int[] outGoingNodes = new int[n];

        for (int i = 0;i<graph.length;i++){
            System.out.print("Enter number of outgoing edges at vertex"+i+":  ");
            int x = sc.nextInt();
            outGoingNodes[i] = x;
            System.out.print("Enter number of edges(incoming) at " + i + "th Vertex:  ");
            int nbrs = sc.nextInt();
            for (int j = 0; j < nbrs; j++) {
                System.out.print("nbr(incoming): ");
                int nbr = sc.nextInt();
                graph[i].add(new Edge(i, nbr));
                System.out.println();
            }

        }

        double[] pageRank = new double[n];
        Arrays.fill(pageRank,1/(double)n);

        /** will take the number of outgoing nodes as input and will create a directed graph by considering incoming
            nodes **/

        int i = 1;
        while (i<n){
            double[] tempRank = new double[n];
            for (int j = 0;j<graph.length;j++){
                ArrayList<Edge> curEdge = graph[j];
                double sum = 0;
                for (Edge e: curEdge){
                    sum +=  ( pageRank[e.nbr] / outGoingNodes[e.nbr] );
                }
                tempRank[j] = sum;
            }
            for (int j = 0;j<graph.length;j++)
                pageRank[j] = tempRank[j];

            System.out.println();
            System.out.println("Ranks of Page: ");
            for (int k = 0;k<pageRank.length;k++){
                System.out.println("Node"+k+": "+pageRank[k]);
            }
            System.out.println();

            i++;
        }

      //  Arrays.sort(pageRank);

        System.out.println("Ranks of Page: ");
        for (i = 0;i<pageRank.length;i++){
            System.out.println("Node"+i+": "+pageRank[i]);
        }

    }

    public static void main(String[] args) {

        pageRankAlgo();


    }

}
