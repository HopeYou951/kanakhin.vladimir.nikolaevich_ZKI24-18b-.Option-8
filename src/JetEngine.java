/**
 * Реактивный двигатель.
 * Наследуется от DieselEngine и добавляет назначение и максимальную высоту.
 */
public class JetEngine extends DieselEngine {

	/** Назначение двигателя */
	private String purpose;

	/** Максимальная высота полёта */
	private int maxAltitude;

	/** Конструктор по умолчанию */
	public JetEngine() {
		super();
		this.purpose = "Unknown";
		this.maxAltitude = 0;
	}

	/**
	 * Конструктор с параметрами
	 *
	 * @param manufacturer производитель
	 * @param power мощность
	 * @param fuelType тип топлива
	 * @param volume объём
	 * @param injectionType тип впрыска
	 * @param fuelConsumption расход топлива
	 * @param purpose назначение
	 * @param maxAltitude максимальная высота
	 */
	public JetEngine(String manufacturer, int power,
									 String fuelType, double volume,
									 String injectionType, double fuelConsumption,
									 String purpose, int maxAltitude) {
		super(manufacturer, power, fuelType, volume, injectionType, fuelConsumption);
		setPurpose(purpose);
		setMaxAltitude(maxAltitude);
	}

	/** @return назначение двигателя */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * Устанавливает назначение двигателя
	 *
	 * @param purpose назначение
	 */
	public void setPurpose(String purpose) {
		if (purpose != null && purpose.length() > 0) {
			this.purpose = purpose;
		} else {
			System.out.println("Назначение не может быть пустым");
		}
	}

	/** @return максимальную высоту полёта */
	public int getMaxAltitude() {
		return maxAltitude;
	}

	/**
	 * Устанавливает максимальную высоту полёта
	 *
	 * @param maxAltitude высота (0–50000)
	 */
	public void setMaxAltitude(int maxAltitude) {
		if (maxAltitude >= 0 && maxAltitude <= 50000) {
			this.maxAltitude = maxAltitude;
		} else {
			System.out.println("Высота должна быть 0–50000");
		}
	}

	/**
	 * Сравнивает объекты JetEngine по всем полям родителей и новым полям
	 *
	 * @param obj объект для сравнения
	 * @return true, если все поля совпадают
	 */
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) return false;
		JetEngine that = (JetEngine) obj;
		return maxAltitude == that.maxAltitude &&
				purpose.equals(that.purpose);
	}

	/** @return хэш-код объекта */
	@Override
	public int hashCode() {
		return super.hashCode() + purpose.hashCode() + maxAltitude;
	}

	/** @return строковое представление объекта */
	@Override
	public String toString() {
		return "JetEngine{" +
				"manufacturer='" + manufacturer + '\'' +
				", power=" + power +
				", fuelType='" + fuelType + '\'' +
				", volume=" + volume +
				", injectionType='" + injectionType + '\'' +
				", fuelConsumption=" + fuelConsumption +
				", purpose='" + purpose + '\'' +
				", maxAltitude=" + maxAltitude +
				'}';
	}
}
