//https://leetcode.com/problems/valid-parentheses/?envType=study-plan-v2&envId=top-interview-150
//T.C  worst case = O(n)
//S.C  - O(n)
class Solution {
    public boolean isValid(String s) {
        char topBracket;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i <s.length() ; i++)
        {
            char currentBracket = s.charAt(i);

            if(currentBracket=='(' || currentBracket=='{' || currentBracket=='[')
            {
                stack.push(currentBracket);
            }else{
                if(stack.isEmpty())
                {
                   return false;
                }

                topBracket = stack.pop();
                switch (topBracket){
                    case '{':{
                        if(currentBracket!='}'){
                           return  false;
                        }
                    }
                    break;
                    case '[':{
                        if(currentBracket!=']'){
                            return  false;
                        }
                    }
                    break;
                    case '(':{
                        if(currentBracket!=')'){
                            return  false;
                        }
                    }
                    break;
                    default:
                        return false;
                }

            }

        }

        return stack.isEmpty();


    }
}
