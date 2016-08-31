public class Solution {
    public String convert(String s, int nRows) {
    char[] c = s.toCharArray();
    int len = c.length;
    StringBuffer[] sb = new StringBuffer[nRows];
    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

    int i = 0;
    while(i < len){
        for(int r = 0; i < len && r < nRows;r++){
            sb[r].append(c[i++]);
        }

        for(int r = nRows - 2; i < len && r > 0; r--){
            sb[r].append(c[i++]);
        }
    }
    
    for(int r = 1; r < nRows; r++){
        sb[0].append(sb[r].toString());
    }
    return sb[0].toString();
}
}