package figuritas;

public class Cilindro extends Circulo {
    int altura;
    Cilindro(String nombre, int x, int y, int radio, int altura) {
        super(nombre,x,y,radio);
        this.altura = altura;
    }

    @Override
    public String obtenerNombre() {
        return nombreFigura;
    }

    @Override
    public String imprimir() {
        return "altura" + radio + super.imprimir();
    }

    @Override
    public float obtenerVolumen() {
        return super.obtenerArea() * altura;
    }

    @Override
    public float obtenerArea() {//JAVA!!!!!!?
        return (float)((float)(2*super.obtenerArea())+(2*Math.PI*radio*altura));
    }
}
