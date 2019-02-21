package Objects;
//TODO сделать выгрузку сообщений из стека в документ по желанию пользователя
//TODO сделать загрузку сообщений из файла в стек
//TODO реализовать систему Вам пришло новое сообщение, то есть оно записывается в стек и выводится на экран
//TODO вывод сообщений из стека когда этого захочет пользователь
//TODO сделать создание файла для пользователя при регистрации
//TODO сделать регистрацию
//TODO определять читаемый файл в конструкторе класса

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Stack;

public class Messages {
    private String username, pass;
    private FileInputStream fis;
    private Properties properties;
    Messages(String username, String pass) {
        this.username = username;
        this.pass = pass;
        if(!checkAuthorithationData(this.username, this.pass)){
            System.out.print("\nВы ввели неверные данные. Перезапустите программу и попробуйте снова.");
            System.exit(0);
        }

    }

    public void saveToFile(Stack stack){

    }

    public Stack addToStack(Stack stack){
        return stack;
    }

    public Stack newMessage(Stack stack){
        return stack;
    }

    public void whatInStack(Stack stack){

    }

    private boolean checkAuthorithationData(String username, String pass) {
        try {
            fis = new FileInputStream("secretfiles/users.txt");
            properties.load(fis);
            if(pass == properties.get(username))
                return true;
        }catch(FileNotFoundException e){
            System.out.print("\nФайла не существует.");
            System.exit(0);
        }catch(IOException e){
            System.out.print("Непредвиденная оошибка.(не понятно зачем она лол)");
            System.exit(0);
        }
        return false;
    }

    private void writerFromFile(String username, String pass) {
        try {
            fis = new FileInputStream("secretfiles/" + username + "data.txt");
        }catch(FileNotFoundException e){
            System.out.print("Данные этого пользователя кудато пропали. Обратитесь к дебилу которыый это писал");
        }
    }
}