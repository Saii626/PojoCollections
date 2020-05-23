package app.saikat.PojoCollections.Utils;

import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

public class CommonFunc {

	public static <T> void safeAdd(Set<T> collection, T item) {
		synchronized (collection) {
			collection.add(item);
		}
	}

	public static <K, V> void addToMapSet(Map<K, Set<V>> map, K key, V item) {
		map.compute(key, (k, v) -> {

			if (v == null) {
				v = new HashSet<>();
			}

			v.add(item);

			return v;
		});
	}

	public static <K, V> void safeAddToMapSet(Map<K, Set<V>> map, K key, V item) {
		map.compute(key, (k, v) -> {

			if (v == null) {
				v = Collections.synchronizedSet(new HashSet<>());
			}
			
			v.add(item);
			return v;
		});
	}

	public static <K, V> void safeRemoveFromMapSet(Map<K, Set<V>> map, K key, V item) {
		map.compute(key, (k, v) -> {

			if (v == null) {
				throw new NullPointerException("No value corrosponding to key " + key.toString());
			}
			
			if (!v.remove(item)) {
				throw new NullPointerException("No item " + item.toString() + " in the set");
			}

			return v;
		});
	}
}