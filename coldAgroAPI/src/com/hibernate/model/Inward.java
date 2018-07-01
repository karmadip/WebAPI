package com.hibernate.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Inward")
public class Inward{
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	String inwardNo;
	@Temporal(TemporalType.TIMESTAMP)
	Date date;
	@OneToOne(cascade = CascadeType.ALL)
	Party party;
	String customerName;
	String mobileNo;
	String address;
	String chamberNo;
	String blockNo;
	String chargeType;
	boolean isLimitCycle;
	int noOfLimit;
	boolean isFixMonth;
	int noOfFixMonth;
	boolean isLoadChargesPaid;
	float loadCharges;
	boolean showCharges;
	String vehicleNo;
	@Temporal(TemporalType.TIMESTAMP)
	Date createdDate;
	String createdBy;
	
	@OneToMany(mappedBy="inward",cascade = CascadeType.ALL)
	Set<InwardProduct> inwardProducts;

	public Set<InwardProduct> getInwardProducts() {
		return inwardProducts;
	}



	public void setInwardProducts(Set<InwardProduct> inwardProducts) {
		this.inwardProducts = inwardProducts;
	}



	public String getInwardNo() {
		return inwardNo;
	}



	public void setInwardNo(String inwardNo) {
		this.inwardNo = inwardNo;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Party getParty() {
		return party;
	}



	public void setParty(Party party) {
		this.party = party;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getChamberNo() {
		return chamberNo;
	}



	public void setChamberNo(String chamberNo) {
		this.chamberNo = chamberNo;
	}



	public String getBlockNo() {
		return blockNo;
	}



	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}



	public String getChargeType() {
		return chargeType;
	}



	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}



	public boolean isLimitCycle() {
		return isLimitCycle;
	}



	public void setIsLimitCycle(boolean isLimitCycle) {
		this.isLimitCycle = isLimitCycle;
	}



	public int getNoOfLimit() {
		return noOfLimit;
	}



	public void setNoOfLimit(int noOfLimit) {
		this.noOfLimit = noOfLimit;
	}



	public boolean isFixMonth() {
		return isFixMonth;
	}



	public void setIsFixMonth(boolean isFixMonth) {
		this.isFixMonth = isFixMonth;
	}



	public int getNoOfFixMonth() {
		return noOfFixMonth;
	}



	public void setNoOfFixMonth(int noOfFixMonth) {
		this.noOfFixMonth = noOfFixMonth;
	}



	public boolean isIsLoadChargesPaid() {
		return isLoadChargesPaid;
	}



	public void setIsLoadChargesPaid(boolean isLoadChargesPaid) {
		this.isLoadChargesPaid = isLoadChargesPaid;
	}



	public float getLoadCharges() {
		return loadCharges;
	}



	public void setLoadCharges(float loadCharges) {
		this.loadCharges = loadCharges;
	}



	public boolean isShowCharges() {
		return showCharges;
	}



	public void setIsShowCharges(boolean showCharges) {
		this.showCharges = showCharges;
	}



	public String getVehicleNo() {
		return vehicleNo;
	}



	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}



	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	@Override
	public String toString() {
		return "Inward [inwardNo=" + inwardNo + ", date=" + date + ", party=" + party + ", customerName=" + customerName
				+ ", mobileNo=" + mobileNo + ", address=" + address + ", chamberNo=" + chamberNo + ", blockNo="
				+ blockNo + ", chargeType=" + chargeType + ", isLimitCycle=" + isLimitCycle + ", noOfLimit=" + noOfLimit
				+ ", isFixMonth=" + isFixMonth + ", noOfFixMonth=" + noOfFixMonth + ", isLoadChargesPaid="
				+ isLoadChargesPaid + ", loadCharges=" + loadCharges + ", showCharges=" + showCharges + ", vehicleNo="
				+ vehicleNo + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", inwardProducts="
				+ inwardProducts + "]";
	}




	

	






	
	
}
