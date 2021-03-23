package shalini.model;

import java.util.Date;

public class InvoiceDetails {
  private String businessCode;
  private String custNumber;
  private String nameCustomer;
  private Date clearDate;
  private Long businessYear;
  private Long docId;
  private Date postingDate;
  private Date documentCreateDate;
  private Date dueDate;
  private String invoiceCurrency;
  private String documentType;
  private int postingId;
  private String businessArea;
  private Double totalOpenAmt;
  private Date baseLineDate;
  private String paymentTerms;
  private Long invoiceId;
  private boolean isOpen;
public String getBusinessCode() {
	return businessCode;
}
public void setBusinessCode(String businessCode) {
	this.businessCode = businessCode;
}
public String getCustNumber() {
	return custNumber;
}
public void setCustNumber(String custNumber) {
	this.custNumber = custNumber;
}
public String getNameCustomer() {
	return nameCustomer;
}
public void setNameCustomer(String nameCustomer) {
	this.nameCustomer = nameCustomer;
}
public Date getClearDate() {
	return clearDate;
}
public void setClearDate(Date clearDate) {
	this.clearDate = clearDate;
}
public Long getBusinessYear() {
	return businessYear;
}
public void setBusinessYear(Long businessYear) {
	this.businessYear = businessYear;
}
public long getDocId() {
	return docId;
}
public void setDocId(long docId) {
	this.docId = docId;
}
public Date getPostingDate() {
	return postingDate;
}
public void setPostingDate(Date postingDate) {
	this.postingDate = postingDate;
}
public Date getDocumentCreateDate() {
	return documentCreateDate;
}
public void setDocumentCreateDate(Date documentCreateDate) {
	this.documentCreateDate = documentCreateDate;
}
public Date getDueDate() {
	return dueDate;
}
public void setDueDate(Date dueDate) {
	this.dueDate = dueDate;
}
public String getInvoiceCurrency() {
	return invoiceCurrency;
}
public void setInvoiceCurrency(String invoiceCurrency) {
	this.invoiceCurrency = invoiceCurrency;
}
public String getDocumentType() {
	return documentType;
}
public void setDocumentType(String documentType) {
	this.documentType = documentType;
}
public int getPostingId() {
	return postingId;
}
public void setPostingId(int postingId) {
	this.postingId = postingId;
}
public String getBusinessArea() {
	return businessArea;
}
public void setBusinessArea(String businessArea) {
	this.businessArea = businessArea;
}
public Double getTotalOpenAmt() {
	return totalOpenAmt;
}
public void setTotalOpenAmt(Double totalOpenAmt) {
	this.totalOpenAmt = totalOpenAmt;
}
public Date getBaseLineDate() {
	return baseLineDate;
}
public void setBaseLineDate(Date baseLineDate) {
	this.baseLineDate = baseLineDate;
}
public String getPaymentTerms() {
	return paymentTerms;
}
public void setPaymentTerms(String paymentTerms) {
	this.paymentTerms = paymentTerms;
}
public Long getInvoiceId() {
	return invoiceId;
}
public void setInvoiceId(Long invoiceId) {
	this.invoiceId = invoiceId;
}
public boolean getIsOpen() {
	return isOpen;
}
public void setIsOpen(boolean b) {
	this.isOpen = b;
}
  
}
