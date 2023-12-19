class SuiteRoom extends Room {
    private String suiteType;

    public SuiteRoom(int roomNumber, String suiteType) {
        super(roomNumber);
        this.suiteType = suiteType;
    }

    public String getSuiteType() {
        return suiteType;
    }
}