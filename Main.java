package cinema;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Cinema {

//    public static final int rows = 8;
//    public static final int columns = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int columns = scanner.nextInt();
        menuWithOptionsAndFunctions(row, columns);
//        seatsScheme(row, columns);
//        System.out.println("Enter a row number:");
//        int row1 = scanner.nextInt();
//        System.out.println("Enter a seat number in that row:");
//        int columns1 = scanner.nextInt();
//        System.out.println();
//        showPrice(row, columns, row1, columns1);
//        markScheme(row, columns, row1, columns1);


    }
    private static void seatsScheme(int rows, int columns) {
        System.out.println("Cinema:");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= columns; j++) {
                if (i == 0 && j == 0) {
                    System.out.print(" ");
                } else if (i == 0) {
                    System.out.print(j);
                } else if (j == 0) {
                    System.out.print(i);
                } else {
                    System.out.print("S");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void calcProfit(int rows, int seats) {
        String text = "Total income:" + "\n$";
        int resultSmallRoom = rows * seats * 10;
        int resultBigRoomEvenNum = rows / 2 * seats * 10 + rows / 2 * seats * 8;
        int resultBigRoomOddNum = rows / 2 * seats * 10 + ((rows - rows / 2) * seats * 8);
        if (rows * seats <= 60) {
            System.out.println(text + resultSmallRoom);
        } else {
            if (rows % 2 == 0) {
                System.out.println(text + resultBigRoomEvenNum);
            } else {
                System.out.println(text + resultBigRoomOddNum);
            }
        }
    }

    private static int totalProfit(int rows, int seats) {
        String text = "Total income:" + "\n$";
        int resultSmallRoom = rows * seats * 10;
        int resultBigRoomEvenNum = rows / 2 * seats * 10 + rows / 2 * seats * 8;
        int resultBigRoomOddNum = rows / 2 * seats * 10 + ((rows - rows / 2) * seats * 8);
        if (rows * seats <= 60) {
            return resultSmallRoom;
        } else {
            if (rows % 2 == 0) {
                return resultBigRoomEvenNum;
            } else {
                return resultBigRoomOddNum;
            }
        }
    }

    private static void markScheme(int rows, int columns, int rows1, int columns1) {
        System.out.println("Cinema:");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= columns; j++) {
                if (i == 0 && j == 0) {
                    System.out.print(" ");
                } else if (i == 0) {
                    System.out.print(j);
                } else if (j == 0) {
                    System.out.print(i);
                } else if (i == rows1 && j == columns1) {
                    System.out.print("B");
                } else {
                    System.out.print("S");
                }
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    private static void showPrice(int rows, int seats ,int rows1, int columns1) {
        String text = "Ticket Price: $";
        int resultSmallRoom = 10;
        int resultBigRoomEvenNum = rows / 2 * seats * 10 + rows / 2 * seats * 8;
        int resultBigRoomOddNum = rows / 2 * seats * 10 + ((rows - rows / 2) * seats * 8);
        if (rows * seats <= 60) {
            System.out.println(text + resultSmallRoom + "\n");
        } else {
                if (rows1 <= rows / 2 ) {
                    System.out.println(text + 10);
                } else {
                    System.out.println(text + 8);
                }
        }
    }

    private static int currentIncome(int rows, int seats ,int rows1, int columns1) {
        String text = "Ticket Price: $";
        int resultSmallRoom = 10;
        int resultBigRoomEvenNum = rows / 2 * seats * 10 + rows / 2 * seats * 8;
        int resultBigRoomOddNum = rows / 2 * seats * 10 + ((rows - rows / 2) * seats * 8);
        if (rows * seats <= 60) {
//            System.out.println(text + resultSmallRoom + "\n");
            return resultSmallRoom;
        } else {
            if (rows1 <= rows / 2 ) {
//                System.out.println(text + 10);
                return 10;
            } else {
//                System.out.println(text + 8);
                return 8;
            }
        }
    }

    private static void cinemaMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "0. Exit");
    }
    private static void menuWithOptionsAndFunctions(int rows, int columns) {
        int totalIncome = totalProfit(rows, columns);
        boolean on = false;
        int currentIncome = 0;
        int countTicket = 0;
        double oneTicketPercent = (double) 100 / (rows * columns);
        String checkTicketIsPurchased = "";
        String seatRow = "";
        String seatCol = "";

        String [][] cinemaSeats = new String[rows + 1][columns + 1];
        for (int i = 0; i < cinemaSeats.length; i++)
            for (int j = 0; j < columns + 1; j++) {
                if (i == 0 && j == 0) {
                    cinemaSeats[i][j] = " ";
                } else if (i == 0) {
                    cinemaSeats[0][j] = String.valueOf(j);
                } else if (j == 0) {
                    cinemaSeats[i][0] = String.valueOf(i);
                } else {
                    cinemaSeats[i][j] = "S";
                }
            }
        Scanner scanner = new Scanner(System.in);
        while (!on) {
            boolean flag = true;
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Cinema:");
                for (int i = 0; i < cinemaSeats.length; i++) {
                    for (int j = 0; j < columns + 1; j++) {
                        System.out.print(cinemaSeats[i][j] + " ");
                    }
                    System.out.println();
                }
            } else if (choice == 2) {
                while (flag) {
                System.out.println("Enter a row number:");
                int seatRows = scanner.nextInt();
                System.out.println("Enter a seat number in that row:");
                int seatColumns = scanner.nextInt();
                seatRow = String.valueOf(seatRows);
                seatCol = String.valueOf(seatColumns);
                String check = seatRow + seatCol + seatRow + seatCol;
                checkTicketIsPurchased = checkTicketIsPurchased + seatRow + seatCol;
                if (seatRows > rows || seatColumns > columns) {
                    System.out.println("Wrong input!");
                }
                else if (checkTicketIsPurchased.contains(check)) {
                    System.out.println("That ticket has already been purchased!");
                } else {
                    countTicket++;
                    showPrice(rows, columns, seatRows, seatColumns);
                    currentIncome = currentIncome + currentIncome(rows, columns, seatRows, seatColumns);
                    cinemaSeats[seatRows][seatColumns] = "B";
                    flag = false;
                }
            }
            } else if (choice == 3) {
                System.out.println(cinemaSeats[0][0]);
                if (countTicket == 0) {
                    System.out.println("Number of purchased tickets: " + countTicket);
                    System.out.println("Percentage: 0.00%");
                    System.out.println("Current income " + "$" + currentIncome);
                    System.out.println("Total income: " + "$" + totalIncome);
                } else {
                    DecimalFormat f = new DecimalFormat("#.00");
                    double purchasedTicketsPercent = oneTicketPercent * countTicket;
                    System.out.println("Number of purchased tickets: " + countTicket);
                    System.out.println("Percentage: " + f.format(purchasedTicketsPercent) + "%");
//                    System.out.println(purchasedTicketsPercent);
                    System.out.println("Current income " + "$" + currentIncome);
                    System.out.println("Total income: " + "$" + totalIncome);
                }
            } else if (choice == 0) {
                on = true;
            }


        }

    }

}
