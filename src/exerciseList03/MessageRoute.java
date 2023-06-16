package exerciseList03;


import java.util.*;
import java.util.stream.Collectors;

public class MessageRoute {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ") ;

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        ArrayList<Integer>[] connections = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            connections[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] connectionInput = sc.nextLine().split(" ");
            int computer = Integer.parseInt(connectionInput[0]);
            int connection = Integer.parseInt(connectionInput[1]);

            connections[computer-1].add(connection);
            connections[connection-1].add(computer);
        }

        messageRoute(connections);
    }

    private static void messageRoute(ArrayList<Integer>[] connections) {
        HashMap<Integer, Integer> predecessors = new HashMap<>();
        boolean[] visited = new boolean[connections.length];
        ArrayList<Integer> queue = new ArrayList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int currentComputer = queue.remove(0);

            if (currentComputer == connections.length) {
                printValues(predecessors);
                return;
            }

            visited[currentComputer-1] = true;

            List<Integer> filteredList = connections[currentComputer-1].stream().filter(connection -> !visited[connection-1]).collect(Collectors.toList());

            for (int i : filteredList) {
                if (!queue.contains(i)) {
                    queue.add(i);
                }
            }

            for (int computer : connections[currentComputer-1]) {
                if (!visited[computer-1]) {
                    predecessors.put(computer, currentComputer);
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    private static void printValues(HashMap<Integer, Integer> predecessors) {
        ArrayList<Integer> path = new ArrayList<>();
        int computer = predecessors.size()+1;
        path.add(computer);


         do {
             computer = predecessors.get(computer);
            path.add(computer);
        } while (computer != 1);

         Collections.sort(path);
         StringBuilder output = new StringBuilder();

         for (Integer i : path) {
             output.append(i).append(" ");
         }
        System.out.println(path.size());
        System.out.println(output.toString().trim());
    }
}
