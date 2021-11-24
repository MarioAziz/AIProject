package code;

import java.util.Arrays;

public class matrixValue implements Cloneable {
    public int gridSizeX;
    public int gridSizeY;
    public int cap;
    public int carryCount;
    public int neoPositionX;
    public int neoPositionY;
    public int telephoneX;
    public int telephoneY;
    public int[] agentsX;
    public int[] agentsY;
    public int[] pillsX;
    public int[] pillsY;
    public boolean[] pillTaken;
    public int[] padsX;
    public int[] padsY;
    public int[] hostagesX;
    public int[] hostagesY;
    public int[] hostagesDmg;
    public int currentHostages;
    public boolean[] hostagesCarried;
    public boolean[] hostageAgent;
    public boolean[] hostageAgentKilled;
    public boolean[] agentDead;
    public int neoDmg;

    public matrixValue(String[] gridSize, String cap, String[] neoPosition, String[] telephone, String[] agents,
            String[] pills, String[] pads, String[] hostages, int neoDmg) {
        this.gridSizeX = Integer.parseInt(gridSize[0]);
        this.gridSizeY = Integer.parseInt(gridSize[1]);
        this.cap = Integer.parseInt(cap);
        this.neoPositionX = Integer.parseInt(neoPosition[0]);
        this.neoPositionY = Integer.parseInt(neoPosition[1]);
        this.telephoneX = Integer.parseInt(telephone[0]);
        this.telephoneY = Integer.parseInt(telephone[1]);
        agentsX = new int[agents.length / 2];
        agentsY = new int[agents.length / 2];
        agentDead = new boolean[agents.length / 2];
        for (int i = 0; i < agentsX.length; i++) {
            agentsX[i] = Integer.parseInt(agents[i * 2]);
            agentsY[i] = Integer.parseInt(agents[i * 2 + 1]);
            agentDead[i] = false;
        }
        pillsX = new int[pills.length / 2];
        pillsY = new int[pills.length / 2];
        pillTaken = new boolean[pills.length / 2];
        for (int i = 0; i < pillsX.length; i++) {
            pillsX[i] = Integer.parseInt(pills[i * 2]);
            pillsY[i] = Integer.parseInt(pills[i * 2 + 1]);
            pillTaken[i] = false;
        }
        padsX = new int[pads.length / 2];
        padsY = new int[pads.length / 2];
        for (int i = 0; i < padsX.length; i++) {
            padsX[i] = Integer.parseInt(pads[i * 2]);
            padsY[i] = Integer.parseInt(pads[i * 2 + 1]);
        }
        hostagesX = new int[hostages.length / 3];
        hostagesY = new int[hostages.length / 3];
        hostagesDmg = new int[hostages.length / 3];
        hostagesCarried = new boolean[hostages.length / 3];
        hostageAgent = new boolean[hostages.length / 3];
        hostageAgentKilled = new boolean[hostages.length / 3];

        for (int i = 0; i < hostagesX.length; i++) {
            hostagesX[i] = Integer.parseInt(hostages[i * 3]);
            hostagesY[i] = Integer.parseInt(hostages[i * 3 + 1]);
            hostagesDmg[i] = Integer.parseInt(hostages[i * 3 + 2]);
            hostagesCarried[i] = false;
            hostageAgent[i] = false;
            hostageAgentKilled[i] = false;
        }
        currentHostages = hostagesX.length;
        this.neoDmg = neoDmg;
        carryCount = 0;
    }

    public matrixValue(matrixValue x) {
        this.gridSizeX = x.gridSizeX;
        this.gridSizeY = x.gridSizeY;
        this.cap = x.cap;
        this.neoPositionX = x.neoPositionX;
        this.neoPositionY = x.neoPositionY;
        this.telephoneX = x.telephoneX;
        this.telephoneY = x.telephoneY;
        agentsX = x.agentsX;
        agentsY = x.agentsY;
        agentDead = x.agentDead;
        pillsX = x.pillsX;
        pillsY = x.pillsY;
        pillTaken = x.pillTaken;
        padsX = x.padsX;
        padsY = x.padsY;
        hostagesX = x.hostagesX;
        hostagesY = x.hostagesY;
        hostagesDmg = x.hostagesDmg;
        hostagesCarried = x.hostagesCarried;
        hostageAgent = x.hostageAgent;
        hostageAgentKilled = x.hostageAgentKilled;
        currentHostages = x.currentHostages;
        neoDmg = x.neoDmg;
        carryCount = x.carryCount;
    }

