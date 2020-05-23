package app.saikat.PojoCollections.CommonObjects;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public final class Either<L, R> implements Copyable<Either<L, R>> {
	public static <L, R> Either<L, R> left(L value) {
		return new Either<>(Optional.of(value), Optional.empty());
	}

	public static <L, R> Either<L, R> right(R value) {
		return new Either<>(Optional.empty(), Optional.of(value));
	}

	private final Optional<L> left;
	private final Optional<R> right;

	private Either(Optional<L> l, Optional<R> r) {
		left = l;
		right = r;
	}

	public <T> Either<T, R> mapLeft(Function<? super L, ? extends T> lFunc) {
		return new Either<>(left.map(lFunc), right);
	}

	public <T> Either<L, T> mapRight(Function<? super R, ? extends T> rFunc) {
		return new Either<>(left, right.map(rFunc));
	}

	public <RES> RES apply(Function<? super L, ? extends RES> lFunc, Function<? super R, ? extends RES> rFunc) {
		if (containsLeft()) {
			return lFunc.apply(left.get());
		} else {
			return rFunc.apply(right.get());
		}
	}

	public void consume(Consumer<? super L> lFunc, Consumer<? super R> rFunc) {
		if (containsLeft()) {
			lFunc.accept(left.get());
		} else {
			rFunc.accept(right.get());
		}
	}

	public boolean containsLeft() {
		return left.isPresent();
	}

	public boolean containsRight() {
		return right.isPresent();
	}

	public Optional<L> getLeft() {
		return left;
	}

	public Optional<R> getRight() {
		return right;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Either<>(left, right);
	}

	@Override
	public Either<L, R> copy() {
		return new Either<>(left, right);
	}

	@Override
	public String toString() {
		return this.apply(l -> "L(" + left.get() + ")", r -> "R(" + right.get() + ")");
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && Either.class.isAssignableFrom(obj.getClass())) {
			Either<?, ?> e = (Either<?,?>) obj;
			return left.equals(e.left) && right.equals(e.right);
		} 
		return false;
	}
}