public class Sorts{
    
    public static String name(){
	return "10.Abbas.Adam";
    }

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

    public static void main(String[] aragasdrtawelkjhaselkgasdklasdghkl){
	int[] test1 = {8, 5, 6, 2, 7, 3, 1, 9, 0, 4};
	selectionSort(test1);

	for(int i: test1){
	    System.out.println(test1[i]);

	}   
    }



}
