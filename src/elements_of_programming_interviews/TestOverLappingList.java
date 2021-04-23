package elements_of_programming_interviews;

public class TestOverLappingList {

    public static ListNode<Integer> overlappingNoCycleLists(ListNode<Integer> L1, ListNode<Integer> L2) {
        int length1 = length(L1), lenght2 = length(L2);
        if (length1 > lenght2) {
            L1 = advanceListByK(length1 - lenght2, L1);
        } else {
            L2 = advanceListByK(lenght2 - lenght2, L2);
        }

        while (L1 != L2 && L1 != null && L2 != null) {
            L1 = L1.next;
            L2 = L2.next;
        }
        return L1;
    }

    public static ListNode<Integer> advanceListByK(int k, ListNode<Integer> L) {
        while (k-- > 0) {
            L = L.next;
        }
        return L;
    }

    public static int length(ListNode<Integer> L) {
        int len = 0;
        while (L != null) {
            len++;
            L = L.next;
        }

        return len;
    }
}
