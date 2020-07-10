package effectivejava.chapter2.item3.Mytest;

import effectivejava.chapter2.item3.staticfactory.Elvis;

import java.io.Serializable;

public class ElvisStealer implements Serializable {
    static Elvis impersonator;
    private Elvis payload;

    private Object readResolve() {
        // Save a reference to the "unresolved" Elvis instance
        impersonator = payload;
        // Return object of correct type for favoriteSongs field
        return new String[] { "A Fool Such as I" };
    }

    private static final long serialVersionUID = 0;
}
