package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
  public static void main( String[] args ) {
    App app = new App();
    int [] param = {1,3,3};
    app.pivotIndex(param); 
  }

  /**
   * 左辺と右辺の合計が同一となるインデックスを返却する
   * 左辺と右辺の合計が同一となるインデックスが無ければ-1を返却する
   */  
  public int pivotIndex(int[] nums) {
    List<Integer> numsList = convertIntList(nums);  
    for (int x=0; x<numsList.size(); x++) {
      List<Integer> subListLeft = numsList. subList(0, x);
      List<Integer> subListRight = numsList.subList(x, numsList.size());
      if (equalListElemSum(subListLeft,subListRight)) {
	return x;
      }
    }

    return -1; 
  }

  /**
   *  引数で受け取った配列をListに変換する
   */
  public List<Integer> convertIntList(int[] nums) {
    List<Integer> intList = new ArrayList<>();
    for (int i : nums) {
      intList.add(i);
    }  
    return intList;
  }
  
  /**
   *  引数で受け取った2つのList<Integer>の要素の合計が等しいかどうかを判定する
   */ 
  public boolean equalListElemSum(List<Integer> a, List<Integer> b) {
    Integer aSum = null;
    Integer bSum = null;
    
    for (int e : a) {
      if (aSum == null) aSum = 0;
      aSum = aSum + e;
    }
    
    for (int e : b) {
      if (bSum == null) bSum = 0;
      bSum = bSum + e;
    }
    
    if (aSum != null && bSum != null && aSum.equals(bSum)) {
      return true; 
    } 
    return false;
  }
  
}
