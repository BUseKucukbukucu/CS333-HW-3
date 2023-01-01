import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Graph extends NFforProjects{
    int numVertices;
    HashMap<String, List<String>> adjList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new HashMap<>();
    }

    public void addEdge(String u, String v) {
        if (!adjList.containsKey(u)) {
            adjList.put(u, new ArrayList<>());
        }
        adjList.get(u).add(v);
    }


    public void dfs(String[] projects, int[] outcomes, String start, int maxOutcome, List<String> path, List<String> bestPath) {
        path.add(start);
        if (path.size() > bestPath.size() || (path.size() == bestPath.size() && maxOutcome > getOutcome(bestPath, outcomes, projects))) {
            bestPath.clear();
            bestPath.addAll(path);
        }
        for (String neighbor : adjList.get(start)) {
            dfs(projects, outcomes, neighbor, maxOutcome + getOutcome(neighbor,projects, outcomes), path, bestPath);
        }
        path.remove(path.size() - 1);
    }

    public int getOutcome(String project, String[] projects, int[] outcomes) {
        int index = -1;
        for (int i = 0; i < projects.length; i++) {
            if (projects[i].equals(project)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return 0;
        }
        return outcomes[index];
    }


    public int getOutcome(List<String> path, int[] outcomes, String[] projects) {
        int outcome = 0;
        for (String project : path) {
            outcome += getOutcome(project, projects, outcomes);
        }
        return outcome;
    }}


