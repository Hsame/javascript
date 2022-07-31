package dev.domain;

public class Store {
	private int storeId;
	private String StoreName;
	private String StoreAddress;
	private String telephone;
	private int sitCapacity;
	private String availableTime;
	private int holiday;
	private String representMenu;
	private String foodCategory;
	private int approvalStatus;
	
	public int getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(int approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return StoreName;
	}
	public void setStoreName(String storeName) {
		StoreName = storeName;
	}
	public String getStoreAddress() {
		return StoreAddress;
	}
	public void setStoreAddress(String storeAddress) {
		StoreAddress = storeAddress;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getSitCapacity() {
		return sitCapacity;
	}
	public void setSitCapacity(int sitCapacity) {
		this.sitCapacity = sitCapacity;
	}
	public String getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	public int getHoliday() {
		return holiday;
	}
	public void setHoliday(int holiday) {
		this.holiday = holiday;
	}
	public String getRepresentMenu() {
		return representMenu;
	}
	public void setRepresentMenu(String representMenu) {
		this.representMenu = representMenu;
	}
	public String getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

}
