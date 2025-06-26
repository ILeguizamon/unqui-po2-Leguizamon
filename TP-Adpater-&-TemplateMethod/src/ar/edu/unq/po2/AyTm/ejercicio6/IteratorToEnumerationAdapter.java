package ar.edu.unq.po2.AyTm.ejercicio6;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorToEnumerationAdapter<E> implements Enumeration<E> {
    private Iterator<E> iterator;

    public IteratorToEnumerationAdapter(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public E nextElement() {
        return iterator.next();
    }
}
