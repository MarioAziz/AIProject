import java.util.*;

public class App {
    public static String[] actions = { "up", "down", "left", "right", "carry", "drop", "takePill", "kill", "fly" };
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

    public static Pair upFunc(MyTreeNode<matrixValue> currentNode) {
        for (int i = 0; i < currentNode.value.hostagesDmg.length; i++) {
            currentNode.value.hostagesDmg[i] += 2;
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
        boolean up = false;
        if (currentNode.value.neoPositionY + 1 < currentNode.value.gridSizeY) {
            for (int i = 0; i < currentNode.value.agentsX.length; i++) {
                if (currentNode.value.agentsX[i] != currentNode.value.neoPositionX
                        && currentNode.value.agentsY[i] != currentNode.value.neoPositionY + 1
                        && currentNode.value.agentsX[i] == currentNode.value.neoPositionX
                        && currentNode.value.agentsY[i] == currentNode.value.neoPositionY + 1
                        && currentNode.value.agentDead[i] == true
                        && currentNode.value.hostagesX[i] == currentNode.value.neoPositionX
                        && currentNode.value.hostagesY[i] == currentNode.value.neoPositionY + 1
                        && currentNode.value.hostageAgent[i] == false) {
                    up = true;
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
        Pair balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(up, currentNode);
        return balabezo;
    }

    public static Pair downFunc(MyTreeNode<matrixValue> currentNode) {
        for (int i = 0; i < currentNode.value.hostagesDmg.length; i++) {
            currentNode.value.hostagesDmg[i] += 2;
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
        boolean down = false;
        if (currentNode.value.neoPositionY - 1 >= 0) {
            for (int i = 0; i < currentNode.value.agentsX.length; i++) {
                if (currentNode.value.agentsX[i] != currentNode.value.neoPositionX
                        && currentNode.value.agentsY[i] != currentNode.value.neoPositionY - 1
                        && currentNode.value.agentsX[i] == currentNode.value.neoPositionX
                        && currentNode.value.agentsY[i] == currentNode.value.neoPositionY - 1
                        && currentNode.value.agentDead[i] == true
                        && currentNode.value.hostagesX[i] == currentNode.value.neoPositionX
                        && currentNode.value.hostagesY[i] == currentNode.value.neoPositionY - 1
                        && currentNode.value.hostageAgent[i] == false) {
                    down = true;
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
        Pair balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(down, currentNode);
        return balabezo;
    }

    public static Pair leftFunc(MyTreeNode<matrixValue> currentNode) {
        for (int i = 0; i < currentNode.value.hostagesDmg.length; i++) {
            currentNode.value.hostagesDmg[i] += 2;
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
        boolean left = false;
        if (currentNode.value.neoPositionX - 1 >= 0) {
            for (int i = 0; i < currentNode.value.agentsX.length; i++) {
                if (currentNode.value.agentsX[i] != currentNode.value.neoPositionX - 1
                        && currentNode.value.agentsY[i] != currentNode.value.neoPositionY
                        && currentNode.value.agentsX[i] == currentNode.value.neoPositionX - 1
                        && currentNode.value.agentsY[i] == currentNode.value.neoPositionY
                        && currentNode.value.agentDead[i] == true
                        && currentNode.value.hostagesX[i] == currentNode.value.neoPositionX - 1
                        && currentNode.value.hostagesY[i] == currentNode.value.neoPositionY
                        && currentNode.value.hostageAgent[i] == false) {
                    left = true;
                }

            }
            if (left) {
                currentNode.value.neoPositionX -= 1;
                for (int i = 0; i < currentNode.value.hostagesCarried.length; i++) {
                    if (currentNode.value.hostagesCarried[i]) {
                        currentNode.value.hostagesX[i] -= 1;
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
        Pair balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(left, currentNode);
        return balabezo;
    }

    public static Pair rightFunc(MyTreeNode<matrixValue> currentNode) {
        for (int i = 0; i < currentNode.value.hostagesDmg.length; i++) {
            currentNode.value.hostagesDmg[i] += 2;
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
        boolean right = false;
        if (currentNode.value.neoPositionX + 1 < currentNode.value.gridSizeX) {
            for (int i = 0; i < currentNode.value.agentsX.length; i++) {
                if (currentNode.value.agentsX[i] != currentNode.value.neoPositionX + 1
                        && currentNode.value.agentsY[i] != currentNode.value.neoPositionY && currentNode.value.agentsX[i] == currentNode.value.neoPositionX + 1
                        && currentNode.value.agentsY[i] == currentNode.value.neoPositionY
                        && currentNode.value.agentDead[i] == true && currentNode.value.hostagesX[i] == currentNode.value.neoPositionX + 1
                        && currentNode.value.hostagesY[i] == currentNode.value.neoPositionY
                        && currentNode.value.hostageAgent[i] == false) {
                    right = true;
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
        Pair balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(right, currentNode);
        return balabezo;
    }

    public static Pair dropFunc(MyTreeNode<matrixValue> currentNode) {
        for (int i = 0; i < currentNode.value.hostagesDmg.length; i++) {
            currentNode.value.hostagesDmg[i] += 2;
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
        // if (action) {
        // for (int i = 0; i < 9; i++) {
        // MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentMatrix,
        // actions[i]);
        // currentNode.addChild(temp);
        // queue.add(temp);
        // }
        // }
        Pair balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(action, currentNode);
        return balabezo;
    }

    public static Pair carryFunc(MyTreeNode<matrixValue> currentNode) {
        for (int i = 0; i < currentNode.value.hostagesDmg.length; i++) {
            currentNode.value.hostagesDmg[i] += 2;
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
        boolean action = false;
        for (int i = 0; i < currentNode.value.hostagesX.length; i++) {
            if (currentNode.value.neoPositionX == currentNode.value.hostagesX[i]
                    && currentNode.value.neoPositionY == currentNode.value.hostagesY[i]
                    && currentNode.value.carryCount < currentNode.value.cap && !currentNode.value.hostagesCarried[i]
                    && !currentNode.value.hostageAgent[i] && !currentNode.value.hostageAgentKilled[i])
                currentNode.value.hostagesCarried[i] = true;
            action = true;
        }

        // if (action) {
        // for (int i = 0; i < 9; i++) {
        // MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentMatrix,
        // actions[i]);
        // currentNode.addChild(temp);
        // queue.add(temp);
        // }
        // }
        Pair balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(action, currentNode);
        return balabezo;
    }

    public static Pair takepillFunc(MyTreeNode<matrixValue> currentNode) {
        for (int i = 0; i < currentNode.value.hostagesDmg.length; i++) {
            currentNode.value.hostagesDmg[i] += 2;
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
        boolean action = false;
        for (int i = 0; i < currentNode.value.pillsX.length; i++) {
            if (currentNode.value.neoPositionX == currentNode.value.pillsX[i]
                    && currentNode.value.neoPositionY == currentNode.value.pillsY[i]) {
                currentNode.value.neoDmg -= 20;
                action = true;
                for (int dmg : currentNode.value.hostagesDmg) {
                    if (dmg != 100) {
                        dmg -= 20;
                        if (dmg < 0) {
                            dmg = 0;
                        }
                    }
                }
            }
        }
        // if (action) {
        // for (int i = 0; i < 9; i++) {
        // MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentMatrix,
        // actions[i]);
        // currentNode.addChild(temp);
        // queue.add(temp);
        // }
        // }
        Pair balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(action, currentNode);
        return balabezo;
    }

    public static Pair killFunc(MyTreeNode<matrixValue> currentNode) {
        for (int i = 0; i < currentNode.value.hostagesDmg.length; i++) {
            currentNode.value.hostagesDmg[i] += 2;
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
            if (currentNode.value.hostageAgent[i] == true) {
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
        // if (action) {
        // for (int i = 0; i < 9; i++) {
        // MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentMatrix,
        // actions[i]);
        // currentNode.addChild(temp);
        // queue.add(temp);
        // }
        // }
        Pair balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(action, currentNode);
        return balabezo;
    }

    public static Pair flyFunc(MyTreeNode<matrixValue> currentNode) {
        for (int i = 0; i < currentNode.value.hostagesDmg.length; i++) {
            currentNode.value.hostagesDmg[i] += 2;
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
        boolean action = false;
        for (int i = 0; i < currentNode.value.padsX.length; i += 2) {
            if (currentNode.value.neoPositionX == currentNode.value.padsX[i]
                    && currentNode.value.neoPositionY == currentNode.value.padsY[i]) {
                currentNode.value.neoPositionX = currentNode.value.padsX[i + 1];
                currentNode.value.neoPositionY = currentNode.value.padsY[i + 1];
                action = true;

            }
        }
        // if (action) {
        // for (int i = 0; i < 9; i++) {
        // MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(currentMatrix,
        // actions[i]);
        // currentNode.addChild(temp);
        // queue.add(temp);
        // }
        // }
        Pair balabezo = new Pair<Boolean, MyTreeNode<matrixValue>>(action, currentNode);
        return balabezo;

    }

    public static void bfs(Queue<MyTreeNode<matrixValue>> queue) {

        MyTreeNode<matrixValue> currentNode;
        do {

            currentNode = queue.remove();
            if (currentNode.action == "root") {
                for (int i = 0; i < 9; i++) {
                    matrixValue tempMatrix = new matrixValue(currentNode.value);
                    MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(tempMatrix, actions[i]);
                    currentNode.addChild(temp);
                    queue.add(temp);
                }
            } else {
                if (currentNode.value.neoDmg < 100) {

                    for (int i = 0; i < 9; i++) {
                        matrixValue tempMatrix = new matrixValue(currentNode.value);
                        MyTreeNode<matrixValue> temp = new MyTreeNode<matrixValue>(tempMatrix, actions[i]);
                        switch (actions[i]) {
                            case "up":
                                if ((boolean) upFunc(temp).a) {
                                    temp = (MyTreeNode<matrixValue>) upFunc(temp).b;
                                    currentNode.addChild(temp);
                                    queue.add(temp);
                                }
                                break;
                            case "down":
                                if ((boolean) downFunc(temp).a) {
                                    temp = (MyTreeNode<matrixValue>) downFunc(temp).b;
                                    currentNode.addChild(temp);
                                    queue.add(temp);
                                }
                                break;
                            case "left":
                                if ((boolean) leftFunc(temp).a) {
                                    temp = (MyTreeNode<matrixValue>) leftFunc(temp).b;
                                    currentNode.addChild(temp);
                                    queue.add(temp);
                                }
                                break;
                            case "right":
                                if ((boolean) rightFunc(temp).a) {
                                    temp = (MyTreeNode<matrixValue>) rightFunc(temp).b;
                                    currentNode.addChild(temp);
                                    queue.add(temp);
                                }
                                break;
                            case "carry":
                                if ((boolean) carryFunc(temp).a) {
                                    temp = (MyTreeNode<matrixValue>) carryFunc(temp).b;
                                    currentNode.addChild(temp);
                                    queue.add(temp);
                                }
                                break;
                            case "drop":
                                if ((boolean) dropFunc(temp).a) {
                                    temp = (MyTreeNode<matrixValue>) dropFunc(temp).b;
                                    currentNode.addChild(temp);
                                    queue.add(temp);
                                }
                                break;
                            case "takePill":
                                if ((boolean) takepillFunc(temp).a) {
                                    temp = (MyTreeNode<matrixValue>) takepillFunc(temp).b;
                                    currentNode.addChild(temp);
                                    queue.add(temp);
                                }
                                break;
                            case "kill":
                                if ((boolean) killFunc(temp).a) {
                                    temp = (MyTreeNode<matrixValue>) killFunc(temp).b;
                                    currentNode.addChild(temp);
                                    queue.add(temp);
                                }
                                break;
                            case "fly":
                                if ((boolean) flyFunc(temp).a) {
                                    temp = (MyTreeNode<matrixValue>) flyFunc(temp).b;
                                    currentNode.addChild(temp);
                                    queue.add(temp);
                                }
                                break;

                            default:
                                break;
                        }

                    }
                }
            }

            // System.out.println(currentNode.value.currentHostages);

            // for (MyTreeNode<matrixValue> myTreeNode : queue) {
            // System.out.println(myTreeNode.action);
            // }
            // System.out.println(currentNode.value.currentHostages);
            // for (MyTreeNode<matrixValue> myTreeNode : currentNode.getChildren()) {
            // System.out.println(myTreeNode.action);

            // }
        } while (currentNode.value.currentHostages > 0);
        // System.out.println(currentNode.value.currentHostages);
        while (currentNode.action != "root") {
            System.out.println(currentNode.value.currentHostages);
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
        // String grid = genGrid();
        String grid = "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";

        solve(grid, "BFS", false);

        // }
    }
}
