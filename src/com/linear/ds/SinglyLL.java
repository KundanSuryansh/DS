package com.linear.ds;

class Node<T> {
    private T data;
    private Node link;

    public Node(T data) {
        this.data = data;
        this.link = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }
}

class SinglyLinkList<T> {
    private Node<T> head;

    public SinglyLinkList() {
        this.head = null;
    }

    public void createSinglyLinkList(T[] objs) {
        Node<T> curNode = null;
        for (T obj : objs) {
            Node<T> newNode = new Node<T>(obj);
            if (head == null) {
                curNode = head = newNode;
            } else {
                curNode.setLink(newNode);
                curNode = newNode;
            }

        }
    }

    public void printSinglyLinkList() {
        Node<T> curNode = head;
        System.out.print("[ ");
        while (curNode.getLink() != null) {
            System.out.print(curNode.getData() + ", ");
            curNode = curNode.getLink();
        }
        System.out.println(curNode.getData() + " ]" );
    }

    public void insertFromFront(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setLink(head);
            head = newNode;
        }
    }

    public void insertFromBack(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> curNode = head;
            while (curNode.getLink() != null) {
                curNode = curNode.getLink();
            }
            curNode.setLink(newNode);
        }
    }

    public void searchAnObject(T data){
        if(head == null){
            System.out.println("No object are inserted into Link List");
            return;
        }
        int pos = 1;
        Node<T> curNode = head;
        while (curNode.getLink() != null) {
            if(curNode.getData().equals(data)){
                break;
            }
            curNode = curNode.getLink();
            pos++;
        }
        if(curNode.getData().equals(data)){
            System.out.println("Element found at position : "+pos);
        }

    }
}


public class SinglyLL {
    public static void main(String[] args) {

        SinglyLinkList<Integer> singlyLinkList = new SinglyLinkList<>();
        singlyLinkList.createSinglyLinkList(new Integer[]{1, 2, 4, 5, 3});
        singlyLinkList.printSinglyLinkList();
        singlyLinkList.insertFromFront(new Integer(10));
        singlyLinkList.printSinglyLinkList();
        singlyLinkList.insertFromBack(new Integer(23));
        singlyLinkList.printSinglyLinkList();
        singlyLinkList.searchAnObject(23);
    }

}
