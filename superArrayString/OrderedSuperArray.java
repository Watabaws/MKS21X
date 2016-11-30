public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
        super();
    }

    public OrderedSuperArray(int initialCapacity){
        super(initialCapacity);
    }

    public OrderedSuperArray(String[] ary){
        super(ary.length);
        for(int i = 0;i < ary.length;i++){
            add(ary[i]);
        }
    }

    private int findAHome(String homelessString){
        int ind = 0;
        while(ind < size() && homelessString.compareTo(get(ind)) > 0){
            //System.out.println(homelessString + " vs. " + get(ind));
            ind += 1;
        }
        return ind;
    }

    public String set(int ind, String element){
        throw new UnsupportedOperationException();
    }

    public void add(int ind, String element){
        throw new UnsupportedOperationException();
    }


    private int indexOfHelper(String element,int bot,int up){
        int index = 0, botBound = bot, upBound = size()-1;
        while(upBound >= botBound){
            //System.out.println((upBound+botBound) /2);
            index = (upBound+botBound)/2;
            if(get(index).equals(element)){
                return index;
            }
            else if (get(index).compareTo(element) < 0){
                botBound = index + 1;
            }
            else{
                upBound = index - 1;
            }
        }
        return -1;
    }

    public int indexOf(String element){
        return indexOfHelper(element, 0, size() -1);
    }

    public int lastIndexOf(String element){
        int firIO = indexOf(element);
        while(indexOfHelper(element, firIO + 1, size() -1) != -1){
            firIO++;
        }
        return firIO;
    }

    public boolean add(String elemelon){
        int home = findAHome(elemelon);
        //System.out.println(home + " " + elemelon + " " + size());
        //System.out.println(this);
        super.add(home,elemelon);
        //trimToSize();
        return true;
    }

    /*public static void main(String[] args){
        OrderedSuperArray test1 = new OrderedSuperArray();
        test1.add("hello");
        test1.add("there there");
        test1.add("Waffles");
        test1.add("Pancakes");
        test1.add("French Toast");
        //test1.add(2,"Cereal"); // Should return an error
        System.out.println(test1);
        //test1.set(3,"Sausage"); // Also should return an error
        System.out.println(test1.get(4)); // "there there"
        System.out.println(test1.indexOf("French Toast")); // "0"
        test1.add("hello");
        System.out.println(test1.lastIndexOf("hello")); // "4"

        String[] tempTest = new String[14];
        tempTest[0] = "Glock"; tempTest[1] = "Apple"; tempTest[2] = "Carrot"; tempTest[3] = "Eggplant"; tempTest[4] = "Firecracker"; tempTest[5] = "Bazinga"; tempTest[6] = "Donkey";tempTest[7] = "Glock"; tempTest[8] = "Apple"; tempTest[9] = "Carrot"; tempTest[10] = "Eggplant"; tempTest[11] = "Firecracker"; tempTest[12] = "Bazinga"; tempTest[13] = "Donkey";
        OrderedSuperArray test2 = new OrderedSuperArray(tempTest);
        System.out.println(test2);

        for(int i = 0; i < tempTest.length;i++){
            System.out.println(tempTest[i]);
            System.out.println(test2.indexOf(tempTest[i]));
        }

        System.out.println("");

        for(int i = 0; i < tempTest.length;i++){
            System.out.println(tempTest[i]);
            System.out.println(test2.lastIndexOf(tempTest[i]));
        }

    }*/




}
