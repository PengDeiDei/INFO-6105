/*
 * @author: Haonan Peng
 * @email: peng.haon@northeastern.edu
 *
 * This class is to implement the Bag ADT.
 */
import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class MyBag<T>{
    private List<T> items;

    /*
     * @brief: class constructor
     */
    public MyBag(){
        this.items = new ArrayList<T>();
    }

    /*
     * @brief: method to add new element to the bag
     *
     * @param: (T) item
     */
    public void add(T item){
        items.add(item);
    }

    /*
     * @brief: method to clear all elements in the bag
     */
    public void clear(){
        items.clear();
    }

    /*
     * @brief: method to check if the bag contains such element,
     * return true if such element is found, else false
     *
     * @params: (T) item
     * @return: boolean
     */
    public boolean contains(T item){
        return items.contains(item);
    }

    /*
     * @brief: method to randomly pick an element from the bag
     *
     * @return: (T)
     */
    public T grab(){
        Random random = new Random();
        return items.get(random.nextInt(items.size()));
    }

    /*
     * @brief: method to check if the bag is empty,
     *  return true if the bag is empty, else false
     *
     * @return: boolean
     */
    public boolean isEmpty(){
        return items.isEmpty();
    }

    /*
     * @brief: method to remove input element from the bag,
     *  return true if remove success, else false
     *
     * @param: (T) item
     * @return: boolean
     */
    public boolean remove(T item){
        return items.remove(item);
    }

    /*
     * @brief: method to check the size of the bag
     *
     * @return: int
     */
    public int size(){
        return items.size();
    }

    /*
     * @brief: method to transfer all elements to an array
     *
     * @return: (T[])
     */

    public Object[] toArray(){
       return items.toArray();
    }

    /*
     * @brief: method to turn all elements into String
     *
     * @return: String
     */
    @Override
    public String toString(){
        return items.toString();
    }
}