
public class SuperArray{
    private String[] data;
    private int size = 0;

    public SuperArray(){
        data = new String[10];
    }

    public SuperArray(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
        }
        data = new String[initialCapacity];
    }

    public void checkIndex(int ind, int size){
        if(ind < 0 || ind > size){
            throw new IndexOutOfBoundsException();
        }
    }

    public int size(){
        return size;
    }

    public String get(int ind){
        checkIndex(ind, size);
        return data[ind];
    }

    public boolean add(String str){
        if (size == data.length){
            grow();
        }
        data[size] = str;
        size++;
        return true;
    }

    public void clear(){
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int ind, String element){
        if(ind < 0 || ind > size()){
            throw new IndexOutOfBoundsException();
        }
        if(size + 1 == data.length){
            grow();
        }
        //System.out.println("Length is: " + data.length);
        //System.out.println("Ind is: " + ind);
        //System.out.println("Size is: " + size);
        //System.out.println("Data is: " + toArray());
        for(int i = size-1;i >= ind;i--){
            //System.out.println("i is: " + i);
            data[i+1] = data[i];
        }
        data[ind] = element;

        size++;
        //System.out.println(" ");
    }

    public void remove(int ind){
        checkIndex(ind, size);
        for(int i = ind;i < size;i++){
            data[i] = data[i+1];
        }
        size--;
    }

    public String set(int ind, String element){
        checkIndex(ind, size);
        String toRet = data[ind];
        data[ind] = element;
        return toRet;
    }

    public String[] toArray(){
        String[] retAr = new String[size];
        for(int i = 0; i < size;i++){
            retAr[i] = data[i];
        }
        return retAr;
    }


    public int indexOf(String element){
        for(int i = 0; i < size; i++){
            if(data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String element){
        for(int i = size-1; i < size; i--){
            if(data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    /*public void removeByInt(int n){
        for(int i = 0; i < size;i++){
            if(data[i] == n){
                removeByInd(i);
                i = size;
            }
        }
    }*/

    private void grow(){
        String[] temp = new String[data.length*2+1];
        for(int i = 0; i < data.length;i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    public void trimToSize(){
        String[] temp = new String[size];
        for(int i = 0; i < size;i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    public String toString(){
        String retStr = "[" + data[0] + ", ";
        for(int i = 1;i < size;i++){
            retStr += data[i] + ", ";
        }
        return retStr + "]";
    }

    public String toStringDebug(){
        String retStr = "[";
        for(int i = 0;i < data.length - 1;i++){
            if(i < size){
                retStr += data[i] + ", ";
            }
            else{
                retStr += "_, ";
            }
        }
        return retStr + "]";
    }

    /*public static void main(String[] args){
        SuperArray test1 = new SuperArray();
        test1.add("hello");
        test1.add("there there");
        test1.add("Waffles");
        test1.add("Pancakes");
        test1.add("French Toast");
        test1.add(2,"Cereal");
        System.out.println(test1);
        test1.set(3,"Sausage");
        System.out.println(test1);
        System.out.println(test1.get(4));
        System.out.println(test1.indexOf("French Toast"));
        test1.add("hello");
        System.out.println(test1.lastIndexOf("hello"));



    }*/
}
