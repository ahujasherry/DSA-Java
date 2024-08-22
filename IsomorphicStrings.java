class Solution {
    public boolean isIsomorphic(String s, String t) 
    {
        if(s.length()!=t.length())
            return false;

        
        HashMap<Character,Character> map = new HashMap<>();
        

        for(int i=0;i<s.length();i++)
        {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            //if no mapping exist
           
            if(!map.containsKey(sChar))
            {
                //but if already tChar taken care of
                if(map.containsValue(tChar))
                {
                    return false;
                }

                 //create mapping
                map.put(sChar,tChar);
                
            }else
            {
                //if mapping exist already 
                if(map.get(sChar)!=tChar)
                {
                   return false;
                }
            }
        }
        return true;
    }
}
