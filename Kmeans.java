package DWMCodes;

import java.util.ArrayList;
import java.util.Scanner;

public class Kmeans {

    public static void Kmeans(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of elements: ");
        int n = sc.nextInt();
        int[] ar = new int[n];
        System.out.print("Enter elements: ");
        for (int i = 0;i<n;i++) ar[i] = sc.nextInt();
        /*System.out.print("Enter K: ");
        int k = sc.nextInt();*/

        int k = 2;
        int m1 = ar[n/k-1];
        int m2 = ar[n/k + 1];
        ArrayList<Integer> k1 = new ArrayList<>();
        ArrayList<Integer> k2 = new ArrayList<>();
        int s1 = 0 , s2 = 0;

        int pM1 = m1, pM2 = m2;

        System.out.println("m1 = "+m1+" , m2 = "+m2);

        do{
            pM1 = m1;
            pM2 = m2;
            k1 = new ArrayList<>();
            k2 =  new ArrayList<>();
            s1 = 0;
            s2 = 0;
            for (int ele: ar){
                int d1 = Math.abs(m1-ele);
                int d2 = Math.abs(m2-ele);
                if(d1<d2){
                    k1.add(ele);
                    s1 += ele;
                } else{
                    k2.add(ele);
                    s2 += ele;
                }
            }
            m1 = s1/k1.size();
            m2 = s2/k2.size();
            System.out.println(k1);
            System.out.println(k2);
            System.out.println();
            System.out.println("m1 = "+m1 + " , m2 = "+m2);
        } while (pM1!=m1 && pM2 != m2);

        //  2 4 10 12 3 20 30 11 25

    }

    public static void main(String[] args) {

        Kmeans();

    }

}
