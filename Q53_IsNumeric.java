/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"，“5e2”，"-123"，“3.1416"和”-1E-16"都表示数值。
 * 但是"12e"，“1a3.14”，“1.2.3”，"±5"和"12e+4.3"都不是。
 */
public class Q53_IsNumeric {
    public boolean isNumeric(char[] str) {
        String s = String.valueOf(str);
        // [+-]?表示正或负符号出现与否
        // [0-9]*表示整数部分
        // \\.[0-9]+表示小数点后紧跟整数
        // (\\.[0-9]+)?表示小数点与小数部分出现与否
        // [eE]表示指数符号
        // [+-]?表示正或负符号出现与否
        // [0-9]+表示紧跟整数
        // ([eE][+-]?[0-9]+)?表示指数部分出现与否
        return s.matches("[+-]?[0-9]*(\\.[0-9]+)?([eE][+-]?[0-9]+)?");
    }
}
