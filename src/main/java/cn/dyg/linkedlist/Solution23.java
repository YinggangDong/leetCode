package cn.dyg.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution23 类是 23. 合并K个升序链表
 *
 * @author dongyinggang
 * @date 2021-08-31 09:14
 **/
public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> valList = new ArrayList();
        //把所有的val值放到list中
        for (ListNode list : lists) {
            ListNode ln = list;
            while (null != ln) {
                valList.add(ln.val);
                ln = ln.next;
            }
        }
        //排序
        Collections.sort(valList);
        //哨兵节点
        ListNode pre = new ListNode();
        //创建新的链的指针
        ListNode cur = pre;
        //遍历lit，根据val创建节点并通过cur指针连接起来
        for (Integer val : valList) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        //返回哨兵节点指向的头节点
        return pre.next;
    }
}
