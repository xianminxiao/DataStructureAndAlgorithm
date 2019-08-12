package com.xxm;

import com.xxm.CommonUtil;

public class QuickSortMain {
	
	// 以low位置的值为基准值，将dataArray分成两部分，左侧都不大于(小于)基准值，右侧都大于（小于）基准值
	public static int partitionDataArray(int[] dataArray, int low, int high, SortType sortType) {
		// 以low位置为基准，记录下基准信息
		int baseIndex = low;
		int baseValue = dataArray[baseIndex];
		// 从low往后查，从high往前查，找到符合条件对换位置上的值
		while (low < high) {
			if (sortType == SortType.SortType_Asc) {
				while (baseValue <= dataArray[high] && low < high) high--;
				while (baseValue >= dataArray[low] && low < high)  low++;
			}
			else {
				while (baseValue >= dataArray[high] && low < high) high--;
				while (baseValue <= dataArray[low] && low < high)  low++;
			}
		
			if (low < high) CommonUtil.swapTwoIntDataInArray(dataArray, low, high);
		}
		// while处理结束后，low和high相等，将基准和low（high）上的值对换即可实现分成两部分
		CommonUtil.swapTwoIntDataInArray(dataArray, baseIndex, low);
		
		return low;
	}
	
	public static void quickSort(int[] dataArray, int low, int high, SortType sortType) {
		// 过滤不符合条件，直接return
		if (dataArray.length < 1 || low < 0 || high >= dataArray.length || low > high) return;
		
        int partitionIndex = partitionDataArray(dataArray, low, high, sortType);
        // 分成两部分后，继续对前后两部分做同样的处理
        if (partitionIndex > low)
        	quickSort(dataArray, low, partitionIndex - 1, sortType);
        if (partitionIndex < high)
        	quickSort(dataArray, partitionIndex + 1, high, sortType);
        return ;
	}
	
	public static void main(String[] args) {
		int[] dataArray = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
		
		System.out.println("快速排序用例");
		// 升序
		SortType sortType = SortType.SortType_Asc;
		quickSort(dataArray, 0, dataArray.length-1, sortType);
		System.out.println("升序排序后：");
		CommonUtil.printIntArrayData(dataArray);
		
		// 降序
		sortType = SortType.SortType_Desc;
		quickSort(dataArray, 0, dataArray.length-1, sortType);
		System.out.println("降序排序后：");
		CommonUtil.printIntArrayData(dataArray);

	}

}
