package Objects;
//TODO сделать выгрузку сообщений из стека в документ по желанию пользователя
//TODO сделать загрузку сообщений из файла в стек
//TODO реализовать систему Вам пришло новое сообщение, то есть оно записывается в стек и выводится на экран
//TODO вывод сообщений из стека когда этого захочет пользователь
//TODO сделать создание файла для пользователя при регистрации
//TODO сделать регистрацию


import java.util.Stack;

public class Messages {
    private String username, pass;

    Messages(String username, String pass) {
        this.username = username;
        this.pass = pass;
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

}