import java.util.*;
public class MyTreeNode<T>{
    public T value = null;
    public String action;
    private List<MyTreeNode> children = new ArrayList<>();
    private MyTreeNode parent = null;

    public MyTreeNode(T value,String action) {
        this.value = value;
        this.action=action;
    }

    public void addChild(MyTreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T value,String action) {
        MyTreeNode<T> newChild = new MyTreeNode<>(value,action);
        this.addChild(newChild);
    }

    public void addChildren(List<MyTreeNode> children) {
        for(MyTreeNode t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<MyTreeNode> getChildren() {
        return children;
    }

    public T getvalue() {
        return value;
    }

    public void setvalue(T value) {
        this.value = value;
    }

    private void setParent(MyTreeNode parent) {
        this.parent = parent;
    }

    public MyTreeNode getParent() {
        return parent;
    }
}