package com.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "InwardProduct")
public class InwardProduct {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String lotNo;
	int goodsTypeId;
	int goodsUnit;
	double quantity;
	float charge;
	int remainingQuantity;
	String weight;
	
	@ManyToOne
    @JoinColumn(name="inward", nullable=false)
    private Inward inward;


	public Inward getInward() {
		return inward;
	}

	public void setInward(Inward inward) {
		this.inward = inward;
	}

	public String getLotNo() {
		return lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

	public int getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public double getGoodsUnit() {
		return goodsUnit;
	}

	public void setGoodsUnit(int goodsUnit) {
		this.goodsUnit = goodsUnit;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public float getCharge() {
		return charge;
	}

	public void setCharge(float charge) {
		this.charge = charge;
	}

	public int getRemainingQuantity() {
		return remainingQuantity;
	}

	public void setRemainingQuantity(int remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}


}
