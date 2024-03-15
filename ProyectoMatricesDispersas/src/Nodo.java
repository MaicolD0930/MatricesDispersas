public class Nodo {
    private int f, c, Dato;
    private Nodo Liga, Lf, Lc;

    public Nodo(int f, int c, int dato) {
        this.f = f;
        this.c = c;
        Dato = dato;
        Liga = null;
        Lf = null;
        Lc = null;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getDato() {
        return Dato;
    }

    public void setDato(int dato) {
        Dato = dato;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo liga) {
        Liga = liga;
    }

    public Nodo getLf() {
        return Lf;
    }

    public void setLf(Nodo lf) {
        Lf = lf;
    }

    public Nodo getLc() {
        return Lc;
    }

    public void setLc(Nodo lc) {
        Lc = lc;
    }

}
