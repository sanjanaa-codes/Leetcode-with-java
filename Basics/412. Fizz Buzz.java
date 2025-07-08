🐢 1. Brute‑Force (If‑Else)

class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> al = new ArrayList<String>();
        for(int i=1;i<=n;i++){
            if(i % 3 == 0 && i % 5 == 0){
                al.add("FizzBuzz");
            }
            else if(i % 3 == 0){
                al.add("Fizz");
            }
            else if(i % 5 == 0){
                al.add("Buzz");
            }
            else{
                al.add(Integer.toString(i));
            }
        }
        return al;
    }
}

Time Complexity: O(n) — one pass over 1..n
Space Complexity: O(n) — stores n strings 
    
To convert integers to strings within a list in Java, one common method involves iterating through the list and converting each 
Integer object to a String using String.valueOf() or Integer.toString().
___________________________________________________________________________________________________________________________________________
🚶 2. Better (String Concatenation)

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
        StringBuilder sb = new StringBuilder();
        if (i % 3 == 0) sb.append("Fizz");
        if (i % 5 == 0) sb.append("Buzz");
        result.add(sb.length() > 0 ? sb.toString() : String.valueOf(i));
    }
    return result;
    }
}

Adds "Fizz" and/or "Buzz" without nested conditionals
Time Complexity: O(n)
Space Complexity: O(n)
Same O(n) time and space but more scalable for additional rules 
___________________________________________________________________________________________________________________________________________

public List<String> fizzBuzz(int n) {
    List<String> result = new ArrayList<>();
    Map<Integer, String> map = Map.of(3, "Fizz", 5, "Buzz");
    List<Integer> divisors = List.of(3, 5);

    for (int i = 1; i <= n; i++) {
        StringBuilder sb = new StringBuilder();
        for (int d : divisors) {
            if (i % d == 0) sb.append(map.get(d));
        }
        result.add(sb.length() > 0 ? sb.toString() : String.valueOf(i));
    }
    return result;
}
  
  
Flexible: Easy to add more rules (e.g., 7 → "Jazz")
Similar time & space complexity, code stays clean 
___________________________________________________________________________________________________________________________________________
