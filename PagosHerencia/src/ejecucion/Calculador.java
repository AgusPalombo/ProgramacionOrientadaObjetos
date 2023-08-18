package ejecucion;


public class Calculador {
    private double totalMontos = 0;

    public void agregarMonto(double monto) {
        totalMontos += monto;
    }

    public void mostrarTotalMontos() {
        System.out.println("Total de montos acumulados: " + totalMontos);
    }
}
