package exerciseList03;

import java.util.ArrayList;
import java.util.Scanner;

public class BuildingRoads {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in)
        String[] input = sc.nextLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int tamanho = n+1;
        boolean[] visitados = new boolean[tamanho];
        ArrayList<Integer> componentes = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjacencias = new ArrayList<>();
        for (int i = 0; i < tamanho; i++) {
            adjacencias.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = sc.nextLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            adjacencias.get(u).add(v);
            adjacencias.get(v).add(u);
        }

        ArrayList<Integer> fila = new ArrayList<>();

        acharComponentes();

        ArrayList<Integer> novasArestas = new ArrayList<>();
        Integer primeiroVertice = componentes.get(0);

        for (int i = 1; i < componentes.size(); i++) {
            novasArestas.add();
        }
    }
}
