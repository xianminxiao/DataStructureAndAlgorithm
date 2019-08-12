package com.xxm;

import com.xxm.CommonUtil;

public class ShellSortMain {

	public static void shellSort(int[] dataArray, SortType sortType) {
		int dataArrayLength = dataArray.length;
		int step = dataArrayLength / 2;
		
        while (step > 0) {
            for (int i = step; i < dataArrayLength; i++) {
                int temp = dataArray[i];
                int preIndex = i - step;
                while (preIndex >= 0 && dataArray[preIndex] > temp) {
                	dataArray[preIndex + step] = dataArray[preIndex];
                    preIndex -= step;
                }
                dataArray[preIndex + step] = temp;
            }
            step /= 2;
        }
	}

	public static void main(String[] args) {
		int[] dataArray = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
	
		System.out.println("希尔排序用例");
		// 升序
		SortType sortType = SortType.SortType_Asc;
		shellSort(dataArray, sortType);
		System.out.println("升序排序后：");
		CommonUtil.printIntArrayData(dataArray);
				
		// 降序
		sortType = SortType.SortType_Desc;
		shellSort(dataArray, sortType);
		System.out.println("降序排序后：");
		CommonUtil.printIntArrayData(dataArray);

	}

}
