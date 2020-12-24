#Dynamic Programming
```
Top down
O(n) - fib with memozaiton
space for time trade off

```


```
Bottom up - transform recurssive into loop
t: O(n)
s: O(n)

DAG - directed, acyclic, graph
topological sort

s: O(1) n % 3 to resuse array space to cache result

```
```BX-DVZ-97H-4QL-XSW
counting problem => recurssive equation => DP solution

decrease/conquer
Climbing Stairs algorithm; total of n steps. The final step is either n-1, or n-2.
    fib(n) = fib(n-1) + finb(n-2).  
    n^0, n^2, n^3...n^n-1

t: O(n)
s: O(1)
def fib(n)
    if n <=2 return n
    
    table = []
    for(i<=3; i++)
        int idx = i%3;
        table[idx] = table[idx-1] +table[idx-2]

    return table[n] 

```

### counting subsets of k
```
N choose K
c(n,k) = c(n-1, k) + c (n01, k-1)
         //exclude      //include

def c(n,k)
    if k <= 1 return 1
    return c(n-1, k) + c(n-1, k-1)


t:O(nk)
s:O(nk)
def c(n,k)
    if k==0 || k==n return 1

    table = [n][k]
    for row in n
        table[row][0] = 1

    for col in k
        table[col][col] = 1

    for(row=2; row<n; row++)
        for(col=1; col<min(row, k); col++)
            table[row[col] = table[row-1][col] + table[row][col-1]

    return table[n][k]

```

### count unique paths
```
t: O(mn)
s:O(mn)
def countPaths(m, n)
    table = [][]

    for i < m
        table[i][0] = 1
    for j < n
        table[0][j] = 1

    for row < m
        for col < j
            table[row][col] = table[row -1][col] + table[row][col-1]

```

### maximum path
```
optimal substructure; sub paths are optimal path along main path


t: O(mn)
s: O(mn)
def maxPath(grid)
    table = [grid.length][grid[0].length]
    table[0][0] = grid[0][0]
    
    for j< grid[0].length
        table[0][j] = table[0][j-1] + grid[0][j]

    for i < grid.length
        table[i][0] = table[i-1][0] + grid[i][0]


    for row < m
        for col < n
            table[row][col] = grid[row][col] + max(table[row-1][col], table[row][col-1]

    return table[m-1][n-1]

```


### min cost stair climb
```
t: O(n)
s: O(n)
def minCostPath(n, costarray)
    table = [n +2]
    table[0] = 0
    table[1] = costarr[0]

    for i< n+1
        table[i]= costarr[i-1] + min(table[i-1], table[i-2])
    
    return table[n+1]
        
```


### coin change
```
1. type of problem;
    minimization problem - DP
    optimize
    decrease and conquer

2. Recurise equation; optimal solution
    c1+c2+c3....ck = a
    f(a-c1)
    f(a-c2)
    f(a-ck)
    f(a) = min( f(a-ck) )+1

3. Identify all different possibe subproblems
    tree, nodes; a-1, a-2,..., a+1 problems

4. Identify dependencies; each subproblem of vertex
    a-c1, a-c2...a-ck

5. Identify data structure to cache subproblem solutions;memoize
   1d/2d array, tree 

6. DP algo
    def coinChange(a, coins)
        table = []
        //basecase
        table[0] = 0

        //init rest of table to null value
        for i=i; i < a  
            //compute and cache f(i)
            for c in coins
                if i -c >= 0
                    table[i] = min(table[i], table[i-c])
             

        return table[a]
```

