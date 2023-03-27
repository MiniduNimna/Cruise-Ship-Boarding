package arrays;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        String[][] cabinFirstName = new String[13][3];
        String[][] cabinSecondName = new String[13][3];
        String[] queueFirstName = new String[5];
        String[] queueSecondName = new String[5];
        int[][] expenses = new int[12][3];
        int front = 0;
        int rear = 0;
        String userInput;
        String userInputUpperCase;
        //initialise
        initialise(cabinFirstName);
        initialise(cabinSecondName);//better to initialise in a procedure
        initialiseQueue(queueFirstName);
        initialiseQueue(queueSecondName);

        System.out.println("initialise ");
        while (true) {
            System.out.println();
            System.out.println("""
            ---------- MENU ----------
            V : View all cabins\s
            A : Add a customer to a cabin\s
            E : Display empty cabins\s
            D : Delete customer from a cabin\s
            F : Find cabin from customer name\s
            S : Store program data into file
            L : Load program data from file\s
            O : View passengers ordered alphabetically by name
            T : Print expenses per passenger and total expenses of passengers
            --------------------------\s
            Enter the Letter : \s""");
            userInput = input.next();
            userInputUpperCase = userInput.toUpperCase();
            switch (userInputUpperCase) {  //Menu selection
                case "V":
                    View(cabinFirstName,cabinSecondName);
                    break;
                case "A":
                    rear = Add(cabinFirstName,cabinSecondName,expenses,queueFirstName,queueSecondName,rear);
                    break;
                case "E":
                    Empty(cabinFirstName);
                    break;
                case "D":
                    front = Delete(cabinFirstName,cabinSecondName,expenses,queueFirstName,queueSecondName,rear);
                    break;
                case "F":
                    Find(cabinFirstName,cabinSecondName);
                    break;
                case "S":
                    Store(cabinFirstName,cabinSecondName);
                    break;
                case "L":
                    Load();
                    break;
                case "O":
                    Order(cabinFirstName,cabinSecondName);
                    break;
                case "T":
                    expenses(expenses);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }

    }

    private static void initialise(String[][] cabinRef) {
        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 3; y++) {
                cabinRef[x][y] = "e";
            }
        }
    }

    private static void initialiseQueue(String [] myQueue) {
        for (int x = 0; x < 5; x++) myQueue[x] = "e";
    }

    private static void View(String[][] cabinFirstName, String[][] cabinSecondName) {
        for (int x = 0; x < 12; x++) {
            System.out.println("Cabin " + x + " occupied by " + cabinFirstName[x][0] + " " + cabinSecondName[x][0] + " , " + cabinFirstName[x][1] + " " + cabinSecondName[x][1] + " , " + cabinFirstName[x][2] + " " + cabinSecondName[x][2]);
        }
    }



    private static int Add(String[][] cabinFirstName, String[][] cabinSecondName, int[][] expenses, String[] queueFirstName, String[] queueSecondName, int rear){
        Scanner input = new Scanner(System.in);
        String cabinName1;
        String cabinName1Temp;
        String cabinName2;
        String cabinName2Temp;
        int cabinNum;
        int passengerNum;
        int counter = 0;
        while (true) {
            System.out.println();
            for (int x = 0; x < 12; x++) {
                if ((cabinFirstName[x][0].equals("e")) && (cabinFirstName[x][1].equals("e")) && (cabinFirstName[x][2].equals("e"))) {
                    counter ++ ;
                }
            }
            if (counter == 0){
                System.out.println("All the cabins in cruise ship is full.You will be added to the waiting list");
                System.out.println();
                int counter1 = 0;
                for (int x = 0; x < 5; x++){
                    if (!(queueFirstName[x].equals("e"))){
                        counter1++;
                    }
                }
                if(counter1 == 5){
                    System.out.println("Queue is full. No more passengers can be add to the waiting list.");
                    break;
                }
                else{
                    System.out.println("Enter passenger's first name : ");
                    cabinName1Temp = input.next();
                    cabinName1 = cabinName1Temp.toUpperCase();
                    queueFirstName[rear] = cabinName1;
                    System.out.println("Enter passenger's surname : ");
                    cabinName2Temp = input.next();
                    cabinName2 = cabinName2Temp.toUpperCase();
                    queueSecondName[rear] = cabinName2;
                    System.out.println("Passenger successfully added to the waiting list. ");
                    rear = rear + 1;
                }
                if(rear == 5) {
                    rear = 0;
                }
                break;
            }
            else {
                System.out.println("Enter cabin number (0-11) or 12 to stop : ");
                cabinNum = input.nextInt();
                if ((cabinNum >= 0) && (cabinNum <= 11)) {
                    if ((cabinFirstName[cabinNum][0].equals("e")) && (cabinFirstName[cabinNum][1].equals("e")) && (cabinFirstName[cabinNum][2].equals("e"))) {  // Code for cabin space for 3 passengers
                        System.out.println("Maximum 3 passengers can be allocate.");
                        System.out.println("How many passengers you want to allocate for cabin " + cabinNum + " : ");
                        passengerNum = input.nextInt();
                        if (passengerNum == 1) {
                            System.out.println("Enter passenger's first name : ");
                            cabinName1Temp = input.next();
                            cabinName1 = cabinName1Temp.toUpperCase();
                            cabinFirstName[cabinNum][0] = cabinName1;
                            System.out.println("Enter passenger's surname : ");
                            cabinName2Temp = input.next();
                            cabinName2 = cabinName2Temp.toUpperCase();
                            cabinSecondName[cabinNum][0] = cabinName2;
                            expenses[cabinNum][0] = 1000;
                            System.out.println("Passengers successfully allocated to the cabin. ");
                        } else if (passengerNum == 2) {
                            System.out.println("Enter 1st passenger's first name : ");
                            cabinName1Temp = input.next();
                            cabinName1 = cabinName1Temp.toUpperCase();
                            cabinFirstName[cabinNum][0] = cabinName1;
                            System.out.println("Enter 1st passenger's surname : ");
                            cabinName2Temp = input.next();
                            cabinName2 = cabinName2Temp.toUpperCase();
                            cabinSecondName[cabinNum][0] = cabinName2;
                            expenses[cabinNum][0] = 1000;
                            System.out.println("Enter 2nd passenger's first name : ");
                            cabinName1Temp = input.next();
                            cabinName1 = cabinName1Temp.toUpperCase();
                            cabinFirstName[cabinNum][1] = cabinName1;
                            System.out.println("Enter 2nd passenger's surname : ");
                            cabinName2Temp = input.next();
                            cabinName2 = cabinName2Temp.toUpperCase();
                            cabinSecondName[cabinNum][1] = cabinName2;
                            expenses[cabinNum][1] = 1000;
                            System.out.println("Passengers successfully allocated to the cabin. ");
                        } else if (passengerNum == 3) {
                            System.out.println("Enter 1st passenger's first name : ");
                            cabinName1Temp = input.next();
                            cabinName1 = cabinName1Temp.toUpperCase();
                            cabinFirstName[cabinNum][0] = cabinName1;
                            System.out.println("Enter 1st passenger's surname : ");
                            cabinName2Temp = input.next();
                            cabinName2 = cabinName2Temp.toUpperCase();
                            cabinSecondName[cabinNum][0] = cabinName2;
                            expenses[cabinNum][0] = 1000;
                            System.out.println("Enter 2nd passenger's first name : ");
                            cabinName1Temp = input.next();
                            cabinName1 = cabinName1Temp.toUpperCase();
                            cabinFirstName[cabinNum][1] = cabinName1;
                            System.out.println("Enter 2nd passenger's surname : ");
                            cabinName2Temp = input.next();
                            cabinName2 = cabinName2Temp.toUpperCase();
                            cabinSecondName[cabinNum][1] = cabinName2;
                            expenses[cabinNum][1] = 1000;
                            System.out.println("Enter 3rd passenger's first name : ");
                            cabinName1Temp = input.next();
                            cabinName1 = cabinName1Temp.toUpperCase();
                            cabinFirstName[cabinNum][2] = cabinName1;
                            System.out.println("Enter 3rd passenger's surname : ");
                            cabinName2Temp = input.next();
                            cabinName2 = cabinName2Temp.toUpperCase();
                            cabinSecondName[cabinNum][2] = cabinName2;
                            expenses[cabinNum][2] = 1000;
                            System.out.println("Passengers successfully allocated to the cabin. ");
                        } else {
                            System.out.println(passengerNum + " passengers can not be allocated for this cabin.");
                        }
                    } else {
                        System.out.println("Cabin " + cabinNum + " is already occupied.");
                    }
                } else if (cabinNum == 12) {
                    System.out.println("Exited from the program");
                    break;
                } else {
                    System.out.println("Invalid cabin number");
                }
            }
        }
        return rear;
    }

    private static void Empty(String[][] cabinFirstName){
        for (int x = 0; x < 12; x++) {
            if ((cabinFirstName[x][0].equals("e")) && (cabinFirstName[x][1].equals("e")) && (cabinFirstName[x][2].equals("e"))) {
                System.out.println("Cabin " + x + " is empty");
            }
        }
    }

    private static void Find(String[][] cabinFirstName , String[][] cabinSecondName){
        Scanner input = new Scanner(System.in);
        String userNameTemp;
        String userName;
        int counter = 0;
        System.out.println("Enter the name of the customer : ");
        userNameTemp = input.next();
        userName = userNameTemp.toUpperCase();
        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 3; y++) {
                if (cabinFirstName[x][y].equals(userName)) {
                    System.out.println(userName + " has occupied cabin " + x);
                    counter ++;
                }
            }
        }
        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 3; y++) {
                if (cabinSecondName[x][y].equals(userName)) {
                    System.out.println(userName + " has occupied cabin " + x);
                    counter ++;
                }
            }
        }
        if (counter == 0){
            System.out.println(userName + " has not occupied any cabin ");
        }
    }

