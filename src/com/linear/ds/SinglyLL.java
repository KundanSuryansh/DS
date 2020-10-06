package com.linear.ds;

/**
 * @author Kundan Suryansh
 */
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
        System.out.println(curNode.getData() + " ]");
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

    public void searchAnObject(T data) {
        boolean isElementPresent = false;
        if (head == null) {
            System.out.println("No object are inserted into Link List");
            return;
        }
        int pos = 1;
        Node<T> curNode = head;
        while (curNode != null) {
            if (curNode.getData().equals(data)) {
                isElementPresent = true;
                break;
            }
            curNode = curNode.getLink();
            pos++;
        }
        if (isElementPresent) {
            System.out.println("Element found at position : " + pos);
        } else {
            System.out.println("Element is not present");
        }

    }

    /**
     * @param data : object which we want to store.
     * @param pos  : It should start from 1. if pos value is greater than length of link list, it will store data at last.
     */
    public void insertAtAnyPosition(T data, int pos) {
        if (pos < 1) {
            System.out.println("Position value is not proper.");
            return;
        }
        Node<T> newNode = new Node<T>(data);
        boolean isElementInserted = false;
        if (head == null) {
            head = newNode;
            return;
        }
        if (pos == 1) {
            newNode.setLink(head);
            head = newNode;
        } else {
            int count = 1;
            Node<T> curNode = head;
            Node<T> prevNode = head;
            while (curNode != null) {
                if (count == pos) {
                    prevNode.setLink(newNode);
                    newNode.setLink(curNode);
                    isElementInserted = true;
                    break;
                }
                prevNode = curNode;
                curNode = curNode.getLink();
                count++;
            }
            if (!isElementInserted)
                prevNode.setLink(newNode);
        }

    }

    /**
     * @param pos : It should start from 1. if pos value is greater than length of link list, it will delete data at last.
     */
    public void deleteAtAnyPosition(int pos) {

        boolean isElementDeleted = false;

        if (pos < 1) {
            System.out.println("Position value is not proper.");
            return;
        }
        if (head == null) {
            System.out.println("No data there for deletion.");
            return;
        }
        if (pos == 1) {
            head = head.getLink();
        } else {
            int count = 1;
            Node<T> curNode = head;
            Node<T> prevNode = head;
            while (curNode != null) {
                if (count == pos) {
                    prevNode.setLink(curNode.getLink());
                    isElementDeleted = true;
                    break;
                }
                prevNode = curNode;
                curNode = curNode.getLink();
                count++;
            }
            if (isElementDeleted)
                System.out.println("specified position data removed.");
        }
    }

    public void printMiddleElementOfList() {
        Node<T> slowPtr = head;
        Node<T> fastPtr = head;
        if (head == null) {
            System.out.println("No data is there.");
            return;
        }
        if (head.getLink() != null) {

            while (fastPtr != null && fastPtr.getLink() != null) {
                fastPtr = fastPtr.getLink().getLink();
                slowPtr = slowPtr.getLink();
            }
        }
        System.out.println("Middle Element : " + slowPtr.getData());

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
        singlyLinkList.searchAnObject(32);
        singlyLinkList.insertAtAnyPosition(new Integer(56), 8);
        singlyLinkList.printSinglyLinkList();
        singlyLinkList.deleteAtAnyPosition(8);
        singlyLinkList.printSinglyLinkList();
        singlyLinkList.printMiddleElementOfList();
    }

}
