package algoerxpertss.linked_list;

public class SumOfLinkedList {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        LinkedList answerHead = new LinkedList(-1);
        LinkedList dummyanswerHead = answerHead;
        int remainder = 0;
        LinkedList currentListOne = linkedListOne;
        LinkedList currentListTwo = linkedListTwo;
        while(currentListOne != null && currentListTwo != null){
            int tempAns = currentListOne.value + currentListTwo.value + remainder;
            if (tempAns < 10){
                remainder = 0;
                dummyanswerHead.next = new LinkedList(tempAns);
                dummyanswerHead = dummyanswerHead.next;
            } else {
                remainder = tempAns / 10;
                int realVal = tempAns % 10;
                dummyanswerHead.next = new LinkedList(realVal);
                dummyanswerHead = dummyanswerHead.next;

            }
            currentListOne = currentListOne.next;
            currentListTwo = currentListTwo.next;
        }

        while(currentListOne != null){
            if (remainder > 0){
                int newVal = currentListOne.value+ remainder;
                if (newVal < 10){
                    dummyanswerHead.next = new LinkedList(newVal);
                    dummyanswerHead = dummyanswerHead.next;
                    dummyanswerHead.next = currentListOne.next;
                    remainder = 0;
                    break;
                } else {
                    remainder = newVal / 10;
                    int realVal = newVal % 10;
                    dummyanswerHead.next = new LinkedList(realVal);
                    dummyanswerHead = dummyanswerHead.next;
                    if (currentListOne.next == null){
                        dummyanswerHead.next = new LinkedList(remainder);
                        dummyanswerHead = dummyanswerHead.next;
                        remainder = 0;
                        break;
                    }
                }
            } else {
                dummyanswerHead.next = currentListOne;
                break;
            }
            currentListOne = currentListOne.next;
        }

        while(currentListTwo != null){
            if (remainder > 0){
                int newVal = currentListTwo.value+ remainder;
                if (newVal < 10){
                    dummyanswerHead.next = new LinkedList(newVal);
                    dummyanswerHead = dummyanswerHead.next;
                    dummyanswerHead.next = currentListTwo.next;
                    remainder = 0;
                    break;
                } else {
                    remainder = newVal / 10;
                    int realVal = newVal % 10;
                    dummyanswerHead.next = new LinkedList(realVal);
                    dummyanswerHead = dummyanswerHead.next;
                    if (currentListTwo.next == null){
                        dummyanswerHead.next = new LinkedList(remainder);
                        dummyanswerHead = dummyanswerHead.next;
                        remainder = 0;
                    }
                }
            } else {
                dummyanswerHead.next = currentListTwo;
                break;
            }
            currentListTwo = currentListTwo.next;
        }

        if (remainder > 0){
            dummyanswerHead.next = new LinkedList(remainder);
        }

        return answerHead.next;
    }
}
