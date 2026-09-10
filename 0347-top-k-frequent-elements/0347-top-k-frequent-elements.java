class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // Count frequency of each number
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // bucket[i] contains numbers that appear i times
        List<Integer>[] bucket = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }

            bucket[count].add(num);
        }

        // Get the k most frequent elements
        int[] result = new int[k];
        int index = 0;

        for (int count = bucket.length - 1; count >= 0 && index < k; count--) {
            if (bucket[count] != null) {
                for (int num : bucket[count]) {
                    result[index] = num;
                    index++;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
