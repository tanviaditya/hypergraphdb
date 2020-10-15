import org.hypergraphdb.*; // top-level API classes are in this package
import org.hypergraphdb.HGQuery.hg;
import java.util.List;
class removePerson
{ 

	final private static String DIR="./db";

	public static void main(String [] args)
	{
		HGConfiguration config = new HGConfiguration();
		config.setTransactional(false);
		config.setSkipOpenedEvent(true);
		HyperGraph graph=HGEnvironment.get(removePerson.DIR,config);
		HGHandle h1=graph.add("Alice");
		HGHandle h2=graph.add("Bob");



		System.out.println("=================== Displaying all the nodes of HyperGraph ===================");
		for (Object s : hg.getAll(graph, hg.type(String.class) ))
            System.out.println(s); 

		Person meet = new Person();
		meet.setName("Meet");
		meet.setAge(20);
		HGHandle meetHandle=graph.add(meet.getName());
		System.out.println((graph.get(meetHandle))+" is added...");

		System.out.println("=================== Displaying all the nodes of HyperGraph ===================");
		for (Object s : hg.getAll(graph, hg.type(String.class) ))
            System.out.println(s); 

        Person sagar = new Person();
		sagar.setName("Sagar");
		sagar.setAge(20);

        System.out.println("Replacing "+graph.get(meetHandle)+" with "+sagar);
        graph.replace(meetHandle,sagar.getName());   
		
		System.out.println("=================== Displaying all the nodes of HyperGraph ===================");
		for (Object s : hg.getAll(graph, hg.type(String.class) ))
            System.out.println(s); 


        System.out.println("Removing ....."+sagar.getName());
        // get handle and remove that atom
		graph.remove(meetHandle);


		System.out.println("=================== Displaying all the nodes of HyperGraph ===================");
		for (Object s : hg.getAll(graph, hg.type(String.class) ))
            System.out.println(s); 

     //replace


	}
}



