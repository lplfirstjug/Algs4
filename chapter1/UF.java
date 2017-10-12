package chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public abstract class UF{

    int[] id;
    int count;

    public UF(int n){
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i]=i;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p,int q){
        return find(p)==find(q);
    }

    abstract int find(int p);
    abstract void union(int p,int q);

    private static void UF_test(UF uf,int N){
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p,q)){
                continue;
            }
            uf.union(p,q);
            StdOut.println(p+" "+q);
        }
        StdOut.println(uf.count()+" components");
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf=new SQuickUnion(N);
        UF_test(uf,N);
    }
}

class QuickFind extends UF {

    public QuickFind(int n){
        super(n);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) id[i] = qID;
        }
        count--;
    }
}

class QuickUnion extends UF{

    public QuickUnion(int N){
        super(N);
    }

    @Override
    public int find(int p) {
        while (p!=id[p]){
            p=id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot==qRoot){
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }
}

class SQuickUnion extends UF{

    private int[] sz;

    public SQuickUnion(int n) {
        super(n);
        sz = new int[n];
    }

    @Override
    int find(int p) {
        while (p!=id[p]){
            p=id[p];
        }
        return p;
    }

    @Override
    void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i==j){
            return;
        }
        if (sz[i]<sz[j]){
            id[i]=j;
            sz[j]+=sz[i];
        }
        else {
            id[j]=i;
            sz[i]+=sz[j];
        }
        count--;
    }
}