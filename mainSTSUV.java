package com.company;
import java.util.Scanner; // import scanner class for user input

public class Main {

    public static void main(String[] args) {
        Scanner commandIs = new Scanner(System.in); //Creating a scanner object for user input
        int yourCommandIs;//declaring input as an integer

        //Creating a semi-Truck object
        mySemi semiTruck = new mySemi();
        //Creating an SUV object
        mySUV suvObject = new mySUV();
        //Creating a traffic light object
        myTraffic trafficLight = new myTraffic();

        //displaying the options menu
        System.out.println("Options to move the Semi-Truck:\n 1) Move Forward\n 2) Turn Right\n" +
                " 3) Turn Left\n 4) Jack Knife to a Stop");
        System.out.println("Options to move the Semi-Truck:\n 1) Move Forward\n 2) Turn Right\n" +
                " 3) Turn Left\n 4) Run Over Ford Pinto");
        System.out.println("Options to change the traffic light:\n 1) Green\n 2) Yellow\n" +
                " 3) Red\n 4) Left-Turn Green");
        System.out.println("Format should be Semi-Truck command then SUV command then Traffic Light command. Example: 111 is \n" +
                "forward forward green 334 is left turn, left turn light. The except is 4341 which will let the semi truck jack\n" +
                "knife to a stop on a red and the SUV run over the Ford Pinto on a green. Please enter 0 at anytime to exit the program.");
        //Start of loop to take in input. When the light isn't green the light will automatically be switched to green so
        //condition 5 on the semi truck and condition 3 on the SUV are met. Also condition 2 is met, because only one light
        // is turned on at a time.
        while((yourCommandIs = commandIs.nextInt()) !=0){
            switch(yourCommandIs) {
                //move forward and green light. With if else statement to check if semi truck is already moving forward.
                //If so program will give an error and ask for a different option. If not the program will run as usual.
                //This will allow condition 1 of both to be met.
                case (111):
                    if (semiTruck.command =="move forward" && suvObject.suv =="move forward") {
                        System.out.println("Error semi truck and SUV are already moving forward. Please select a different option.");
                    } else {
                        semiTruck.command="move forward";
                        suvObject.suv="move forward";
                        trafficLight.light="green";
                        System.out.println("Semi-Truck: " + semiTruck.command+ "\nSUV: " + suvObject.suv+
                                "\nTraffic Light:" + trafficLight.light);
                    }
                    break;
                //Move forward and yellow light.
                case (112):
                    semiTruck.command="move forward";
                    suvObject.suv="move forward";
                    trafficLight.light="yellow - slow down";
                    System.out.println("Semi-Truck: " + semiTruck.command+ "\nSUV: " + suvObject.suv+
                            "\nTraffic Light:" + trafficLight.light);
                    trafficLight.light="green";
                    System.out.println("Traffic Light:" + trafficLight.light);
                    break;
                //Turn right and green light.
                case (221):
                    semiTruck.command="turn right";
                    suvObject.suv="turn right";
                    trafficLight.light="green";
                    System.out.println("Semi-Truck: " + semiTruck.command+ "\nSUV: " + suvObject.suv+
                            "\nTraffic Light:" + trafficLight.light);
                    break;
                //Turn right and yellow light.
                case (222):
                    semiTruck.command="turn right";
                    suvObject.suv="turn right";
                    trafficLight.light="yellow - slow down";
                    System.out.println("Semi-Truck: " + semiTruck.command+ "\nSUV: " + suvObject.suv+
                            "\nTraffic Light:" + trafficLight.light);
                    trafficLight.light="green";
                    System.out.println("Traffic Light:" + trafficLight.light);
                    break;
                //Left turn and left green. The only time left turn is allowed is when the left green is selected so condition
                //3 of the semi truck and condition 3 on the SUV will be met.
                case (334):
                    semiTruck.command="left turn";
                    suvObject.suv="left turn";
                    trafficLight.light="left green";
                    System.out.println("Semi-Truck: " + semiTruck.command+ "\nSUV: " + suvObject.suv+
                            "\nTraffic Light:" + trafficLight.light);
                    trafficLight.light="green";
                    System.out.println("Traffic Light:" + trafficLight.light);
                    break;
                /*Jack knife to a stop and red. There is also an if else statement that will ask if the user wants to
                  continue with the program which will select the move forward and green light option or exit the program
                  so condition 4 is met. Also, for condition 4 of the second exercise the SUV is moving forward so the
                  SUV can run over the Ford Pinto.*/
                case (4341):
                    semiTruck.command="jack knife to a stop";
                    trafficLight.light="red";
                    System.out.println("Semi-Truck: " + semiTruck.command+ "\nTraffic Light:" + trafficLight.light);
                    suvObject.suv="move forward";
                    System.out.println("\nSUV: "+ suvObject.suv);
                    trafficLight.light="green";
                    suvObject.suv="Run Over Ford Pinto";
                    System.out.println("SUV: " + suvObject.suv+"\nTraffic Light:" + trafficLight.light);
                    System.out.println("Enter 1 to move forward otherwise 0 to quit program");
                    if((yourCommandIs = commandIs.nextInt())==1){
                        semiTruck.command="move forward";
                        trafficLight.light="green";
                        System.out.println("Semi-Truck: " + semiTruck.command+ "\nTraffic Light:" + trafficLight.light);
                    }else{
                        commandIs.close();
                        System.exit(0);
                    }
                    break;
                //In case an input that violates a condition or an input that doesn't exist is entered by the user.
                default:
                    System.out.println("Sorry can't process command. Check your input.");
                    break;
                //When the user decides to exit the program without causing it to crash.
                case (0):
                    commandIs.close();
                    System.exit(0);
                    break;
            }
        }
    }
}
