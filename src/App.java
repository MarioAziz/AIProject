import java.net.URI;
import java.nio.file.ClosedFileSystemException;
import java.util.*;

public class App {
    public static String[] actions = { "up", "down", "left", "right", "carry", "drop", "takePill", "kill", "fly" };
    public static Queue<MyTreeNode<matrixValue>> queue;
    public static int hostages = 0;

    public static String genGrid() {
        ArrayList<String> cellsTaken = new ArrayList<String>();
        // Random rand = new Random();
        // int m = (int) Math.floor(Math.random() * (15 - 5 + 1) + 5);
        // int n = (int) Math.floor(Math.random() * (15 - 5 + 1) + 5);
        int m = 5;
        int n = 5;
        cellsTaken.add("(" + m + "," + n + ")");
        int c = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
        int neoX = (int) Math.floor(Math.random() * (m - 0 + 1));
        int neoY = (int) Math.floor(Math.random() * (n - 0 + 1));
        cellsTaken.add("(" + neoX + "," + neoY + ")");
        int telephoneX = (int) Math.floor(Math.random() * (m - 0 + 1));
        int telephoneY = (int) Math.floor(Math.random() * (n - 0 + 1));
        String telephone = "(" + telephoneX + "," + telephoneY + ")";
        while (cellsTaken.indexOf(telephone) != -1) {
            telephoneX = (int) Math.floor(Math.random() * (m - 0 + 1));
            telephoneY = (int) Math.floor(Math.random() * (n - 0 + 1));
            telephone = "(" + telephoneX + "," + telephoneY + ")";
        }
        String outPutFirst = m + "," + n + ";" + c + ";" + neoX + "," + neoY + ";" + telephoneX + "," + telephoneY
                + ";";
        String outPutHostages = "";
        int hostagesNumber = (int) Math.floor(Math.random() * (10 - 3 + 1) + 3);
        for (int i = 0; i < hostagesNumber; i++) {
            int hostageX = (int) Math.floor(Math.random() * (m - 0 + 1));
            int hostageY = (int) Math.floor(Math.random() * (n - 0 + 1));
            int hostageDmg = (int) Math.floor(Math.random() * (99 - 1 + 1) + 1);
            String hostage = "(" + hostageX + "," + hostageY + ")";
            while (cellsTaken.indexOf(hostage) != -1) {
                hostageX = (int) Math.floor(Math.random() * (m - 0 + 1));
                hostageY = (int) Math.floor(Math.random() * (n - 0 + 1));
                hostage = "(" + hostageX + "," + hostageY + ")";
            }
            cellsTaken.add(hostage);
            if (hostagesNumber - i == 1) {
                outPutHostages += hostageX + "," + hostageY + "," + hostageDmg + ";";
            } else {
                outPutHostages += hostageX + "," + hostageY + "," + hostageDmg + ",";

            }

        }
        String outPutPills = "";
        int pillsNumber = (int) Math.floor(Math.random() * (hostagesNumber - 1 + 1) + 1);
        for (int i = 0; i < pillsNumber; i++) {
            int pillX = (int) Math.floor(Math.random() * (m - 0 + 1));
            int pillY = (int) Math.floor(Math.random() * (n - 0 + 1));
            String pill = "(" + pillX + "," + pillY + ")";
            while (cellsTaken.indexOf(pill) != -1) {
                pillX = (int) Math.floor(Math.random() * (m - 0 + 1));
                pillY = (int) Math.floor(Math.random() * (n - 0 + 1));
                pill = "(" + pillX + "," + pillY + ")";
            }
            cellsTaken.add(pill);
            if (pillsNumber - i == 1) {
                outPutPills += pillX + "," + pillY + ";";
            } else {

                outPutPills += pillX + "," + pillY + ",";

            }

        }

        String agentsString = "";
        int agentsNumberMax = (m * n) - cellsTaken.size() - 2;
        int agentsNumber = (int) Math.floor(Math.random() * (agentsNumberMax - 1 + 1) + 1);
        for (int i = 0; i < agentsNumber; i++) {
            int agentX = (int) Math.floor(Math.random() * (m - 0 + 1));
            int agentY = (int) Math.floor(Math.random() * (n - 0 + 1));
            String agent = "(" + agentX + "," + agentY + ")";
            while (cellsTaken.indexOf(agent) != -1) {
                agentX = (int) Math.floor(Math.random() * (m - 0 + 1));
                agentY = (int) Math.floor(Math.random() * (n - 0 + 1));
                agent = "(" + agentX + "," + agentY + ")";
            }
            cellsTaken.add(agent);
            if (agentsNumber - i == 1) {
                agentsString += agentX + "," + agentY + ";";
            } else {

                agentsString += agentX + "," + agentY + ",";

            }

        }
        String padsString = "";
        int padsNumberMax = (int) Math.floor(((m * n) - cellsTaken.size()) / 2);
        int padsNumber = (int) Math.floor(Math.random() * (padsNumberMax - 1 + 1) + 1);
        for (int i = 0; i < padsNumber; i++) {
            int pad1x = (int) Math.floor(Math.random() * (m - 0 + 1));
            int pad1y = (int) Math.floor(Math.random() * (n - 0 + 1));
            String pad1 = "(" + pad1x + "," + pad1y + ")";
            int pad2x = (int) Math.floor(Math.random() * (m - 0 + 1));
            int pad2y = (int) Math.floor(Math.random() * (n - 0 + 1));
            String pad2 = "(" + pad1x + "," + pad1y + ")";
            while (cellsTaken.indexOf(pad1) != -1 && cellsTaken.indexOf(pad2) != -1 && pad1 != pad2) {
                pad1x = (int) Math.floor(Math.random() * (m - 0 + 1));
                pad1y = (int) Math.floor(Math.random() * (n - 0 + 1));
                pad1 = "(" + pad1x + "," + pad1y + ")";
                pad2x = (int) Math.floor(Math.random() * (m - 0 + 1));
                pad2y = (int) Math.floor(Math.random() * (n - 0 + 1));
                pad2 = "(" + pad1x + "," + pad1y + ")";
            }
            cellsTaken.add(pad1);
            cellsTaken.add(pad2);

            if (padsNumber - i == 1) {
                padsString += pad1x + "," + pad1y + "," + pad2x + "," + pad2y + "," + pad2x + "," + pad2y + "," + pad1x
                        + "," + pad1y + ";";
            } else {

                padsString += pad1x + "," + pad1y + "," + pad2x + "," + pad2y + "," + pad2x + "," + pad2y + "," + pad1x
                        + "," + pad1y + ",";

            }

        }
        return outPutFirst + agentsString + outPutPills + padsString + outPutHostages;
    }

