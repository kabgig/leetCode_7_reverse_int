import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        if (x == 0) return 0;

        if (isNegative) x = Math.abs(x);
        while (x % 10 == 0) x /= 10;
        String number = Integer.toString(x);
        ArrayList<Character> newNumber = new ArrayList<>();

        for (int i = number.length() - 1; i >= 0; i--) {
            newNumber.add(number.charAt(i));
        }

        String betweenStr = newNumber
                .stream()
                .map(Objects::toString)
                .collect(Collectors.joining(""));
        if (isNegative) betweenStr = "-" + betweenStr;

        int res = Integer.parseInt(betweenStr);

        if (-Math.pow(2, 31) <= res || res <= Math.pow(2, 31) - 1) return res;
        else return 0;
    }
}