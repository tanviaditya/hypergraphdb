import org.hypergraphdb.*;
import org.hypergraphdb.HGQuery.hg;
import java.util.List;


class FindHandle
{ 

	final private static String DIR="./db";

	public static void main(String [] args)
	{
		HGConfiguration config = new HGConfiguration();
		config.setTransactional(false);
		config.setSkipOpenedEvent(true);
		HyperGraph graph=HGEnvironment.get(FindHandle.DIR,config);
		System.out.println("======== Handles of Nodes in HyperGraph =======");
		for (Object s : hg.findAll(graph, hg.type(Person.class)))
            System.out.println(s); //this return the handles
         
	}
}

		