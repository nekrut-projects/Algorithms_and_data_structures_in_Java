package lesson_7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(12);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('I');
        graph.addVertex('J');
        graph.addVertex('K');

        graph.addEdge('A', 'C');
        graph.addEdge('C', 'D');
        graph.addEdge('C', 'F');
        graph.addEdge('F', 'J');
        graph.addEdge('J', 'K');
        graph.addEdge('D', 'B');
        graph.addEdge('B', 'E');
        graph.addEdge('D', 'E');
        graph.addEdge('E', 'I');
        graph.addEdge('G', 'J');
        graph.addEdge('G', 'H');
        graph.addEdge('I', 'K');

        graph.widthTraversal();

        graph.findShortPath('A', 'K');

    }
}
