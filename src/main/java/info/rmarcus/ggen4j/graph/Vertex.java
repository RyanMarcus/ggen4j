// { begin copyright } 
// Copyright Ryan Marcus 2016
// 
// This file is part of poingnard.
// 
// poingnard is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
// 
// poingnard is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
// 
// You should have received a copy of the GNU General Public License
// along with poingnard.  If not, see <http://www.gnu.org/licenses/>.
// 
// { end copyright } 
 
 
package info.rmarcus.ggen4j.graph;

import java.util.HashMap;
import java.util.Map;

public class Vertex {
	private int id;
	private Map<Vertex, Map<String, String>> children;
	private Map<Vertex, Map<String, String>> parents;
	private Map<String, String> props;
	
	int topoOrder;
	
	public Vertex(int num) {
		this.id = num;
		children = new HashMap<>();
		parents = new HashMap<>();
		this.topoOrder = -1;
	}
	
	public int getID() {
		return id;
	}
	
	/**
	 * Returns the topological sort index of this vertex, if -1 if no topo
	 * sort was requested.
	 * 
	 * @return the topo sort order
	 */
	public int getTopographicalOrder() {
		return topoOrder;
		
	}
	
	public Map<Vertex, Map<String, String>> getChildren() {
		return children;
	}
	
	public Map<Vertex, Map<String, String>> getParents() {
		return parents;
	}
	
	public Map<String, String> getVertexProperties() {
		return props;
	}
	
	void addChild(Vertex v, Map<String, String> edgeProps) {
		if (children.containsKey(v)) {
			children.get(v).putAll(edgeProps);
			return;
		}
		
		children.put(v, edgeProps);
	}
	
	void addParent(Vertex v, Map<String, String> edgeProps) {
		if (parents.containsKey(v)) {
			parents.get(v).putAll(edgeProps);
			return;
		}
		
		parents.put(v, edgeProps);
	}
	
	void noteProperties(Map<String, String> props) {
		if (this.props == null) {
			this.props = new HashMap<>(props);
			return;
		}
		
		this.props.putAll(props);
	}
	
	@Override
	public int hashCode() {
		return Integer.valueOf(id).hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Vertex)
			return ((Vertex) o).id == this.id;
		return false;
	}
}
