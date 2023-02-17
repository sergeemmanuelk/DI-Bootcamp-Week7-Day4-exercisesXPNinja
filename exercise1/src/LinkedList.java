public class LinkedList<E> {

    Node<E> head; // head of list
    int itemNumber = 0;

    /**
     *
     * Insert a new node to the list
     *
     * @param data
     */
    public void add(E data) {
        //List item count grow to 1
        itemNumber += 1;

        //Create a new node with given data
        Node<E> newNode = new Node<>(data);
        newNode.index = itemNumber - 1;

        // If the Linked List is empty,
        // then make the new node as head
        if (head == null) {
            head = newNode;
        } else {
            // Else traverse till the last node and insert the new_node there
            Node<E> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            // Insert the new_node at last node
            currentNode.next = newNode;
        }
    }

    /**
     * Remove the node at the specified index to the list
     *
     * @param index
     */
    public void remove(int index) {
        //If there are no values on list then return
        if (head == null) {
            return;
        }

        //If the node at specified index is the head, then delete it from the list
        if (head.index == index) {
            head = head.next;
            return;
        }

        //If node is found at the given index then
        //remove them, and replace them in the list by the next node
        Node<E> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.index == index) {
                currentNode.next = currentNode.next.next;

                //Recalculate all indices of remaining nodes
                resetIndex();
                return;
            }
            currentNode = currentNode.next;
            currentNode.index = currentNode.next.index;
        }
    }

    /**
     * Recalculate all the indices of nodes in the list
     */
    private void resetIndex() {
        itemNumber = 0;
        Node<E> currentNode = head;
        while (currentNode != null) {
            itemNumber += 1;
            currentNode.index = itemNumber - 1;
            currentNode = currentNode.next;
        }
    }

    /**
     * Get all nodes items in the list
     */
    public void getAll() {
        Node<E> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            System.out.print("Index " + currentNode.index + " ");
            currentNode = currentNode.next;
        }
    }

    /**
     * Get node item at the specified index
     *
     * @param index
     */
    public void get(int index) {
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.index == index) {
                System.out.print(currentNode.data + " ");
                break;
            } else {
                currentNode = currentNode.next;
            }
        }
    }
}
