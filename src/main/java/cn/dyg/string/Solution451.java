package cn.dyg.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution451 类是 451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 解法：计数排序
 *
 * @author dongyinggang
 * @date 2021-07-03 09:16
 **/
public class Solution451 {

    public String frequencySort(String s) {
        if (s.length() < 2) {
            return s;
        }
        //记录字符出现次数
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int freq = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), freq);
        }
        //根据value值降序排列
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));

        StringBuffer sb = new StringBuffer();
        list.forEach(item -> {
            for (int i = 0; i < map.get(item); i++) {
                sb.append(item);
            }
        });
        return sb.toString();
    }
}
