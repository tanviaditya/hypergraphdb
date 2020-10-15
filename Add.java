import org.hypergraphdb.*; // top-level API classes are in this package
import org.hypergraphdb.HGQuery.hg;
import java.util.List;
class Person{
	private String name;
	private int age;
	// private String gender;
	 String getName() { return name; }
     void setName(String name) { this.name = name; }

     int getAge() { return age; }
     void setAge(int age) { this.age = age; }

	
	public String toString(){
		return this.name;
	}
}

class Add
{ 
	final private static String DIR="./db";

	public static void main(String [] args)
	{
		HGConfiguration config = new HGConfiguration();
		config.setTransactional(false);
		config.setSkipOpenedEvent(true);
		HyperGraph graph=HGEnvironment.get(Add.DIR,config);

		Person bob = new Person();
		bob.setName("Bob");
		bob.setAge(40);

		Person alice = new Person();
		alice.setName("Alice");
		alice.setAge(38);

		HGHandle bobHandle=graph.add(bob);
		System.out.println((graph.get(bobHandle))+" is added...");	
		HGHandle aliceHandle=graph.add(alice);
		System.out.println((graph.get(aliceHandle))+" is added...");

		System.out.println("============== Displaying nodes in Graph ===============");
		for (Object s : hg.getAll(graph, hg.type(Person.class)))
            System.out.println("Person name :"+s); //this return the object

     graph.close();

	}
}