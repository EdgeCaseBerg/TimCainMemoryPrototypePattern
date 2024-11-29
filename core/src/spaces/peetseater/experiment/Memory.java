package spaces.peetseater.experiment;

class Memory {
    private long totalMemory;
    private long usedSoFar;
    private final Runtime runtime;

    public Memory() {
        runtime = Runtime.getRuntime();
        totalMemory = runtime.totalMemory();
        calculateMemory();
    }

    public void calculateMemory() {
        totalMemory = runtime.totalMemory();
        usedSoFar = (totalMemory - runtime.freeMemory())  / (1024 * 1024);
    }

    public long used() {
        return usedSoFar;
    }
}
