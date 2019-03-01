import Objects.Messages;
import Objects.Registration;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Добро пожаловать.\n1.Ввойти в систему\n2.Зарегистрироваться в системе\nВведите число:");
        Scanner scanner = new Scanner(System.in);
        int action = input1_2();
        switch(action){
            case 1: signIn();
            break;
            case 2: registration();
            break;
        }


    }

    public static int input1_2() {
        Scanner scanner;
        int action = 1;
        do {
            scanner = new Scanner(System.in);
            action = scanner.nextInt();
            if (action != 1 && action != 2)
                System.out.print("\nВы ввели данные неверно. Повторите ввод:");
        } while (action != 1 && action != 2);
        return action;
    }

    public static void registration() {
        Registration registration = new Registration();
    }

    public static void signIn() {
        System.out.print("\nВведите имя пользователя: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        System.out.print("\nВведите пароль: ");
        String pass = scanner.next();
        Messages messages = new Messages(username, pass, true);
        actionSignIn(messages);
    }

    public static void actionSignIn(Messages messages) {
        System.out.print("\n1.Посмотреть сообщения\n2.Новое сообщение\n3.Сохранить их в файл\n4.Закрыть программу");
        System.out.print("\nВведите действие: ");
        Scanner scanner = new Scanner(System.in);
        int action = 0;
        try {
             action = scanner.nextInt();
        }catch(InputMismatchException e){
            System.out.print("\nОшибка ввода. Попробуйте снова.");
            actionSignIn(messages);
        }

        switch(action){
            case 1:
                messages.whatInStack();
                actionSignIn(messages);
                break;
            case 2:
                messages.newMessage();
                actionSignIn(messages);
                break;
            case 3:
                messages.saveToFile();
                actionSignIn(messages);
                break;
            case 4:
                System.exit(123);
                default:
                    System.out.print("Вы ввели неверные данные. Начните заново.");
                    actionSignIn(messages);
        }

    }
}
