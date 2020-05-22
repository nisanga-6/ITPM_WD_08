package itpm_service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import itpm_model.*;

public class Method {

	public ArrayList<Methods_model> method(String code) {
		
        int count = 0;
        ArrayList<Methods_model> list = new ArrayList<Methods_model>();
		
        String[] lines = code.split("\\r?\\n");
        for (String line : lines) {
        	
            count++;
            String[] sample_line_txt  = line.split("\"");
            
            int primitiveM=0;
            int compositeM=0;
            int primitiveP=0;
            int compositeP=0;
            
            for (int i=1;i<=sample_line_txt.length;i++) {
        		
            	if(i%2==1) {
            		
                    String test =sample_line_txt[i-1];

                    String str= test.replaceAll("\\s+","_");

                    String rgx_txt = "public_|protected_|private_"; 
                    Pattern pattern = Pattern.compile(rgx_txt, Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(str);
                    while (matcher.find())
                    {
                            String spl_txt1= test.replaceAll("\\s+","");
                            String spl_txt2= spl_txt1.replaceAll("\\)","@");
                            String spl_txt3= spl_txt2.replaceAll("\\{","._@1");

                            String rgx_txt1 = "@._@1"; 
                            Pattern txt_ptr1 = Pattern.compile(rgx_txt1, Pattern.CASE_INSENSITIVE);
                            Matcher txt_mtr1 = txt_ptr1.matcher(spl_txt3);
                            while (txt_mtr1.find())
                            {
                                boolean type=false;

                                String rgx_txt2 = "_void_"; 
                                Pattern txt_ptr2 = Pattern.compile(rgx_txt2, Pattern.CASE_INSENSITIVE);
                                Matcher txt_mtr2 = txt_ptr2.matcher(str);
                                while (txt_mtr2.find())
                                {
                                        type=true;
                                }
                                if(!type) {

                                        String spl_txt4= test.replaceAll("\\(","@@");
                                        String[] sample  = spl_txt4.split("@@");

                                        String spl_txt5= sample[0].replaceAll("\\s+","_");
                                        String rgx_txt3 = "_boolean_|_byte_|_char_|_double_|_float_|_int_|_long_|_short_|_String_"; 
                                        Pattern txt_ptr3 = Pattern.compile(rgx_txt3, Pattern.CASE_INSENSITIVE);
                                        Matcher txt_mtr3 = txt_ptr3.matcher(spl_txt5);
                                        while (txt_mtr3.find())
                                        {
                                                primitiveM++;
                                        }

                                        if(primitiveM==0) {
                                                compositeM++;
                                        }

                                        int data_types=0;

                                        String spl_txt6= sample[1].replaceAll("\\s+","_");
                                        String rgx_txt4 = "boolean_|byte_|char_|double_|float_|int_|long_|short_|String_"; 
                                        Pattern txt_ptr4 = Pattern.compile(rgx_txt4, Pattern.CASE_INSENSITIVE);
                                        Matcher txt_mtr4 = txt_ptr4.matcher(spl_txt6);
                                        while (txt_mtr4.find())
                                        {
                                                data_types++;
                                        }

                                        int parameters=1;

                                        String rgx_txt5 = ","; 
                                        Pattern txt_ptr5 = Pattern.compile(rgx_txt5, Pattern.CASE_INSENSITIVE);
                                        Matcher txt_mtr5 = txt_ptr5.matcher(sample[1]);
                                        while (txt_mtr5.find())
                                        {
                                                parameters++;
                                        }

                                        int no_para=0;

                                        String spl_txt7= sample[1].replaceAll("\\s+","");
                                        String spl_txt8= spl_txt7.replaceAll("\\)","@");
                                        String rgx_txt6 = "@@"; 
                                        Pattern txt_ptr6 = Pattern.compile(rgx_txt6, Pattern.CASE_INSENSITIVE);
                                        Matcher txt_mtr6 = txt_ptr6.matcher("@"+spl_txt8);
                                        while (txt_mtr6.find())
                                        {
                                                no_para++;
                                        }

                                        int comp=0;

                                        String spl_txt9= sample[1].replaceAll("\\[","@@");
                                        String rgx_txt9 = "@@"; 
                                        Pattern pattern9 = Pattern.compile(rgx_txt9, Pattern.CASE_INSENSITIVE);
                                        Matcher matcher9 = txt_ptr6.matcher(spl_txt9);
                                        while (matcher9.find())
                                        {
                                                comp++;
                                        }

                                        if(no_para!=0) {
                                                primitiveP=0;
                                                compositeP=0;
                                        }else if((data_types==parameters)&&comp==0){
                                                primitiveP=data_types;
                                                compositeP=0;
                                        }else if((data_types!=parameters)&&comp==0){
                                                primitiveP=data_types;
                                                compositeP=parameters-data_types;
                                        }else if((comp==parameters)&&data_types!=0){
                                                primitiveP=0;
                                                compositeP=parameters;
                                        }else{
                                                primitiveP=data_types;
                                                compositeP=parameters;
                                        }

                                }else {
                                	String spl_txt4= test.replaceAll("\\(","@@");
                                    String[] sample  = spl_txt4.split("@@");

                                    String spl_txt5= sample[1].replaceAll("\\s+","_");
                                    String rgx_txt3 = "Graphics_|MouseEvent_"; 
                                    Pattern txt_ptr3 = Pattern.compile(rgx_txt3, Pattern.CASE_INSENSITIVE);
                                    Matcher txt_mtr3 = txt_ptr3.matcher(spl_txt5);
                                    while (txt_mtr3.find())
                                    {
                                    	compositeP++;
                                    }
                                }
                            }
                    }
            	}
            }
            
            Methods_model method = new Methods_model();
            
            method.setLine(line);
            method.setLineNumber(count);
            method.setComposite_method(compositeM);
            method.setComposite_parameters(compositeP);
            method.setPrimitive_method(primitiveM);
            method.setPrimitive_parameters(primitiveP);

            list.add(method);
        }
        return list;
    }
	
}
