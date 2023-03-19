class Tree {
    node root;
    public Boolean is (int n) {
        node x = search(n);
        if (x == null) return false;
        else return true;
    }

    public node search(int n) {
        node x = root;
        while(x != null) {
            if(n == x.get()) return x;
            else if(n > x.get()) x = x.right();
            else x = x.left();
        }
        return null;
    }
    
    public void inorder() {
        root.inorder();
    }

    public void delete(int n) {
        node x = search(n);
        node p = x.parent();
        if(x.leaf()){ 
            if(x == p.right()) p.rattach(null);
            else p.lattach(null);
            return;
        }
        if(x.right() == null) {
            if(x == p.right()) p.rattach(x.left());
            else p.lattach(x.left());
            return;
        }
        if(x.left() == null) {
            if(x == p.right()) p.rattach(x.right());
            else p.lattach(x.right());
            return;
        }
        node suc = x.succ();
        x.set(suc.get());
        node q = suc.parent();
        if(suc == q.right()) q.rattach(null);
        else q.lattach(null);
    }

    public void insert(int n) {
        if(root == null) root = new node(n, null);
        node cu = root;
        while(cu != null) {
            if (n == cu.get()) return;
            if (n > cu.get()) {
                if (cu.right() == null) cu.rattach(n);
                else cu = cu.right();
            } else {
                if (cu.left() == null) cu.lattach(n);
                else cu = cu.left();
            }
        }
    }

}

class node {
    int n;
    node l;
    node r;
    node p;
    public node left() {return l;}
    public node parent() {return p;}
    public Boolean leaf() {return r == null && l == null;}
    public node lattach(int n) {node t = l; l = new node(n, this); return t;}
    public node lattach(node x) {node t = l; l = x; if(x != null) x.from(this); return t;}
    public void from(node p) {this.p = p;}
    public node rattach(int n) {node t = r; r = new node(n, this); return t;}
    public node rattach(node x) {node t = r; r = x; if(x != null) x.from(this); return t;}
    public node right() {return r;}
    
    public int get() {return n;}
    public void set(int n_other) {n = n_other;}
    public node(int n, node p) {this.n = n; l = null; r = null; this.p = p;}
    public void inorder() {
        if (l != null) l.inorder();
        System.out.println(n);
        if (r != null) r.inorder();
    }

    public node succ() {
        node x = r;
        while(x.left() != null) x = x.left();

        return x;
    }
}

public class bst{
    public static void main(String[] args) {
        Tree t = new Tree();
        t.insert(2);
        t.insert(4);
        t.insert(6);
        t.insert(1);
        t.insert(3);
        t.insert(5);
        t.insert(7);
        System.out.println(t.is(0));
        System.out.println(t.is(1));
        t.inorder();
        t.delete(4);
        t.delete(2);
        t.inorder();
    }
}