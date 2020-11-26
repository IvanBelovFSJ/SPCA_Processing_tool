/** Dog.java - class defining a Dog, with attributes:
* - name (String)
* - age (int)
* - adopted (boolean)
*
 * author: Yanni Giftakis
 * edited by: Ivan Belov
 * 
 *This is a hybrid data class
 *helps with creation of a dog class objects 
*/
public class Dog	{
 private String name = ""; // name of dog
 private int age = 0; // age of dog (years)
 private boolean adopted = false; // whether dog is adopted (true) or not (false)

 // default constructor
 public Dog ()
 { // default values set above
 }// end of Dog()

 // constructor for name and age
 public Dog (String nameP, int ageP, boolean adoptedP)	{
 name = nameP; // set name
 setAge(ageP); // set age (see method below for security rule)
 setAdopted(adoptedP);
 // adopted defaulted to false above
}// end of Dog()

 // mutator (setters) for each attribute
 public void setName (String nameP)	{
	 name = nameP + "\t \t"; // set name
	 } // end of setName
 
 public void setAge (int ageP)	{
	 if (ageP > 0) // if age parameter valid (>0)
	 age = ageP; // set age
	 } // end of setAge
 
 public void setAdopted (boolean adoptedP)	{
	 adopted = adoptedP;	} // end of setAdopted

 // getPersonAge() - return dog age in "person" year ( age*7 )
 public int getPersonAge()	{
	 return ( age*7 ); // return dogs age in person years
 }// end of getPersonAge()
 
 // equals() - compare this dog against an other dog: name's are equal AND ages are equal
 public boolean equals (Dog other)	{
	 return ( name.equals(other.name) && (age==other.age) );	}// end of equals()

 // toString() - return attributes in a readable format
 public String toString()	{
	 String retStr = "";

	 String yearTitle = ( ( age == 1 ) ? " year":" years");
	 
	 retStr = retStr + name + " is \t " + age + yearTitle + " old and \t is ";

	 retStr = retStr + ( ( adopted ) ? "adopted":"not adopted");

 return (retStr);	}// end of toString()
 
 public boolean getAdopted()	{
	 return (adopted);	} // eend of getAdopted
}// end of class