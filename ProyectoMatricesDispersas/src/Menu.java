import java.util.Random;
import java.util.Scanner;

public class Menu {
    private Scanner escaner = new Scanner(System.in);

    public Menu() {
    }

    public int[][] Matriz(int f, int c) {
        Random aleatorio = new Random();
        if (f == 0) {
            f = aleatorio.nextInt(5) + 1;
        }
        if (c == 0) {
            c = aleatorio.nextInt(5) + 1;
        }
        int[][] matriz = new int[f][c];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                boolean bandera = aleatorio.nextBoolean();
                if (bandera) {
                    int N = aleatorio.nextInt(100) + 1;
                    matriz[i][j] = N;
                }
            }
        }
        return matriz;
    }

    public void MenuPrincipal(int[][] Matriz, int id) {
        int opc;
        Tripletas T = new Tripletas(Matriz);
        Forma1 F1 = new Forma1(Matriz);
        Forma2 F2 = new Forma2(Matriz);
        System.out.println("------------Bienvenido-------------");
        do {
            System.out.println("1. Mostrar\n" +
                    "2. Suma de filas\n" +
                    "3. Suma de columnas\n" +
                    "4. Insertar dato\n" +
                    "5. Eliminar dato\n" +
                    "6. Suma con otra matriz generada aleatoriamente\n" +
                    "7. Multiplicacion con otra matriz generada aleatoriamente\n" +
                    "8. tripleta * froma 2 = forma 1\n" +
                    "0. Salir");
            opc = escaner.nextInt();
            switch (opc) {
                case 1:
                    switch (id) {
                        case 1:
                            T.Mostrar();
                            break;
                        case 2:
                            F1.Mostrar();
                            break;
                        case 3:
                            F2.Mostrar();
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    switch (id) {
                        case 1:
                            T.SumarF();
                            break;
                        case 2:
                            F1.SumarF();
                            break;
                        case 3:
                            F2.SumarF();
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    switch (id) {
                        case 1:
                            T.SumarC();
                            break;
                        case 2:
                            F1.SumarC();
                            break;
                        case 3:
                            F2.SumarC();
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    switch (id) {
                        case 1:
                            T.Insertar();
                            break;
                        case 2:
                            F1.Insertar("");
                            break;
                        case 3:
                            F2.Insertar("");
                            break;
                        default:
                            break;
                    }
                    break;
                case 5:
                    switch (id) {
                        case 1:
                            T.Eliminar();
                            break;
                        case 2:
                            F1.Eliminar();
                            break;
                        case 3:
                            F2.Eliminar();
                            break;
                        default:
                            break;
                    }
                    break;
                case 6:
                    switch (id) {
                        case 1:
                            T.Sumar(new Tripletas(MenuCreacionMatriz(T.getTripleta()[0][0], T.getTripleta()[0][1])));
                            break;
                        case 2:
                            F1.Sumar(new Forma1(MenuCreacionMatriz(F1.getPunta().getF(), F1.getPunta().getC())));
                            break;
                        case 3:
                            F2.Sumar(new Forma2(MenuCreacionMatriz(F2.getPunta().getF(), F2.getPunta().getC())));
                            break;
                        default:
                            break;
                    }
                    break;
                case 7:
                    switch (id) {
                        case 1:
                            T.Multiplicar(new Tripletas(MenuCreacionMatriz(T.getTripleta()[0][1], 0)));
                            break;
                        case 2:
                            F1.Multiplicar(new Forma1(MenuCreacionMatriz(F1.getPunta().getC(), 0)));
                            break;
                        case 3:
                            F2.Multiplicar(new Forma2(MenuCreacionMatriz(F2.getPunta().getC(), 0)));
                            break;
                        default:
                            break;
                    }
                    break;
                case 8:
                    OperacionEspecial();
                    break;
                case 0:

                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;
            }

        } while (opc != 0);
    }

    public int[][] MenuCreacionMatriz(int f, int c) {
        int opc;
        int[][] matriz;
        System.out.println("Se a generado esta matriz aleatoriamente");
        do {
            matriz = Matriz(f, c);
            System.out.println(MostrarMatriz(matriz));
            System.out.println("Escribe 1 si la quieres usar, o cualquier otro numero si quieres generar otra");
            opc = escaner.nextInt();
        } while (opc != 1);
        return matriz;
    }

    public void MenuCreacion() {
        int opc;
        int[][] matriz = MenuCreacionMatriz(0, 0);
        do {
            System.out.println(
                    "Escriba 1, si quieres convertir la matriz en Tripletas, 2 para forma 1, y 3 para forma 2");
            opc = escaner.nextInt();
            if (opc == 1 || opc == 2 || opc == 3) {
                MenuPrincipal(matriz, opc);
            } else {
                System.out.println("Opcion Incorrecta");
            }

        } while (opc != 1 && opc != 2 && opc != 3);
    }

    private String MostrarMatriz(int[][] Matriz) {
        String cadena = "";
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz[0].length; j++) {
                cadena += "[" + Matriz[i][j] + "]";
            }
            cadena += "\n";
        }
        return cadena;
    }

    public void OperacionEspecial() {
        int[][] mtri = Matriz(0, 0);
        int[][] mf2 = Matriz(mtri[0].length, 0);
        System.out.println(MostrarMatriz(mtri));
        System.out.println("X\n");
        System.out.println(MostrarMatriz(mf2));
        System.out.println("=\n");
        Tripletas tripleta = new Tripletas(mtri);
        Forma2 f2 = new Forma2(mf2);
        Forma1 f1 = new Forma1(new int[tripleta.getTripleta()[0][0]][f2.getPunta().getC()]);
        int sum =0;
        for (int i = 0; i < tripleta.getTripleta()[0][0]; i++) {
            int j = 0;
            while (j < f2.getPunta().getC()) {
                sum = fMasc(tripleta.getTripleta(), f2.getPunta(), i, j);
                if (sum != 0) {
                    f1.Insertar(i + "," + j + "," + sum);
                }
                j++;
            }
        }
        f1.Mostrar();
    }

    private int fMasc(int[][] a, Nodo b, int f, int c){
        int sum = 0;
        for (int i = 1;i < a.length; i++) {
            Nodo p = b.getLc();
            while (a[i][0] == f && p.getC() <= c && p != b) {
                if(a[i][1] == p.getF() && p.getC() == c){
                    sum += a[i][2]*p.getDato();
                }
                p = p.getLc();
            }
        }
        return sum;
    }

}
