# LinkedList
Cycle Detection

Floyd's algo - see also Brent's algo

Fast/slow pointers eventually meet
```
bool hasCycle(Node head)
    Node fast = head
    Node slow = head
        
    while(fast && fast.next)
        slow = slow.next
        fast = fast.next.next
    
        if(slow == fast)
            return true
    
    return false
```

Dutch Flag Sort

3 pointers plus anchor

```

```

### flatten a list
multiple lists linked off a single list

DFP or level order search
1. use Que
1. add child list to que
1. recursively call child lists

Flatten = O(2n) - reduce space complexity

add child list to end of parent list

```
tail getTail(head)
    while(node)
        if(node.child)
            tail.next == node.child
            tail.getTail(node.child)
        node = node.next


```
