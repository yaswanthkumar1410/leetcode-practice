
import java.util.*;

public class DailyTemperatures {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}))); // [1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,40,50,60})));              // [1,1,1,0]
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,60,90})));                 // [1,1,0]
    }

    // ============================================
    // LC 739 — Daily Temperatures
    // ============================================
    // Given daily temperatures, return an array where
    // result[i] is how many days you have to wait for
    // a warmer temperature. If no future day is warmer,
    // result[i] = 0.
    // ============================================
    static int[] dailyTemperatures(int[] temperatures) {
        // your code here
        int[] waitDays = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prev = stack.pop();
                waitDays[prev] = i - prev;
            }
            stack.add(i);
        }
        return waitDays;
    } 
}
