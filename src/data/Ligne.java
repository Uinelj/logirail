package data;


import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.ListenableUndirectedGraph;

public class Ligne {
	 private ListenableUndirectedGraph ligne;
	 private JGraphModelAdapter m_jgAdapter;

   // private JGraphModelAdapter m_jgAdapter;
    public Ligne(){
    	ligne = new ListenableUndirectedGraph(DefaultEdge.class);
    }
    
    public void init_ligne(){
    	GareDataBase db = GareDataBase.getInstance();
    	db.loadJsonGare("Gare.json");
		Canton canton = new Canton(-1);

    	for(int i=0; i< 12; i++){
    		
    		ligne.addVertex(db.getGare(i));
    		if(i!=0){
    			ligne.addEdge(canton, db.getGare(i));
    		}
    		canton = new Canton(i);
    		ligne.addVertex(canton);
    		ligne.addEdge(db.getGare(i), canton);
    	}
    	
    	for(int i=19; i< 27; i++){

    		ligne.addVertex(db.getGare(i));
			ligne.addEdge(canton, db.getGare(i));

    		canton = new Canton(i);
    		ligne.addVertex(canton);
    		ligne.addEdge(db.getGare(i), canton);
    	}
    	
    	for(int i=27; i< 36; i++){

    		ligne.addVertex(db.getGare(i));
			ligne.addEdge(canton, db.getGare(i));

    		canton = new Canton(i);
    		ligne.addVertex(canton);
    		ligne.addEdge(db.getGare(i), canton);
    	}
    	canton = new Canton(100);
		ligne.addVertex(canton);
    	ligne.addEdge(db.getGare(26), canton);
    	for(int i=36; i< 47; i++){
    		ligne.addVertex(db.getGare(i));
    		ligne.addEdge(canton, db.getGare(i));

    		canton = new Canton(i);
    		ligne.addVertex(canton);
    		ligne.addEdge(db.getGare(i), canton);
    	}
    	
    	canton = new Canton(101);
		ligne.addVertex(canton);
    	ligne.addEdge(db.getGare(26), canton);
    	
    	for(int i=36; i< 47; i++){
    		ligne.addVertex(db.getGare(i));
    		ligne.addEdge(canton, db.getGare(i));
    		canton = new Canton(i);
    		ligne.addVertex(canton);
    		ligne.addEdge(db.getGare(i), canton);
    	}
    	
    	
    	
    	
    	
    	System.out.println(ligne);
    	
    	
    	
    	
    	
    }

    
	public ListenableUndirectedGraph getLigne() {
		return ligne;
	}

	public void setLigne(ListenableUndirectedGraph ligne) {
		this.ligne = ligne;
	}
   


}
