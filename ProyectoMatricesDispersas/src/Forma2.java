import java.util.Scanner;

public class Forma2 {
    private Nodo Punta;
    Scanner Basura = new Scanner(System.in);

    public Forma2(int[][] Matriz) {
        Punta = new Nodo(Matriz.length, Matriz[0].length, 0);
        Nodo p = Punta;
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz[0].length; j++) {
                if (Matriz[i][j] != 0) {
                    Nodo x = new Nodo(i, j, Matriz[i][j]);
                    p.setLf(x);
                    p = p.getLf();
                }
            }
        }
        p.setLf(Punta);
        Nodo q = Punta;
        for (int i = 0; i < Matriz[0].length; i++) {
            p = Punta.getLf();
            while (p != Punta) {
                if (p.getC() == i) {
                    q.setLc(p);
                    q = q.getLc();
                }
                p = p.getLf();
            }
        }
        q.setLc(Punta);
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo punta) {
        Punta = punta;
    }

    public void Mostrar() {
        Nodo p = Punta;
        String cadena = "";
        do {
            cadena += "[" + p.getF() + "]" + "[" + p.getC() + "]" + "[" + p.getDato() + "]";
            if (p.getLf() != Punta) {
                cadena += "-->";
            }
            p = p.getLf();
        } while (p != Punta);
        System.out.println(cadena);
    }

    public void SumarF() {
        Nodo p = Punta, q;
        int j = 0, s;
        while (j < p.getF()) {
            q = p.getLf();
            s = 0;
            while (q != p) {
                if (q.getF() == j) {
                    s += q.getDato();
                }
                q = q.getLf();
            }
            System.out.println("La suma de la fila " + j + " es: " + s);

            j++;
        }
    }

    public void SumarC() {
        Nodo p = Punta, q;
        int j = 0, s;
        while (j < p.getC()) {
            q = p.getLc();
            s = 0;
            while (q != p) {
                if (q.getC() == j) {
                    s += q.getDato();
                }
                q = q.getLc();
            }
            System.out.println("La suma de la columna " + j + " es: " + s);

            j++;
        }

    }

    public void Insertar(String cadena) {
        if (cadena.isEmpty()) {
            System.out.println(
                    "ingrese primero las filas, luego las columnas, y por ultimo el dato, ejemplo: (1,2,3) uno es las filas, dos las columnas y 3 el dato");
            cadena = Basura.next();
        }
        String[] comp = cadena.split(",");
        int dato = Integer.parseInt(comp[2]);
        int c = Integer.parseInt(comp[1]);
        int f = Integer.parseInt(comp[0]);
        boolean bandera = false;
        Nodo p = Punta;
        Nodo q = p.getLf();
        if (f < Punta.getF() && c < Punta.getC()) {
            while (q != p && !bandera) {
                if (q.getF() == f && q.getC() == c) {
                    bandera = true;
                    System.out.println(
                            "Se encontro un valor en esa posicion, ingrese 1 para reemplazarlo, o 2 para sumarlos");
                    int valor;
                    do {
                        valor = Basura.nextInt();
                        switch (valor) {
                            case 1:
                                q.setDato(dato);
                                break;
                            case 2:
                                q.setDato(q.getDato() + dato);
                                break;
                            default:
                                System.out.println("No seas idiota, coloca un 1 o 2, usuario de mierda");
                                break;
                        }
                    } while (valor != 1 && valor != 2);
                }

                q = q.getLf();
            }

            if (!bandera) {
                Nodo ñ = Punta, a;
                p = Punta;
                q = p.getLf();
                a = ñ.getLc();

                    while (q != p && q.getLf().getF() < f) {
                        q = q.getLf();
                    }
                    while (a != ñ && a.getLc().getC() < c) {
                        a = a.getLc();
                    }
                    Nodo x = new Nodo(f, c, dato);
                    x.setLf(q.getLf());
                    x.setLc(a.getLc());
                    q.setLf(x);
                    a.setLc(x);


            } else {
                System.out.println("No existe la posicion del dato a insertar en la matriz");
            }
        }
    }

    public void Eliminar() {
        boolean bandera;
        int opc;
        do {
            System.out.println(
                    "ingrese 1, 2 o 3 si quieres eliminar por dato, posicion o posicion y dato respectivamente");
            opc = Basura.nextInt();
            bandera = false;
            Nodo p = Punta, q = p.getLf(), o = p, w = p.getLc();
            switch (opc) {
                case 1:
                    System.out.println("ingrese el dato a eliminar");
                    int dato = Basura.nextInt();

                    while (q != p) {
                        if (q.getDato() == dato) {
                            bandera = true;
                            w = q.getLc();
                            while (w.getLc() != q) {
                                w = w.getLc();
                            }
                            o.setLf(q.getLf());
                            w.setLc(q.getLc());
                        }
                        q = q.getLf();
                        o = o.getLf();
                    }

                    break;
                case 2:
                    System.out.println(
                            "ingrese primero las filas, y luego las columnas, ejemplo: (1,2) uno es las filas y dos las columnas");
                    String cadena = Basura.next();
                    String[] componentes = cadena.split(",");
                    while (q != p) {
                        if (q.getF() == Integer.parseInt(componentes[0])
                                && q.getC() == Integer.parseInt(componentes[1])) {
                            bandera = true;
                            w = q.getLc();
                            while (w.getLc() != q) {
                                w = w.getLc();
                            }
                            o.setLf(q.getLf());
                            w.setLc(q.getLc());
                        }
                        q = q.getLf();
                        o = o.getLf();
                    }
                    break;
                case 3:
                    System.out.println(
                            "ingrese primero las filas, luego las columnas, y por ultimo el dato, ejemplo: (1,2,3) uno es las filas, dos las columnas y 3 el dato");
                    cadena = Basura.next();
                    String[] comp = cadena.split(",");
                    while (q != p) {
                        if (q.getF() == Integer.parseInt(comp[0]) && q.getC() == Integer.parseInt(comp[1])
                                && q.getDato() == Integer.parseInt(comp[2])) {
                            bandera = true;
                            w = q.getLc();
                            while (w.getLc() != q) {
                                w = w.getLc();
                            }
                            o.setLf(q.getLf());
                            w.setLc(q.getLc());
                        }
                        q = q.getLf();
                        o = o.getLf();
                    }
                    p = p.getLiga();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opc != 1 && opc != 2 && opc != 3);
        if (bandera) {
            System.out.println("El dato se a eliminado exitosamente");
        } else {
            System.out.println("El dato a eliminar no se encuentra en la tripleta");
        }
    }

    public void Sumar(Forma2 b) {
        Nodo p = Punta, q = p.getLf(), p1 = b.Punta, q1 = p1.getLf();
        Forma2 nueva = new Forma2(new int[Punta.getF()][Punta.getC()]);
        Nodo z = nueva.Punta, m = nueva.Punta, x;
        while (q != p || q1 != p1) {
            if (q != p && q1 != p1) {
                if (q.getF() == q1.getF() && q.getC() == q1.getC()) {
                    if (q.getDato() + q1.getDato() != 0) {
                        x = new Nodo(q.getF(), q.getC(), q.getDato() + q1.getDato());
                        m.setLf(x);
                        m = x;
                        x.setLf(z);
                    }
                    q = q.getLf();
                    q1 = q1.getLf();
                } else if (q.getC() < q1.getC()) {
                    x = new Nodo(q.getF(), q.getC(), q.getDato());
                    q = q.getLf();
                    m.setLf(x);
                    m = x;
                    x.setLf(z);
                } else {
                    x = new Nodo(q1.getF(), q1.getC(), q1.getDato());
                    q1 = q1.getLf();
                    m.setLf(x);
                    m = x;
                    x.setLf(z);
                }
            } else {
                if (q != p) {
                    x = new Nodo(q.getF(), q.getC(), q.getDato());
                    q = q.getLf();
                    m.setLf(x);
                    m = x;
                    x.setLf(z);
                } else {
                    x = new Nodo(q1.getF(), q1.getC(), q1.getDato());
                    q1 = q1.getLf();
                    m.setLf(x);
                    m = x;
                    x.setLf(z);
                }
            }
        }

        Punta = nueva.Punta;

    }

    public void Multiplicar(Forma2 b) {
        Forma2 nueva = new Forma2(new int[Punta.getF()][b.Punta.getC()]);
        int i = 0;
        Nodo p = Punta.getLc();
        int sum = 0;
        while (i < Punta.getF()) {
            int j = 0;
            Nodo q = b.Punta;
            while (j < b.Punta.getC()) {
                sum = fMasc(p, q, i, j);
                if (sum != 0) {
                    nueva.Insertar(i + "," + j + "," + sum);
                }
                j++;
            }
            i++;
            p = p.getLc();
        }
        this.Punta = nueva.Punta;
    }

    private int fMasc(Nodo cabezeraf, Nodo cabezerac, int i, int j) {
        int sum = 0;
        Nodo p = cabezeraf;
        Nodo q = cabezerac.getLc();
        while (p != Punta && p.getF() <= i) {
            while (q != cabezerac && q.getC() <= j) {
                if (p.getC() == q.getF() && q.getC() == j && p.getF() == i) {
                    sum += p.getDato() * q.getDato();
                }
                q = q.getLc();
            }
            p = p.getLf();
        }
        return sum;
    }

}
