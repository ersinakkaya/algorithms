package QuickFind;

public class BinarySearch {

	public static boolean binarySearch(int target, int[] arr){
		int floorIndex = -1;
		int ceilingIndex = arr.length;
		
		while(floorIndex + 1 < ceilingIndex){
			int distance = ceilingIndex - floorIndex;
			int halfDistance = distance / 2;
			int guessIndex = floorIndex + halfDistance;
			
			if(arr[guessIndex] == target){
				return true;
			}
			else if(arr[guessIndex] > target){
				floorIndex = guessIndex;
			}
			else{
				ceilingIndex = guessIndex;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		//find if a target exists in sorted array via binarySearch
	}
}
