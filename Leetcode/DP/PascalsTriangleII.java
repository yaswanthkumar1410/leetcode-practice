
import java.util.*;

// LC 119 — Pascal's Triangle II
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        if(rowIndex == 0) return temp;
        temp.add(1);
        if(rowIndex == 1)  return temp;
        for(int i = 2; i <= rowIndex; i++) {
            result = new ArrayList<>();
            result.add(1);
            for(int j = 0; j < temp.size() - 1; j++) {
                result.add(temp.get(j) + temp.get(j + 1));
            }
            result.add(1);
            temp = new ArrayList<>(result);
        }
        return temp;
    }
}
