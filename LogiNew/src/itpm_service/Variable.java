package itpm_service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import itpm_model.*;

public class Variable {

	public ArrayList<Variables_model> variable(String code) {
		
		int count = 0;
		int method = 0;
		ArrayList<Variables_model> variablesList = new ArrayList<Variables_model>();
		
		String[] lines = code.split("\\r?\\n");
        for (String line : lines) {
        	
        	count++;
        	
            String[] sample_line_txt  = line.split("\"");
            int Global =0;
            int local=0;
            int composite=0;
            
            for (int i=1;i<=sample_line_txt.length;i++) {
        		
            	if(i%2==1) {
            		
            		String smpl_line =sample_line_txt[i-1];
            		
        			String str= smpl_line.replaceAll("\\{","@X@");
        			
        			String mainString= smpl_line.replaceAll("\\s+","_");
            		
            		String rgx = "@X@"; 
            		Pattern txt_ptr = Pattern.compile(rgx, Pattern.CASE_INSENSITIVE);
            		Matcher txt_mtr = txt_ptr.matcher(str);
            		while (txt_mtr.find())
            		{
            			method++;
            		}
            		
            		if(method==1) {
        				
        				String rgx1 = "_boolean_|_byte_|_char_|_double_|_float_|_int_|_long_|_short_|_String_"; 
                		Pattern txt_ptr1 = Pattern.compile(rgx1, Pattern.CASE_INSENSITIVE);
                		Matcher txt_mtr1 = txt_ptr1.matcher(mainString);
                		while (txt_mtr1.find())
                		{
                			String rgx2 = ";"; 
                    		Pattern txt_ptr2 = Pattern.compile(rgx2, Pattern.CASE_INSENSITIVE);
                    		Matcher txt_mtr2 = txt_ptr2.matcher(smpl_line);
                    		while (txt_mtr2.find())
                    		{
                    			String line_var= smpl_line.substring(txt_mtr1.end(),txt_mtr2.start());
                    			String[] var_arr  = line_var.split("=\\,\\;");
                    			for(int k = 0; k < var_arr.length; k++) {
                    				String[] var_arr1  = line_var.split(",");
                    				for(int m = 0; m < var_arr1.length; m++) {
                						Global++;
                    				}
                                }
                    		}
                    		
                    		String str1 = smpl_line.replaceAll("\\d+", "_X_");
                    		String str2 = str1.replaceAll("\\[", "@");
                    		String str3 = str2.replaceAll("\\]", ".");
                    		String rgx3 = "@_X_.|@."; 
                    		Pattern txt_ptr3 = Pattern.compile(rgx3, Pattern.CASE_INSENSITIVE);
                    		Matcher txt_mtr3 = txt_ptr3.matcher(str3);
                    		while (txt_mtr3.find())
                    		{
                    			String rgx4 = ";"; 
                        		Pattern txt_ptr4 = Pattern.compile(rgx4, Pattern.CASE_INSENSITIVE);
                        		Matcher txt_mtr4 = txt_ptr2.matcher(smpl_line);
                        		while (txt_mtr4.find())
                        		{
                        			String line_var= smpl_line.substring(txt_mtr1.end(),txt_mtr4.start());
                        			String[] var_arr  = line_var.split("=\\,\\;");
                        			for(int k = 0; k < var_arr.length; k++) {
                        				String[] var_arr1  = line_var.split(",");
                        				for(int m = 0; m < var_arr1.length; m++) {
                    						composite++;
                        				}
                                    }
                        		}
                    		}
                    		
                		}
                		String rgx4 = "_Dimension_"; 
                		Pattern txt_ptr4 = Pattern.compile(rgx4, Pattern.CASE_INSENSITIVE);
                		Matcher txt_mtr4 = txt_ptr4.matcher(mainString);
                		while (txt_mtr4.find())
                		{
                			composite++;
                		}
        				
        			}
            		
            		
            		if(method>1) {
            			String rgx1 = "if|while|do|for"; 
                		Pattern txt_ptr1 = Pattern.compile(rgx1, Pattern.CASE_INSENSITIVE);
                		Matcher txt_mtr1 = txt_ptr1.matcher(smpl_line);
                		
            			if(!txt_mtr1.find()) {
            				String rgx3 = "_boolean_|_byte_|_char_|_double_|_float_|_int_|_long_|_short_|_String_"; 
                    		Pattern txt_ptr3 = Pattern.compile(rgx3, Pattern.CASE_INSENSITIVE);
                    		Matcher txt_mtr3 = txt_ptr3.matcher(mainString);
                    		while (txt_mtr3.find())
                    		{
                    			String rgx2 = ";"; 
                        		Pattern txt_ptr2 = Pattern.compile(rgx2, Pattern.CASE_INSENSITIVE);
                        		Matcher txt_mtr2 = txt_ptr2.matcher(smpl_line);
                        		while (txt_mtr2.find())
                        		{
                        			String line_var= smpl_line.substring(txt_mtr3.end(),txt_mtr2.start());
                        			String[] var_arr  = line_var.split("=\\,\\;");
                        			for(int k = 0; k < var_arr.length; k++) {
                        				String[] var_arr1  = line_var.split(",");
                        				for(int m = 0; m < var_arr1.length; m++) {
                    						local++;
                        				}
                                    }
                        		}
                        		

                        		String str1 = smpl_line.replaceAll("\\d+", "_X_");
                        		String str2 = str1.replaceAll("\\[", "@");
                        		String str3 = str2.replaceAll("\\]", ".");
                        		String rgx4 = "@_X_.|@."; 
                        		Pattern txt_ptr4 = Pattern.compile(rgx4, Pattern.CASE_INSENSITIVE);
                        		Matcher txt_mtr4 = txt_ptr4.matcher(str3);
                        		while (txt_mtr4.find())
                        		{
                        			String rgx5 = ";"; 
                            		Pattern txt_ptr5 = Pattern.compile(rgx5, Pattern.CASE_INSENSITIVE);
                            		Matcher txt_mtr5 = txt_ptr2.matcher(smpl_line);
                            		while (txt_mtr5.find())
                            		{
                            			String line_var= smpl_line.substring(txt_mtr3.end(),txt_mtr5.start());
                            			String[] var_arr  = line_var.split("=\\,\\;");
                            			for(int k = 0; k < var_arr.length; k++) {
                            				String[] var_arr1  = line_var.split(",");
                            				for(int m = 0; m < var_arr1.length; m++) {
                    							composite++;
                            				}
                                        }
                            		}
                        		}
                    		}
                    		
                    		String rgx4 = "_Dimension_"; 
                    		Pattern txt_ptr4 = Pattern.compile(rgx4, Pattern.CASE_INSENSITIVE);
                    		Matcher txt_mtr4 = txt_ptr4.matcher(mainString);
                    		while (txt_mtr4.find())
                    		{
                    			composite++;
                    		}
            			}
            		}
            	}
            }
            Variables_model list = new Variables_model();
            
            list.setLine(line);
            list.setLineNumber(count);
            list.setComposite(composite);
            list.setGlobal(Global);
            list.setLocal(local);

            variablesList.add(list);
        }
		return variablesList;
		
	}
	
}
