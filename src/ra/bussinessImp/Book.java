package ra.bussinessImp;

import ra.bussiness.IShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book implements IShop {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private Author author;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, Author author, float importPrice, float exportPrice, int quantity, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }


    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên sách: ");
        bookName = sc.nextLine();
        System.out.println("Mời bạn nhập tiêu đề sách");
        title = sc.nextLine();
        System.out.println("Mời bạn nhập số trang sách ");
        numberOfPages = Integer.parseInt(sc.nextLine());
        System.out.println("Mời bạn nhập giá nhập sách ");
        importPrice = Float.parseFloat(sc.nextLine());
        exportPrice = importPrice * RATE;
        System.out.println("Mời bạn nhập số lượng sách ");
        quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Mời bạn nhập Trạng thái sách ");
        bookStatus = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Mời bạn nhập tên tác giả");
    }

    @Override
    public void displayData() {
        System.out.printf("%-10d %-25s %-20s %-20f %-15d %-10b \n", bookId, bookName,author.getAuthorNam(), exportPrice, quantity, bookStatus);
    }
}