import org.hypergraphdb.*; // top-level API classes are in this package
import org.hypergraphdb.HGQuery.hg;
import java.util.List;
class Book {
    String title;
    String author;
    public Book() {}  // nullary-constructor

    public String getTitle() {return title; }
    public void setTitle(String title) {this.title = title;}

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
}
class Main
{ 

	final private static String DIR="./db";

	public static void main(String [] args)
	{
		HGConfiguration config = new HGConfiguration();
		config.setTransactional(false);
		config.setSkipOpenedEvent(true);
		HyperGraph graph=HGEnvironment.get(Main.DIR,config);

		String x = "Hello World";
		String y = "HyperGraph";
		String z = "ADBMS";
		// HGHandle stringHandle1=graph.add(x);

		// System.out.println(((String) graph.get(stringHandle1)).toUpperCase());

		//store and reterive data
		
		// HGHandle stringHandle2=graph.add(y);
		// HGHandle stringHandle3=graph.add(z);
		// System.out.println(((String) graph.get(stringHandle2)).toUpperCase());

		// Query all the String objects
		for (Object s : hg.getAll(graph, hg.type(String.class)))
            System.out.println(s); //this return the object
		
        //creating a link between two atoms
		// HGHandle duplicateLink = graph.add(new HGPlainLink(graph.getHandle(x), graph.getHandle(y)));
		
		//checking if link exists between two atoms
		List<HGHandle> dupsList = hg.findAll(graph, hg.link(graph.getHandle(x), graph.getHandle(y)));
		
		for (Object s : hg.getAll(graph, hg.link(graph.getHandle(x), graph.getHandle(y))))
            System.out.println(s);

		// String y = "HyperGraph";
  //       // get handle
  //       graph.remove(graph.getHandle(y));

        //replace atom XYZ with HyperGraph
        // String y = "XYZ";
        // String x = "HyperGraph";
        // graph.replace(graph.getHandle(y),x);

  //       graph.remove(stringHandle2);
  //       System.out.println("======================================");
  //       // Query all the String objects
		// for (Object s : hg.getAll(graph, hg.type(String.class)))
  //           System.out.println(s); //this return the object


        // //Query
        // for (Object s : hg.findAll(graph, hg.type(String.class)))
        //     System.out.println(s); //this returns handles



        // //create link
        // HGHandle duplicateLink = graph.add(new HGPlainLink(stringHandle1, stringHandle2));
        // //check if link exists
        // List<HGHandle> dupsList = hg.findAll(graph, hg.link(stringHandle1, stringHandle2));

        // System.out.println("querying for link returned that duplicate Link? :" + dupsList.contains(duplicateLink));
		// // hg.link: Return a condition constraining the query result set to links pointing to a target set of atoms.
		graph.close();

		//

	}
}



