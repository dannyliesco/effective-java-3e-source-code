package effectivejava.chapter2.item5.injector;

public class EmailServiceImp implements MessageService{
    @Override
    public void sendMessage(String msg, String rec) {
        System.out.println("Email send to " + rec + "with message"+msg);
    }

    @Override
    public void addMethod() {
        System.out.println("Email add method");
    }
}
