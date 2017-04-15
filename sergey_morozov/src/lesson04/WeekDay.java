package lesson04;

public enum WeekDay {

	MONDAY ("Понедельник", 1),
	TUESDAY ("Вторник", 2),
	WEDNESDAY ("Среда", 3),
	THURSDAY ("Четверг", 4),
	FRIDAY ("Пятница", 5),
	SATURDAY ("Суббота", 6),
	SUNDAY ("Воскресенье", 7);
	
	private String name;
	private int order;
	
	WeekDay(String name, int order) {
		this.name = name;
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	
}
