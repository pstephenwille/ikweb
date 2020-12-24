# Graphs
```
traveling salesman problem
Eulearin cycle

Graph algos are variation of same aglo

1. model as graph?
2. simple graph traversal
3. standard extension help?
4. code it up

Graph; diagram of nodes/vertices and edges
Undirected graph; edges have no direction
Directed; arrows of allowed movement
Adjacent; connected edges
Path: visits each edge once
Cycle: path that ends where it started
Degree; num of edges on vertices
Mulitgraph; self referencing vertices
Complete undirected: has edge to every other vertice, v-1 vertices
Connected; no un-reachable vertices || stand alone node 
    
G = (V, E)// set of vertices, set of edges
Sum of edges;
    Undirected G = 2|E|
    Directed G; |E| - in  degress
    


Hamiltonian cycle; iverse of Eulearian; walls = vertcies, edges = nodes

Connected components; pieces of connected graph
Cycle if any degree is odd, it is not a cycle
    if all degress are even, it is cycle

Tree; connected graph with no cycles

```

### Eulerian path
```
Eulearian cycle: covers each edge once, comes back to start
Eulearian path: visits each edge once, ending other thant start

cycle 
Start/End different vertices; can have odd degrees

Can not have a single vetice with an odd degree
Can not have odd number vertces with odd degrees

0 vertices with odd degress = cycle
2 vertices with odd degress = path
3+ vertices with odd degress != cycle or path


directed graph, non cycle;
    one in-degree > out-degree
    one with out > in-degree
    all others in == out

```

### Conclusion
```
Connected graph with odd degree vertices;
    >2 no cycle or path
    ==2 is path
    0 is cycle

```


### Graph representations
```
n = |v| // vertcies
m = |e| // edges


n choose 2 = n(n-1)/2 == O(n2)

Store vertices in arrays or hashtables; 
    s: O(n)

visiting edges; O(|e|)
neighbors = O(mn) or O(n3)

Adjacency list; t: O(n1), s; O(m+n)
    list of vertices and their neighbors

Edge lists; s O(m+n)
    get neighbors; O(m)    

Adjacency matrix: t:0(1) || O(degree(U)) , s: O(|V|^2)
    undirected; symetric matrix
    directed; asymetric
neigbors; t:O(n), s:O(n2)

Dense graph; |E| ~ |V|^2 == n(n-1)/2
Sparce graph; |E| << |V|^2

Adjency Maps: best of lists and matrix t: O(1), s: O(1)
    N vertcies with M edges = O(M + N)
```


### code; Eulerian cycle
```
class Graph{
    List<Integer>[] adjList;
    int v;
    
    Graph(int size){
        v = size;
        adjList = new List<Integer>[v];
    }
    
    void addEdge(int start, int end, bidir=true){
        adjList[start].add(end);
        if bidir == true
            adjList[end].add(start)

    }

    boolean hasEulerianCycle(){
        add = 0;
        for vertex in adjList
            if(adjList[vertex].size() % 2 > 0)
                odd++  
    
        return (odd == 0) || (odd == 2)
    }
    
    search(int s){
        captured[] captureed = new int[1];
        parent[] parents;
    
        while(s.had child)
            picke one;
            captured[v] = 1;
            parent[v] = u;
    }   

}

```
### Graph search
```
1. BFS - choose the fringe edge first seen; BFS tree
2. DFS - choose the fringe edge last seen; DFS tree
3. Dijkstra's - fringe edge w/RHS vertex smallest label; shortest path tree
4. Prims - same as Kijkstras; min spanning tree
5. Best-first-search - same; best-first search tree

Cross edges; connect vertcies on different branches;
    do not have an ancestor/descendant relationship
    can not skip layers
    indicate cycles; neighbor/children already visted
```

### BFS
```
que fifo
hits each node once
traks visited

void BFS(int s)
    captured[]
    visited[]
    q = new Queue()
    q.push(s)

while !q.isEmpty()
    Node node = q.pop();
    captured[node] = 1
    
    for w in adjlist[]
        if visited[w] == 0
            visted[w] = 1
            parent[w] = node
            q.push(w)

```

### DFS
```
stack lifo
hits each noe 3 times; l,r, bottom

O(m + n)
void DFS(int s)
    captured[]
    visited[]
    q = new Stack()
    q.push(s)

while !q.isEmpty()
    Node node = q.pop();
    captured[node] = 1
    
    // O(degree(V)) = O(M)
    for w in adjlist[]
        if visited[w] == 0
            visted[w] = 1
            parent[w] = node
            q.push(w)


void DFS(int s)
    visited[s]

    for w in adjlist
        if visted[w]] == 0
        DFS(w)  

```

### Finding connected components
```
void DFS(int s, int c)
    visited[s] = c

    for w in adjlist
        if visted[w]] == 0
        DFS(w, c)

  
void findCOmponents()
{
    component = 0;
    for i in 1 to V
        if visited[i] == 0
            component++;
            DFS(i, component)
     
    return component       
}


```


### Class video
```
O(m+n)
1. build graph; adjaceny list/map
    num of verticies

    BFS - iterative
function bfs(source)
    que = new que()
    que.push(source)
    visited[source] = 1
    parent[]

    while(!q.notEmpty)
        node = q.pop()
        
        for(neighbor in adjList)
            if vistied[neighbor] == -1
                visited[neighbor] = 1 //O(degrees n)
                parent[neighbor] = node
                q.push(neighbor)
            else://check if neighbor is not parent, then is cross edge
                if neighbor != parent[neighbor]
                    //is cross edge
                



    components = 0
    for(v in adjList)
        if visted[v] == -1
            components++
            bfs(v)

    return components


    BFS - recursive
function BFS(src){
    if src is null return
    visited[src] = 1

    for(node in adjList)
        if visited[node] == -1
            BFS(node)

    for(n in adjList)
        if visted[n] == -1// not connected
        components++
        BFS(node)

    // components > 1? true : false;


}



    DFS - recurssive; graph is tree
function dfs(source)
    vistied[source] = 1
    for(neigbor in adjList)
        if visted[neighbor] == -1
            parent[neigbor] = 1
            dfs(neighbor)
            return true
    
        else if neighbor != parent[neighbor]
            connected++
            return true
            
    return false
```

### Bipartite
```
Trees genrally are  bipartite
distance[node] = neighbor +1

if distance[node] == distance[neighbor]
    return false

distance % 2 > 0? false: true





```



