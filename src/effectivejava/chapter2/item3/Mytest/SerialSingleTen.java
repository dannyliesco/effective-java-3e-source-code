package effectivejava.chapter2.item3.Mytest;

import effectivejava.chapter2.item3.staticfactory.Elvis;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerialSingleTen {

    public static void main(String[] args) {
        // Initializes ElvisStealer.impersonator and returns
        // the real Elvis (which is Elvis.INSTANCE)
        Elvis elvis = (Elvis) deserialized(Elvis.INSTANCE);
        Elvis impersonator = ElvisStealer.impersonator;
        elvis.printFavorites();
        impersonator.printFavorites();
    }

    public static void deserialized(){
        try
        {
            FileInputStream fis = new FileInputStream("serialize.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Elvis elvis = (Elvis) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("反序列化结束");
        }
        catch (ClassNotFoundException | IOException e)
        {
            e.printStackTrace();
        }

    }



}
