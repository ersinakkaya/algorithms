package FindEquals;

import java.util.Arrays;

public class FindEquals {

    public static int count(int[] a) {
        int N = a.length;
        Arrays.sort(a);
        int cnt = 0;
        for (int i = 0; i < N-1; i++) {
        	if(a[i] == a[i+1]){
        		cnt++;
        	}
        }
        return cnt;
    } 

    public static void main(String[] args)  { 
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        int N = a.length;
        int cnt = count(a);
        StdOut.println("Number of equal item:" + cnt);
    }
} 
