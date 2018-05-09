package it.polito.tdp.dizionariograph.model;

import java.util.*;

import org.jgrapht.*;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.dizionariograph.db.WordDAO;

public class Model {
	
	private Graph<String, DefaultEdge> graph;
	private String str = "";


	public Graph<String, DefaultEdge> createGraph(int numeroLettere) {
		
		this.graph = new SimpleGraph<>(DefaultEdge.class);

		WordDAO wdao = new WordDAO();
		List<String> parole = wdao.getAllWordsFixedLength(numeroLettere);
		
		Graphs.addAllVertices(this.graph, parole);
		
		for(String s1: parole) {
			for(String s2: parole) {
				if(!s1.equals(s2) && controllo(s1, s2)==true && s1.compareTo(s2)>0) {
					// creo arco
					Graphs.addEdgeWithVertices(this.graph, s1, s2);
				}
			}
		}
		
		return graph;
	}

	public boolean controllo(String s1, String s2) {
		
		int count = 0;
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i))
				count++;
		}
		
		if(count==1)
			return true;
		
		return false;
	}

	public List<String> displayNeighbours(String parolaInserita) {

		return Graphs.neighborListOf(this.graph, parolaInserita);
	}

	public int findMaxDegree() {
		
		int max = -1;
		
		for(String s: this.graph.vertexSet()) {
			if(this.graph.degreeOf(s) > max) {
				max = this.graph.degreeOf(s);
				this.str = s;
			}
		}
		
		return max;
	}
	
	public String getVertexMax() {
		return this.str;
	}
	
}
