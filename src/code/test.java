// package code;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashSet;

// public class Matrix extends SearchProblem {

// 	public static HashSet<String> statesSet = new HashSet<String>();

// 	public static void main(String[] args) {
// 		String grid0 = "5,5;2;4,3;2,1;2,0,0,4,0,3,0,1;3,1,3,2;4,4,3,3,3,3,4,4;4,0,17,1,2,54,0,0,46,4,1,22";
// 		String grid3 = "5,5;1;0,4;4,4;0,3,1,4,2,1,3,0,4,1;4,0;2,4,3,4,3,4,2,4;0,2,98,1,2,98,2,2,98,3,2,98,4,2,98,2,0,1";
// 		String grid4 = "5,5;1;0,4;4,4;0,3,1,4,2,1,3,0,4,1;4,0;2,4,3,4,3,4,2,4;0,2,98,1,2,98,2,2,98,3,2,98,4,2,98,2,0,98,1,0,98";		
// 		String grid5 = "5,5;2;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
// 		String grid7 = "7,7;4;4,3;0,2;0,1,1,0,1,1,1,2,2,0,2,2,2,4,2,6,1,4;5,5,5,0;5,1,2,5,2,5,5,1;0,0,98,3,2,98,4,4,98,0,3,98,0,4,98,0,5,98,5,4,98";
// 		String grid10 = "6,6;1;4,3;2,4;0,1,1,0,3,0,4,1,4,3,3,4,1,4,0,3,1,5;0,2;1,3,4,2,4,2,1,3;0,5,90,1,2,92,4,4,2,5,5,1,1,1,98";
// 		String solution = solve(grid3, "BF", false);
// 		System.out.println(solution);
// 	}
// //	kill,down,kill,down,right,right,drop;5;8;2660

// 	public static String genGrid() {
// 		StringBuilder str = new StringBuilder();
// 		int m;
// 		int n;
// 		int c;
// 		int noHostages;
// 		int noPills;
// 		int noAgents;
// 		int noPads;
// 		boolean[][] occupiedCells;
// 		int noOfEmptyCells;

// 		m = (int) (Math.random() * 11) + 5;
// 		n = (int) (Math.random() * 11) + 5;
// //		m = 4;
// //		n = 4;
// 		occupiedCells = new boolean[m][n];

// 		c = (int) (Math.random() * 4) + 1;
// //		c = 2;
// 		int x = (int) (Math.random() * m);
// 		int y = (int) (Math.random() * n);
// 		occupiedCells[x][y] = true;

// 		// grid
// 		str.append(m + "," + n + ";" + c + ";");
// 		// neo
// 		str.append(x + "," + y + ";");

// 		// tel
// 		for (int i = 0; i < 1; i++) {

// 			x = (int) (Math.random() * m);
// 			y = (int) (Math.random() * n);

// 			if (occupiedCells[x][y])
// 				i--;
// 			else {
// 				occupiedCells[x][y] = true;
// 				str.append(x + "," + y + ";");
// 			}
// 		}

// 		noHostages = (int) (Math.random() * 8) + 3;

// 		int hostageDamage;
// 		StringBuilder strHostages = new StringBuilder();
// 		for (int i = 0; i < noHostages; i++) {
// 			x = (int) (Math.random() * m);
// 			y = (int) (Math.random() * n);
// 			hostageDamage = (int) (Math.random() * 99) + 1;

// 			if (occupiedCells[x][y])
// 				i--;
// 			else {
// 				if (i != 0)
// 					strHostages.append(",");
// 				occupiedCells[x][y] = true;
// 				strHostages.append(x + "," + y + "," + hostageDamage);
// 			}
// 		}

// 		noPills = (int) (Math.random() * noHostages) + 1;
// //		noPills = 1;

// //		Occupy Hostages

// //		Occupy Pills

// 		StringBuilder strPills = new StringBuilder();
// 		for (int i = 0; i < noPills; i++) {

// 			x = (int) (Math.random() * m);
// 			y = (int) (Math.random() * n);

// 			if (occupiedCells[x][y])
// 				i--;
// 			else {
// 				if (i != 0)
// 					strPills.append(",");
// 				occupiedCells[x][y] = true;
// 				strPills.append(x + "," + y);
// 			}
// 		}

// 		noOfEmptyCells = m * n - 2 - noHostages - noPills;

// 		noPads = ((int) (Math.random() * (noOfEmptyCells - 2)) + 2);
// //		noPads = 3;

// 		if (noPads % 2 != 0)
// 			noPads--;

// 		noOfEmptyCells -= noPads;
// 		StringBuilder strPads = new StringBuilder();

// 		for (int i = 0; i < noPads; i++) {
// 			x = (int) (Math.random() * m);
// 			y = (int) (Math.random() * n);
// 			if (occupiedCells[x][y])
// 				i--;
// 			else {
// 				if (i != 0)
// 					strPads.append(",");
// 				occupiedCells[x][y] = true;
// 				strPads.append(x + "," + y);

// 			}
// 		}

// //		Occupy Agents
// 		noAgents = ((int) (Math.random() * (noOfEmptyCells - 1)) + 1);
// //		noAgents = 5;
// 		StringBuilder strAgents = new StringBuilder();

// 		for (int i = 0; i < noAgents; i++) {

// 			x = (int) (Math.random() * m);
// 			y = (int) (Math.random() * n);

// 			if (occupiedCells[x][y])
// 				i--;
// 			else {
// 				if (i != 0)
// 					strAgents.append(",");
// 				occupiedCells[x][y] = true;
// 				strAgents.append(x + "," + y);
// 			}
// 		}

// 		str.append(strAgents + ";" + strPills + ";" + strPads + ";" + strHostages);
// 		return str.toString();

		
// 	}

// 	public static String solve(String grid, String strategy, boolean visualize) {

// 		statesSet = new HashSet<String>();

		
// 		String state = modifyGrid(grid);
		
// 		System.out.println(visualizeGrid(state));
// 		System.out.println();

// 		Node root = new Node(state, null, null, 0, 0);
// //		System.out.println(state);
// //		System.out.println(visualizeGrid(m,n,c , neo , tel, agents, hostages, pills,pads));

// 		switch (strategy) {

// 		case "BF":
// 			return breadthFirst(root, visualize);

// 		// ADD VISUALLIZE TO REST OF METHODS
// 		case "DF":
// 			return depthFirst(root);

// 		case "ID":
// 			return iterativeDeepening(root);

// 		case "UC":
// 			return uniformCost(root);

// 		case "GR1":
// 			return greedy1(root);

// 		case "GR2":
// 			return greedy2(root);

// 		case "AS1":
// 			return aStar1(root);

// 		case "AS2":
// 			return aStar2(root);

// 		}

// 		return strategy;

// 	}

// 	public static String breadthFirst(Node node, boolean visualize) {
// 		ArrayList<Node> q = new ArrayList<Node>();
// 		q.add(node);
// 		int nodes = 0;
// 		while (!q.isEmpty()) {
// 			node = q.remove(0);
// //			System.out.println(node.depth);

// //			if (!q.isEmpty()) 
// //				if (node.depth < q.get(0).depth) 
// //					System.out.println(q.get(0).depth);
					
// 			String state = node.state;
// //			System.out.println("dequeue " + node.operator);
// //			System.out.println(visualizeGrid(state));

// 			nodes++;

// 			if (goalTest(node)) {
// 				return generatePlan(node) + ";" + getDeaths(state) + ";" + getKills(state) + ";" + nodes;
// 				// return plan + deaths + kills;
// 			}

