/**
 * Класс двигателя внутреннего сгорания.
 * Наследуется от Engine, добавляет поля топлива и объёма.
 */
public class InternalCombustionEngine extends Engine {

  /**
   * Тип топлива двигателя
   */
  protected String fuelType;

  /**
   * Объём двигателя
   */
  protected double volume;

  /**
   * Конструктор по умолчанию
   */
  public InternalCombustionEngine() {
    super();
    this.fuelType = "Unknown";
    this.volume = 0;
  }

  /**
   * Конструктор с параметрами
   *
   * @param manufacturer производитель
   * @param power        мощность
   * @param fuelType     тип топлива
   * @param volume       объём
   */
  public InternalCombustionEngine(String manufacturer, int power,
                                  String fuelType, double volume) {
    super(manufacturer, power);
    setFuelType(fuelType);
    setVolume(volume);
  }

  /**
   * @return тип топлива
   */
  public String getFuelType() {
    return fuelType;
  }

  /**
   * Устанавливает тип топлива
   *
   * @param fuelType тип топлива
   */
  public void setFuelType(String fuelType) {
    if (fuelType != null && fuelType.length() > 0) {
      this.fuelType = fuelType;
    } else {
      System.out.println("Тип топлива не может быть пустым");
    }
  }

  /**
   * @return объём двигателя
   */
  public double getVolume() {
    return volume;
  }

  /**
   * Устанавливает объём двигателя
   *
   * @param volume объём (0–20)
   */
  public void setVolume(double volume) {
    if (volume >= 0 && volume <= 20) {
      this.volume = volume;
    } else {
      System.out.println("Объём должен быть в диапазоне 0–20");
    }
  }

  /**
   * Сравнивает объекты InternalCombustionEngine по полям родителя и новым полям
   *
   * @param obj объект для сравнения
   * @return true, если все поля совпадают
   */
  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj)) return false;
    InternalCombustionEngine that = (InternalCombustionEngine) obj;
    return Double.compare(volume, that.volume) == 0 &&
        fuelType.equals(that.fuelType);
  }

  /**
   * @return хэш-код объекта
   */
  @Override
  public int hashCode() {
    return super.hashCode() + fuelType.hashCode() + (int) volume;
  }

  /**
   * @return строковое представление объекта
   */
  @Override
  public String toString() {
    return "InternalCombustionEngine{" +
        "manufacturer='" + manufacturer + '\'' +
        ", power=" + power +
        ", fuelType='" + fuelType + '\'' +
        ", volume=" + volume +
        '}';
  }
}
