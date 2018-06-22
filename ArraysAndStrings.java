package code;
class ArraysAndStrings
{
    public boolean isOneEditAway(String s1, String s2)
    {
        String smaller = s1, larger = s2;
        if (s1.length() > s2.length())
        {
            smaller = s2;
            larger = s1;
        } // if
        int deleteCount = 0, replaceCount = 0, insertCount = 0;
        for (int i=0, j=0; i<smaller.length();)
        {
            char ch1 = smaller.charAt(i);
            char ch2 = larger.charAt(j);
            if(ch1 == ch2)
            {
                i++;
                j++;
            } // move forawrd in both strings
            else
            {
                if(i<smaller.length()-1)
                {
                    if(smaller.charAt(i) == larger.charAt(j))
                    {
                        deleteCount++;
                        i++;
                    }
                    else
                    {
                        replaceCount++;
                        i++;
                        j++;
                    }
                }
                else
                {
                    if (deleteCount+replaceCount < 1) return true;
                }
            }
            
        }
        return (deleteCount+replaceCount <= 1);
    }
    
    public String compress(String s)
    {
        StringBuilder sb = new StringBuilder("");
        for (int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            int count = 1;
            int j = i+1;
            while(j < s.length() && s.charAt(j) == ch)
            {
                j++;
                i++;
                count++;
            }
            sb.append(ch+""+count);
        }
        if(sb.toString().length() < s.length()) return sb.toString();
        else return s;
    } // compress
    
    private static void printMatrix(int a[][], int m, int n)
    {
         System.out.println("Array:");
         for(int i = 0; i<m ;i++) 
         {
             System.out.print("[");
             for(int j=0; j<n; j++)
                 System.out.print(a[i][j]+"\t");
             System.out.println("]");
         } // for
        
    } // printMatrix
    
    public void rotateMatrixIP(int a[][], int m) // m = n, square matrix
    {
        int index = m - 1;
        for (int i=index; i>=0; i--)
        {
            for (int j= 0; j<i; j++)
            {
                int LL = a[index-j][index-i];
                int LR = a[index][index-j];
                int TR = a[j][i];
                int TL = a[index-i][j];
                System.out.println(i+":"+j+" "+LL+" "+LR+" "+" "+TR+" "+TL);
                a[index-j][index-i] = LR;
                a[index][index-j] = TR;
                a[j][i] = TL;
                a[index-i][j] = LL;
                printMatrix(a, m, m);
                
            } // for
        } // for
    } // rotateMatrixIP
} // ArraysAndStrings