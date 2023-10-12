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
		  while (!stackS.isEmpty()) {
        E element = stackS.pop();
        dequeD.addLast(element);
      }

      while (!stackT.isEmpty()) {
        E element = stackT.pop();
        dequeD.addLast(element);
        
      }

      while (!dequeD.isEmpty()) {
        E element = dequeD.removeLast();
        stackS.push(element);
      }
    }

    /* Print elements in stackS */
    public void printElements() {
      while (!stackS.isEmpty()) {
        E element = stackS.pop();
        System.out.println(element);
      }
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