    public matrixValue clone() {
        return new matrixValue(this);

    }

    public matrixValue(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");

        gridSizeX = Integer.parseInt(temp[0]);
        gridSizeY = Integer.parseInt(temp[1]);
        cap = Integer.parseInt(temp[2]);
        neoPositionX = Integer.parseInt(temp[3]);
        neoPositionY = Integer.parseInt(temp[4]);
        telephoneX = Integer.parseInt(temp[5]);
        telephoneY = Integer.parseInt(temp[6]);

        if (temp[7].length() > 1) {
            String[] agentsXString = temp[7].split(",");
            agentsX = new int[agentsXString.length];
            for (int i = 0; i < agentsXString.length; i++) {
                agentsX[i] = Integer.parseInt(agentsXString[i]);
            }
        } else {
            agentsX = new int[1];

            agentsX[0] = Integer.parseInt((temp[7]));
        }

        if (temp[8].length() > 1) {

            String[] agentsYString = temp[8].split(",");
            agentsY = new int[agentsYString.length];

            for (int i = 0; i < agentsYString.length; i++) {
                agentsY[i] = Integer.parseInt(agentsYString[i]);
            }
        } else {
            agentsY = new int[1];

            agentsY[0] = Integer.parseInt(temp[8]);

        }

        if (temp[9].length() > 1) {

            String[] pillsXString = temp[9].split(",");
            pillsX = new int[pillsXString.length];

            for (int i = 0; i < pillsXString.length; i++) {
                pillsX[i] = Integer.parseInt(pillsXString[i]);
            }

            String[] pillsYString = temp[10].split(",");
            pillsY = new int[pillsYString.length];

            for (int i = 0; i < pillsYString.length; i++) {
                pillsY[i] = Integer.parseInt(pillsYString[i]);
            }

            String[] pillsTakenString = temp[11].split(",");
            pillTaken = new boolean[pillsTakenString.length];

            for (int i = 0; i < pillsTakenString.length; i++) {
                pillTaken[i] = Boolean.parseBoolean(pillsTakenString[i]);
            }
        } else {
            pillsX = new int[1];
            pillsY = new int[1];
            pillTaken = new boolean[1];
            pillsX[0] = Integer.parseInt(temp[9]);
            pillsY[0] = Integer.parseInt(temp[10]);
            pillTaken[0] = Boolean.parseBoolean(temp[11]);

        }

        String[] padsXString = temp[12].split(",");
        padsX = new int[padsXString.length];

        for (int i = 0; i < padsXString.length; i++) {
            padsX[i] = Integer.parseInt(padsXString[i]);
        }

        String[] padsYString = temp[13].split(",");
        padsY = new int[padsYString.length];

        for (int i = 0; i < padsYString.length; i++) {
            padsY[i] = Integer.parseInt(padsYString[i]);
        }

        if (temp[14].length() > 1) {

            String[] hostagXString = temp[14].split(",");
            hostagesX = new int[hostagXString.length];

            for (int i = 0; i < hostagXString.length; i++) {
                hostagesX[i] = Integer.parseInt(hostagXString[i]);
            }

            String[] hostageYString = temp[15].split(",");
            hostagesY = new int[hostageYString.length];

            for (int i = 0; i < hostageYString.length; i++) {
                hostagesY[i] = Integer.parseInt(hostageYString[i]);
            }

            String[] hostageDmgString = temp[16].split(",");
            hostagesDmg = new int[hostageDmgString.length];

            for (int i = 0; i < hostageDmgString.length; i++) {
                hostagesDmg[i] = Integer.parseInt(hostageDmgString[i]);
            }

            String[] hostageCarriedString = temp[18].split(",");
            hostagesCarried = new boolean[hostageCarriedString.length];

            for (int i = 0; i < hostageCarriedString.length; i++) {
                hostagesCarried[i] = Boolean.parseBoolean(hostageCarriedString[i]);
            }

            String[] hostageAgentString = temp[19].split(",");
            hostageAgent = new boolean[hostageAgentString.length];

            for (int i = 0; i < hostageAgentString.length; i++) {
                hostageAgent[i] = Boolean.parseBoolean(hostageAgentString[i]);
            }

            String[] hostageAgentKilledString = temp[20].split(",");
            hostageAgentKilled = new boolean[hostageAgentKilledString.length];

            for (int i = 0; i < hostageAgentKilledString.length; i++) {
                hostageAgentKilled[i] = Boolean.parseBoolean(hostageAgentKilledString[i]);
            }
        } else {
            hostagesX = new int[1];
            hostagesY = new int[1];
            hostagesDmg = new int[1];
            hostagesCarried = new boolean[1];
            hostageAgent = new boolean[1];
            hostageAgentKilled = new boolean[1];

            hostagesX[0] = Integer.parseInt(temp[14]);
            hostagesY[0] = Integer.parseInt(temp[15]);
            hostagesDmg[0] = Integer.parseInt(temp[16]);
            hostagesCarried[0] = Boolean.parseBoolean(temp[18]);
            hostageAgent[0] = Boolean.parseBoolean(temp[19]);
            hostageAgentKilled[0] = Boolean.parseBoolean(temp[20]);

        }
        currentHostages = Integer.parseInt(temp[17]);

        if (temp[21].length() > 1) {

            String[] agentDeadString = temp[21].split(",");
            agentDead = new boolean[agentDeadString.length];

            for (int i = 0; i < agentDeadString.length; i++) {
                agentDead[i] = Boolean.parseBoolean(agentDeadString[i]);
            }
        } else {
            agentDead = new boolean[1];

            agentDead[0] = Boolean.parseBoolean(temp[21]);
        }

        neoDmg = Integer.parseInt(temp[22]);
        carryCount = Integer.parseInt(temp[23]);

    }

