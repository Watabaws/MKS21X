import java.util.Iterator;
import java.util.NoSuchElementException;
public class SuperArrayIterator implements Iterator{
    private int ctr = 0;
    private SuperArray iterThrough;

    public SuperArrayIterator(SuperArray l){
        iterThrough = l;
    }

    public boolean hasNext(){
        return ctr < iterThrough.size();
    }

    public String next(){
        if(hasNext()){
            return iterThrough.get(ctr++);
        }
        else{
            throw new NoSuchElementException();
        }
    }

    public void remove(){
        throw new UnsupportedOperationException();
    }



}
