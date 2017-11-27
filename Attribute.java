
/**
 * Public Attribute class is used by public Card class.
 * It contains members: name, value and methods: getName(), getValue(), print().
 *
 * @author Zhiyong Liu
 *
 */
public class Attribute {

	/**
	 * The name of the attribute.
	 */
	private String name;

	/**
	 * The value of the attribute.
	 */
	private int value;

	/**
	 * Constructs an attribute with specified name and value.
	 *
	 * @param name the name of the attribute
	 * @param value the value of the attribute
	 */
	Attribute(String name, int value){
		this.name = name;
		this.value = value;
	}

	/**
	 * Return the name of the attribute.
	 *
	 * @return the string of the attribute's name
	 */
	public String getName(){
		return name;
	}

	/**
	 * Return the value of the value.
	 *
	 * @return  the value of the attribute
	 */
	public int getValue(){
		return value;
	}

	/**
	 * Print the name and the value of attribute.
	 */
	public void print(){
		System.out.println(name+": "+value);
	}
}
