package Lab6.tdd;

import junit.framework.TestCase;

public class TestMovieList extends TestCase {

	public void testEmptyListSize() {
		MovieList emptyList = new MovieList();
		assertEquals("Size of empty movie list should be 0.", 0, emptyList.size());
	}

	public void testSizeAfterAddingOne() {
		Movie starWars = new Movie("Star Wars");
		MovieList oneItemList = new MovieList();
		oneItemList.add(starWars);
		assertEquals("Size of one item list should be 1.", 1, oneItemList.size());
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestMovieList.class);
	}
}