class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        long volume = (long) length * width * height;
        boolean isBulky = length >= 10_000
                || width >= 10_000
                || height >= 10_000
                || volume >= 1_000_000_000;
        boolean isHeavy = mass >= 100;
        if (isBulky && isHeavy)
            return "Both";
        if (isBulky)
            return "Bulky";
        if (isHeavy)
            return "Heavy";
        return "Neither";
    }
}

Time: O(1) — only a few simple arithmetic and comparison operations 
Space: O(1) — only a handful of primitive variables used 
