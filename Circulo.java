package figuritas;

public class Circulo extends Punto {
    int radio;
    Circulo(String nombre, int x, int y, int radio) {
        super(nombre,x,y);
        this.radio = radio;
    }

    @Override
    public String obtenerNombre() {
        return nombreFigura;
    }

    @Override
    public String imprimir() {
        return "radio" + radio + super.imprimir()+"\n";
    }

    @Override
    public float obtenerVolumen() {
        return 0f;
    }

    @Override
    public float obtenerArea() {
        return (float) (Math.PI * Math.pow(radio, 2));
    }

}