// 			ArrayList<Node> children = generateStates(node);

// 			// System.out.println(children.size());
// 			q.addAll(children);
// 		}
// 		// return failure
// 		return "No Solution";
// 	}

// 	public static String depthFirst(Node node) {
// 		ArrayList<Node> q = new ArrayList<Node>();
// 		q.add(node);

// 		int nodes = 0;
// 		while (!q.isEmpty()) {
// 			node = q.remove(q.size() - 1);
// 			String state = node.state;
// 			nodes++;
// 			if (goalTest(node)) {
// 				return generatePlan(node) + ";" + getDeaths(state) + ";" + getKills(state) + ";" + nodes;
// 				// return plan + deaths + kills;
// 			}
// 			ArrayList<Node> children = generateStates(node);
// 			q.addAll(children);
// 		}
// 		// return failure
// 		return "No Solution";

// 	}

// //	drop,takePill,kill, and fly.

// 	public static boolean goalTest(Node node) {
// 		String state = node.state;
// //		int m = getM(state);
// //		int n = getN(state);
// //		int c = getC(state);
// 		int[] neo = getNeo(state);
		
// 		int[] tel = getTelephone(state);
		
// 		ArrayList<Integer> hostages = getArrayInt(state, 7);
// 		ArrayList<Integer> carriedHostages = getArrayInt(state, 8);
// 		if (carriedHostages.isEmpty() && hostages.isEmpty() && (neo[2] < 100)&& tel[0]==neo[0] && tel[1] == neo[1])
// 			return true;
// 		return false;
// 	}

// 	public static String generatePlan(Node node) {
// 		String plan = "";
// 		String action = "";
		
// 		plan = node.operator;
// 		node = node.parent;
		

// 		while (node.operator != null) {
// 			System.out.println(visualizeGrid(node.state));
// 			System.out.println();
// 			action = node.operator;
// 			plan = action + "," + plan;
// 			node = node.parent;
// 		}

// 		return plan;
// 	}
	
// 	public static ArrayList<Node> generateStates(Node node) {

// //		System.out.println("state "+ node.operator+" " + node.depth+ ": " );
// //		String oldState = node.state;
// 		String oldState = node.state;
// //		System.out.println(oldState);
// 		String prevAction;
		
// 		if(node.operator !=null)
// 			prevAction = node.operator;
// 		else
// 			prevAction= "none";
		
// 		int m = getM(oldState);
// 		int n = getN(oldState);
// 		int c = getC(oldState);
// 		int[] neo = getNeo(oldState);
// 		int[] tel = getTelephone(oldState);
// 		ArrayList<Integer> agents = getArrayInt(oldState, 4);
// 		ArrayList<Integer> pills = getArrayInt(oldState, 5);
// 		ArrayList<Integer> pads = getArrayInt(oldState, 6);
// 		ArrayList<Integer> hostages = getArrayInt(oldState, 7);
// 		ArrayList<Integer> carriedHostages = getArrayInt(oldState, 8);
// 		int kills = getKills(oldState);
// 		int deaths = getDeaths(oldState);
		
// //		m = getM(oldState);
// //		n = getN(oldState);
// //		c = getC(oldState);
// //		neo = getNeo(oldState);
// //		tel = getTelephone(oldState);
// //		agents = getArrayInt(oldState, 4);
// //		pills = getArrayInt(oldState, 5);
// //		pads = getArrayInt(oldState, 6);
// //		hostages = getArrayInt(oldState, 7);
// //		carriedHostages = getArrayInt(oldState, 8);
// //		kills = getKills(oldState);
// //		deaths = getDeaths(oldState);

// //		System.out.println("Number of hostages " + hostages.size());
// //		System.out.println("Number of Carried Hostages " + carriedHostages.size());
// //		System.out.println();
// 		String newState = "";
// 		String stateEnd = "";

		
// 		ArrayList<Node> children = new ArrayList<Node>();

// 		if (neo[2] >= 100) 
// 			return children;


// //		Move Up
// 		if (neo[0] > 0 && NoAgent(neo[0] - 1, neo[1], agents, hostages) ) {
			
// 			stateEnd = addDamage(hostages, carriedHostages, kills, deaths, oldState);
// 			newState = appendState(m, n, c, new int[] { neo[0] - 1, neo[1], neo[2] }, tel, agents, pills, pads,
// 					stateEnd);

// 			children.add(new Node(newState, node, "up", node.pathCost + 1, node.depth + 1));

// 			// reinitialize hostages
// 			neo = getNeo(oldState);
// 			tel = getTelephone(oldState);
// 			agents = getArrayInt(oldState, 4);
// 			pills = getArrayInt(oldState, 5);
// 			pads = getArrayInt(oldState, 6);
// 			hostages = getArrayInt(oldState, 7);
// 			carriedHostages = getArrayInt(oldState, 8);
// 			kills = getKills(oldState);
// 			deaths = getDeaths(oldState);
// 		}

// //		Move Down
// 		if (neo[0] < m - 1 && NoAgent(neo[0] + 1, neo[1], agents, hostages)) {
// //			System.out.println("down");
// //			System.out.println(" At depth: " + node.depth);
// //			System.out.println("Number of hostages " + hostages.size());
// //			System.out.println("Number of Carried Hostages " + carriedHostages.size());
// //			System.out.println("old: ("+  oldState.neo.x + ","+ oldState.neo.y +")");
// //			System.out.println("new: ("+  stateDown.neo.x + ","+ stateDown.neo.y +")");
// 			stateEnd = addDamage(hostages, carriedHostages, kills, deaths, oldState);
// 			newState = appendState(m, n, c, new int[] { neo[0] + 1, neo[1], neo[2] }, tel, agents, pills, pads,
// 					stateEnd);
// 			children.add(new Node(newState, node, "down", node.pathCost + 1, node.depth + 1));

// 			// reinitialize hostages
// 			neo = getNeo(oldState);
// 			tel = getTelephone(oldState);
// 			agents = getArrayInt(oldState, 4);
// 			pills = getArrayInt(oldState, 5);
// 			pads = getArrayInt(oldState, 6);
// 			hostages = getArrayInt(oldState, 7);
// 			carriedHostages = getArrayInt(oldState, 8);
// 			kills = getKills(oldState);
// 			deaths = getDeaths(oldState);
// 		}

// //		Move Left
// 		if (neo[1] > 0 && NoAgent(neo[0], neo[1] - 1, agents, hostages)) {
// //			System.out.println("left");
// //			System.out.println(" At depth: " + node.depth);
// //			System.out.println("Number of hostages " + hostages.size());
// //			System.out.println("Number of Carried Hostages " + carriedHostages.size());
// 			// System.out.println("old: ("+ oldState.neo.x + ","+ oldState.neo.y +")");
// //			System.out.println("new: ("+  stateLeft.neo.x + ","+ stateLeft.neo.y +")");
// 			stateEnd = addDamage(hostages, carriedHostages, kills, deaths, oldState);
// 			newState = appendState(m, n, c, new int[] { neo[0], neo[1] - 1, neo[2] }, tel, agents, pills, pads,
// 					stateEnd);
// 			children.add(new Node(newState, node, "left", node.pathCost + 1, node.depth + 1));
// 			// reinitialize hostages
// 			neo = getNeo(oldState);
// 			tel = getTelephone(oldState);
// 			agents = getArrayInt(oldState, 4);
// 			pills = getArrayInt(oldState, 5);
// 			pads = getArrayInt(oldState, 6);
// 			hostages = getArrayInt(oldState, 7);
// 			carriedHostages = getArrayInt(oldState, 8);
// 			kills = getKills(oldState);
// 			deaths = getDeaths(oldState);
// 		}

