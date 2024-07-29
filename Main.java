import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /* books define */
        Book book1  =new Book("Don Quixote");
        Book book2  =new Book("Wuthering Heights");
        Book book3  =new Book("The Great Gatsby");
        Book book4  =new Book("Moby-Dick");
        Book book5  =new Book("Pride and Prejudice");
        Book book6  =new Book("To Kill a Mockingbird");
        Book book7  =new Book("1984");
        Book book8  =new Book("Jane Eyre");
        Book book9  =new Book("One Hundred Years of Solitude");
        Book book10 =new Book("Adventures of Huckleberry Finn");
        Book book11 =new Book("Anna Karenina");
        Book book12 =new Book("Crime and Punishment");
        Book book13 =new Book("The Lord of the Rings");
        Book book14 =new Book("War and Peace");
        Book book15 =new Book("Frankenstein");
        Book book16 =new Book("Harry Potter");
        Book book17 =new Book("In Search of Lost Time");
        Book book18 =new Book("Ulysses");
        Book book19 =new Book("Beloved");
        Book book20 =new Book("Lolita");

        Person person = null;
        Scanner in = new Scanner(System.in);
        /* person define */
        HashMap<String ,String> user = new HashMap<>();
        File file =new File("names.txt");
        try{
            Scanner f_sc = new Scanner(file);
            while(f_sc.hasNext()){
                if(f_sc.next().equals("user_name")){
                    user.put(f_sc.next(),f_sc.next());
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        /* first print line */
        System.out.println("welcome to library");

        /* variable defination */
        boolean while_loop = true; //for contin in the loop
        /* input user */
        Scanner sc_var = new Scanner(System.in);
        int counter = 0; // check for password
        int user_check =0; // to stop program when 5 invalid data
        int regist_login_var =5 ;
        int exit_continue = 0;


        /* while loop for the start of program */


        while(while_loop){

            /* check file */
            if(!(file.exists())){
                System.out.println("error in the file sorry program will repair soon");
                break;
            }

            /* check for Register or login   */
            System.out.println("do you have an email or wanted to creat ?");
            System.out.print("to login enter (0) or to register a new user enter (1) : ");
            try {
                regist_login_var = sc_var.nextInt();

            }catch (Exception e) {
                System.out.println("data not valued default value is log in");
                regist_login_var =0 ;
            }

            if(regist_login_var == 0) {

                /* user enter name and password check with it */
                while (counter == 0) {
                    /* user name and password take */

                    System.out.print("username : ");
                    String name = in.nextLine();
                    System.out.print("password : ");
                    String password = in.nextLine();


                    /* check user name and password */
                    try {
                        Scanner f_sc = new Scanner(file);
                        while (f_sc.hasNext()) {
                            if (f_sc.next().equals("user_name")) {
                                if (f_sc.next().equals(name)) {
                                    counter++;
                                    if (f_sc.next().equals(password)) {
                                        System.out.println("welcome " + name);
                                        break;
                                    } else {
                                        System.out.println("user_name or pasword doesn't match");
                                        break;
                                    }
                                }

                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    if (counter == 0) {
                        System.out.println("user_name or pasword doesn't match");
                        System.out.println("please try again");
                        user_check++;
                        break;
                    }
//                if(user_check == 5){
//                    System.out.println("Invalid data has been duplicated, please try again in 5 minutes");
//                    break;
//                }
                    user_check = 0;

                    exit_continue =0;  // to enter loop
                    /* loop for borrow and return  */
                    while(exit_continue == 0) {
                        System.out.print("if you wanted to borrow enter 1 if you wanted to return enter 0 : ");
                        int x = sc_var.nextInt();
                        while ((x != 1) && (x != 0)) {
                            System.out.print("please enter 1 0r 0 only : ");
                            x = sc_var.nextInt();
                        }
                        if (x == 1) {
                            System.out.println("books available : ");
                            System.out.println("1- " + book1.getTitle());
                            System.out.println("2- " + book2.getTitle());
                            System.out.println("3- " + book3.getTitle());
                            System.out.println("4- " + book4.getTitle());
                            System.out.println("5- " + book5.getTitle());
                            System.out.println("6- " + book6.getTitle());
                            System.out.println("7- " + book7.getTitle());
                            System.out.println("8- " + book8.getTitle());
                            System.out.println("9- " + book9.getTitle());
                            System.out.println("10- " + book10.getTitle());
                            System.out.println("11- " + book11.getTitle());
                            System.out.println("12- " + book12.getTitle());
                            System.out.println("13- " + book13.getTitle());
                            System.out.println("14- " + book14.getTitle());
                            System.out.println("15- " + book15.getTitle());
                            System.out.println("16- " + book16.getTitle());
                            System.out.println("17- " + book17.getTitle());
                            System.out.println("18- " + book18.getTitle());
                            System.out.println("19- " + book19.getTitle());
                            System.out.println("20- " + book20.getTitle());
                            System.out.println("\n");
                            System.out.print("chose the book you wanted from 1 to 20 : ");
                            int y = sc_var.nextInt();
                            person = new Person(name);
                            while ((y < 1) || (y > 20)) {
                                System.out.print("please enter number from 1 to 20 : ");
                                Scanner in_sc = new Scanner(System.in);
                                y = in_sc.nextInt();
                            }
                            /* switch the book borrowed */
                            switch (y) {
                                case 1:
                                    if (book1.getCounter() == 0) {
                                        person.borrowItem(book1);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                    break;
                                case 2:
                                    if (book2.getCounter() == 0) {
                                        person.borrowItem(book2);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                    break;
                                case 3:
                                    if (book3.getCounter() == 0) {
                                        person.borrowItem(book3);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                        break;
                                    }
                                case 4:
                                    if (book4.getCounter() == 0) {
                                        person.borrowItem(book4);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                    break;
                                case 5:
                                    if (book5.getCounter() == 0) {
                                        person.borrowItem(book5);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                    break;
                                case 6:
                                    if (book6.getCounter() == 0) {
                                        person.borrowItem(book6);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                case 7:
                                    if (book7.getCounter() == 0) {
                                        person.borrowItem(book7);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                    break;
                                case 8:
                                    if (book8.getCounter() == 0) {
                                        person.borrowItem(book8);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                    break;
                                case 9:
                                    if (book9.getCounter() == 0) {
                                        person.borrowItem(book9);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                        break;
                                    }
                                case 10:
                                    if (book10.getCounter() == 0) {
                                        person.borrowItem(book10);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                    break;
                                case 11:
                                    if (book11.getCounter() == 0) {
                                        person.borrowItem(book11);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                    break;
                                case 12:
                                    if (book12.getCounter() == 0) {
                                        person.borrowItem(book12);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                case 13:
                                    if (book13.getCounter() == 0) {
                                        person.borrowItem(book13);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                    break;
                                case 14:
                                    if (book14.getCounter() == 0) {
                                        person.borrowItem(book14);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                    break;
                                case 15:
                                    if (book15.getCounter() == 0) {
                                        person.borrowItem(book15);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                        break;
                                    }
                                case 16:
                                    if (book16.getCounter() == 0) {
                                        person.borrowItem(book16);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                    break;
                                case 17:
                                    if (book17.getCounter() == 0) {
                                        person.borrowItem(book17);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                    break;
                                case 18:
                                    if (book18.getCounter() == 0) {
                                        person.borrowItem(book18);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                    break;
                                case 19:
                                    if (book19.getCounter() == 0) {
                                        person.borrowItem(book19);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                    break;
                                case 20:
                                    if (book20.getCounter() == 0) {
                                        person.borrowItem(book20);
                                    } else {
                                        System.out.println("sorry this book is already borrowed now");
                                    }
                                    break;
                                default:
                                    break;
                            }
                            /* switch the book returned */
                        } else if (x == 0) {
                            System.out.print("please enter book code that you wanted to return from 1 to 20 : ");
                            int book_code = sc_var.nextInt();
                            while ((book_code < 1) || (book_code > 20)) {
                                System.out.print("please enter number from 1 to 20 : ");
                                book_code = sc_var.nextInt();
                            }
                            /* switch the book returned */
                            switch (book_code) {
                                case 1:
                                    if (book1.getCounter() == 1) {
                                        person.returnItem(book1);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                    break;
                                case 2:
                                    if (book2.getCounter() == 1) {
                                        person.returnItem(book2);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                    break;
                                case 3:
                                    if (book3.getCounter() == 1) {
                                        person.returnItem(book3);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                        break;
                                    }
                                case 4:
                                    if (book4.getCounter() == 1) {
                                        person.returnItem(book4);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                    break;
                                case 5:
                                    if (book5.getCounter() == 1) {
                                        person.returnItem(book5);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                    break;
                                case 6:
                                    if (book6.getCounter() == 1) {
                                        person.returnItem(book6);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                case 7:
                                    if (book7.getCounter() == 1) {
                                        person.returnItem(book7);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                    break;
                                case 8:
                                    if (book8.getCounter() == 1) {
                                        person.returnItem(book8);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                    break;
                                case 9:
                                    if (book9.getCounter() == 1) {
                                        person.returnItem(book9);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                        break;
                                    }
                                case 10:
                                    if (book10.getCounter() == 1) {
                                        person.returnItem(book10);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                    break;
                                case 11:
                                    if (book11.getCounter() == 1) {
                                        person.returnItem(book11);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                    break;
                                case 12:
                                    if (book12.getCounter() == 1) {
                                        person.returnItem(book12);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                case 13:
                                    if (book13.getCounter() == 1) {
                                        person.returnItem(book13);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                    break;
                                case 14:
                                    if (book14.getCounter() == 1) {
                                        person.returnItem(book14);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                    break;
                                case 15:
                                    if (book15.getCounter() == 1) {
                                        person.returnItem(book15);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                        break;
                                    }
                                case 16:
                                    if (book16.getCounter() == 1) {
                                        person.returnItem(book16);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                    break;
                                case 17:
                                    if (book17.getCounter() == 1) {
                                        person.returnItem(book17);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                    break;
                                case 18:
                                    if (book18.getCounter() == 1) {
                                        person.returnItem(book18);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                    break;
                                case 19:
                                    if (book19.getCounter() == 1) {
                                        person.returnItem(book19);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                    break;
                                case 20:
                                    if (book20.getCounter() == 1) {
                                        person.returnItem(book20);
                                    } else {
                                        System.out.println("please make sure from book code this book already exist ");
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                        System.out.print("if you want to (borrow or return books ) enter 0 to exit enter 1 :");
                        exit_continue = sc_var.nextInt();
                        while ((exit_continue != 0) && (exit_continue !=1 )) {
                            System.out.print("if you want to (borrow or return books ) enter 0 to exit enter 1 :");
                            exit_continue = sc_var.nextInt();
                        }
                        if (exit_continue == 1) {
                            break;
                        }
                    }
                    //System.out.println("while finished 1");
                    counter = 0; // to return again
                }
            }else if(regist_login_var == 1){
                /* write new information */
                System.out.print("enter new user name : ");
                String newname = in.nextLine();
                System.out.print("enter new password : ");
                String newpassword = in.nextLine();

                try (FileWriter fw = new FileWriter("names.txt", true);
                     Formatter f = new Formatter(fw)) {

                    f.format("%s %s %s %s", "user_name", newname,newpassword,"\r\n");
                    // Add more lines as needed
                } catch (IOException e) {
                    System.out.println(e);
                }
                System.out.println("We'd love to have you join our library, which you can log in to now");
            }
        }
        System.out.println("end of program");
    }
}