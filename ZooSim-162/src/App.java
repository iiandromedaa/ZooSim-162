import java.util.Scanner;
import java.io.File;

public class App {
    static String[] animalNames;
    static String[] animalSpecies;
    static String[] animalAges;
    static String[] animalHabitats;
    static Scanner scanscan = new Scanner(System.in);
    static int zooSize;

    public static void main(String[] args) throws Exception {
        System.out.println("=-=-=-= ZooSim =-=-=-=");
        System.out.println("The world's most mediocre digital zoo!");
        System.out.println("1) Blank Zoo \n2) Autogenerate Zoo \n3) Load Zoo from CSV\n4) Exit");
        switch(intLoopScan("", 4, 3)) {
            case 1:
                int val = intLoopScan("Enter the size of your zoo.", 0, 1);
                createZoo(val);
                break;
            case 2:
                int valley = intLoopScan("Enter the size of your zoo.", 0, 1);
                createZoo(valley);
                break;
            case 3:
                System.out.println("Place Zoo.CSV in directory on the same level as App.java\nPress enter to continue");
                File csv = new File("./Zoo.csv");
                break;
            case 4:
                scanscan.close();
                System.exit(0);
                break;
        }
        System.out.println("Welcome to your zoo!");
        while (true) {
            switch (intLoopScan("1) Search animal\n2) Add animal\n3) Remove animal\n4) Edit animal\n5) Display full zoo\n6) Save to CSV\n7) Exit", 7, 3)) {
                case 1:
                    switch (intLoopScan("Search by\n1) Name\n2) Species\n3) Age\n4) Habitat", 4, 1)) {
                        case 1:
                            System.out.println("Enter name");
                        case 2:
                            System.out.println("Enter species");
                        case 3:
                            System.out.println("Enter age");                             
                        case 4:
                            System.out.println("Enter habitat");
                    }
                    break;
                case 2:
                    if (checkEmpty() == 0) {
                        System.out.println("Animal list full, please remove an animal entry before adding a new one.");
                        break;
                    } else {
                        
                    }
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    open = false;
                    scanscan.close();
                    System.exit(0);
                    break;
            }
        }
    }

    /**
     * @param prompt
     * @param bound
     * @param mode 
     * 1) GRE bound
     * 2) LES bound
     * 3) LEQ bound AND GRE 0
     * @return parsed int
     */
    public static int intLoopScan(String prompt, int bound, int mode) {
        System.out.print(prompt);
        while(true){
            try {
                int inty = Integer.parseInt(scanscan.next());
                if (mode == 1) {
                    if (inty > bound)
                        return inty;
                } else if (mode == 2) {
                    if (inty < bound)
                        return inty;
                } else if (mode == 3) {
                    if (inty <= bound && inty > 0)
                        return inty;
                }
                System.out.println("Invalid input.\n"+prompt);
            }
            catch(NumberFormatException ne) {
                System.out.println("Invalid input.\n"+prompt);
            }
        }
    }

    public static int checkEmpty() {
        int count = 0;
        for (int i = 0; i < animalNames.length; i++)
            if (animalNames[i].equals(""))
                count++;
        return count;
    }

    public static void createZoo(int zooSize) {
        animalNames = new String[zooSize];
        animalSpecies = new String[zooSize];
        animalAges = new String[zooSize];
        animalHabitats = new String[zooSize];
    };

    public static void randZoo(String[] names, String[] species, String[] ages, String[] habitats) {

    };

    /**
     * @deprecated
     */
    public static void bubbleCorresponding(String[] names, String[] specs, String[] ages, String[] habs, int sortBy) {
        {
            String[] arr, arr2, arr3, arr4;
            switch (sortBy) {
                case 1:
                    arr = names;
                    arr2 = specs;
                    arr3 = ages;
                    arr4 = habs;
                case 2:
                    
                case 3:
                case 4:
            }
            int n = names.length;
            int i, j;
            String temp, temp2, temp3, temp4;
            boolean swapped;
            for (i = 0; i < n - 1; i++) {
                swapped = false;
                for (j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        temp = arr[j];
                        temp2 = arr2[j];
                        temp3 = arr3[j];
                        temp4 = arr4[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        arr2[j] = arr2[j + 1];
                        arr2[j + 1] = temp2;
                        arr3[j] = arr3[j + 1];
                        arr3[j + 1] = temp3;
                        arr4[j] = arr4[j + 1];
                        arr4[j + 1] = temp4;
                        swapped = true;
                    }
                }
                if (swapped == false)
                    break;
            }
        }
    }
}
