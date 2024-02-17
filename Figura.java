package figuritas;

public abstract class Figura {
    protected String nombreFigura;
    Figura(String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }
    public abstract String obtenerNombre();
    public abstract String imprimir();
    public abstract float obtenerVolumen();
    public abstract float obtenerArea();
}