// //		Move Right
// 		if (neo[1] < n - 1 && NoAgent(neo[0], neo[1] + 1, agents, hostages)) {
// //			System.out.println("right");
// //			System.out.println(" At depth: " + node.depth);
// //
// //			System.out.println("Number of hostages " + hostages.size());
// //			System.out.println("Number of Carried Hostages " + carriedHostages.size());
// //			System.out.println("old: ("+  oldState.neo.x + ","+ oldState.neo.y +")");
// //			System.out.println("new: ("+  stateRight.neo.x + ","+ stateRight.neo.y +")");
// 			stateEnd = addDamage(hostages, carriedHostages, kills, deaths, oldState);
// 			newState = appendState(m, n, c, new int[] { neo[0], neo[1] + 1, neo[2] }, tel, agents, pills, pads,
// 					stateEnd);
// 			children.add(new Node(newState, node, "right", node.pathCost + 1, node.depth + 1));

// 			// reinitialize hostages
// 			neo = getNeo(oldState);
// 			tel = getTelephone(oldState);
// 			agents = getArrayInt(oldState, 4);
// 			pills = getArrayInt(oldState, 5);
// 			pads = getArrayInt(oldState, 6);
// 			hostages = getArrayInt(oldState, 7);
// 			carriedHostages = getArrayInt(oldState, 8);
// 			kills = getKills(oldState);
// 			deaths = getDeaths(oldState);
// 		}

// //		Carry 
// 		if (!prevAction.equals("ca")) {
// 			int hostageX, hostageY, hostageDamage;
// 			for (int i = 0; i < hostages.size(); i += 3) {
// 				hostageX = hostages.get(i);
// 				hostageY = hostages.get(i + 1);
// 				hostageDamage = hostages.get(i + 2);

// 				if (neo[0] == hostageX && neo[1] == hostageY && hostageDamage < 100 && carriedHostages.size() < c) {
// 					carriedHostages.add(hostageX);
// 					carriedHostages.add(hostageY);
// 					carriedHostages.add(hostageDamage);
// 					hostages.remove(i + 2);
// 					hostages.remove(i + 1);
// 					hostages.remove(i);
// 					i -= 3;
// 					stateEnd = addDamage(hostages, carriedHostages, kills, deaths, oldState);
// 					newState = appendState(m, n, c, neo, tel, agents, pills, pads, stateEnd);
// 					children.add(new Node(newState, node, "carry", node.pathCost + 1, node.depth + 1));
// //					System.out.println("carry");
// //					System.out.println(" At depth: " + node.depth);
// //
// //					System.out.println("Number of hostages " + hostages.size());
// //					System.out.println("Number of Carried Hostages " + carriedHostages.size());

// 					break;

// 				}
// 			}
// 			// reinitialize hostages
// 			neo = getNeo(oldState);
// 			tel = getTelephone(oldState);
// 			agents = getArrayInt(oldState, 4);
// 			pills = getArrayInt(oldState, 5);
// 			pads = getArrayInt(oldState, 6);
// 			hostages = getArrayInt(oldState, 7);
// 			carriedHostages = getArrayInt(oldState, 8);
// 			kills = getKills(oldState);
// 			deaths = getDeaths(oldState);
// 		}

// //		Drop
// 		if (neo[0] == tel[0] && neo[1] == tel[1] && carriedHostages.size() > 0) {
			

// //			System.out.println("drop");
// //			System.out.println(" At depth: " + node.depth);
// 			carriedHostages.clear();
// //			System.out.println("Number of hostages " + hostages.size());
// //			System.out.println("Number of Carried Hostages " + carriedHostages.size());
// 			stateEnd = addDamage(hostages, carriedHostages, kills, deaths, oldState);
// 			newState = appendState(m, n, c, neo, tel, agents, pills, pads, stateEnd);
// 			children.add(new Node(newState, node, "drop", node.pathCost + 1, node.depth + 1));

// 			// reinitialize hostages
// 			neo = getNeo(oldState);
// 			tel = getTelephone(oldState);
// 			agents = getArrayInt(oldState, 4);
// 			pills = getArrayInt(oldState, 5);
// 			pads = getArrayInt(oldState, 6);
// 			hostages = getArrayInt(oldState, 7);
// 			carriedHostages = getArrayInt(oldState, 8);
// 			kills = getKills(oldState);
// 			deaths = getDeaths(oldState);
// 		}

// //		Take Pill
// 		if (!prevAction.equals("takePillsss")) {
// 			int pillX, pillY, hostageDamage;

// 			for (int i = 0; i < pills.size(); i += 2) {

// 				pillX = pills.get(i);
// 				pillY = pills.get(i + 1);

// 				if (neo[0] == pillX && neo[1] == pillY) {
// 					pills.remove(i + 1);
// 					pills.remove(i);
// 					i -= 2;

// 					// update Neo health
// 					neo[2] = Math.max(0, neo[2] - 20);

// 					// update hostages health
// 					for (int j = 0; j < hostages.size(); j += 3) {
// 						hostageDamage = hostages.get(j + 2);
// 						if (hostageDamage < 100)
// 							hostages.set(j + 2, Math.max(0, hostageDamage - 20));
// 					}

// 					// update carried hostages health
// 					for (int j = 0; j < carriedHostages.size(); j += 3) {
// 						hostageDamage = carriedHostages.get(j + 2);
// 						if (hostageDamage < 100)
// 							carriedHostages.set(j + 2, Math.max(0, hostageDamage - 20));
// 					}

// 					// dont add damage since everyone just took a pill
// 					StringBuilder st = new StringBuilder();
// 					st.append(stringifyList(hostages)).append(";").append(stringifyList(carriedHostages)).append(";")
// 							.append(kills).append(";").append(deaths).append(";");
// 					stateEnd = st.toString();
// 					newState = appendState(m, n, c, neo, tel, agents, pills, pads, stateEnd);
// 					children.add(new Node(newState, node, "takePill", node.pathCost + 1, node.depth + 1));

// 					break;
// 				}
// 			}
// 			pills = getArrayInt(oldState, 5);
// 			neo = getNeo(oldState);
// 			// reinitialize hostages
// 			neo = getNeo(oldState);
// 			tel = getTelephone(oldState);
// 			agents = getArrayInt(oldState, 4);
// 			pills = getArrayInt(oldState, 5);
// 			pads = getArrayInt(oldState, 6);
// 			hostages = getArrayInt(oldState, 7);
// 			carriedHostages = getArrayInt(oldState, 8);
// 			kills = getKills(oldState);
// 			deaths = getDeaths(oldState);
// 		}

// //		Kill		
// 		boolean killed = false;

// 		if (!prevAction.equals("killsss") && canKill(neo[0], neo[1],  hostages)) {
// //			System.out.println("kill");
// //			System.out.println(" At depth: " + node.depth);
// //			System.out.println("Number of hostages " + hostages.size());
// //			System.out.println("Number of Carried Hostages " + carriedHostages.size());
// //			System.out.println("old state" + oldState.agents.size());
// //			System.out.println("old state" + stateKill.agents.size());
// 			int agentX, agentY;

// 			for (int i = 0; i < agents.size(); i += 2) {

// 				agentX = agents.get(i);
// 				agentY = agents.get(i + 1);

