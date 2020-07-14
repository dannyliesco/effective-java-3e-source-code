package effectivejava.chapter2.item3.Mytest;

import effectivejava.chapter2.item3.staticfactory.Elvis;

import java.io.*;

public class SerialSingleTen {
    private static Elvis elvis;

    public static void main(String[] args) {
        // Initializes ElvisStealer.impersonator and returns
        // the real Elvis (which is Elvis.INSTANCE)
        serialized();
        elvis = deserialized();
        Elvis impersonator = ElvisStealer.impersonator;
        elvis.printFavorites();
        impersonator.printFavorites();
    }

    public static Elvis deserialized(){
        try
        {
            FileInputStream fis = new FileInputStream("serialize.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            elvis = (Elvis) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("反序列化结束");
            return elvis;
        }
        catch (ClassNotFoundException | IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void serialized(){
        try{
            FileOutputStream fos = new FileOutputStream("serialize.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Elvis.INSTANCE);
            System.out.println("序列化成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
