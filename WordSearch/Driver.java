public class Driver{
    public static void main(String[] args){
        String Directions = "\t\tHi! Welcome to the crossword generator. Here's how to use this: \n"
                          + "1. Make sure the your code has been compiled.\n"
                          + "2. Type in java *filename* (don't push enter yet)\n"
                          + "3. There are several input options. The first is, after the filename, to enter the number of rows, number of columns and file of text"
                          + "4. You can also input a Seed after that, if you wish to recreate an older puzzle"
                          + "5. Finally you can write 'key' if you would like only the answers to the puzzle printed out.";
        WordSearch poozl;
        if(args.length < 3){
            System.out.println(Directions);
        }
        else{
            if(args.length >= 3){
                try{
                    poozl = WordSearch.makePuzzle(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
                }
                catch(IllegalArgumentException e){
                    System.out.println(Directions);
                }
            }
            else if(args.length >= 4){
                try{
                    poozl = WordSearch.makePuzzle(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
                }
                catch(IllegalArgumentException e){
                    System.out.println(Directions);
                }
            }

            if(args.length == 5){
                if(args[4].equals("key")){
                    System.out.println(poozl);
                    poozl.unAnswer();
                    System.out.println(poozl);
                }
            }

        }
    }
}
