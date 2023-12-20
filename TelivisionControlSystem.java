import java.util.*;

public class TelivisionControlSystem {

    int input = Integer.MIN_VALUE;
    Scanner sc = new Scanner(System.in);
    boolean on = false;
    int channel = 1;
    int volume = 1;

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public void setChannel() {
        if (on == true && 1 <= channel || channel >= 7) {
            int setchnl;
            System.out.print("Set channel number : ");
            setchnl = sc.nextInt();
            channel = setchnl;
            System.out.println("Current channel number is " + channel);
        }
    }

    public void channelUp() {
        if (on == true && channel < 7) {
            channel++;
            System.out.println("Current channel number is = " + channel);
        } else {
            System.out.println("There are 7 Channels max.");
        }
    }

    public void channelDown() {
        if (on == true && channel > 7) {
            channel--;
            System.out.println("Current channel number is = " + channel);
        } else {
            System.out.println("There are 7 Channels max.");
        }
    }

    public void setVolume() {
        if (on == true && 1 <= volume || volume >= 7) {
            int setvlmn;
            System.out.print("Set Volume : ");
            setvlmn = sc.nextInt();
            volume = setvlmn;
            System.out.println("Current Volume is " + volume);
        }

    }

    public void incVolume() {
        if (on == true && volume < 7) {
            volume++;
            System.out.println("Current volume is = " + volume);
        } else {
            System.out.println("Volume max limit is 7.");
        }
    }

    public void decVolume() {
        if (on == true && volume > 7) {
            volume--;
            System.out.println("Current volume is = " + volume);
        } else {
            System.out.println("Volume min limit is 1.");
        }
    }

    public static void main(String[] args) {

        TelivisionControlSystem obj = new TelivisionControlSystem();
        System.out.println("Welcome to TV Control System");
        System.out.println("-----------------------");
        System.out.println("Current state of TV = off");
        while (obj.input != 9) {
            System.out.println("Menu:");
            System.out.println("1. Turn the TV on");
            System.out.println("2. Turn the TV off");
            System.out.println("3. Set the channel");
            System.out.println("4. Change the channel up");
            System.out.println("5. Change the channel down");
            System.out.println("6. Set the volume level");
            System.out.println("7. Increase the volume");
            System.out.println("8. Decrease the volume");
            System.out.println("9. Exit the program");
            System.out.print("Perform operation you want to perform : ");
            obj.input = obj.sc.nextInt();
            switch (obj.input) {
                case 1:
                    obj.turnOn();
                    System.out.println("TV is turned On.");
                    System.out.println();
                    break;
                case 2:
                    obj.turnOff();
                    System.out.println("TV is turned Off.");
                    System.out.println();
                    break;
                case 3:
                    obj.setChannel();
                    System.out.println();
                    break;
                case 4:
                    obj.channelUp();
                    System.out.println();
                    break;
                case 5:
                    obj.channelDown();
                    System.out.println();
                    break;
                case 6:
                    obj.setVolume();
                    System.out.println();
                    break;
                case 7:
                    obj.incVolume();
                    System.out.println();
                    break;
                case 8:
                    obj.decVolume();
                    System.out.println();
                    break;
                case 9:

                    System.out.println("Thank you for using the Television Control System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }

    }
}
