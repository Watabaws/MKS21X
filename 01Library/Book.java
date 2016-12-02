public class Book{
    private String author, title, ISBN;

    public Book(){}

    public Book(String auth, String titl, String code){
        setAuthor(auth);
        setTitle(titl);
        setISBN(code);
    }

    public void setAuthor(String auth){
        author = auth;
    }
    public void setTitle(String titl){
        title = titl;
    }
    public void setISBN(String code){
        ISBN = code;
    }

    public String getAuthor(){
        return author;
    }
    public String getTitle(){
        return title;
    }
    public String getISBN(){
        return ISBN;
    }

    public String toString(){
        return title + ", " + author + ", " + ISBN;
    }

}
