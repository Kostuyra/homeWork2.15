package org.example;
import org.example.exception.ElementNotFoundException;
import org.example.exception.FullException;
import org.example.exception.InvalidIndexExeption;
import org.example.exception.NullItemException;

import java.util.Arrays;


public class NewArrayList implements IntegerList {

	private final Integer[] integers;
	private int size;


	public NewArrayList() {
		integers = new Integer[10];
	}

	public NewArrayList(int sizeArray) {
		integers = new Integer[sizeArray];
	}

	@Override
	public Integer add(Integer item) {
		isNull(item);
		validateSize();
		integers[size++] = item;
		return item;
	}

	@Override
	public Integer add(int index, Integer item) {
		validateSize();
		isNull(item);
		validateIndex(index);
		if (index == size) {
			integers[size++] = item;
			return item;
		}
		System.arraycopy(integers, index, integers, index + 1, size - index);
		integers[index] = item;
		size++;
		return item;
	}

	@Override
	public Integer set(int index, Integer item) {
		isNull(item);
		validateIndex(index);
		integers[index] = item;
		return item;
	}

	@Override
	public Integer remove(Integer item) {
		isNull(item);
		int index = indexOf(item);
		if (index == -1){
			throw new ElementNotFoundException();
		}
		removeIndex(index);
		return item;
	}

	@Override
	public Integer removeIndex(int index) {
		validateIndex(index);
		Integer item = integers[index];
		if (index != size) {
			System.arraycopy(integers, index+1, integers, index, integers.length - index - 1);
		}
		size--;
		return item;
	}

	@Override
	public boolean contains(Integer item) {
		Integer[] listCopy = toArray();
		fastedSort(listCopy);
		return binarySearch(listCopy, item);
	}

	@Override
	public int indexOf(Integer item) {
		for (int i = 0; i < size; i++) {
			if (integers[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Integer item) {
		for (int i = size - 1; i >= 0; i--) {
			if (integers[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Integer get(int index) {
		validateIndex(index);
		return integers[index];
	}

	@Override
	public boolean equals(IntegerList otherList) {
		if (otherList == null) {
			throw new NullItemException();
		}
		return Arrays.equals(this.toArray(), otherList.toArray());
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public Integer[] toArray() {
		return Arrays.copyOf(integers, size);
	}

	private void fastedSort(Integer arr[]){
		Sorts.insertionSort(arr);
	}

	private boolean binarySearch(Integer[] arr, Integer item){
		int min = 0;
		int max = arr.length - 1;

		while (min <= max) {
			int mid = (min + max) / 2;

			if (item == arr[mid]) {
				return true;
			}

			if (item < arr[mid]) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return false;
	}
	private void isNull(Integer item) {
		if (item == null) {
			throw new NullItemException();
		}
	}

	private void validateSize() {
		if (size == integers.length) {
			throw new FullException();
		}
	}

	private void validateIndex(int index) {
		if (index < 0 || index > size) {
			throw new InvalidIndexExeption();
		}
	}

}
