public class Personas extends Thread {
    private final Ascensor ascensor;
    private final int pisoOrigen;
    private final int pisoDestino;

    public Personas(Ascensor ascensor, int pisoOrigen, int pisoDestino) {
        this.ascensor = ascensor;
        this.pisoOrigen = pisoOrigen;
        this.pisoDestino = pisoDestino;
    }

    @Override
    public void run() {
        try {
            // Solicita el ascensor desde el piso de origen
            System.out.println("Persona en el piso " + pisoOrigen + " solicita el ascensor.");
            ascensor.solicitarPiso(pisoOrigen);

            // Espera para simular que la persona entra en el ascensor
            Thread.sleep(1000);

            // Solicita el ascensor para ir al piso de destino
            System.out.println("Persona en el piso " + pisoOrigen + " solicita ir al piso " + pisoDestino + ".");
            ascensor.solicitarPiso(pisoDestino);
        } catch (InterruptedException e) {
            System.err.println("Persona interrumpida.");
        }
    }
}
