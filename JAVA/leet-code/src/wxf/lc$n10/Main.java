package wxf.lc$n10;

/**
 * @Description
 * @auther xuefeng
 * @create 2020-01-16 21:42
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("", ""));
        System.out.println(solution.isMatch("ab", ".*"));
        System.out.println(solution.isMatch("aab", "c*a*b"));
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
