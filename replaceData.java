import org.hypergraphdb.*; // top-level API classes are in this package
import org.hypergraphdb.HGQuery.hg;
import java.util.List;

class replaceData
{ 

	final private static String DIR="./db";

	public static void main(String [] args)
	{
		HGConfiguration config = new HGConfiguration();
		config.setTransactional(false);
		config.setSkipOpenedEvent(true);
		HyperGraph graph=HGEnvironment.get(replaceData.DIR,config);



		String y = "Software Engineering";
		HGHandle stringHandle5=graph.add(y);
        System.out.println(" Added "+ y);


        System.out.println("======================================");
        // Query all the String objects
		for (Object s : hg.getAll(graph, hg.type(String.class)))
            System.out.println(s); //this return the object

        String x=" SE ";
        System.out.println("Updating.... "+y+" to "+x);
        // get handle and remove that atom
        graph.replace(graph.getHandle(y),x);


        System.out.println("====================After updating==================");
        // Query all the String objects
		for (Object s : hg.getAll(graph, hg.type(String.class)))
            System.out.println(s); //this return the object
		graph.close();

		//

	}
}



