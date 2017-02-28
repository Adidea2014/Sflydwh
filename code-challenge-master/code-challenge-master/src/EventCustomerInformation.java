package com.vzw.is.vzwutils.httpclient.util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

	
	public class EventCustomerInformation {
		
		//Delimiter used in CSV file
		private static final String COMMA_DELIMITER = ",";
	
		private static final String NEW_LINE_SEPARATOR = "\n";
		
		
		private static final int KEY = 0;
		private static final int LAST_NAME = 1;
		private static final int TOTAL_AMOUNT = 2;
		//CSV file header
		private static final String FILE_HEADER = "key,last_name,adr_city,adr_state,total_amount";
		private static final String FILE_HEADER_Writer = "key,last_name,total_amount,averageLifeSpan";
		
		
		public static void readCsvFile(String fileName) {

			BufferedReader fileReader = null;
			FileWriter fileWriter = null;
	     
	        try {
	        	
	        	//Create a new list of  to be filled by CSV file data 
	        	List<InputCustomerEvent> inputCustomerEvents = new ArrayList<InputCustomerEvent>();
	        	
	            String line = "";
	            
	            //Create the file reader
	            fileReader = new BufferedReader(new FileReader(fileName));
	            
	            //Read the CSV file header to skip it
	            fileReader.readLine();
	            
	            //Read the file line by line starting from the second line
	            while ((line = fileReader.readLine()) != null) {
	                //Get all tokens available in line
	                String[] tokens = line.split(COMMA_DELIMITER);
	                if (tokens.length > 0) {
	                	//Create a new  object and fill his  data
						InputCustomerEvent customerEvent = new InputCustomerEvent(tokens[KEY],tokens[LAST_NAME],Double.parseDouble(tokens[TOTAL_AMOUNT]));
						inputCustomerEvents.add(customerEvent);
					}
	            }
	            
	            //iterate customerEvent information
	            List<OutputCustomer> outputCustomer = new ArrayList<OutputCustomer>();
	            for (InputCustomerEvent inputCustomerEvent : inputCustomerEvents) {
	            	OutputCustomer outputCustomerInfo=new OutputCustomer();
	            	outputCustomerInfo.setKey(inputCustomerEvent.getKey());
	            	outputCustomerInfo.setLast_name(inputCustomerEvent.getLast_name());
	            	outputCustomerInfo.setTotal_amount(inputCustomerEvent.getTotal_amount());
	            	outputCustomerInfo.setAverageLifeSpan(getLifeSpanofCustomer(inputCustomerEvent.getTotal_amount()));
					System.out.println(outputCustomerInfo.toString());
					outputCustomer.add(outputCustomerInfo);
				}
	            
	            String fileNameWriter=System.getProperty("user.home")+"/Customer_Info1.csv";
	            fileWriter = new FileWriter(fileNameWriter);

				//Write the CSV file header
				fileWriter.append(FILE_HEADER_Writer.toString());
				
				//Add a new line separator after the header
				fileWriter.append(NEW_LINE_SEPARATOR);
				
				
				for (OutputCustomer outputCustomerInfo : outputCustomer) {
					fileWriter.append(outputCustomerInfo.getKey());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(outputCustomerInfo.getLast_name());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(outputCustomerInfo.getTotal_amount()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(outputCustomerInfo.getAverageLifeSpan());
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
	            
	        } 
	        catch (Exception e) {
	        	System.out.println("Error in CsvFileReader !!!");
	            e.printStackTrace();
	        } finally {
	            try {
	            	fileWriter.flush();
					fileWriter.close();
	            } catch (IOException e) {
	            	System.out.println("Error while closing fileReader !!!");
	                e.printStackTrace();
	            }
	        }

		}

	
		
		public static void main(String[] args) {
			String fileName = System.getProperty("user.home")+"/customer.txt";
			EventCustomerInformation.readCsvFile(fileName);
			
			
		}
		
		
		public static String getLifeSpanofCustomer(double averageCustomerValue)
		{
			String averageValue=null;
			
			double averageCustomerSpan=52*averageCustomerValue*10;
			
			averageValue=Double.toString(averageCustomerSpan);
			return averageValue;
		}
	}



