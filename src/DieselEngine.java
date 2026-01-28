/**
 * Дизельный двигатель.
 * Наследуется от InternalCombustionEngine и добавляет тип впрыска и расход топлива.
 */
public class DieselEngine extends InternalCombustionEngine {

  /**
   * Тип впрыска топлива
   */
  protected String injectionType;

  /**
   * Расход топлива
   */
  protected double fuelConsumption;

  /**
   * Конструктор по умолчанию
   */
  public DieselEngine() {
    super();
    this.injectionType = "Unknown";
    this.fuelConsumption = 0;
  }

  /**
   * Конструктор с параметрами
   *
   * @param manufacturer    производитель
   * @param power           мощность
   * @param fuelType        тип топлива
   * @param volume          объём
   * @param injectionType   тип впрыска
   * @param fuelConsumption расход топлива
   */
  public DieselEngine(String manufacturer, int power,
                      String fuelType, double volume,
                      String injectionType, double fuelConsumption) {
    super(manufacturer, power, fuelType, volume);
    setInjectionType(injectionType);
    setFuelConsumption(fuelConsumption);
  }

  /**
   * @return тип впрыска
   */
  public String getInjectionType() {
    return injectionType;
  }

  /**
   * Устанавливает тип впрыска
   *
   * @param injectionType тип впрыска
   */
  public void setInjectionType(String injectionType) {
    if (injectionType != null && injectionType.length() > 0) {
      this.injectionType = injectionType;
    } else {
      System.out.println("Тип впрыска не может быть пустым");
    }
  }

  /**
   * @return расход топлива
   */
  public double getFuelConsumption() {
    return fuelConsumption;
  }

  /**
   * Устанавливает расход топлива
   *
   * @param fuelConsumption расход топлива (0–100)
   */
  public void setFuelConsumption(double fuelConsumption) {
    if (fuelConsumption >= 0 && fuelConsumption <= 100) {
      this.fuelConsumption = fuelConsumption;
    } else {
      System.out.println("Расход должен быть 0–100");
    }
  }

  /**
   * Сравнивает объекты DieselEngine по всем полям родителя и новым полям
   *
   * @param obj объект для сравнения
   * @return true, если все поля совпадают
   */
  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj)) return false;
    DieselEngine that = (DieselEngine) obj;
    return Double.compare(fuelConsumption, that.fuelConsumption) == 0 &&
        injectionType.equals(that.injectionType);
  }

  /**
   * @return хэш-код объекта
   */
  @Override
  public int hashCode() {
    return super.hashCode() + injectionType.hashCode() + (int) fuelConsumption;
  }

  /**
   * @return строковое представление объекта
   */
  @Override
  public String toString() {
    return "DieselEngine{" +
        "manufacturer='" + manufacturer + '\'' +
        ", power=" + power +
        ", fuelType='" + fuelType + '\'' +
        ", volume=" + volume +
        ", injectionType='" + injectionType + '\'' +
        ", fuelConsumption=" + fuelConsumption +
        '}';
  }
}