    public static void upFunc(MyTreeNode<matrixValue> currentNode) {
        boolean up = true;
        matrixValue currentMatrix = currentNode.value;
        if (currentMatrix.neoPositionY + 1 <= currentMatrix.gridSizeY) {
            for (int i = 0; i < currentMatrix.agentsX.length; i++) {
                if (currentMatrix.agentsX[i] == currentMatrix.neoPositionX
                        && currentMatrix.agentsY[i] == currentMatrix.neoPositionY + 1) {
                    up = false;
                }

            }
            if (up) {
                currentMatrix.neoPositionY += 1;
                for (int i = 0; i < currentMatrix.hostagesCarried.length; i++) {
                    if (currentMatrix.hostagesCarried[i]) {
                        currentMatrix.hostagesY[i] += 1;
                    }
                }

                for (int i = 0; i < 9; i++) {
                    MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentMatrix, actions[i]);
                    currentNode.addChild(temp);
                    queue.add(temp);
                }
            }
        }

    }

    public static void downFunc(MyTreeNode<matrixValue> currentNode) {
        boolean down = true;
        matrixValue currentMatrix = currentNode.value;
        if (currentMatrix.neoPositionY - 1 >= 0) {
            for (int i = 0; i < currentMatrix.agentsX.length; i++) {
                if (currentMatrix.agentsX[i] == currentMatrix.neoPositionX
                        && currentMatrix.agentsY[i] == currentMatrix.neoPositionY - 1) {
                    down = false;
                }

            }
            if (down) {
                currentMatrix.neoPositionY -= 1;
                for (int i = 0; i < currentMatrix.hostagesCarried.length; i++) {
                    if (currentMatrix.hostagesCarried[i]) {
                        currentMatrix.hostagesY[i] -= 1;
                    }
                }

                for (int i = 0; i < 9; i++) {
                    MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentMatrix, actions[i]);
                    currentNode.addChild(temp);
                    queue.add(temp);
                }
            }
        }

    }

    public static void leftFunc(MyTreeNode<matrixValue> currentNode) {
        boolean left = true;
        matrixValue currentMatrix = currentNode.value;
        if (currentMatrix.neoPositionX - 1 >= 0) {
            for (int i = 0; i < currentMatrix.agentsX.length; i++) {
                if (currentMatrix.agentsX[i] == currentMatrix.neoPositionX - 1
                        && currentMatrix.agentsY[i] == currentMatrix.neoPositionY) {
                    left = false;
                }

            }
            if (left) {
                currentMatrix.neoPositionX -= 1;
                for (int i = 0; i < currentMatrix.hostagesCarried.length; i++) {
                    if (currentMatrix.hostagesCarried[i]) {
                        currentMatrix.hostagesX[i] -= 1;
                    }
                }

                for (int i = 0; i < 9; i++) {
                    MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentMatrix, actions[i]);
                    currentNode.addChild(temp);
                    queue.add(temp);
                }
            }

        }

    }

    public static void rightFunc(MyTreeNode<matrixValue> currentNode) {
        boolean right = true;
        matrixValue currentMatrix = currentNode.value;
        if (currentMatrix.neoPositionX + 1 <= currentMatrix.gridSizeX) {
            for (int i = 0; i < currentMatrix.agentsX.length; i++) {
                if (currentMatrix.agentsX[i] == currentMatrix.neoPositionX + 1
                        && currentMatrix.agentsY[i] == currentMatrix.neoPositionY) {
                    right = false;
                }

            }
            if (right) {
                currentMatrix.neoPositionX += 1;
                for (int i = 0; i < currentMatrix.hostagesCarried.length; i++) {
                    if (currentMatrix.hostagesCarried[i]) {
                        currentMatrix.hostagesX[i] += 1;
                    }
                }

                for (int i = 0; i < 9; i++) {
                    MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentMatrix, actions[i]);
                    currentNode.addChild(temp);
                    queue.add(temp);
                }

            }
        }

    }

    public static void dropFunc(MyTreeNode<matrixValue> currentNode) {
        matrixValue currentMatrix = currentNode.value;
        boolean action = false;
        for (int i = 0; i < currentMatrix.hostagesX.length; i++) {
            if (currentMatrix.hostagesCarried[i]) {
                if (currentMatrix.neoPositionX == currentMatrix.telephoneX
                        && currentMatrix.neoPositionY == currentMatrix.telephoneY) {
                    currentMatrix.hostagesCarried[i] = false;
                    currentMatrix.carryCount--;
                    hostages--;
                    action = true;
                }
            }
        }
        if (action) {
            for (int i = 0; i < 9; i++) {
                MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentMatrix, actions[i]);
                currentNode.addChild(temp);
                queue.add(temp);
            }
        }

    }

    public static void carryFunc(MyTreeNode<matrixValue> currentNode) {
        boolean action = false;
        matrixValue currentMatrix = currentNode.value;
        for (int i = 0; i < currentMatrix.hostagesX.length; i++) {
            if (currentMatrix.neoPositionX == currentMatrix.hostagesX[i]
                    && currentMatrix.neoPositionY == currentMatrix.hostagesY[i]
                    && currentMatrix.carryCount < currentMatrix.cap) {
                currentMatrix.hostagesCarried[i] = true;
                action = true;
            }
        }
        if (action) {
            for (int i = 0; i < 9; i++) {
                MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentMatrix, actions[i]);
                currentNode.addChild(temp);
                queue.add(temp);
            }
        }

    }

    public static void takepillFunc(MyTreeNode<matrixValue> currentNode) {
        matrixValue currentMatrix = currentNode.value;
        boolean action = false;
        for (int i = 0; i < currentMatrix.pillsX.length; i++) {
            if (currentMatrix.neoPositionX == currentMatrix.pillsX[i]
                    && currentMatrix.neoPositionY == currentMatrix.pillsY[i]) {
                currentMatrix.neoDmg -= 20;
                action = true;
                for (int dmg : currentMatrix.hostagesDmg) {
                    if (dmg != 100) {
                        dmg -= 20;
                        if (dmg < 0) {
                            dmg = 0;
                        }
                    }
                }
            }
        }
        if (action) {
            for (int i = 0; i < 9; i++) {
                MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentMatrix, actions[i]);
                currentNode.addChild(temp);
                queue.add(temp);
            }
        }

    }

    public static void killFunc(MyTreeNode<matrixValue> currentNode) {
        matrixValue currentMatrix = currentNode.value;
        int x = currentMatrix.neoPositionX;
        int y = currentMatrix.neoPositionY;
        boolean action = false;
        for (int i = 0; i < currentMatrix.agentsX.length; i++) {
            if (x == currentMatrix.agentsX[i] - 1 && y == currentMatrix.agentsY[i]) {
                currentMatrix.agentDead[i] = true;
                action = true;
            }
            if (x == currentMatrix.agentsX[i] + 1 && y == currentMatrix.agentsY[i]) {
                currentMatrix.agentDead[i] = true;
                action = true;
            }
            if (x == currentMatrix.agentsX[i] && y == currentMatrix.agentsY[i] - 1) {
                currentMatrix.agentDead[i] = true;
                action = true;
            }
            if (x == currentMatrix.agentsX[i] && y == currentMatrix.agentsY[i] + 1) {
                currentMatrix.agentDead[i] = true;
                action = true;
            }
        }
        for (int i = 0; i < currentMatrix.hostageAgent.length; i++) {
            if (currentMatrix.hostageAgent[i]) {
                if (x == currentMatrix.hostagesX[i] - 1 && y == currentMatrix.hostagesY[i]) {
                    currentMatrix.hostageAgent[i] = false;
                    hostages--;
                    action = true;
                }
                if (x == currentMatrix.hostagesX[i] + 1 && y == currentMatrix.hostagesY[i]) {
                    currentMatrix.hostageAgent[i] = true;
                    hostages--;
                    action = true;
                }
                if (x == currentMatrix.hostagesX[i] && y == currentMatrix.hostagesY[i] - 1) {
                    currentMatrix.hostageAgent[i] = true;
                    hostages--;
                }
                if (x == currentMatrix.hostagesX[i] && y == currentMatrix.hostagesY[i] + 1) {
                    currentMatrix.hostageAgent[i] = true;
                    hostages--;
                    action = true;
                }
            }

        }
        if (action) {
            for (int i = 0; i < 9; i++) {
                MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentMatrix, actions[i]);
                currentNode.addChild(temp);
                queue.add(temp);
            }
        }
    }

    public static void flyFunc(MyTreeNode<matrixValue> currentNode) {
        matrixValue currentMatrix = currentNode.value;
        boolean action = false;
        for (int i = 0; i < currentMatrix.padsX.length; i += 2) {
            if (currentMatrix.neoPositionX == currentMatrix.padsX[i]
                    && currentMatrix.neoPositionY == currentMatrix.padsY[i]) {
                currentMatrix.neoPositionX = currentMatrix.padsX[i + 1];
                currentMatrix.neoPositionY = currentMatrix.padsY[i + 1];
                action = true;

            }
        }
        if (action) {
            for (int i = 0; i < 9; i++) {
                MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentMatrix, actions[i]);
                currentNode.addChild(temp);
                queue.add(temp);
            }
        }

    }

    public static void bfs(Queue<MyTreeNode<matrixValue>> queue) {

        MyTreeNode<matrixValue> currentNode;
        do {
            currentNode = queue.remove();
            hostages = 0;
            for (int i = 0; i < currentNode.value.hostagesX.length; i++) {
                if ((currentNode.value.hostagesX[i] != currentNode.value.telephoneX
                        && currentNode.value.hostagesY[i] != currentNode.value.telephoneY)
                        || currentNode.value.hostageAgent[i] == true) {
                    hostages++;

                }

            }
            if (currentNode.action == "root") {
                for (int i = 0; i < 9; i++) {
                    MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentNode.value, actions[i]);
                    currentNode.addChild(temp);
                    queue.add(temp);
                }
            } else if (currentNode.action == "up") {
                upFunc(currentNode);
            } else if (currentNode.action == "down") {
                downFunc(currentNode);
            } else if (currentNode.action == "left") {
                leftFunc(currentNode);
            } else if (currentNode.action == "right") {
                rightFunc(currentNode);
            } else if (currentNode.action == "carry") {
                carryFunc(currentNode);
            } else if (currentNode.action == "drop") {
                dropFunc(currentNode);
            } else if (currentNode.action == "takePill") {
                takepillFunc(currentNode);
            } else if (currentNode.action == "kill") {
                killFunc(currentNode);
            } else if (currentNode.action == "fly") {
                flyFunc(currentNode);
            }

            for (int i = 0; i < currentNode.value.hostagesDmg.length; i++) {
                currentNode.value.hostagesDmg[i] += 2;
                if (currentNode.value.hostagesDmg[i] >= 100) {
                    currentNode.value.hostagesDmg[i] = 100;
                    if (currentNode.value.hostagesCarried[i] == false) {
                        currentNode.value.hostageAgent[i] = true;
                    }
                }

            }

        } while (hostages != 0);
        while (currentNode != null) {
            System.out.println(currentNode.action);
            currentNode = currentNode.getParent();
        }
    }

    public static String solve(String grid, String strategy, boolean visualize) {
        String[] gridSplit = grid.split(";");
        String[] gridSize = gridSplit[0].split(",");
        String cap = gridSplit[1];
        String[] neoPosition = gridSplit[2].split(",");
        String[] telephone = gridSplit[3].split(",");
        String[] agents = gridSplit[4].split(",");
        String[] pills = gridSplit[5].split(",");
        String[] pads = gridSplit[6].split(",");
        String[] hostages = gridSplit[7].split(",");
        int neoDmg = 0;
        matrixValue root = new matrixValue(gridSize, cap, neoPosition, telephone, agents, pills, pads, hostages,
                neoDmg);
        MyTreeNode<matrixValue> tree = new MyTreeNode<matrixValue>(root, "root");
        queue = new ArrayDeque<>();
        queue.add(tree);
        switch (strategy) {
        case "BFS":
        bfs(queue);
        break;

        }

        return "";
    }

    public static void main(String[] args) throws Exception {
        // for (int i = 0; i < 10; i++) {
        String grid = genGrid();
        solve(grid, "BFS", false);

        // }
    }
}
