package tp.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Restaurant implements Serializable{
	private int restaurantId; 			//시퀀스 사용, PK
	private String foodCategory;
	private String location;
	private String restaurantName;
	private int hits;
	private String restaurantTelNum;
	private String introduction;
	private String menu;
	private String image;
	private int avgKostar;

	ArrayList<Review> reviews;         	//조인 위한 리뷰들
	ArrayList<String> images;  			//조인 위한 사진들 

	
	public Restaurant(){}
	
	public Restaurant(int restaurantId, String foodCategory, String location, String restaurantName, int hits,
			String restaurantTelNum, String introduction, String menu, ArrayList<String> images) {
		this.restaurantId = restaurantId;
		this.foodCategory = foodCategory;
		this.location = location;
		this.restaurantName = restaurantName;
		this.hits = hits;
		this.restaurantTelNum = restaurantTelNum;
		this.introduction = introduction;
		this.menu = menu;
		this.images = images;
	}
	public Restaurant(int restaurantId, String foodCategory, String location, String restaurantName, int hits,
			String restaurantTelNum, String introduction, String menu, ArrayList<Review> reviews,
			ArrayList<String> images) {
		this.restaurantId = restaurantId;
		this.foodCategory = foodCategory;
		this.location = location;
		this.restaurantName = restaurantName;
		this.hits = hits;
		this.restaurantTelNum = restaurantTelNum;
		this.introduction = introduction;
		this.menu = menu;
		this.reviews = reviews;
		this.images = images;
	}
	public Restaurant(int restaurantId, String foodCategory, String location, String restaurantName, int hits,
			String restaurantTelNum, String introduction, String menu) {
		this.restaurantId = restaurantId;
		this.foodCategory = foodCategory;
		this.location = location;
		this.restaurantName = restaurantName;
		this.hits = hits;
		this.restaurantTelNum = restaurantTelNum;
		this.introduction = introduction;
		this.menu = menu;
	}
	
	
	
	
	
	public Restaurant(int restaurantId, String foodCategory, String location, String restaurantName, int hits,
			String restaurantTelNum, String introduction, String menu, String image, int avgKostar,
			ArrayList<Review> reviews, ArrayList<String> images) {
		this.restaurantId = restaurantId;
		this.foodCategory = foodCategory;
		this.location = location;
		this.restaurantName = restaurantName;
		this.hits = hits;
		this.restaurantTelNum = restaurantTelNum;
		this.introduction = introduction;
		this.menu = menu;
		this.image = image;
		this.avgKostar = avgKostar;
		this.reviews = reviews;
		this.images = images;
	}

	public Restaurant(int restaurantId, String image ){
		this.restaurantId = restaurantId;
		this.image=  image;
	}
	

	public Restaurant(int restaurantId, ArrayList<String> images) {
		super();
		this.restaurantId = restaurantId;
		this.images = images;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getRestaurantTelNum() {
		return restaurantTelNum;
	}

	public void setRestaurantTelNum(String restaurantTelNum) {
		this.restaurantTelNum = restaurantTelNum;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}

	public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	
	
	public int getAvgKostar() {
		return avgKostar;
	}

	public void setAvgKostar(int avgKostar) {
		this.avgKostar = avgKostar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foodCategory == null) ? 0 : foodCategory.hashCode());
		result = prime * result + hits;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((introduction == null) ? 0 : introduction.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		result = prime * result + restaurantId;
		result = prime * result + ((restaurantName == null) ? 0 : restaurantName.hashCode());
		result = prime * result + ((restaurantTelNum == null) ? 0 : restaurantTelNum.hashCode());
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
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
		Restaurant other = (Restaurant) obj;
		if (foodCategory == null) {
			if (other.foodCategory != null)
				return false;
		} else if (!foodCategory.equals(other.foodCategory))
			return false;
		if (hits != other.hits)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (introduction == null) {
			if (other.introduction != null)
				return false;
		} else if (!introduction.equals(other.introduction))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (menu == null) {
			if (other.menu != null)
				return false;
		} else if (!menu.equals(other.menu))
			return false;
		if (restaurantId != other.restaurantId)
			return false;
		if (restaurantName == null) {
			if (other.restaurantName != null)
				return false;
		} else if (!restaurantName.equals(other.restaurantName))
			return false;
		if (restaurantTelNum == null) {
			if (other.restaurantTelNum != null)
				return false;
		} else if (!restaurantTelNum.equals(other.restaurantTelNum))
			return false;
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", foodCategory=" + foodCategory + ", location=" + location
				+ ", restaurantName=" + restaurantName + ", hits=" + hits + ", restaurantTelNum=" + restaurantTelNum
				+ ", introduction=" + introduction + ", menu=" + menu + ", image=" + image + ", reviews=" + reviews
				+ ", images=" + images + "]";
	}

	
	
}
