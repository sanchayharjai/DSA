package Algorithms;

import java.io.PrintWriter;

public class QuickSelectDriver {

    /* Quickselect is a selection algorithm to find the kth smallest
      element in an unordered list. It is related to the quicksort sorting
      algorithm. Like quicksort, it was developed by Tony Hoare, and thus
      is also known as Hoare's selection algorithm.

      Worst-case performance	  О(n2)
      Best-case performance	  Omega (n)
      Average performance	  theta (n)

     */
    public static void main(String[] args) {
        PrintWriter pr = new PrintWriter(System.out);
        pr.println(new QuickSelect().select(new int[]{3,2,3,1,2,4,5,5,6},4));
        pr.flush();
    }
}
