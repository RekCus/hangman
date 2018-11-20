package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static private void run(){
        String word="superman";

        int life=6;
        Scanner start = new Scanner(System.in);
        String inp = start.next();

        if(inp.equalsIgnoreCase( "run")){
            hangman(word, life);
        }
        else if (inp.equalsIgnoreCase( "-")){
            System.out.println("Bye bye");
            System.exit(0);
        }
        else{
            run();
        }

    }

    static private void hangman(String word, int life){
        char[] placeholder = new char[word.length()];
        int i = 0;


       while(i < word.length()){
           placeholder[i] = '-';

           if(word.charAt(i) == ' '){
            placeholder[i] = ' ';
           }
           i++;
        }

        System.out.println(placeholder);
        System.out.println("Lives left:" + life);


        Scanner scan = new Scanner(System.in);

        ArrayList<Character> usedCharacters = new ArrayList<>();


        while(life>0){

            String inputString = scan.next();
            char in = inputString.charAt(0);

            int maxLength = 1;
             if (inputString.length() > maxLength) {
                System.out.println("You can only type ONE letter, Try again");

             } else if (usedCharacters.contains(in)){
                 System.out.println("You already used this letter, Try again!");
             } else if(word.contains(in + "")){
                for(int m = 0 ; m < word.length(); m++){
                    if(word.charAt(m) == in){
                        placeholder[m] = in;
                        System.out.println("Nice Job!");
                        usedCharacters.add(in);
                    }
                }
            }else if (in == '-') {
                System.out.println("Bye bye");
                System.exit(0);
            }
            else{
                life--;
                System.out.println("Wrong!");
                usedCharacters.add(in);
            }

            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println(placeholder);
            System.out.println("Lives left:" + life);
           System.out.println("Guessed Letters:" + usedCharacters);

            if (isTheWordGuessed(placeholder)){
                System.out.println("You've Won");
                System.out.println("The answer was " + word);
                System.exit(0);
            }
            else if(life == 0) {
                System.out.println("You've Lost");
                System.out.println("The answer was " + word);
                System.exit(0);
            }


        }
    }

    public static boolean isTheWordGuessed(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == '-') return  false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Welcome to the hangman game");
        System.out.println("You can only guess one letter at a time. When all blank spaces are filled then you'll win.");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Type (run) to start playing.");
        System.out.println("Type (-) anytime to stop.");
        System.out.println("-------------------------------------------------------------------------------------------");

        run();

    }
}
