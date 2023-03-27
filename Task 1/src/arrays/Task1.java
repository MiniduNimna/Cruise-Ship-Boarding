package arrays;
import java.util.*;

public class Task1 {

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        String cabinName;
        int cabinNum;
        String[] cabin = new String[13];
        //initialise
        initialise(cabin); //better to initialise in a procedure
        while (true) {

            for (int x = 0; x < 12; x++ ) {
                if (cabin[x].equals("e")) {
                    System.out.println("room " + x + " is empty");
                }
            }
            System.out.println("Enter cabin number (0-11) or 12 to stop:" );
            cabinNum = input.nextInt();

            if ((cabinNum >= 0) && (cabinNum <= 11)){
                System.out.println("Enter name for cabin " + cabinNum +" :" ) ;
                cabinName = input.next();
                cabin[cabinNum] = cabinName;
                for (int x = 0; x < 12; x++ ) {
                    System.out.println("Cabin " + x + " occupied by " + cabin[x]);
                }
            }
            else if (cabinNum == 12) {
                System.out.println("Exited from the program");
                break;
            }
            else{
                System.out.println("Invalid cabin number");
                continue;
            }

        }

    }


    private static void initialise( String hotelRef[]) {
        for (int x = 0; x < 12; x++ ) hotelRef[x] = "e";
        System.out.println( "initialise ");
    }


}

