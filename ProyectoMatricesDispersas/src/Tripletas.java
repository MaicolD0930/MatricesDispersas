import java.util.Scanner;

public class Tripletas {
    private int tripleta[][];
    Scanner Basura = new Scanner(System.in);

    public Tripletas() {
    }

    public Tripletas(int[][] Matriz) {
        int i = 0;
        int j = 0;
        int cont = 0;
        for (; i < Matriz.length; i++) {
            j = 0;
            for (; j < Matriz[i].length; j++) {
                if (Matriz[i][j] != 0) {
                    cont++;
                }
            }
        }
        int Tripleta[][] = new int[cont + 1][3];
        Tripleta[0][0] = i;
        Tripleta[0][1] = j;
        Tripleta[0][2] = cont;
        cont = 1;
        for (int k = 0; k < Matriz.length; k++) {
            for (int k2 = 0; k2 < Matriz[k].length; k2++) {
                if (Matriz[k][k2] != 0) {
                    Tripleta[cont][0] = k;
                    Tripleta[cont][1] = k2;
                    Tripleta[cont][2] = Matriz[k][k2];
                    cont++;
                }
            }
        }
        tripleta = Tripleta;
    }

    public void Mostrar() {
        for (int i = 0; i < tripleta.length; i++) {
            for (int j = 0; j < tripleta[i].length; j++) {
                System.out.print("[" + tripleta[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] getTripleta() {
        return tripleta;
    }

    public void setTripleta(int[][] tripleta) {
        this.tripleta = tripleta;
    }

    public void Sumar(Tripletas b) {
        if (tripleta[0][0] == b.tripleta[0][0] && b.tripleta[0][1] == tripleta[0][1]) {
            int k = 1;
            int i = 1;
            int j = 1;
            Tripletas c = new Tripletas();
            c.tripleta = new int[tripleta[0][2] + b.tripleta[0][2]][3];
            while (i < tripleta.length || j < b.tripleta.length) {
                if (i < tripleta.length && j < b.tripleta.length) {
                    if (tripleta[i][0] == b.tripleta[j][0] && b.tripleta[j][1] == tripleta[i][1]) {
                        if (tripleta[i][2] + b.tripleta[j][2] != 0) {
                            c.tripleta[k][0] = tripleta[i][0];
                            c.tripleta[k][1] = tripleta[i][1];
                            c.tripleta[k][2] = tripleta[i][2] + b.tripleta[j][2];

                            k++;
                        }
                        j++;
                        i++;
                    } else {
                        if (tripleta[i][0] == b.tripleta[j][0] && b.tripleta[j][1] > tripleta[i][1]) {
                            c.tripleta[k][0] = tripleta[i][0];
                            c.tripleta[k][1] = tripleta[i][1];
                            c.tripleta[k][2] = tripleta[i][2];
                            k++;
                            i++;
                        } else if (tripleta[i][0] == b.tripleta[j][0] && b.tripleta[j][1] < tripleta[i][1]) {
                            c.tripleta[k][0] = b.tripleta[j][0];
                            c.tripleta[k][1] = b.tripleta[j][1];
                            c.tripleta[k][2] = b.tripleta[j][2];
                            k++;
                            j++;
                        } else if (tripleta[i][0] > b.tripleta[j][0]) {
                            c.tripleta[k][0] = b.tripleta[j][0];
                            c.tripleta[k][1] = b.tripleta[j][1];
                            c.tripleta[k][2] = b.tripleta[j][2];
                            k++;
                            j++;
                        } else {
                            c.tripleta[k][0] = tripleta[i][0];
                            c.tripleta[k][1] = tripleta[i][1];
                            c.tripleta[k][2] = tripleta[i][2];
                            k++;
                            i++;
                        }
                    }
                } else if (i < tripleta.length) {
                    c.tripleta[k][0] = tripleta[i][0];
                    c.tripleta[k][1] = tripleta[i][1];
                    c.tripleta[k][2] = tripleta[i][2];
                    k++;
                    i++;
                } else {
                    c.tripleta[k][0] = b.tripleta[j][0];
                    c.tripleta[k][1] = b.tripleta[j][1];
                    c.tripleta[k][2] = b.tripleta[j][2];
                    k++;
                    j++;
                }
            }
            c.tripleta[0][0] = tripleta[0][0];
            c.tripleta[0][1] = tripleta[0][1];
            c.tripleta[0][2] = k - 1;
            c.Redimensionar();
            c.Mostrar();
        } else {
            System.out.println("Las matrices son de diferente tamaño, no se pueden sumar");
        }
    }

    public void Redimensionar() {
        Tripletas nuevo = new Tripletas();
        nuevo.tripleta = new int[tripleta[0][2] + 1][3];
        for (int i = 0; i < nuevo.tripleta.length; i++) {
            nuevo.tripleta[i][0] = tripleta[i][0];
            nuevo.tripleta[i][1] = tripleta[i][1];
            nuevo.tripleta[i][2] = tripleta[i][2];
        }
        tripleta = nuevo.tripleta;
    }

    public void Eliminar() {
        boolean bandera;
        int opc;
        do {
            System.out.println(
                    "ingrese 1, 2 o 3 si quieres eliminar por dato, posicion o posicion y dato respectivamente");
            opc = Basura.nextInt();
            bandera = false;
            switch (opc) {
                case 1:
                    System.out.println("ingrese el dato a eliminar");
                    int dato = Basura.nextInt();
                    for (int i = 1; i < tripleta.length; i++) {
                        if (tripleta[i][2] == dato) {
                            bandera = true;
                            for (int j = i; j + 1 < tripleta.length; j++) {
                                tripleta[j][0] = tripleta[j + 1][0];
                                tripleta[j][1] = tripleta[j + 1][1];
                                tripleta[j][2] = tripleta[j + 1][2];
                            }
                            tripleta[0][2]--;
                        }
                    }
                    break;
                case 2:
                    System.out.println(
                            "ingrese primero las filas, y luego las columnas, ejemplo: (1,2) uno es las filas y dos las columnas");
                    String cadena = Basura.next();
                    String[] componentes = cadena.split(",");
                    if (Integer.parseInt(componentes[0]) < tripleta[0][0]
                            && Integer.parseInt(componentes[1]) < tripleta[0][1]) {
                        for (int i = 1; i < tripleta.length; i++) {
                            if (Integer.parseInt(componentes[0]) == tripleta[i][0]
                                    && Integer.parseInt(componentes[1]) == tripleta[i][1]) {
                                bandera = true;
                                for (int j = i; j + 1 < tripleta.length; j++) {
                                    tripleta[j][0] = tripleta[j + 1][0];
                                    tripleta[j][1] = tripleta[j + 1][1];
                                    tripleta[j][2] = tripleta[j + 1][2];
                                }
                                tripleta[0][2]--;
                                i = tripleta.length;
                            }
                        }
                    }

                    break;
                case 3:
                    System.out.println(
                            "ingrese primero las filas, luego las columnas, y por ultimo el dato, ejemplo: (1,2,3) uno es las filas, dos las columnas y 3 el dato");
                    cadena = Basura.next();
                    String[] comp = cadena.split(",");
                    if (Integer.parseInt(comp[0]) < tripleta[0][0] && Integer.parseInt(comp[1]) < tripleta[0][1]) {
                        for (int i = 1; i < tripleta.length; i++) {
                            if (Integer.parseInt(comp[0]) == tripleta[i][0]
                                    && Integer.parseInt(comp[1]) == tripleta[i][1]
                                    && Integer.parseInt(comp[2]) == tripleta[i][2]) {
                                bandera = true;
                                for (int j = i; j + 1 < tripleta.length; j++) {
                                    tripleta[j][0] = tripleta[j + 1][0];
                                    tripleta[j][1] = tripleta[j + 1][1];
                                    tripleta[j][2] = tripleta[j + 1][2];
                                }
                                tripleta[0][2]--;
                                i = tripleta.length;
                            }
                        }
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
        Redimensionar();
    }

    public void SumarF() {
        for (int i = 0; i < tripleta[0][0]; i++) {
            int f = 0;
            for (int j = 1; j < tripleta.length; j++) {
                if (tripleta[j][0] == i) {
                    f += tripleta[j][2];
                }
            }
            System.out.println("La suma de la fila " + i + " es: " + f);
        }
    }

    public void SumarC() {
        for (int i = 0; i < tripleta[0][1]; i++) {
            int f = 0;
            for (int j = 1; j < tripleta.length; j++) {
                if (tripleta[j][1] == i) {
                    f += tripleta[j][2];
                }
            }
            System.out.println("La suma de la columna " + i + " es: " + f);
        }
    }

    public void Insertar() {
        System.out.println(
                "ingrese primero las filas, luego las columnas, y por ultimo el dato, ejemplo: (1,2,3) uno es las filas, dos las columnas y 3 el dato");
        String cadena = Basura.next();
        String[] comp = cadena.split(",");
        int dato = Integer.parseInt(comp[2]);
        int c = Integer.parseInt(comp[1]);
        int f = Integer.parseInt(comp[0]);
        if (f < tripleta[0][0] && c < tripleta[0][1]) {
            boolean bandera = false;
            for (int i = 1; i < tripleta.length && !bandera; i++) {
                if (tripleta[i][0] == f && tripleta[i][1] == c) {
                    bandera = true;
                    System.out.println(
                            "Se encontro un valor en esa posicion, ingrese 1 para reemplazarlo, o 2 para sumarlos");
                    int valor;
                    do {
                        valor = Basura.nextInt();
                        switch (valor) {
                            case 1:
                                tripleta[i][2] = dato;
                                break;
                            case 2:
                                tripleta[i][2] += dato;
                                break;
                            default:
                                System.out.println("No seas idiota, coloca un 1 o 2, usuario de mierda");
                                break;
                        }
                    } while (valor != 1 && valor != 2);
                }
            }
            if (!bandera) {
                Tripletas nueva = new Tripletas();
                nueva.tripleta = new int[tripleta.length + 1][3];
                int aux = 0;
                for (int i = 0; i < tripleta.length; i++) {
                    nueva.tripleta[i + aux][0] = tripleta[i][0];
                    nueva.tripleta[i + aux][1] = tripleta[i][1];
                    nueva.tripleta[i + aux][2] = tripleta[i][2];
                    if (i > 0) {
                        if ((tripleta[i][0] == f && tripleta[i][1] > c || tripleta[i][0] > f) && !bandera) {
                            aux++;
                            bandera = !bandera;
                            nueva.tripleta[i + aux][0] = tripleta[i][0];
                            nueva.tripleta[i + aux][1] = tripleta[i][1];
                            nueva.tripleta[i + aux][2] = tripleta[i][2];
                            nueva.tripleta[i][0] = f;
                            nueva.tripleta[i][1] = c;
                            nueva.tripleta[i][2] = dato;
                        }
                    }
                }
                if (!bandera) {
                    nueva.tripleta[nueva.tripleta.length - 1][0] = f;
                    nueva.tripleta[nueva.tripleta.length - 1][1] = c;
                    nueva.tripleta[nueva.tripleta.length - 1][2] = dato;
                }
                nueva.tripleta[0][2]++;
                tripleta = nueva.tripleta;
            }
        } else {
            System.out.println(
                    "La matriz no es lo suficientemente grande para insertar ese dato");
        }
    }

    public void Multiplicar(Tripletas b) {
        Tripletas nueva = new Tripletas();
        nueva.tripleta = new int[(tripleta[0][0]*b.tripleta[0][1])+1][3];
        nueva.tripleta[0][0] = tripleta[0][0];
        nueva.tripleta[0][1] = b.tripleta[0][1];
        int k = 0;
        for (int i = 0; i < tripleta[0][0]; i++) {
            for (int j = 0; j < b.tripleta[0][1]; j++) {
                nueva.tripleta[k+1][2] = fMasc(tripleta, b.tripleta, i, j);
                if(nueva.tripleta[k+1][2] != 0){
                    nueva.tripleta[k+1][0] = i;
                    nueva.tripleta[k+1][1] = j;
                    k++;
                }
            }
        }
        nueva.tripleta[0][2] = k;
        nueva.Redimensionar();
        tripleta = nueva.tripleta;
    }

    private int fMasc(int[][] a,int[][] b,int f,int c){
        int sum = 0;
        for (int i = 1;i < a.length; i++) {
            for (int j = 1; a[i][0] == f && j < b.length; j++) {
                if(a[i][1] == b[j][0] && b[j][1] == c){
                    sum += a[i][2]*b[j][2];
                }
            }
        }
        return sum;
    }
}
