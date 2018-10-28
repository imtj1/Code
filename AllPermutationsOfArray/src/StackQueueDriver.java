public class StackQueueDriver {
    private static String suitName[] = {"DIAMOND", "CLUB", "HEART", "SPADE"};
    private static String rankName[] = {"ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};

    public static void main(String[] args) throws Exception {

        IntegerStack integerStack = new IntegerStack(52);

        System.out.println("\n\n==================Inserting all cards into stack===================");
        insertAllCardsToStack(integerStack);

        IntegerQueue integerQueue = new IntegerQueue(52);

        System.out.println("\n\n==================Inserting all cards into queue===================");
        insertAllCardsToQueue(integerQueue);

        while (!integerQueue.isEmpty()) {
            int cardNumber = integerQueue.de_queue();
            System.out.println("De-queueing " + getCardNameFromNumber(cardNumber) + " from stack");
        }

        System.out.println("\n\n==================Queueing popped cards from stack into queue for reverse order===================");
        while (!integerStack.isEmpty()) {
            int cardNumber = integerStack.pop();
            System.out.println("Popped card from stack : " + getCardNameFromNumber(cardNumber));
            integerQueue.enqueue(cardNumber);
            System.out.println("Enqueueing : " + getCardNameFromNumber(cardNumber) + " into queue");
        }

        System.out.println("\n\n=================De-queueing cards from queue to demonstrate reverse order===================");
        while (!integerQueue.isEmpty()) {
            int cardNumber = integerQueue.de_queue();
            System.out.println("De-queueing " + getCardNameFromNumber(cardNumber) + " from stack");
        }
    }

    private static void insertAllCardsToStack(IntegerStack integerStack) {
        for (int cardNumber = 1; cardNumber < 52; cardNumber++) {
            System.out.println("Pushing " + getCardNameFromNumber(cardNumber) + " to stack");
            integerStack.push(cardNumber);
        }
    }

    private static void insertAllCardsToQueue(IntegerQueue integerQueue) throws Exception {
        for (int cardNumber = 1; cardNumber < 52; cardNumber++) {
            System.out.println("Enqueueing " + getCardNameFromNumber(cardNumber) + " to queue");
            integerQueue.enqueue(cardNumber);
        }
    }

    private static String getCardNameFromNumber(int cardNumber) {
        return rankName[(cardNumber - 1) % 13] + " of " + suitName[(cardNumber - 1) % 4];
    }
}
