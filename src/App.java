import java.util.*;
import java.util.concurrent.TimeUnit;

public class App {
    public static String[] actions = { "carry", "drop", "takePill", "kill", "fly", "up", "down", "left", "right" };
    public static Queue<MyTreeNode<matrixValue>> queue;

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

    public static Pair<Boolean, MyTreeNode<matrixValue>> upFunc(MyTreeNode<matrixValue> currentNode) {

        boolean up = false;
        if ((currentNode.getParent() != null && currentNode.getParent().action != "down")
                || currentNode.getParent() == null) {

            if (currentNode.value.neoPositionY + 1 < currentNode.value.gridSizeY) {
                up = true;
                for (int i = 0; i < currentNode.value.agentsX.length; i++) {
                    if (currentNode.value.agentsX[i] == currentNode.value.neoPositionX
                            && currentNode.value.agentsY[i] == currentNode.value.neoPositionY + 1
                            && !currentNode.value.agentDead[i]) {
                        up = false;
                    }
                }
                for (int i = 0; i < currentNode.value.hostageAgent.length; i++) {
                    if (currentNode.value.hostageAgent[i]) {
                        if (currentNode.value.hostagesX[i] == currentNode.value.neoPositionX
                                && currentNode.value.hostagesY[i] == currentNode.value.neoPositionY + 1
                                && !currentNode.value.hostageAgentKilled[i])
                            up = false;
                    }

                }
            }
            if (up) {
                currentNode.value.neoPositionY += 1;
                for (int i = 0; i < currentNode.value.hostagesCarried.length; i++) {
                    if (currentNode.value.hostagesCarried[i]) {
                        currentNode.value.hostagesY[i] += 1;
                    }
                }

            }
        }

        Pair<Boolean, MyTreeNode<matrixValue>> balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(up, currentNode);
        return balabezo;
    }

    public static Pair<Boolean, MyTreeNode<matrixValue>> downFunc(MyTreeNode<matrixValue> currentNode) {

        boolean down = false;
        if ((currentNode.getParent() != null && currentNode.getParent().action != "up")
                || currentNode.getParent() == null) {

            if (currentNode.value.neoPositionY - 1 >= 0) {

                down = true;
                for (int i = 0; i < currentNode.value.agentsX.length; i++) {
                    if (currentNode.value.agentsX[i] == currentNode.value.neoPositionX
                            && currentNode.value.agentsY[i] == currentNode.value.neoPositionY - 1
                            && !currentNode.value.agentDead[i]) {
                        down = false;
                    }
                }
                for (int i = 0; i < currentNode.value.hostageAgent.length; i++) {
                    if (currentNode.value.hostageAgent[i]) {
                        if (currentNode.value.hostagesX[i] == currentNode.value.neoPositionX
                                && currentNode.value.hostagesY[i] == currentNode.value.neoPositionY - 1
                                && !currentNode.value.hostageAgentKilled[i]) {
                            down = false;
                        }

                    }
                }
                if (down) {
                    currentNode.value.neoPositionY -= 1;
                    for (int i = 0; i < currentNode.value.hostagesCarried.length; i++) {
                        if (currentNode.value.hostagesCarried[i]) {
                            currentNode.value.hostagesY[i] -= 1;
                        }
                    }

                    // for (int i = 0; i < 9; i++) {
                    // MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentMatrix,
                    // actions[i]);
                    // currentNode.addChild(temp);
                    // queue.add(temp);
                    // }
                }
            }
        }
        Pair<Boolean, MyTreeNode<matrixValue>> balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(down, currentNode);
        return balabezo;
    }

