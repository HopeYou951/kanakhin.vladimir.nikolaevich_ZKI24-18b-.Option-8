/**
 * Базовый класс, представляющий двигатель.
 * Содержит производителя и мощность двигателя.
 */
public class Engine {
  /**
   * Производитель двигателя
   */
  protected String manufacturer;

  /**
   * Мощность двигателя
   */
  protected int power;

  /**
   * Конструктор по умолчанию
   */
  public Engine() {
    this.manufacturer = "Unknown";
    this.power = 0;
  }

  /**
   * Конструктор с параметрами
   *
   * @param manufacturer производитель двигателя
   * @param power        мощность двигателя
   */
  public Engine(String manufacturer, int power) {
    setManufacturer(manufacturer);
    setPower(power);
  }

  /**
   * @return производитель двигателя
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * Устанавливает производителя двигателя
   *
   * @param manufacturer название производителя
   */
  public void setManufacturer(String manufacturer) {
    if (manufacturer != null && manufacturer.length() > 0) {
      this.manufacturer = manufacturer;
    } else {
      System.out.println("Производитель не может быть пустым");
    }
  }

  /**
   * @return мощность двигателя
   */
  public int getPower() {
    return power;
  }

  /**
   * Устанавливает мощность двигателя
   *
   * @param power мощность (0–200000)
   */
  public void setPower(int power) {
    if (power >= 0 && power <= 200000) {
      this.power = power;
    } else {
      System.out.println("Мощность должна быть в диапазоне 0–200000");
    }
  }

  /**
   * Сравнивает текущий объект Engine с другим объектом на равенство.
   * Два объекта считаются равными, если они принадлежат к одному классу
   * и имеют одинаковые значения полей power и manufacturer.
   *
   * @param obj объект для сравнения
   * @return true, если объекты равны по содержимому; false иначе
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Engine engine = (Engine) obj;
    return power == engine.power && manufacturer.equals(engine.manufacturer);
  }

  /**
   * Возвращает хэш-код объекта, основанный на полях manufacturer и power
   *
   * @return числовой хэш-код объекта
   */
  @Override
  public int hashCode() {
    return manufacturer.hashCode() + power;
  }

  /**
   * Возвращает строковое представление объекта Engine
   *
   * @return строка с производителем и мощностью
   */
  @Override
  public String toString() {
    return "Engine{" +
        "manufacturer='" + manufacturer + '\'' +
        ", power=" + power +
        '}';
  }
}
