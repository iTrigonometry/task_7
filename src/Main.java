import Objects.Messages;

public class Main {
    public static void main(String[] args){
        Messages mess = new Messages("admin", "qwerty");
        mess.generateRandomMessagess();
        mess.writerFromFile();
    }
}
