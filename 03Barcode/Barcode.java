import java.util.Arrays;

public class Barcode implements Comparable<Barcode>{
    private String _zip;
    private static final String[] b4rz = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};

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
        return _zip + checkSum(_zip) + " " + toCode(_zip);
    }

    private static String checkSum(String zip){
    	int cSum = 0;
    	for(int i = 0; i < zip.length(); i++){
    	    cSum += Integer.parseInt(zip.substring(i, i+1));
    	}
    	return "" + cSum % 10;
    }

    public static String toCode(String zip){
    	String bars = "|";
        zip = zip + checkSum(zip);
    	for(int i = 0; i < zip.length(); i++){
    	    bars += intToBar(zip.substring(i, i+1));
    	}
    	bars += intToBar(checkSum(zip));
    	bars += "|";
    	return bars;
    }

    private static void checkCode(String code){
        if((code.length() - 2) % 5 != 0){
            throw new IllegalArgumentException("Your barcode must be a multiple of 5, + 2 characters long!");
        }
        if(code.charAt(0) != '|' || code.charAt(code.length() - 1) != '|'){
            throw new IllegalArgumentException("There must be an initial and final pipe in the barcode!");
        }
        for(int i = 0; i < code.length(); i++){
            char letta = code.charAt(i);
            if(letta != ':' || letta != '|'){
                throw new IllegalArgumentException("Barcodes can only contain '|'s or ':'s!");
            }
        }
        for(int i = 1; i < code.length()-1; i+=5){
            if(!(Arrays.asList(b4rz).contains(code.substring(i,i+5)))){
                throw new IllegalArgumentException("Invalid bar values!");
            }
        }
    }

    public static String toZip(String code){
        checkCode(code);
        String zip = "";
        for(int i = 1; i < code.length() -1; i+=5){
            zip += "" + Arrays.asList(b4rz).indexOf(code.substring(i, i+5));
        }
        if((zip.substring(zip.length()-1, zip.length())) != checkSum(zip.substring(0, zip.length()-1))){
            throw new IllegalArgumentException("Your Check Digit isn't valid!");
        }
        return zip.substring(0, zip.length()-1);
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
