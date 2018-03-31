/*Sedak Puri
 * Lab02
 * Intro to CS 3
 * Note: I worked a little bit with Evan Gill on this lab
 */

import java.util.Random;
public class Driver {

	public static void main(String[] args) {
		Random rng = new Random();
		int randomGuide, value;
		CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<Integer>();
		list.printList();
		System.out.println();
		
		//Adding Values 1-10 to list
		for(int i = 1; i <= 10; i++) {
			list.addAfterCursor(i);
		}
		list.printList();
		System.out.println();

		//Lottery Simulation 
		while(list.getSize() != 0) {
			list.advanceCursor(rng.nextInt(list.getSize()) + 1);
			value = list.deleteCursor();
			System.out.println("\nThe random value that was selected and removed was: " + value);
			list.printList();
			System.out.println();
		}
	}

}