// 				// Agent left of Neo
// 				if (agentX == neo[0] && agentY - 1 == neo[1]) {
// 					agents.remove(i + 1);
// 					agents.remove(i);
// 					i -= 2;
// 					kills++;
// 					killed = true;
// 				}

// 				// Agent right of Neo
// 				else if (agentX == neo[0] && agentY + 1 == neo[1]) {
// 					agents.remove(i + 1);
// 					agents.remove(i);
// 					i -= 2;
// 					kills++;
// 					killed = true;
// 				}

// 				// Agent below of Neo
// 				else if (agentX + 1 == neo[0] && agentY == neo[1]) {
// 					agents.remove(i + 1);
// 					agents.remove(i);
// 					i -= 2;
// 					kills++;
// 					killed = true;
// 				}
// 				// Agent above of Neo
// 				else if (agentX - 1 == neo[0] && agentY == neo[1]) {
// 					agents.remove(i + 1);
// 					agents.remove(i);
// 					i -= 2;
// 					kills++;
// 					killed = true;
// 				}
// 			}
// 		}

// 		// check on hostages even if the last action was a kill
// 		// in case one of them just turned into an agent

// 		int hostageX, hostageY, hostageDamage;

// 		for (int i = 0; i < hostages.size(); i += 3) {
// 			hostageX = hostages.get(i);
// 			hostageY = hostages.get(i + 1);
// 			hostageDamage = hostages.get(i + 2);

// 			if (hostageDamage >= 100) {

// 				// Agent above Neo
// 				if (hostageX == neo[0] && hostageY - 1 == neo[1]) {
// 					hostages.remove(i + 2);
// 					hostages.remove(i + 1);
// 					hostages.remove(i);
// 					i -= 3;
// 					kills++;
// 					killed = true;
// 				}

// 				// Agent below Neo
// 				else if (hostageX == neo[0] && hostageY + 1 == neo[1]) {
// 					hostages.remove(i + 2);
// 					hostages.remove(i + 1);
// 					hostages.remove(i);
// 					i -= 3;
// 					kills++;
// 					killed = true;
// 				}

// 				// Agent Right of Neo
// 				else if (hostageX + 1 == neo[0] && hostageY == neo[1]) {
// 					hostages.remove(i + 2);
// 					hostages.remove(i + 1);
// 					hostages.remove(i);
// 					i -= 3;
// 					kills++;
// 					killed = true;
// 				}
// 				// Agent Left of Neo
// 				else if (hostageX - 1 == neo[0] && hostageY == neo[1]) {
// 					hostages.remove(i + 2);
// 					hostages.remove(i + 1);
// 					hostages.remove(i);
// 					i -= 3;
// 					kills++;
// 					killed = true;
// 				}

// 			}
// 		}
// 		if (killed) {
// //			System.out.println("kill");
// 			neo[2] = Math.min(100, neo[2] + 10);
// 			stateEnd = addDamage(hostages, carriedHostages, kills, deaths, oldState);
// 			newState = appendState(m, n, c, neo, tel, agents, pills, pads, stateEnd);
// 			children.add(new Node(newState, node, "kill", node.pathCost + 1, node.depth + 1));
// 		}
// 		neo = getNeo(oldState);
// 		agents = getArrayInt(oldState, 4);
// 		// reinitialize hostages
// 		neo = getNeo(oldState);
// 		tel = getTelephone(oldState);
// 		agents = getArrayInt(oldState, 4);
// 		pills = getArrayInt(oldState, 5);
// 		pads = getArrayInt(oldState, 6);
// 		hostages = getArrayInt(oldState, 7);
// 		carriedHostages = getArrayInt(oldState, 8);
// 		kills = getKills(oldState);
// 		deaths = getDeaths(oldState);

// //		Fly
// 		if (!prevAction.equals("flysss")) {
// 			for (int i = 0; i < pads.size(); i += 4) {
// 				if (pads.get(i) == neo[0] && pads.get(i + 1) == neo[1]) {
// 					// System.out.println("fly");
// 					neo[0] = pads.get(i + 2);
// 					neo[1] = pads.get(i + 3);
// 					stateEnd = addDamage(hostages, carriedHostages, kills, deaths, oldState);
// 					newState = appendState(m, n, c, neo, tel, agents, pills, pads, stateEnd);
// 					children.add(new Node(newState, node, "fly", node.pathCost + 1, node.depth + 1));
// 					break;
// 				}

// 			}
// 			neo = getNeo(oldState);
// 			// reinitialize hostages
// 			neo = getNeo(oldState);
// 			tel = getTelephone(oldState);
// 			agents = getArrayInt(oldState, 4);
// 			pills = getArrayInt(oldState, 5);
// 			pads = getArrayInt(oldState, 6);
// 			hostages = getArrayInt(oldState, 7);
// 			carriedHostages = getArrayInt(oldState, 8);
// 			kills = getKills(oldState);
// 			deaths = getDeaths(oldState);
// 		}

// 		// print children operators
// 		String ch = "CHILDREN: ";
// 		ArrayList<Node> nd = repeatedState(children);
// //		for (Node child : nd) {
// //			ch += child.operator + ", ";
// //		}
// //		System.out.println(ch);
// //		System.out.println();

// 		return nd;
// 	}

	
	
// 	public static ArrayList<Node> repeatedState(ArrayList<Node> children) {
// 		ArrayList<Node> filteredChildren = new ArrayList<Node>();
		
		
// 		//location of neo, number of agents, number of hostages, number of hostages carried,number of pills

// 		for (Node node : children) {
// 			String stateString = node.state;
// 			int[] neo = getNeo(stateString);
// 			int numberOfAgents = getArrayInt(stateString,4).size();
// 			int numberOfHostages = getArrayInt(stateString,7).size();
// 			int numberOfPills = getArrayInt(stateString,5).size();
// 			int numberOfCarriedHostages = getArrayInt(stateString,8).size();
// //			position of agents, position of hostages, damage of hostages 
			
// //			System.out.println(statesSet.size());
			
// 			String str = ""+neo[0]+neo[1]+neo[2]+numberOfAgents+numberOfHostages+numberOfPills+numberOfCarriedHostages;

// 			// if state not found in hashset
// 			if (!statesSet.contains(str)) {
// 				// add to hashset
// 				statesSet.add(str);
// 				// add to filtered children
// 				filteredChildren.add(node);
// 			}
// //			else {
// //				System.out.println("Repeated state " + str);
// //			}
// 		}
		

// 		return filteredChildren;
	

// 	}

// //	public static String repeatedString(String state) {
// //		// format:
// //		// neoX,neoY;agents;pills;hostagesNoDamage;
// //
// //		int[] neo = getNeo(state);
// //		ArrayList<Integer> agents = getArrayInt(state, 4);
// //		ArrayList<Integer> pills = getArrayInt(state, 5);
// //		ArrayList<Integer> hostages = getArrayInt(state, 7);
// //
// //		ArrayList<Integer> noDamage = new ArrayList<Integer>();
// //		for (int i = 0; i < hostages.size(); i += 3) {
// //			noDamage.add(hostages.get(i));
// //			noDamage.add(hostages.get(i + 1));
// //
// //		}
// //
// //		StringBuilder st = new StringBuilder();
// //		st.append(neo[0]).append(",").append(neo[1]).append(";");
// //		st.append(stringifyList(agents)).append(";");
// //		st.append(stringifyList(pills)).append(";");
// //		st.append(stringifyList(noDamage)).append(";");
// //
// //		return st.toString();
// //	}

