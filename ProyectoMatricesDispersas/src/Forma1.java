import java.util.Scanner;

public class Forma1 {
    private Nodo Punta;

    public Forma1(int[][] matriz) {
        Punta = null;
        Paso1(matriz.length, matriz[0].length);
        Paso2(matriz);
        Paso3();
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo punta) {
        Punta = punta;
    }

    private void Paso1(int f, int c) {
        int mayor;
        if (f > c) {
            mayor = f;
        } else {
            mayor = c;
        }
        Nodo x = new Nodo(f, c, 0);
        Punta = x;
        Nodo p = Punta;
        for (int i = 0; i < mayor; i++) {
            x = new Nodo(i, i, 0);
            p.setLiga(x);
            p = x;
        }
        p.setLiga(Punta);
    }

    private void Paso2(int[][] M) {
        Nodo p = Punta.getLiga();
        Nodo q = p;
        Nodo x;
        for (int i = 0; i < M.length; i++) {
            q = p;
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] != 0) {
                    x = new Nodo(i, j, M[i][j]);
                    q.setLf(x);
                    q = q.getLf();
                }
            }
            q.setLf(p);
            p = p.getLiga();
        }
        p = Punta.getLiga();
        while (p != Punta) {
            if (p.getLc() == null) {
                p.setLc(p);
            }
            if (p.getLf() == null) {
                p.setLf(p);
            }
            p = p.getLiga();
        }
    }

    private void Paso3() {
        Nodo RC = Punta.getLiga(), a = RC, p = Punta.getLiga(), q = p.getLf();
        while (RC != Punta) {
            a = RC;
            p = Punta.getLiga();
            while (p != Punta) {
                q = p.getLf();
                while (q != p) {
                    if (q.getC() == RC.getC()) {
                        a.setLc(q);
                        a = a.getLc();
                    }
                    q = q.getLf();
                }
                p = p.getLiga();
            }
            a.setLc(RC);
            RC = RC.getLiga();
        }
    }

    public void Mostrar() {
        Nodo p = Punta.getLiga();
        System.out.println("[" + Punta.getF() + "]" + "[" + Punta.getC() + "]" + "[" + Punta.getDato() + "]");
        while (p != Punta) {
            Nodo q = p.getLf();
            String cadena;
            if (p.getLf() == p) {
                cadena = "[" + p.getF() + "]" + "[" + p.getC() + "]" + "[" + p.getDato() + "]";
            } else {
                cadena = "[" + p.getF() + "]" + "[" + p.getC() + "]" + "[" + p.getDato() + "]-->";
            }
            while (q != p) {
                if (q.getLf() == p) {
                    cadena += "[" + q.getF() + "]" + "[" + q.getC() + "]" + "[" + q.getDato() + "]";
                } else {
                    cadena += "[" + q.getF() + "]" + "[" + q.getC() + "]" + "[" + q.getDato() + "]-->";
                }
                q = q.getLf();
            }
            p = p.getLiga();
            System.out.println(cadena);
        }
    }

    public void Eliminar() {
        boolean bandera;
        int opc;
        do {
            System.out.println(
                    "ingrese 1, 2 o 3 si quieres eliminar por dato, posicion o posicion y dato respectivamente");
            Scanner Basura = new Scanner(System.in);
            opc = Basura.nextInt();
            bandera = false;
            Nodo p = Punta.getLiga(), q = p.getLf(), o = p.getLf(), w = p.getLc();
            switch (opc) {
                case 1:
                    System.out.println("ingrese el dato a eliminar");
                    int dato = Basura.nextInt();
                    while (p != Punta) {
                        q = p.getLf();
                        o = p;
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
                        p = p.getLiga();
                    }
                    break;
                case 2:
                    System.out.println(
                            "ingrese primero las filas, y luego las columnas, ejemplo: (1,2) uno es las filas y dos las columnas");
                    String cadena = Basura.next();
                    String[] componentes = cadena.split(",");
                    while (p != Punta) {
                        q = p.getLf();
                        o = p;
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
                        p = p.getLiga();
                    }
                    break;
                case 3:
                    System.out.println(
                            "ingrese primero las filas, luego las columnas, y por ultimo el dato, ejemplo: (1,2,3) uno es las filas, dos las columnas y 3 el dato");
                    cadena = Basura.next();
                    String[] comp = cadena.split(",");
                    while (p != Punta) {
                        q = p.getLf();
                        o = p;
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
                    }
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

    public void Insertar(String cadena) {
        Scanner Basura = new Scanner(System.in);
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
        if (f < Punta.getF() && c < Punta.getC()) {
            Nodo p = Punta.getLiga();
            while (p != Punta && !bandera) {
                Nodo q = p.getLf();
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
                p = p.getLiga();
            }

            if (!bandera) {
                p = Punta.getLiga();
                Nodo ñ = Punta.getLiga();
                while ((p.getF() != f || ñ.getC() != c)) {
                    if (p.getF() != f) {
                        p = p.getLiga();
                    }
                    if (ñ.getC() != c) {
                        ñ = ñ.getLiga();
                    }
                }
                Nodo q = p, a = ñ.getLc();
                do {
                    if(q.getLf().getC() < c){
                        q = q.getLf();
                    }
                } while (q.getLf() != p && q.getLf().getC() < c);
                do {
                    if(a.getLc().getF() < f){
                        a = a.getLc();
                    }
                } while (a.getLc() != ñ && a.getLc().getF() < f);
                Nodo x = new Nodo(f, c, dato);
                x.setLf(q.getLf());
                q.setLf(x);
                x.setLc(a.getLc());
                a.setLc(x);
            }
        }else{
            System.out.println("No existe la posicion del dato a insertar en la matriz");
        }

    }

    public void SumarF() {
        Nodo p = Punta.getLiga(), q;
        int i = 0, f;
        while (p != Punta) {
            q = p.getLf();
            f = 0;
            while (q != p) {
                f += q.getDato();
                q = q.getLf();
            }
            System.out.println("La suma de la fila " + i + " es: " + f);
            i++;
            p = p.getLiga();
        }
    }

    public void SumarC() {
        Nodo p = Punta.getLiga(), q;
        int i = 0, f;
        while (p != Punta) {
            q = p.getLc();
            f = 0;
            while (q != p) {
                f += q.getDato();
                q = q.getLc();
            }
            System.out.println("La suma de la columna " + i + " es: " + f);
            i++;
            p = p.getLiga();
        }
    }

    public void Sumar(Forma1 b) {
        Nodo p = Punta.getLiga(), q, ñ = b.Punta.getLiga(), a;
        Forma1 nueva = new Forma1(new int[Punta.getF()][Punta.getC()]);
        Nodo z = nueva.Punta.getLiga(), m, x;
        while (p != Punta || ñ != b.Punta) {
            q = p.getLf();
            a = ñ.getLf();
            m = z.getLf();
            while (q != p || a != ñ) {
                if (q != p && a != ñ) {
                    if (q.getC() == a.getC()) {
                        if (q.getDato() + a.getDato() != 0) {
                            x = new Nodo(q.getF(), q.getC(), q.getDato() + a.getDato());
                            m.setLf(x);
                            m = x;
                            x.setLf(z);
                        }
                        q = q.getLf();
                        a = a.getLf();
                    } else if (q.getC() < a.getC()) {
                        x = new Nodo(q.getF(), q.getC(), q.getDato());
                        q = q.getLf();
                        m.setLf(x);
                        m = x;
                        x.setLf(z);
                    } else {
                        x = new Nodo(a.getF(), a.getC(), a.getDato());
                        a = a.getLf();
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
                        x = new Nodo(a.getF(), a.getC(), a.getDato());
                        a = a.getLf();
                        m.setLf(x);
                        m = x;
                        x.setLf(z);
                    }
                }
            }
            p = p.getLiga();
            ñ = ñ.getLiga();
            z = z.getLiga();
        }
        nueva.Paso3();
        Punta = nueva.Punta;
    }

    public void Multiplicar(Forma1 b) {
        Forma1 nueva = new Forma1(new int[Punta.getF()][b.Punta.getC()]);
        int i = 0;
        int sum = 0;
        Nodo p = Punta.getLiga();
        while (i < Punta.getF()) {
            int j = 0;
            Nodo q = b.Punta.getLiga();
            while (j < b.Punta.getC()) {
                sum = fMasc(p, q);
                if (sum != 0) {
                    nueva.Insertar(i + "," + j + "," + sum);
                }
                q = q.getLiga();
                j++;
            }
            p = p.getLiga();
            i++;
        }
        this.Punta = nueva.Punta;
    }

    private int fMasc(Nodo cabezeraf, Nodo cabezerac) {
        int sum = 0;
        Nodo p = cabezeraf.getLf();
        Nodo q = cabezerac.getLc();
        while (p != cabezeraf && q != cabezerac) {
            if (p.getC() == q.getF()) {
                sum += p.getDato() * q.getDato();
            }
            if (p.getC() > q.getF()) {
                q = q.getLc();
            } else if (p.getC() < q.getF()) {
                p = p.getLf();
            } else {
                p = p.getLf();
                q = q.getLc();
            }
        }
        return sum;
    }
}
