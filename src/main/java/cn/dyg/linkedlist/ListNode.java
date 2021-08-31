package cn.dyg.linkedlist;

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
