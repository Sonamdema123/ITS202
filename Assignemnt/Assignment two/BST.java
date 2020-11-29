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
        if (x == null){
            return 0;
        }
        return 1 + size(x.left) + size(x.right); 
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
        if (key == null){
            throw new IllegalArgumentException("key is null");
        }
        else{
            return get(root, key);
        }
        
    }

    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null; 
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
        
      Node newest = new Node(key,val,1);
        if (root == null) {
            root = newest;
            return;
        }
        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else {
                x.val = val;
                return;
            }   
        }
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) parent.left  = newest;
        else         parent.right = newest;
    
    }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
        if(size()== 0) throw new NoSuchElementException("symbol table is empty");
        return min (root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x;
       
        while(x.left != null){
            x = x.left;
        }
       
        return x;
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
        
        if (key == null) throw new IllegalArgumentException("key is null");
        if (size()==0) throw new NoSuchElementException("there is no such key");
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    } 
    private Node floor(Node x, Key key){
        
        Node z=null,floor = min(x);

        while(x != null){
            int com = key.compareTo(x.key);

            if(com < 0) x = x.left;

            else if (com > 0){
                int cmp = floor.key.compareTo(x.key);

                if(cmp<=0){
                    floor = x;
                    z = floor;
                }
                x = x.right; 
            }
            else return x;
        }
        //if there is no floor key then return null
        return z;
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
        
    public Key select(int rank){

        if(rank<0 || rank>=size()) throw new NoSuchElementException("rank out of limit");

        Node temp = select(root, rank);
        if(temp!=null) return temp.key;
        return null;
    }

     //return the Node associated to given rank else null
    private Node select(Node x, int rank){
        while(x!=null){
            int size = size(x.left);
            //if size of left is greater than given rank than set x node to left node.
            if(size > rank) x = x.left;
            //if the given rank is greater than size of left than set x to right node
            else if(size < rank){
                x = x.right;
                rank = rank - size - 1;
            }
           //if temp is equal to rank return current node
            else return x;
        }
        return null;
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
   
    public Iterable<Key> keys(Key lo, Key hi){
        if(lo==null || hi==null) throw new IllegalArgumentException("argument to keys() is null");

        Queue<Key> queue_list = new LinkedList<Key>();
        keys(root, queue_list, lo, hi); 
        return queue_list;
    }

    //travers thought the tree and add key to the queue if the key>=lo && key<=hi
    private void keys(Node x, Queue<Key> queue_list, Key lo, Key hi){ 
        if (x == null) return;  
        
        Node node1 = x;  
        //travers through the tree until the Node is null
        while (node1 != null){  
      
            int cmp = node1.key.compareTo(hi);
            int com = node1.key.compareTo(lo);

            if (node1.left == null){   
                if (cmp <= 0 && com >= 0)  queue_list.offer(node1.key);
                node1 = node1.right;

            }else{  
                Node node2 = node1.left;
               
                while (node2.right != null && node2.right != node1)  
                    node2 = node2.right;  
        
               
                if (node2.right == null){  
                    node2.right = node1;  
                    node1 = node1.left; 
            
               
                }else{  
                    node2.right = null;    
                    if (cmp <= 0 && com >= 0)  queue_list.offer(node1.key);  
                    node1 = node1.right;  
                }  
            }  
        }   
    }
 
   
    /* Run the program by giving the approriate command obtained from
    input files through input.txt files. The output should be displayed
    exactly like the file output.txt shows it to be.*/  
}