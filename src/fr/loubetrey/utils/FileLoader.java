package fr.loubetrey.utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileLoader 
{
	public static String loadResource(String fileName) throws Exception 
	{
        String result = "";
        
//        try (InputStream in = Class.forName(FileLoader.class.getName()).getResourceAsStream(fileName) ; Scanner scanner = new Scanner(in, "UTF-8")) 
//        {
//            result = scanner.useDelimiter("\\A").next();
//        }
//        
//        Log.log(result, "FileLoader", false);
        
        BufferedReader br = null;
        FileReader fr = null;
        
        try
        {
        	fr = new FileReader(fileName);
        	br = new BufferedReader(fr);
        	
        	String current;
        	
        	while((current = br.readLine()) != null)
        	{
        		result += current + (current.startsWith("#") ? "\n" : "");
        	}
        	
        	br.close();
        	fr.close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        return result;
	}
}
