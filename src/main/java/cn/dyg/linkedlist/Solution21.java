package cn.dyg.linkedlist;

/**
 * Solution21 类是 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author dongyinggang
 * @date 2020-08-03 10:17
 **/
public class Solution21 {

    /**
     * mergeTwoLists 方法是 递归解法
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 升序链表
     * @author dongyinggang
     * @date 2020/8/3 10:50
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //任意一个链表为空时，停止递归
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        //哪个值较小,就取其next继续和val较大链表进行比较
        if(l1.val>l2.val){
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }else {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
    }
    /**
     * mergeTwoLists1 方法是 迭代解法
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 升序链表
     * @author dongyinggang
     * @date 2020/8/3 10:52
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        //构建一个新的ListNode,用来比较并构建返回值
        ListNode preHead = new ListNode(-1);
        //构建一个哨兵,用来记录新链表的头节点
        ListNode preReturn = preHead;
        //当l1和l2不为空时，进行比较，获取新链表的下一个节点是谁,
        //为空则说明不再需要比较,直接把不为空的链表拼接到新的链表中
        while(l1!=null&&l2!=null){
            //那个链表节点的val值小，就让新链表的下一个节点是它，并且它指向下一个节点
            if(l1.val<l2.val){
                preHead.next = l1;
                l1 = l1.next;
            }else {
                preHead.next = l2;
                l2 = l2.next;
            }
            preHead = preHead.next;
        }
        //新链表直接指向还有剩余节点的链表的当前节点
        preHead.next = l1 == null? l2:l1;
        //根据最开始标记新链表的头部节点的链表获取实际返回链表
        return preReturn.next;
    }
}

/**
 * ListNode 类是 链表节点类
 *
 * @author dongyinggang
 * @date 2020/8/3 11:00
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
