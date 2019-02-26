package Objects;

import java.util.Scanner;

//TODO при авторизации записывать это все в два файла (имя юзера в users.txt, а пароль юзера + юзера в users.properties)
//TODO сделать создание файла для пользователя при регистрации

//ОТДЕЛЬНЫЙ ПЛАН ДЕЙСТВИЙ
/*
Пользователь вводит данные.
Теперь мы должны проверить эти данные. Так как если они уже присутсвуют, то нужно об этом предупредить и начать вводить данные заново TODO вынести в оотдельный метод ввод данных
Если таких данных не было обнаружено, то мы для начала записывваем данные в файл, а только потом создаем файл пользователя и генерируем в него сообщения

ПРОБЛЕМЫ КОТОРЫЕ МЕНЯ БЕСПОКОЯТ
так как мы используем для хранения паролей файл properties, то тут возникает очень не приятная вещь как кодировка. при ввводе русских символов вв properties, мы получаем просто набор непонятных символов.
Решение этой проблемы методом фикса кодировки не катит, так как это того не стОит.
А вот например заставить пользователя вводить только латинские символы стОит

 */
public class Registration {

    private String username, password;
    public Registration(){
        Scanner  scanner = new Scanner(System.in);

        username = scanner.next();
        password = scanner.next();
        writeDataToFiles();
        createUserFile();

    }

    private void createUserFile(){
        Messages messages = new Messages(username,password);
    }

    private void writeDataToFiles(){

    }


}
