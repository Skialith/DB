package testweb1.check;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//判断电话号码是不是数字
public class CheckForm {
	public static boolean isNotNumeric(String str){  
		  for (int i = str.length();--i>=0;){    
		   if (!Character.isDigit(str.charAt(i))){ 
			   //不是数字，返回true
		    return true;  
		   }  
		  }  
		  return false;  
		}
//判断是不是图片
	public static final boolean isImage(File file)throws IOException {
        boolean flag = true;
        try {
            BufferedImage bufreader = ImageIO.read(file);

    
            System.out.println("bufreader = " + bufreader);
            if (bufreader == null) {
                flag = false;
            } else {
            	//是图片
                flag = true;
            }
        } catch (IOException e) {
            flag = false;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
