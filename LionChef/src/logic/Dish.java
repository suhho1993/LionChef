package logic;

public class Dish{


	private String name;
	private String url;
	
	/**
	 * @param name
	 * @param url
	 * COnstructor
	 * Creates a new dish with name and url
	 */
	public Dish(String name, String url){
		this.name=name;
		this.url=url;
	}

	/**
	 * @return name of dish
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 * sets new name for the dish
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return url of dish
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 * sets new url for dish
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
}