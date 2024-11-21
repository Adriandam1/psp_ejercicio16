public class Main {
    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();

        // Crear y arrancar el hilo del ascensor
        HiloControlAscensor hiloAscensor = new HiloControlAscensor(ascensor);
        hiloAscensor.start();

        // Crear varias personas
        Personas persona1 = new Personas(ascensor, 3, 10);
        Personas persona2 = new Personas(ascensor, 7, 2);
        Personas persona3 = new Personas(ascensor, 15, 1);

        // Iniciar los hilos de las personas
        persona1.start();
        persona2.start();
        persona3.start();
    }
}
