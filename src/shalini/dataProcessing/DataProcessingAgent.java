package shalini.dataProcessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

import shalini.model.InvoiceDetails;

public class DataProcessingAgent {
	public static void main(String args[]) throws SQLException {
		String line = "";  
		String splitBy = ",";  
		Handler object= new Handler();
		Connection con=null;
		PreparedStatement pst =null;
		try   
		{  
		 con=DatabaseConn.getConnection();

		String query = "insert into invoice_details(area_business,baseline_create_date,business_code,business_year,clear_date,cust_number,cust_payment_terms,doc_id,document_create_date,document_type,due_in_date,invoice_currency,invoice_id,is_open,name_customer,posting_date,posting_id,total_open_amount)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		con.setAutoCommit(false);
		pst = con.prepareStatement(query);
		//parsing a CSV file into BufferedReader class constructor  
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\shali\\Downloads\\Task\\dataset.csv")); 
		String headers = br.readLine();
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
		String[] row = line.split(splitBy);    // use comma as separator
		InvoiceDetails invoiceObject = new InvoiceDetails();
		invoiceObject.setBusinessCode(row[0]);
		invoiceObject.setCustNumber(row[1]);
		invoiceObject.setNameCustomer(row[2]);
		System.out.println("clearing date"+row[3]);
		invoiceObject.setClearDate(object.dateTimeFormatterHandler(row[3]));
		
		invoiceObject.setBusinessYear(object.getLongParsedData(row[4]));
		invoiceObject.setDocId(object.getLongParsedData(row[5]));
		invoiceObject.setPostingDate(object.dateTimeFormatterHandler(row[6]));
		invoiceObject.setDocumentCreateDate(object.dateTimeFormatterHandler(row[7]));
		invoiceObject.setDueDate(object.dateTimeFormatterHandler(row[8]));
		invoiceObject.setInvoiceCurrency(row[9]);
		invoiceObject.setDocumentType(row[10]);
	
		invoiceObject.setPostingId(object.parsingIntData(row[11]));
		invoiceObject.setBusinessArea(row[12]);
		invoiceObject.setTotalOpenAmt(object.getDoubleParsedData(row[13]));
		invoiceObject.setBaseLineDate(object.dateTimeFormatterHandler(row[14]));
		invoiceObject.setPaymentTerms(row[15]);
		invoiceObject.setInvoiceId(object.getLongParsedData(row[16]));
		invoiceObject.setIsOpen(Boolean.parseBoolean(row[17]));
		System.out.println(invoiceObject.getBaseLineDate()+","+invoiceObject.getTotalOpenAmt());
		pst.setString(1,invoiceObject.getBusinessArea());
		java.util.Date bseline= invoiceObject.getBaseLineDate();
		java.sql.Date dayDateSql = new java.sql.Date(bseline.getDate());
		pst.setDate(2,dayDateSql);
		pst.setString(3, invoiceObject.getBusinessCode());
		pst.setLong(4, invoiceObject.getBusinessYear());
		java.util.Date clearDate= invoiceObject.getClearDate();
		
		if(clearDate==null) {
			pst.setNull(5, Types.DATE);
		}
		else {
		java.sql.Date clearDateSql = new java.sql.Date(clearDate.getDate());
		pst.setDate(5, clearDateSql);
		}
		pst.setString(6, invoiceObject.getCustNumber());
		pst.setString(7, invoiceObject.getPaymentTerms());
		pst.setLong(8, invoiceObject.getDocId());
		java.util.Date docCreateDate= invoiceObject.getDocumentCreateDate();
		java.sql.Date docCreateDateSql = new java.sql.Date(docCreateDate.getDate());
		pst.setDate(9, docCreateDateSql);
		pst.setString(10,invoiceObject.getDocumentType());
		java.util.Date dueDate= invoiceObject.getDueDate();
		java.sql.Date dueDateSql = new java.sql.Date(dueDate.getDate());
		
		pst.setDate(11, dueDateSql);
		pst.setString(12, invoiceObject.getInvoiceCurrency());
		if(invoiceObject.getInvoiceId()==null) {
			pst.setNull(13, Types.BIGINT);
		}
		else {
		pst.setLong(13, invoiceObject.getInvoiceId());
		}
		pst.setBoolean(14,invoiceObject.getIsOpen());
		pst.setString(15, invoiceObject.getNameCustomer());
		java.util.Date postingDate= invoiceObject.getPostingDate();
		java.sql.Date postingDateSql = new java.sql.Date(postingDate.getDate());
		pst.setDate(16,postingDateSql);
		pst.setLong(17, invoiceObject.getPostingId());
		pst.setDouble(18, invoiceObject.getTotalOpenAmt());
		pst.addBatch();
		
		}  
		int affectedRows[]=pst.executeBatch();
		con.commit();
		}   
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}  
		finally{
		     if(pst!=null)
		        pst.close();
		if(con!=null)
		     con.close();
		}
	}
  
}
