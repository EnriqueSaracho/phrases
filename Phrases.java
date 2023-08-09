import java.util.Scanner;
import java.io.File;

public class Phrases {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int option;
        int person = 0;
        do {
            option = getOption(input, person);
            switch (option) {
                case 1:
                    person = choosePerson(input);
                    break;
                case 2:
                    printPhrases(person);
                    break;
            }
        } while (option != 0);

        input.close();
    }

    public static void printPhrases(int person) throws Exception {
        File file;
        if (person == 1)
            file = new File("./mom.txt");
        else
            file = new File("./dad.txt");

        if (!file.canRead()) {
            System.out.println("ERROR: Permision to read from file denied");
            System.exit(1);
        }

        Scanner inputFile = new Scanner(file);
        while (inputFile.hasNext()) {
            System.out.println(inputFile.nextLine());
        }
        inputFile.close();

    }

    public static int choosePerson(Scanner input) {
        int person;
        boolean flag = false;

        do {
            if (flag)
                System.out.println("ERROR: Invalid input");
            System.out.println();
            System.out.println("1 - Mom");
            System.out.println("2 - Dad");
            System.out.print("Choose one (1-2): ");
            person = input.nextInt();
            flag = true;
        } while (person < 1 || person > 2);

        return person;
    }

    public static int getOption(Scanner input, int person) {
        int option;
        boolean flag = false;

        printMenu(person);
        do {
            if (flag)
                System.out.println("ERROR: Invalid input");
            System.out.print("Enter a number to choose an option (0-3): ");
            option = input.nextInt();
            flag = true;
        } while (option < 0 || option > 3);

        return option;
    }

    public static void printMenu(int person) {
        System.out.println();
        System.out.println("                    Phrases                    ");
        System.out.println("-----------------------------------------------");
        System.out.printf("Current phrases: %s\n", person == 0 ? "none" : person == 1 ? "mom" : "dad");
        System.out.println("1 - Choose a person's phrases");
        System.out.println("2 - Show phrases");
        System.out.println("3 - Add a phrase");
        System.out.println("0 - Exit program");
    }
}