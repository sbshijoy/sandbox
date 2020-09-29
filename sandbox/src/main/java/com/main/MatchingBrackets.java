package com.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class MatchingBrackets {
    public static void main(String args[]) {
        System.out.println("Checking");
        MatchingBrackets matchingBrackets = new MatchingBrackets();
        //"[()]{}{[()()]()}" Should return true
        //"[(])" should return false 
        boolean matching = matchingBrackets.match("[(])");
        if(matching) {
            System.out.println("Matching");
        }
        else {
            System.out.println("Not Matching");
        }

    }

    private boolean match(String s) {
        Stack<Character> stack = new Stack();
        Map<Character,Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        
        for(int i = 0; i< s.length(); i++) {
            char currentChar = s.charAt(i);
            if(currentChar == '{'|| currentChar == '[' || currentChar == '(') {
                stack.push(currentChar);
            }
            if(currentChar == '}'|| currentChar == ']' || currentChar == ')') {
                Character latestCharacter = stack.pop();
                if(latestCharacter != map.get(currentChar)) {
                    return false;
                }

            }

        }
        return true;
    }

}