package com.zhenapp.po.Custom;

public class OrderInfoCustom {
	private String minPrice;
	private String maxPrice;
	private int totalTask;
	private int totalCollectProduct;
	private int totalShoppingCart;
	private String taskstartdate;
	private String taskenddate;
	private String kwd;
	private String nid;
	private String ktype;
	private String searchType;
	private String timecontrol;
	private String image;
	
	
	
	public String getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	
	public String getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getTaskstartdate() {
		return taskstartdate;
	}
	public void setTaskstartdate(String taskstartdate) {
		this.taskstartdate = taskstartdate;
	}
	public String getTaskenddate() {
		return taskenddate;
	}
	public void setTaskenddate(String taskenddate) {
		this.taskenddate = taskenddate;
	}
	public int getTotalTask() {
		return totalTask;
	}
	public void setTotalTask(int totalTask) {
		this.totalTask = totalTask;
	}
	public int getTotalCollectProduct() {
		return totalCollectProduct;
	}
	public void setTotalCollectProduct(int totalCollectProduct) {
		this.totalCollectProduct = totalCollectProduct;
	}
	public int getTotalShoppingCart() {
		return totalShoppingCart;
	}
	public void setTotalShoppingCart(int totalShoppingCart) {
		this.totalShoppingCart = totalShoppingCart;
	}
	public String getKwd() {
		return kwd;
	}
	public void setKwd(String kwd) {
		this.kwd = kwd;
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getKtype() {
		return ktype;
	}
	public void setKtype(String ktype) {
		this.ktype = ktype;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getTimecontrol() {
		return timecontrol;
	}
	public void setTimecontrol(String timecontrol) {
		this.timecontrol = timecontrol;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "OrderInfoCustom [minPrice=" + minPrice + ", maxPrice="
				+ maxPrice + ", totalTask=" + totalTask
				+ ", totalCollectProduct=" + totalCollectProduct
				+ ", totalShoppingCart=" + totalShoppingCart
				+ ", taskstartdate=" + taskstartdate + ", taskenddate="
				+ taskenddate + ", kwd=" + kwd + ", nid=" + nid + ", ktype="
				+ ktype + ", searchType=" + searchType + ", timecontrol="
				+ timecontrol + ", image=" + image + "]";
	}
	
}