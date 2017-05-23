package tp.vo;

import java.io.Serializable;

public class RestaurantImage implements Serializable{
	private int restaurantId;	//외래키로 사용
	private String image;
	
	Restaurant restaurant;		//조인 위한 변수(1:1)
	
	public RestaurantImage(){}
	
	public RestaurantImage(int restaurantId, String image, Restaurant restaurant) {
		this.restaurantId = restaurantId;
		this.image = image;
		this.restaurant = restaurant;
	}

	public RestaurantImage(int restaurantId, String image) {
		this.restaurantId = restaurantId;
		this.image = image;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
		result = prime * result + restaurantId;
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
		RestaurantImage other = (RestaurantImage) obj;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		if (restaurantId != other.restaurantId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RestaurantImage [restaurantId=" + restaurantId + ", image=" + image + ", restaurant=" + restaurant
				+ "]";
	}
	
	
}
