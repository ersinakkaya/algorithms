public class ArrayOfArrays{
	
	public static int[] answer(int[] num){
		  int[] result = new int[num.length];
		  int[] productsOfAllIntsAfterIndex = new int[num.length];

		  int productSoFar = 1;
		  for (int i = num.length - 1; i >= 0; i--) {
		      productsOfAllIntsAfterIndex[i] = productSoFar;
		      productSoFar *= num[i];
		  }
		  
		  productSoFar = 1;
		  for(int i = 0; i < num.length; i++){
			  result[i] = productsOfAllIntsAfterIndex[i] * productSoFar;
			  productSoFar *= num[i];
		  }

		return result;
	}

	public static void main(String[] args){
	int[] data =   {2, 4, 8};
		int[] resp = answer(data);
		for(int i : resp){
			System.out.println(i);
		}
	}	
}

//Runtime complexity = O(n)
//Space Complexity = O(n)