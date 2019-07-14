/**
 * 请实现一个函数用来匹配包括‘.’和‘*’的正则表达式。模式中的字符‘.’表示任意一个字符，
 * 而‘*’表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配。
 */
public class Q52_Match {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        // 如果模式串的下一个字符是‘*’，则进入状态机的匹配
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            // 如果字符串和模式串相等，或者模式串是‘.’，并且字符串没有到结尾，则继续匹配
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                // 分三种情况，进入下一状态：
                // 1）匹配到一个，例如：
                // abc和ab*c，strIndex在b，patternIndex在b时，strIndex往后移动一位到c，patternIndex往后移动2位到c
                return matchCore(str, strIndex + 1, pattern, patternIndex + 2) ||
                        // 2）匹配到连续多个，继续拿这个‘*’去匹配，例如：
                        // aaa和a*，strIndex在第一个a，patternIndex在a，strIndex往后移动一位，patternIndex不动
                        matchCore(str, strIndex + 1, pattern, patternIndex) ||
                        // 3）匹配到零个，跳过这个‘*’，例如：
                        // ac和a.*c，strIndex在c，patternIndex在.，strIndex不动，patternIndex往后移动2位到c
                        matchCore(str, strIndex, pattern, patternIndex + 2);
            } else {
                // 如果字符串和模式串不相等，则跳过当前模式串的字符和‘*’，进入新一轮的匹配
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        // 如果字符串和模式串相等，或者模式串是‘.’，并且字符串没有到结尾，则继续匹配
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
