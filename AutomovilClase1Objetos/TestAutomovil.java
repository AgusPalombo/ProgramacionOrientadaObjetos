public class TestAutomovil {
	public static void main(String[] args) {
        Automovil miAutomovil = new Automovil("Toyota", "Corolla", 2023, "Rojo", true);

        System.out.println("Detalles del automóvil:");
        System.out.println("Marca: " + miAutomovil.getMarca());
        System.out.println("Modelo: " + miAutomovil.getModelo());
        System.out.println("Año: " + miAutomovil.getAño());
        System.out.println("Color: " + miAutomovil.getColor());
        System.out.println("Encendido: " + miAutomovil.isEncendido());

        miAutomovil.acelerar();
        miAutomovil.frenar();
        miAutomovil.apagar();
    }
}
