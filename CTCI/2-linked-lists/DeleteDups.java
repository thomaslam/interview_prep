public class DeleteDups {
  // SOLUTION 1: Use external buffer. Takes O(n) time
  // We need to keep track of duplicate elements using simple hash table.
  public void deleteDups(LinkedListNode n) {
    HashSet<Integer>() set = new HashSet<Integer>();
    LinkedListNode previous = null;
    while (n != null) {
      if (set.contains(n.data)) {
        previous.next = n.next;
      } else {
        set.add(n.data);
        previous = n;
      }
      n = n.next;
    }
  }

  // SOLUTION 2: Runner method. Takes O(n^2) time
  public void deleteDups(LinkedListNode n) {
    LinkedListNode curr = n;
    while (n != null) {
      LinkedListNode runner = n.next;
      while (runner != null) {
      }

    }
  }
}
