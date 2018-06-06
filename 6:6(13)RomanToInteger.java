class Solution {
    public int romanToInt(String s) {
        
        // if string is empty
        if (s.length() == 0) {
            return 0;
        }

        // create a hashmap with values each character represents
        Map<Character, Integer> roman = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        
        char ch[] = s.toCharArray();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += roman.get(ch[i]);
        }
        
        // check if subtraction case exists
        // Use single quotes for literal chars, double quotes for literal Strings,
        if (s.indexOf("IV") != -1) res -= 2;
        if (s.indexOf("IX") != -1) res -= 2;
        if (s.indexOf("XL") != -1) res -= 20;
        if (s.indexOf("XC") != -1) res -= 20;
        if (s.indexOf("CD") != -1) res -= 200;
        if (s.indexOf("CM") != -1) res -= 200;    
        
    
        return res;
    
    }
    
}