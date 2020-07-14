package effectivejava.chapter2.item5.injector;

public class SMSServiceInjector implements MessageServiceInjector{
    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new SMSServiceImp());
    }
}
