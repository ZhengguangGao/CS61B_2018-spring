package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] grid;
    private WeightedQuickUnionUF set_all;
    private WeightedQuickUnionUF set_all_except_bottom;
    private int size;
    private int top;
    private int bottow;
    private int count;
    private int[][] strides = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};




    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        top=0;
        bottow=N*N+1;
        count=0;
        grid=new boolean[N][N];
        size=N;
        set_all = new WeightedQuickUnionUF(N*N+2);
        set_all_except_bottom = new WeightedQuickUnionUF(N*N+1);

    }

    // open the site (row, col) if it is not open already?
    public void open(int row, int col) {

        initial_valid(row, col);

        if (!isOpen(row, col)) {
            grid[row][col] = true;
            count += 1;
        }

        if (row == 0) {

            set_all.union(xyTo1D(row,col),top);
            set_all_except_bottom.union(xyTo1D(row, col),top);
        }

        if (row == size-1) {

            set_all.union(xyTo1D(row,col),bottow);

        }

        for (int[] stride: strides) {

            int surround_row=stride[0]+row;
            int surround_col=stride[1]+col;
            if (surround_row>=0&&surround_row<size&&surround_col>=0&&surround_col<size) {

                if (isOpen(surround_row,surround_col)){

                    set_all.union(xyTo1D(row, col),xyTo1D(surround_row,surround_col));

                    set_all_except_bottom.union(xyTo1D(row, col),xyTo1D(surround_row,surround_col));

                }

            }

        }

    }



    // is the site (row, col) open?
    public boolean isOpen ( int row, int col) {

        initial_valid(row, col);

        if (grid[row][col]==true) {
            return true;
        }
        return false;

    }





    // is the site (row, col) full?
    public boolean isFull ( int row, int col) {
        initial_valid(row, col);
        return set_all_except_bottom.connected(xyTo1D(row, col),top);
    }

    // number of open sites
    public int numberOfOpenSites () {

        return count;

    }

    // does the system percolate?
    public boolean percolates () {

        return set_all.connected(top,bottow);

    }

    // use for unit testing (not required)

    private void initial_valid(int x, int y) {

        if (x < 0 || x >= size || y < 0 || y >= size) {
            throw new IndexOutOfBoundsException();
        }
    }


    private int xyTo1D(int x,int y) {

        return x*size+y+1;
    }

    public static void main (String[]args) {

    }


}