    public static Pair<Boolean, MyTreeNode<matrixValue>> leftFunc(MyTreeNode<matrixValue> currentNode) {

        boolean left = false;
        if ((currentNode.getParent() != null && currentNode.getParent().action != "right")
                || currentNode.getParent() == null) {

            if (currentNode.value.neoPositionX - 1 >= 0) {

                left = true;
                for (int i = 0; i < currentNode.value.agentsX.length; i++) {
                    if (currentNode.value.agentsX[i] == currentNode.value.neoPositionX - 1
                            && currentNode.value.agentsY[i] == currentNode.value.neoPositionY
                            && !currentNode.value.agentDead[i]) {
                        left = false;
                    }
                }
                for (int i = 0; i < currentNode.value.hostageAgent.length; i++) {
                    if (currentNode.value.hostageAgent[i]) {
                        if (currentNode.value.hostagesX[i] == currentNode.value.neoPositionX - 1
                                && currentNode.value.hostagesY[i] == currentNode.value.neoPositionY
                                && !currentNode.value.hostageAgentKilled[i]) {
                            left = false;
                        }

                    }
                }
                if (left) {
                    currentNode.value.neoPositionX -= 1;
                    for (int i = 0; i < currentNode.value.hostagesCarried.length; i++) {
                        if (currentNode.value.hostagesCarried[i]) {
                            currentNode.value.hostagesX[i] -= 1;
                        }
                    }
                }
            }
        }
        Pair<Boolean, MyTreeNode<matrixValue>> balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(left, currentNode);
        return balabezo;
    }

    public static Pair<Boolean, MyTreeNode<matrixValue>> rightFunc(MyTreeNode<matrixValue> currentNode) {

        boolean right = false;
        if ((currentNode.getParent() != null && currentNode.getParent().action != "left")
                || currentNode.getParent() == null) {

            if (currentNode.value.neoPositionX + 1 < currentNode.value.gridSizeX) {
                right = true;

                for (int i = 0; i < currentNode.value.agentsX.length; i++) {
                    if (currentNode.value.agentsX[i] == currentNode.value.neoPositionX + 1
                            && currentNode.value.agentsY[i] == currentNode.value.neoPositionY
                            && !currentNode.value.agentDead[i]) {
                        right = false;
                    }
                }
                for (int i = 0; i < currentNode.value.hostageAgent.length; i++) {
                    if (currentNode.value.hostageAgent[i]) {
                        if (currentNode.value.hostagesX[i] == currentNode.value.neoPositionX + 1
                                && currentNode.value.hostagesY[i] == currentNode.value.neoPositionY
                                && !currentNode.value.hostageAgentKilled[i]) {
                            right = false;
                        }

                    }
                }
                if (right) {
                    currentNode.value.neoPositionX += 1;
                    for (int i = 0; i < currentNode.value.hostagesCarried.length; i++) {
                        if (currentNode.value.hostagesCarried[i]) {
                            currentNode.value.hostagesX[i] += 1;
                        }
                    }

                    // for (int i = 0; i < 9; i++) {
                    // MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentNode.value,
                    // actions[i]);
                    // currentNode.addChild(temp);
                    // queue.add(temp);
                    // }

                }
            }
        }
        Pair<Boolean, MyTreeNode<matrixValue>> balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(right,
                currentNode);
        return balabezo;
    }

    public static Pair<Boolean, MyTreeNode<matrixValue>> dropFunc(MyTreeNode<matrixValue> currentNode) {

        boolean action = false;
        // If the hostage returned to the telehpone booth
        for (int i = 0; i < currentNode.value.hostagesX.length; i++) {
            if (currentNode.value.hostagesCarried[i]) {
                if (currentNode.value.neoPositionX == currentNode.value.telephoneX
                        && currentNode.value.neoPositionY == currentNode.value.telephoneY) {
                    currentNode.value.hostagesCarried[i] = false;
                    currentNode.value.carryCount--;
                    currentNode.value.currentHostages--;
                    // System.out.println("drop");
                    action = true;
                }
            }
        }

        Pair<Boolean, MyTreeNode<matrixValue>> balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(action,
                currentNode);
        return balabezo;
    }

