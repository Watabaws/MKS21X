public class Barcode implements Comparable<Barcode>{
    private String _zip; 
    private int _checkDigit;


    public Barcode(String zip){
	try{
	    _zip = zip;
	    _checkDigit = checkSum();
	}
	catch(RuntimeException e){
	    System.out.println("Make sure you are inputting a 5 digit string of numbers!");
		}
    }

    public Barcode clone(){
	return new Barcode(_zip);
    }

    public int checkSum(){
	int cSum = 0;
	for(int i = 0; i < _zip.length(); i++){
	    cSum += Integer.parseInt(i);
	}
	return cSum % 10;
    }
    
    public String makeBarcode(){
	String bars = ""
	for(int i = 0; i < _zip.length(); i++){
	    switch(i){
	    case1: bars += ":::||";
	    break;
	    case2: bars += "::|:|";
	    break;
	    case3: bars += "::||:";
	    break;
	    case4: bars += ":|::|";
	    break;
	    case5: bars += ":|:|:";
	    break;
	    case6: bars += ":||::";
	    break;
	    case7: bars += "|:::|";
	    break;
	    case8: bars += "|::|:";
	    break;
	    case9: bars += "|:|::";
	    break;
	    case0: bars += "||:::";
	    break;
	    }

	    
    public compareTo(Barcode other){
	

    

}



	
