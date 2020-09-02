package test;

public class valid_palindrome_125 {

    /**
     * 125. 验证回文串
     *
     * 难度简单266收藏分享切换为英文关注反馈给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     *
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     *
     *
     * 示例 2:
     *
     * 输入: "race a car"
     * 输出: false
     *
     * */
        public boolean isPalindrome1(String s) {
            /**
             * 法一
             *
             *  主干逻辑
             *  1.只考虑字母和数字字符，转为新String
             *  2.倒转过来判断是否跟去掉多余字符的数组相等
             * */


        String filteredS = _filterNonNumberAndChar(s);
        String reversedS = _reverseString(filteredS);
        return reversedS.equalsIgnoreCase(reversedS);


    }

    private String _reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private String _filterNonNumberAndChar(String s) {
        return s.replaceAll("[^A-Za-z0-9]","");
    }


    public boolean isPalindrome2(String s) {
       /**
        * 法二
        * 对字符串进行一次遍历，并将其中的字母和数字字符进行保留，放在另一个字符串
        */
        StringBuilder newS = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                newS.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder reversedS = new StringBuilder(newS).reverse();
        return reversedS.toString().equals(newS.toString());
    }

    public boolean isPalindrome3(String s) {
            /**
             * 法3
             *  我们还可以在比较之前字母全部转化为小写，这里改为for循环的方式，
             *  只不过是换汤不换药，原理还都是一样的
             * */

        if (s ==null || s.length() ==0){
            return true;
        }
        s = s.toLowerCase();
        for (int i =0,j = s.length()-1;i<j;i++,j--){
            while (i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while (i<j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }


}
