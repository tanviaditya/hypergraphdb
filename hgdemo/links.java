//remove all the data import org.hypergraphdb.*; // top-level API classes are in this package
import org.hypergraphdb.*; 
import org.hypergraphdb.HGQuery.hg;
import java.util.List;

class Links
{ 

	final private static String DIR="./db";

	public static void main(String [] args)
	{
		HGConfiguration config = new HGConfiguration();
		config.setTransactional(false);
		config.setSkipOpenedEvent(true);
		HyperGraph graph=HGEnvironment.get(Links.DIR,config);

		Person william = new Person();
		william.setName("William");
		william.setAge(40);

		Person kate = new Person();
		kate.setName("Kate");
		kate.setAge(38);

		HGHandle williamHandle=graph.add(william);
		HGHandle kateHandle=graph.add(kate);
		//Creating a marriage Link 
        HGPlainLink mlink=new HGPlainLink(williamHandle,kateHandle);
        HGHandle marriage = graph.add(mlink);
		System.out.println("Arity of Marriage Link "+mlink.getArity());

		HGTypeSystem hgts=new HGTypeSystem(graph);
		hgts.addAlias(marriage,"Marriage Link");
		hgts.addAlias(williamHandle,"William Node");
		hgts.addAlias(kateHandle,"Kate Node");
        System.out.println("=======================================");
		
		for (Object s : hg.getAll(graph, hg.link(williamHandle,kateHandle)))
            System.out.println("Marriage Link between William and Kate is: "+s);
       	
       	// A link between Kate William and Marriage Link
       	HGPlainLink dlink=new HGPlainLink(williamHandle,kateHandle,marriage);
       	HGHandle divorce = graph.add(dlink);

       	System.out.println("Arity of Dlink "+dlink.getArity());
       	System.out.println("=======================================");

       	for(int i=0;i<dlink.getArity();i++){
       		System.out.println("Target...."+hgts.findAliases(dlink.getTargetAt(i)));
       	}

       	graph.close();
		}
	}