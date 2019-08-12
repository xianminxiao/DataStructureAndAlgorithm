package com.xxm;

import com.xxm.CommonUtil;

public class SelectionSortMain {
	
	public static boolean selectionSort(int[] dataArray, SortType sortType) {
		int dataArrayLength = dataArray.length;
		if (dataArrayLength <= 1)              // 数组元素超过1个才有意义走下面选择逻辑
			return true;
		
		// 控制选择的次数，从第二个元素开始
		for(int i = 1; i < dataArrayLength; i++) {
			int replaceIndex = i-1;            // 待替换元素的位置，即第几大（小）元素值
			int minOrMaxIndex = replaceIndex;  // 最大or最小值的位置标识
			
			for(int j=i; j<dataArrayLength; j++) {	
				if (sortType == SortType.SortType_Asc) {
					if(dataArray[j] < dataArray[minOrMaxIndex]) minOrMaxIndex = j;
				}
				else {
					if(dataArray[j] > dataArray[minOrMaxIndex]) minOrMaxIndex = j;
				}
			}
			
			// 只有当待替换的位置和选择出来的minOrMaxIndex不一致的时候才交换，在swapTwoIntDataInArray函数中有判断两个index是否相同情况
			CommonUtil.swapTwoIntDataInArray(dataArray, replaceIndex, minOrMaxIndex);
		}
		return true;
	}

	public static void main(String[] args) {		
		int[] dataArray = new int[]{6, 5, 3, 1, 8, 7, 2, 4};

		System.out.println("选择排序用例");
		// 升序
		SortType sortType = SortType.SortType_Asc;
		selectionSort(dataArray, sortType);
		System.out.println("升序排序后：");
		CommonUtil.printIntArrayData(dataArray);
		
		// 降序
		sortType = SortType.SortType_Desc;
		selectionSort(dataArray, sortType);
		System.out.println("降序排序后：");
		CommonUtil.printIntArrayData(dataArray);

	}

}
