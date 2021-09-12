import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

        File inputFile = new File("/Users/MarcioRK/Documents/Codigos_Faculdade/Desafio2-FTT/src/TestInput.txt");
        /*Scanner sc = new Scanner(inputFile);
        Queue < String > lines = new LinkedList < > ();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            lines.add(line);
        }*/

        //Creates the output file
        File outputFile = new File("TestOutput.txt");
        outputFile.createNewFile();
        FileWriter fw = new FileWriter("TestOutput.txt");

        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                char character;
                char top = ' ';
                Boolean isValid = true;
                Stack < Character > stackChar = new Stack < > ();

                for (Integer i = 0; i < line.length(); i++) {
                    character = line.charAt(i);

                    if (character == '{' || character == '(' || character == '[' || character == '<') {
                        stackChar.push(character);
                    } else if ((character == '}' || character == ')' || character == ']' || character == '>')) {
                        top = stackChar.peek();

                        if ((character == '}' && top == '{') || (character == ')' && top == '(') || (character == ']' && top == '[') || (character == '>' && top == '<')) {
                            stackChar.pop();
                        } else {
                            isValid = false;
                        }
                    }
                }
   
                if (stackChar.isEmpty()) {
                    isValid = true;
                } else {
                    isValid = false;
                }

                if (isValid) {
                    line += " - Ok";
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

        //sc.close();

        //String outputText = validadeLines(lines);
        //validadeLines(lines);
    }
}