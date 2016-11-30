public String sameEnds(String string) {
    String rtrn = "";
    for(int i=0;i<string.length()/2+1;i++){
        if(string.substring(0,i).equals(string.substring(string.length()-i)))
        rtrn=string.substring(0,i);
    }
    return rtrn;
}
