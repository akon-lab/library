package comparators;

import models.BookModel;

import java.util.Comparator;

public class BookCopyComparator implements Comparator<BookModel> {
    @Override
    public int compare(BookModel o1, BookModel o2) {
        return o1.getCopy()-o2.getCopy();
    }
}
