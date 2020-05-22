package itpm_service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import itpm_model.*;

public class Size {
	
	public ArrayList<Sizes_model> size(String code) {
		
		int count = 0;
		String code_variable="";
		ArrayList<Sizes_model> sizeList = new ArrayList<Sizes_model>();
		
		String[] lines = code.split("\\r?\\n");
        for (String line : lines) {
        	count++;
            String[] sample_line_txt  = line.split("\"");
            
            int keyword=0;
    		int Numerical=0;
    		int stringCount = 0;
    		int identifier = 0;
    		int operator=0;
            
            for (int i=1;i<=sample_line_txt.length;i++) {
        		
            	if(i%2==1) {
            		
            		String test =sample_line_txt[i-1];
            		
            		String regex = "abstract_|boolean_|break_|byte_|case_|catch_|char_|class_|continue_|default_|do_|double_|else_|enum_|extends_|final_|finally_|float_|for_|if_|implements_|instanceof_|interface_|long_|new_|null_|package_|private_|protected_|public_|return_|short_|String_|static_|strictfp_|super_|switch_|synchronized_|this_|throw_|throws_|transient_|try_|void_|volatile_|while_"; 
            		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            		Matcher matcher = pattern.matcher(test.replaceAll("\\s+","_"));
            		while (matcher.find())
            		{
            			keyword++;
            		}
            		
            		String str = test.replaceAll("\\d+", "_X@X_");
            		
            		String rgx1 = "_X@X_";
            		Pattern pttrn1 = Pattern.compile(rgx1, Pattern.CASE_INSENSITIVE);
            		Matcher mtchr1 = pttrn1.matcher(str);
            		while (mtchr1.find())
            		{
            			Numerical++;
            		}
            		
            		String rgx2 = "boolean|byte|char|double|float|int|long|short|String|Dimension"; 
            		Pattern pttrn2 = Pattern.compile(rgx2, Pattern.CASE_INSENSITIVE);
            		Matcher mtchr2 = pttrn2.matcher(test);
            		while (mtchr2.find())
            		{
            			int first=0;
            			String rgx3 = ";"; 
                		Pattern pttrn3 = Pattern.compile(rgx3, Pattern.CASE_INSENSITIVE);
                		Matcher mtchr3 = pttrn3.matcher(test);
                		while (mtchr3.find())
                		{
                			if(first==0) {
                    			String line_var= test.substring(mtchr2.end(),mtchr3.start());
                    			String[] var_arr  = line_var.split("=\\,\\;");
                    			for(int k = 0; k < var_arr.length; k++) {
                    				String[] var_arr1  = line_var.split(",");
                    				for(int m = 0; m < var_arr1.length; m++) {
                    					String test_var =var_arr1[m];
                    					String[] test_arr  = test_var.split("=");
                    					test_arr[0]=test_arr[0].replaceAll("\\s+","");
                    					if(code_variable=="") {
                    						
                    						boolean suc=true;
                    						
                    						String strt4 = (test_arr[0].replaceAll("\\(", "_X@X_")).replaceAll("\\)", "_X@X_");
                    						
                    						String rgx4 = "_X@X_"; 
                    	            		Pattern pttrn4 = Pattern.compile(rgx4, Pattern.CASE_INSENSITIVE);
                    	            		Matcher mtchr4 = pttrn4.matcher(strt4);
                    	            		while (mtchr4.find())
                    	            		{
                    	            			suc=false;
                    	            		}
                    	            		
                    	            		if(suc) {
                    	            			code_variable =test_arr[0]+"=|"+test_arr[0]+"<|"+test_arr[0]+".XX-X.|="+test_arr[0]+"|<"+test_arr[0]+"|.X-X."+test_arr[0]+"|"+test_arr[0]+".X-X.|-"+test_arr[0]+"|"+test_arr[0]+"-|.X-X-X."+test_arr[0]+"|"+test_arr[0]+".X-X-X.|/"+test_arr[0]+"|"+test_arr[0]+"/|%"+test_arr[0]+"|"+test_arr[0]+"%";
                    	            		}
                    					}else {
                							boolean suc=true;
                    						
                    						String strt4 = (test_arr[0].replaceAll("\\(", "_X@X_")).replaceAll("\\)", "_X@X_");
                    						
                    						String rgx4 = "_X@X_"; 
                    	            		Pattern pttrn4 = Pattern.compile(rgx4, Pattern.CASE_INSENSITIVE);
                    	            		Matcher mtchr4 = pttrn4.matcher(strt4);
                    	            		while (mtchr4.find())
                    	            		{
                    	            			suc=false;
                    	            		}
                    	            		
                    	            		if(suc) {
                    	            			code_variable = code_variable+"|"+test_arr[0]+"=|"+test_arr[0]+"<|"+test_arr[0]+".XX-X.|="+test_arr[0]+"|<"+test_arr[0]+"|.X-X."+test_arr[0]+"|"+test_arr[0]+".X-X.|-"+test_arr[0]+"|"+test_arr[0]+"-|.X-X-X."+test_arr[0]+"|"+test_arr[0]+".X-X-X.|/"+test_arr[0]+"|"+test_arr[0]+"/|%"+test_arr[0]+"|"+test_arr[0]+"%";
                    	            		}
                        					
                    					}
                    				}
                                }
                			}
                			first++;
                		}
            		}
            		
            		if(code_variable!="") {
            			String strt1= test.replaceAll("\\s+","");
            			String strt2= strt1.replaceAll("\\+",".X-X.");
            			String strt3= strt2.replaceAll("\\*",".X-X-X.");
            			String strt4= strt3.replaceAll("\\)",".XX-X.");
            			String rgx5 = code_variable; 
	            		Pattern pttrn5 = Pattern.compile(rgx5, Pattern.CASE_INSENSITIVE);
	            		Matcher mtchr5 = pttrn5.matcher(strt4);
	            		while (mtchr5.find())
	            		{
	            			identifier++;
	            		}
            		}
            		
            		String strt1= test.replaceAll("\\s+","_");
            		String rgx6 = "class_|interface_|void_"; 
            		Pattern pttrn6 = Pattern.compile(rgx6, Pattern.CASE_INSENSITIVE);
            		Matcher mtchr6 = pttrn6.matcher(strt1);
            		while (mtchr6.find())
            		{
            			identifier++;
            			
            			int x=0,y=0;
            			
                		String rgx7 = ","; 
                		Pattern pttrn7 = Pattern.compile(rgx7, Pattern.CASE_INSENSITIVE);
                		Matcher mtchr7 = pttrn7.matcher(test);
                		while (mtchr7.find())
                		{
                			x++;
                		}
                		
                		String rgx8 = ","; 
                		Pattern pttrn8 = Pattern.compile(rgx8, Pattern.CASE_INSENSITIVE);
                		Matcher mtchr8 = pttrn8.matcher(test);
                		while (mtchr8.find())
                		{
                			y++;
                		}
            			
                		if(x>0) {
                			identifier=identifier+x+1;
                		}
                		
                		if(y>0) {
                			identifier=identifier+y+1;
                		}
                		
            		}
            		
            		boolean imp=true;
            		
            		String rgx7 = "import_"; 
            		Pattern pttrn7 = Pattern.compile(rgx7, Pattern.CASE_INSENSITIVE);
            		Matcher mtchr7 = pttrn7.matcher(strt1);
            		while (mtchr7.find())
            		{
            			imp=false;
            		}
            		
            		if(imp) {
	            		
	            		String strg= conn(test);
	            		String rgx8 = "&&|@@|.X-1@3.X@";
	            		Pattern pttrn8 = Pattern.compile(rgx8, Pattern.CASE_INSENSITIVE);
	            		Matcher mtchr8 = pttrn8.matcher(strg);
	            		while (mtchr8.find())
	            		{
	            			operator++;
	            		}
            		}
            		
            	}else {
            		String string = sample_line_txt[i-1];
            		for(int k = 0; k < string.length(); k++) {    
                        if(string.charAt(k) != ' ')    
                        	stringCount++;    
                    }
            		stringCount = stringCount + string.replaceAll("[^ ]", "").length();
            	}
            }
            
            Sizes_model list = new Sizes_model();
            
            list.setIdentifier(identifier);
            list.setKeyword(keyword);
            list.setLine(line);
            list.setLineNumber(count);
            list.setNumerical(Numerical);
            list.setOperator(operator);
            list.setStringCount(stringCount);
            
            sizeList.add(list);
          
        }
		
        return sizeList;
        
	}
	
