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
 
 
package info.rmarcus.ggen4j;

public class StaticGraphGenerator {
	public GraphGenerator fibonacci(int toCompute, int cutOff) {
		return new GGenCommand("static-graph fibonacci " + toCompute + " " + cutOff);
	}
	
	public GraphGenerator forkJoin(int phases, int diameter) {
		return new GGenCommand("static-graph forkjoin " + phases + " " + diameter);
	}
	
	public GraphGenerator strassen(int size, int depth, int cutoff) {
		return new GGenCommand("static-graph strassen " + size + " " + depth + " " + cutoff);
	}
}
