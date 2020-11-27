import java.util.*;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public BST() {
        root = null;
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        if (size()==0){
            return true;
        }
        return false;
       
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
      
       return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        
       if (x == null) return 0;
       return x.size;
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
      if (key == null){
        throw new IllegalArgumentException("the key should not br null");
      }
      return get(key)!=null;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {

        return get(root,key);
    }

    private Value get(Node x, Key key) {
        if (key == null) throw new IllegalArgumentException("key cannot be null");
        if (x == null) return null;
       
        int com = key.compareTo(x.key);
        if (com < 0) return get(x.left,key);
        else if (com > 0) return get(x.right,key);
        else return x.val;
        
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null){
            throw new IllegalArgumentException("key should not be null");
        }
        root = put(root, key, val);
       
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key,val,1);
        int com = key.compareTo(x.key);
        if (com < 0)

            x.left = put(x.left, key, val);

        else if (com > 0)

            x.right = put(x.right, key, val);
        
        else
            x.val = val;
        x.size = 1+size(x.left) + size(x.right);
        return x;
    }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
       
       return min(root).key;
    } 

    private Node min(Node x) { 
         if (x.left == null) return x;
         return min(x.left);
    } 

   

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
            return x.key;
     } 

    private Node floor(Node x, Key key) {
        if (x == null) return null;
    
        int com = key.compareTo(x.key);
        if (com == 0) return x;
        if (com < 0) return floor(x.left,key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
       
    } 

    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */

     public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + k);
        }
        return select(root, k);
    }

    // Return key in BST rooted at x of given rank.
    // Precondition: rank is in legal range.
    private Key select(Node x, int k) {
        if (x == null) return null;
        int comleft = size(x.left);
        if      (comleft > k) return select(x.left,  k);
        else if (comleft < k) return select(x.right, k - comleft - 1); 
        else                      return x.key;
    }

    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */

     public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        ArrayList<Key> arr = new ArrayList<Key>();
        keys(root, arr, lo, hi);
        return arr;  
    } 

    private void keys(Node x, ArrayList<Key> arr, Key lo, Key hi) { 
        if (x == null) return; 
        int comlo = lo.compareTo(x.key); 
        int comhi = hi.compareTo(x.key); 
        if (comlo < 0) keys(x.left, arr, lo, hi); 
        if (comlo <= 0 && comhi >= 0) arr.add(x.key); 
        if (comhi > 0) keys(x.right, arr, lo, hi); 
    }

    // deleting specific key-value pair from the tree
    public void deleteMin() {
        
        root = deleteMin(root);
        
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size= size(x.left) + size(x.right) + 1;
        return x;
    }
    public void delete(Key key) {
        root = delete(root, key);
        
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int com = key.compareTo(x.key);
        if      (com < 0) x.left  = delete(x.left,  key);
        else if (com > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    } 
   
    /* Run the program by giving the approriate command obtained from
    input files through input.txt files. The output should be displayed
    exactly like the file output.txt shows it to be.*/
  
    public static void main(String[] args) { 
        
       BST <String, Integer> bst = new BST <String, Integer>();
       bst.put("D",1);
       bst.put("B",2);
       bst.put("S",4);
       bst.put("N",6);
       // bst.put(null,4);
       bst.delete("S");
       System.out.println(bst.get("D"));
       System.out.println(bst.get("B"));
       System.out.println(bst.isEmpty());
       System.out.println(bst.size());
       System.out.println(bst.min());
       System.out.println(bst.floor("E"));
       System.out.println(bst.select(2));
    }
}