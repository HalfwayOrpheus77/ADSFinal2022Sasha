package Final2;

import java.security.Key;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * HashMap class written by the 2022 ADS class
 * 
 * V is the type parameter, the type of the value we will store.
 * For now, all of our keys will be Strings.
 */

 class DSHashMap<V> implements Iterable<String>{
    // The backing array - contains the values
    DSArrayList<DSArrayList<KVP>> a; // the backing DSArrayList
    int capacity; // Size of the backing array
    int numItems; // Number of KVPs added to the DSHashMap
    int totalCount;

    // A Java constructor is identified by three properties
    // The same name as the class
    // public
    // no return type, not even void
    public DSHashMap(){
        capacity = 2;
        a = new DSArrayList<>(capacity);
        numItems = 0;
        totalCount = 0;
    }
    void put(String key, V value){

        // Check to see if our DSHashMap is getting crowded
        if(numItems > 3*capacity){ // Purposely dense to encourage long chain, for the Midterm
            rehash();
        }

        // Give us the location of this key's value in the backing array
        int location = hash(key);
        if(a.get(location) == null){
            a.put(location, new DSArrayList<KVP>(10));
            a.get(location).add(new KVP(key, value));
            numItems++;
        } else { // Already a chain here, with stuff in it
            // search that chain for our key.
            for(int i = 0; i < a.get(location).length(); i++){
                KVP kvp = a.get(location).get(i);
                // If we find the key, replace the value
                if(kvp.key.equals(key)){
                    a.get(location).replace(i, new KVP(key, value));
                    return;
                }
            }
            // If we don't find the key, create a new KVP and add it to the chain
            a.get(location).add(new KVP(key, value));
            numItems++;
        }
    }

    /*
     * Double the size of the backing DSArrayList
     * Move all KVPs to their new locations and chains
     */
    private void rehash() {
        // Save a reference to the current backing array
        DSArrayList<DSArrayList<KVP>> olda = a; 

        // Create a new, larger backing array
        int newCapacity = 2 * this.capacity;
        a = new DSArrayList<>(newCapacity);
        this.capacity = newCapacity;
        //System.out.println("New capacity is " + this.capacity);

        // Loop over old backing array
        this.numItems = 0;
        for(int i = 0; i < olda.capacity(); i++){
            DSArrayList<KVP>chain = olda.get(i);
            if(chain == null) continue;

            for(KVP kvp : chain){
                if(kvp == null) break;
                this.put(kvp.key, kvp.value);
            }
        }
    }


    /**
     * Return the value associated with this key
     * If the key is not in the DSHashMap, return an exception
     * 
     * @param key
     * @return The value of type V stored with this key
     */
    V get(String key){
        int location = hash(key);
        if(a.get(location) == null){
            throw new IndexOutOfBoundsException("Key not found: " + key);
        } else { // Already a chain here, with stuff in it
            // search that chain for our key.
            for(int i = 0; i < a.get(location).length(); i++){
                KVP kvp = a.get(location).get(i);
                //System.out.printf("loc = %d, i = %d: Looking for %s, found %s\n", 
                //    location, i, key, kvp.key);
                // If we find the key, replace the value
                if(kvp.key.equals(key)){
                    return kvp.value;
                }
            }
            // If we don't find the key, create a new KVP and add it to the chain
            throw new IndexOutOfBoundsException("Key not found: " + key);
        }
    }

    /**
     * Check to see if this DSHashMap contains an entry with key k
     * 
     * @param k The key to search for
     * @return True if the key already exists in the hash map
     */
    public Boolean containsKey(String k){
        // Initialize the location as hash(k) for the keys
        int location = hash(k);
        if(a.get(location) == null){
            return false;
        } else { // Already a chain here, with stuff in it
            // search that chain for our key.
            for(int i = 0; i < a.get(location).length(); i++){
                KVP kvp = a.get(location).get(i);
                // In the key value pairs, get the location of the key and value
                if(kvp.key.equals(k)){
                    return true;
                }
            }
            return false;
        }
    }


    // This is the hash function. Tells where a string's value
    // should be stored in the backing array
    int hash(String s){
        int rv = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            rv = (rv * 7 + c) % capacity;
        }
        return rv;
    }

    @Override
    public String toString(){
        System.out.print("{");
           for(String key : this){
            System.out.print(key + ":" + this.get(key) + ", ");
            // First grab the key, then enter inside to get the value of the key
            // For now, it is not sorted but it works
        }
        return "";
    }
    
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>(){
            int backindex = 0;
            int chainindex = 0;

            @Override
            public boolean hasNext() {
                if(a.get(backindex) != null && chainindex < a.get(backindex).length()){
                    return true;
                }
                backindex++;
                while(backindex < capacity && a.get(backindex) == null) backindex++;
                if(backindex == capacity) return false;

                // There is another chain to use!
                chainindex = 0;
                return true;
            }

            @Override
            public String next() {
                String returnValue = a.get(backindex).get(chainindex).key;
                chainindex++;
                return returnValue;
            }
            
        };
    }


    /**
     * Inner class for Key-Value pairs
     */
    class KVP {
        String key;
        V value;

        public KVP(String s, V v){
            key = s;
            value = v;
        }
    }
}