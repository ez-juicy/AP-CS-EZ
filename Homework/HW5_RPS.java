import java.util.*;

public class HW5_RPS {
    static Scanner s = new Scanner(System.in);
    static ArrayList<String> compChoice = new ArrayList<String>();
    static ArrayList<String> userChoice = new ArrayList<String>();

    public static void main(String[] args) {

        System.out.println("Would you like to play Bo1, Bo3, or Bo5 of RPS");
        int round = dataValidation();

        System.out.println("Rock Paper Scissors");
        System.out.println("R for rock, P for paper, S for Scissors");

        int i = 1;
        while (i <= round) {
            System.out.printf("What is your choice for round %d: ", i);
            String userInput = dataVali();
            userChoice.add(userInput);
            compChoice.add(choice());
            i++;
        }

        RPS(userChoice, compChoice, round);
        System.out.println(compChoice);
    }

    public static void RPS(ArrayList<String> userChoice, ArrayList<String> compChoice, int round) {
        int uWin = 0;
        int cWin = 0;

        if (userChoice.size() != compChoice.size()) {
            System.out.println("Error: ArrayList sizes do not match.");
            return;
        }

        for (int i = 0; i < Math.min(userChoice.size(), compChoice.size()); i++) {
            String compMove = compChoice.get(i);
            String userMove = userChoice.get(i);

            switch (compMove) {
                case "R":
                    if (userMove.equals("S")) {
                        cWin++;
                        break;
                    } else if (userMove.equals("R")) {
                        cWin++;
                        uWin++;
                    } else if (userMove.equals("P")) {
                        uWin++;
                    }
                    break;

                case "S":
                    if (userMove.equals("P")) {
                        cWin++;
                        break;
                    } else if (userMove.equals("S")) {
                        cWin++;
                        uWin++;
                    } else if (userMove.equals("R")) {
                        uWin++;
                    }
                    break;

                case "P":
                    if (userMove.equals("R")) {
                        cWin++;
                        break;
                    } else if (userMove.equals("P")) {
                        cWin++;
                        uWin++;
                    } else if (userMove.equals("S")) {
                        uWin++;
                    }
                    break;

                default:
                    break;
            }
        }

        System.out.printf("user score: %d; computer score: %d %n", uWin, cWin);

        if (uWin > cWin) {
            System.out.println("You win!");
        } else if (cWin > uWin) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static String choice() {

        Random r = new Random();

        String[] options = {"P", "R", "S"};

        int randomIndex = r.nextInt(options.length);

        return options[randomIndex];
    }

    public static String dataVali() {

        String input = "";
        boolean isInputString = false;
        while (!isInputString) {
            input = s.nextLine().toUpperCase();
            if (input.equals("S") || input.equals("R") || input.equals("P")) {
                isInputString = true;
            } else {
                System.out.println("Please give me a valid input");
            }
        }
        return input.toUpperCase();
    }

    public static int dataValidation() {

        int input = -1;
        boolean isInputInty = false;
        while (!isInputInty) {
            try {

                input = Integer.parseInt(s.nextLine());

                if (!(input == 1 || input == 3 || input == 5)) {
                    throw new Exception("Your number should be a valid integer");
                }

                isInputInty = true;

            } catch (Exception e) {
                System.out.println("Give me a valid integer");
            }

        }
        return input;
    }
}
