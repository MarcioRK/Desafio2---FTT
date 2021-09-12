import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

        File inputFile = new File("C:/Users/MarcioRK/Documents/Codigos_Faculdade/Desafio2---FTT/Input.txt");

        //Creates the output file
        File outputFile = new File("Output.txt");
        outputFile.createNewFile();
        FileWriter fw = new FileWriter("Output.txt");

        //Read the file
        BufferedReader br = new BufferedReader(new FileReader(inputFile));

        //Validade the string
        try {
            String line;
            while ((line = br.readLine()) != null) {
                char character;
                char firstCharacter = line.charAt(0);
                char top = ' ';
                Boolean incomplete = false;
                Stack < Character > stackChar = new Stack < > ();

                //Repeat for each character in string
                for (Integer i = 0; i < line.length(); i++) {
                    character = line.charAt(i);

                    if (character == '{' || character == '(' || character == '[' || character == '<') { //Opening
                        stackChar.push(character);
                    } else if ((character == '}' || character == ')' || character == ']' || character == '>')) { //Closing

                        //Starts with invalid String
                        if (firstCharacter == '}' || firstCharacter == ')' || firstCharacter == ']' || firstCharacter == '>') {
                            continue;
                        } else if(!stackChar.isEmpty()) {

                            //Get the character from the top of the stack
                            top = stackChar.peek();
                        }

                        //Really closing
                        if ((character == '}' && top == '{') || (character == ')' && top == '(') || (character == ']' && top == '[') || (character == '>' && top == '<')) {
                            stackChar.pop();
                            top = ' ';
                        } else {
                            incomplete = true;
                        }
                    }
                }

                //If stackChar is empty and top isn't ' ', it hasn't passed throught "opening if"
                if (stackChar.isEmpty()/* && top != ' '*/) {
                    //Boolean for remaining char
                    if (incomplete) {
                        line += " - Error";
                    } else {
                        line += " - Ok";
                    }
                } else {
                    line += " - Error";
                }

                System.out.println(line);

                fw.write(line);
                fw.write(System.getProperty("line.separator"));
            }
        } finally {
            br.close();
        }

        fw.close();

        System.out.println("\nOutput created\nOutput file name: Output.txt\n");
    }
}