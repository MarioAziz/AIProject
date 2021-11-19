public class matrixValue {
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
            pillTaken[i]=false;
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
            hostagesX[i] = Integer.parseInt(hostages[i*3]);
            hostagesY[i] = Integer.parseInt(hostages[i*3 + 1]);
            hostagesDmg[i] = Integer.parseInt(hostages[i*3 + 2]);
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
        pillTaken=x.pillTaken;
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

}