
1. BRUTE FORCE APPROACH

class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count>n/2){
                return nums[i];
            }
        }
        return -1;
    }
}

Time Complexity - O(n^2)
Space Complexity - O(1)

------------------------------------------------------------------------------------------------------------------------------

2. BETTER APPRAOCH

-> Optimizing to NlogN or N
-> To keep a track and see how many times something occurs use hashing

class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>n/2){
                return entry.getKey();
            }
        }
        return -1;
    }
}

Time Complexity - O(2n) - O(n)
Space Complexity - O(n)

Worst Case SC is n if unique elements.

------------------------------------------------------------------------------------------------------------------------------

3. BEST APPROACH 

-> Moore's Voting Algorithm
    --> Find Candidate for Majority Element
    --> Verify ME


class Solution {
    public int majorityElement(int[] nums) {
        int c = 0; //count
        int ele = 0;
        // Finding the Majority Candidate O(n)
        for (int i = 0; i < nums.length; i++) {
            if (c == 0) {
                ele = nums[i];
                c = 1;
            } else if (ele == nums[i]) {
                c++;
            } else {
                c--;
            }
        }
        // Verify Majority Element O(n)
        // (This step is not done if majority element always exists in the array)
        c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele) {
                c++;
            }

        }
        if (c > nums.length / 2) {
            return ele;
        }
        return -1;

    }
}

Time Complexity - O(n)
Space Complexity - O(1)
