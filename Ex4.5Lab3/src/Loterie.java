import javax.swing.*;
import java.util.Scanner;

// Loterie 6/49

public class Loterie {
    private int n;

    public Loterie(int n) {
        this.n = n;
    }

    public int Factorial(int n) {
        if (n == 1 || n == 0) return 1;
        return n * Factorial(n - 1);
    }

    public double Sanse(int n) {
        return n / (double) 13983816;
    }

    public static void main(String[] args) {
        String nStr;
        int n;
        int[] m = new int[6];

        nStr = JOptionPane.showInputDialog(null, "Enter the number of combinations you want to play:");
        n = Integer.parseInt(nStr);
        Loterie loterie = new Loterie(n);
        double sanse = loterie.Sanse(n);
        JOptionPane.showMessageDialog(null, "Sanse: " + String.format("%.10f", sanse));

        int minim = 1;
        int maxim = 49;

        for (int i = 0; i < n; i++) {
            System.out.println("\nCombinatie numar: " + (i + 1));
            Scanner sc = new Scanner(System.in);
            for (int j = 0; j < 6; j++) {
                m[j] = sc.nextInt();
            }
            long numar = 1;
            for (int k = 0; k < 6; k++) {
                int random = (int) (Math.random() * (maxim - minim + 1) + minim);
                long copie = numar;
                if (copie != random) {
                    numar |= (1L << random);
                }
                System.out.print(random + " ");
            }

            System.out.println("\nDescrescator: ");
            for (int j = 49; j >= 1; j--) {
                if ((numar & (1L << j)) != 0) {
                    System.out.print(j + " ");
                }
            }

                System.out.println("\nCrescator: ");
                for (int ab = 1; ab <= 49; ab++) {
                    if ((numar & (1L << ab)) != 0) {
                        System.out.print(ab + " ");
                    }
                }

            }
        }
    }


