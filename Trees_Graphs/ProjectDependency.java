import java.util.*;
public class ProjectDependency {

    public static void main(String[] args) {
        Project a = new Project("a");
        Project b = new Project("b");
        Project c = new Project("c");
        Project d = new Project("d");
        Project e = new Project("e");
        Project f = new Project("f");
        Graph g = new Graph(Arrays.asList(a, b, c, d, e, f));
        g.addDependency(a, d);
        g.addDependency(f, b);
        g.addDependency(b, d);
        g.addDependency(f, a);
        g.addDependency(d, c);
        List<Project> result = g.buildOrder();
        for (Project p : result) {
            System.out.println(p.name);
        }
    }
    
}

class Project {
    String name;

    public Project(String name) {
        this.name = name;
    }
}

class Graph {
    private List<Project> projects;
    private List<Dependency> dependencies;
    private Map<String, List<Project>> adj;

    public Graph(List<Project> projects) {
        this.projects = projects;
        adj = new HashMap();
        for (Project p : projects) {
            adj.put(p.name, new LinkedList());
        }
        this.dependencies = new LinkedList();
    }

    public void addDependency(Project parent, Project child) {
        dependencies.add(new Dependency(parent, child));
        adj.get(parent.name).add(child);
    }

    public List<Project> buildOrder() {
        Set<String> visited = new HashSet();
        List<Project> result = new LinkedList();
        for (Project p : projects) {
            if (!visited.contains(p.name)) dfsUtil(result, visited, p);
        }
        return result;
    }

    private void dfsUtil(List<Project> result, Set<String> visited, Project p) {
        visited.add(p.name);
        for (Project neighbor : adj.get(p.name)) {
            if (!visited.contains(neighbor.name)) dfsUtil(result, visited, neighbor);
        }
        result.add(0, p);
    }
}

class Dependency {
    Project parent;
    Project child;

    public Dependency(Project parent, Project child) {
        this.parent = parent;
        this.child = child;
    }
}