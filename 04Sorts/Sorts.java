import java.util.Arrays;
public class Sorts{
    
    public static String name(){
	return "10.Abbas.Adam";
    }

    /**Selection sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
    public static void selectionSort(int[] data){
	int nowMin, nowDex;
	for(int strt = 0; strt < data.length-1; strt++){
	    nowMin = data[strt];
	    nowDex = strt;
	    for(int ind = strt; ind < data.length; ind++){
		if(data[ind] <= nowMin){
		    nowMin = data[ind];
		    nowDex = ind;
		}
	    }
	    data[nowDex] = data[strt];
	    data[strt] = nowMin;
	}
    }

    public static void insertionSort(int[] data){
	int bNMoved, cTDwn;
	for(int i = 1; i < data.length; i++){
	    bNMoved = data[i];
	    cTDwn = i-1;
	    while(cTDwn >= 0 && bNMoved < data[cTDwn]){
		data[cTDwn + 1] = data[cTDwn];
		cTDwn--;
		System.out.println(Arrays.toString(data));
	    }
	    data[cTDwn+1] = bNMoved;
	}
    }

     
    public static void main(String[] aragasdrtawelkjhaselkgasdklasdghkl){
	int[] test1 = {8, 5, 6, 2, 7, 3, 1, 9, 0, 4};
	insertionSort(test1);

	for(int i: test1){
	    System.out.println(test1[i]);

	}   
    }



}
