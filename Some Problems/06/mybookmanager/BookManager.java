package hus.oop.mybookmanager;

public class BookManager {
    private static BookManager instance;
    private MyList bookList;

    private BookManager() {
        /* TODO */
        bookList = new MyLinkedList();
    }

    public static BookManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    public MyList getBookList() {
        /* TODO */
        return bookList;
    }

    /**
     * Thêm book vào đầu danh sách.
     * @param book
     */
    public void insertAtStart(Book book) {
        /* TODO */
        bookList.insertAtStart(book);
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void insertAtEnd(Book book) {
        /* TODO */
        bookList.insertAtEnd(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void insertAPosition(Book book, int index) {
        /* TODO */
        bookList.insertAtPosition(book, index);
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        bookList.remove(index);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        /* TODO */
        return (Book) bookList.get(index);
    }

    /**
     * Lấy ra sách có giá cao nhất.
     * @return
     */
    public Book highestPriceBook() {
        MyIterator iterator = bookList.iterator();
        Book book = (Book) bookList.get(0);
        double highestPrice = book.getPrice();
        while (iterator.hasNext()) {
            Book currentBook = (Book) iterator.next();
            if (currentBook.getPrice() > highestPrice) {
                highestPrice = currentBook.getPrice();
                book = currentBook;
            }
        }
        return book;
    }

    /**
     * Lấy ra sách có giá thấp nhất.
     * @return
     */
    public Book lowestPriceBook() {
        MyIterator iterator = bookList.iterator();
        Book book = (Book) bookList.get(0);
        double lowestPrice = book.getPrice();
        while (iterator.hasNext()) {
            Book currentBook = (Book) iterator.next();
            if (currentBook.getPrice() < lowestPrice) {
                lowestPrice = currentBook.getPrice();
                book = currentBook;
            }
        }
        return book;
    }

    /**
     * Lấy ra sách có số trang cao nhất.
     * @return
     */
    public Book highestNumberOfPagesBook() {
        MyIterator iterator = bookList.iterator();
        Book book = (Book) bookList.get(0);
        double highestNumberOfPage = book.getPages();
        while (iterator.hasNext()) {
            Book currentBook = (Book) iterator.next();
            if (currentBook.getPages() > highestNumberOfPage) {
                highestNumberOfPage = currentBook.getPages();
                book = currentBook;
            }
        }
        return book;
    }

    /**
     * Lấy ra sách có số trang thấp nhất.
     * @return
     */
    public Book lowestNumberOfPagesBook() {
        MyIterator iterator = bookList.iterator();
        Book book = (Book) bookList.get(0);
        double lowestNumberOfPage = book.getPages();
        while (iterator.hasNext()) {
            Book currentBook = (Book) iterator.next();
            if (currentBook.getPages() < lowestNumberOfPage) {
                lowestNumberOfPage = currentBook.getPages();
                book = currentBook;
            }
        }
        return book;
    }

    /**
     * Lọc ra những book theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public MyList filterBooksOfPublisher(String publisher) {
        /* TODO */
        MyList filteredList = new MyLinkedList();
        MyIterator iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book currentBook = (Book) iterator.next();
            if (currentBook.getPublisher().equals(publisher)) {
                filteredList.insertAtEnd(currentBook);
            }
        }
        return filteredList;
    }

    /**
     * Lọc ra những book theo thể loại.
     * @param genre
     * @return
     */
    public MyList filterBooksOfGenre(String genre) {
        /* TODO */
        MyList filteredList = new MyLinkedList();
        MyIterator iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book currentBook = (Book) iterator.next();
            if (currentBook.getGenre().equals(genre)) {
                filteredList.insertAtEnd(currentBook);
            }
        }
        return filteredList;
    }

    /**
     * Lọc ra những book theo tác giả.
     * @param author
     * @return
     */
    public MyList filterBooksOfAuthor(String author) {
        /* TODO */
        MyList filteredList = new MyLinkedList();
        MyIterator iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book currentBook = (Book) iterator.next();
            if (currentBook.getAuthor().equals(author)) {
                filteredList.insertAtEnd(currentBook);
            }
        }
        return filteredList;
    }

    public static String titleOfBooksToString(MyList bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            titleOfBooks.append(book.getTitle()).append("\n");
        }
        return titleOfBooks.toString().trim() + "\n]";
    }

    public static void print(MyList bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            booksString.append(book.toString()).append("\n");
        }
        System.out.print(booksString.toString().trim() + "\n]");
    }
}
