package code;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Matrix {
    public static String[] actions = { "up", "down", "left", "right", "carry", "drop", "takePill", "kill", "fly" };
    //public static String[] actions = { "fly", "kill", "takePill", "drop", "carry", "right", "left", "down", "up" };
    // public static Queue<MyTreeNode<String>> queue;

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

    public static Pair<Boolean, MyTreeNode<String>, String> upFunc(MyTreeNode<String> currentNode,
            MyTreeNode<String> parent) {

        boolean left = false;
        matrixValue currentMatrix = new matrixValue(currentNode.value);
        if ((parent != null && parent.action != "down") || parent == null) {

            if (currentMatrix.neoPositionX - 1 >= 0) {

                left = true;
                for (int i = 0; i < currentMatrix.agentsX.length; i++) {
                    if (currentMatrix.agentsX[i] == currentMatrix.neoPositionX - 1
                            && currentMatrix.agentsY[i] == currentMatrix.neoPositionY && !currentMatrix.agentDead[i]) {
                        left = false;
                    }
                }
                for (int i = 0; i < currentMatrix.hostageAgent.length; i++) {
                    if (currentMatrix.hostageAgent[i]) {
                        if (currentMatrix.hostagesX[i] == currentMatrix.neoPositionX - 1
                                && currentMatrix.hostagesY[i] == currentMatrix.neoPositionY
                                && !currentMatrix.hostageAgentKilled[i]) {
                            left = false;
                        }

                    }
                }
                if (left) {
                    currentMatrix.neoPositionX -= 1;
                    int[] hostagesXTemp = new int[currentMatrix.hostagesX.length];
                    for (int i = 0; i < hostagesXTemp.length; i++) {
                        hostagesXTemp[i] = currentMatrix.hostagesX[i];
                    }
                    for (int i = 0; i < currentMatrix.hostagesCarried.length; i++) {
                        if (currentMatrix.hostagesCarried[i]) {
                            // currentMatrix.hostagesX[i] -= 1;
                            hostagesXTemp[i] = currentMatrix.neoPositionX;
                        }
                    }
                    currentMatrix.hostagesX = new int[hostagesXTemp.length];
                    for (int i = 0; i < hostagesXTemp.length; i++) {
                        currentMatrix.hostagesX[i] = hostagesXTemp[i];
                    }
                }
            }
        }
        currentNode.value = currentMatrix.hashValue();

        Pair<Boolean, MyTreeNode<String>, String> balabezo = new Pair<Boolean, MyTreeNode<String>, String>(left,
                currentNode, currentMatrix.hashValueNodmg());
        return balabezo;

    }

    public static Pair<Boolean, MyTreeNode<String>, String> downFunc(MyTreeNode<String> currentNode,
            MyTreeNode<String> parent) {

        boolean right = false;
        matrixValue currentMatrix = new matrixValue(currentNode.value);

        if ((parent != null && parent.action != "up") || parent == null) {

            if (currentMatrix.neoPositionX + 1 < currentMatrix.gridSizeX) {
                right = true;

                for (int i = 0; i < currentMatrix.agentsX.length; i++) {
                    if (currentMatrix.agentsX[i] == currentMatrix.neoPositionX + 1
                            && currentMatrix.agentsY[i] == currentMatrix.neoPositionY && !currentMatrix.agentDead[i]) {
                        right = false;
                    }
                }
                for (int i = 0; i < currentMatrix.hostageAgent.length; i++) {
                    if (currentMatrix.hostageAgent[i]) {
                        if (currentMatrix.hostagesX[i] == currentMatrix.neoPositionX + 1
                                && currentMatrix.hostagesY[i] == currentMatrix.neoPositionY
                                && !currentMatrix.hostageAgentKilled[i]) {
                            right = false;
                        }

                    }
                }
                if (right) {
                    currentMatrix.neoPositionX += 1;
                    int[] hostagesXTemp = new int[currentMatrix.hostagesX.length];
                    for (int i = 0; i < hostagesXTemp.length; i++) {
                        hostagesXTemp[i] = currentMatrix.hostagesX[i];
                    }
                    for (int i = 0; i < currentMatrix.hostagesCarried.length; i++) {
                        if (currentMatrix.hostagesCarried[i]) {
                            // currentMatrix.hostagesX[i] += 1;
                            hostagesXTemp[i] = currentMatrix.neoPositionX;
                        }
                    }
                    currentMatrix.hostagesX = new int[hostagesXTemp.length];
                    for (int i = 0; i < hostagesXTemp.length; i++) {
                        currentMatrix.hostagesX[i] = hostagesXTemp[i];
                    }

                    // for (int i = 0; i < 9; i++) {
                    // MyTreeNode<String> temp = new MyTreeNode<String>(currentMatrix,
                    // actions[i]);
                    // currentNode.addChild(temp,parent);
                    // queue.add(temp,parent);
                    // }

                }
            }
        }
        currentNode.value = currentMatrix.hashValue();

        Pair<Boolean, MyTreeNode<String>, String> balabezo = new Pair<Boolean, MyTreeNode<String>, String>(right,
                currentNode, currentMatrix.hashValueNodmg());
        return balabezo;
    }

    public static Pair<Boolean, MyTreeNode<String>, String> rightFunc(MyTreeNode<String> currentNode,
            MyTreeNode<String> parent) {

        boolean up = false;
        matrixValue currentMatrix = new matrixValue(currentNode.value);

        if ((parent != null && parent.action != "left") || parent == null) {

            if (currentMatrix.neoPositionY + 1 < currentMatrix.gridSizeY) {
                up = true;
                for (int i = 0; i < currentMatrix.agentsX.length; i++) {
                    if (currentMatrix.agentsX[i] == currentMatrix.neoPositionX
                            && currentMatrix.agentsY[i] == currentMatrix.neoPositionY + 1
                            && !currentMatrix.agentDead[i]) {
                        up = false;
                    }
                }
                for (int i = 0; i < currentMatrix.hostageAgent.length; i++) {
                    if (currentMatrix.hostageAgent[i]) {
                        if (currentMatrix.hostagesX[i] == currentMatrix.neoPositionX
                                && currentMatrix.hostagesY[i] == currentMatrix.neoPositionY + 1
                                && !currentMatrix.hostageAgentKilled[i])
                            up = false;
                    }

                }
            }
            if (up) {
                currentMatrix.neoPositionY += 1;
                int[] hostagesYTemp = new int[currentMatrix.hostagesY.length];
                for (int i = 0; i < hostagesYTemp.length; i++) {
                    hostagesYTemp[i] = currentMatrix.hostagesY[i];
                }
                for (int i = 0; i < currentMatrix.hostagesCarried.length; i++) {
                    if (currentMatrix.hostagesCarried[i]) {
                        // currentMatrix.hostagesY[i] += 1;
                        hostagesYTemp[i] = currentMatrix.neoPositionY;
                    }
                }
                currentMatrix.hostagesY = new int[hostagesYTemp.length];
                for (int i = 0; i < hostagesYTemp.length; i++) {
                    currentMatrix.hostagesY[i] = hostagesYTemp[i];
                }

            }
        }
        currentNode.value = currentMatrix.hashValue();

        Pair<Boolean, MyTreeNode<String>, String> balabezo = new Pair<Boolean, MyTreeNode<String>, String>(up,
                currentNode, currentMatrix.hashValueNodmg());
        return balabezo;
    }

    public static Pair<Boolean, MyTreeNode<String>, String> leftFunc(MyTreeNode<String> currentNode,
            MyTreeNode<String> parent) {

        boolean down = false;
        matrixValue currentMatrix = new matrixValue(currentNode.value);

        if ((parent != null && parent.action != "right") || parent == null) {
            // if (parent != null)
            // System.out.println(parent.action);
            // else
            // System.out.println("null");
            if (currentMatrix.neoPositionY - 1 >= 0) {

                down = true;
                for (int i = 0; i < currentMatrix.agentsX.length; i++) {
                    if (currentMatrix.agentsX[i] == currentMatrix.neoPositionX
                            && currentMatrix.agentsY[i] == currentMatrix.neoPositionY - 1
                            && !currentMatrix.agentDead[i]) {
                        down = false;
                    }
                }
                for (int i = 0; i < currentMatrix.hostageAgent.length; i++) {
                    if (currentMatrix.hostageAgent[i]) {
                        if (currentMatrix.hostagesX[i] == currentMatrix.neoPositionX
                                && currentMatrix.hostagesY[i] == currentMatrix.neoPositionY - 1
                                && !currentMatrix.hostageAgentKilled[i]) {
                            down = false;
                        }

                    }
                }
                if (down) {
                    currentMatrix.neoPositionY -= 1;
                    int[] hostagesYTemp = new int[currentMatrix.hostagesY.length];
                    for (int i = 0; i < hostagesYTemp.length; i++) {
                        hostagesYTemp[i] = currentMatrix.hostagesY[i];
                    }
                    for (int i = 0; i < currentMatrix.hostagesCarried.length; i++) {
                        if (currentMatrix.hostagesCarried[i]) {
                            // currentMatrix.hostagesY[i] -= 1;
                            hostagesYTemp[i] = currentMatrix.neoPositionY;
                        }
                    }
                    currentMatrix.hostagesY = new int[hostagesYTemp.length];
                    for (int i = 0; i < hostagesYTemp.length; i++) {
                        currentMatrix.hostagesY[i] = hostagesYTemp[i];
                    }

                    // for (int i = 0; i < 9; i++) {
                    // MyTreeNode<String> temp = new MyTreeNode<String>(currentMatrix,
                    // actions[i]);
                    // currentNode.addChild(temp,parent);
                    // queue.add(temp,parent);
                    // }
                }
            }
        }
        currentNode.value = currentMatrix.hashValue();

        Pair<Boolean, MyTreeNode<String>, String> balabezo = new Pair<Boolean, MyTreeNode<String>, String>(down,
                currentNode, currentMatrix.hashValueNodmg());
        return balabezo;
    }

    public static Pair<Boolean, MyTreeNode<String>, String> dropFunc(MyTreeNode<String> currentNode,
            MyTreeNode<String> parent) {

        boolean action = false;
        matrixValue currentMatrix = new matrixValue(currentNode.value);

        boolean[] hostagesCarriedTemp = new boolean[currentMatrix.hostagesCarried.length];
        for (int i = 0; i < hostagesCarriedTemp.length; i++) {
            hostagesCarriedTemp[i] = currentMatrix.hostagesCarried[i];
        }
        // If the hostage returned to the telehpone booth, drop all hostages that neo is carrying
        for (int i = 0; i < currentMatrix.hostagesX.length; i++) {
            if (hostagesCarriedTemp[i]) {
                if (currentMatrix.neoPositionX == currentMatrix.telephoneX
                        && currentMatrix.neoPositionY == currentMatrix.telephoneY) {
                    // currentMatrix.hostagesCarried[i] = false;
                    hostagesCarriedTemp[i] = false;
                    currentMatrix.carryCount--;
                    currentMatrix.currentHostages--;
                    // System.out.println("drop");
                    action = true;
                }
            }

        }
        currentMatrix.hostagesCarried = new boolean[hostagesCarriedTemp.length];
        for (int i = 0; i < hostagesCarriedTemp.length; i++) {
            currentMatrix.hostagesCarried[i] = hostagesCarriedTemp[i];
        }
        currentNode.value = currentMatrix.hashValue();

        Pair<Boolean, MyTreeNode<String>, String> balabezo = new Pair<Boolean, MyTreeNode<String>, String>(action,
                currentNode, currentMatrix.hashValueNodmg());
        return balabezo;
    }

    public static Pair<Boolean, MyTreeNode<String>, String> carryFunc(MyTreeNode<String> currentNode,
            MyTreeNode<String> parent) {

        boolean action = false;
        matrixValue currentMatrix = new matrixValue(currentNode.value);

        boolean[] hostagesCarriedTemp = new boolean[currentMatrix.hostagesCarried.length];
        for (int i = 0; i < hostagesCarriedTemp.length; i++) {
            hostagesCarriedTemp[i] = currentMatrix.hostagesCarried[i];
        }
        for (int i = 0; i < currentMatrix.hostagesX.length; i++) {
            if (currentMatrix.neoPositionX == currentMatrix.hostagesX[i]
                    && currentMatrix.neoPositionY == currentMatrix.hostagesY[i]
                    && currentMatrix.carryCount < currentMatrix.cap && !hostagesCarriedTemp[i]
                    && !currentMatrix.hostageAgent[i] && !currentMatrix.hostageAgentKilled[i]
                    && currentMatrix.hostagesX[i] != currentMatrix.telephoneX
                    && currentMatrix.hostagesY[i] != currentMatrix.telephoneY) {
                hostagesCarriedTemp[i] = true;
                currentMatrix.carryCount++;
                action = true;
            }
        }
        currentMatrix.hostagesCarried = new boolean[hostagesCarriedTemp.length];
        for (int i = 0; i < hostagesCarriedTemp.length; i++) {
            currentMatrix.hostagesCarried[i] = hostagesCarriedTemp[i];
        }
        currentNode.value = currentMatrix.hashValue();

        Pair<Boolean, MyTreeNode<String>, String> balabezo = new Pair<Boolean, MyTreeNode<String>, String>(action,
                currentNode, currentMatrix.hashValueNodmg());
        return balabezo;
    }

    public static Pair<Boolean, MyTreeNode<String>, String> takepillFunc(MyTreeNode<String> currentNode,
            MyTreeNode<String> parent) {

        boolean action = false;
        matrixValue currentMatrix = new matrixValue(currentNode.value);

        boolean[] pillTakenTemp = new boolean[currentMatrix.pillTaken.length];
        for (int i = 0; i < pillTakenTemp.length; i++) {
            pillTakenTemp[i] = currentMatrix.pillTaken[i];
        }
        int[] hostageDmgTmp = new int[currentMatrix.hostagesDmg.length];
        for (int i = 0; i < hostageDmgTmp.length; i++) {
            hostageDmgTmp[i] = currentMatrix.hostagesDmg[i];
        }
        for (int i = 0; i < currentMatrix.pillsX.length; i++) {
            if (currentMatrix.neoPositionX == currentMatrix.pillsX[i]
                    && currentMatrix.neoPositionY == currentMatrix.pillsY[i] && !currentMatrix.pillTaken[i]) {
                        // && currentMatrix.hostagesDmg[i] != 100
                currentMatrix.neoDmg -= 20;
                action = true;
                pillTakenTemp[i] = true;
                // currentMatrix.pillTaken[i] = true;
                for (int j = 0; j < currentMatrix.hostagesX.length; j++) {
                    if (!currentMatrix.hostageAgent[j] && !currentMatrix.hostageAgentKilled[j]) {
                        if (currentMatrix.hostagesDmg[j] != 100) {
                            // currentMatrix.hostagesDmg[j] -= 20;
                            hostageDmgTmp[j] -= 20;
                            if (currentMatrix.hostagesDmg[j] < 0) {
                                // currentMatrix.hostagesDmg[j] = 0;
                                hostageDmgTmp[j] = 0;
                            }
                        }
                    }
                }
            }
        }
        currentMatrix.pillTaken = new boolean[pillTakenTemp.length];
        for (int i = 0; i < pillTakenTemp.length; i++) {
            currentMatrix.pillTaken[i] = pillTakenTemp[i];
        }
        if (action) {
            for (int i = 0; i < currentMatrix.hostagesDmg.length; i++) {
                if (currentMatrix.hostagesDmg[i] < 100) {
                    // currentMatrix.hostagesDmg[i] -= 2;
                    hostageDmgTmp[i] -= 2;
                    if (currentMatrix.hostagesDmg[i] < 0) {
                        // currentMatrix.hostagesDmg[i] = 0;
                        hostageDmgTmp[i] = 0;
                    }

                }

            }
            currentMatrix.hostagesDmg = new int[hostageDmgTmp.length];
            for (int i = 0; i < hostageDmgTmp.length; i++) {
                currentMatrix.hostagesDmg[i] = hostageDmgTmp[i];
            }
        }
        currentNode.value = currentMatrix.hashValue();

        Pair<Boolean, MyTreeNode<String>, String> balabezo = new Pair<Boolean, MyTreeNode<String>, String>(action,
                currentNode, currentMatrix.hashValueNodmg());
        return balabezo;
    }

    public static Pair<Boolean, MyTreeNode<String>, String> killFunc(MyTreeNode<String> currentNode,
            MyTreeNode<String> parent) {
        matrixValue currentMatrix = new matrixValue(currentNode.value);
        int x = currentMatrix.neoPositionX;
        int y = currentMatrix.neoPositionY;
        boolean action = false;
        // Agent dead temp, so as not to reference an array
        boolean[] agentDeadTemp = new boolean[currentMatrix.agentDead.length];
        for (int i = 0; i < agentDeadTemp.length; i++) {
            agentDeadTemp[i] = currentMatrix.agentDead[i];
        }
        ///////
        boolean[] hostageAgentTemp = new boolean[currentMatrix.hostageAgent.length];
        for (int i = 0; i < hostageAgentTemp.length; i++) {
            hostageAgentTemp[i] = currentMatrix.hostageAgent[i];
        }
        //////
        boolean[] hostageAgentKilledTemp = new boolean[currentMatrix.hostageAgentKilled.length];
        for (int i = 0; i < hostageAgentKilledTemp.length; i++) {
            hostageAgentKilledTemp[i] = currentMatrix.hostageAgentKilled[i];
        }
        /////
        boolean noAction = false;
        for (int i = 0; i < currentMatrix.hostagesX.length; i++) {
            if (currentMatrix.hostagesX[i] == currentMatrix.neoPositionX
                    && currentMatrix.hostagesY[i] == currentMatrix.neoPositionY && currentMatrix.hostagesDmg[i] > 97) {
                noAction = true;

            }

        }
        if (!noAction) {
            for (int i = 0; i < currentMatrix.agentsX.length; i++) {
                if (x == currentMatrix.agentsX[i] - 1 && y == currentMatrix.agentsY[i] && !currentMatrix.agentDead[i]) {
                    // currentMatrix.agentDead[i] = true;
                    agentDeadTemp[i] = true;
                    action = true;
                }
                if (x == currentMatrix.agentsX[i] + 1 && y == currentMatrix.agentsY[i] && !currentMatrix.agentDead[i]) {
                    // currentMatrix.agentDead[i] = true;
                    agentDeadTemp[i] = true;
                    action = true;
                }
                if (x == currentMatrix.agentsX[i] && y == currentMatrix.agentsY[i] - 1 && !currentMatrix.agentDead[i]) {
                    // currentMatrix.agentDead[i] = true;
                    agentDeadTemp[i] = true;
                    action = true;
                }
                if (x == currentMatrix.agentsX[i] && y == currentMatrix.agentsY[i] + 1 && !currentMatrix.agentDead[i]) {
                    // currentMatrix.agentDead[i] = true;
                    agentDeadTemp[i] = true;
                    action = true;
                }
            }
            for (int i = 0; i < currentMatrix.hostageAgent.length; i++) {
                if (currentMatrix.hostageAgent[i] == true && !currentMatrix.hostageAgentKilled[i]) {
                    if (x == currentMatrix.hostagesX[i] - 1 && y == currentMatrix.hostagesY[i]) {
                        // currentMatrix.hostageAgent[i] = false;
                        // currentMatrix.hostageAgentKilled[i] = true;
                        hostageAgentTemp[i] = false;
                        hostageAgentKilledTemp[i] = true;
                        currentMatrix.currentHostages--;
                        action = true;
                    } else if (x == currentMatrix.hostagesX[i] + 1 && y == currentMatrix.hostagesY[i]) {
                        // currentMatrix.hostageAgent[i] = false;
                        currentMatrix.currentHostages--;
                        // currentMatrix.hostageAgentKilled[i] = true;
                        hostageAgentTemp[i] = false;
                        hostageAgentKilledTemp[i] = true;
                        action = true;
                    } else if (x == currentMatrix.hostagesX[i] && y == currentMatrix.hostagesY[i] - 1) {
                        // currentMatrix.hostageAgent[i] = false;
                        // currentMatrix.hostageAgentKilled[i] = true;
                        hostageAgentTemp[i] = false;
                        hostageAgentKilledTemp[i] = true;
                        currentMatrix.currentHostages--;
                        action = true;
                    } else if (x == currentMatrix.hostagesX[i] && y == currentMatrix.hostagesY[i] + 1) {
                        // currentMatrix.hostageAgent[i] = false;
                        // currentMatrix.hostageAgentKilled[i] = true;
                        hostageAgentTemp[i] = false;
                        hostageAgentKilledTemp[i] = true;
                        currentMatrix.currentHostages--;
                        action = true;
                    }
                }

            }
            currentMatrix.agentDead = new boolean[agentDeadTemp.length];
            for (int i = 0; i < agentDeadTemp.length; i++) {
                currentMatrix.agentDead[i] = agentDeadTemp[i];
            }
            currentMatrix.hostageAgent = new boolean[hostageAgentTemp.length];
            for (int i = 0; i < hostageAgentTemp.length; i++) {
                currentMatrix.hostageAgent[i] = hostageAgentTemp[i];
            }
            currentMatrix.hostageAgentKilled = new boolean[hostageAgentKilledTemp.length];
            for (int i = 0; i < hostageAgentKilledTemp.length; i++) {
                currentMatrix.hostageAgentKilled[i] = hostageAgentKilledTemp[i];
            }
            if (action) {
                currentMatrix.neoDmg += 20;
            }
        }
        currentNode.value = currentMatrix.hashValue();

        Pair<Boolean, MyTreeNode<String>, String> balabezo = new Pair<Boolean, MyTreeNode<String>, String>(action,
                currentNode, currentMatrix.hashValueNodmg());
        return balabezo;
    }

    public static Pair<Boolean, MyTreeNode<String>, String> flyFunc(MyTreeNode<String> currentNode,
            MyTreeNode<String> parent) {
        matrixValue currentMatrix = new matrixValue(currentNode.value);
        boolean action = false;
        for (int i = 0; i < currentMatrix.padsX.length; i += 2) {

            if (currentMatrix.neoPositionX == currentMatrix.padsX[i]
                    && currentMatrix.neoPositionY == currentMatrix.padsY[i] && !action) {

                if ((parent != null && parent.action != "fly") || parent.action == null) {
                    currentMatrix.neoPositionX = currentMatrix.padsX[i + 1];
                    currentMatrix.neoPositionY = currentMatrix.padsY[i + 1];
                    action = true;
                }
                if (action) {
                    int[] hostagesYTemp = new int[currentMatrix.hostagesY.length];
                    int[] hostagesXTemp = new int[currentMatrix.hostagesX.length];
                    for (int j = 0; j < hostagesYTemp.length; j++) {
                        hostagesXTemp[j] = currentMatrix.hostagesX[j];
                        hostagesYTemp[j] = currentMatrix.hostagesY[j];
                        if (currentMatrix.hostagesCarried[j]) {
                            hostagesXTemp[j] = currentMatrix.neoPositionX;
                            hostagesYTemp[j] = currentMatrix.neoPositionY;
                        }

                    }
                    currentMatrix.hostagesY = new int[hostagesYTemp.length];
                    currentMatrix.hostagesX = new int[hostagesXTemp.length];

                    for (int j = 0; j < hostagesYTemp.length; j++) {
                        currentMatrix.hostagesY[j] = hostagesYTemp[j];
                        currentMatrix.hostagesX[j] = hostagesXTemp[j];

                    }

                }

            }
        }
        currentNode.value = currentMatrix.hashValue();

        Pair<Boolean, MyTreeNode<String>, String> balabezo = new Pair<Boolean, MyTreeNode<String>, String>(action,
                currentNode, currentMatrix.hashValueNodmg());
        return balabezo;

    }

    public static String bfs(Queue<MyTreeNode<String>> queue) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        HashSet<String> hash = new HashSet<>();
        String currentString = queue.peek().value;
        matrixValue matrixValue = new matrixValue(currentString);
        MyTreeNode<String> currentNode = queue.peek();
        hash.add(matrixValue.hashValueNodmg() + currentNode.action);
        boolean loopCheck=true;
        do {
            counter++;
            currentNode = queue.remove();
            matrixValue = new matrixValue(currentNode.value);

            if (matrixValue.neoDmg < 100) {
                int[] tempDmg = new int[matrixValue.hostagesDmg.length];
                boolean[] agentTemp = new boolean[matrixValue.hostageAgent.length];
                for (int i = 0; i < tempDmg.length; i++) {
                    tempDmg[i] = matrixValue.hostagesDmg[i];
                    agentTemp[i] = matrixValue.hostageAgent[i];
                }
                for (int i = 0; i < matrixValue.hostagesDmg.length; i++) {
                    if (!(matrixValue.hostagesX[i] == matrixValue.telephoneX
                            && matrixValue.hostagesY[i] == matrixValue.telephoneY)) {
                        tempDmg[i] += 2;
                        if (tempDmg[i] >= 100) {
                            tempDmg[i] = 100;
                            if (matrixValue.hostagesCarried[i] == false
                                    && matrixValue.hostagesX[i] != matrixValue.telephoneX
                                    && matrixValue.hostagesY[i] != matrixValue.telephoneY
                                    && !matrixValue.hostageAgentKilled[i]) {
                                agentTemp[i] = true;
                            }
                            if (matrixValue.hostagesX[i] == matrixValue.telephoneX
                                    && matrixValue.hostagesY[i] == matrixValue.telephoneY) {
                                agentTemp[i] = false;
                            }
                            if (matrixValue.hostagesCarried[i] == true) {
                                agentTemp[i] = false;
                            }
                        }
                    }
                }
                matrixValue.hostagesDmg = new int[tempDmg.length];
                matrixValue.hostageAgent = new boolean[agentTemp.length];
                for (int i = 0; i < tempDmg.length; i++) {
                    matrixValue.hostagesDmg[i] = tempDmg[i];
                    matrixValue.hostageAgent[i] = agentTemp[i];

                }
                MyTreeNode<String> parent = null;
                if (currentNode.getParent() != null) {
                    parent = new MyTreeNode<String>(currentNode.value, currentNode.action);

                }

                for (int i = 0; i < 9; i++) {
                    matrixValue tempMatrix = matrixValue.clone();
                    MyTreeNode<String> temp = new MyTreeNode<String>((tempMatrix.hashValue()), actions[i]);
                    switch (temp.action) {
                        case "up":
                            Pair<Boolean, MyTreeNode<String>, String> outPair = upFunc(temp, parent);
                            if (outPair.a && !hash.contains(outPair.c + temp.action)) {
                                hash.add(outPair.c + temp.action);
                                currentNode.addChild(outPair.b);
                                queue.add(outPair.b);
                            }
                            break;
                        case "down":
                            Pair<Boolean, MyTreeNode<String>, String> outPair2 = downFunc(temp, parent);
                            if (outPair2.a && !hash.contains(outPair2.c + temp.action)) {
                                hash.add(outPair2.c + temp.action);
                                currentNode.addChild(outPair2.b);
                                queue.add(outPair2.b);
                            }
                            break;
                        case "left":
                            Pair<Boolean, MyTreeNode<String>, String> outPair3 = leftFunc(temp, parent);
                            if (outPair3.a && !hash.contains(outPair3.c + temp.action)) {
                                hash.add(outPair3.c + temp.action);
                                currentNode.addChild(outPair3.b);
                                queue.add(outPair3.b);
                            }
                            break;
                        case "right":
                            Pair<Boolean, MyTreeNode<String>, String> outPair4 = rightFunc(temp, parent);
                            if (outPair4.a && !hash.contains(outPair4.c + temp.action)) {
                                hash.add(outPair4.c + temp.action);
                                currentNode.addChild(outPair4.b);
                                queue.add(outPair4.b);
                            }
                            break;
                        case "carry":
                            Pair<Boolean, MyTreeNode<String>, String> outPair5 = carryFunc(temp, parent);
                            if (outPair5.a && !hash.contains(outPair5.c + temp.action)) {
                                hash.add(outPair5.c + temp.action);
                                currentNode.addChild(outPair5.b);
                                queue.add(outPair5.b);
                            }
                            break;
                        case "drop":
                            Pair<Boolean, MyTreeNode<String>, String> outPair6 = dropFunc(temp, parent);
                            if (outPair6.a && !hash.contains(outPair6.c + temp.action)) {
                                hash.add(outPair6.c + temp.action);
                                currentNode.addChild(outPair6.b);
                                queue.add(outPair6.b);

                            }
                            break;
                        case "takePill":
                            Pair<Boolean, MyTreeNode<String>, String> outPair7 = takepillFunc(temp, parent);
                            if (outPair7.a && !hash.contains(outPair7.c + temp.action)) {
                                hash.add(outPair7.c + temp.action);
                                currentNode.addChild(outPair7.b);
                                queue.add(outPair7.b);

                            }
                            break;
                        case "kill":
                            Pair<Boolean, MyTreeNode<String>, String> outPair8 = killFunc(temp, parent);
                            if (outPair8.a && !hash.contains(outPair8.c + temp.action)) {
                                hash.add(outPair8.c + temp.action);
                                currentNode.addChild(outPair8.b);
                                queue.add(outPair8.b);
                            }
                            break;
                        case "fly":
                            Pair<Boolean, MyTreeNode<String>, String> outPair9 = flyFunc(temp, parent);
                            if (outPair9.a && !hash.contains(outPair9.c + temp.action)) {
                                hash.add(outPair9.c + temp.action);
                                currentNode.addChild(outPair9.b);
                                queue.add(outPair9.b);
                            }
                            break;

                        default:
                            break;
                    }
                }
            }
            if(matrixValue.currentHostages == 0 ){
                if(matrixValue.neoPositionX==matrixValue.telephoneX && matrixValue.neoPositionY==matrixValue.telephoneY){
                    loopCheck=false;
                }
            }
        } while (loopCheck);
        // }
        String output = "";
        int hostageDead = 0;
        int agentDead = 0;
        for (int dmg : matrixValue.hostagesDmg) {
            if (dmg == 100) {
                hostageDead++;
            }
        }
        for (boolean dmg : matrixValue.agentDead) {
            if (dmg) {
                agentDead++;
            }
        }
        for (boolean dmg : matrixValue.hostageAgentKilled) {
            if (dmg) {
                agentDead++;
            }
        }

        // for (MyTreeNode<String> child : currentNode.getChildren()) {
        // System.out.println(child.action);

        // }
        while (currentNode.action != "root") {
            output = "," + currentNode.action + output;
            // System.out.println(currentNode.action);
            matrixValue tempmat = new matrixValue(currentNode.value);
            for (int dmg : tempmat.hostagesDmg) {
                System.out.print(dmg + ",");

            }
            System.out.println(tempmat.currentHostages);
            for (int x : tempmat.hostagesX) {
                System.out.print(x);
            }
            System.out.println("");
            for (int y : tempmat.hostagesY) {
                System.out.print(y);
            }
            System.out.println("");
            // if (currentNode.action == "drop") {
            System.out.println(tempmat.neoPositionX + " , " + tempmat.neoPositionY);
            // }

            currentNode = (MyTreeNode<String>) currentNode.getParent();
        }
        output += ";" + hostageDead + ";" + agentDead + ";" + counter;
        output = output.substring(1);
        return output;
    }

    public static String dfs(Queue<MyTreeNode<String>> queueold) throws InterruptedException {
        int counter = 0;
        HashSet<String> hash = new HashSet<>();
        String currentString = queueold.peek().value;
        matrixValue currentMatrix = new matrixValue(currentString);
        hash.add(currentMatrix.hashValueNodmg());
        LinkedList<MyTreeNode<String>> queue = new LinkedList<>();
        queue.addFirst(queueold.remove());
        boolean loopCheck=true;
        MyTreeNode<String> currentNode = queue.peek();
        do {
            counter++;
            currentNode = queue.remove();
            currentString = currentNode.value;

            currentMatrix = new matrixValue(currentString);

            if (currentMatrix.neoDmg < 100) {
                int[] tempDmg = new int[currentMatrix.hostagesDmg.length];
                boolean[] agentTemp = new boolean[currentMatrix.hostageAgent.length];
                for (int i = 0; i < tempDmg.length; i++) {
                    tempDmg[i] = currentMatrix.hostagesDmg[i];
                    agentTemp[i] = currentMatrix.hostageAgent[i];
                }
                for (int i = 0; i < currentMatrix.hostagesDmg.length; i++) {
                    tempDmg[i] += 2;
                    if (tempDmg[i] >= 100) {
                        tempDmg[i] = 100;
                        if (currentMatrix.hostagesCarried[i] == false
                                && currentMatrix.hostagesX[i] != currentMatrix.telephoneX
                                && currentMatrix.hostagesY[i] != currentMatrix.telephoneY
                                && !currentMatrix.hostageAgentKilled[i]) {
                            agentTemp[i] = true;
                        }
                    }

                }
                currentMatrix.hostagesDmg = new int[tempDmg.length];
                currentMatrix.hostageAgent = new boolean[agentTemp.length];
                for (int i = 0; i < tempDmg.length; i++) {
                    currentMatrix.hostagesDmg[i] = tempDmg[i];
                    currentMatrix.hostageAgent[i] = agentTemp[i];

                }
                MyTreeNode<String> parent = currentNode;
                for (int i = 0; i < 9; i++) {
                    matrixValue tempMatrix = currentMatrix.clone();
                    MyTreeNode<String> temp = new MyTreeNode<String>((tempMatrix.hashValue()), actions[i]);
                    // temp.setParent(parent);
                    switch (temp.action) {
                        case "up":
                            Pair<Boolean, MyTreeNode<String>, String> outPair = upFunc(temp, parent);
                            if (outPair.a && !hash.contains(outPair.c + temp.action)) {
                                hash.add(outPair.c + temp.action);
                                currentNode.addChild(outPair.b);
                                queue.addFirst(outPair.b);
                            }
                            break;
                        case "down":
                            Pair<Boolean, MyTreeNode<String>, String> outPair2 = downFunc(temp, parent);
                            if (outPair2.a && !hash.contains(outPair2.c + temp.action)) {
                                hash.add(outPair2.c + temp.action);
                                currentNode.addChild(outPair2.b);
                                queue.addFirst(outPair2.b);
                            }
                            break;
                        case "left":
                            Pair<Boolean, MyTreeNode<String>, String> outPair3 = leftFunc(temp, parent);
                            if (outPair3.a && !hash.contains(outPair3.c + temp.action)) {
                                hash.add(outPair3.c + temp.action);
                                currentNode.addChild(outPair3.b);
                                queue.addFirst(outPair3.b);
                            }
                            break;
                        case "right":
                            Pair<Boolean, MyTreeNode<String>, String> outPair4 = rightFunc(temp, parent);
                            if (outPair4.a && !hash.contains(outPair4.c + temp.action)) {
                                hash.add(outPair4.c + temp.action);
                                currentNode.addChild(outPair4.b);
                                queue.addFirst(outPair4.b);
                            }
                            break;
                        case "carry":
                            Pair<Boolean, MyTreeNode<String>, String> outPair5 = carryFunc(temp, parent);
                            if (outPair5.a && !hash.contains(outPair5.c + temp.action)) {
                                hash.add(outPair5.c + temp.action);
                                currentNode.addChild(outPair5.b);
                                queue.addFirst(outPair5.b);
                            }
                            break;
                        case "drop":
                            Pair<Boolean, MyTreeNode<String>, String> outPair6 = dropFunc(temp, parent);
                            if (outPair6.a && !hash.contains(outPair6.c + temp.action)) {
                                hash.add(outPair6.c + temp.action);
                                currentNode.addChild(outPair6.b);
                                queue.addFirst(outPair6.b);

                            }
                            break;
                        case "takePill":
                            Pair<Boolean, MyTreeNode<String>, String> outPair7 = takepillFunc(temp, parent);
                            if (outPair7.a && !hash.contains(outPair7.c + temp.action)) {
                                hash.add(outPair7.c + temp.action);
                                currentNode.addChild(outPair7.b);
                                queue.addFirst(outPair7.b);

                            }
                            break;
                        case "kill":
                            Pair<Boolean, MyTreeNode<String>, String> outPair8 = killFunc(temp, parent);
                            if (outPair8.a && !hash.contains(outPair8.c + temp.action)) {
                                hash.add(outPair8.c + temp.action);
                                currentNode.addChild(outPair8.b);
                                queue.addFirst(outPair8.b);
                            }
                            break;
                        case "fly":
                            Pair<Boolean, MyTreeNode<String>, String> outPair9 = flyFunc(temp, parent);
                            if (outPair9.a && !hash.contains(outPair9.c + temp.action)) {
                                hash.add(outPair9.c + temp.action);
                                currentNode.addChild(outPair9.b);
                                queue.addFirst(outPair9.b);
                            }
                            break;

                        default:
                            break;
                    }
                }
            }
            if(currentMatrix.currentHostages == 0 ){
                if(currentMatrix.neoPositionX==currentMatrix.telephoneX && currentMatrix.neoPositionY==currentMatrix.telephoneY){
                    loopCheck=false;
                }
            }
        } while (loopCheck);
        // }
        String output = "";
        int hostageDead = 0;
        int agentDead = 0;
        for (int dmg : currentMatrix.hostagesDmg) {
            if (dmg == 100) {
                hostageDead++;
            }
        }
        for (boolean dmg : currentMatrix.agentDead) {
            if (dmg) {
                agentDead++;
            }
        }
        for (boolean dmg : currentMatrix.hostageAgentKilled) {
            if (dmg) {
                agentDead++;
            }
        }

        while (currentNode.action != "root") {
            output = "," + currentNode.action + output;
            // System.out.println(currentNode.action);
            currentNode = (MyTreeNode<String>) currentNode.getParent();
        }
        output += ";" + hostageDead + ";" + agentDead + ";" + counter;
        output = output.substring(1);
        return output;
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
        MyTreeNode<String> tree = new MyTreeNode<String>(root.hashValue(), "root");
        // System.out.println(root.hashValue());
        Queue<MyTreeNode<String>> queue = new ArrayDeque<>();
        queue.add(tree);
        // solvetest(tree);
        // String output = dfs(queue);
        switch (strategy) {
            case "BF":
                return bfs(queue);

            case "DF":
                return dfs(queue);

        }
        return "";

    }

    public static void main(String[] args) throws Exception {
        // for (int i = 0; i < 10; i++) {
        // String grid = genGrid();
        String grid = "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String grid1 = "5,5;1;1,4;1,0;0,4;0,0,2,2;3,4,4,2,4,2,3,4;0,2,32,0,1,38";
        String grid3 = "6,6;2;2,4;2,2;0,4,1,4,3,0,4,2;0,1,1,3;4,4,3,1,3,1,4,4;0,0,94,1,2,38,4,1,76,4,0,80";
        String grid5 = "5,5;2;0,4;3,4;3,1,1,1;2,3;3,0,0,1,0,1,3,0;4,2,54,4,0,85,1,0,43";
        String grid0 = "5,5;2;3,4;1,2;0,3,1,4;2,3;4,4,0,2,0,2,4,4;2,2,91,2,4,62";
        String grid9 = "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";


        // solve(grid1, "BFS", false);
        // System.out.println("hi");
        String out = solve(grid1, "DF", false);
        System.out.println(out);

        // }
    }
}
