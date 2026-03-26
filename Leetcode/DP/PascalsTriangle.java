
import java.util.*;

// LC 118 — Pascal's Triangle
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        result.add(new ArrayList<>(temp));
        if(numRows == 1) return result;
        temp.add(1);
        result.add(new ArrayList<>(temp));
        for(int i = 2; i < numRows; i++) {
            result.add(buildNextLayer(result.get(i - 1)));
        }
        return result;
    }

    public List<Integer> buildNextLayer(List<Integer> preList) {
        List<Integer> newLayer = new ArrayList<>();
        newLayer.add(1);
        for(int i = 0; i < preList.size() - 1; i++) {
            newLayer.add(preList.get(i) + preList.get(i+1));
        }
        newLayer.add(1);
        return newLayer;
    }
}
