# Recursion

### Rule of sum
```$xslt
if an action can be performed by choosing one of A options,
OR one of B options, then it can be performed in A + B ways
``` 

### Rule of product
```$xslt
If an action can be performed by choosing one of A options,
FOLLOWED by one of B options, then it can be done in A * B ways
 
n= n * (n-1) * (n-2) * (n-x)...
n = n! // n factorial
```

### Permutations
```$xslt
no repeats
n!
```

### Arrangements
```$xslt
repeats allowed
n^length

4 digit pass code = _ _ _ _
digitis 0-9 = 10 digits
total arrangemenst = 10^4 
```

### Fibonacci
```$xslt
shortest path = right n/2
longest path = left n-1

levels = 2^n/2 -1
O(2^n/2), O((2^1/2)^n), O(sqr.root(2)^n), O(1*4^n)
```

### Sets N choose K
```$xslt
Combinations = C, rows = n, items = k 
C(n,k)

n choose k = (n above k)
C(n,n) = 1
C(n,0) = 1
C(n, 1) = n
C(n,n-1) = n
C(n,k) = C(n, n-k)

C(n,k) = C(n-1, k-1) + C(n-1, k)

num of subsets of n = 2^n
 
C(n,2) = n!/2!(n-2)! = n(n-1)/2

```

### Tower of Hanoi
```$xslt
base t(1)
t(n) = 2t(n-1) +1

level = 2^n-1
ex: T(3) = 2^3 -1 = 7 moves

T(n) = O(2^n)
```

### Combinatorial enumeration
```$xslt
order = permutation
!order = combination or subset

```

###  f(n) = f(n-1) + f(n-3)
```$xslt
accumulate the base cases
expressed as needing 3 base cases of n, n-1, n-3


```

### Permutations with out repetition
````$xslt

leaf level is <= O(n! n)
space = O(n)

For printing all [permutations] of a set of distinct numbers n, 
into how many subproblems is the root-level manager dividing up the overall problem? = n

For printing all [subsets] of a set of distinct numbers n, 
into how many subproblems is the root-level manager dividing up the overall problem?

```

### Sets combinations
```
{a,b} = 2n = {},{a},{b},{a,b}
2n = branching pattern (2) power of height (n) || lenght of problem set

total sets = s(n) = 2 *  s(n-1) 
total subsets = 2^n
num permutations = n!

total nodes left->right = 2n
todla nodes right->left = 2n-1

lower bound of leaf lever work = 0(2n . n)
max call stack size O(n)


``` 
