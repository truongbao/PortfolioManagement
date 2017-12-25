package utility;

import org.apache.commons.io.FilenameUtils;

public class RenameFile {
 
 public static String renameFile(String fileName){
      return FilenameUtils.getBaseName(fileName)+"-"+System.nanoTime()+"."+FilenameUtils.getExtension(fileName);
 }
 
}