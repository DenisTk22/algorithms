package practice4;
// Добавляем массив связных списков с фиксированным размером (массив бакетов), либо пеердаваемым в конструкторе
// хэш-таблица оперирует индексами
// Реализуем метод вычисления индекса на основании хэш-кода ключа
public class Task2 {
    public class HashTable2<K,V> {
        private static final int INIT_BASKET_COUNT = 16;

        private Basket[] baskets;

        public HashTable2() {
            this(INIT_BASKET_COUNT);
        }
        public HashTable2(int initSize) {
            baskets = (Basket[]) new Object[initSize];
        }

        private int calculateBasketIndex(K key) {
            return key.hashCode() % baskets.length;


        }

        private class Entity {
            private K key;
            private V value;
        }

        private class Basket {
            private Node head;
            public V get(K key) {
                int index = calculateBasketIndex(key);
                Basket basket = baskets[index];
                if (basket != null) {
                    return basket.get(key);
                }
                return null;
            }

            private class Node {
                private Node next;
                private Entity value;

                public V get(K key) {
                    int index = calculateBasketIndex(key);
                    Basket basket = baskets[index];
                    if (basket != null) {
                        return basket.get(key);
                    }
                    return null;
                }
            }

            public boolean remove(K key) {
            if (head != null) {
                if (head.value.key.equals(key)) {
                    head = head.next;
                } else {
                    Node node = head;
                    while (node.next != null) {
                        if (node.next.value.key.equals(key)) {
                            node.next = node.next.next;
                            return true;
                        }
                        node = node.next;
                    }
                }
            }
            return false;
        }

            public boolean add(Entity entity) {
                Node node = new Node();
                node.value = entity;
                if (head != null) {
                    Node current = head;
                    while (true) {
                        if (current.value.key.equals(entity.key)) {
                            return false;
                        }
                        if (current.next == null) {
                            current.next = node;
                            return true;
                        } else {
                            current = current.next;
                        }
                    }
                } else {
                    head = node;
                    return true;
                }
            }

        }
    }
}
