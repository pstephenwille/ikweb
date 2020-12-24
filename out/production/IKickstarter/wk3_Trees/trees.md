# Trees
```
ADT abstract data type
Dyanamic or Static

key:value pairs

Dictionary
- search key
- values
- dynamic
- insert
- delete

Set - collection of keys
- search key
- static | dynamic 

Balanced BST; complete, full
Search O(log n)
Height O(log n)
dfs height O(n)



Arity; max nodes

```

### Implementing Dictionary
```
BST = sorted array  using binary search

BST; left < root, right > root

Search; O(log n)

Hashtable - contigious/memory array
BST = linked/memory
Based on a hashtable, or BST

Sets = BST
HashMap = hashtable
```

### Searching tree
```
search; unbalanced O(n), blanced O(log n)

def search(Node root, int key)
    curr = root
    while curr != null
        if key == curr.key
            return curr
        else if key < curr.key
            curr = curr.left
        else
            curr = curr.right

```

### Inserting tree
```

def insert(Node root, int k)
     Node newNode = new Node(k)
    curr = root
    while curr != null
        if k == curr.key
            return 
        else if k < curr.key
            prev = curr
            curr = curr.left
        else 
            prev = curr
            curr = curr.right

        if k < prev.key
            prev.left = newNode
        else
            prev.right = newNode  
```

### Finding min/max in tree
```
balanced O(log n), else O(n)

def findMin(Node root)
    if root == null
        return null

    curr = root
    while curr.left != null
        cur == curr.left

    return curr.key


```

### Successor/Predecessor in tree
```
next largest
...min of node.right.left
...node.prev.right

def findSuccessor(Node root, Node p)
    curr = root

    if p.right != null
        curr = p.right
        
        while curr.left != null
            curr = curr.left
        return curr
    
    ancestor = null
    while curr.key != p.key
        if p.key < curr.key
            ancestor = curr
            curr = curr.left
        else
            curr = curr.right      
    
```

### Delete node
```
delete leafnode
def deleteLeaf(Node root, int k)
    prev = null
    while curr != null
        if k == curr.kwy
            break
        else if k < curr.key
            prev = curr
            curr = curr.left
        else
            prev = curr
            curr = curr.right

        if curr.left == null && curr.right == null // leaf node
            if curr = prev.left
                prev.left = null
            else if curr = prev.right
                prev.right = null

        if prev == null//one node tree
            return null

    if curr == null
        return root
```

### Delete node with child
```

def deleteNode(Node root, int k)
    prev = null
    chile = null

    while curr != null
        if k == curr.kwy
            break
        else if k < curr.key
            prev = curr
            curr = curr.left
        else
            prev = curr
            curr = curr.right

        if curr.left == null && curr.right == null // leaf node
            if curr = prev.left
                prev.left = null
            else if curr = prev.right
                prev.right = null

        if curr.left == null && curr.right != null
            child = curr.left
        
        if curr.left != null && curr.right == null
            chile = curr.right
       
        if child != null &&  prev == null
                root == child
                return root

        if prev == null//one node tree
            return null

    if curr == null
        return root

```

### Delete node with L/R nodes
```
if curr.left != null &&curr.right != null 
    succ = curr.right
    prev = curr

    while succ.left != null
        prev = succ
        succ.left

    curr.key = succ.key

    if succ == prev
        prev.left = succ.right
    else
        prv.right = succ.left

    return root
```

### BFS
```
Queu
level order traversal
half noded present at last level
time: O(n)
space: O(n)

def levelOrder(Node root)
    q = new Queue()
    q.pusth(root)
    
    while ! q.empty()
        node = q.pop()
        print node
        
        if node.left != null
            q.push(node.left)
        
        if node.right != null
            q.push(node.right)


```

### DFS
```
Stack
t: O(n)
s: O(n)
max s: O(log n)

each node is hit 3 time; left, below, right
left; pre-order
below; in-order
right; post-order

treesort O(n log n)

def dfs(Node root)

// print; pre order
if root.left != null
    dfs(root.left)

// print; in-order
if root.right != null
    dfs(root.right)

// print; post-order

``` 

### Preorder
```

def helper(Node rot, int level)
    if root == null return
    
    print " " * level + root.key
    
    for child in root.children
        helper(child, level+1)


```

### Postorder
```
t: O(n)
s: O(h)

def helper(Node root)
    du = node.space
    
    for child in node.children
        du += helper(child)
    
    return du

```

### Successor/Predecessor 2
```
in-order, hit from bottom

successor; left most node on the right side of root
if node is null, first right node from left of current node

predcessor; right most node on left of root
if node is null, first left node from right of current node


```

### Reconstructing Binary Tree from traversals
```
traversals are not individually unique
pre-order; [a, b, c]
in-order: [b, a, c]
post-order: [b, c, a]

in-order; root node is first element
post-order; root node is late element

BST; in-order + pre||post order

 
```

### Uni Value tree
```
Counter{
count=0;
}

int countSameVlaueTrees(Node n)
    Counter c = new Counter();
    countSUT(Node n, c)
    return c.count 

bool countSUT(Node n, Counter c)
if n == null return true

isLeft = countSUT(n.left, c)
isRight = countSUT(n.right, c)

if !isRight || !isLeft return false

if n.left != null && n.left.val != n.val return false

if n.right !== null && n.right.val != n.val return false

c.count++
return true

```


### Count levels
```
printLeftMostLevel(Node n)
    que q = new queu()
    q.add(n)
    
    while !q.isEmpty()
        int size = q.size()
        printed = false
    
        while size-- > 0
            node = q.deque()
        
        if !printed
            print node.val
            printed = true
        
        for node c : node.childre
            q.add(c)


```

### Equal trees
```
compare leafs
do not use recursion


compareTrees(Node n1, Node n2)
    while n1.hasNext() && n2.hasNext()
        Node leaf1 = n1.next
        Node leaf2 = n2.next
        
        if leaf1.val != left2.val return false

    return ! n1.hasNext() && n2.hasNext()  

```


### LinkedList from BST
```
in-order

FirstLast{first; last}

tolinkedList(Node root)
    firstLast fl = new FirstLast
    
    toll(n, fll)
        fl.first.right = fl.last//prev
        fl.last.right = fl.first//next
        retur fl.first

toll(Node n, FirstLast fl)
if n == null return

toll(n.elft, fl)
if fl.first == null
    fl.first = n

rigth = n.right
prev = fl.last
if prev != null
    n.right = prev
    prev.left = n
    toll(right, fl)

```


### Build tree
```
[2,3,4,5,6,7]

toBst(Node[] arr, start, end)
    if(end<start) return null
    int mid = (start + end) /2
    node n = a[mid] 
    n.left = toBst(a, start, mid -1)
    n.right = toBst(a, mid +1, end)



toBinarySearchTree(Node[] arr)
    return toBst(a, 0, a.length -1

```