// 	public static ArrayList<Node> generateStates2(Node node) {

// //		System.out.println("state "+ node.operator+" " + node.depth+ ": " );
// //		String oldState = node.state;
// 		String oldState = node.state;
// //		System.out.println(oldState);
// 		String prevAction;
		
// 		if(node.operator !=null)
// 			prevAction = node.operator;
// 		else
// 			prevAction= "none";
		
// 		int m = getM(oldState);
// 		int n = getN(oldState);
// 		int c = getC(oldState);
// 		int[] neo = getNeo(oldState);
// 		int[] tel = getTelephone(oldState);
// 		ArrayList<Integer> agents = getArrayInt(oldState, 4);
// 		ArrayList<Integer> pills = getArrayInt(oldState, 5);
// 		ArrayList<Integer> pads = getArrayInt(oldState, 6);
// 		ArrayList<Integer> hostages = getArrayInt(oldState, 7);
// 		ArrayList<Integer> carriedHostages = getArrayInt(oldState, 8);
// 		int kills = getKills(oldState);
// 		int deaths = getDeaths(oldState);

// //		System.out.println("Number of hostages " + hostages.size());
// //		System.out.println("Number of Carried Hostages " + carriedHostages.size());
// //		System.out.println();
// 		String newState = "";
// 		String stateEnd = "";

// 		;
// 		ArrayList<Node> children = new ArrayList<Node>();

// 		if (neo[2] >= 100) 
// 			return children;


// //		Move Up
// 		if (neo[0] > 0 && NoAgent(neo[0] - 1, neo[1], agents, hostages) && !prevAction.equals("down")) {
// //			System.out.println("up");
// //			System.out.println(" At depth: " + node.depth);
// //			System.out.println("Number of hostages " + hostages.size() + " At depth: " + node.depth);
// //			System.out.println("Number of Carried Hostages " + carriedHostages.size());
// //			System.out.println("old: ("+  oldState.neo.x + ","+ oldState.neo.y +")");
// //			System.out.println("new: ("+  stateUp.neo.x + ","+ stateUp.neo.y +")");
// 			stateEnd = addDamage(hostages, carriedHostages, kills, deaths, oldState);
// 			newState = appendState(m, n, c, new int[] { neo[0] - 1, neo[1], neo[2] }, tel, agents, pills, pads,
// 					stateEnd);

// 			children.add(new Node(newState, node, "up", node.pathCost + 1, node.depth + 1));

// 			// reinitialize hostages
// 			hostages = getArrayInt(oldState, 7);
// 			carriedHostages = getArrayInt(oldState, 8);
// 			deaths = getDeaths(oldState);
// 		}

// //		Move Down
// 		if (neo[0] < m - 1 && NoAgent(neo[0] + 1, neo[1], agents, hostages) && !prevAction.equals("up")) {
// //			System.out.println("down");
// //			System.out.println(" At depth: " + node.depth);
// //			System.out.println("Number of hostages " + hostages.size());
// //			System.out.println("Number of Carried Hostages " + carriedHostages.size());
// //			System.out.println("old: ("+  oldState.neo.x + ","+ oldState.neo.y +")");
// //			System.out.println("new: ("+  stateDown.neo.x + ","+ stateDown.neo.y +")");
// 			stateEnd = addDamage(hostages, carriedHostages, kills, deaths, oldState);
// 			newState = appendState(m, n, c, new int[] { neo[0] + 1, neo[1], neo[2] }, tel, agents, pills, pads,
// 					stateEnd);
// 			children.add(new Node(newState, node, "down", node.pathCost + 1, node.depth + 1));

// 			// reinitialize hostages
// 			hostages = getArrayInt(oldState, 7);
// 			carriedHostages = getArrayInt(oldState, 8);
// 			deaths = getDeaths(oldState);
// 		}

// //		Move Left
// 		if (neo[1] > 0 && NoAgent(neo[0], neo[1] - 1, agents, hostages) && !prevAction.equals("right")) {
// //			System.out.println("left");
// //			System.out.println(" At depth: " + node.depth);
// //			System.out.println("Number of hostages " + hostages.size());
// //			System.out.println("Number of Carried Hostages " + carriedHostages.size());
// 			// System.out.println("old: ("+ oldState.neo.x + ","+ oldState.neo.y +")");
// //			System.out.println("new: ("+  stateLeft.neo.x + ","+ stateLeft.neo.y +")");
// 			stateEnd = addDamage(hostages, carriedHostages, kills, deaths, oldState);
// 			newState = appendState(m, n, c, new int[] { neo[0], neo[1] - 1, neo[2] }, tel, agents, pills, pads,
// 					stateEnd);
// 			children.add(new Node(newState, node, "left", node.pathCost + 1, node.depth + 1));
// 			// reinitialize hostages
// 			hostages = getArrayInt(oldState, 7);
// 			carriedHostages = getArrayInt(oldState, 8);
// 			deaths = getDeaths(oldState);
// 		}

// //		Move Right
// 		if (neo[1] < n - 1 && NoAgent(neo[0], neo[1] + 1, agents, hostages) && !prevAction.equals("left")) {
// //			System.out.println("right");
// //			System.out.println(" At depth: " + node.depth);
// //
// //			System.out.println("Number of hostages " + hostages.size());
// //			System.out.println("Number of Carried Hostages " + carriedHostages.size());
// //			System.out.println("old: ("+  oldState.neo.x + ","+ oldState.neo.y +")");
// //			System.out.println("new: ("+  stateRight.neo.x + ","+ stateRight.neo.y +")");
// 			stateEnd = addDamage(hostages, carriedHostages, kills, deaths, oldState);
// 			newState = appendState(m, n, c, new int[] { neo[0], neo[1] + 1, neo[2] }, tel, agents, pills, pads,
// 					stateEnd);
// 			children.add(new Node(newState, node, "right", node.pathCost + 1, node.depth + 1));

// 			// reinitialize hostages
// 			hostages = getArrayInt(oldState, 7);
// 			carriedHostages = getArrayInt(oldState, 8);
// 			deaths = getDeaths(oldState);
// 		}

// //		Carry 
// 		if (!prevAction.equals("carry")) {
// 			int hostageX, hostageY, hostageDamage;
// 			for (int i = 0; i < hostages.size(); i += 3) {
// 				hostageX = hostages.get(i);
// 				hostageY = hostages.get(i + 1);
// 				hostageDamage = hostages.get(i + 2);

// 				if (neo[0] == hostageX && neo[1] == hostageY && hostageDamage < 100 && carriedHostages.size() < c) {
// 					carriedHostages.add(hostageX);
// 					carriedHostages.add(hostageY);
// 					carriedHostages.add(hostageDamage);
// 					hostages.remove(i + 2);
// 					hostages.remove(i + 1);
// 					hostages.remove(i);
// 					i -= 3;
// 					stateEnd = addDamage(hostages, carriedHostages, kills, deaths, oldState);
// 					newState = appendState(m, n, c, neo, tel, agents, pills, pads, stateEnd);
// 					children.add(new Node(newState, node, "carry", node.pathCost + 1, node.depth + 1));
// //					System.out.println("carry");
// //					System.out.println(" At depth: " + node.depth);
// //
// //					System.out.println("Number of hostages " + hostages.size());
// //					System.out.println("Number of Carried Hostages " + carriedHostages.size());

// 					break;

