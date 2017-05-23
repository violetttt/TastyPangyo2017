package tp.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Review implements Serializable{
   private int reviewNo;
   private String memberId;   // 회원 테이블 외래키
   private int restaurantId;   // 맛집 테이블 외래키
   private String restaurantName;
   private Date registeredDate;
   private String title;
   private String comments;
   private int kostar;
   
   
   
   // JOIN위한 변수
   private Member member;
   private Restaurant restaurant;
   
   
   //constructor
   public Review() {
   }

   



   public Review(int reviewNo, String memberId, int restaurantId, String restaurantName, Date registeredDate,
         String title, String comments, int kostar) {
      this.reviewNo = reviewNo;
      this.memberId = memberId;
      this.restaurantId = restaurantId;
      this.restaurantName = restaurantName;
      this.registeredDate = registeredDate;
      this.title = title;
      this.comments = comments;
      this.kostar = kostar;
   }

   public Review(int reviewNo, String memberId, int restaurantId, String restaurantName, Date registeredDate,
         String title, String comments, int kostar, Member member, Restaurant restaurant) {
      this.reviewNo = reviewNo;
      this.memberId = memberId;
      this.restaurantId = restaurantId;
      this.restaurantName = restaurantName;
      this.registeredDate = registeredDate;
      this.title = title;
      this.comments = comments;
      this.kostar = kostar;
      this.member = member;
      this.restaurant = restaurant;
   }







   //setter & getter


   public int getReviewNo() {
      return reviewNo;
   }


   public void setReviewNo(int reviewNo) {
      this.reviewNo = reviewNo;
   }



   public String getMemberId() {
      return memberId;
   }


   public void setMemberId(String memberId) {
      this.memberId = memberId;
   }


   public Date getRegisteredDate() {
      return registeredDate;
   }


   public void setRegisteredDate(Date registeredDate) {
      this.registeredDate = registeredDate;
   }


   public String getTitle() {
      return title;
   }


   public void setTitle(String title) {
      this.title = title;
   }


   public String getRestaurantName() {
      return restaurantName;
   }


   public void setRestaurantName(String restaurantName) {
      this.restaurantName = restaurantName;
   }


   public String getComments() {
      return comments;
   }


   public void setComments(String comments) {
      this.comments = comments;
   }


   public int getKostar() {
      return kostar;
   }


   public void setKostar(int kostar) {
      this.kostar = kostar;
   }


   public int getRestaurantId() {
      return restaurantId;
   }


   public void setRestaurantId(int restaurantId) {
      this.restaurantId = restaurantId;
   }
   

   
   public Member getMember() {
      return member;
   }




   public void setMember(Member member) {
      this.member = member;
   }




   public Restaurant getRestaurant() {
      return restaurant;
   }




   public void setRestaurant(Restaurant restaurant) {
      this.restaurant = restaurant;
   }




   //hashCode & equals
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((comments == null) ? 0 : comments.hashCode());
      result = prime * result + kostar;
      result = prime * result + ((member == null) ? 0 : member.hashCode());
      result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
      result = prime * result + ((registeredDate == null) ? 0 : registeredDate.hashCode());
      result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
      result = prime * result + restaurantId;
      result = prime * result + ((restaurantName == null) ? 0 : restaurantName.hashCode());
      result = prime * result + reviewNo;
      result = prime * result + ((title == null) ? 0 : title.hashCode());
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
      Review other = (Review) obj;
      if (comments == null) {
         if (other.comments != null)
            return false;
      } else if (!comments.equals(other.comments))
         return false;
      if (kostar != other.kostar)
         return false;
      if (member == null) {
         if (other.member != null)
            return false;
      } else if (!member.equals(other.member))
         return false;
      if (memberId == null) {
         if (other.memberId != null)
            return false;
      } else if (!memberId.equals(other.memberId))
         return false;
      if (registeredDate == null) {
         if (other.registeredDate != null)
            return false;
      } else if (!registeredDate.equals(other.registeredDate))
         return false;
      if (restaurant == null) {
         if (other.restaurant != null)
            return false;
      } else if (!restaurant.equals(other.restaurant))
         return false;
      if (restaurantId != other.restaurantId)
         return false;
      if (restaurantName == null) {
         if (other.restaurantName != null)
            return false;
      } else if (!restaurantName.equals(other.restaurantName))
         return false;
      if (reviewNo != other.reviewNo)
         return false;
      if (title == null) {
         if (other.title != null)
            return false;
      } else if (!title.equals(other.title))
         return false;
      return true;
   }




   //toString
   @Override
   public String toString() {
      return "Review [reviewNo=" + reviewNo + ", memberId=" + memberId + ", restaurantId=" + restaurantId
            + ", restaurantName=" + restaurantName + ", registeredDate=" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(registeredDate) + ", title=" + title
            + ", comments=" + comments + ", kostar=" + kostar + "]";
   }
}