import java.util.Scanner;
import java.io.File;
import java.net.URI;

public class App {
    static String[] animalNames;
    static String[] animalSpecies;
    static int[] animalAges;
    static String[] animalHabitats;
    static int zooSize;

    public static void main(String[] args) throws Exception {
        System.out.println("=-=-=-= ZooSim =-=-=-=");
        System.out.println("The world's most mediocre digital zoo!");
        System.out.println("1) Blank Zoo \n2) Autogenerate Zoo \n3) Load Zoo from CSV\n4) Exit");
        Scanner scanscan = new Scanner(System.in);
        boolean valid = false;
        if (scanscan.hasNextInt()) {
            switch(scanscan.nextInt()) {
                case 1:
                    while(!valid) {
                        System.out.println("Enter the size of your zoo:");
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
                    while(!valid) {
                        System.out.println("Enter the size of your zoo:");
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
        };
    }

    public static void createZoo(int zooSize) {
        //Attributes
        // - Name
        // - Species
        // - Ages
        // - Habitats
        animalNames = new String[zooSize];
        animalSpecies = new String[zooSize];
        animalAges = new int[zooSize];
        animalHabitats = new String[zooSize];
    };

    public static void randZoo(String[] names, String[] species, int[] ages, String[] habitats) {

    };
}
