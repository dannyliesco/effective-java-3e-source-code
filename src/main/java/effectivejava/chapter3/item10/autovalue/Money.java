package effectivejava.chapter3.item10.autovalue;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Money {
    public abstract String getCurrency();
    public abstract int getAmount();

    static Money create(String currency,int amount){
        return new AutoValue_Money(currency,amount);
    }
}
