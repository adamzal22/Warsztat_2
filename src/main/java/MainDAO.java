import java.sql.*;
import java.util.Scanner;

public class MainDAO {

    public static void main(String[] args) {
        User user1 = new User("adamso21@gmail.com", "adamsow", "kwoka123");
        /*System.out.println(user1.getUSER());*/
        /*userDAO.create(user1);*/
        /*Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();
        userDAO.read(id);*/

        System.out.println("Good day!");
        System.out.println("Welcome to the User Manager.");
        menu();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String text = scanner.nextLine();
            switch (text) {
                case "exit":
                    System.out.println("Good bye!");
                    System.exit(0);
                    break;
                case "create":
                    System.out.println("Podaj dane usera");
                    System.out.println("email");
                    String text1 = scanner.nextLine();
                    System.out.println("username");
                    String text2 = scanner.nextLine();
                    System.out.println("password");
                    String text3 = scanner.nextLine();
                    User userX = new User(text1, text2, text3);
                    userDAO.create(userX);
                    break;
                case "read":
                    int id_num = scanner.nextInt();
                    userDAO.read(id_num);
                    break;
                case "update":
                    System.out.println("Podaj ID do zmiany");
                    int id_num2 = scanner.nextInt();
                    userDAO.read(id_num2);
                    System.out.println("Podaj dane do zmiany");
                    System.out.println("email");
                    String text11 = scanner.nextLine();
                    System.out.println("username");
                    String text22 = scanner.nextLine();
                    System.out.println("password");
                    String text33 = scanner.nextLine();
                    User userU = new User(text11, text22, text33);
                    break;
                case "show all":
                    System.out.println("List of users: ");
                    User[] all = userDAO.findAll();
                    for (User u : all) {
                        System.out.println(u);
                    }
                    break;
                case "delete":
                    System.out.println("Podaj Id do usunięcia");
                    int user_id3 = scanner.nextInt();
                    userDAO.delete(user_id3);
                    break;
                default:
                    System.out.println("Please select a correct option.");
            }


            System.out.println("Czy chcesz wykonać kolejną operację? Y/N");

                char text31 = 'D';
                while (text31 != 'E'){
                    String text2 = scanner.nextLine().toUpperCase();
                switch (text2) {
                    case "Y":
                        text31 = 'E';
                        menu();
                        break;
                    case "N":
                        System.out.println("Good bye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please select a correct option.");
                        break;
                }

            }

        }
    }

    //MENU//
    public static void menu() {
        System.out.println("Please select an option:");
        System.out.println("create");
        System.out.println("read");
        System.out.println("update");
        System.out.println("show all");
        System.out.println("delete");
        System.out.println("exit");

    }


    }


