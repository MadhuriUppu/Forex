package com.mapping;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
	static boolean[][] dp;
    static List<Order> buyList=null;
    static void display(List<Order> v)
    {
       System.out.println(v);
       buyList.addAll(v);
    }
    static void printSubsetsRec(List<Order> arr, int i, int sum, 
                                         List<Order> p)
    {
        if (i == 0 && sum != 0 && dp[0][sum])
        {
            p.add(arr.get(i));
            display(p);
            p.clear();
            return;
        }
        if (i == 0 && sum == 0)
        {
            display(p);
            p.clear();
            return;
        }
        if (dp[i-1][sum])
        {
           
            List<Order> b = null;
            b.addAll(p);
            printSubsetsRec(arr, i-1, sum, b);
        }
      
        if (sum >= arr.get(i).volume && dp[i-1][sum-arr.get(i).volume])
        {
            p.add(arr.get(i));
            printSubsetsRec(arr, i-1, sum-arr.get(i).volume, p);
        }
    }
  
    static List<Order> printAllSubsets(List<Order> arr, int n, int sum)
    {
        if (n == 0 || sum < 0)
           return buyList;
      
        dp = new boolean[n][sum + 1];
        for (int i=0; i<n; ++i)
        {
            dp[i][0] = true;  
        }
      
        if ((arr.get(0).volume) <= sum)
           dp[0][arr.get(0).volume] = true;

        for (int i = 1; i < n; ++i)
            for (int j = 0; j < sum + 1; ++j)
                dp[i][j] = (arr.get(i).volume <= j) ? (dp[i-1][j] ||
                                           dp[i-1][j-arr.get(i).volume])
                                         : dp[i - 1][j];
        if (dp[n-1][sum] == false)
        {
            System.out.println("There are no subsets with" + 
                                                  " sum "+ sum);
            return buyList;
        }
        List<Order> p = null;
        printSubsetsRec(arr, n-1, sum, p);
        return buyList;
    }
}
