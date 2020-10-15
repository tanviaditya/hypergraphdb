import org.hypergraphdb.*; // top-level API classes are in this package
import org.hypergraphdb.HGQuery.hg;
import java.util.List;

class findData
{ 

	final private static String DIR="./db";

	public static void main(String [] args)
	{
		HGConfiguration config = new HGConfiguration();
		config.setTransactional(false);
		config.setSkipOpenedEvent(true);
		HyperGraph graph=HGEnvironment.get(findData.DIR,config);

		for (Object s : hg.findAll(graph, hg.type(String.class)))
            System.out.println(s); //this return the handles
		
		Integer xyz=1234;
		HGHandle stringHandle4=graph.add(xyz);

		//get data specifying the condition
		for (Object s : hg.getAll(graph, hg.type(String.class)))
            System.out.println(s);
        System.out.println("========================================");
        for (Object s : hg.getAll(graph, hg.type(Integer.class)))
            System.out.println(s);  
        graph.close();
	}
}
		