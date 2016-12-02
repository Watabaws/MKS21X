public class ReferenceBook extends LibraryBook{
    private String collection;

    public ReferenceBook(String author, String title, String ISBN, String CallNum, String collect){
        super(author, title, ISBN, CallNum);
        setCollection(collect);
    }

    public void setCollection(String collect){
        collection = collect;
    }

    public String getCollection(){
        return collection;
    }

    public void checkout(String patron, String dues){
        System.out.println("Cannot check out reference book");
    }

    public void returned(){
        System.out.println("Refernce book could not have been checked out -- return impossible");
    }

    public String circulationStatus(){
        return "Non-circulating reference book";
    }

    public String toString(){
        return super.toString() + ", " + collection;
    }
}
