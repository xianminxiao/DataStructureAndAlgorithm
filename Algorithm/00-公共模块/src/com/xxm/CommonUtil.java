package com.xxm;

/*
 * 提供公共模块的一些工具函数，抽象能力模块
 * 
 */
public class CommonUtil {
	
	/*
	 *  打印int数组元素，用每个元素值用->拼接
	 *  @param dataArray 待打印的int数组  
	 *  @Author: xxm  
	 *  
	 */
	public static void printIntArrayData(int[] dataArray) {
		for (int i = 0; i < dataArray.length; i++) {
			System.out.print(dataArray[i]);
			if (i != dataArray.length-1) {
				System.out.print(" -> ");
			}
		}
		System.out.println("");
	}
	
	/*
	 *  交换int数组中两个位置元素的值
	 *  @param dataArray 待交换的int数组
	 *         index1    交换位置1
	 *         index2    交换位置2
	 *  @return boolean，如果index1或者index2大于等于数组大小，index1==index2，会返回false
	 *  @Author: xxm
	 *  
	 */
	public static boolean swapTwoIntDataInArray(int[] dataArray, int index1, int index2) {	
		int dataArrayLength = dataArray.length;
		if (index1 >= dataArrayLength || index2 >= dataArrayLength || index1 == index2) return false;
		
		dataArray[index1] = dataArray[index1] ^ dataArray[index2];  
		dataArray[index2] = dataArray[index1] ^ dataArray[index2];  
		dataArray[index1] = dataArray[index1] ^ dataArray[index2]; 
		
		return true;
	}

}
