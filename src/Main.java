import java.util.ArrayList;
import java.util.Scanner;

/**
 * Главное меню программы для управления коллекцией двигателей.
 * Позволяет добавлять, удалять, просматривать и сравнивать объекты Engine и его наследников.
 */
public class Main {

  public static void main(String[] args) {
    ArrayList<Engine> engines = new ArrayList<>(); // Создаем список, в котором будем хранить коллекцию двигателей.
    Scanner sc = new Scanner(System.in); // Создаем объект сканер, для считывания с консоли.

    boolean isWork = true;

    while (isWork) {
      System.out.println("\nМеню:");
      System.out.println("1. Добавить элемент");
      System.out.println("2. Удалить по индексу");
      System.out.println("3. Показать все");
      System.out.println("4. Сравнить два элемента");
      System.out.println("5. Выход");

      int choice = EngineFactory.readInt(sc, "Выбор: "); // Переменная для условий

      switch (choice) {
        case 1:
          System.out.println("Тип двигателя:");
          System.out.println("1. Engine");
          System.out.println("2. InternalCombustionEngine");
          System.out.println("3. DieselEngine");
          System.out.println("4. JetEngine");

          int type = EngineFactory.readInt(sc, "Тип: "); // Создаем переменную для указания типа двигателя который мы создадим.
          Engine obj = EngineFactory.createEngine(sc, type); // Создаем объект двигателя.

          if (obj != null) {
            engines.add(obj);
            System.out.println("Добавлено: " + obj);
          } else {
            System.out.println("Ошибка создания двигателя.");
          }
          break;

        case 2:
          for (int i = 0; i < engines.size(); i++) {
            System.out.println(i + ": " + engines.get(i));
          }
          int index = EngineFactory.readInt(sc, "Индекс: ");
          if (index >= 0 && index < engines.size()) {
            engines.remove(index);
            System.out.println("Удалено.");
          } else {
            System.out.println("Неверный индекс.");
          }
          break;

        case 3:
          if (engines.isEmpty()) {
            System.out.println("Список пуст.");
          } else {
            for (int i = 0; i < engines.size(); i++) {
              System.out.println(i + ": " + engines.get(i));
            }
          }
          break;

        case 4:

          if (engines.size() < 2) {
            System.out.println("В списке один элемент, сравнение не возможно!");
          } else {

            for (int i = 0; i < engines.size(); i++) {
              System.out.println(i + ": " + engines.get(i));
            }

            int indexOne = EngineFactory.readInt(sc, "Первый индекс: ");
            int indexTwo = EngineFactory.readInt(sc, "Второй индекс: ");

            if (indexOne >= 0 && indexOne < engines.size() && indexTwo >= 0 && indexTwo < engines.size()) {
              System.out.println(engines.get(indexOne).equals(engines.get(indexTwo)) ? "Равны" : "Неравны");
            } else {
              System.out.println("Неверные индексы.");
            }
          }
          break;

        case 5:
          isWork = false;
          break;

        default:
          System.out.println("Неверный пункт меню.");
      }
    }
  }
}