    public static Pair<Boolean, MyTreeNode<matrixValue>> carryFunc(MyTreeNode<matrixValue> currentNode) {

        boolean action = false;
        for (int i = 0; i < currentNode.value.hostagesX.length; i++) {
            if (currentNode.value.neoPositionX == currentNode.value.hostagesX[i]
                    && currentNode.value.neoPositionY == currentNode.value.hostagesY[i]
                    && currentNode.value.carryCount < currentNode.value.cap && !currentNode.value.hostagesCarried[i]
                    && !currentNode.value.hostageAgent[i] && !currentNode.value.hostageAgentKilled[i]) {
                currentNode.value.hostagesCarried[i] = true;
                currentNode.value.carryCount++;
                action = true;
            }
        }

        Pair<Boolean, MyTreeNode<matrixValue>> balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(action,
                currentNode);
        return balabezo;
    }

    public static Pair<Boolean, MyTreeNode<matrixValue>> takepillFunc(MyTreeNode<matrixValue> currentNode) {

        boolean action = false;
        for (int i = 0; i < currentNode.value.pillsX.length; i++) {
            if (currentNode.value.neoPositionX == currentNode.value.pillsX[i]
                    && currentNode.value.neoPositionY == currentNode.value.pillsY[i]
                    && !currentNode.value.pillTaken[i]) {
                currentNode.value.neoDmg -= 20;
                action = true;
                currentNode.value.pillTaken[i] = true;
                for (int j = 0; j < currentNode.value.hostagesX.length; j++) {
                    if (!currentNode.value.hostageAgent[j] && !currentNode.value.hostageAgentKilled[j]) {
                        if (currentNode.value.hostagesDmg[j] != 100) {
                            currentNode.value.hostagesDmg[j] -= 20;
                            if (currentNode.value.hostagesDmg[j] < 0) {
                                currentNode.value.hostagesDmg[j] = 0;
                            }
                        }
                    }
                }
            }
        }
        if (action) {
            for (int i = 0; i < currentNode.value.hostagesDmg.length; i++) {
                if (currentNode.value.hostagesDmg[i] < 100) {
                    currentNode.value.hostagesDmg[i] -= 2;
                    if (currentNode.value.hostagesDmg[i] < 0) {
                        currentNode.value.hostagesDmg[i] = 0;
                    }

                }

            }
        }

        Pair<Boolean, MyTreeNode<matrixValue>> balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(action,
                currentNode);
        return balabezo;
    }

    public static Pair<Boolean, MyTreeNode<matrixValue>> killFunc(MyTreeNode<matrixValue> currentNode) {
        int x = currentNode.value.neoPositionX;
        int y = currentNode.value.neoPositionY;
        boolean action = false;
        for (int i = 0; i < currentNode.value.agentsX.length; i++) {
            if (x == currentNode.value.agentsX[i] - 1 && y == currentNode.value.agentsY[i]
                    && !currentNode.value.agentDead[i]) {
                currentNode.value.agentDead[i] = true;
                action = true;
            }
            if (x == currentNode.value.agentsX[i] + 1 && y == currentNode.value.agentsY[i]
                    && !currentNode.value.agentDead[i]) {
                currentNode.value.agentDead[i] = true;
                action = true;
            }
            if (x == currentNode.value.agentsX[i] && y == currentNode.value.agentsY[i] - 1
                    && !currentNode.value.agentDead[i]) {
                currentNode.value.agentDead[i] = true;
                action = true;
            }
            if (x == currentNode.value.agentsX[i] && y == currentNode.value.agentsY[i] + 1
                    && !currentNode.value.agentDead[i]) {
                currentNode.value.agentDead[i] = true;
                action = true;
            }
        }
        for (int i = 0; i < currentNode.value.hostageAgent.length; i++) {
            if (currentNode.value.hostageAgent[i] == true && !currentNode.value.hostageAgentKilled[i]) {
                if (x == currentNode.value.hostagesX[i] - 1 && y == currentNode.value.hostagesY[i]) {
                    currentNode.value.hostageAgent[i] = false;
                    currentNode.value.hostageAgentKilled[i] = true;
                    currentNode.value.currentHostages--;
                    action = true;
                } else if (x == currentNode.value.hostagesX[i] + 1 && y == currentNode.value.hostagesY[i]) {
                    currentNode.value.hostageAgent[i] = false;
                    currentNode.value.currentHostages--;
                    currentNode.value.hostageAgentKilled[i] = true;
                    action = true;
                } else if (x == currentNode.value.hostagesX[i] && y == currentNode.value.hostagesY[i] - 1) {
                    currentNode.value.hostageAgent[i] = false;
                    currentNode.value.hostageAgentKilled[i] = true;
                    currentNode.value.currentHostages--;
                    action = true;
                } else if (x == currentNode.value.hostagesX[i] && y == currentNode.value.hostagesY[i] + 1) {
                    currentNode.value.hostageAgent[i] = false;
                    currentNode.value.hostageAgentKilled[i] = true;
                    currentNode.value.currentHostages--;
                    action = true;
                }
            }

        }
        if (action) {
            currentNode.value.neoDmg += 20;
        }

        Pair<Boolean, MyTreeNode<matrixValue>> balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(action,
                currentNode);
        return balabezo;
    }

