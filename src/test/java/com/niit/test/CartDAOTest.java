package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.model.CartItem;

public class CartDAOTest {

	static CartDAO cartDAO;
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		cartDAO = (CartDAO) context.getBean("cartDAO");
	}
	
	@Ignore
	public void addCartItemTest() {
		CartItem cartItem = new CartItem();
		cartItem.setProductId(3);
		cartItem.setProductName("Moto G4");
		cartItem.setQuantity(3);
		cartItem.setPrice(13000);
		cartItem.setUsername("shbptl111");
		cartItem.setPstatus("NP");
		
		assertTrue("Problem in Adding the Cart Item", cartDAO.addCartItem(cartItem));
	}
	
	@Ignore
	public void deleteCartItemTest() {
		
		CartItem cartItem = new CartItem();
		cartItem = cartDAO.getCartItem(3);
		assertTrue("Problem in Delete the Cart Item", cartDAO.deleteCartItem(cartItem));
	}
	
	@Ignore
	public void updateCartItem() {
		
		CartItem cartItem = new CartItem();
		cartItem = cartDAO.getCartItem(4);
		cartItem.setProductId(2);
		cartItem.setProductName("Moto G3");
		cartItem.setQuantity(5);
		cartItem.setUsername("shbptl111");
		cartItem.setPstatus("NP");
		
		cartDAO.updateCartItem(cartItem);
		
		assertTrue("Problem in Updating the Cart Item", cartDAO.updateCartItem(cartItem));
	}
	
	@Ignore
	public void retrieveCartItem() {
		
		List<CartItem> listCartItems = cartDAO.retrieveCartItems("shbptl111");
		
		assertTrue("Problem in Retrieving the cart list", listCartItems.size()>0);
		
		for(CartItem cartItem:listCartItems) {
			System.out.print(cartItem.getProductName() + ":::");
			System.out.print(cartItem.getQuantity() + ":::");
			System.out.print(cartItem.getProductId());
			System.out.println();
		}
	}
	
	@Ignore
	public void getCartItem() {
		CartItem cartItem = new CartItem();
		cartItem = cartDAO.getCartItem(1);
		System.out.println(cartItem.getProductName());
		assertNotNull(cartDAO.getCartItem(1));
	}
	
	@AfterClass
	public static void executeLast() {
		context.close();
	}
}
