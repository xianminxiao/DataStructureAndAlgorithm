package com.xxm;

import com.xxm.CommonUtil;

public class InsertionSortMain {
	
	public static void insertSort(int[] dataArray, SortType sortType) {
		for (int i=0; i<dataArray.length; i++) {
			int willCompareData = dataArray[i];
			int j=i-1; 
			for (; j>=0; j--) {	
				// 根据排序方式，在适当条件下退出当前比较，结束数据往后挪动
				if (sortType == SortType.SortType_Asc) {
					if (dataArray[j] <= willCompareData) break;
				}
				else {
					if (dataArray[j] >= willCompareData) break;
				}
				dataArray[j+1] = dataArray[j];
			}
			// 将待比较的数据赋值到j+1位置上
			dataArray[j+1] = willCompareData;
		}
	}

	public static void main(String[] args) {
		int[] dataArray = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
	
		System.out.println("插入排序用例");
		// 升序
		SortType sortType = SortType.SortType_Asc;
		insertSort(dataArray, sortType);
		System.out.println("升序排序后：");
		CommonUtil.printIntArrayData(dataArray);
				
		// 降序
		sortType = SortType.SortType_Desc;
		insertSort(dataArray, sortType);
		System.out.println("降序排序后：");
		CommonUtil.printIntArrayData(dataArray);

	}

}
