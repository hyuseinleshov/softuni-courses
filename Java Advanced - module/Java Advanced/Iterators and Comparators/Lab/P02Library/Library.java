package Lab.P01Book.P02Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    public int size() {
        return this.books.length;
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    private class LibIterator implements Iterator<Book> {

        private int counter = 0;

        public LibIterator() {
        }

        @Override
        public boolean hasNext() {
            if (this.counter < size()) {
                return true;
            }

            return false;
        }

        @Override
        public Book next() {
            Book book = getBookAt(counter);
            counter++;
            return book;
        }

    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }
}
