import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class App {
    static String[] animalNames;
    static String[] animalSpecies;
    static String[] animalAges;
    static String[] animalHabitats;
    static Scanner scanscan = new Scanner(System.in);
    static int zooSize;

    static final String[] nameFront = {"Geo", "Joe", "And", "Jeb", "Mat", "Ors", "Aer", "Bo", "E", "Chlo", "Cor", "Barr", "Li", "Ker", "Za", "Fi", "Madi"};
    static final String[] nameEnd = {"y", "ro", "oss", "ose", "or", "am", "man", "son", "rge", "min", "yu", "iyu", "-La", "nn"};
    static final String[] randHabs = {"Arctic", "Suburbia", "Plains", "Prarie", "Sky", "Underground", "Your mom's house", "Ocean", "Sea", "Freshwater", "Saltwater", "Desert", "Dessert (with two S's)"};
    static final String[] randSpec = {"Bear", "Fox", "Cat", "Wolf", "Glorpus", "Glumbo", "Seal", "Glubby", "Womp", "Dog", "Blep", "Human", "Lion", "Capybara"};

    public static void main(String[] args) throws Exception {
        System.out.println("=-=-=-= ZooSim =-=-=-=");
        System.out.println("The world's most mediocre digital zoo!");
        System.out.print("1) Blank Zoo \n2) Autogenerate Zoo \n3) Load Zoo from CSV (Not implemented)\n4) Exit");
        switch(intLoopScan("", 4, 3)) {
            case 1:
                int val = intLoopScan("Enter the size of your zoo.", 0, 1);
                createZoo(val);
                break;
            case 2:
                int valley = intLoopScan("Enter the size of your zoo.", 0, 1);
                createZoo(valley);
                randZoo();
                break;
            case 3:
                System.out.println("Place Zoo.CSV in directory on the same level as App.java (src folder)\nPress enter to continue");
                scanscan.next();
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
                    switch (intLoopScan("Search by\n1) Name\n2) Species\n3) Age\n4) Habitat", 4, 3)) {
                        case 1:
                            System.out.println("Enter name");
                            bubbleCorresponding(1); //name
                            int resultN = binarySearch(animalNames, scanscan.next());
                            if (resultN != -1) {
                                resultPrinter(resultN);
                            } else {
                                System.out.println("Match not found");
                            }
                            break;
                        case 2:
                            System.out.println("Enter species");
                            bubbleCorresponding(2); //spec
                            int resultS = binarySearch(animalSpecies, scanscan.next());
                            if (resultS != -1) {
                                resultPrinter(resultS);
                            } else {
                                System.out.println("Match not found");
                            }
                            break;
                        case 3:
                            bubbleCorrespondingByInt(); //age specific one
                            int resultA = binarySearchByInt(animalAges, intLoopScan("Enter age", -1, 1));
                            if (resultA != -1) {
                                resultPrinter(resultA);
                            } else {
                                System.out.println("Match not found");
                            }
                            break;                 
                        case 4:
                            System.out.println("Enter habitat");
                            bubbleCorresponding(4); //habs
                            int resultH = binarySearch(animalHabitats, scanscan.next());
                            if (resultH != -1) {
                                resultPrinter(resultH);
                            } else {
                                System.out.println("Match not found");
                            }
                            break;
                    }
                    break;
                case 2:
                    if (checkEmpty() == 0) {
                        System.out.println("Animal list full, please remove an animal entry before adding a new one.");
                        break;
                    } else {
                        int empy = 0;
                        for (int i = 0; i < animalNames.length; i++)
                            if (animalNames[i] == null) {
                                empy = i;
                                break;
                            }
                        String tName, tSpec, tAge, tHab;
                        System.out.println("Enter animal name");
                        tName = scanscan.next();
                        System.out.println("Enter animal species");
                        tSpec = scanscan.next();
                        tAge = Integer.toString(intLoopScan("Enter animal age", 0, 1));
                        System.out.println("Enter animal habitat");
                        tHab = scanscan.next();
                        animalNames[empy] = tName; animalSpecies[empy] = tSpec; animalAges[empy] = tAge; animalHabitats[empy] = tHab;
                        break;
                    }
                case 3:
                    int clearer = intLoopScan("Enter animal index to clear (indices begin at 0)", animalNames.length, 4);
                    animalNames[clearer] = null;
                    animalSpecies[clearer] = null;
                    animalAges[clearer] = null;
                    animalHabitats[clearer] = null;
                    break;
                case 4:
                    int iEdit = intLoopScan("Enter animal index to edit (indices begin at 0)", animalNames.length, 4);
                    System.out.println(animalNames[iEdit] + ", " + animalSpecies[iEdit] + ", " + animalAges[iEdit] + ", " + animalHabitats[iEdit]);
                    switch (intLoopScan("1) Edit name\n2) Edit species\n3) Edit age\n4) Edit habitat", 4, 3)) {
                        case 1:
                            System.out.println("Enter new name");
                            animalNames[iEdit] = scanscan.next();
                            break;
                        case 2:
                            System.out.println("Enter new species");
                            animalSpecies[iEdit] = scanscan.next();
                            break;
                        case 3:
                            animalAges[iEdit] = Integer.toString(intLoopScan("Enter new age", -1, 1));
                            break;
                        case 4:
                            System.out.println("Enter new habitat");
                            animalHabitats[iEdit] = scanscan.next();
                            break;
                    }
                    System.out.println("Edited entry");
                    System.out.println(animalNames[iEdit] + ", " + animalSpecies[iEdit] + ", " + animalAges[iEdit] + ", " + animalHabitats[iEdit]);
                    break;
                case 5:
                    System.out.println("Name, Species, Age, Habitat");
                    for (int i = 0; i < animalNames.length; i++) {
                        System.out.println(i + " " + animalNames[i] + ", " + animalSpecies[i] + ", " + animalAges[i] + ", " + animalHabitats[i]);
                    }
                    break;
                case 6:
                    CSVHelper.export();
                    break;
                case 7:
                    scanscan.close();
                    System.exit(0);
                    break;
            }
        }
    }

    /**
     * @param prompt
     * @param bound
     * @param mode <br>
     * 1) GRE bound <br>
     * 2) LES bound <br>
     * 3) LEQ bound AND GRE 0 (menu switch mode) <br>
     * 4) LES bound AND GRQ 0 (array mode) <br>
     * @return parsed int
     */
    public static int intLoopScan(String prompt, int bound, int mode) {
        System.out.println(prompt);
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
                } else if (mode == 4) {
                    if (inty < bound  && inty >= 0)
                        return inty;
                }
                System.out.println("Invalid input.\n"+prompt);
            }
            catch(NumberFormatException ne) {
                System.out.println("Invalid input.\n"+prompt);
            }
        }
    }

    /**
     * @return number of empty animal indices
     */
    public static int checkEmpty() {
        int count = 0;
        for (int i = 0; i < animalNames.length; i++)
            if (animalNames[i] == null)
                count++;
        return count;
    }

    public static void createZoo(int zooSize) {
        animalNames = new String[zooSize];
        animalSpecies = new String[zooSize];
        animalAges = new String[zooSize];
        animalHabitats = new String[zooSize];
    };

    public static void randZoo() {
        for (int i = 0; i < animalNames.length; i++) {
            int rand = new Random().nextInt(nameFront.length);
            int rand2 = new Random().nextInt(nameEnd.length);
            animalNames[i] = nameFront[rand] + nameEnd[rand2];
        }
        for (int i = 0; i < animalNames.length; i++) {
            int rand = new Random().nextInt(randSpec.length);
            animalSpecies[i] = randSpec[rand];
        }
        for (int i = 0; i < animalNames.length; i++) {
            animalAges[i] = Integer.toString(new Random().nextInt(120));
        }
        for (int i = 0; i < animalNames.length; i++) {
            int rand = new Random().nextInt(randHabs.length);
            animalHabitats[i] = randHabs[rand];
        }
    };

    /**
     * @param sortBy 1 is by name, 2 is by species, 3 is by age, 4 is by habitat
     */
    public static void bubbleCorresponding(int sortBy) {
        {
            String[] arr, arr2, arr3, arr4;
            //default assignment so the compiler doesn't get mad
            arr = animalNames;
            arr2 = animalSpecies;
            arr3 = animalAges;
            arr4 = animalHabitats;
            switch (sortBy) {
                case 1:
                    arr = animalNames;
                    arr2 = animalSpecies;
                    arr3 = animalAges;
                    arr4 = animalHabitats;
                    break;
                case 2:
                    arr = animalSpecies;
                    arr2 = animalNames;
                    arr3 = animalAges;
                    arr4 = animalHabitats;
                    break;
                case 4:
                    arr = animalHabitats;
                    arr2 = animalSpecies;
                    arr3 = animalAges;
                    arr4 = animalNames;
                    break;
            }
            String temp, temp2, temp3, temp4;
            for (int j = 0; j < arr.length; j++) {
                for (int i = j + 1; i < arr.length; i++) {
                    if (arr[i].compareTo(arr[j]) < 0) {
                        temp = arr[j];
                        temp2 = arr2[j];
                        temp3 = arr3[j];
                        temp4 = arr4[j];
                        arr[j] = arr[i];
                        arr2[j] = arr2[i];
                        arr3[j] = arr3[i];
                        arr4[j] = arr4[i];
                        arr[i] = temp;
                        arr2[i] = temp2;
                        arr3[i] = temp3;
                        arr4[i] = temp4;
                    }
                }
            }
        }
    }

    static int binarySearch(String[] arr, String key)
    {
        int low = 0;
        int range = arr.length - 1;
        while (low <= range) {
            int mid = low + (range - low) / 2;
            int res = key.compareTo(arr[mid]);
            if (res == 0)
                return mid;
            if (res > 0)
                low = mid + 1;
            else
                range = mid - 1;
        }
        return -1;
    }

    static int binarySearchByInt(String[] arr, int key)
    {
        int low = 0;
        int range = arr.length - 1;
        while (low <= range) {
            int mid = (low + range) / 2;
            if (Integer.parseInt(arr[mid]) == key) {
                return mid;
            } else if (Integer.parseInt(arr[mid]) > key) {
                range = mid - 1;
            } else {
              low = mid + 1;
            }  
        }
        return -1;
    }

    static void resultPrinter(int result) {
        System.out.println("A match was found at index " + result);
        
        if (result > 1) {
            System.out.println("...");
            System.out.println(result - 2 + ", " + animalNames[result - 2] + ", " + animalSpecies[result - 2] + ", " + animalAges[result - 2] + ", " + animalHabitats[result - 2]);
        } if (result > 0)
            System.out.println(result - 1 + ", " + animalNames[result - 1] + ", " + animalSpecies[result - 1] + ", " + animalAges[result - 1] + ", " + animalHabitats[result - 1]);
        System.out.println(result + ", " + animalNames[result] + ", " + animalSpecies[result] + ", " + animalAges[result] + ", " + animalHabitats[result]);
        if (result < animalNames.length - 1)
            System.out.println(result + 1 + ", " + animalNames[result + 1] + ", " + animalSpecies[result + 1] + ", " + animalAges[result + 1] + ", " + animalHabitats[result + 1]);
        if (result < animalNames.length - 2) {
            System.out.println(result + 2 + ", " + animalNames[result + 2] + ", " + animalSpecies[result + 2] + ", " + animalAges[result + 2] + ", " + animalHabitats[result + 1]);
            System.out.println("...");
        }
    }

    //because i decided to store the ages as strings
    //if it's stupid but it works, it's not stupid
    public static void bubbleCorrespondingByInt() {
        String[] arr, arr2, arr3, arr4;
        arr = animalAges;
        arr2 = animalSpecies;
        arr3 = animalNames;
        arr4 = animalHabitats;
        String temp, temp2, temp3, temp4;
        for (int j = 0; j < arr.length; j++) {
            for (int i = j + 1; i < arr.length; i++) {
                if (Integer.parseInt(arr[i]) < Integer.parseInt(arr[j])) {
                    temp = arr[j];
                    temp2 = arr2[j];
                    temp3 = arr3[j];
                    temp4 = arr4[j];
                    arr[j] = arr[i];
                    arr2[j] = arr2[i];
                    arr3[j] = arr3[i];
                    arr4[j] = arr4[i];
                    arr[i] = temp;
                    arr2[i] = temp2;
                    arr3[i] = temp3;
                    arr4[i] = temp4;
                }
            }
        }
    }
}