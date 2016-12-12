public class Barcode implements Comparable<Barcode>{
    private String _zip;

    public Barcode(String zip){
    	try{
    	    _zip = zip;
            _zip = zip + checkSum(zip);
        }
        finally{
            throw new IllegalArgumentException("Make sure you are inputting a 5 digit string of numbers!");
        }
    }

    public String toString(){
        return _zip + " " + makeCode(_zip);
    }

    private static String checkSum(String zip){
    	int cSum = 0;
    	for(int i = 0; i < zip.length(); i++){
    	    cSum += Integer.parseInt(zip.substring(i, i+1));
    	}
    	return "" + cSum % 10;
    }

    public static String makeCode(String zip){
    	String bars = "|";
    	for(int i = 0; i < zip.length(); i++){
    	    bars += intToBar(zip.substring(i, i+1));
    	}
    	bars += intToBar(checkSum(zip));
    	bars += "|";
    	return bars;
    }

    private static String intToBar(String i){
    	int l = Integer.parseInt(i);
    	switch(l){
    	    case 1: return ":::||";
    	    case 2: return "::|:|";
    	    case 3: return "::||:";
    	    case 4: return ":|::|";
    	    case 5: return ":|:|:";
    	    case 6: return ":||::";
    	    case 7: return "|:::|";
    	    case 8: return "|::|:";
    	    case 9: return "|:|::";
    	    case 0: return "||:::";
            default: throw new IllegalArgumentException("Please make sure your zip is made up of integers");
    	}
    }

    public int compareTo(Barcode other){
	       return _zip.compareTo(other._zip);
    }

    public static void main(String[] argsssSSSsSSssSS){
        Barcode dabar = new Barcode("11209");
        System.out.print(dabar);
    }
}
