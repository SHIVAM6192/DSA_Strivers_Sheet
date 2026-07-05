package DisjointSetUnion;

class DisjointSetUnion{
    int n;
    int[] par;
    int[] rank;

    DisjointSetUnion(int n){
        this.n = n;
        par = new int[this.n];
        rank = new int[this.n];
        for (int i = 0; i<n; i++){
            par[i] = i;
            rank[i] = 0;
        }
    }

    public void unionByRank(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if (parA == parB) return;

        if (rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }
        else if (rank[parA] > rank[parB]){
            par[parB] = parA;
        }
        else {
            par[parA] = parB;
        }
    }

    public int find(int x){
        if (par[x] == x){
            return x;
        }

        return par[x] = find(par[x]);  // Path compression
    }

    void getInfo(){
        for (int i = 0; i < this.n; i++){
            System.out.print(par[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < this.n; i++){
            System.out.print(rank[i] + " ");
        }
    }

}
public class Main {
    public static void main(String[] args) {
        DisjointSetUnion dsu = new DisjointSetUnion(6);

        dsu.unionByRank(0, 2);
        System.out.println(dsu.find(2));

        dsu.unionByRank(1,3);
        dsu.unionByRank(2,5);
        dsu.unionByRank(0,3);
        System.out.println(dsu.find(2));

        dsu.unionByRank(0,4);

        dsu.getInfo();
    }
}
