import java.util.Stack;

public class ParenthesesChecker {

    public static void main(String[] args) {

    }
    // write a method called checkParentheses
    // takes in a String
    // returns a boolean

    // return true if the string contains "correct" pairs of parentheses
    // return false if not!

    // situations to return false:
    // more opening or closing brackets of a particular type (),<>,{},[]
    // closing bracket at start
    // number of opening bracket and closing bracket doesn't match
    public static boolean checkParentheses(String text){

        int numOfOB = 0; //initiate number of opening brackets
        int numOfCB = 0; //initiate number of closing brackets
        Stack<String> textStack = new Stack<>();
        char[] chars = text.toCharArray();

        for(char c : chars){
            textStack.add(String.valueOf(c));
            }

        System.out.println(textStack);
        System.out.println(textStack.get(0));

        //count the number of opening brackets and closing brackets
        for(int i = 0; i < textStack.size(); i++) {
            if(textStack.get(i).equals("(")){
                numOfOB += 1;
            }
            if(textStack.get(i).equals(")")){
                numOfCB += 1;
            }
        }

        //can pass for empty string
        if (textStack.isEmpty() == true){
            return true;
        }

        // check with one pair
        if(numOfCB == 1 && numOfOB == 1){
            if(textStack.search("(") > textStack.search(")")){
                return true;
            }
        }

        //will fail if text have only opening bracket or closing bracket
        if(numOfCB != numOfOB){
            return false;
        }

        //for nested brackets
        if(numOfCB == numOfOB){
            for(int i=0; i < textStack.size()/2; i++){
                while(textStack.get(i).equals("(") && textStack.peek().equals(")")){
                    textStack.remove(i);
                    textStack.pop();
                    System.out.println(textStack);
                }
                return true;
            }
        }


        return false;
    }




}
