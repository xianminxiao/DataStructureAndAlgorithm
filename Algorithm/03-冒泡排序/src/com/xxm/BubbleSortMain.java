package com.xxm;

import com.xxm.CommonUtil;

public class BubbleSortMain {
	
	public static void bubbleSort(int[] dataArray, SortType sortType) {
		int dataArrayHandleLength = dataArray.length - 1;   // 数组冒泡次数，最后一位就不处理，所以要减去1
		
        for(int i = 0;i < dataArrayHandleLength; i++) {     // 冒泡次数
        	// 比较的次数，比较大or比较小已经冒泡到末尾，不比较，要减去相应次数
            for(int j=0;j<dataArrayHandleLength-i;j++) {    
            	if (sortType == SortType.SortType_Asc) {
            		// 前面的元素小于后面的元素 调换位置
            		if(dataArray[j] > dataArray[j+1]) CommonUtil.swapTwoIntDataInArray(dataArray, j, j+1);
				}
				else {
					// 前面的元素大于后面的元素 调换位置
					if(dataArray[j]<dataArray[j+1]) CommonUtil.swapTwoIntDataInArray(dataArray, j, j+1);
				}
            }
        }
	}

	public static void main(String[] args) {
		int[] dataArray = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
		
		System.out.println("冒泡排序用例");
		// 升序
		SortType sortType = SortType.SortType_Asc;
		bubbleSort(dataArray, sortType);
		System.out.println("升序排序后：");
		CommonUtil.printIntArrayData(dataArray);
		
		// 降序
		sortType = SortType.SortType_Desc;
		bubbleSort(dataArray, sortType);
		System.out.println("降序排序后：");
		CommonUtil.printIntArrayData(dataArray);

	}

}
