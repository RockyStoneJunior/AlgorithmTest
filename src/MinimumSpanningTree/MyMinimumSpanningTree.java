package MinimumSpanningTree;

public class MyMinimumSpanningTree {

    private static final int V = 5;

    public static void main(String[] args){

        int[][] graph = new int[][]{
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };
    }

    int minKey(int key[], Boolean mstSet[]){
        int min = Integer.MAX_VALUE, min_index = -1;

        for(int v = 0; v < V; v++){
            if(mstSet[v] == false && key[v] < min){
                min = key[v];
                min_index = v;
            }
        }

        return min_index;
    }


    /*
     *  mstSet = [F, F, F, F, F]  vertices that are not in mst
     *  parent = [-1,0, 1, 0, 1]  from parent[i] to index i, that's to say graph[parent[i]][i]
     *            0  1  2  3  4   index of arrays
     *  key    = [0, 2, 3, 6, 5]  Key values used to pick minimum weight edge in cut
     *
     */

    void primMST(int[][] graph){
        int parent[] = new int[V];

        int key[] = new int[V];

        Boolean mstSet[] = new Boolean[V];

        for(int i = 0; i < V; i++){
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for(int count =  0; count < V - 1; count++){

            int u  = minKey(key, mstSet);

            mstSet[u] = true;


            for(int v = 0; v < V; v++){

                if(graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]){
                    parent[v] = u;
                    key[v] = graph[u][v];
                }

            }
        }
    }
}
