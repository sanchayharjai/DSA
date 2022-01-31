package DataStructures;

public class DisjointSet {
    private int size;
    private int[] id;
    private int[] sz;
    private int numComponents;
    public DisjointSet(int size){
        if(size < 0) throw new IllegalArgumentException();
        this.size = numComponents = size;
        sz = new int[size];
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }
    public int find(int p){
        if(id[p] == p) return p;
        return id[p] = find(id[p]);
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public int componentSize(int p){
        return sz[find(p)];
    }
    public int components(){
        return numComponents;
    }
    public void union(int p, int q){
        if(connected(p,q)) return;
        int root1 = find(p);
        int root2 = find(q);
        if (sz[root1] < sz[root2]) {
            sz[root2] += sz[root1];
            id[root1] = root2;
            sz[root1] = 0;
        } else {
            sz[root1] += sz[root2];
            id[root2] = root1;
            sz[root2] = 0;
        }
        numComponents--;
    }
}
