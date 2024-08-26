class Solution {
    public List<String> letterCombinations(String digits) 
    {
        HashMap<Character, String> map = new HashMap<>();

        //prepare
        map.put('2',"abc");

        map.put('3',"def");

        map.put('4',"ghi");

        map.put('5',"jkl");

        map.put('6',"mno");

        map.put('7',"pqrs");

        map.put('8',"tuv");
        map.put('9',"wxyz");


        List<String> ans = new ArrayList<>();
        
        if(digits==null || digits.length()==0) return ans;
      
        StringBuilder currentStr= new StringBuilder();
        constructComb(digits, map,ans,0,currentStr);
        return ans;
    }

    public void constructComb(String digits, HashMap<Character, String> map,
    List<String> ans, int index,StringBuilder currentStr)
    {
        if(index==digits.length())
        {
            ans.add(currentStr.toString());
            return;
        }
        
       
        String str= map.get(digits.charAt(index));
        for(char c: str.toCharArray())
        {
                currentStr.append(c);
                constructComb(digits,map,ans,index+1, currentStr);
                currentStr.deleteCharAt(currentStr.length()-1);

        }
        
    }
}
