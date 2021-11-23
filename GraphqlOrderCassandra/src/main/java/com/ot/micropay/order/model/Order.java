package com.ot.micropay.order.model;

import lombok.Data;


import org.springframework.data.cassandra.core.mapping.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Table(value = "orders")
@Data
public class Order implements Serializable {

   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
    @Column("orderid")
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID orderId;
    
   //@CassandraType(type = CassandraType.Name.LIST)
   // @CassandraType(type = CassandraType.Name.LIST, typeArguments = { CassandraType.Name.Product } )
    @Column("product_list")
    private List<Product> productList;
    
    @Column("order_desc")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String orderDescription;
    
    @CassandraType(type = CassandraType.Name.TIMESTAMP)
    @Column("order_created_at")
    private Instant orderCreationTimestamp;
    
   

    public Order(String orderDescription, List<Product> productList,  Instant orderCreationTimestamp){
       this.orderId=UUID.randomUUID();
       this.orderDescription=orderDescription;
       this.productList=productList;
        this.orderCreationTimestamp = orderCreationTimestamp;
    }



	public UUID getOrderId() {
		return orderId;
	}



	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}



	public List<Product> getProductList() {
		return productList;
	}



	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}



	public String getOrderDescription() {
		return orderDescription;
	}



	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}



	public Instant getOrderCreationTimestamp() {
		return orderCreationTimestamp;
	}



	public void setOrderCreationTimestamp(Instant orderCreationTimestamp) {
		this.orderCreationTimestamp = orderCreationTimestamp;
	}
    
}
