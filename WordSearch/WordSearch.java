import java.util.*;
import java.io.*;

public class WordSearch{
    private char[][] data;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private Random randgen;

    public WordSearch(int rows,int cols, String filename, int seed, boolean key){
        data = new char[rows][cols];
        wordsToAdd = new ArrayList<String>();
        wordsAdded = new ArrayList<String>();
        clear();
        randgen = new Random(seed);
        System.out.println("Your seed is: " + seed);
        loadWords(filename);
        makePuzzle();
        if(!key){
            unAnswer();
        }
    }

    public void loadWords(String fileName){
        try{
            Scanner in = new Scanner(new File(fileName));
            while(in.hasNext()){
                String word = in.next();
                //System.out.println(word.toUpperCase());
                wordsToAdd.add(word.toUpperCase());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Invalid filename or path");
            System.exit(1);
        }
    }

    public String getWord(){
        int wordInd = Math.abs(randgen.nextInt() % wordsToAdd.size());
        String word2add = wordsToAdd.get(wordInd);
        wordsToAdd.remove(wordInd);
        wordsAdded.add(word2add);
        //System.out.println(word2add);
        return word2add;
    }

    public void addWord(){
        String word2add = getWord();
        int direction = Math.abs((randgen.nextInt() + 1)) % 8;
        //int direction = 7;
        int row = Math.abs(randgen.nextInt() % data.length);
        int column = Math.abs(randgen.nextInt() % data[0].length);
        //System.out.println("" + direction + " " + row + " " + column);
        int ctr = 0;
        boolean didIt;
        if(direction == 0){
            didIt = addWordHorizontal(word2add, row, column, false);
            while(!didIt && ctr < 150){
                row = Math.abs(randgen.nextInt() % data.length);
                column = Math.abs(randgen.nextInt() % data[0].length);
                //System.out.println("" + direction + " " + row + " " + column);
                didIt = addWordHorizontal(word2add, row, column, false);
                ctr++;
            }
        }
        else if (direction == 1){
            didIt = addWordDiagonal(word2add, row, column, true, false);
            while(!didIt && ctr < 150){
                row = Math.abs(randgen.nextInt() % data.length);
                column = Math.abs(randgen.nextInt() % data[0].length);
                //System.out.println("" + direction + " " + row + " " + column);
                didIt = addWordDiagonal(word2add, row, column, true, false);
                ctr++;
            }
        }
        else if(direction == 2){
            didIt = addWordVertical(word2add, row, column, false);
            while(!didIt && ctr < 150){
                row = Math.abs(randgen.nextInt() % data.length);
                column = Math.abs(randgen.nextInt() % data[0].length);
                //System.out.println("" + direction + " " + row + " " + column);
                didIt = addWordVertical(word2add, row, column, false);
                ctr++;
            }
        }
        else if(direction == 3){
            didIt = addWordDiagonal(word2add, row, column, true, true);
            while(!didIt && ctr < 150){
                row = Math.abs(randgen.nextInt() % data.length);
                column = Math.abs(randgen.nextInt() % data[0].length);
                //System.out.println("" + direction + " " + row + " " + column);
                didIt = addWordDiagonal(word2add, row, column, true, true);
                ctr++;
            }
        }
        else if(direction == 4){
            didIt = addWordHorizontal(word2add, row, column, true);
            while(!didIt && ctr < 150){
                row = Math.abs(randgen.nextInt() % data.length);
                column = Math.abs(randgen.nextInt() % data[0].length);
                //System.out.println("" + direction + " " + row + " " + column);
                didIt = addWordHorizontal(word2add, row, column, true);
                ctr++;
            }
        }
        else if(direction == 5){
            didIt = addWordDiagonal(word2add, row, column, false, true);
            while(!didIt && ctr < 150){
                row = Math.abs(randgen.nextInt() % data.length);
                column = Math.abs(randgen.nextInt() % data[0].length);
                //System.out.println("" + direction + " " + row + " " + column);
                didIt = addWordDiagonal(word2add, row, column, false, true);
                ctr++;
            }
        }
        else if(direction == 6){
            didIt = addWordVertical(word2add, row, column, true);
            while(!didIt && ctr < 150){
                row = Math.abs(randgen.nextInt() % data.length);
                column = Math.abs(randgen.nextInt() % data[0].length);
                //System.out.println("" + direction + " " + row + " " + column);
                didIt = addWordVertical(word2add, row, column, true);
                ctr++;
            }
        }
        else if(direction == 7){
            didIt = addWordDiagonal(word2add, row, column, false, false);
            while(!didIt && ctr < 150){
                row = Math.abs(randgen.nextInt() % data.length);
                column = Math.abs(randgen.nextInt() % data[0].length);
                //System.out.println("" + direction + " " + row + " " + column);
                didIt = addWordDiagonal(word2add, row, column, false, false);
                ctr++;
            }
        }

    }

    private void clear(){
        for(int i = 0; i < data.length;i++){
            for(int j = 0; j < data[i].length;j++){
                data[i][j] = '_';
            }
        }
    }

    public String toString(){
        String toRet = "";
        for(int i = 0; i < data.length;i++){
            for(int j = 0;j < data[i].length; j++){
                toRet += data[i][j] + " ";
            }
            toRet += "\n";
        }
        return toRet;
    }

    private boolean addWordDiagonal(String word, int row, int col, boolean down, boolean back){
        boolean validWord;
        if(down){
            if(back){
                if(row + word.length() >= data.length || col - word.length() <= 0){
                    return false;
                }
                else{
                    validWord = true;
                    for(int i = 0; i < word.length(); i++){
                        validWord = validWord && (data[row+i][col-i] == word.charAt(i) || data[row+i][col-i] == '_');
                    }
                }
            }
            else{
                if(row + word.length() > data.length || col + word.length() > data[row].length){
                    return false;
                }
                else{
                    validWord = true;
                    for(int i = 0; i < word.length(); i++){
                        validWord = validWord && (data[row+i][col+i] == word.charAt(i) || data[row+i][col + i] == '_');
                    }
                }
            }
        }
        else{
            if(back){
                if(row - word.length() <    0 || col - word.length() < 0){
                    return false;
                }
                else{
                    validWord = true;
                    for(int i = 0; i < word.length(); i++){
                        validWord = validWord && (data[row-i][col-i] == word.charAt(i) || data[row-i][col-i] == '_');
                    }
                }
            }
            else{
                if(row - word.length() < 0 || col + word.length() > data[row].length){
                    return false;
                }
                else{
                    validWord = true;
                    for(int i = 0; i < word.length(); i++){
                        validWord = validWord && (data[row-i][col+i] == word.charAt(i) || data[row-i][col+i] == '_');
                    }
                }
            }
        }
        //System.out.println(validWord);
        if(validWord){
            int vertDir = 0, horiDir = 0;
            for(int i = 0; i < word.length(); i++){
                vertDir = i;
                horiDir = i;
                if(!down){
                    horiDir *= -1;
                }
                if(back){
                    vertDir *= -1;
                }
                //System.out.println("" + vertDir + " " + horiDir);
                data[row+horiDir][col+vertDir] = word.charAt(i);
            }
            return true;
        }
        else{
            return false;
        }
    }

    private boolean addWordHorizontal(String word,int row, int col, boolean backwards){
        boolean validWord;
        if(backwards){
            if(col - word.length() < 0){
                return false;
            }
            else{
                validWord = true;
                for(int i = 0; i < word.length(); i++){
                    validWord = validWord && (data[row][col - i] == word.charAt(i) || data[row][col-i] == '_');
                }
            }
        }
        else{
            if(col + word.length() > data[row].length){
                return false;
            }
            else{
                validWord = true;
                for(int i = 0; i < word.length(); i++){
                    validWord = validWord && (data[row][col + i] == word.charAt(i) || data[row][col+i] == '_');
                }
            }
        }
        if(validWord){
            int dir = 0;
            for(int i = 0; i < word.length(); i++){
                dir = i;
                if(backwards){
                    dir *= -1;
                }
                data[row][col+dir] = word.charAt(i);
            }
            return true;
        }
        else{
            return false;
        }
    }

    private boolean addWordVertical(String word,int row, int col, boolean upwards){
        boolean validWord;
        if(upwards){
            if(row - word.length() < 0){
                return false;
            }
            else{
                validWord = true;
                for(int i = 0; i < word.length(); i++){
                    validWord = validWord && (data[row - i][col] == word.charAt(i) || data[row-i][col] == '_');
                }
            }
        }
        else{
            if(row + word.length() > data.length){
                return false;
            }
            else{
                validWord = true;
                for(int i = 0; i < word.length(); i++){
                    validWord = validWord && (data[row + i][col] == word.charAt(i) || data[row+i][col] == '_');
                }
            }
        }
        if(validWord){
            int dir = 0;
            for(int i = 0; i < word.length(); i++){
                dir = i;
                if(upwards){
                    dir *= -1;
                }
                data[row+dir][col] = word.charAt(i);
            }
            return true;
        }
        else{
            return false;
        }
    }

    public void unAnswer(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < data.length;i++){
            for(int j = 0; j < data[i].length; j++){
                if(data[i][j] == '_'){
                    data[i][j] = alphabet.charAt((int)(Math.abs(randgen.nextInt() % 26)));
                }
            }
        }
    }


