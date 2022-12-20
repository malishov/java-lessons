import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String input = "()[]{()}";

        Pattern p = Pattern.compile("[({\\[]");
//        Matcher m = p.matcher(input);

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {

            Matcher m = p.matcher(input);
            System.out.println();



            if (stack.empty())
                stack.push(input.charAt(i));
            else {

                if (stack.get(stack.size() - 1) == '[' && input.charAt(i) == ']' && !m.find())
                    stack.pop();
                else if (stack.get(stack.size() - 1) == '(' && input.charAt(i) == ')' && !m.find())
                    stack.pop();
                else if (stack.get(stack.size() - 1) == '{' && input.charAt(i) == '}' && !m.find())
                    stack.pop();
                else {
                    System.out.println("ERROR");
                    break;
                }
            }


        }

        for (char e : stack)
            System.out.println(e + " " + (int)e);


    }
}