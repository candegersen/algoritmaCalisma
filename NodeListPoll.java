
import java.util.*;

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

public class NodeListPoll {

    public ListNode mergeKLists(ListNode[] lists) {
        //listenin başındaki elemanları saklamak için min heap kullanılır
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // öbeğin ilk elemanları ile başlatılır
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // başka gidecek liste kalmayana kadar öbeğe eleman eklenir
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll(); // öncelik sıralamasına göre en küçük eleman alınır
            current.next = node;
            current = current.next; // sonraki düğüme geçer

            // eğer düğümün bir sonraki elemanı boş değil ise öbeğe eklenir
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }

        return dummy.next; // dummy'nin bir sonraki elemanı geri döndürülür çünkü dummy placeholder olarak kullanılır.
    }
}
