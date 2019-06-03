import java.lang.reflect.Array;
public class sort {

	public double midNum( double[] array1,double[] array2)
	{
   	   int length1=array1.length;
       int length2=array2.length;
       double midNum = 0;
	   
//一奇一偶情况;将奇数数列放置第一个
	   if (length1==0||length2==0) {
		if ((length1==0)&&(length2==0)) {
			System.out.println("No median!");
			return 0;
		}else if (length1==0) {
			if (length2%2==0) {
				return midNum=(array2[length2/2-1]+array2[length2/2])/2;
			}else {
				return midNum=array2[length2/2];
			}
		}else if (length2==0) {
			if (length1%2==0) {
				return midNum=(array1[length1/2-1]+array1[length1/2])/2;
			}else {
				return midNum=array1[length1/2];
			}
		}
	   }else if ((length1%2==1&&length2%2==0)||(length2%2==1&&length1%2==0)) {//位运算解决
	   if (length1%2==1) {
			midNum=oddAndEven(array1,array2);
		}else {
			midNum=oddAndEven(array2,array1);
		}
	}//两个偶数数列情况
	else if ((length1%2==0)&&(length2%2==0)) {
	midNum=twoEven(array1, array2);
	}//两个奇数数列情况
	else if ((length1%2==1)&&(length2%2==1)) {
	midNum=twoOdd(array1, array2);
	}
	return midNum ;
	}
	
	
	
	  
	public double oddAndEven(double[] array1, double[] array2) {//默认第一个为奇数个数字
		 double midNum = 0;
		 double set1max;
		 double set2min;
		 int length1=array1.length;
	     int length2=array2.length;
		 
		 if (length1==1) {//奇数数列只有一个数字的情况
			int index2=length2/2-1;//set1 element, not set2
			if (array1[0]<=array2[index2]) {//返回array2set1中的最后一个
			 midNum=array2[index2];
			}else if (array1[0]>array2[index2]&&array1[0]<=array2[index2+1]) {//返回array1set1中唯一个元素
			 midNum=array1[0];
			}else if (array1[0]>array2[index2+1]) {//返回array2set2中的最前一个
			 midNum=array2[index2+1];
			}
		 }else {//奇数数列超过1个数字的情况，取set2最小值
			 
			 int index1=length1/2-1;//set1 element, not set2
		     int index2=length2/2-1;//set1 element, not set2
		    
		     set1max = array1[index1]>array2[index2] ? array1[index1]:array2[index2];
		     set2min = array1[index1+1]<array2[index2+1] ? array1[index1+1]:array2[index2+1];
		     
		     
		     
		     while (set1max>set2min) {//未完成取中位数，移动下标满足的条件
		    	 		if (array1[index1]>array2[index2+1]) {//集合1中array1的最右元素大于array2set2中最左元素
		    	 				if (index1==0) {
		    	 					set2min = array1[index1]<array2[index2+2] ? array1[index1]:array2[index2+2];
		    	 					midNum=set2min;
		    	 					return midNum;
		    	 				}else if ((index2+1)==length2-1) {
		    	 					set2min =array1[index1];
		    	 					midNum=set2min;
		    	 					return midNum;
								}else{
		    	 					index1=index1-1;
		    	 					index2=index2+1;
		    	 					set1max = array1[index1]>array2[index2] ? array1[index1]:array2[index2];
		    	 					set2min = array1[index1+1]<array2[index2+1] ? array1[index1+1]:array2[index2+1];
		    	 				}
		    	 		}else if (array2[index2]>array1[index1+1]) {
		    	 			if (index2==0) {
		    	 				index1=index1+1;
		    	 				set2min = array1[index1+1]<array2[index2] ? array1[index1+1]:array2[index2];
		    	 				midNum =set2min;
		    	 				return midNum;
							}else if (index1+1==(length1-1)) {
								set2min=array2[index2];
								midNum=set2min;
								return midNum;
							}else {
								index1=index1+1;
								index2=index2-1;
								 set1max = array1[index1]>array2[index2] ? array1[index1]:array2[index2];
							     set2min = array1[index1+1]<array2[index2+1] ? array1[index1+1]:array2[index2+1];
							}
						}
			}
		   midNum=set2min;
		}
		return midNum;
	}
		    	 	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		    	 	
	public double twoOdd(double[] array1, double[] array2) {
		double set1max,set2min;
		int length1=array1.length, length2=array2.length,index1,index2;
		double  midNum = 0;
		if ((length1==1)&&(length2==1))
		{
			midNum=(array1[0]+array2[0])/2;
			return midNum;
		}else if (length1==1) {//array1只有一个数字的情况
			index2=length2/2-1;//set1 element, not set2
			if (array1[0]<=array2[index2]) {//array1[0]小于array2[index2]
			 midNum=(array2[index2]+array2[index2+1])/2;
			 return midNum;
			}else if ((array1[0]>array2[index2])&&array1[0]<=array2[index2+1]) {
			 midNum=(array1[0]+array2[index2+1])/2;
			 return midNum;
			}else if ((array1[0]>array2[index2+1])&&(array1[0]<=array2[index2+2])) {//
			 midNum=(array2[index2+1]+array1[0])/2;
			 return midNum;
			}else{
				midNum=(array2[index2+1]+array2[index2+2])/2;
				return midNum;
			}
		}else if (length2==1) {//array2只有一个数字
			double[] array3=array1;
			array1=array2;
			array2=array3;
			length1=array1.length;
			length2=array2.length;
			index2=length2/2-1;//set1 element, not set2
			if (array1[0]<=array2[index2]) {//array1[0]小于array2[index2]
			 midNum=(array2[index2]+array2[index2+1])/2;
			 return midNum;
			}else if ((array1[0]>array2[index2])&&array1[0]<=array2[index2+1]) {
			 midNum=(array1[0]+array2[index2+1])/2;
			 return midNum;
			}else if ((array1[0]>array2[index2+1])&&(array1[0]<=array2[index2+2])) {//
			 midNum=(array2[index2+1]+array1[0])/2;
			 return midNum;
			}else{
			midNum=(array2[index2+1]+array2[index2+2])/2;
			return midNum;
			}
		}else {//都大于或等于三个数字
			index1=length1/2;
			index2=(length2/2)-1;
			set1max=array1[index1]>array2[index2]?array1[index1]:array2[index2];
			set2min=array1[index1+1]<array2[index2+1]?array1[index1+1]:array2[index2+1];
			while (set1max>set2min) {
				if (array1[index1]>array2[index2+1]) {//上左下右
					if ((index1==0)&&(index2==(length2-2))) {
						midNum=(array1[index1]+array2[index2+1])/2;
						return midNum;
					}else if (index1==0) {
						set2min=array1[index1]<array2[index2+2]?array1[index1]:array2[index2+2];
						midNum=(array2[index2+1]+set2min)/2;
						return midNum;
					}else if (index2==(length2-2)) {
						set1max=array1[index1-1]>array2[index2+1]?array1[index1-1]:array2[index2+1];
						midNum=(set1max+array1[index1])/2;
						return midNum;
					}else {
						index1=index1-1;
						index2=index2+1;
						set1max=array1[index1]>array2[index2]?array1[index1]:array2[index2];
						set2min=array1[index1+1]<array2[index2+1]?array1[index1+1]:array2[index2+1];
					}
				}else if (array2[index2]>array1[index1+1]) {//上右下左
					if ((index2==0)&&(index1==(length1-2))) {
						midNum=(array2[index2]+array1[index1+1])/2;
						return midNum;
					}else if (index2==0) {
						set2min=array2[index2]<array1[index1+2]?array2[index2]:array1[index1+2];
						midNum=(array1[index1+1]+set2min)/2;
						return midNum;
					}else if (index1==(length1-2)) {
						set1max=array2[index2-1]>array1[index1+1]?array2[index2-1]:array1[index1+1];
						midNum=(set1max+array2[index2])/2;
						return midNum;
					}else {
						index1=index1+1;
						index2=index2-1;
						set1max=array1[index1]>array2[index2]?array1[index1]:array2[index2];
						set2min=array1[index1+1]<array2[index2+1]?array1[index1+1]:array2[index2+1];
					}
				}
			}
			
				midNum=(set1max+set2min)/2;
		}
		return midNum;
	}
	
	
	
