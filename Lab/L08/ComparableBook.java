
public class ComparableBook implements Comparable <ComparableBook> {
    private int ISBN;
    private String title;

    public ComparableBook(int ISBN, String title) {
        this.ISBN = ISBN;
        this.title = title;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public int compareTo(ComparableBook c){
        return this.getTitle().compareTo(c.getTitle());
    }
    
    @Override
    public String toString(){
        return ISBN + " - " + title;
    }
    
    
    
    
}
