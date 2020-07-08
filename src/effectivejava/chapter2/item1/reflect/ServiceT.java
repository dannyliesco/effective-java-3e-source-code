package effectivejava.chapter2.item1.reflect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceT <T> {
    private ServiceT() {

    }

    public <T> void registerProvider(String name, T t) {
        t.toString();
    }

    public SubWayInterface getService(String name) {

        SubwayProviderInterface p = providers.get(name);

        if (p == null) {
            throw new IllegalArgumentException(
                    "No provider registered with name:" + name);
        }

        return p.getService();

    }

}
