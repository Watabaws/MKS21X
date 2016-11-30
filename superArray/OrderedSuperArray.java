public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
        super();
    }

    public OrderedSuperArray(int initialCapacity){
        super(initialCapacity);
    }

    public OrderedSuperArray(int[] ary){
        super(ary.length);
        for(int i = 0;i < ary.length;i++){
            add(ary[i]);
        }
    }

    private int findAHome(int value){
        int ind = 0;
        while(ind < size() && value > get(ind)){
            //System.out.println(value + " vs. " + get(ind));
            ind += 1;
        }
        return ind;
    }


    public int set(int ind, int element){
        throw new UnsupportedOperationException();
    }

    public void add(int ind, int element){
        throw new UnsupportedOperationException();
    }

    public boolean add(int elemelon){
        int home = findAHome(elemelon);
        //System.out.println(home + " " + elemelon + " " + size());
        //System.out.println(this);
        super.add(home,elemelon);
        //trimToSize();
        System.out.println(size());
        return true;
    }

    public static void main(String[] args){
        OrderedSuperArray test1 = new OrderedSuperArray();
        test1.add(3);
        test1.add(1);
        test1.add(10);
        test1.add(7);
        test1.add(6);
        test1.add(15);
        test1.add(8);
        test1.add(6);
        System.out.println(test1);
        int[]param = new int[10];
        for(int i = 0; i < param.length;i++){
            param[i] = (int)(Math.random() * 500);
        }
        OrderedSuperArray test2 = new OrderedSuperArray(param);
        System.out.println(test2);
    }


    if (get(middle).compareTo(get(middle-1)) == 0 && begin != 0){
    		    begin--;
    		    end --;
    		}
}
