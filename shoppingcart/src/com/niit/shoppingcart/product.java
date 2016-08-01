package com.niit.shoppingcart;

class Product {
	private int pid;
	private String pname;
	public int price;

    Product(int i, String iphone, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public int getId() {
		return pid;
	}

	public void setId(int id) {
		this.pid = id;
	}

	public String getName() {
		return pname;
	}

	public void setName(String name) {
		this.pname = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
