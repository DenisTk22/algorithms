package practice4;
//Добавляем информацию о размере хэш-таблицы, а также алгоритм увеличения количества бакетов при достижении количества элементов до определенного размера относительно количества бакетов (load factor).
//        Чтобы хэш-таблица сохраняла сложность поиска близкой к O(1), нам необходимо контролировать количество бакетов, чтобы в них не скапливалось слишком много элементов, которые способны увеличить длительность операции поиска и добавления.
//        В Java load factor для хэш-таблицы – 0.75, что значит, что при достижении количества значений 75% от общего количества бакетов – это количество необходимо увеличить. Это позволяет минимизировать шансы, что в бакетах будет больше 1-2 значений, а значит сохранит скорость поиска на уровне сложности O(1).
public class Task6 {

}