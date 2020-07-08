package effectivejava.chapter2.item1.reflect;
/**
 * 使用范型来实现服务者框架
 */

/**
 * 进出地铁服务接口
 * @author hogen
 *
 */
interface SubWayInterface {
    //进入地铁
    public boolean in();
    //出地铁
    public boolean out();
}

/**
 * 地铁进出服务提供者接口
 * @author Administrator
 *
 */
interface SubwayProviderInterface {
    public SubWayInterface getService();
}




public class MySubwayRelect {

    /**
     * 服务提供者实现类
     * @author Administrator
     *
     */
    class SubwayProviderImpl implements SubwayProviderInterface {

        static {
            ServiceManager.registerProvider("一卡通", new SubwayProviderImpl());
        }

        public SubWayInterface getService() {
            return new SubWayImpl();
        }

    }


    /**
     * 服务提供者注册类
     *
     * @author Administrator
     *
     */
    public class ServiceManager {

        private ServiceManager() {

        }

        private static final Map<String, SubwayProviderInterface> providers = new ConcurrentHashMap<String, SubwayProviderInterface>();

        public static void registerProvider(String name, SubwayProviderInterface p) {
            providers.put(name, p);
        }

        public static SubWayInterface getService(String name) {

            SubwayProviderInterface p = providers.get(name);

            if (p == null) {
                throw new IllegalArgumentException(
                        "No provider registered with name:" + name);
            }

            return p.getService();

        }

    }


    /**
     * 一卡通地铁进出服务实现
     * @author Administrator
     *
     */
     class SubWayImpl implements SubWayInterface {

        @Override
        public boolean in() {
            System.out.println("通过一卡通进入地铁");
            /**
             * 进行一些处理，然后返回是否放行
             */
            return false;
        }

        @Override
        public boolean out() {
            System.out.println("通过一卡通出地铁");
            /**
             * 进行一些处理，然后返回是否放行
             */
            return false;
        }
    }

}
