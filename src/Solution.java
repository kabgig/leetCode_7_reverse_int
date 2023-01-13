import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        boolean canAdd = false;
        if (x < 0) isNegative = true;


        String number = Integer.toString(x);
        if (isNegative) number = number.replace('-', ' ').trim();

        ArrayList<Character> newNumber = new ArrayList<Character>();

        for (int i = number.length() - 1; i >= 0; i--) {
            if (number.charAt(i) == 0) {
                if (canAdd) newNumber.add(number.charAt(i));
                else {}
            } else {
                newNumber.add(number.charAt(i));
                canAdd = true;
            }
        }
        String betweenStr = newNumber.stream().map(Objects::toString)
                .collect(Collectors.joining(""));
        if (isNegative) betweenStr = "-" + betweenStr;

        int res1 = Integer.parseInt(betweenStr);

        if (-Math.pow(2, 31) <= res1 || res1 <= Math.pow(2, 31) - 1) return 0;
        else return res1;
    }
}