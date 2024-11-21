public class HiloControlAscensor extends Thread {
    private final Ascensor ascensor;

    public HiloControlAscensor(Ascensor ascensor) {
        this.ascensor = ascensor;
    }

    @Override
    public void run() {
        ascensor.procesarSolicitudes();
    }
}
