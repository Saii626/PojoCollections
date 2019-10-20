package app.saikat.PojoCollections.CommonObjects;

public class Tuple<X, Y> {
    public X first;

    public Y second;

    public Tuple(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    public static <X, Y> Tuple<X, Y> of(X first, Y second) {
        return new Tuple<X, Y>(first, second);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tuple) {
            Tuple<?, ?> t = (Tuple<?, ?>) obj;
            return (first != null ? first.equals(t.first) : t.first == null)
                    && (second != null ? second.equals(t.second) : t.second == null);
        } else {
            return false;
        }
    }
}