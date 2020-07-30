package effectivejava.chapter3.item10.inheritance;

import effectivejava.chapter3.item10.Color;
import effectivejava.chapter3.item10.Point;
import effectivejava.chapter3.item10.Smell;

public class SmellPoint extends Point {
    private final Smell smell;

    public SmellPoint(int x, int y,Smell smell) {
        super(x, y);
        this.smell = smell;
    }

    // Broken - violates transitivity! (page 42)
    @Override public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;

        // If o is a normal Point, do a color-blind comparison
        if (!(o instanceof SmellPoint))
            return o.equals(this);

        // o is a SmellPoint; do a full comparison
        return super.equals(o) && ((SmellPoint) o).smell == smell;
    }

    public static void main(String[] args) {
        SmellPoint smellPoint = new SmellPoint(1,1,Smell.BITTER);
        ColorPoint colorPoint = new ColorPoint(1,1,Color.BLUE);
        System.out.println("result is "+smellPoint.equals(colorPoint));
        //this approach can cause infinite recursion @by Hogen.

    }
}
