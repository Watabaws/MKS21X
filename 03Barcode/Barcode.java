public class Barcode implements Comparable<Barcode>{
    private String _zip;
    private static final String[] b4rz = {":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::", "||:::"};

    public Barcode(String zip){
        IllegalArgumentException oops = new IllegalArgumentException("Make sure you are inputting a 5 digit string of numbers!");
        if(zip.length() != 5){
            throw oops;
        }
    	try{
    	    _zip = zip;
        }
        catch(IllegalArgumentException e){
            throw oops;
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
        zip = zip + checkSum(zip);
    	for(int i = 0; i < zip.length(); i++){
    	    bars += intToBar(zip.substring(i, i+1));
    	}
    	bars += intToBar(checkSum(zip));
    	bars += "|";
    	return bars;
    }

    private boolean checkCode(String code){
        if(code.length() < 32){
            return false;
        }
        if(code.charAt(0) != '|' || code.charAt(code.length() - 1) != '|'){
            return false;
        }
        for(int i = 0; i < code.length(); i++){
            char letta = code.charAt(i);
            if(letta != ':' || letta != '|'){
                return false;
            }
        }
        return true;

    }

    private static String intToBar(String i){
    	int l = Integer.parseInt(i);
    	return b4rz[l];
    }

    public int compareTo(Barcode other){
	       return _zip.compareTo(other._zip);
    }

    public static void main(String[] argsssSSSsSSssSS){
        Barcode dabar = new Barcode("11209");
        System.out.print(dabar);
    }
}
