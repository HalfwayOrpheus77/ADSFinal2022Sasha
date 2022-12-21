package Final2;

import java.util.LinkedList;
import java.math.BigInteger;
import java.security.interfaces.DSAPrivateKey;

/**
 * This is a class to hold a graph.
 */

public class DSGraph {

    // Our graph is a DSHashMap, mapping strings to a DSArrayList of neighbors
    DSHashMap<DSArrayList<String>> graph;

    public DSGraph() {
        this.graph = new DSHashMap<>();
    }

    /**
     * Adds a vertex to the graph, if it is not already there.
     *
     * @param v The String that represents the new vertex
     */
    public void addVertex(String v) {
        // Make sure v1 exists as a vertex
        if (!graph.containsKey(v)) {
            graph.put(v, new DSArrayList<String>());
        }
    }
    
    /**
     * Add an edge between vertices v1 and v2.
     * If v1 and/or v2 do not already exist, create them.
     *
     * @param v1 The first vertex
     * @param v2 The second vertex
     */
    public void addEdge(String v1, String v2) {
        // Make sure v1 exists as a vertex
        addVertex(v1);
        // Make sure v2 exists as a vertex
        addVertex(v2);

        // Add v1 and v2 to each others' neighbor lists
        if(graph.get(v1).contains(v2)) return; // Don't add a duplicate edge
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }

     /**
     * Add an arc directed from v1 and v2.
     * If v1 and/or v2 do not already exist, create them.
     *
     * @param v1 The first vertex
     * @param v2 The second vertex
     */
    public void addArc(String v1, String v2) {
        // Make sure v1 exists as a vertex
        addVertex(v1);
        // Make sure v2 exists as a vertex
        addVertex(v2);

        // Add v1 and v2 to each others' neighbor lists
        if(graph.get(v1).contains(v2)) return; // Don't add a duplicate edge
        graph.get(v1).add(v2);
    }

