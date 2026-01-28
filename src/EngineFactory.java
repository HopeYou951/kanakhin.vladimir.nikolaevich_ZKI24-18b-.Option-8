import java.util.ArrayList;
import java.util.Scanner;

/**
 * Фабричный класс для создания объектов типа {@link Engine} и его наследников.
 * Содержит методы для ввода данных с консоли и вспомогательные методы валидации.
 */
public class EngineFactory {

  /**
   * Список возможных типов впрыска для дизельных двигателей.
   */
  private static final ArrayList<String> dieselInjectionTypes = new ArrayList<>();
  /**
   * Список возможных типов впрыска для реактивных двигателей.
   */
  private static final ArrayList<String> jetInjectionTypes = new ArrayList<>();

  static {
    dieselInjectionTypes.add("С рядным насосом");
    dieselInjectionTypes.add("С насосом распределительного типа");
    dieselInjectionTypes.add("Системы с насос-форсунками");
    dieselInjectionTypes.add("Сommon Rail");
  }

  static {
    jetInjectionTypes.add("Непосредственный впрыск (прямой)");
    jetInjectionTypes.add("Моновпрыск (центральный)");
    jetInjectionTypes.add("Впрыск в турбореактивных двигателях");
    jetInjectionTypes.add("Системы высокого давления (Common Rail)");
  }

  /**
   * Создаёт объект двигателя выбранного типа и запрашивает у пользователя
   * необходимые параметры через консоль.
   *
   * @param sc   объект Scanner для чтения ввода
   * @param type тип двигателя (1 - Engine, 2 - InternalCombustionEngine,
   *             3 - DieselEngine, 4 - JetEngine)
   * @return созданный объект типа Engine или null, если тип некорректен
   */
  public static Engine createEngine(Scanner sc, int type) {

    switch (type) {

      case 1 -> {
        String manufacturer = readString(sc, "Производитель: ");
        int power = readInt(sc, "Мощность: ");
        return new Engine(manufacturer, power);
      }

      case 2 -> {
        String manufacturer = readString(sc, "Производитель: ");
        int power = readInt(sc, "Мощность: ");
        String fuelType = readString(sc, "Топливо: ");
        double volume = readDouble(sc, "Объем: ");
        return new InternalCombustionEngine(manufacturer, power, fuelType, volume);
      }

      case 3 -> {
        String manufacturer = readString(sc, "Производитель: ");
        int power = readInt(sc, "Мощность: ");
        String fuelType = readString(sc, "Топливо: ");
        double volume = readDouble(sc, "Объем: ");
        String injection = chooseInjectionType(sc, dieselInjectionTypes);
        double fuelConsumption = readDouble(sc, "Расход: ");
        return new DieselEngine(manufacturer, power, fuelType, volume, injection, fuelConsumption);
      }

      case 4 -> {
        String manufacturer = readString(sc, "Производитель: ");
        int power = readInt(sc, "Мощность: ");
        String fuelType = readString(sc, "Топливо: ");
        double volume = readDouble(sc, "Объем: ");
        String injection = chooseInjectionType(sc, jetInjectionTypes);
        double fuelConsumption = readDouble(sc, "Расход: ");
        String purpose = readString(sc, "Назначение двигателя: ");
        int maxAltitude = readInt(sc, "Максимальная высота: ");
        return new JetEngine(manufacturer, power, fuelType, volume, injection, fuelConsumption, purpose, maxAltitude);
      }

      default -> {
        System.out.println("Такого типа двигателя нет.");
        return null;
      }
    }
  }

  /**
   * Считывает целое число с консоли с проверкой корректности ввода.
   *
   * @param scan объект Scanner
   * @param msg  сообщение, выводимое пользователю
   * @return корректно введённое целое число
   */
  public static int readInt(Scanner scan, String msg) {
    System.out.println(msg);
    while (!scan.hasNextInt()) {
      System.out.println("Ошибка! Введите целое число.");
      scan.next();
      System.out.println(msg);
    }
    return scan.nextInt();
  }

  /**
   * Считывает число с плавающей точкой с консоли с проверкой корректности ввода.
   *
   * @param scan объект Scanner
   * @param msg  сообщение, выводимое пользователю
   * @return корректно введённое число типа double
   */
  public static double readDouble(Scanner scan, String msg) {
    System.out.println(msg);
    while (!scan.hasNextDouble()) {
      System.out.println("Ошибка! Введите число.");
      scan.next();
      System.out.println(msg);
    }
    return scan.nextDouble();
  }

  /**
   * Считывает строку с консоли.
   *
   * @param scan объект Scanner
   * @param msg  сообщение, выводимое пользователю
   * @return введённая строка
   */
  public static String readString(Scanner scan, String msg) {
    System.out.println(msg);
    return scan.next();
  }

  /**
   * Позволяет пользователю выбрать тип впрыска из заданного списка.
   *
   * @param sc                объект Scanner
   * @param InjectionTypeList список доступных типов впрыска
   * @return выбранный тип впрыска
   */
  private static String chooseInjectionType(Scanner sc, ArrayList<String> InjectionTypeList) {
    System.out.println("Выберите тип впрыска:");
    for (int i = 0; i < InjectionTypeList.size(); i++) {
      System.out.println(i + ": " + InjectionTypeList.get(i));
    }

    int index;
    do {
      index = readInt(sc, "Введите номер типа: ");
      if (index < 0 || index >= InjectionTypeList.size()) {
        System.out.println("Некорректный индекс. Попробуйте снова.");
      }
    } while (index < 0 || index >= InjectionTypeList.size());

    return InjectionTypeList.get(index);
  }
}


