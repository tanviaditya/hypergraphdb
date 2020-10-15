import org.hypergraphdb.*; // top-level API classes are in this package
import org.hypergraphdb.HGQuery.hg;
import java.util.List;

class getData
{ 

	final private static String DIR="./db";

	public static void main(String [] args)
	{
		HGConfiguration config = new HGConfiguration();
		config.setTransactional(false);
		config.setSkipOpenedEvent(true);
		HyperGraph graph=HGEnvironment.get(getData.DIR,config);

		String x = "Hello World";
		String y = "HyperGraph";
		String z = "ADBMS";

		HGHandle stringHandle1=graph.add(x);
		System.out.println(((String) graph.get(stringHandle1)).toUpperCase()+" is added...");	
		HGHandle stringHandle2=graph.add(y);
		System.out.println(((String) graph.get(stringHandle2)).toUpperCase()+" is added...");
		HGHandle stringHandle3=graph.add(z);
		System.out.println(((String) graph.get(stringHandle3)).toUpperCase()+" is added...");

		for (Object s : hg.getAll(graph, hg.type(String.class)))
            System.out.println(s); //this return the object
       graph.close();
		}
	}