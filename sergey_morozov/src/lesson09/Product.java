package lesson09;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	@XmlElement
	private String code;
	@XmlElement
	private String name;
	@XmlElement
	private BigDecimal price;

	/**
	 * Creates new product
	 * @param code product code
	 * @param name product name
	 * @param price product price
	 */
	public Product() {
		
	}
	public Product(String code, String name, BigDecimal price) {
		super();
		if ( code == null ) {
			throw new IllegalArgumentException("code must not be null");
		}
		if ( name == null ) {
			throw new IllegalArgumentException("name must not be null");
		}
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	public Product(String code, String name, double price) {	
		this(code, name, new BigDecimal(price) );
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		String s = String.format("Product {code=%s, name=%s, price=%s}", code, name, price);
		return s;
	}
	
}
