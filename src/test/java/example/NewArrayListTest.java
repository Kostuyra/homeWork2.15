package example;

import org.example.NewArrayList;
import org.example.exception.*;


import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import static example.Constants.*;
import static org.junit.jupiter.api.Assertions.*;


class NewArrayListTest {
	private final NewArrayList out = new NewArrayList(3);
	@Test
	void testAddItem() {
		Assertions.assertEquals(INT, out.add(INT));
		Assertions.assertNotEquals(out, TEST);
	}

	@Test
	void testAddItemOnIndex() {
		Assertions.assertEquals(out.add(0, INT1), INT1);
	}

	@Test
	void set() {
		out.add(INT);
		out.add(INT1);
		Assertions.assertEquals(out.set(1, INT2), INT2);
	}

	@Test
	void testRemoveElement() {
		out.add(INT);
		out.add(INT1);
		Assertions.assertEquals(out.remove(INT1), INT1);
	}

	@org.junit.jupiter.api.Test
	void testRemoveElementOnIndex() {
		out.add(INT);
		out.add(INT1);
		Assertions.assertEquals(out.removeIndex(1), INT1);
	}

	@Test
	void testContains() {
		out.add(INT);
		out.add(INT1);
		Assertions.assertTrue(out.contains(INT1));
		Assertions.assertFalse(out.contains(INT2));
	}

	@Test
	void testIndexOf() {
		out.add(INT);
		out.add(INT1);
		Assertions.assertEquals(1, out.indexOf(INT1));
		Assertions.assertEquals(-1, out.indexOf(INT2));
	}

	@Test
	void testLastIndexOf() {
		out.add(INT);
		out.add(INT1);
		Assertions.assertEquals(1, out.lastIndexOf(INT1));
		Assertions.assertEquals(-1, out.lastIndexOf(INT2));
	}

	@Test
	void testGet() {
		out.add(INT);
		out.add(INT1);
		out.add(INT2);
		Assertions.assertEquals(INT1, out.get(1));
	}

	@Test
	void testEquals() {
		out.add(INT);
		out.add(INT1);
		out.add(INT2);
		TEST.add(INT);
		TEST.add(INT1);
		TEST.add(INT2);
		Assertions.assertTrue(out.equals(TEST));
		out.removeIndex(0);
		Assertions.assertFalse(out.equals(TEST));
	}

	@Test
	void size() {
		out.add(INT);
		out.add(INT1);
		out.add(INT2);
		Assertions.assertEquals(3, out.size());
	}

	@Test
	void isEmpty() {
		Assertions.assertTrue(out.isEmpty());
		out.add(INT);
		Assertions.assertFalse(out.isEmpty());
	}

	@Test
	void clear() {
		out.add(INT);
		out.add(INT1);
		out.add(INT2);
		out.clear();
		Assertions.assertEquals(0, out.size());
	}

	@Test
	void toArray() {
		out.add(INT);
		out.add(INT1);
		out.add(INT2);
		Assertions.assertArrayEquals(INTEGER_TEST, out.toArray());
	}
	@Test
	void shouldElementNotFoundException(){
		out.add(INT);
		out.add(INT1);
		out.add(INT2);
		assertThrowsExactly(ElementNotFoundException.class, ()-> out.remove(INT3));
	}

	@Test
	void shouldFullException(){
		out.add(INT);
		out.add(INT1);
		out.add(INT2);
		assertThrowsExactly(FullException.class, ()-> out.add(INT3));
		assertThrowsExactly(FullException.class, ()-> out.add(3, INT3));
	}

	@Test
	void shouldInvalidIndexException(){
		out.add(INT);
		out.add(INT1);
		assertThrowsExactly(InvalidIndexExeption.class, ()-> out.removeIndex(3));
		assertThrowsExactly(InvalidIndexExeption.class, ()-> out.removeIndex(-1));
	}
	@Test
	void shouldNullItemException(){
		out.add(INT);
		out.add(INT1);
		assertThrowsExactly(NullItemException.class, ()-> out.add(null));

	}

}