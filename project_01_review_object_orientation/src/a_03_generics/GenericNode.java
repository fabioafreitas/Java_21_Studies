package a_03_generics;


public class GenericNode<T> {
    private T value;
    private GenericNode<T> nextNode;

    public GenericNode(GenericNode<T> nextNode, T value) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public T getValue() {
        return this.value;
    }

    public GenericNode<T> getNextNode() {
        return this.nextNode;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNextNode(GenericNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public boolean equals(Object evalNode) {
        if (this == evalNode) return true;
        if (evalNode == null || getClass() != evalNode.getClass()) return false;
        
        // casting to test object, since Object is of current class type
        GenericNode<?> other = (GenericNode<?>) evalNode;
        return (value == null) ? other.value == null : value.equals(other.value);
    }

    public GenericNode<T> findByValueIterative(GenericNode<T> paramNode,T searchValue) {
        if(this.nextNode.equals(paramNode)) {
            return this.nextNode;
        }
        GenericNode<T> currentNode = paramNode;
        while(currentNode != null) {
            if(currentNode.getValue().equals(searchValue)) {
                return currentNode;
            }
            currentNode.setNextNode(currentNode.getNextNode());
        }
        return null;
    }

    public void printListContent() {
        GenericNode<T> currentNode = this;
        while(currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode.setNextNode(currentNode.getNextNode());
        }
    }
}
