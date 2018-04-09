import java.util.ArrayList;

/**
 *
 * 3. 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 * <p>
 * 给定一个字符串，找出不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例：
 * <p>
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * <p>
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * <p>
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串。
 *
 * 思路：
 *      遍历字符，同时将每次的字符保存到list集合中。
 *      倒序遍历list和字符进行比对，同时将倒序的元素按照正序存放到tempList中。，
 *      如果查到相等，则break出list循环。
 *      最终将此次新查询的字符添加到tempList中。
 *      tempList和max比对大小，进行更新。
 *      最后将tempList保存到list中，清空tempList。开始下一次字符遍历
 *
 */
public class code3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        char[] chars = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Character> tempList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            // 倒序进行比对，如果存在则跳出，保存大小，同时将之前的保存
            for (int j = list.size() - 1; j >= 0; j--) {
                Character temp = list.get(j);
                if (temp == c) {
                    break;
                } else {
                    tempList.add(0, temp);
                }
            }

            tempList.add(c);

            if (max < tempList.size()) {
                max = tempList.size();
            }
            list.clear();
            list.addAll(tempList);
            tempList.clear();
        }
        return max;
    }
}
