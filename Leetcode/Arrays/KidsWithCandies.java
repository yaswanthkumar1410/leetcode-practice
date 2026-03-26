
import java.util.*;

// LC 1431 — Kids With the Greatest Number of Candies
public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int mostCandies = Integer.MIN_VALUE;
        List<Boolean> result = new ArrayList<>();
        for(int i : candies) {
            mostCandies = Math.max(mostCandies, i);
        }
        for(int i : candies) {
            result.add(i + extraCandies >= mostCandies);
        }
        return result;
    }
}
