package shalini.dataProcessing;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Handler {
 public Date dateTimeFormatterHandler(String text) throws ParseException {
	Date date = null;
	if(text!=null && !text.equals("")) {
	if(text.contains(":")) {
		//System.out.println(text);
		DateFormat informat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		DateFormat outputformat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		 String datea = outputformat.format(informat.parse(text));
		// System.out.println(datea);
		 date = outputformat.parse(datea);
		
	}
	else {
		   if(text.contains("/") || text.contains("\\") || text.contains("-")) {
			SimpleDateFormat informat = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat outputformat = new SimpleDateFormat("yyyy-MM-dd");
			 String datea = outputformat.format(informat.parse(text));
			 System.out.println(datea);
			 date = outputformat.parse(datea);
		   }
		   else {
			   String year=text.substring(0, 4);
			   String month = text.substring(4,6);
			   String dates = text.substring(6,8);
			   String formattedDate = year+"-"+month+"-"+dates;
			   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			   date = format.parse(formattedDate);
			   
		   }
	}
	}
	
	
	return date;
 }
 
 public Integer parsingIntData(String text) {
	 Integer data = null;
	// System.out.println("Hellooo!!");
//	 System.out.println(text);
	 if(text!=null && !text.equals("")) {
	//	 System.out.println("Hellooo!!");
		 data = Integer.parseInt(text);
	//	 System.out.println(data);
	 }
	 return data;
 }
 
 public Long getLongParsedData(String text) {
	 Long data = null;
	 if(text!=null && !text.equals("")) {
		 data = Long.parseLong(text.replaceAll("\\D+", ""));
	 }
	 return data;
 }
 
 public Double getDoubleParsedData(String text) {
	 Double data = null;
	 if(text!=null && !text.equals("")) {
		 data = Double.parseDouble(text);
	 }
	 return data;
 }
}
