package effectivejava.chapter2.item5.injector;

/*
* https://www.journaldev.com/2394/java-dependency-injection-design-pattern-example-tutorial
* */
public class EmailService {
    public void sendEmail(String message,String receiver){
        System.out.println("Email send to " + receiver + " with message " + message);
    }
}