    public static Pair<Boolean, MyTreeNode<matrixValue>> flyFunc(MyTreeNode<matrixValue> currentNode) {

        boolean action = false;
        for (int i = 0; i < currentNode.value.padsX.length; i += 2) {

            if (currentNode.value.neoPositionX == currentNode.value.padsX[i]
                    && currentNode.value.neoPositionY == currentNode.value.padsY[i] && !action) {

                if ((currentNode.getParent() != null && currentNode.getParent().action != "fly")
                        || currentNode.getParent() == null) {
                    currentNode.value.neoPositionX = currentNode.value.padsX[i + 1];
                    currentNode.value.neoPositionY = currentNode.value.padsY[i + 1];
                    action = true;
                }

            }
        }

        Pair<Boolean, MyTreeNode<matrixValue>> balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(action,
                currentNode);
        return balabezo;

    }

    public static void bfs(Queue<MyTreeNode<matrixValue>> queue) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        HashSet<String> hash = new HashSet<>();
        MyTreeNode<matrixValue> currentNode = queue.peek();
        hash.add(currentNode.value.hashValue()+currentNode.getLevel(currentNode));
        do {
            // for (int v = 0; v < 50; v++) {
            // MyTreeNode<matrixValue> tempNode = queue.remove();

            // currentNode = new MyTreeNode(tempNode.value, tempNode.action);
            currentNode = queue.remove();

            if (currentNode.value.neoDmg < 100) {
                for (int i = 0; i < currentNode.value.hostagesDmg.length; i++) {
                    if (currentNode.getParent() == null) {
                        currentNode.value.hostagesDmg[i] += 2;
                    } else {
                        currentNode.value.hostagesDmg[i] = currentNode.value.hostagesDmg[i] + 2;
                    }
                    if (currentNode.value.hostagesDmg[i] >= 100) {
                        currentNode.value.hostagesDmg[i] = 100;
                        if (currentNode.value.hostagesCarried[i] == false
                                && currentNode.value.hostagesX[i] != currentNode.value.telephoneX
                                && currentNode.value.hostagesY[i] != currentNode.value.telephoneY
                                && !currentNode.value.hostageAgentKilled[i]) {
                            currentNode.value.hostageAgent[i] = true;
                        }
                    }

                }
                for (int i = 0; i < 9; i++) {
                    matrixValue tempMatrix = currentNode.value.clone();
                    MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(new matrixValue(tempMatrix), actions[i]);
                    // temp.setParent(currentNode);
                    switch (temp.action) {
                        case "up":
                            Pair<Boolean, MyTreeNode<matrixValue>> outPair = upFunc(temp);
                            if (outPair.a && !hash.contains(outPair.b.value.hashValue()+currentNode.getLevel(currentNode))) {
                                hash.add(outPair.b.value.hashValue()+currentNode.getLevel(currentNode));
                                currentNode.addChild(outPair.b);
                                queue.add(outPair.b);
                            }
                            break;
                        case "down":
                            Pair<Boolean, MyTreeNode<matrixValue>> outPair2 = downFunc(temp);
                            if (outPair2.a && !hash.contains(outPair2.b.value.hashValue()+currentNode.getLevel(currentNode))) {
                                hash.add(outPair2.b.value.hashValue()+currentNode.getLevel(currentNode));
                                currentNode.addChild(outPair2.b);
                                queue.add(outPair2.b);
                            }
                            break;
                        case "left":
                            Pair<Boolean, MyTreeNode<matrixValue>> outPair3 = leftFunc(temp);
                            if (outPair3.a && !hash.contains(outPair3.b.value.hashValue()+currentNode.getLevel(currentNode))) {
                                hash.add(outPair3.b.value.hashValue()+currentNode.getLevel(currentNode));
                                currentNode.addChild(outPair3.b);
                                queue.add(outPair3.b);
                            }
                            break;
                        case "right":
                            Pair<Boolean, MyTreeNode<matrixValue>> outPair4 = rightFunc(temp);
                            if (outPair4.a && !hash.contains(outPair4.b.value.hashValue()+currentNode.getLevel(currentNode))) {
                                hash.add(outPair4.b.value.hashValue()+currentNode.getLevel(currentNode));
                                currentNode.addChild(outPair4.b);
                                queue.add(outPair4.b);
                            }
                            break;
                        case "carry":
                            Pair<Boolean, MyTreeNode<matrixValue>> outPair5 = carryFunc(temp);
                            if (outPair5.a && !hash.contains(outPair5.b.value.hashValue()+currentNode.getLevel(currentNode))) {
                                hash.add(outPair5.b.value.hashValue()+currentNode.getLevel(currentNode));
                                currentNode.addChild(outPair5.b);
                                queue.add(outPair5.b);
                            }
                            break;
                        case "drop":
                            Pair<Boolean, MyTreeNode<matrixValue>> outPair6 = dropFunc(temp);
                            if (outPair6.a && !hash.contains(outPair6.b.value.hashValue()+currentNode.getLevel(currentNode))) {
                                hash.add(outPair6.b.value.hashValue()+currentNode.getLevel(currentNode));
                                currentNode.addChild(outPair6.b);
                                queue.add(outPair6.b);

                            }
                            break;
                        case "takePill":
                            Pair<Boolean, MyTreeNode<matrixValue>> outPair7 = takepillFunc(temp);
                            if (outPair7.a && !hash.contains(outPair7.b.value.hashValue()+currentNode.getLevel(currentNode))) {
                                hash.add(outPair7.b.value.hashValue()+currentNode.getLevel(currentNode));
                                currentNode.addChild(outPair7.b);
                                queue.add(outPair7.b);

                            }
                            break;
                        case "kill":
                            Pair<Boolean, MyTreeNode<matrixValue>> outPair8 = killFunc(temp);
                            if (outPair8.a && !hash.contains(outPair8.b.value.hashValue()+currentNode.getLevel(currentNode))) {
                                hash.add(outPair8.b.value.hashValue()+currentNode.getLevel(currentNode));
                                currentNode.addChild(outPair8.b);
                                queue.add(outPair8.b);
                            }
                            break;
                        case "fly":
                            Pair<Boolean, MyTreeNode<matrixValue>> outPair9 = flyFunc(temp);
                            if (outPair9.a && !hash.contains(outPair9.b.value.hashValue()+currentNode.getLevel(currentNode))) {
                                hash.add(outPair9.b.value.hashValue()+currentNode.getLevel(currentNode));
                                currentNode.addChild(outPair9.b);
                                queue.add(outPair9.b);
                            }
                            break;

                        default:
                            break;
                    }

                    System.out
                            .print(currentNode.getLevel(currentNode) + Arrays.toString(currentNode.value.hostagesDmg));

                }
                System.out.println("");
                if (currentNode.getParent() != null)
                    System.out.print("Parent=" + currentNode.getParent().getLevel(currentNode)
                            + Arrays.toString(currentNode.getParent().value.hostagesDmg));
                // System.out.println("");
                // System.out.println(currentNode.getLevel(currentNode)+","+"root= " +
                // currentNode.action + "," + currentNode.value.currentHostages);

            }

            // // for (MyTreeNode<matrixValue> myTreeNode : currentNode.getChildren()) {
            // // System.out.println(myTreeNode.action
            // +","+myTreeNode.value.currentHostages);
            // // }
            // System.out.println("-------");
            // TimeUnit.SECONDS.sleep(2);
            // System.out.println(counter);
            // counter++;
        } while (currentNode.value.currentHostages != 0);
        // }
        while (currentNode.action != "root") {
            System.out.println(currentNode.value.currentHostages);
            System.out.println(currentNode.action);
            currentNode = (MyTreeNode<matrixValue>) currentNode.getParent();
        }
    }

    public static String solve(String grid, String strategy, boolean visualize) throws Exception {
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
        // System.out.println(root.hashValue());
        queue = new ArrayDeque<>();
        queue.add(tree);
        // solvetest(tree);

        switch (strategy) {
            case "BFS":
                bfs(queue);
                break;

        }

        return "";
    }

    public static void solvetest(MyTreeNode<matrixValue> tree) {
        System.out.println(tree.value.currentHostages);
        MyTreeNode<matrixValue> down = downFunc(tree).b;
        System.out.println(tree.value.neoPositionX + " , " + tree.value.neoPositionY);
        MyTreeNode<matrixValue> fly = flyFunc(tree).b;
        System.out.println(tree.value.neoPositionX + " , " + tree.value.neoPositionY);
        MyTreeNode<matrixValue> up = upFunc(tree).b;
        System.out.println(tree.value.neoPositionX + " , " + tree.value.neoPositionY);
        MyTreeNode<matrixValue> carry = carryFunc(tree).b;
        for (Boolean x : tree.value.hostagesCarried) {
            System.out.println(x);
        }

        down = downFunc(tree).b;
        fly = flyFunc(tree).b;
        MyTreeNode<matrixValue> right = rightFunc(tree).b;
        up = upFunc(tree).b;
        MyTreeNode<matrixValue> drop = dropFunc(tree).b;
        System.out.println(drop.value.currentHostages);
        down = downFunc(tree).b;
        down = downFunc(tree).b;
        MyTreeNode<matrixValue> kill = killFunc(tree).b;
        down = downFunc(tree).b;
        down = downFunc(tree).b;
        MyTreeNode<matrixValue> left = leftFunc(tree).b;
        carry = carryFunc(tree).b;
        right = rightFunc(tree).b;
        right = rightFunc(tree).b;
        kill = killFunc(tree).b;
        System.out.println(tree.value.currentHostages);

        left = leftFunc(tree).b;
        up = upFunc(tree).b;
        up = upFunc(tree).b;
        up = upFunc(tree).b;
        up = upFunc(tree).b;
        drop = dropFunc(tree).b;
        System.out.println(tree.value.currentHostages);

        System.out.println(drop.value.neoPositionX + " , " + drop.value.neoPositionY);

    }

    public static void main(String[] args) throws Exception {
        // for (int i = 0; i < 10; i++) {
        // String grid = genGrid();
        String grid = "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        solve(grid, "BFS", false);

        // }
    }
}
