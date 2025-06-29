class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(sumOfdigits(nums[i])==i){
                return i;
            }
        }
        return -1;
    }

    public int sumOfdigits(int num) { //72
        int sum = 0;
        int rem = 0;
        while (num != 0) {
            rem = num % 10; //2
            sum += rem;
            num = num / 10; //7
        }
        return sum;
    }

}
