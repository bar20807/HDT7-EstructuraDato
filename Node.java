/**
 * 
 * @author José Rodrigo Barrera García Carnet: 20807
 *Universidad del Valle
 *Este codigo fue tomado como referencia de los ejemplos brindados por Douglas 
 * @param <E>
 */
public class Node<E>{
    E value;
    Node<E> left;
    Node<E> right;

    Node(E value) {
        this.value = value;
        right = null;
        left = null;
    }

    public E getValue(){
        return value;
    }
}
