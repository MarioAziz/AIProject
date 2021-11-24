package code;
import java.util.*;
public class MyTreeNode<T>{
    public T value = null;
    
    public String action;
    public List<MyTreeNode<T>> children = new ArrayList<>();
    private MyTreeNode<T> parent = null;

    public MyTreeNode(T value,String action) {
        this.value = value;
        this.action=action;
    }

    public void addChild(MyTreeNode<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T value,String action) {
        MyTreeNode<T> newChild = new MyTreeNode<T>(value,action);
        this.addChild(newChild);
    }

    public void addChildren(List<MyTreeNode<T>> children) {
        for(MyTreeNode<T> t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<MyTreeNode<T>> getChildren() {
        return children;
    }

    public T getvalue() {
        return value;
    }

    public void setvalue(T value) {
        this.value = value;
    }

    public void setParent(MyTreeNode<T> parent) {
        this.parent = parent;
    }

    public MyTreeNode<T> getParent() {
        return parent;
    }
    public int getLevel(MyTreeNode<T> parent){
        int lvl=0;

        while(parent.getParent()!=null){
            parent=parent.getParent();
            lvl++;
        }
        return lvl;

    }
}