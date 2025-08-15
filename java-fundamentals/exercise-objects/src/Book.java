public class Book {
    private String title;
    private String author;
    public boolean isAvailable;


    /*
    -------------------
    CONSTRUCTORS
    -------------------
     */
    public Book(){

    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public Book(String title, String author, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }


    /*
    -------------------
    GETTERS & SETTERS
    -------------------
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /*
    -------------------
    CUSTOM METHODS
    -------------------
     */
    public void borrowBook(){
        this.isAvailable = false;
    }


}
