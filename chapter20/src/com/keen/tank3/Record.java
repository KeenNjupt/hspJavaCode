package com.keen.tank3;

import java.io.*;
import java.util.Vector;

public class Record {
    private static int destroyEnemyTankNum = 0;
    private static BufferedWriter bufferedWriter = null;
    private static String recordFilePath = "src\\recordDestroyEnemyNumAndEnemyVector.txt";

    public static void writeNumToFile(){
        Vector<EnemyTank> enemyTank = SysGlobalUtil.getEnemyTank();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(recordFilePath));
            Vector<TankBaseInfo> tankBaseInfos = new Vector<>();
            for(EnemyTank i : enemyTank){
                TankBaseInfo tankBaseInfo = new TankBaseInfo(i.getX(), i.getY(), i.direction);
                tankBaseInfos.add(tankBaseInfo);
            }
            RecordContent recordContent = new RecordContent(destroyEnemyTankNum, tankBaseInfos);
            objectOutputStream.writeObject(recordContent);
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public static Boolean recordFileIsExist(){
        File file = new File(recordFilePath);
        return file.exists();
    }
    public static RecordContent getEnemyTankInfoFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(recordFilePath));
        Object o = objectInputStream.readObject();
        RecordContent res = (RecordContent) o;
        if(objectInputStream != null){
            objectInputStream.close();
        }
        destroyEnemyTankNum = res.getDestroyEnemyTankNum();
        return res;
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

class RecordContent implements Serializable{
    private int destroyEnemyTankNum = 0;
    private Vector<TankBaseInfo> tankBaseInfoVector = null;
    //serialVersionUID 序列化版本号，提升兼容性
    static private final long serialVersionUID = 1L;

    public RecordContent(int destroyEnemyTankNum, Vector<TankBaseInfo> tankBaseInfoVector) {
        this.destroyEnemyTankNum = destroyEnemyTankNum;
        this.tankBaseInfoVector = tankBaseInfoVector;
    }

    public int getDestroyEnemyTankNum() {
        return destroyEnemyTankNum;
    }

    public void setDestroyEnemyTankNum(int destroyEnemyTankNum) {
        this.destroyEnemyTankNum = destroyEnemyTankNum;
    }

    public Vector<TankBaseInfo> getTankBaseInfoVector() {
        return tankBaseInfoVector;
    }

    public void setTankBaseInfoVector(Vector<TankBaseInfo> tankBaseInfoVector) {
        this.tankBaseInfoVector = tankBaseInfoVector;
    }
}

class TankBaseInfo implements Serializable{
    private int x;
    private int y;
    private int direction;
    //serialVersionUID 序列化版本号，提升兼容性
    static private final long serialVersionUID = 1L;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public TankBaseInfo(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}
