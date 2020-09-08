package effectivejava.chapter2.item2.hierarchicalbuilder;

// Subclass with hierarchical builder (Page 15)
public class Calzone extends Pizza {
    private final boolean sauceInside;

    public static class CalZoneBuilder extends Pizza.Builder<CalZoneBuilder> {
        private boolean sauceInside = false; // Default

        public CalZoneBuilder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override public Calzone build() {
            return new Calzone(this);
        }

        @Override protected CalZoneBuilder self() { return this; }
    }

    private Calzone(CalZoneBuilder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    @Override public String toString() {
        return String.format("Calzone with %s and sauce on the %s",
                toppings, sauceInside ? "inside" : "outside");
    }
}
