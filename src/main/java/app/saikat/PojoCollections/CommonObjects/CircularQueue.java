package app.saikat.PojoCollections.CommonObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class CircularQueue<T> {

	private final List<T> list;
	private final int MAX_SIZE;
	private int index;
	private int size;

	public CircularQueue(int size) {
		this.list = Collections.synchronizedList(new ArrayList<>(size));
		this.index = 0;
		this.size = 0;
		this.MAX_SIZE = size;
	}

	public void put(T t) {
		synchronized (list) {
			list.add(index, t);
			++index;

			size = size == MAX_SIZE ? MAX_SIZE : ++size;
			if (index == MAX_SIZE) index = 0;
		}
	}

	public void forEach(Consumer<? super T> consumer) {
		list.forEach(consumer);
	}

	public T reduce(BinaryOperator<T> operation) {
		return list.stream().reduce(operation).orElseThrow(() -> new NoSuchElementException());
	}
}