// 				}
// 			}
// 			// reinitialize hostages
// 			hostages = getArrayInt(oldState, 7);
// 			carriedHostages = getArrayInt(oldState, 8);
// 			deaths = getDeaths(oldState);
// 		}

// //		Drop
// 		if (neo[0] == tel[0] && neo[1] == tel[1] && carriedHostages.size() > 0 && !prevAction.equals("drop")) {
			

// //			System.out.println("drop");
// //			System.out.println(" At depth: " + node.depth);
// 			carriedHostages.clear();
// //			System.out.println("Number of hostages " + hostages.size());
// //			System.out.println("Number of Carried Hostages " + carriedHostages.size());
// 			stateEnd = addDamage(hostages, carriedHostages, kills, deaths, oldState);
// 			newState = appendState(m, n, c, neo, tel, agents, pills, pads, stateEnd);
// 			children.add(new Node(newState, node, "drop", node.pathCost + 1, node.depth + 1));

// 			// reinitialize hostages
// 			hostages = getArrayInt(oldState, 7);
// 			carriedHostages = getArrayInt(oldState, 8);
// 			deaths = getDeaths(oldState);
// 		}

// //		Take Pill
// 		if (!prevAction.equals("takePill")) {
// 			int pillX, pillY, hostageDamage;

// 			for (int i = 0; i < pills.size(); i += 2) {

// 				pillX = pills.get(i);
// 				pillY = pills.get(i + 1);

// 				if (neo[0] == pillX && neo[1] == pillY) {
// 					pills.remove(i + 1);
// 					pills.remove(i);
// 					i -= 2;

// 					// update Neo health
// 					neo[2] = Math.max(0, neo[2] - 20);

// 					// update hostages health
// 					for (int j = 0; j < hostages.size(); j += 3) {
// 						hostageDamage = hostages.get(j + 2);
// 						if (hostageDamage < 100)
// 							hostages.set(j + 2, Math.max(0, hostageDamage - 20));
// 					}

// 					// update carried hostages health
// 					for (int j = 0; j < carriedHostages.size(); j += 3) {
// 						hostageDamage = carriedHostages.get(j + 2);
// 						if (hostageDamage < 100)
// 							carriedHostages.set(j + 2, Math.max(0, hostageDamage - 20));
// 					}

// 					// dont add damage since everyone just took a pill
// 					StringBuilder st = new StringBuilder();
// 					st.append(stringifyList(hostages)).append(";").append(stringifyList(carriedHostages)).append(";")
// 							.append(kills).append(";").append(deaths).append(";");
// 					stateEnd = st.toString();
// 					newState = appendState(m, n, c, neo, tel, agents, pills, pads, stateEnd);
// 					children.add(new Node(newState, node, "takePill", node.pathCost + 1, node.depth + 1));

// 					break;
// 				}
// 			}
// 			pills = getArrayInt(oldState, 5);
// 			neo = getNeo(oldState);
// 			// reinitialize hostages
// 			hostages = getArrayInt(oldState, 7);
// 			carriedHostages = getArrayInt(oldState, 8);
// 			deaths = getDeaths(oldState);
// 		}

// //		Kill		
// 		boolean killed = false;

// 		if (!prevAction.equals("kill") && canKill(neo[0], neo[1],  hostages)) {
// //			System.out.println("kill");
// //			System.out.println(" At depth: " + node.depth);
// //			System.out.println("Number of hostages " + hostages.size());
// //			System.out.println("Number of Carried Hostages " + carriedHostages.size());
// //			System.out.println("old state" + oldState.agents.size());
// //			System.out.println("old state" + stateKill.agents.size());
// 			int agentX, agentY;

// 			for (int i = 0; i < agents.size(); i += 2) {

// 				agentX = agents.get(i);
// 				agentY = agents.get(i + 1);

// 				// Agent left of Neo
// 				if (agentX == neo[0] && agentY - 1 == neo[1]) {
// 					agents.remove(i + 1);
// 					agents.remove(i);
// 					i -= 2;
// 					kills++;
// 					killed = true;
// 				}

// 				// Agent right of Neo
// 				else if (agentX == neo[0] && agentY + 1 == neo[1]) {
// 					agents.remove(i + 1);
// 					agents.remove(i);
// 					i -= 2;
// 					kills++;
// 					killed = true;
// 				}

// 				// Agent below of Neo
// 				else if (agentX + 1 == neo[0] && agentY == neo[1]) {
// 					agents.remove(i + 1);
// 					agents.remove(i);
// 					i -= 2;
// 					kills++;
// 					killed = true;
// 				}
// 				// Agent above of Neo
// 				else if (agentX - 1 == neo[0] && agentY == neo[1]) {
// 					agents.remove(i + 1);
// 					agents.remove(i);
// 					i -= 2;
// 					kills++;
// 					killed = true;
// 				}
// 			}
// 		}

// 		// check on hostages even if the last action was a kill
// 		// in case one of them just turned into an agent

// 		int hostageX, hostageY, hostageDamage;

// 		for (int i = 0; i < hostages.size(); i += 3) {
// 			hostageX = hostages.get(i);
// 			hostageY = hostages.get(i + 1);
// 			hostageDamage = hostages.get(i + 2);

// 			if (hostageDamage >= 100) {

// 				// Agent above Neo
// 				if (hostageX == neo[0] && hostageY - 1 == neo[1]) {
// 					hostages.remove(i + 2);
// 					hostages.remove(i + 1);
// 					hostages.remove(i);
// 					i -= 3;
// 					kills++;
// 					killed = true;
// 				}

// 				// Agent below Neo
// 				else if (hostageX == neo[0] && hostageY + 1 == neo[1]) {
// 					hostages.remove(i + 2);
// 					hostages.remove(i + 1);
// 					hostages.remove(i);
// 					i -= 3;
// 					kills++;
// 					killed = true;
// 				}

// 				// Agent Right of Neo
// 				else if (hostageX + 1 == neo[0] && hostageY == neo[1]) {
// 					hostages.remove(i + 2);
// 					hostages.remove(i + 1);
// 					hostages.remove(i);
// 					i -= 3;
// 					kills++;
// 					killed = true;
// 				}
// 				// Agent Left of Neo
// 				else if (hostageX - 1 == neo[0] && hostageY == neo[1]) {
// 					hostages.remove(i + 2);
// 					hostages.remove(i + 1);
// 					hostages.remove(i);
// 					i -= 3;
// 					kills++;
// 					killed = true;
// 				}

// 			}
// 		}
// 		if (killed) {
// //			System.out.println("kill");
// 			neo[2] = Math.min(100, neo[2] + 10);
// 			stateEnd = addDamage(hostages, carriedHostages, kills, deaths, oldState);
// 			newState = appendState(m, n, c, neo, tel, agents, pills, pads, stateEnd);
// 			children.add(new Node(newState, node, "kill", node.pathCost + 1, node.depth + 1));
// 		}
// 		neo = getNeo(oldState);
// 		agents = getArrayInt(oldState, 4);
// 		// reinitialize hostages
// 		hostages = getArrayInt(oldState, 7);
// 		carriedHostages = getArrayInt(oldState, 8);
// 		deaths = getDeaths(oldState);

// //		Fly
// 			for (int i = 0; i < pads.size(); i += 4) {

// 				if (pads.get(i) == neo[0] && pads.get(i + 1) == neo[1]) {
// 					// System.out.println("fly");
// 					neo[0] = pads.get(i + 2);
// 					neo[1] = pads.get(i + 3);
// 					stateEnd = addDamage(hostages, carriedHostages, kills, deaths, oldState);
// 					newState = appendState(m, n, c, neo, tel, agents, pills, pads, stateEnd);
// 					children.add(new Node(newState, node, "fly", node.pathCost + 1, node.depth + 1));
// 					break;
// 				}

