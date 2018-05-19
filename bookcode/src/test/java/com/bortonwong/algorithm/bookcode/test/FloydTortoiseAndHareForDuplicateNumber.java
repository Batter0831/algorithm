package com.bortonwong.algorithm.bookcode.test;

class FloydTortoiseAndHareForDuplicateNumber {

	//有n+1个整数，分布在1-n的范围内，只有一个数字出现了重复，存储在arr[0..n]上，求出哪个数字出现了重复
	//环形链表也可以用同样的方法求得第一个入环的节点
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9,8,6,2,4,3};
		System.out.println(new FloydTortoiseAndHareForDuplicateNumber().duplicateNumber(arr));
	}
	public int duplicateNumber(int[] nums) {
		int t = nums[0];
		int h = nums[0];
		do {
			t = nums[t];
			h = nums[nums[h]];
		} while (t != h);
		h = nums[0];
		while (t != h) {
			t = nums[t];
			h = nums[h];
		}
		return h;
	}
}