    public String hashValue() {

        return "" + gridSizeX + ";" + gridSizeY + ";" + cap + ";" + neoPositionX + ";" + neoPositionY + ";" + telephoneX
                + ";" + telephoneY + ";" + Arrays.toString(agentsX) + ";" + Arrays.toString(agentsY) + ";"
                + Arrays.toString(pillsX) + ";" + Arrays.toString(pillsY) + ";" + Arrays.toString(pillTaken) + ";"
                + Arrays.toString(padsX) + ";" + Arrays.toString(padsY) + ";" + Arrays.toString(hostagesX) + ";"
                + Arrays.toString(hostagesY) + ";" + Arrays.toString(hostagesDmg) + ";" + currentHostages + ";"
                + Arrays.toString(hostagesCarried) + ";" + Arrays.toString(hostageAgent) + ";"
                + Arrays.toString(hostageAgentKilled) + ";" + Arrays.toString(agentDead) + ";" + neoDmg + ";"
                + carryCount;
    }

    public String hashValueNodmg() {

        return "" + gridSizeX + ";" + gridSizeY + ";" + cap + ";" + neoPositionX + ";" + neoPositionY + ";" + telephoneX
                + ";" + telephoneY + ";" + Arrays.toString(agentsX) + ";" + Arrays.toString(agentsY) + ";"
                + Arrays.toString(pillsX) + ";" + Arrays.toString(pillsY) + ";" + Arrays.toString(pillTaken) + ";"
                + Arrays.toString(padsX) + ";" + Arrays.toString(padsY) + ";" + Arrays.toString(hostagesX) + ";"
                + Arrays.toString(hostagesY) + ";" + currentHostages + ";" + Arrays.toString(hostagesCarried) + ";"
                + Arrays.toString(hostageAgent) + ";" + Arrays.toString(hostageAgentKilled) + ";"
                + Arrays.toString(agentDead) + ";" + neoDmg + ";" + carryCount;
    }

}