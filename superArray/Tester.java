public class Tester{

    public static boolean testAdd1(SuperArray supAr, int n){
        int oldSize = supAr.size();
        supAr.add(n);
        int[] added = supAr.toArray();
        if (added[oldSize] == n && oldSize + 1 == supAr.size()){
                return true;
        }
        else if(added[oldSize] != n){
            System.out.println("Add didn't append the object to the end of the array!");
            return false;
        }
        else if(oldSize + 1 == supAr.size()){
            System.out.println("You didn't add 1 to size!");
            return false;
        }
        return false;
    }

    public static boolean testGet(){
        SuperArray test2 = new SuperArray();
        test2.add(1); test2.add(3); test2.add(5);
        return test2.get(0) == 1 && test2.get(1) == 3 && test2.get(2) == 5;
    }

    public static boolean testClear(SuperArray supAr){
        supAr.clear();
        if(supAr.size() == 0){
            return supAr.size() == 0;
        }
        else{
            System.out.println("Your clear() didn't set the size to 0!");
            return false;
        }
    }

    public static boolean testSet(){
        SuperArray test = new SuperArray();
        test.add(5); test.add(3); test.add(2);
        test.set(0, 1); test.set(1,2); test.set(2,3);
        return test.get(0) == 1 && test.get(1) == 2 & test.get(2) == 3;
    }

    public static boolean testAdd2(){
        SuperArray test = new SuperArray();
        test.add(1); test.add(2); test.add(3);
        test.add(1, 5);
        return test.get(1) == 5;

    }

    public static boolean testIndexOf(){
        SuperArray test = new SuperArray();
        test.add(5); test.add(3); test.add(2); test.add(3); test.add(4); test.add(3);
        if(test.indexOf(3) == 1 && test.indexOf(7) == -1){
            return true;
        }
        else if(test.indexOf(7) != -1){
            System.out.println("You're not returning -1 for values that aren't found");
            return false;
        }
        else{
            System.out.println("IndexOf doesn't work!");
            return false;
        }
    }

    public static boolean testLastIndexOf(){
        SuperArray test = new SuperArray();
        test.add(5); test.add(3); test.add(2); test.add(3); test.add(4); test.add(3);
        if(test.lastIndexOf(3) == 5 && test.indexOf(7) == -1){
            return true;
        }
        else if(test.lastIndexOf(7) != -1){
            System.out.println("You're not returning -1 for values that aren't found");
            return false;
        }
        else{
            System.out.println("LastIndexOf doesn't work!");
            return false;
        }
    }

    public static void main(String[]args){
        SuperArray test1 = new SuperArray();


        boolean testBool = true;

        //Testing add(int element)//

        testBool = testBool && testAdd1(test1, 5);
        testBool = testBool && testAdd1(test1, 6);
        testBool = testBool && testAdd1(test1, 0);
        testBool = testBool && testAdd1(test1, -3);

        System.out.println(test1);

        //Testing get, this assumes your add is working!!//
        testBool = testGet();

        /*Not gonna bother testing size...
        And each String method is different so uncomment the next line if you wanna print the previous SuperArray that should be [5, 6, 0, -3]*/
        //System.out.println(test1);

        //Testing clear()!//
        testBool = testBool && testClear(test1);

        //Testing isEmpty() [assuming clear() works]//
        testBool = testBool && test1.isEmpty();

        //Testing set! [assumes get() works]//
        testBool = testBool && testSet();

        //Testing the other add//
        testBool = testBool && testAdd2();

        //Testing indexOf()//
        testBool = testBool && testIndexOf();

        //testing lastIndexOf()//
        testBool = testBool && testLastIndexOf();



        System.out.println(Boolean.valueOf(testBool));
    }

}
