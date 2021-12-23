//Redowan Shajib

import java.util.List;
import java.util.ArrayList;
import java.util.Random; 


//MAX HEAP
//The higher the number, the higher the priority


public class PQ {
    int data[];
    int size;
    int capacity;

    PQ(int capacity){
        this.capacity = capacity;
        size = 0;
        data = new int[capacity+1];
        data[0] = Integer.MAX_VALUE;
    }

    PQ(){
        capacity = 1000;
        size = 0;
        data = new int[capacity];
    }

    private int parent(int pos) 
    { 
        return pos / 2; 
    } 
    // Below two functions return left and 
    // right children. 
    private int leftChild(int pos) 
    { 
        return (2 * pos); 
    } 
    private int rightChild(int pos) 
    { 
        return (2 * pos) + 1; 
    } 
  
    // Returns true of given node is leaf 
    private boolean isLeaf(int pos) 
    { 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
    private void swap(int fpos, int spos) 
    { 
        int tmp; 
        tmp = data[fpos]; 
        data[fpos] = data[spos]; 
        data[spos] = tmp; 
    }
    
    // Inserts a new element to max heap 
    public void insert(int element) 
    { 
        data[++size] = element; 
  
        // Traverse up and fix violated property 
        int current = size; 
        while (data[current] > data[parent(current)]) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    } 
    
    public void remove(){
        int popped = data[1]; 
        data[1] = data[size--]; 
        heapify(1); 
        // return popped;
    }

    public int poll(){
        //Returns the node with the highest priority. This method should NOT remove that node
        //fill in
        int popped = data[1]; 
        return popped;
    }
    private void heapify(int pos) 
    { 
        if (isLeaf(pos)) 
            return; 
  
        if (data[pos] < data[leftChild(pos)] ||  
            data[pos] < data[rightChild(pos)]) { 
  
            if (data[leftChild(pos)] > data[rightChild(pos)]) { 
                swap(pos, leftChild(pos)); 
                heapify(leftChild(pos)); 
            } 
            else { 
                swap(pos, rightChild(pos)); 
                heapify(rightChild(pos)); 
            } 
            }
    }
}