	private String conn(String test) {
		String tst1= test.replaceAll("\\*;","");
		String tst2= tst1.replaceAll("\\.",".X-1@3.X@");
		String strt1= tst2.replaceAll("\\|=",".X-1@3.X@");
		String strt2= strt1.replaceAll("\\|","@");
		String strt3= strt2.replaceAll("\\!=",".X-1@3.X@");
		String strt4= strt3.replaceAll("\\>=",".X-1@3.X@");
		String strt5= strt4.replaceAll("\\<=",".X-1@3.X@");
		String strt6= strt5.replaceAll("\\==",".X-1@3.X@");
		String strt7= strt6.replaceAll("\\++",".X-1@3.X@");
		String strt8= strt7.replaceAll("\\--",".X-1@3.X@");
		String strt9= strt8.replaceAll("\\<<<",".X-1@3.X@");
		String strt10= strt9.replaceAll("\\>>>",".X-1@3.X@");
		String strt11= strt10.replaceAll("\\>>",".X-1@3.X@");
		String strt12= strt11.replaceAll("\\<<",".X-1@3.X@");
		String strt13= strt12.replaceAll("\\~",".X-1@3.X@");
		String strt14= strt13.replaceAll("\\^",".X-1@3.X@");
		String strt15= strt14.replaceAll("\\->",".X-1@3.X@");
		String strt16= strt15.replaceAll("\\::",".X-1@3.X@");
		String strt17= strt16.replaceAll("\\+=",".X-1@3.X@");
		String strt18= strt17.replaceAll("\\-=",".X-1@3.X@");
		String strt19= strt18.replaceAll("\\*=",".X-1@3.X@");
		String strt20= strt19.replaceAll("\\/=",".X-1@3.X@");
		String strt21= strt20.replaceAll("\\>>>=",".X-1@3.X@");
		String strt22= strt21.replaceAll("\\&=",".X-1@3.X@");
		String strt23= strt22.replaceAll("\\%=",".X-1@3.X@");
		String strt24= strt23.replaceAll("\\<<=",".X-1@3.X@");
		String strt25= strt24.replaceAll("\\>>=",".X-1@3.X@");
		String strt26= strt25.replaceAll("\\^=",".X-1@3.X@");
		String strt27= strt26.replaceAll("\\+",".X-1@3.X@");
		String strt28= strt27.replaceAll("\\-",".X-1@3.X@");
		String strt29= strt28.replaceAll("\\*",".X-1@3.X@");
		String strt30= strt29.replaceAll("\\/",".X-1@3.X@");
		String strt31= strt30.replaceAll("\\%",".X-1@3.X@");
		String strt32= strt31.replaceAll("\\=",".X-1@3.X@");
		
		return strt32.replaceAll("\\,",".X-1@3.X@");
	}

}
