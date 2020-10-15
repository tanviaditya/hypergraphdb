import org.hypergraphdb.*; // top-level API classes are in this package
import org.hypergraphdb.HGQuery.hg;
import java.util.List;

class removeData
{ 

	final private static String DIR="./db";

	public static void main(String [] args)
	{
		HGConfiguration config = new HGConfiguration();
		config.setTransactional(false);
		config.setSkipOpenedEvent(true);
		HyperGraph graph=HGEnvironment.get(removeData.DIR,config);



		String y = "Hello World";
		// HGHandle stringHandle4=graph.add(y);
  //       System.out.println(" Added "+ y);


        System.out.println("======================================");
        // Query all the String objects
		for (Object s : hg.getAll(graph, hg.type(String.class)))
            System.out.println(s); //this return the object

        System.out.println("Removing "+y);
        // get handle and remove that atom
        graph.remove(graph.getHandle("Hello World"));


        System.out.println("======================================");
        // Query all the String objects
		for (Object s : hg.getAll(graph, hg.type(String.class)))
            System.out.println(s); //this return the object
		graph.close();


	}
}



