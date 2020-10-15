//remove all the data import org.hypergraphdb.*; // top-level API classes are in this package
import org.hypergraphdb.*; 
import org.hypergraphdb.algorithms.*;
import org.hypergraphdb.HGQuery.hg;
import java.util.List;
import org.hypergraphdb.util.Pair; 


class Traverse
{ 

    final private static String DIR="./db";

    public static void main(String [] args)
    {
        HGConfiguration config = new HGConfiguration();
        config.setTransactional(false);
        config.setSkipOpenedEvent(true);
        HyperGraph graph=HGEnvironment.get(Traverse.DIR,config);

        String[] strings = " Look here, this is a String, that is gonna be split into words and linked together".toLowerCase().replaceAll(",", "").split("\\s+");
        HGHandle[] stringsHandles = new HGHandle[strings.length];
        for (int i = 0; i<strings.length; i++){
            stringsHandles[i] = graph.add(strings[i]);
        }
        for (int i = 0; i<strings.length; i++){

                if (i< strings.length-2){
                HGPlainLink link = new HGPlainLink(stringsHandles[i], stringsHandles[i+1], stringsHandles[i+2]);
                graph.add(link);
            }
        }
        HGALGenerator alGen = new DefaultALGenerator(graph, hg.type(HGPlainLink.class), hg.type(String.class),false, true, false);
        HGTraversal trav= new HGBreadthFirstTraversal(stringsHandles[0], alGen);
        while(trav.hasNext()){
            Pair<HGHandle, HGHandle> pair = trav.next();
            System.out.println("\nTraversing. Current word: " + graph.get(pair.getSecond()));
        }
       graph.close();
    }
}