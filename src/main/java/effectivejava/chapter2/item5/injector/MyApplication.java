package effectivejava.chapter2.item5.injector;

public class MyApplication {
    private EmailService email = new EmailService();
    public void processMessages(String msg ,String rec){
        this.email.sendEmail(msg,rec);
    }
}
