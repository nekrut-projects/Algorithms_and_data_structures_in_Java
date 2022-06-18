package lesson_7;

import lesson_3.Queue;
import lesson_3.Stack;

public class Graph {
    private Vertex[] listVertices;
    private int[][] adjMatrix;
    private int size;
    private Stack stack;
    private Queue queue;

    public Graph(int maxAmountVortex) {
        this.listVertices = new Vertex[maxAmountVortex];
        this.adjMatrix = new int[maxAmountVortex][maxAmountVortex];
        this.size = 0;

        for (int i = 0; i < maxAmountVortex; i++) {
            for (int j = 0; j < maxAmountVortex; j++) {
                adjMatrix[i][j] = 0;
            }
        }
        this.stack = new Stack(maxAmountVortex);
        this.queue = new Queue(maxAmountVortex);
    }

    public void addVertex(char label) {
        listVertices[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void addEdge(char start, char end) {
        int s = findVertex(start);
        int e = findVertex(end);
        addEdge(s, e);
    }

    public void displayVertex(int vertex) {
        System.out.printf("%4s[i%d] ",listVertices[vertex], vertex);
    }

    private int findVertex(char c) {
        for (int i = 0; i < size; i++) {
            if (listVertices[i].label == c) {
                return i;
            }
        }
        return -1;
    }

    private int getUnvisited(int v) {
        for (int i = 0; i < size; i++) {
            if (!listVertices[i].wasVisited && adjMatrix[v][i] == 1) {
                return i;
            }
        }
        return -1;
    }

    public void depthTraversal () {
        stack.push(0);
        displayVertex(0);
        listVertices[0].wasVisited = true;

        while (!stack.isEmpty()) {
            int v = getUnvisited(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                listVertices[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        resetVertices();
    }

    public void widthTraversal () {
        queue.insert(0);
        displayVertex(0);
        listVertices[0].wasVisited = true;
        int temp;

        while (!queue.isEmpty()) {
            int v = queue.remove();
            while ((temp = getUnvisited(v)) != -1) {
                queue.insert(temp);
                displayVertex(temp);
                listVertices[temp].wasVisited = true;
            }
        }
        resetVertices();
    }

    public int size() {
        return size;
    }

    public void findShortPath (char beginVer, char endVer) {
        int begin = findVertex(beginVer);
        int end = findVertex(endVer);
        int[] steps = new int[size];

        queue.insert(begin);
        listVertices[begin].wasVisited = true;
        steps[begin] = 0;

        int temp;

        while (!queue.isEmpty()) {
            int v = queue.remove();
            while ((temp = getUnvisited(v)) != -1) {
                queue.insert(temp);
                listVertices[temp].wasVisited = true;
                steps[temp] = steps[v] + 1;

                if (temp == end){
                    break;
                }
            }
        }

        int amountVer = steps[end] + 1;
        int[] shortPath = new int[amountVer];
        shortPath[amountVer - 1] = end;
        int currVer = end;

        for (int i = amountVer - 1; i > 0;/* --i*/) {   // так i не уменьшается
            --i;              //а так все нормально работает, все меньше и меньше понимаю работу fori
            for (int j = 0; j < size; j++) {
                if (adjMatrix[currVer][j] == 1 && i == steps[j]){
                    shortPath[i] = j;
                    currVer = j;
                    break;
                }
            }
        }
        resetVertices();
        for (int i = 0; i < shortPath.length; i++) {
            System.out.printf(i == 0 ? "\n%s ": "-> %s ", listVertices[shortPath[i]]);
        }
    }

    private void resetVertices () {
        for (int i = 0; i < size; i++) {
            listVertices[i].wasVisited = false;
        }
    }

    private class Vertex {
        private char label;
        private boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            this.wasVisited = false;
        }

        @Override
        public String toString() {
            return "V{" + label +'}';
        }
    }
}
