package com.keen;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessBoard {
    /**
     * 马踏棋盘，马从一个位置出发，走日字形，有八个方向可以去，并且不能走已经走过的地方，输出一种可以走完
     * 全部棋盘的方法
     *
     * 可以用回溯方法，chessBoard记录第几步，visited记录是否访问过
     * 编写递归函数，进入递归则将当前位置的步数记录，将visited置为true，并遍历八个可走的步数是否可走
     * 若可走则继续递归调用，遍历完成后，判断当前步数是否为最后一步，若是则直接退出，
     * 若不是则回溯 chessBoard设置为0，visited设置为false
     */
    //定义属性
    //棋盘行数
    private static int row = 6;
    //棋盘列数
    private static int col = 6;
    //棋盘数组，chessBoard[x][y] 表示 马走到棋盘x行y列时是第几步
    private static int[][] chessBoard = new int[row][col];
    //visited[x][y] 表示棋盘x行y列是否被访问过
    private static boolean[][] visited = new boolean[row][col];
    //记录是否遍历完成所有位置
    private static boolean finish = false;
    public static void main(String[] args) {
        int initX = 1;
        int initY = 1;
        long start = System.currentTimeMillis();
//        go(initX, initY, 1);
        goGreedy(initX, initY, 1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

//        if(finish){

            for(int[] rows : chessBoard){
                for(int colData : rows){
                    System.out.print(colData + "\t");
                }
                System.out.println("\n");
            }
//        }
    }

    public static void go(int x, int y, int step){
        if(x < 0 || x > row-1 || y < 0 || y > col-1){
            return;
        }
        if(visited[x][y] || finish){
            return;
        }
        chessBoard[x][y] = step;
        visited[x][y] = true;
        if(step == row*col){
            finish = true;
            return;
        }
        //8个方向 (x-1,y-2) (x-1,y+2) (x-2,y-1) (x-2,y+1)
        //(x+1,y-2) (x+1,y+2) (x+2,y-1) (x+2,y+1)
        go(x-1, y-2, step+1);
        go(x-1, y+2, step+1);
        go(x-2, y-1, step+1);
        go(x-2, y+1, step+1);
        go(x+1, y-2, step+1);
        go(x+1, y+2, step+1);
        go(x+2, y-1, step+1);
        go(x+2, y+1, step+1);
        //一条路径返回时，若未完成则回溯
        if(!finish) {
            visited[x][y] = false;
            chessBoard[x][y] = 0;
        }
    }

    public static boolean legal(Point p){
        int x = p.x;
        int y = p.y;
        if(x < 0 || x > row-1 || y < 0 || y > col-1){
            return false;
        }
        else{
            return true;
        }
    }
    public static ArrayList<Point> next(Point p1){
        int x = p1.x;
        int y = p1.y;
        //8个方向 (x-1,y-2) (x-1,y+2) (x-2,y-1) (x-2,y+1)
        //(x+1,y-2) (x+1,y+2) (x+2,y-1) (x+2,y+1)
        ArrayList<Point> points = new ArrayList<>();
        Point p = new Point(x - 1, y - 2);
        if(legal(p)){
            points.add(p);
        }
        p = new Point(x - 1, y + 2);
        if(legal(p)){
            points.add(p);
        }
        p = new Point(x - 2, y - 1);
        if(legal(p)){
            points.add(p);
        }
        p = new Point(x - 2, y + 1);
        if(legal(p)){
            points.add(p);
        }
        p = new Point(x + 1, y - 2);
        if(legal(p)){
            points.add(p);
        }
        p = new Point(x + 1, y + 2);
        if(legal(p)){
            points.add(p);
        }
        p = new Point(x + 2, y - 1);
        if(legal(p)){
            points.add(p);
        }
        p = new Point(x + 2, y + 1);
        if(legal(p)){
            points.add(p);
        }
        return points;
    }
    public static void sort(ArrayList<Point> points){
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();
            }
        });
    }
    //每次从候选位置中再下一位置最少的位置开始遍历
    public static void goGreedy(int x, int y, int step){
        if(x < 0 || x > row-1 || y < 0 || y > col-1){
            return;
        }
        if(visited[x][y] || finish){
            return;
        }
        chessBoard[x][y] = step;
        visited[x][y] = true;
        if(step == row*col){
            finish = true;
            return;
        }
        ArrayList<Point> nexts = next(new Point(x, y));
        sort(nexts);
        for(Point p : nexts){
            go(p.x, p.y, step+1);
        }

        //一条路径返回时，若未完成则回溯
        if(!finish) {
            visited[x][y] = false;
            chessBoard[x][y] = 0;
        }
    }
}
