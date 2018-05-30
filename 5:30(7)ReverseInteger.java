class Solution {
    public int reverse(int x) {
        
        // check if integer is negative or not first
        boolean negFlag = x < 0;
        x = Math.abs(x);
        
        int reverse = 0;

        while (x != 0) {
            // check if will overflow
            if (reverse > (Integer.MAX_VALUE - x % 10) / 10) {
                return 0;
            }
            reverse = reverse * 10 + x % 10;
            x = x /10;
        }

        return negFlag ? -reverse : reverse;
    
    }
}