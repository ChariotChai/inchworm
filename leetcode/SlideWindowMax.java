
public int[] slideWindowMax(int nums[], int k) {
	
	if (nums == null || nums.length == 0 || nums.length < k) {
		return new int[0];
	}

	Deque<Integer> window = new LinkedList<>();
	int[] ans = new int[nums.length - k + 1];

	for (int i = 0; i < nums.length; i++) {
		if (i >= k && window.peekFirst() < i - k) { window.pollFirst(); }
		while (!window.isEmpty() && nums[window.peekLast()] <= nums[i]) {
			window.pollLast();
		}
		window.offerLast(nums[i]);
		if (i >= k - 1) { ans[i - k + 1] = window.peekFirst(); }
	}

	return ans;
}