    public void makePuzzle(){
        //int numWords = (int)((Math.random() * (wordsToAdd.size() / 2)) + wordsToAdd.size() / 2);
        int numWords = wordsToAdd.size();
        for(int i = 0; i < numWords; i++){
            addWord();
        }
    }

    public static void main(String[]args){
            String Directions = "\t\tHi! Welcome to the crossword generator. \nHere's how to use this: \n"
                              + "1. Make sure the your code has been compiled.\n"
                              + "2. Type in java *filename* (don't push enter yet)\n"
                              + "3. There are several input options. The first is, after the filename, to enter the number of rows, number of columns and file of text"
                              + "4. You can also input a Seed after that, if you wish to recreate an older puzzle"
                              + "5. Finally you can write 'key' if you would like only the answers to the puzzle printed out.";

            if(args.length < 3){
                System.out.println(Directions);
            }
            else{
                try{
                    int row = Integer.parseInt(args[0]);
                    int column = Integer.parseInt(args[1]);
                    String filename = args[2];
                    int seed = (int)(Math.random() * Integer.MAX_VALUE);
                    if(args.length >= 4){
                        seed = Integer.parseInt(args[3]);
                    }
                    boolean key = false;
                    if(args.length >= 5){
                        key = args[4].equals("key");
                    }
                    WordSearch poozl = new WordSearch(row, column, filename, seed, key);
                    System.out.println(poozl);
                    for(int i = 0; i < poozl.wordsAdded.size(); i++){
                        System.out.println(poozl.wordsAdded.get(i));
                    }
                }
                catch(NumberFormatException e){
                    System.out.println(Directions);
                }
            }
    }
}
