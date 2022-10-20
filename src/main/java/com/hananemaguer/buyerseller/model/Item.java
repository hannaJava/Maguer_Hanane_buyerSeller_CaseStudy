package com.hananemaguer.buyerseller.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="item_name",nullable=false)
	private String itemName;
	
	@Column(name="item_price")
	private Double itemPrice;
	
	@Column(name="item_descrip")
	private String itemDescrip;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="seller_id",referencedColumnName ="id")
    private Seller seller;

	public Item(String itemName, Double itemPrice, String itemDescrip, Seller seller) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDescrip = itemDescrip;
		this.seller = seller;
	}
	
	/*@Column(name="item_qte")
	private Integer itemQte; */
	
	/*@Lob
	@Column(name="item_image") //columnDefinition ="MEDIUMBLOB",
	private String itemImage;
	//private MultipartFile itemImage;*/
	
}
