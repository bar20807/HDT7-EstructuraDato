import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author José Rodrigo Barrera García Carnet: 20807
 * Universidad del Valle
 *
 */
class BinaryTreeTest {

	/*Realizamos el test del metodo add
	 * del arbol
	 */
    @Test
    public void addTest() {
        BinaryTree testTree = new BinaryTree();
        ComparableWords word=new ComparableWords("prueba","test","test");
        assertNull(testTree.root);
        testTree.add(word);
        assertNotNull(testTree.root);
    }
    
    


   
}