	//-------------------------------------------------------------------------
	public double twoEven(double[] array1, double[] array2) {
		double set1max,set2min;
		int length1=array1.length, length2=array2.length,index1,index2;
		double  midNum = 0;
		
			index1=(length1/2)-1;
			index2=(length2/2)-1;
			set1max=array1[index1]>array2[index2]?array1[index1]:array2[index2];
			set2min=array1[index1+1]<array2[index2+1]?array1[index1+1]:array2[index2+1];
			while (set1max>set2min) {
				if (array1[index1]>array2[index2+1]) {//上左下右
					if ((index1==0)&&(index2==(length2-2))) {
						midNum=(array1[index1]+array2[index2+1])/2;
						return midNum;
					}else if (index1==0) {
						set2min=array1[index1]<array2[index2+2]?array1[index1]:array2[index2+2];
						midNum=(array2[index2+1]+set2min)/2;
						return midNum;
					}else if (index2==(length2-2)) {
						set1max=array1[index1-1]>array2[index2+1]?array1[index1-1]:array2[index2+1];
						midNum=(set1max+array1[index1])/2;
						return midNum;
					}else {
						index1=index1-1;
						index2=index2+1;
						set1max=array1[index1]>array2[index2]?array1[index1]:array2[index2];
						set2min=array1[index1+1]<array2[index2+1]?array1[index1+1]:array2[index2+1];
					}
				}else if (array2[index2]>array1[index1+1]) {//上右下左
					if ((index2==0)&&(index1==(length1-2))) {
						midNum=(array2[index2]+array1[index1+1])/2;
						return midNum;
					}else if (index2==0) {
						set2min=array2[index2]<array1[index1+2]?array2[index2]:array1[index1+2];
						midNum=(array1[index1+1]+set2min)/2;
						return midNum;
					}else if (index1==(length1-2)) {
						set1max=array2[index2-1]>array1[index1+1]?array2[index2-1]:array1[index1+1];
						midNum=(set1max+array2[index2])/2;
						return midNum;
					}else {
						index1=index1+1;
						index2=index2-1;
						set1max=array1[index1]>array2[index2]?array1[index1]:array2[index2];
						set2min=array1[index1+1]<array2[index2+1]?array1[index1+1]:array2[index2+1];
					}
				}
			}
				midNum=(set1max+set2min)/2;
		
		return midNum;
	}
	
}
