package com.niit.shoppingcart;
public class Supplier {
	  private Product product ;
	private String id;
	private String name;
	private String address;
	


public Supplier(Product product,String id, String name, String address) {
	super();
	//this.product=product;
	this.id = id;
	this.name = name;
	this.address = address;
}





public void setProduct(Product product) {
	this.product = product;
}





public String getId() {
	return id;
}





public void setId(String id) {
	this.id = id;
}





public String getName() {
	return name;
}





public void setName(String name) {
	this.name = name;
}





public String getAddress() {
	return address;
}





public void setAddress(String address) {
	this.address = address;
}
public String getProduct(){
	return product;

}
public void setProduct(Product product){
	this.product=product;
}


}