/*private static void Delete(String[][] cabinFirstName, String[][] cabinSecondName, int[][] expenses){
    Scanner input = new Scanner(System.in);
    int cabinNum;
    int passengerNumTemp;
    int passengerNum;
    while(true){
        System.out.println("Enter the customer's cabin number to delete (0-11) or 12 to stop : ");
        cabinNum = input.nextInt();
        if ((cabinNum >= 0) && (cabinNum <= 11)) {
            System.out.println("Which passenger in this cabin you want to delete ( 1, 2 or 3) : ");
            passengerNumTemp = input.nextInt();
            passengerNum = passengerNumTemp - 1;
            if (passengerNum > 2 ) {
                System.out.println("Invalid cabin number");
            }
            else if(passengerNum < 0) {
                System.out.println("Invalid cabin number");
            }
            else if((cabinFirstName[cabinNum][passengerNum].equals("e")) && (cabinSecondName[cabinNum][passengerNum].equals("e"))) {
                System.out.println("Cabin is already empty");
            }
            else{
                cabinFirstName[cabinNum][passengerNum] = "e";
                cabinSecondName[cabinNum][passengerNum] = "e";
                expenses[cabinNum][passengerNum] = 0;
                System.out.println("Passenger " + passengerNumTemp + " in cabin " + cabinNum + " removed");
            }
        } else if (cabinNum == 12) {
            System.out.println("Exited to the main menu");
            break;
        }
        else {
            System.out.println("Invalid cabin number");
        }
        System.out.println();
    }
}*/

    private static int Delete(String[][] cabinFirstName, String[][] cabinSecondName, int[][] expenses, String[] queueFirstName, String[] queueSecondName,int front){
        Scanner input = new Scanner(System.in);
        int counter1 = 0;
        int cabinNum;
        while(true){
            System.out.println("Enter the customer's cabin number to delete (0-11) or 12 to stop : ");
            cabinNum = input.nextInt();
            if ((cabinNum >= 0) && (cabinNum <= 11)) {
                if((cabinFirstName[cabinNum][0].equals("e")) && (cabinFirstName[cabinNum][1].equals("e")) && (cabinFirstName[cabinNum][2].equals("e"))) {
                    System.out.println("Cabin is already empty");
                }
                else{
                    for (int i=0 ; i < 3 ; i++){
                        cabinFirstName[cabinNum][i] = "e";
                        cabinSecondName[cabinNum][i] = "e";
                        expenses[cabinNum][i] = 0;
                    }
                    System.out.println("Passengers " +   "in cabin " + cabinNum + " removed");
                    for (int x = 0; x < 5; x++){
                        if ((queueFirstName[x].equals("e"))){
                            counter1++;
                        }
                    }
                    if(counter1 == 5){
                        System.out.println("Queue is empty. There are no passengers in the waiting list. ");
                        break;
                    }
                    else {
                        cabinFirstName[cabinNum][0] = queueFirstName[front];
                        cabinSecondName[cabinNum][0] = queueSecondName[front];
                        expenses[cabinNum][0] = 1000;
                        queueFirstName[front] = "e";
                        queueSecondName[front] = "e";
                        front = front + 1;
                        System.out.println("Next passenger in the waiting list allocated for cabin " + cabinNum +".");
                    }
                    if(front == 5){
                        front = 0;
                    }
                }
            } else if (cabinNum == 12) {
                System.out.println("Exited to the main menu");
                break;
            }
            else {
                System.out.println("Invalid cabin number");
            }
            System.out.println();
        }
        return front;
    }

    private static void Store(String[][] cabinFirstName, String[][] cabinSecondName) throws IOException {
        File data = new File("Cabin Data.txt");
        data.delete(); // to delete the previous program data stored in the file
        FileWriter dataWrite = new FileWriter("Cabin Data.txt");
        dataWrite.write("\n-------\tCabin Data\t-------\n\n");
        for (int x = 0; x < 12; x++ ) {
            dataWrite.write("Cabin " + x + " occupied by " + cabinFirstName[x][0] + " " + cabinSecondName[x][0] + " , " + cabinFirstName[x][1] + " " + cabinSecondName[x][1] + " , " + cabinFirstName[x][2] + " " + cabinSecondName[x][2] + "\n");
        }
        dataWrite.close();
        System.out.println("Successfully stored data into the file.");
    }

    private static void Load() throws IOException {
        File data = new File("Cabin Data.txt");
        data.createNewFile(); // to avoid the file missing error when running the program first time
        Scanner input = new Scanner(data);
        String info;
        while (input.hasNextLine()){
            info = input.nextLine();
            System.out.println(info);
        }
        input.close();
        System.out.println();
        System.out.println("Successfully loaded data from the file.");
    }

    /*private static void Order(String[][] cabinFirstName, String[][] cabinSecondName ){
        String[][] cabinOrderCombine = new String[24][3];
        String[] cabinOrderTemp = new String[72];
        String[] cabinOrder = new String[36];
        int counter1 = 0;
        int counter2 = 36;
        int counter3 = 0;
        System.arraycopy(cabinFirstName, 0, cabinOrderCombine, 0, 12); // Get a copy of cabinFirstName array to the combine 2d array
        System.arraycopy(cabinSecondName, 0, cabinOrderCombine, 12, 12);// Get a copy of cabinSecondName array to the combine 2d array starting from 12th position in combine array
        for(int i = 0; i < cabinOrderCombine.length; i++) {  //making a simple array using the 2d array
            for(int j = 0; j < cabinOrderCombine[i].length; j++) {
                cabinOrderTemp[counter1] = cabinOrderCombine[i][j];
                counter1++;
            }
        }
        for(int m = 0; m < 36; m++) {  // combining the passengers surname with the relevant fist name
            cabinOrderTemp[m] = cabinOrderTemp[m] + " " + cabinOrderTemp[counter2];
            counter2++;
        }
        System.arraycopy(cabinOrderTemp, 0, cabinOrder, 0, 36);  //Copying the fist 36 elements of the cabinOrderTemp array
        Arrays.sort(cabinOrder);
        System.out.println("Alphabetical order of passenger names");
        System.out.println();
        for(int x = 0; x < cabinOrder.length; x++) {
            if(!(cabinOrder[x].equals("e e"))) {
                System.out.println(cabinOrder[x]);
                counter3 ++;
            }
        }
        if (counter3 == 0){
            System.out.println("No passenger names allocated for cabins to display ");
        }
    }*/
    private static void Order(String[][] cabinFirstName, String[][] cabinSecondName ){
        String[] cabinOrder = new String[36];
        int counter1 = 0;
        int counter2 = 0;
        for(int i = 0; i < 12; i++) {  //making a simple array using the 2d arrays cabinFirstName and cabinSecondName
            for(int j = 0; j < 3; j++) {
                cabinOrder[counter1] = cabinFirstName[i][j] + " " + cabinSecondName[i][j];
                counter1++;
            }
        }
        Arrays.sort(cabinOrder);
        System.out.println("Alphabetical order of passenger names");
        System.out.println();
        for(int x = 0; x < cabinOrder.length; x++) {
            if(!(cabinOrder[x].equals("e e"))) {
                System.out.println(cabinOrder[x]);
                counter2 ++;
            }
        }
        if (counter2 == 0){
            System.out.println("No passenger names allocated for cabins to display ");
        }
    }

    private static void expenses(int[][] expenses ){
        int counter = 0;
        int totalExpense;
        int passengerExpense = 0;
        System.out.println(Arrays.deepToString(expenses));
        for(int i = 0; i < expenses.length; i++) {  //making a simple array using the 2d array
            for(int j = 0; j < 3; j++) {
                if(!(expenses[i][j] == 0)) {
                    passengerExpense = 1000;
                    counter++;
                }
            }
        }
        totalExpense = 1000 * counter;
        System.out.println("Expense per passenger : " + passengerExpense);
        System.out.println("Total expenses of passengers : " + totalExpense);
    }

}



