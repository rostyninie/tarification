package com.producttarification.tarification.models;

public class Product {
	
	private long productId;
	private String productCode;
	private Tarification tarification;
	
	public Product(long productId, String productCode, Tarification tarification) {
		this.productId = productId;
		this.productCode = productCode;
		this.tarification = tarification;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Tarification getTarification() {
		return tarification;
	}

	public void setTarification(Tarification tarification) {
		this.tarification = tarification;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result + (int) (productId ^ (productId >>> 32));
		result = prime * result + ((tarification == null) ? 0 : tarification.hashCode());
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
		Product other = (Product) obj;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (productId != other.productId)
			return false;
		if (tarification == null) {
			if (other.tarification != null)
				return false;
		} else if (!tarification.equals(other.tarification))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productCode=" + productCode + "]   tarification=" + tarification;
	}
	
	
}
