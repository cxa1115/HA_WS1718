import java.util.Random;
import java.util.Arrays;

public class InsertionSort {
  public static int[] sortR(int[] arr) {
    // TODO
    InsertionSortRecursion(arr, 1, 0, -1);
    return arr;
  }

  public static void InsertionSortRecursion(int [] arr,  int unsortedIndex, int key,  int sortedIndex){
		
		if(unsortedIndex <= arr.length){
			
			if(sortedIndex == -1 && key == 0 ){
				if(unsortedIndex != arr.length)
					InsertionSortRecursion(arr, unsortedIndex +1,arr[unsortedIndex],unsortedIndex-1);
			}
			else{
				if(sortedIndex == -1 || arr[sortedIndex] < key){
					arr[sortedIndex+1] = key;
					sortedIndex = 0;
					key = 0;
				}
				else{
					arr[sortedIndex+1] = arr[sortedIndex];
				}
				InsertionSortRecursion(arr,unsortedIndex,key,sortedIndex - 1);				
			}			
		}
	}

  // Hilfsmethoden hier einfuegen.

  public static int[] sortI(int[] arr) {
    for(int upto = 1; upto < arr.length; ++upto) {
      for(int current = upto; current > 0; --current) {
        if(arr[current] >= arr[current-1]) {
          break;
        } else {
          //aktuelles Element gehoert weiter vorne einsortiert
          int tmp = arr[current];
          arr[current] = arr[current-1];
          arr[current-1] = tmp;
        }
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    Random rng = new Random();
    boolean passed = true;

    passed &= test(new int[0]);
    {
      int[] arr = new int[1];
      arr[0] = rng.nextInt(20) - 7;
      passed &= test(arr);
    }
    for(int i = 0; i < 10; ++i) {
      int[] arr = new int[rng.nextInt(20)];
      for(int j = 0; j < arr.length; ++j) {
        arr[j] = rng.nextInt(20) - 7;
      }
      passed &= test(arr);
    }

    if(passed) {
      System.out.println("All tests passed.");
    } else {
      System.out.println("Some tests failed!");
    }
  }

  private static boolean test(int[] arr) {
    int[] resA = sortI(Arrays.copyOf(arr, arr.length));
    int[] resB = sortR(Arrays.copyOf(arr, arr.length));

    System.out.println(Arrays.toString(resA));
    System.out.println(Arrays.toString(resB));

    return Arrays.equals(resA, resB);
  }
}
