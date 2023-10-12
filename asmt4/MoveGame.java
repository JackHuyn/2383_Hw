public class MoveGame<E> {
    public DeqStack<E> stackS;
    public DeqStack<E> stackT;
    public DListDeque<E> dequeD;

    public MoveGame() {
        stackS = new DeqStack<>();
        stackT = new DeqStack<>();
        dequeD = new DListDeque<>();
    }

    /* Move elements as required */
    public void moveElements() {
		// to be completed
    }

    /* Print elements in stackS */
    public void printElements() {
		// to be completed
    }

    public static void main(String[] args) {
        MoveGame<Integer> testGame = new MoveGame<>();
        testGame.stackS.push(4);
        testGame.stackS.push(5);

        testGame.stackT.push(6);
        testGame.stackT.push(7);
        testGame.stackT.push(8);
        testGame.stackT.push(9);

        testGame.moveElements();
        testGame.printElements();
    }
}
