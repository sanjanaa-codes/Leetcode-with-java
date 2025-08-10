1. Simple Loop (Brute Force)
Check every number in the range and count odds.

public int countOdds(int low, int high) {
    int count = 0;
    for (int i = low; i <= high; i++) {
        if (i % 2 != 0) count++;
    }
    return count;
}

TC: O(n) (where n = high - low + 1)
SC: O(1)

Easy, but slow for large ranges.
------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Math Formula (Most Efficient)
Key idea: Number of odds = (high + 1) / 2 - low / 2

public int countOdds(int low, int high) {
    return (high + 1) / 2 - (low) / 2;
}

TC: O(1)
SC: O(1)
Instant calculation, no loops.
------------------------------------------------------------------------------------------------------------------------------------------------------------------

3. Shift Bounds & Divide
Adjust low and high to nearest odds, then divide range length by 2.

public int countOdds(int low, int high) {
    if (low % 2 == 0) low++;   // make low odd
    if (high % 2 == 0) high--; // make high odd
    if (low > high) return 0;
    return (high - low) / 2 + 1;
}

TC: O(1)
SC: O(1)
Works by aligning ends to odd numbers.
------------------------------------------------------------------------------------------------------------------------------------------------------------------

4. Using Bit Manipulation (Odd Check via & 1)

public int countOdds(int low, int high) {
    return ((high + 1) >> 1) - (low >> 1);
}
Same as method 2 but uses >> 1 instead of / 2 for slight speed.

------------------------------------------------------------------------------------------------------------------------------------------------------------------
