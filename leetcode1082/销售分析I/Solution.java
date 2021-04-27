package leetcode1082.销售分析I;


public class Solution {
    // 编写一个 SQL 查询，查询总销售额最高的销售者，如果有并列的，就都展示出来
    // 只需要用到 sales 表
    /*
     *   对总的 sum(price) 按 seller_id 进行分组之后，降序排序，使用 limit 1 ，只取头一个
     *   如果只取第一个话，不能实现把所有的 seller_id 都取出来
     *
     *   使用 subquery 找到这个 销售额度，然后根据这个 销售额度 来查找所有的 seller_id
     * */
    String subQuerySolution = " select sum(price) as pr from Sales group by seller_id order by pr DESC limit 1 ";
    String solution = " select seller_id from Sales " +
            "group by seller_id " +
            "having sum(price) = (select sum(price) as pr " +
            "from Sales group by seller_id order by pr DESC limit 1 )";
}
