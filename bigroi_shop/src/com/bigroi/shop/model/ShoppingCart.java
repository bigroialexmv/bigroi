package com.bigroi.shop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Shopping cart
 *  
 * @author Alexander Medvedev
 *
 */
public class ShoppingCart {
	
	/* Объявление полей (fields) */
	
	private String id; 						// уникальный идентификатор корзины 
	
	private double discount;				// скидка в %
	
	private String discountCardId; 			// номер дисконтной карты
	
	private Double totalPrice; 				// стоимость всех покупок в корзине
	
	private Double totalDiscountPrice; 		// стоимость всех покупок в корзине c учетом скидки
	
	private List<ShoppingCartItem> items; 	// список покупок, добавленных в корзину
	
	public static final String TO_STRING_FORMAT = "{id={0}, discount={1}}";
	
	/**
	 * Creates new cart
	 * <p>
	 * Создает новую корзину по умолчанию, инициализирует поля id, items
	 * 
	 */
	public ShoppingCart() { 						// конструктор класса ShoppingCart
		id = UUID.randomUUID().toString(); 			// генерируется уникальный ключ с помощью класса java.util.UUID
		items = new ArrayList<ShoppingCartItem>(); 	// создается объект Список, в который можно добавлять покупки
	}
	
	public ShoppingCart(String id) {
		this.id = id;
	}
	
	/**
	 * Returns unique cart ID
	 * <p>
	 * Возвращает уникальный идентификатор корзины
	 * @return ID корзины
	 */	
	public String getId() {
		return id;
	}
	
	public String getDiscountCardId() {
		return discountCardId;
	}

	public void setDiscountCardId(String discountCardId) {
		this.discountCardId = discountCardId;
	}
	
	public Double getTotalPrice() {
		return totalPrice;
	}
	

	public Double getTotalDiscountPrice() {
		return totalDiscountPrice;
	}
	

	/**
	 * Adds new shpping item to the cart
	 * <p>
	 * Добавляет новый товар в корзину
	 * @param item
	 */
	public void addItem(ShoppingCartItem item) {
		items.add( item );
	}
	

	/**
	 * Returns array of shopping items added to the cart
	 * <p>
	 * Возвращает массив товаров, добавленных в корзину
	 * @return массив товаров
	 */
	public ShoppingCartItem[] getItems() {
		return items.toArray( new ShoppingCartItem[0] );
	}

}
