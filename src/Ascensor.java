import java.util.ArrayList;

public class Ascensor {
    private int pisoActual = 0; // Piso inicial
    private final ArrayList<Integer> solicitudes = new ArrayList<>();
    private boolean enMovimiento = false;

    // Metodo para solicitar un piso
    public synchronized void solicitarPiso(int piso) {
        solicitudes.add(piso);
        System.out.println("Se solicitó el ascensor al piso " + piso);
        notifyAll(); // Notificar al ascensor que hay una nueva solicitud
    }

    // Metodo para que el ascensor procese las solicitudes
    public synchronized void procesarSolicitudes() {
        while (true) {
            while (solicitudes.isEmpty()) {
                try {
                    System.out.println("El ascensor está esperando solicitudes.");
                    wait(); // Espera hasta que haya solicitudes
                } catch (InterruptedException e) {
                    System.err.println("Ascensor interrumpido.");
                    return;
                }
            }

            // Procesar la siguiente solicitud
            int destino = solicitudes.remove(0); // Tomamos el primer elemento de la lista
            enMovimiento = true;
            System.out.println("Ascensor moviéndose del piso " + pisoActual + " al piso " + destino);

            try {
                Thread.sleep(Math.abs(destino - pisoActual) * 500); // Simula el tiempo de movimiento
            } catch (InterruptedException e) {
                System.err.println("Ascensor interrumpido durante el movimiento.");
                return;
            }

            pisoActual = destino;
            enMovimiento = false;
            System.out.println("El ascensor llegó al piso " + pisoActual + ".");
        }
    }
}
