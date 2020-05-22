package itpm_service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import itpm_model.*;

public class Control {

	public ArrayList<Control_model> control(String code,int conditionz,int loops,int weightSwitch,int weightCase) {
		
	        int count = 0;
	        int if_weight = conditionz;
	        int loop = loops;
	        int wgt_Switch = weightSwitch;
	        int wgt_Case = weightCase;
	        
	        String control="";
	        boolean checkCon=false;
	        ArrayList<Control_model> list = new ArrayList<Control_model>();

	        String[] lines = code.split("\\r?\\n");
	        for (String line : lines) {
	            count++;
	            String[] sample_line_txt  = line.split("\"");
	            
	            int no_Of_Control=0;
	            int lps_Count=0;
	            int cndtn_count=0;
	            int cnt_Switch=0;
	            int wgt_line=0;
	            int case_cnt=0;
	            int cspps=0;
	            
	            for (int i=1;i<=sample_line_txt.length;i++) {
	        		
	            	if(i%2==1) {
	            		
	            		String test =sample_line_txt[i-1];
	            		
	        			String str_test= (test.replaceAll("\\s+","_")).replaceAll("\\(","@");
	        			String test_reg = "do@|if@|while@|case_|switch@|do_@|if_@|while_@|switch_@|for_@|for@"; 
	            		Pattern pattern = Pattern.compile(test_reg, Pattern.CASE_INSENSITIVE);
	            		Matcher matcher = pattern.matcher(str_test);
	            		while (matcher.find())
	            		{
	            			no_Of_Control++;
	            			
	            			String str_test2= test.replaceAll("\\s+","");
	            			String str_test3= str_test2.replaceAll("\\(","@");
	            			String test_reg1 = "if@"; 
	                		Pattern test_ptr1 = Pattern.compile(test_reg1, Pattern.CASE_INSENSITIVE);
	                		Matcher test_mt1 = test_ptr1.matcher(str_test3);
	                		while (test_mt1.find())
	                		{
	                			control = control+"if#";
	                			cndtn_count++;
	                		}
	                		
	                		String test_reg2 = "for@"; 
	                		Pattern test_ptr2 = Pattern.compile(test_reg2, Pattern.CASE_INSENSITIVE);
	                		Matcher test_mt2 = test_ptr2.matcher(str_test3);
	                		while (test_mt2.find())
	                		{
	                			control = control+"for#";
	                			lps_Count++;
	                		}

	            			String str_test4= str_test2.replaceAll("\\{","@");
	                		String test_reg3 = "do@"; 
	                		Pattern test_ptr3 = Pattern.compile(test_reg3, Pattern.CASE_INSENSITIVE);
	                		Matcher test_mt3 = test_ptr3.matcher(str_test4);
	                		while (test_mt3.find())
	                		{
	                			control = control+"do#";
	                			lps_Count++;
	                		}
	                		
	                		String test_reg4 = "while@"; 
	                		Pattern test_ptr4 = Pattern.compile(test_reg4, Pattern.CASE_INSENSITIVE);
	                		Matcher test_mt4 = test_ptr4.matcher(str_test3);
	                		while (test_mt4.find())
	                		{
	                			String str_test5= str_test2.replaceAll("\\)","@");
	                			String str_test6= str_test5.replaceAll("\\{","-.X");
	                			
	                			String test_reg5 = "@-.X"; 
	                    		Pattern test_ptr5 = Pattern.compile(test_reg5, Pattern.CASE_INSENSITIVE);
	                    		Matcher test_mt5 = test_ptr5.matcher(str_test6);
	                    		while (test_mt5.find())
	                    		{
	                    			control = control+"while#";
	                    			lps_Count++;
	                    		}
	                		}
	                		
	            			String test_reg6 = "switch@"; 
	                		Pattern test_ptr6 = Pattern.compile(test_reg6, Pattern.CASE_INSENSITIVE);
	                		Matcher test_mt6 = test_ptr6.matcher(str_test3);
	                		while (test_mt6.find())
	                		{
	                			control = control+"switch#";
	                			cnt_Switch++;
	                		}
	                		
	                		String test_reg7 = "@@"; 
	                		Pattern ptrn7 = Pattern.compile(test_reg7, Pattern.CASE_INSENSITIVE);
	                		Matcher test_mt7 = ptrn7.matcher(test.replaceAll("\\&&","@@"));
	                		while (test_mt7.find())
	                		{
	                			no_Of_Control++;
	                		}
	                		checkCon=true;
	            		}
	            		
	            		if(checkCon) {
	            			String str_test1= (test.replaceAll("\\s+","_")).replaceAll("\\}","@@");
	            			String test_reg1 = "@@"; 
	                		Pattern test_ptr1 = Pattern.compile(test_reg1, Pattern.CASE_INSENSITIVE);
	                		Matcher matcher1 = test_ptr1.matcher(str_test1);
	                		while (matcher1.find())
	                		{
	                			if(control!="") {
	                				String[] lop  = control.split("#");
	                				control="";
	                				for(int j=0;j<lop.length-1;j++) {
	                					control=control+lop[j]+"#";
	                				}
	                			}
	                		}
	            		}
	            	}
	            }
	            
	            case_cnt=no_Of_Control-cnt_Switch-lps_Count-cndtn_count;
	            
	            if(no_Of_Control>0) {
	            	wgt_line=(cnt_Switch*wgt_Switch)+case_cnt+(lps_Count*loop)+(cndtn_count*if_weight);
	            	
	                String[] lop  = control.split("#");
	                if(lop.length>1) {
	                	int current=lop.length;
	                	
	                	for(int j=0;j<current-1;j++) {
	                		
	                		if(lop[j].equals("if")) {
	                			cspps=cspps+if_weight;
	                		}else if(lop[j].equals("for")||lop[j].equals("do")||lop[j].equals("while")) {
	                			cspps=cspps+loop;
	                		}else if(lop[j].equals("switch")) {
	                			cspps=cspps+wgt_Switch;
	                		}
	                		
	                	}
	                	
	                }
	            	
	            }
	            
	            Control_model control_model = new Control_model();
	            
	            control_model.setLine(line);
	            control_model.setLineNumber(count);
	            control_model.setCspps(cspps);
	            control_model.setLine_weight(wgt_line);
	            control_model.setNo_of_control(no_Of_Control);
	            
	            list.add(control_model);
	            
	        }
			
	        return list;
			
	    }
	
}
