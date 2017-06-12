package test1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Parse {

	public static void main(String[] args) {
		String path = "F:\\pengxing\\人教小学语文1年级下册(家教机)(6.3).drm\\人教小学语文1年级下册(家教机)(6.3).drm.xls";
		Path file = Paths.get(path);
		try {
			List<String> lines = Files.readAllLines(file,  Charset.defaultCharset());
			
			 String fileName = new File(path).getName();
			 System.out.println("fileName " + fileName );

	            boolean isFirstRow = true;
	            for (int i = 1; i < lines.size(); i++)
	            {
	            	String line = lines.get(i);
	            	String[] tempLine = line.split("\\t");
	            	
	            	DianDuInfo temp = new DianDuInfo();
	                temp.bookName = tempLine[0];
	            
	                temp.imagePath = tempLine[1];
//	                if (temp.imagePath.endsWith(".jpg") && isFirstRow)
//	                {
//	                    temp.imagePath = "pic\\" + fileName + ".jpg";
//	                    isFirstRow = false;
//	                }
	                temp.imageContentType = tempLine[2];

	                temp.bookPage = tempLine[3];
	                temp.BookInfo = tempLine[4];
	                temp.ISBN = tempLine[5];

	                System.out.println("bookName " + temp.bookName + "\t imagePath " + temp.imagePath + " - page " + temp.bookPage +
	                    " -ISBN " + temp.ISBN);
	              //  dianDuInfos.Add(temp);
	            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
