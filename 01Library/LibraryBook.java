public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String author, String title, String ISBN, String CallNum){
        super(author, title, ISBN);
        setCallNumber(CallNum);
    }

    public String getCallNumber(){
        return callNumber;
    }

    public void setCallNumber(String callNum){
        callNumber = callNum;
    }

    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();

    public int compareTo(LibraryBook l){
        return callNumber.compareTo(l.callNumber);
    }

    public String toString(){
        return super.toString() + ", " + circulationStatus() + ", " + callNumber;
    }
}
