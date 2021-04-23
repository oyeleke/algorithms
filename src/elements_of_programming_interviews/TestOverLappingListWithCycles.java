package elements_of_programming_interviews;

public class TestOverLappingListWithCycles {

    public static ListNode<Integer> overlappingLists(ListNode<Integer> L1, ListNode<Integer> L2){

        ListNode<Integer>root1 = CircularList.hasCycle2(L1);
        ListNode<Integer>root2 = CircularList.hasCycle2(L2);

        if (root1 == null && root2 == null){
            return overlappingLists(L1, L2);
        } else if((root1 != null && root2 == null) || (root1 == null && root2 != null)){
            return null;
        }
        // test if cycles re not separate
        ListNode<Integer>temp = root2;
        do {
            temp = temp.next;
        } while (root1 != temp && root2 != temp);

        if (root1 != temp) return null; // cycles re disjoint

        int stem1Lenght = distance(L1, root1), stem2Length = distance(L2, root2);

        if (stem1Lenght > stem2Length){
            L1 = TestOverLappingList.advanceListByK(stem1Lenght - stem2Length, L1);
        } else {
            L2 = TestOverLappingList.advanceListByK(stem2Length - stem1Lenght, L2);
        }

        while (L1 != L2 && L1 != root1 && L2 != root2){
            L1 = L1.next;
            L2 = L2.next;
        }

        return L1== L2 ? L1 : root1;
    }

    public static int distance(ListNode<Integer>a, ListNode<Integer>b){
        int dis = 0;
        while (a != b){
            a = a.next;
            ++dis;
        }

        return dis;
    }

}
