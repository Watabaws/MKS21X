public class CirculatingBook extends LibraryBook{
    String currentHolder, dueDate;

    public CirculatingBook(String title, String author, String ISBN, String CallNum){
        super(title, author, ISBN, CallNum);
        setCurrentHolder(null);
        setDueDate(null);
    }

    public String getCurrentHolder(){
        return currentHolder;
    }
    public String getDueDate(){
        return dueDate;
    }

    public void setCurrentHolder(String holder){
        currentHolder = holder;
    }
    public void setDueDate(String date){
        dueDate = date;
    }

    public void checkout(String patron, String due){
        currentHolder = patron;
        dueDate = due;
    }

    public void returned(){
        currentHolder = null;
        dueDate = null;
    }

    public String circulationStatus(){
        if(currentHolder != null){
            return currentHolder + ", " + dueDate;
        }
        else{
            return "Book available on shelves";
        }
    }
}
