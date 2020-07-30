package effectivejava.chapter2.item5.injector;

public class MyMessageDITest {
    public static void main(String[] args) {
        String msg = "Hi Pankaj";
        String email = "pankaj@gmail.com";
        String phone = "400888888";
        MessageServiceInjector injector = null;
        Consumer app = null;

        //Send email
        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessage(msg,email);
        app.addedMethod();

        MyDIApplication myApp1 = new MyDIApplication(new EmailServiceImp());
        myApp1.processMessage(msg,email);

        //Send sms
        injector = new SMSServiceInjector();
        app = injector.getConsumer();
        app.processMessage(msg,email);
        app.addedMethod();
    }
}
