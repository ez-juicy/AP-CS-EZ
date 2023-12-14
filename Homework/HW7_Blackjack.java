import java.util.*;

public class HW7_Blackjack {
    static Scanner s = new Scanner(System.in);
    static ArrayList<Integer> userHand = new ArrayList<>();
    static ArrayList<Integer> dealerHand = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            distribute(userHand);
            distribute(dealerHand);
        }

        System.out.println("User's hand: " + userHand);
        System.out.println("Dealer's hand: [" + dealerHand.get(0) + ", *]");

        turn(userHand);

        turn(dealerHand);

        compete(userHand, dealerHand);
    }

    public static void distribute(ArrayList<Integer> hands) {
        Random r = new Random();
        int card = r.nextInt(10) + 2;
        hands.add(card);
    }

    public static void turn(ArrayList<Integer> playerHand) {
        int sum = getHandTotal(playerHand);

        while (sum < 21) {
            System.out.println("Do you still want to hit? (yes/no): ");
            String choice = s.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                distribute(playerHand);
                sum = getHandTotal(playerHand);
                System.out.println("Player's hand: " + playerHand);
            } else {
                break;
            }
        }

        if (sum > 21) {
            System.out.println("Busted!");
        }
    }

    public static void compete(ArrayList<Integer> userHand, ArrayList<Integer> dealerHand) {
        int userSum = getHandTotal(userHand);
        int dealerSum = getHandTotal(dealerHand);

        System.out.println("Player's total: " + userSum);
        System.out.println("Dealer's total: " + dealerSum);

        if (userSum > 21 || (dealerSum <= 21 && dealerSum >= userSum)) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("Player wins!");
        }
    }

    public static int getHandTotal(ArrayList<Integer> hand) {
        int total = 0;
        int numAces = 0;

        for (int card : hand) {
            if (card == 11) {
                numAces++;
            }
            total += card;
        }

        // Adjust for Aces
        while (total > 21 && numAces > 0) {
            total -= 10;
            numAces--;
        }

        return total;
    }
}
