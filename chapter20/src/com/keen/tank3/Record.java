package com.keen.tank3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Vector;

public class Record {
    private static int destroyEnemyTankNum = 0;
    private static BufferedWriter bufferedWriter = null;
    private static String recordFilePath = "E:\\record_destroy_enemy_num.txt";

    public static void writeNumToFile(){
        Vector<EnemyTank> enemyTank = SysGlobalUtil.getEnemyTank();
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(recordFilePath));
            bufferedWriter.write("摧毁敌人坦克数量:" + destroyEnemyTankNum);
            bufferedWriter.newLine();
            for(EnemyTank i : enemyTank){
                bufferedWriter.write(String.format("敌人坦克位置 x, y, direction: %d %d %d", i.getX(), i.getY(), i.direction));
                bufferedWriter.newLine();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public static void addDestroyEnemyTankNum(){
        destroyEnemyTankNum++;
    }
    public static int getDestroyEnemyTankNum() {
        return destroyEnemyTankNum;
    }

    public static void setDestroyEnemyTankNum(int destroyEnemyTankNum) {
        Record.destroyEnemyTankNum = destroyEnemyTankNum;
    }
}
