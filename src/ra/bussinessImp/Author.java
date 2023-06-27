package ra.bussinessImp;

import ra.bussiness.IShop;

import java.util.Scanner;

public class Author implements IShop {
    private int authorId;
    private String authorNam;
    private boolean sex;
    private int year;

    public Author() {
    }

    public Author(int authorId, String authorNam, boolean sex, int year) {
        this.authorId = authorId;
        this.authorNam = authorNam;
        this.sex = sex;
        this.year = year;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorNam() {
        return authorNam;
    }

    public void setAuthorNam(String authorNam) {
        this.authorNam = authorNam;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập Tên tác giả: ");
        authorNam = sc.nextLine();
        System.out.println("Mời bạn nhập giới tính tác giả: ");
        sex = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Mời bạn nhập năm sinh tác giả: ");
        year = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("%-10d %-25s %-10b %-15d \n",authorId,authorNam,sex,year);
    }
}