import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {
    int rowNumber = 4, colNumber = 4;
    int map[][];
    int board[][];
    int size;
    boolean Isgame=true;

    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    MayinTarlasi(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.size = rowNumber * colNumber;

    }

    public void run() {
        int success=0;
        prepareGame();
        System.out.println("Oyun basladı");
        while (Isgame){
            print(map);
            System.out.println("==================================");
            print(board);
            System.out.println("Row :");
            int Row = input.nextInt();
            System.out.println("Coloumn :");
            int Coulumn = input.nextInt();

            if (map[Row][Coulumn]!=-1){
                checkmayin(Row,Coulumn);

                success++;
                if (success==size-(size/4)){
                    System.out.println("You win!!");
                }
            }else {
                Isgame=false;
                System.out.println("Game over");
            }
        }

    }
    public void checkmayin(int Row,int Coulomn){



        if (board[Row][Coulomn]==1 || board[Row][Coulomn]==2 ){
            System.out.println("Aynı degeri giremezsiniz!!");
            Isgame=false;
        }
        if( map[Row][Coulomn]==0) {
            if (Coulomn<(colNumber-1)&&(map[Row][Coulomn + 1] != -1)){
                board[Row][Coulomn]++;
            }
            if ((Row<rowNumber-1)&&(map[Row + 1][Coulomn] != -1)) {
                board[Row][Coulomn]++;
            }
            if ((Row>0)&&(map[Row - 1][Coulomn] != -1)) {
                board[Row][Coulomn]++;
            }
            if ((Coulomn>0)&&(map[Row][Coulomn - 1] != -1)) {
                board[Row][Coulomn]++;

            }if (board[Row][Coulomn]==0){
                board[Row][Coulomn]=-2;

            }

        }
    }

    public void prepareGame() {
        int randRow, randColoumn, count = 0;
        while (count != (size / 4)) {
            randRow = rand.nextInt(rowNumber);
            randColoumn = rand.nextInt(colNumber);
            if (map[randRow][randColoumn] != -1) {
                map[randRow][randColoumn] = -1;
                count++;
            }
        }
    }


    public void print(int[][] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");


            }
            System.out.println();

        }

    }
}

