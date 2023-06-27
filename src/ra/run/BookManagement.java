package ra.run;

import ra.bussinessImp.Author;
import ra.bussinessImp.Book;

import java.util.*;

public class BookManagement {
    static List<Author> authorList = new ArrayList<>();
    static List<Book> bookList = new ArrayList<>();
    static Stack<String> stack = new Stack<>();
    static Queue<String> queue = new LinkedList<>();

    private static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        authorList.add(new Author(1, "tiep", true, 2000));
        authorList.add(new Author(2, "tiep1", true, 2001));
        authorList.add(new Author(3, "tiep2", true, 2002));
        authorList.add(new Author(4, "tiep3", true, 2003));
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập số tác giả và nhập thông tin các tác giả");
            System.out.println("2. Nhập số sách và nhập thông tin các sách");
            System.out.println("3. Sắp xếp sách theo giá xuất sách tăng dần (Comparable/Comparator)");
            System.out.println("4. Tìm kiếm sách theo tên tác giả sách");
            System.out.println("5. bai2");
            System.out.println("6. bai3");
            System.out.println("7. thoat");
            System.out.println("Sự lựa chọn của bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    createAuthor(sc);
                    break;
                case 2:
                    createBook(sc);
                    break;
                case 3:
                    sortExprotASC();
                    break;
                case 4:
                    searchAuthorName(sc);
                    break;
                case 5:
                    bai2(sc);
                    break;
                case 6:
                    bai3(sc);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn tử 1-5");
            }
        } while (true);
    }

    public static void createAuthor(Scanner sc) {
        System.out.println("Mời bạn nhập số lượng tác giả mà bạn cần thêm; ");
        int num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; i++) {
            System.out.println("Thông tin tác giả thứ " + (i + 1));
            Author author = new Author();
            author.setAuthorId(i + 1);
            author.inputData();
            authorList.add(author);
        }
        System.out.println("Bạn đã thêm mới thành công " + num + " tác giả");
    }

   /* public static void createBook(Scanner sc) {
        System.out.println("Mời bạn nhập số lượng sách bạn cần thêm: ");
        int number = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Thông tin sách thứ: " + (i + 1));
            Book book = new Book();
            book.setBookId(i + 1);
            book.inputData();
            bookList.add(book);
        }

    }*/

    public static void createBook(Scanner sc) {
        System.out.println("Mời bạn nhập số lượng sách bạn cần thêm: ");
        int number = Integer.parseInt(sc.nextLine());
        System.out.println("Danh sách tác giả có sẵn:");
        for (Author author : authorList) {
            System.out.println(author.getAuthorId() + ". " + author.getAuthorNam());
        }
        for (int i = 0; i < number; i++) {
            System.out.println("Thông tin sách thứ: " + (i + 1));
            Book book = new Book();
            book.setBookId(i + 1);

            System.out.println("Mời bạn chọn ID tác giả: ");
            int authorId = Integer.parseInt(sc.nextLine());
            Author selectedAuthor = getAuthorById(authorId);
            if (selectedAuthor != null) {
                book.setAuthor(selectedAuthor);
            } else {
                System.out.println("ID tác giả không hợp lệ!");
                continue;
            }
            book.inputData();
            bookList.add(book);
        }
    }

    public static Author getAuthorById(int authorId) {
        for (Author author : authorList) {
            if (author.getAuthorId() == authorId) {
                return author;
            }
        }
        return null;
    }


    public static void sortExprotASC() {
        books.sort(Comparator.comparingDouble(Book::getExportPrice));
        System.out.printf("%-10s %-25s %-20s %-20s %-15s %-10s \n", "bookId", "bookName", "Tên tác giả", "exportPrice", "quantity", "bookStatus");
        for (Book b : bookList) {
            b.displayData();
        }
    }

    public static void searchAuthorName(Scanner sc) {
        System.out.println("Mời bạn nhập tên tác giả: ");
        String authorName = sc.nextLine();
        boolean found = false;
        System.out.printf("%-10s %-25s %-20s %-20s %-15s %-10s \n", "bookId", "bookName", "Tên tác giả", "exportPrice", "quantity", "bookStatus");
        for (Book b : bookList) {
            Author author = b.getAuthor();
            if (author != null && author.getAuthorNam().toLowerCase().contains(authorName.toLowerCase())) {
                b.displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách của tác giả " + authorName);
        }
    }

    public static void bai2(Scanner sc) {
        boolean flag = true;
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập URL muốn truy cập");
            System.out.println("2. Quay lại");
            System.out.println("3. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    stackURL(sc);
                    break;
                case 2:
                    backup();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.err.println("vui lòng chọn tử 1-3");
            }
        } while (flag);
    }

    public static void stackURL(Scanner sc) {
        System.out.println("Hãy nhập url bạn muốn truy cập vào đây: ");
        String str = sc.nextLine();
        stack.push(str);
        System.out.println("đanh truy cập " + str);
    }

    public static void backup() {
        if (stack.isEmpty()) {
            System.err.println("không còn url nào để bạn quay lại nữa ");
            System.out.println();
        } else {
            String str = stack.pop();
            System.out.println("bạn đang truy cập ở " + str);
        }
    }

    public static void bai3(Scanner sc) {
        boolean flag = true;
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập tên khách hàng chờ mua vé xem phim");
            System.out.println("2. Khách tiếp theo");
            System.out.println("3. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    input(sc);
                    break;
                case 2:
                    output();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.err.println("vui lòng chọn tử 1-3");
            }
        } while (flag);
    }

    public static void input(Scanner sc) {
        System.out.println("Mời bạn Nhập tên khách hàng chờ mua vé xem phim");
        String str = sc.nextLine();
        queue.add(str);
    }

    public static void output() {
        if (queue.isEmpty()) {
            System.err.println("khong co khach hang nao ca");
        } else {
            String str = queue.peek();
            System.out.println(str);
            queue.remove();
        }
    }

}