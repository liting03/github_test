import java.io.FileWriter;
import java.util.Arrays;
import java.io.Writer;
import java.util.List;

import java.util.ArrayList; 


//Default separator
char SEPARATOR = ',';

//function write line in csv
public void writeLine(FileWriter writer, String[] params, char separator)
{
   boolean firstParam = true;

   StringBuilder stringBuilder = new StringBuilder();
   String param = "";
   //log.info("--------params------"+params);
   
   for (int i = 0; i < params.length; i++)
   {
      //get param
      param = params[i];
      //log.info(param);
       
         //if the first param in the line, separator is not needed
       if (!firstParam) 
       {
           stringBuilder.append(separator);
       }

         //Add param to line
       stringBuilder.append(param);
       //log.info("--param----"+param);
       firstParam = false;
   }

   //prepare file to next line
   stringBuilder.append("\r\n");
   //stringBuilder.append("\r");

   //add to file the line
   //log.info("------"+stringBuilder.toString());
   writer.append(stringBuilder.toString());

}

// 清空已有的文件内容，以便下次重新写入新的内容
public static void clearInfoForFile(String fileName) {
    File file =new File(fileName);
    try {
        if(!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter =new FileWriter(file);
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


//读取文件内容，文件中的内容为String
   public static List readInfoFromFile(String fileName) {
        File file =new File(fileName);
        if(!file.exists()) {
            return null;
        }
        List resultStr =new ArrayList();
        try {
            BufferedReader bufferedReader =new BufferedReader(new FileReader(file));
            String str =null;
            while(null !=(str=bufferedReader.readLine())) {
                resultStr.add(str);
            }
        }catch (IOException e) {
            e.printStackTrace();
	    file.close();
        }

        return resultStr;
    }

//读取指定文件内容，文件中的内容为String
   public static List readInfoFromFile(String fileName, String id, String value) {
        File file =new File(fileName);
        if(!file.exists()) {
            return null;
        }
        List resultStr =new ArrayList();
        try {
            BufferedReader bufferedReader =new BufferedReader(new FileReader(file));
            String str =null;
            Integer idx = 0;
            Integer key_idx = 0;
            while(null !=(str=bufferedReader.readLine())) {
			log.info("-----****----"+ idx.toString()+"---"+str.toString());
			String [] tmpStr = str.split(",");
			if (idx==0) {
				resultStr.add(str);
				for( int i = 0; i < tmpStr.length; i ++) {
					if (id.equals(tmpStr[i])) {
						key_idx= i;
					}
				}
				idx++;
			}

			else if (value.equals(tmpStr[key_idx])){
				resultStr.add(str);	
			}                
            }
        }catch (IOException e) {
            e.printStackTrace();
	    file.close();
        }
	//log.info("-----****--0---"+resultStr.get(1).toString());
	//log.info("-----****--1---"+resultStr.get(1).toString());
        return resultStr;
    }