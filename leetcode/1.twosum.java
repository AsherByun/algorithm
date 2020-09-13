// 처음에 2중포문으로했음 , 중복되는값때문에 바이너리서치, 해쉬를 못썻는데  해쉬맵에 뺀값을 넣으면서 그걸로 가능해짐

import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){            
            if(!map.containsKey(target - nums[i]))
                map.put(nums[i], i);
            else
                return new int[] {i, map.get(target - nums[i])};
        }
        return new int[2];
    }
}
