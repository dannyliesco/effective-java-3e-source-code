package effectivejava.chapter2.item5.injector;

public class SMSServiceImp implements MessageService{
    @Override
    public void sendMessage(String msg, String rec) {
        System.out.println("Send SMS to " + rec + "with message" + msg);
    }

    @Override
    public void addMethod() {
        System.out.println("SMS add method");
    }
}
