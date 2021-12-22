import java.util.Random;

public class QuickSelect {
    Random rand = new Random();

    public int select(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi){
            // Generating random index between hi and lo in order to
            // improve performance
            int r = lo + rand.nextInt(hi - lo + 1);
            int pivot = nums[r];

            // Swapping pivot to last
            swap(nums,r,hi);
            int j = lo;

            // Swapping elements smaller than pivot to the range (lo,j-1)
            // and keeping larger in the range (j,hi)
            for(int i = lo; i < hi; i++) if(nums[i] < pivot)swap(nums,i,j++);

            // Swapping pivot element to appriopriate position
            swap(nums,j,hi);

            // Checking if current element is the result else changing
            // pointers appriopriately
            if(j == nums.length-k) return nums[j];
            else if(j < nums.length-k) lo = j+1;
            else hi = j-1;
        }
        return -1;
    }
    public void swap(int nums[], int i , int j){
        if(i == j) return;
        nums[i]^=nums[j];
        nums[j]^=nums[i];
        nums[i]^=nums[j];
    }
}