### class
```
DP - bottom up
DP; min/max, or optimum, count, two strings, zero sum game, problem with a table and solution fits in table
1. recurssion, 
2. optimum substructure, 
3. over lapping sub problems

Recursive; 
    make problem smaller/bigger, 
    memoization
    bottom up (smallest first)

Formula;

Start w/table
    


```
### american football
```
points; 2,3,6
score; 8

identify smallest step/solution
final score: [0,1,2,3,4,5,6,7,8]
num of ways: [1,0,1,1,1,2,3,3,6]

identify distinct solutions
6=  2+2+2
    3+3
    6
8=  2+2+2+2+2
    2+3+3
    3+2+3
    3+3+2
    2+6
    6+2

sum of previous N digits + last digit;

f(n) = f(n-6) + f(n-3) + f(n-2) 

int footBallScores(int finalScore)
    int[] now = int[finalScore +1]
    now[0] = 1// base case
    
    for(i=1; i<finalScore)  
        now[i%7] =  (s < 2? 0: now[(s-2) %7]) +
                    (s < 3? 0: now[(s-3) %7])+
                    (s < 6? 0: now[(s-6) %7])
    
    return now[finalScore % 7]


i=1; 1<2=0; 1<3=0; 1<6=0; now[1] = 0
i=2; 2<2=now[2-2=0]=1; 2<3=0; 2<6=0; now[2] = 1
i=3; 3<2=now[3-2]=1=0; 3<3=now[3-3=0]=1; 3<6=0; now[3] = 1
i=4; 4<2=now[4-2]=2=1; 4<3=now[4-3=1]=0; 4<6=0; now[4] = 1


```
### cutting the golden rod - max profit
```
length; [1,2,3,4]
price:  [2,5,6,11]

identify distinct solutions
n-length + price
mp(l) = max(
            mp(l-1) =2
            mp(l-2) =5
            mp(l-3) =6
            mp(l-4) =11)


int cutting(int length, MarketPrice[] mps)
    validateInput(lenght, mps)
    int[] dp = new int[lenght +1]

    for(int l=0; l<=length; l++)
        for(MarketPRice mp : mps)
            if(mp.len > l) continue;
            int newMp = dp[l - mp.len] + mp.price
            
            if newMp > dp[l]
                dp[l] = newMp

    return mp[length]  
    

// or while loop
int l = lenght;
while(l<0)
    for(MP mp : mps)
        if(mp.len > l)  contiue;
        int newMp = dp[l-mp.len] + mp.price
        
        if(newMp == dp[l]
            print(l);
            l -= mp.len
            break;
            
    
    
MarketPrice{price; len;}


```

### bags of gold
```
bags; [8,10,4,3]
game(l, r) = max(
                bag[l] + min(game(l+2, r), game(l+1, r-1)),
                mag[l] + min(game(l+1, r-1), game(l, r-2))
                )


int game(int[] bags)
    int nob=bags.length// number of bags
    int[][] dp = nit[nob][nob]
    
    for(int N=1; N<=nob; N++)
        for(int L=0; L<=nob -N; L++)
            int r = L + N -1
            if(N==1)
                db[L][r] = bags[L]
            else if(N == 2)
                dp[l][r] = max(
                                bags[L], bags[r]
                            )
            else
                dp[L][r] = max(
                                bags[L] + min( dp[L+2][r], dp[L+1][r-1] )
                                bags[r] + min( dp[L+1][r-1], dp[L][r-2] )
                            )
                
    
    return dp[0][nob-1]                
    
```


### two strings
```
a=bcc
b=bcca

ps(ai, bi) = 
   ps(a i-1, bi) && A[ai] == C[ai+bi]
    ||
    (ps(ai, bi-1) && B[bi] == C[ai+bi])


boolean perfectShuffle(String a, String b, String c)
    boolean[][] ps = new boolean[a.length +1][b.length +1]
    
    for(int ai=0; ai<=a.length; ai++)
        for(int bi=0; bi<=b.length; bi++)
            ps[ai][bi] = (ai==0 && bi==0) ||
                         (ai>0 && ps[ai-1][bi] && a.charAt(ai) == c.charAt(ai + bi-1))
                         ||
                         (bi>0 && ps[ai][bi-1] && b.charAt(bi-1) == c.charAt(ai + bi-1)

    return ps[a.length][b.length]
    
    

```

### max profit

```
profit(d, A) = salesPrice(d, A) +
                max(
                    profit(d-1, A),
                    profit(d-2, B),
                )
    
profit(d, B) = salesPrice(d, B) +
                max(
                    profit(d-1, B),
                    profit(d-2, A),
                )
    

int production(int[][] salesPrices)
    //validate input
    int[][] dp = new int[2][salesPrices.length]

    for(int d=0; d<salesPrices.length; d++)
        dp[0][d] = salesPrices[0][d] +
                    max(
                        d>=1?dp[0][d-1]:0,
                        d>=2?dp[1][d-2]:0
                    )
    
    return max(
                dp[0][salesPrices.length -1],
                dp[1][salesPrices.length -1]
            ) 


```


### alternate class
```


```
