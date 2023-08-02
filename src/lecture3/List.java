package lecture3;

public class List {
    Node head;
    Node tail;


    // Работа со стеком, метод push - положить данные - элемент в начало списка
    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }
    // Работа со стеком, метод pop - извлечь данные
    public Integer pop() {
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }

    // Работа с очередью (используются двузвязные списки)
    public void pushQ(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }
    public Integer peek() {
        Integer result = null;
        if (tail != null) {
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }

    //Вставка элемента (в конец списка)
//    public void addLast(int value) {
//        Node node = new Node();
//        node.value = value;
//        if (head == null) {
//            head = node;
//            tail = node;
//        } else {
//            tail.next = node;
//            node.previous = tail;
//            tail = node;
//        }
//    }

    //Вставка элемента (в середину списка) (до этго нужно найти место вставки)

//    public void addMiddle(int value, Node node) {
//        Node next = node.next;
//        Node newNode = new Node();
//        newNode.value = value;
//        node.next = newNode;
//        newNode.previous = node;
//        if (next == null) {
//            tail = newNode;
//        } else {
//            next.previous = newNode;
//            newNode.next = next;
//        }
//    }

    // Удаление элемента (до этого нужно найти требуемый элемент)
//    public void delete(Node node) {
//        Node previous = node.previous;
//        Node next = node.next;
//        if (previous == null) {
//            next.previous = null; // удаляем первый элемент списка
//            head = next; // присваиваем первому элементу значение следующего элемента
//        } else {
//            if (next == null) {
//                previous.next = null;
//                tail = previous;
//            } else {
//                previous.next = next;
//                next.previous = previous;
//            }
//        }
//    }


    // Разворот двусвязного списка

//    public void revert() {
//        Node currentNode = head;
//        while (currentNode != null) {
//            Node next = currentNode.next;
//            Node previous = currentNode.previous;
//            currentNode.next = previous;
//            currentNode.previous = next;
//            if (previous == null) {
//                tail = currentNode;
//            }
//            if (next ==null) {
//                head = currentNode;
//            }
//            currentNode = next;
//        }
//    }


    // Разворот односвязного списка (рекурсия)

    public void revert() {
        if (head != null && head.next != null) {
            Node temp = head;
            revert(head.next, head);
            temp.next = null;
        }
    }
    private void revert(Node currentNode, Node previousNode) {
        if (currentNode.next == null) {
            head = currentNode;
        } else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
    }

    // Поиск элемента в связном списке
//    public Node find(int value) {
//        Node currentNode = head;
//        while (currentNode != null) {
//            if (currentNode.value == value) {
//                return currentNode;
//            }
//            currentNode = currentNode.next;
//        }
//        return null;
//    }

    public class Node {
        int value;
        Node next;
        Node previous;
    }
}
