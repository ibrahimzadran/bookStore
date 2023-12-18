import java.util.Scanner;

public class BookStorApp {
    private static BookDao bookDao=new BookDoaImpl(JDBConnection.getConnection());
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("""
                    Welcome to Book Store! 
                    Please enter your option 
                    1- Add a new Book
                    2- Update a book
                    3- Delete a book
                    4- Display a book
                    5- Display all Books
                    6- Exit the App
                    """);
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    addBook(sc);
                    break;
                case 2:
                    updateBook(sc);
                    break;
                case 3:
                    deleteBook(sc);
                    break;
                case 4:
                    readBookById(sc);
                    System.out.println("Please enter book Id ");
                    int bookId = sc.nextInt();
                    Book book= bookDao.getBookById(bookId);
                    System.out.println(book);
                    break;
                case 5:
                    displayBook(sc);
                    break;
                case 6:
                    System.out.println("Exiting the App ");
                default:
                    System.out.println("Wrong Input ");

            }

        }while (choice !=6);

    }

    private static void displayBook(Scanner sc) {
        for (Book book : bookDao.getAllBooks()){
            if(book ==null) {
                System.out.println("No book found ");
            }
            System.out.println(book);
        }

    }

    private static void readBookById(Scanner sc) {

    }

    private static void deleteBook(Scanner sc) {
    }

    private static void updateBook(Scanner sc) {
    }

    private static void addBook(Scanner sc ) {
        System.out.println("Please enter a title ");
        String title = sc.nextLine();
        System.out.println("Please enter a Book author ");
        String author= sc.nextLine();
        System.out.println("Please enter a book genre ");
        String genre = sc.nextLine();
        System.out.println("Please enter book price ");
        double price = sc.nextDouble();
        Book book =new Book(title, author,genre,price);
        System.out.println(book);
        bookDao.addBook(book);
        System.out.println("Book added successfully ");


    }
}
