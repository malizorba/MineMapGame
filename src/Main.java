import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int column;
        int row;
        System.out.println("Mayın tarlasına hoş geldiniz");
        System.out.println("Lütfen boyutları giriniz");
        System.out.println("Satır sayısını giriniz :");
        row = scan.nextInt();
        System.out.println("Sütun sayısını giriniz");
        column=scan.nextInt();

    MayinTarlasi mayin = new MayinTarlasi(row,column);

    mayin.run();


    }
}
