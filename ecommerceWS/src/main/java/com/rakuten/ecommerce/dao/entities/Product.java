package com.rakuten.ecommerce.dao.entities;

import java.math.BigDecimal;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.rakuten.ecommerce.dao.ProductDao;
/**
 * @author Kshitiz Garg
 */
@Entity
@NamedQueries({
	@NamedQuery(name=ProductDao.FETCH_PRODUCT_BY_ID, query="SELECT p FROM Product p where p.productId = :" + Product.PRODUCT_ID)
})
@Table(name="Product")

public class Product {

	public static final String PRODUCT_ID = "productId";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductId", unique = true, nullable = false)
	private long productId;

	@Access(AccessType.FIELD)
	@Column(name = "ProductDesc", nullable = false)
	private String productDesc;

	@Access(AccessType.FIELD)
	@Column(name = "ProductCurrency", nullable = false)
	private String productCurrency;
	
	@Access(AccessType.FIELD)
	@Column(name = "PriceVal", nullable = false)
	private String priceVal;
	
	@Transient
	private transient BigDecimal priceValInDesiredCurrency;
	
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductCurrency() {
		return productCurrency;
	}

	public void setProductCurrency(String productCurrency) {
		this.productCurrency = productCurrency;
	}

	public String getPriceVal() {
		return priceVal;
	}

	public void setPriceVal(String priceVal) {
		this.priceVal = priceVal;
	}

	public BigDecimal getPriceValInDesiredCurrency() {
		return priceValInDesiredCurrency;
	}

	public void setPriceValInDesiredCurrency(BigDecimal priceValInDesiredCurrency) {
		this.priceValInDesiredCurrency = priceValInDesiredCurrency;
	}

}