// 			}
// 			neo = getNeo(oldState);
// 			// reinitialize hostages
// 			hostages = getArrayInt(oldState, 7);
// 			carriedHostages = getArrayInt(oldState, 8);
// 			deaths = getDeaths(oldState);

// 		// print children operators
// //		String ch = "CHILDREN: ";
// //		for (Node child : children) {
// //			ch += child.operator + ", ";
// //		}
// //		System.out.println(ch);
// //		System.out.println();

// 		return repeatedState(children);
// 	}

// 	public static boolean NoAgent(int neoX, int neoY, ArrayList<Integer> agents, ArrayList<Integer> hostages) {

// 		int agentX, agentY, hostageX, hostageY, hostageDamage;

// 		for (int i = 0; i < agents.size(); i += 2) {
// 			agentX = agents.get(i);
// 			agentY = agents.get(i + 1);

// 			if (agentX == neoX && agentY == neoY)
// 				return false;
// 		}

// 		for (int i = 0; i < hostages.size(); i += 3) {
// 			hostageX = hostages.get(i);
// 			hostageY = hostages.get(i + 1);
// 			hostageDamage = hostages.get(i + 2);

// 			if (hostageDamage >= 98 && hostageX == neoX && hostageY == neoY)
// 				return false;
// 		}

// 		return true;
// 	}
	
// 	public static boolean canKill(int neoX, int neoY, ArrayList<Integer> hostages) {

// 		int hostageX, hostageY, hostageDamage;

		

// 		for (int i = 0; i < hostages.size(); i += 3) {
// 			hostageX = hostages.get(i);
// 			hostageY = hostages.get(i + 1);
// 			hostageDamage = hostages.get(i + 2);

// 			if (hostageDamage >= 98 && hostageX == neoX && hostageY == neoY)
// 				return false;
// 		}

// 		return true;
// 	}

// 	public static String addDamage(ArrayList<Integer> hostages, ArrayList<Integer> carriedHostages, int kills,
// 			int deaths, String oldState) {

// 		StringBuilder stateEnd = new StringBuilder();
// 		int hostageDamage;

// 		// Damage hostages and kill them
// 		for (int i = 0; i < hostages.size(); i += 3) {
// 			hostageDamage = hostages.get(i + 2);
// 			if (hostageDamage == 99 || hostageDamage == 98)
// 				deaths++;
// 			hostages.set(i + 2, Math.min(100, hostageDamage + 2));
// 		}

// 		for (int i = 0; i < carriedHostages.size(); i += 3) {
// 			hostageDamage = carriedHostages.get(i + 2);

// 			if (hostageDamage == 99 || hostageDamage == 98)
// 				deaths++;
// 			carriedHostages.set(i + 2, Math.min(100, hostageDamage + 2));
// 		}

// 		stateEnd.append(stringifyList(hostages)).append(";").append(stringifyList(carriedHostages)).append(";")
// 				.append(kills).append(";").append(deaths).append(";");

// 		return stateEnd.toString();

// 	}

// 	public static String appendState(int m, int n, int c, int[] neo, int[] tel, ArrayList<Integer> agents,
// 			ArrayList<Integer> pills, ArrayList<Integer> pads, String stateEnd) {
// 		StringBuilder st = new StringBuilder();

// 		st.append(m).append(",").append(n).append(";");
// 		st.append(c).append(";");
// 		st.append(neo[0]).append(",").append(neo[1]).append(",").append(neo[2]).append(";");
// 		st.append(tel[0]).append(",").append(tel[1]).append(";");
// 		st.append(stringifyList(agents)).append(";");
// 		st.append(stringifyList(pills)).append(";");
// 		st.append(stringifyList(pads)).append(";");
// 		st.append(stateEnd);

// 		return st.toString();

// 	}

// 	public static String stringifyList(ArrayList<Integer> list) {
// 		StringBuilder st = new StringBuilder();

// 		for (int i = 0; i < list.size(); i++) {
// 			if (i != 0)
// 				st.append(",");
// 			st.append(list.get(i));
// 		}

// 		return st.toString();

// 	}

// //	public String stringifyGrid(int m, int n, int c, Neo neo, Telephone tel, ArrayList<Agent> agents,
// //			ArrayList<Hostage> hostages, ArrayList<Pill> pills, ArrayList<Pad> pads) {
// //		StringBuilder str = new StringBuilder();
// //
// //		str.append(m + "," + n + ";" + c + ";");
// //		str.append(neo.x + "," + neo.y + ";");
// //		str.append(tel.x + "," + tel.y + ";");
// //
// //		for (int i = 0; i < agents.size(); i++) {
// //			Agent a = agents.get(i);
// //			if (i != 0)
// //				str.append(",");
// //
// //			str.append(a.x + "," + a.y);
// //		}
// //		str.append(";");
// //
// //		for (int i = 0; i < pills.size(); i++) {
// //			Pill a = pills.get(i);
// //			if (i != 0)
// //				str.append(",");
// //
// //			str.append(a.x + "," + a.y);
// //		}
// //		str.append(";");
// //
// //		for (int i = 0; i < pads.size(); i++) {
// //			Pad a = pads.get(i);
// //			if (i != 0)
// //				str.append(",");
// //			str.append(a.startX + "," + a.startY + "," + a.endX + "," + a.endY);
// //		}
// //		str.append(";");
// //
// //		for (int i = 0; i < hostages.size(); i++) {
// //			Hostage a = hostages.get(i);
// //			if (i != 0)
// //				str.append(",");
// //			str.append(a.x + "," + a.y);
// //		}
// //		str.append(";");
// //
// //		return str.toString();
// //	}

// //	public static String stringifyState(State state) {
// //		int m = state.m;
// //		int n = state.n;
// //		int c = state.c;
// //		Telephone tel = state.tel;
// //		Neo neo = state.neo;
// //		ArrayList<Agent> agents = state.agents;
// //		ArrayList<Hostage> hostages = state.hostages;
// //		ArrayList<Pill> pills = state.pills;
// //		ArrayList<Pad> pads = state.pads;
// //		ArrayList<Hostage> hostagesCarried = state.hostagesCarried;
// //		int kills = state.kills;
// //		int deaths = state.deaths;
// //		StringBuilder str = new StringBuilder();
// //
// //		// at 0: m,n
// //		str.append(m + "," + n + ";");
// //
// //		// at 1: c
// //		str.append(c + ";");
// //
// //		// at 2: neo
// //		str.append(neo.x + "," + neo.y + "," + neo.damage + ";");
// //
// //		// at 3: tel
// //		str.append(tel.x + "," + tel.y + ";");
// //
// //		// at 4: agents
// //
// //		System.out.println("AGENTS SIZE: " + agents.size());
// //		for (int i = 0; i < agents.size(); i++) {
// //			Agent a = agents.get(i);
// //			if (i != 0)
// //				str.append(",");
// //			str.append(a.x + "," + a.y);
// //		}
// //		str.append(";");
// //
// //		// at 5: pills
// //		for (int i = 0; i < pills.size(); i++) {
// //			Pill a = pills.get(i);
// //			if (i != 0)
// //				str.append(",");
// //			str.append(a.x + "," + a.y);
// //		}
// //		str.append(";");
// //
// //		// at 6: pads
// //		for (int i = 0; i < pads.size(); i++) {
// //			Pad a = pads.get(i);
// //			if (i != 0)
// //				str.append(",");
// //			str.append(a.startX + "," + a.startY + "," + a.endX + "," + a.endY);
// //		}
// //		str.append(";");
// //
// //		// at 7: hostages
// //		for (int i = 0; i < hostages.size(); i++) {
// //			Hostage a = hostages.get(i);
// //			if (i != 0)
// //				str.append(",");
// //			str.append(a.x + "," + a.y + "," + a.damage);
// //		}
// //		str.append(";");
// //
// //		// at 8: carried hostages
// //		for (int i = 0; i < hostagesCarried.size(); i++) {
// //			Hostage a = hostagesCarried.get(i);
// //			if (i != 0)
// //				str.append(",");
// //			str.append(a.x + "," + a.y + "," + a.damage);
// //		}
// //
// //		// at 9: kills
// //		str.append(";" + kills + ";");
// //
// //		// at 10: deaths
// //		str.append(deaths + ";");
// //		return str.toString();
// //	}

