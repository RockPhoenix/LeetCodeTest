public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        //总字符串长度
        int length = s.length();
        //长度为1直接返回false
        if (length <= 1) return false;
        //通过定位首字母找寻子串,有可能有多个结果
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == s.charAt(0)) {
                String child = s.substring(0, i);
                int childLength = child.length();
                //若该子串长度与总字符串长度取余不为0则该子串肯定为错误结果继续寻找
                if (length % childLength != 0) continue;
                //子串重复次数
                int repeatTimes = length / childLength;
                //循环从总字符串中比较子串,成功一次重复次数减1
                for (int j = 0; j < length; j += childLength) {
                    if (s.startsWith(child, j)) {
                        repeatTimes--;
                    }
                }
                //如果子串重复次数减为0则说明定位成功返回true
                if (repeatTimes == 0)return true;
            }
        }
        return false;
    }

}