    /**
     * Determine whether or not the graph has a triangle.
     * 
     * A triangle is a set of 3 vertices {A, B, C} such that the three
     * edges (A, B), (A, C) and (B, C) are all present in the graph
     * 
     * @return true if the graph contains no triangle, otherwise false
     */
    public Boolean triangleFree() {
        for (String v1 : graph) {
            DSArrayList<String> nbs = graph.get(v1);
            for (int i = 0; i < nbs.length - 1; i++) {
                for (int j = i + 1; j < nbs.length; j++) {
                    if (graph.get(nbs.get(i)).contains(nbs.get(j))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Produce the number of connected components in this DSGraph
     * 
     * @return The number of components
     */
    public int numberOfComponents() {
        int rv = 0;
        DSHashMap<String> visited = new DSHashMap<>();

        for (String v : graph) {
            if (visited.containsKey(v))
                continue;
            rv++; // Found a new component
            LinkedList<String> q = new LinkedList<>();
            q.add(v);
            visited.put(v, "");

            while (!q.isEmpty()) {
                String n = q.pop();
                for (String w : graph.get(n)) {
                    if (visited.containsKey(w))
                        continue;
                    visited.put(w, "");
                    q.add(w);
                }
            }

        }
        return rv;
    }

    // Finds a shortest path from start to end in this graph
    public void shortestPath(String start, String end) {
        LinkedList<String> q = new LinkedList<>();
        DSHashMap<String> parent = new DSHashMap<>();
        // visited keeps track of vertices we've seen before
        DSHashMap<String> visited = new DSHashMap<>();

        q.push(start);
        visited.put(start, "");
        String farthest = "";

        while (!q.isEmpty()) {
            String v = q.removeFirst();
            for (String nbr : graph.get(v)) {
                if (visited.containsKey(nbr))
                    continue; // move on to the next neighbor
                q.add(nbr);
                farthest = nbr;
                visited.put(nbr, "");
                parent.put(nbr, v);
            }
        }
        System.out.printf("The farthest word from %s is %s\n", start, farthest);

        // Discover undiscovered vertices
        int numUnreachable = 0;
        for (String v : graph) {
            if (!visited.containsKey(v)) {
                numUnreachable++;
                // System.out.printf("This vertex is unreachable from %s: %s\n", start, v);
            }
        }
        System.out.println(
                "From " + start + ", there are " + numUnreachable + " unreachable words.");

        // If there is no path ...
        if (!visited.containsKey(end)) {
            System.out.println(end + " is unreachable from " + start);
            return;
        }
        printPath(start, end, parent);
    }

    // Overseer DFS from a single vertex
    public void DFS(String start, String end) {
        // The start
        DSHashMap<String> visited = new DSHashMap<>();
        DSHashMap<String> parent = new DSHashMap<>();
        visited.put(start, "");
        boolean pathExists = DFSPath(start, end, visited, parent);
        if (pathExists) {
            printPath(start, end, parent);
        } else {
            System.out.println("No path");
        }
    }

    // Find any path from start to end
    public boolean DFSPath(String start, String end,
            DSHashMap<String> visited, DSHashMap<String> parent) {

        if (start.equals(end)) {
            return true;
        }

        for (String nbr : graph.get(start)) {
            if (visited.containsKey(nbr))
                continue;
            parent.put(nbr, start);
            visited.put(nbr, "");
            if (DFSPath(nbr, end, visited, parent))
                return true;
        }
        return false;
    }

    public void printPath(String start, String end, DSHashMap<String> parent) {
        // There is a path. Let's print it.
        int length = 1;
        String path = "";
        String vertex = end; // Where we are as we walk backwards on the path
        while (vertex != start) {
            // Stick the current vertex at the start of the path
            path = vertex + "-" + path;
            // Update the vertex we are at
            vertex = parent.get(vertex); // move to the parent
            length++;
        }
        path = start + "-" + path;
        System.out.println(path);
        System.out.println("That path had length " + length);
    }

    /**
     * Find the size of the component in the graph containing vertex v
     * 
     * @param v A vertex in the component
     * @return The total number of vertices in v's component
     */

    /**
     * Recursion for the componentSize method
     * 
     * @param v       A vertex to DFS search from
     * @param visited A hash map of all vertices that have been visited so far
     */
    public void componentSizeVisit(String v, DSHashMap<String> visited) {
        for (String nbr : graph.get(v)) { // Loop over neighbors of v
            if (visited.containsKey(nbr))
                continue;
            visited.put(nbr, "");
            componentSizeVisit(nbr, visited);
        }
    }

    // Prints one vertex from every component in the graph, with that component's
    // size
    public void discoverAllComponents() {
        LinkedList<String> q = new LinkedList<>();
        // visited keeps track of vertices we've seen before
        DSHashMap<String> visited = new DSHashMap<>();

        // Loop over all vertices of the graph
        for (String start : graph) {
            if (visited.containsKey(start))
                continue;

            // New, unseen vertex. Do a BFS from v
            q.clear();
            q.add(start); // v is this BFS's start vertex
            visited.put(start, "");
            int componentSize = 1;

            while (!q.isEmpty()) {
                String v = q.removeFirst();
                for (String nbr : graph.get(v)) {
                    if (visited.containsKey(nbr))
                        continue; // move on to the next neighbor
                    q.add(nbr);
                    componentSize++;
                    visited.put(nbr, "");
                }
            }

            System.out.printf("The component containing %s has size %d\n", start, componentSize);
        }
    }

    /*
     * Homework Functions!
     */

    /**
     * Compute the number of vertices of this graph
     * 
     * @return the number of vertices
     */
    public int numVertices() {
        int count = 0;
        for (String vertex : graph)
        count++;
        return count;
    }

    /**
     * Compute the number of edges of this graph
     * 
     * @return the number of edges
     */
    public int numEdges() {
        int count = 0;
        for (String vertex : graph)
        for (int i = 0; i < graph.get(vertex).length; ++i)
        count++;

        count = count / 2;
        return count;
    }

    /**
     * Determine if the graph is connected
     * 
     * @return true if the graph consists of just a single component
     */
    public boolean isConnected() {
        Boolean connected = false;
        int numCom = numberOfComponents();

        if (numCom == 1)
        connected = true;

        return connected;
    }

    /**
     * Determine if the graph is a tree.
     * A tree is a graph that is connected and has no cycles.
     * 
     * return true if this graph is a tree
     */
    public boolean isTree() {
        Boolean tree = false;

        if (isConnected() && numEdges() == numVertices() -1)
        tree = true;

        return tree;
    }

    /**
     * Determine if the graph contains any cycles
     * 
     * @return true if the graph contains any cycles.
     */
    public boolean hasCycle() {
        return false;
    }

    /**
     * Find two vertices that are as far apart as possible.
     * 
     * That is, find two vertices with the property that 
     * the shortest distance between them in the graph is 
     * at least as great as the shortest distance between 
     * any other two vertices in the graph.
     * 
     * @return an array containing two such vertices
     */
    public String[] furthestPair() {
        return new String[] { "v", "w" }; // Fake vertices
    }

    /**
     * Find the distance between two vertices in this graph
     * 
     * The distance between two vertices is the number of edges
     * in a shortest path from one vertex to the other vertex.
     * 
     * @param v The first vertex
     * @param w The second vertex
     * @return the distance between v and w
     */
    public int distance(String v, String w) {
        return 0;
    }

    // A place to remember the work
    DSHashMap<BigInteger> memos = new DSHashMap<>();

    /**
     * counts the number of directed paths in the (di)graph
     * from v to w having length exactly k
     * @param v The start vertex
     * @param w The end Vertex
     * @param k The length of the paths
     * @return
     */
    public BigInteger countPaths(String v, String w, int k){
        String key = v + "." + w + "." + k;
        // Check to see if we've done this work already. If so,
        // simply return the answer
        if(memos.containsKey(key)) return memos.get(key);

        BigInteger rv = BigInteger.ZERO;

        if(k == 0 && v.equals(w)) return BigInteger.ONE;
        if(k == 0) return BigInteger.ZERO;

        // Loop over v's neighbors
        for(String a : graph.get(v)){
            rv = rv.add(countPaths(a, w, k-1));
        }

        // Having done the work for this key (v, w, k)
        // remember the answer in case we're asked to do it again!
        memos.put(key, rv);

        return rv;
    }
    
    /**
     * Finds all the shortest paths between two vertices on a graph
     * 
     * @param start Starting vertex
     * @param end Ending vertex
     * @return List of paths where each path is a list of vertices
     */
    public DSArrayList<DSArrayList<String>> findShortestPathsRow(String start, String end) {
        LinkedList<String> q = new LinkedList<>();
        DSHashMap<DSArrayList<String>> parent = new DSHashMap<>();
        DSHashMap<Integer> dist = new DSHashMap<>();
        // visited keeps track of vertices we've seen before
        DSHashMap<String> visited = new DSHashMap<>();
        DSArrayList<DSArrayList<String>> Paths = new DSArrayList<>();

        q.push(start);
        visited.put(start, "");
        dist.put(start, 0);

        while (!q.isEmpty()) {
            String v = q.removeFirst();
            for (String nbr : graph.get(v)) {
                if (visited.containsKey(nbr) && dist.get(nbr).equals(dist.get(v) + 1)){
                    parent.get(nbr).add(v);
                    continue; // move on to the next neighbor
                }
                if (visited.containsKey(nbr))
                continue;

                parent.put(nbr, new DSArrayList<>());
                q.add(nbr);
                dist.put(nbr, (dist.get(v) + 1));
                visited.put(nbr, "");
                parent.get(nbr).add(v);
            }
        }

        Paths = buildPaths(parent, start, end);

        return Paths;
    }

    public DSArrayList<DSArrayList<String>> findShortestPathsColumn(String start, String end) {
        DSArrayList<DSArrayList<String>> PathsColumn = new DSArrayList<>();
        PathsColumn = findShortestPathsRow(start, end);
        PathsColumn = MakeColumned(PathsColumn);

        return PathsColumn;
    }

    public DSArrayList<DSArrayList<String>> MakeColumned(DSArrayList<DSArrayList<String>> pathsRow) {
        DSArrayList<DSArrayList<String>> pathsColumn = new DSArrayList<>();
        String start = pathsRow.get(0).get(0);
        int lengthOfRow = pathsRow.length() - 1;
        int lengthOfPath = pathsRow.get(0).length();
        String end = pathsRow.get(lengthOfRow).get(lengthOfPath - 1);

        for (int i = 0; i < lengthOfPath; ++i) {
            pathsColumn.add(new DSArrayList<String>());
        }

        for (DSArrayList<String> path : pathsRow){
            int j = 0;
            for (String vertex : path){
                //System.out.print(vertex + " ");
                if (vertex == start || vertex == end)
                    continue;
                if (pathsColumn.get(j).contains(vertex))
                    continue;
                pathsColumn.get(j).add(vertex); // WRONG
                
                j++;
            }
            // Takeoff
        }
        return pathsColumn;
    }

    public DSArrayList<DSArrayList<String>> buildPaths(DSHashMap<DSArrayList<String>> parent, String Start, String End){
        DSArrayList<DSArrayList<String>> Paths = new DSArrayList<>();
        DSArrayList<DSArrayList<String>> allPaths = new DSArrayList<>();
        DSArrayList<String> startList = new DSArrayList<>();
        startList.add(Start);
        DSArrayList<DSArrayList<String>> returnList = new DSArrayList<>();
        returnList.add(startList);
        
        if (End.equals(Start)) {
            return returnList;
        }

        allPaths = new DSArrayList<>();

        DSArrayList<String> lop = parent.get(End);

          for (String p : lop){
             Paths = buildPaths(parent, Start, p);

             for (DSArrayList<String> path : Paths) {
                path.add(End);
                allPaths.add(path);
             }
          }
       return allPaths;
    }    
}