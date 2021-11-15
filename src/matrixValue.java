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
    public int[] padsX;
    public int[] padsY;
    public int[] hostagesX;
    public int[] hostagesY;
    public int[] hostagesDmg;
    public boolean[] hostagesCarried;
    public boolean[] hostageAgent;
    public boolean[] agentDead;
    public int neoDmg;

    public matrixValue(String[] gridSize, String cap, String[] neoPosition, String[] telephone, String[] agents,
            String[] pills, String[] pads, String[] hostages, int neoDmg) {
        this.gridSizeX = Integer.parseInt(gridSize[0]);
        this.gridSizeY = Integer.parseInt(gridSize[0]);
        this.cap = Integer.parseInt(cap);
        this.neoPositionX = Integer.parseInt(neoPosition[0]);
        this.neoPositionY = Integer.parseInt(neoPosition[1]);
        this.telephoneX = Integer.parseInt(telephone[0]);
        this.telephoneY = Integer.parseInt(telephone[1]);
        agentsX = new int[agents.length];
        agentsY = new int[agents.length];
        agentDead = new boolean[agents.length];
        for (int i = 0; i < agents.length; i += 2) {
            agentsX[i] = Integer.parseInt(agents[i]);
            agentsY[i] = Integer.parseInt(agents[i + 1]);
            agentDead[i] = false;
        }
        pillsX = new int[pills.length];
        pillsY = new int[pills.length];
        for (int i = 0; i < pills.length; i += 2) {
            pillsX[i] = Integer.parseInt(pills[i]);
            pillsY[i] = Integer.parseInt(pills[i + 1]);
        }
        padsX = new int[pads.length];
        padsY = new int[pads.length];
        for (int i = 0; i < pads.length; i += 2) {
            padsX[i] = Integer.parseInt(pads[i]);
            padsY[i] = Integer.parseInt(pads[i + 1]);
        }
        hostagesX = new int[hostages.length];
        hostagesY = new int[hostages.length];
        hostagesDmg = new int[hostages.length];
        hostagesCarried = new boolean[hostages.length];
        hostageAgent = new boolean[hostages.length];

        for (int i = 0; i < hostages.length; i += 3) {
            hostagesX[i] = Integer.parseInt(hostages[i]);
            hostagesY[i] = Integer.parseInt(hostages[i + 1]);
            hostagesDmg[i] = Integer.parseInt(hostages[i + 2]);
            hostagesCarried[i] = false;
            hostageAgent[i] = false;

        }
        this.neoDmg = neoDmg;
        carryCount = 0;
    }

}