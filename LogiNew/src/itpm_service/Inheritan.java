package itpm_service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import itpm_model.*;

public class Inheritan {

	public ArrayList<Inheritance_model> inheritance_model(String code) {
		
        int count = 0;
        int classCount=0;
        ArrayList<Inheritance_model> list = new ArrayList<Inheritance_model>();

        String[] lines = code.split("\\r?\\n");
        for (String line : lines) {
            count++;
            
            String[] sample_line_txt  = line.split("\"");
            String className=null;
            
            int direct=0;
            int indirect=0;
            
            for (int i=1;i<=sample_line_txt.length;i++) {
        		
            	if(i%2==1) {
            		
                    String test =sample_line_txt[i-1];

                    String str= test.replaceAll("\\s+","_");

                    String rgx_txt = "class_"; 
                    Pattern txt_ptr = Pattern.compile(rgx_txt, Pattern.CASE_INSENSITIVE);
                    Matcher txt_mt = txt_ptr.matcher(str);
                    while (txt_mt.find())
                    {
                            boolean ex=false;

                            String rgx_txt1 = "_extends_"; 
                            Pattern ptrn1 = Pattern.compile(rgx_txt1, Pattern.CASE_INSENSITIVE);
                            Matcher txt_mt1 = ptrn1.matcher(str);
                            while (txt_mt1.find())
                            {

                                ex=true;
                                String clsName = test.substring(txt_mt.end(),txt_mt1.start());

                                className=clsName.replaceAll("\\s+","");
                                
                                String rgx_txt4 = "_implements_"; 
                                Pattern ptrn4 = Pattern.compile(rgx_txt4, Pattern.CASE_INSENSITIVE);
                                Matcher txt_mt4 = ptrn4.matcher(str);
                                while (txt_mt4.find())
                                {
                                	boolean check=false;
                                	String testClass = test.substring(txt_mt1.end(),txt_mt4.start());
                                	
                                	String rgx_txt5 = "."; 
                                    Pattern ptrn5 = Pattern.compile(rgx_txt5, Pattern.CASE_INSENSITIVE);
                                    Matcher txt_mt5 = ptrn5.matcher(testClass);
                                    while (txt_mt5.find())
                                    {
                                    	check=true;
                                    }
                                    
                                    if(check) {
                                    	direct--;
                                    }
                                }
                                direct++;

                                String smpl_str1= str.replaceAll("\\{","@");

                                String rgx_txt2 = "_@|@"; 
                                Pattern ptrn2 = Pattern.compile(rgx_txt2, Pattern.CASE_INSENSITIVE);
                                Matcher txt_mt2 = ptrn2.matcher(smpl_str1);
                                while (txt_mt2.find())
                                {

                                        String extName = (test.substring(txt_mt1.end(),txt_mt2.start())).replaceAll("\\s+","");

                                        indirect=countingsLoop(code,extName,0);

                                }

                            }

                            if(ex==false) {

                                String smpl_str1= str.replaceAll("\\{","@");

                                String rgx_txt2 = "_@|@"; 
                                Pattern ptrn2 = Pattern.compile(rgx_txt2, Pattern.CASE_INSENSITIVE);
                                Matcher txt_mt2 = ptrn2.matcher(smpl_str1);
                                while (txt_mt2.find())
                                {
                                        String clsName = test.substring(txt_mt.end(),txt_mt2.start());

                                        className=clsName.replaceAll("\\s+","");

                                }
                            }
                    classCount++;
                    Inheritance_model inheritance_model = new Inheritance_model();

                    inheritance_model.setLineNumber(classCount);
                    inheritance_model.setClassName(className);
                    inheritance_model.setDirect(direct);
                    inheritance_model.setIndirect(indirect);

                    list.add(inheritance_model);

                    }
            		
            	}
            }
        }
		
        return list;
		
    }
	
    private int countingsLoop(String code,String ext,int indirect) {

        int count = 0;

        String[] lines = code.split("\\r?\\n");
        for (String line : lines) {
            count++;
            String[] sample_line_txt  = line.split("\"");

            for (int i=1;i<=sample_line_txt.length;i++) {

                if(i%2==1) {

                    String test =sample_line_txt[i-1];

                    String str= test.replaceAll("\\s+","");

                    String rgx_txt = "class"+ext; 
                    Pattern txt_ptr = Pattern.compile(rgx_txt, Pattern.CASE_INSENSITIVE);
                    Matcher txt_mt = txt_ptr.matcher(str);
                    while (txt_mt.find())
                    {
                            boolean ex=false;

                            String smpl_str1= test.replaceAll("\\s+","_");
                            String rgx_txt1 = "_extends_"; 
                            Pattern ptrn1 = Pattern.compile(rgx_txt1, Pattern.CASE_INSENSITIVE);
                            Matcher txt_mt1 = ptrn1.matcher(smpl_str1);
                            while (txt_mt1.find())
                            {
                                    ex=true;

                                    String smpl_str2= smpl_str1.replaceAll("\\{","@");

                                    String rgx_txt2 = "_@|@"; 
                            Pattern ptrn2 = Pattern.compile(rgx_txt2, Pattern.CASE_INSENSITIVE);
                            Matcher txt_mt2 = ptrn2.matcher(smpl_str2);
                            while (txt_mt2.find())
                            {

                                    String extName = (test.substring(txt_mt1.end(),txt_mt2.start())).replaceAll("\\s+","");

                                    indirect++;

                                    return countingsLoop(code,extName,indirect);

                            }
                            }

                            if(ex==false) {

                                    return indirect;

                            }

                    }

                }
            }
        }
        return indirect;
    }
	
}
