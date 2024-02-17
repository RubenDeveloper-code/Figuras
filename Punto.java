package figuritas;

public class Punto extends Figura {
    int x, y;
    Punto(String nombreFigura,int x, int y) {
        super(nombreFigura);
        this.x = x;
        this.y = y;
    }

    @Override
    public String obtenerNombre() {
        return super.nombreFigura;
    }

    @Override
    public String imprimir() {
        return "El punto: [" + x + "," + y + "]\n";
    }

    @Override
    public float obtenerVolumen() {
        return 0;
    }

    @Override
    public float obtenerArea() {
        return 0;
    }
}
