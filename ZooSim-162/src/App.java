import java.util.Scanner;
import java.io.File;

public class App {
    static String[] animalNames;
    static String[] animalSpecies;
    static String[] animalAges;
    static String[] animalHabitats;
    static int zooSize;

    public static void main(String[] args) throws Exception {
        System.out.println("=-=-=-= ZooSim =-=-=-=");
        System.out.println("The world's most mediocre digital zoo!");
        System.out.println("1) Blank Zoo \n2) Autogenerate Zoo \n3) Load Zoo from CSV\n4) Exit");
        Scanner scanscan = new Scanner(System.in);
        boolean valid = false;
        boolean open = true;
        if (scanscan.hasNextInt()) {
            switch(scanscan.nextInt()) {
                case 1:
                    System.out.println("Enter the size of your zoo:");
                    while(!valid) {
                        scanscan.nextLine();
                        if (scanscan.hasNextInt()) {
                            int inp = scanscan.nextInt();
                            if (inp > 0) {
                                valid = true;
                                createZoo(inp);
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter the size of your zoo:");
                    while(!valid) {
                        scanscan.nextLine();
                        if (scanscan.hasNextInt()) {
                            int inp = scanscan.nextInt();
                            if (inp > 0) {
                                valid = true;
                                createZoo(inp);
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Place Zoo.CSV in directory on the same level as App.java\nPress enter to continue");
                    File csv = new File("./Zoo.csv");

                case 4:
                    scanscan.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } else {
            System.err.println("Not a valid integer");
            scanscan.close();
            System.exit(0);
        };
        System.out.println("Welcome to your zoo!");
        while (open = true) {
            System.out.println("1) Search animal\n2) Add animal\n3) Remove animal\n4) Edit animal\n5) Display full zoo\n6) Save to CSV\n7) Exit");
            if (scanscan.hasNextInt()) {
                switch (scanscan.nextInt()) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    default:
                        break;
                }

            }
        }
    }

    public static void createZoo(int zooSize) {
        animalNames = new String[zooSize];
        animalSpecies = new String[zooSize];
        animalAges = new String[zooSize];
        animalHabitats = new String[zooSize];
    };

    public static void randZoo(String[] names, String[] species, int[] ages, String[] habitats) {

    };

    public static void bubbleCorresponding(String[] ref, String[] sort0, String[] sort1, String[] sort2) {

    }
}
