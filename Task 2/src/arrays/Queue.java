package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Queue {
    public static void main(String[] args){
        String[] myQueue = new String[5];
        int front = 0;
        int rear = 0;
        initialiseQueue(myQueue);

        rear=enter(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        rear=enter(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        rear=enter(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        rear=enter(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        rear=enter(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        rear=enter(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        front =remove(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        front=remove(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        front=remove(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        front=remove(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        front=remove(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        rear=enter(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        rear=enter(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        front=remove(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        rear=enter(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        rear=enter(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        rear=enter(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        front=remove(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        front=remove(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        front=remove(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        front=remove(myQueue,front,rear);
        System.out.println(Arrays.toString(myQueue));
        front=remove(myQueue,front,rear);
    }

    private static int enter(String []myQueue,int front,int rear){
        Scanner input = new Scanner(System.in);
        int counter1 = 0;

        for (int x = 0; x < 5; x++){
            if (!(myQueue[x].equals("e"))){
               counter1++;
            }
        }
        if(counter1 == 5){
            System.out.println("Queue is full");
        }
        else{
            System.out.println("Enter the name:");
            myQueue[rear] = input.next();
            rear = rear + 1;
        }
        if(rear == 5) {
            rear = 0;
        }
        System.out.println(rear);
        System.out.println(front);
        System.out.println();
        return rear;
    }

    private static int remove(String  []myQueue,int front,int rear){
        int counter1 = 0;
        for (int x = 0; x < 5; x++){
            if ((myQueue[x].equals("e"))){
                counter1++;
            }
        }
        if(counter1 == 5){
            System.out.println("Queue is empty");
        }
        else {
            myQueue[front] = "e";
            front = front + 1;
        }
        if(front == 5){
            front = 0;
        }
        System.out.println(rear);
        System.out.println(front);
        System.out.println();
        return front;
    }

    private static void initialiseQueue(String [] myQueue) {
        for (int x = 0; x < 5; x++) myQueue[x] = "e";
        System.out.println("initialise ");
    }

}
