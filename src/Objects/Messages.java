package Objects;
//TODO сделать выгрузку сообщений из стека в документ по желанию пользователя
//TODO сделать загрузку сообщений из файла в стек
//TODO реализовать систему Вам пришло новое сообщение, то есть оно записывается в стек и выводится на экран
//TODO вывод сообщений из стека когда этого захочет пользователь
//TODO сделать создание файла для пользователя при регистрации
//TODO сделать регистрацию
//TODO определять читаемый файл в конструкторе класса
//TODO сделать рандомное создание сообщений (приготовить данные, сгенерировать их)
//TODO создать список пользователей чтобы можно было их рандомно выбирать при генерации сообщений
//TODO при авторизации записывать это все в два файла (имя юзера в users.txt, а пароль юзера + юзера в users.properties)

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Messages {
    private String username, pass;
    private FileInputStream fis;
    private Properties properties;
    private String userpath;
    private int count = countOfStrInFiles();
    public Messages(String username, String pass) {
        this.username = username;
        this.pass = pass;
        if(!checkAuthorithationData()){
            System.out.print("\nВы ввели неверные данные. Перезапустите программу и попробуйте снова.");
            System.exit(0);
        }
        userpath = "secretfiles/" + username + "data.txt";

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
    private boolean checkAuthorithationData() {
        try {

            fis = new FileInputStream("secretfiles/users.properties");
            properties = new Properties();
            properties.load(fis);
            if(pass.equals(properties.get(username)))
                return true;
            else return false;
        }catch(FileNotFoundException e){
            System.out.print("\nФайла не существует.");
            System.exit(0);
        }catch(IOException e){
            System.out.print("Непредвиденная оошибка.(не понятно зачем она лол)");
            System.exit(0);
        }
        return true;
    }

    public void writerFromFile() {
        try {
            File file = new File(userpath);
            Scanner scan= new Scanner(file);
            while (scan.hasNextLine()){
                System.out.print(scan.nextLine());
                System.out.println();
            }
        }catch(FileNotFoundException e){
            System.out.print("Данные этого пользователя кудато пропали. Обратитесь к дебилу которыый это писал");
        }
    }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//ВСЕ ЧТО НУЖНО ДЛЯ ГЕНЕРАЦИИ СООБЩЕНИЙ И ЗАПИСИ ИХ В ФАЙЛ
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void generateRandomMessagess(){
        try{

            Path path = Paths.get("secretfiles/" + username + "data.txt");
            Charset charset = StandardCharsets.UTF_8;
            String content = getDate() + getRandomUser();
            for (int i = 1;i<10;i++){
                TimeUnit.SECONDS.sleep(1);
                content += "\n" + getDate() + getRandomUser();
            }
            Files.write(path, content.getBytes(charset));

        }catch(IOException e){
            System.out.print("\nЧтото пошло не так. Код ошибки 5");
            System.exit(5);
        }catch (InterruptedException e){
            System.exit(1488);
        }
    }

    private String getDate(){
        return new Date().toString();
    }

    private String getRandomUser(){
        try {
            Random random = new Random();
            String content = Files.readAllLines(Paths.get("secretfiles/users.properties")).get(random.nextInt(count + 1));
            return content;
        }catch (IOException e){
            System.out.print("\ngetRandomUser");
        }
        return "null";
    }

    private int countOfStrInFiles(){
        try {
            File file = new File("secretfiles/users.properties");
            Scanner scan = new Scanner(file);
            int count = 0;
            while(scan.hasNextInt()){
                ++count;
            }
            return count;

        }catch (FileNotFoundException e){
            System.out.print("\ncountOfStrInFiles");
        }
        return 0;
    }
}