package com.xxm;

import com.xxm.CommonUtil;

public class MergeSortMain {

	public static void merge(int[] dataArray, int left, int mid, int right, SortType sortType) {
		int[] tmp = new int[right-left+1];   // 辅助数组，归并排序
		int point1 = left;                   // point1指向待合并数组左侧的第一个元素
		int point2 = mid+1;                  // 指向待合并数组的右侧的第一个元素，这边mid放到左侧中，所以需要➕1
		int point3 = 0;                      // tmp的游标
		
		while (point1 <= mid && point2 <= right) {
			// 根据sortType将小的（或大的）移动tmp数组中
			if (sortType == SortType.SortType_Asc) {
				tmp[point3++] = (dataArray[point1]<=dataArray[point2]) ? dataArray[point1++] : dataArray[point2++];
			}
			else {
				tmp[point3++] = (dataArray[point1]<=dataArray[point2]) ? dataArray[point2++] : dataArray[point1++];
			}
		}
		
		// 如果左边序列未检测完，将剩余元素加到合并的序列中
		while (point1 <= mid) {
			tmp[point3++] = dataArray[point1++];
		}
		// 如果右边序列未检测完，将剩余元素加到合并的序列中
		while (point2 <= right) {
			tmp[point3++] = dataArray[point2++];
		}
		
		// 用tmp数组覆盖dataArray数据
		for (int i = 0; i < tmp.length; i++) {
			dataArray[left+i] = tmp[i];
		}
	}
	
	public static void mergeSort(int[] dataArray, int start, int end, SortType sortType) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(dataArray, start, mid, sortType);
			mergeSort(dataArray, mid+1, end, sortType);
			merge(dataArray, start, mid, end, sortType);
		}
	}

	public static void main(String[] args) {
		int[] dataArray = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
		
		System.out.println("归并排序用例");
		// 升序
		SortType sortType = SortType.SortType_Asc;
		mergeSort(dataArray, 0, dataArray.length-1, sortType);
		System.out.println("升序排序后：");
		CommonUtil.printIntArrayData(dataArray);
		
		// 降序
		sortType = SortType.SortType_Desc;
		mergeSort(dataArray, 0, dataArray.length-1, sortType);
		System.out.println("降序排序后：");
		CommonUtil.printIntArrayData(dataArray);
	}

}
