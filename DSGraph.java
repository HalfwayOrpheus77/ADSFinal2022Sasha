package Final2;

import java.util.LinkedList;

public class DSGraph {
    // Our graph is a DSHashMap, mapping strings to a DSArrayList of neighbors
    DSHashMap<DSArrayList<String>> graph;

    public DSGraph(){
        this.graph = new DSHashMap<>();
    }

    /**
     * Adds a vertex to the graph, if it is not already there.
     * 
     * @param v The String that represents the new vertex
     */
    public void addVertex(String v){
        // Make sure v1 exists as a vertex
        if(!graph.containsKey(v)){
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
    public void addEdge(String v1, String v2){
        // Make sure v1 exists as a vertex
        if(!graph.containsKey(v1)){
            graph.put(v1, new DSArrayList<String>());
        }
        // Make sure v2 exists as a vertex
        if(!graph.containsKey(v2)){
            graph.put(v2, new DSArrayList<String>());
        }
        // Add v1 and v2 to each others' neighbor lists
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }

    public void shortestPath(String start, String end){
        LinkedList<String> q = new LinkedList<>();
        DSHashMap<String> parent = new DSHashMap<>();
        // Visited keeps track of veritces we have seen before
        DSHashMap<String> visited = new DSHashMap<>();

        q.push(start);
        visited.put(start, "");
        // If graph is a DSGraph, then graph.get(v) gives a DSArrayList of all of v's neighbors
        while(!q.isEmpty()){
            String v = q.removeFirst();
            for(String nbr : graph.get(v)){
                if(visited.containsKey(nbr)){
                    continue;
                }
                q.add(nbr);
                visited.put(nbr, ""); // Visited is full of vertices
                parent.put(nbr, v);
            }
        }
            if(visited.containsKey(end)){
                System.out.print(visited);
        //System.out.println(start + " goes to " + end);
            }
    }

}