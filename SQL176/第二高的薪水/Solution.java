package SQL176.第二高的薪水;

/**
 * @author ：hkxia
 * @description：TODO
 * @date ：2021/4/19 20:51
 */
public class Solution {
    public static void main(String[] args) {
        // 成绩有相同的值，使用 Distinct 去重
        /*
         *  max(列名) 返回该列的最大值
         * */

        String FindMaxSalary = "select max(Salary) as SecondHighestSalary from Employee";

        String solution = "select Salary AS SecondHighestSalary from Employee where Salary < (select max(Salary) from Employee) ";
    }
}
