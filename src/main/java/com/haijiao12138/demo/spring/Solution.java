package com.haijiao12138.demo.spring;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: haijiao12138
 * @ClassName: Solution
 * @description: TODO
 * @date: 2021/8/16 14:44
 */
class Solution {
    public static void main(String[] args) {
        int[][] a = {{0,0,0}, {0,1,0}, {0,0,0}};
      /*  int[][] a = new int[3][3];
        a[0][0] = 0;
        a[0][1] = 0;
        a[0][2] = 0;
        a[1][0] = 0;
        a[1][1] = 1;
        a[1][2] = 0;
        a[2][0] = 0;
        a[2][1] = 0;
        a[2][2] = 0;*/
        List<List<Integer>> lists = pathWithObstacles(a);
        System.out.println(lists);

    }
    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        LinkedList<List<Integer>> list = new LinkedList<>();

        dfs(obstacleGrid, list, 0, 0);
        return list;
    }
    public static boolean dfs(int[][] obstacleGrid, LinkedList<List<Integer>> list, int x, int y){
        if(x < 0 || x >= obstacleGrid.length ||
                y < 0 || y >= obstacleGrid[0].length ||
                obstacleGrid[x][y] != 0){
            return false;
        }
        obstacleGrid[x][y] = 1;                //设置为访问过
        list.add(Arrays.asList(x,y));          //添加这个点
        if(x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1){
            return true;           //到终点了
        }
        if(dfs(obstacleGrid, list, x+1, y)){   //是否这条路径可以到终点
            return true;
        }
        if(dfs(obstacleGrid, list, x, y+1)){   //是否这条路径可以到终点
            return true;
        }
        list.removeLast();                    //从这个点出发无法到达终点，移除这个点
        return false;
    }
}
