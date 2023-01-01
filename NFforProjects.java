import java.util.Scanner;
import java.util.ArrayList;
public class NFforProjects {



    public static void main(String[] args){

            Scanner scanner = new Scanner(System.in);

            // Read input from the user
            System.out.println("Can you give the numbers of projects: ");
            int n = scanner.nextInt();


            String[] projects = new String[n];
            for (int i = 0; i < n; i++) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                }
                System.out.println("Enter name of the "+ (i+1)+". project:");
                projects[i] = scanner.next();
            }

            int[] outcomes = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.println("Enter outcome of the "+ (i+1) +". project:");
                outcomes[i] = scanner.nextInt();
            }


            Graph graph = new Graph(n);

            System.out.println("give prerequisites in form of (p_i,p_j) " +
                    "which means venture project i cannot be executed unless project j is also executed." +
                    "When you are done with prerequisites and if you want me to decide projects. Write 'decide' :" );
            scanner.nextLine();  // Consume the newline character
            int s=1;
            int s2=3;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("decide")) {
                    break;
                }

                while(scanner.hasNextLine()){
                String u = line.substring(s, s+1);
                String v = line.substring(s2, s2+1);
                graph.addEdge(u, v);
                s=s2+3;
                s2=s+3;

            }}
// Find the maximum outcome and the corresponding path
        ArrayList<String> bestPath = new ArrayList<>();
        for (String project : projects) {
            ArrayList<String> path = new ArrayList<>();
            graph.dfs(projects, outcomes, project, graph.getOutcome(project,projects, outcomes), path, bestPath);
        }

        // Print the results
        System.out.println("Maximum outcome: " + graph.getOutcome(bestPath, outcomes, projects));
        System.out.println("Projects: " + bestPath);
    }
}


