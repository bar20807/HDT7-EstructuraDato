/**
 * @author José Rodrigo Barrera García Carnet: 20807 
 * Universidad del Valle 
 *
 */
public class ComparableWords implements Comparable<ComparableWords>{

    String ingles,frances,español, unique;
/**
 * Declaramos el public de nuestra clase
 * @param ingles especificamos el tipo de idioma
 * @param español especificamos el tipo de idioma
 * @param frances especificamos el tipo de idioma
 */
    public ComparableWords(String ingles, String español, String frances){
        this.ingles=ingles;
        this.frances=frances;
        this.español=español;
    }
    /**
     * 
     * @param u 
     */
    public ComparableWords(String u){
        unique = u;
    }

  /**
   *   
   * @param k
   * @return unique
   */
    public String getWord(String k){
        if(unique == null) {
            if (k.equals("ingles")) {
                return ingles;
            } else if (k.equals("frances")) {
                return frances;
            } else if (k.equals("español")) {
                return español;
            } else return null;
        } else {
            return unique;
        }
    }

    @Override
    /*
     * Con esto comparamos 
     */
    public int compareTo(ComparableWords o) {
        if(o.getUnique() == null){
            return getWord(TraductorMain.Idioma).compareTo(o.getWord(TraductorMain.Idioma));
        } else {
            return getWord(TraductorMain.Idioma).compareTo(o.getUnique());
        }

    }
	/**
	 * 
	 * @return unique
	 */
    public String getUnique(){
        return unique;
    }

    @Override
    /**
     * Declaramos el toString de nuestros idiomas
     */
    public String toString() {
        return "( " +
                ingles + ", " +
                frances + ", " +
                español+
                " )\n";
    }
}
