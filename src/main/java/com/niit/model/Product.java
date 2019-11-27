package com.niit.model;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
@Table
public class Product {
	@Id
	@GeneratedValue
	int productId;
	
	@NotEmpty(message = "Product name cannot be blank")
	String productName;
	
	@NotEmpty(message = "Product description cannot be blank")
	@Size(min = 10, max = 200, message = "Product description should be between 10 characters to 200 characters long")
	String productDesc;
	
	@Min(1)
	int price;
	
	@Min(1)
	int stock;
	
	@Min(1)
	int categoryId;
	
	@Min(1)
	int supplierId;
	
	@Transient
	private MultipartFile pimage;
	
	public MultipartFile getPimage() {
		return pimage;
	}
	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	
	@Override
	public String toString() {
		return "Product [productName= " + this.productName + "]";
	}
	
	public static Comparator<Product> priceComparator = new Comparator<Product>() {
		public int compare(Product p1, Product p2) {
			return(p1.getPrice() < p2.getPrice() ? -1 : (p1.getPrice() == p2.getPrice() ? 0 : 1));
		}
	};

}