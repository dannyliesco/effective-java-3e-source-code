package effectivejava.chapter3.item10.autovalue;

import com.google.auto.value.AutoValue;
import effectivejava.chapter3.item10.autovalue.AutoValue_Money;
@AutoValue
public abstract class Money {
    public abstract String getCurrency();
    public abstract int getAmount();

    static Money create (String currency,int amount){
        return new AutoValue_Money(currency,amount);
    }

    public static void main(String[] args) {
        Money money1 = Money.create("USD",2000);
        Money money2 = Money.create("USD",2000);
        System.out.println("money1 equals money2 result: " + money1.equals(money2));
        System.out.println("money1 equals money2 result: " + money1.equals(money2));
    }
}
