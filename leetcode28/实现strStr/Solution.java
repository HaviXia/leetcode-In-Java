package leetcode28.实现strStr;


class Solution {

    //KMP
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return (i - needle.length() + 1);
            }
        }
        return -1;
    }

    // KMP找next数组
    public void getNext(int[] next, String needle) {
        int j = -1; // next数组第一个位置是 -1
        next[0] = j;

        for (int i = 0; i < needle.length(); i++) {
            while (j >= 0 && needle.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (needle.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
    }


    // 暴力
    public int strStr1(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i + m <= n; i++) { // 最大只需要遍历到 n - m 就可以
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

}