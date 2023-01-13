import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        boolean canAdd = false;
        if (x == 0) return 0;
        if (-Math.pow(2, 31) >= x || x >= Math.pow(2, 31) - 1) return 0;


        if (isNegative) x = Math.abs(x);
        while (x % 10 == 0) x /= 10;

        String number = Integer.toString(x);

        ArrayList<Character> newNumber = new ArrayList<>();

        for (int i = number.length() - 1; i >= 0; i--) {
            newNumber.add(number.charAt(i));
        }

        String betweenStr = newNumber.stream().map(Objects::toString)
                .collect(Collectors.joining(""));
        if (isNegative) betweenStr = "-" + betweenStr;

        int res1 = Integer.parseInt(betweenStr);

        if (-Math.pow(2, 31) <= res1 || res1 <= Math.pow(2, 31) - 1) return res1;
        else return 0;
    }
}