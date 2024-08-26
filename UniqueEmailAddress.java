class Solution {
    public int numUniqueEmails(String[] emails) 
    {
        HashSet<String> set= new HashSet<>();

        for(String email:emails)
        {
            StringBuilder sb = new StringBuilder();
            
            for(int i=0;i<email.length();i++)
            {
                char c = email.charAt(i);
                
                //if @ reached, just append domain and break;
                if(c=='@')
                {
                    sb.append(email.substring(i));
                    break;
                }

                //if + seen, just append prefix and skip everything till domain
                if(c=='+')
                {
                    while(email.charAt(i)!='@')
                    {
                        i++;
                    }

                    sb.append(email.substring(i));
                    break;
                }

                //if . seen, ignore
                if(c=='.')  continue;

                //keep adding char 
                sb.append(email.charAt(i));

            }

           
            set.add(sb.toString());
        }
    

        return set.size();
    }
}
