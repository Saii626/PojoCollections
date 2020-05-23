package app.saikat.PojoCollections.CommonObjects;

public interface Copyable<T extends Copyable<T>> {

	T copy();
	
}