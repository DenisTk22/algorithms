package practice4;
// Структура хэш-таблица: значение ключ
public class HashTable<K, V> {
    private class Entity {
        private K key;
        private V value;
    }
    private class Basket {
        private Node head;
        public V get(K key) {
            Node node = head;
            while (node != null) {
                if (node.value.key.equals(key)) {
                    return node.value.value;
                }
            }
            return null;
        }

        private class Node {
            private Node next;
            private Entity value;
        }
    }

    // Реализуем метод поиска данных по ключу в хэш-таблице

}
