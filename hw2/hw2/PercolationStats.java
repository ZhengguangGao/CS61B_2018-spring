package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {

    private int number;

    private double[] X;

    public PercolationStats(int N, int T, PercolationFactory pf) {

        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }

        number = T;
        X = new double[T];
        int total_size=N*N;

        for (int i=0;i<T;i++) {
            int num_trail = 0;
            Percolation p = pf.make(N);
            while (!p.percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                if(p.isOpen(row,col)) {

                    p.open(row,col);

                    num_trail++;

                }

            }

            X[i] = (double) num_trail/total_size;
        }

    }

    public double mean() {

        return StdStats.mean(X);

    }

    public double stddev() {

        return StdStats.stddev(X);

    }

    public double confidenceLow() {
        double mu = mean();
        double std = stddev();
        return mu-1.96*std/Math.sqrt(number);

    }

    public double confidenceHigh() {

        double mu = mean();
        double std = stddev();
        return mu+1.96*std/Math.sqrt(number);

    }

}