// 	public static String visualizeGrid(String state) {
// 		int m = getM(state);
// 		int n = getN(state);
// //		int c = getC(state);
// 		int[] neo = getNeo(state);
// 		int[] tel = getTelephone(state);
// 		ArrayList<Integer> agents = getArrayInt(state, 4);
// 		ArrayList<Integer> pills = getArrayInt(state, 5);
// 		ArrayList<Integer> pads = getArrayInt(state, 6);
// 		ArrayList<Integer> hostages = getArrayInt(state, 7);

// 		String[][] gridVisualized = new String[m][n];

// 		gridVisualized[tel[0]][tel[1]] = "TB";

// 		for (int i = 0; i < agents.size(); i += 2) {
// 			gridVisualized[agents.get(i)][agents.get(i + 1)] = "A";

// 		}

// 		for (int i = 0; i < hostages.size(); i += 3) {
// 			gridVisualized[hostages.get(i)][hostages.get(i + 1)] = "H" + "-" + hostages.get(i + 2);
// 		}

// 		for (int i = 0; i < pills.size(); i += 2) {
// 			gridVisualized[pills.get(i)][pills.get(i + 1)] = "P";

// 		}

// 		for (int i = 0; i < pads.size(); i += 4) {
// 			gridVisualized[pads.get(i)][pads.get(i + 1)] = "P" + pads.get(i + 2) + "-" + pads.get(i + 3);

// 		}
// 		if (gridVisualized[neo[0]][neo[1]] != null)
// 			gridVisualized[neo[0]][neo[1]] = gridVisualized[neo[0]][neo[1]] + " NEO";
// 		else
// 			gridVisualized[neo[0]][neo[1]] = "NEO";

// //		for (int i = 0; i < gridVisualized.length; i++) {
// //			for (int j = 0; j < gridVisualized[i].length; j++) {
// //				if(gridVisualized[i][j] == null)
// //					gridVisualized[i][j] = "";
// //			}
// //			
// //		}

// 		return Arrays.deepToString(gridVisualized).replace("],", "\n").replace(",", "\t").replaceAll("[\\[\\]]", " ");

// 	}

// 	public static String iterativeDeepening(Node node) {
// 		String plan = null;
// //		ArrayList<Node> children = new ArrayList<Node>();
// 		return plan;

// 	}

// 	public static String uniformCost(Node node) {
// 		String plan = null;
// //		ArrayList<Node> children = new ArrayList<Node>();
// 		return plan;

// 	}

// 	public static String greedy1(Node node) {
// 		String plan = null;
// //		ArrayList<Node> children = new ArrayList<Node>();
// 		return plan;

// 	}

// 	public static String greedy2(Node node) {
// 		String plan = null;
// //		ArrayList<Node> children = new ArrayList<Node>();
// 		return plan;
// 	}

// 	public static String aStar1(Node node) {
// 		String plan = null;
// //		ArrayList<Node> children = new ArrayList<Node>();
// 		return plan;

// 	}

// 	public static String aStar2(Node node) {
// 		String plan = null;
// //		ArrayList<Node> children = new ArrayList<Node>();
// 		return plan;
// 	}

// 	public static int[] getNeo(String grid) {
// 		String[] s = grid.split(";");
// 		String[] neo = s[2].split(",");

// 		int[] n = new int[3];

// 		n[0] = Integer.parseInt(neo[0]);
// 		n[1] = Integer.parseInt(neo[1]);
// 		n[2] = Integer.parseInt(neo[2]);

// 		return n;
// 	}

// 	public static int[] getTelephone(String grid) {
// 		String[] s = grid.split(";");
// 		String[] tel = s[3].split(",");

// 		int[] n = new int[2];

// 		n[0] = Integer.parseInt(tel[0]);
// 		n[1] = Integer.parseInt(tel[1]);

// 		return n;
// 	}

// 	public static int getM(String grid) {
// 		String[] s = grid.split(";");
// 		String[] m = s[0].split(",");
// 		return Integer.parseInt(m[0]);
// 	}

// 	public static int getN(String grid) {
// 		String[] s = grid.split(";");
// 		String[] m = s[0].split(",");
// 		return Integer.parseInt(m[1]);
// 	}

// 	public static int getC(String grid) {
// 		String[] s = grid.split(";");
// 		return Integer.parseInt(s[1]);
// 	}

// 	public static ArrayList<Integer> getArrayInt(String state, int index) {

// 		// index mapping
// 		// 0: m,n
// 		// 1: c
// 		// 2: neo
// 		// 3: telephone
// 		// 4: agents
// 		// 5: pills
// 		// 6: pads
// 		// 7: hostages
// 		// 8: carriedHostages

// 		String s = state.split(";")[index];

// 		String[] arr = s.split(",");

// 		ArrayList<Integer> elements = new ArrayList<Integer>();

// 		if (arr.length <= 1)
// 			return elements;

// 		for (int i = 0; i < arr.length; i++)
// 			elements.add(Integer.parseInt(arr[i]));
// 		return elements;

// 	}

// 	public static String modifyGrid(String g) {

// 		String[] grid = g.split(";");

// 		// add neo's damage to the state
// 		grid[2] += ",0";

// 		StringBuilder state = new StringBuilder();

// 		// reassemble string
// 		for (int i = 0; i < grid.length; i++) {
// 			state.append(grid[i]);
// 			state.append(";");
// 		}

// 		// add placeholder for carried hostages, add kills and deaths to the state;
// 		state.append(";0;0;");

// 		return state.toString();

// 	}

// 	public static int getKills(String grid) {
// 		String[] s = grid.split(";");
// 		return Integer.parseInt(s[9]);
// 	}

// 	public static int getDeaths(String grid) {
// 		String[] s = grid.split(";");
// 		return Integer.parseInt(s[10]);
// 	}

// }

// class SearchProblem {
// 	String[] operators;
// 	String initialState;
// 	ArrayList<String> stateSpace;

// 	boolean goalTest() {

// 		return true;
// 	}

// 	int pathCost(Node node) {
// 		int cost = 0;
// 		return cost;
// 	}

// }

// class Node {
    
// 	public String state;
// 	public Node parent;
// 	String operator;
// 	int depth;
// 	int pathCost;

// 	public Node(String state, Node parent, String operator, int depth, int pathCost) {
// 		this.state = state;
// 		this.parent = parent;
// 		this.operator = operator;
// 		this.depth = depth;
// 		this.pathCost = pathCost;
// 	}

// }