package com.oreilly.servlet.multipart;
import java.io.*;

public class MyFileRenamePolicy implements FileRenamePolicy {

    private String userId;
	
	public MyFileRenamePolicy(String userId) {
		super();
		this.userId = userId;
	}

	public File rename(File f) {
		
		String name = f.getName();
        String body = null;
        String ext = null;

        int dot = name.lastIndexOf(".");
        if (dot != -1) {
             body = name.substring(0, dot);
             ext = name.substring(dot);  // includes "."
        }
        else {
             body = name;
             ext = "";
        }
        
        name =  body + "."+userId+ ext;
        
        f = new File(f.getParent(), name);
        
        int count = 0;
        while (!createNewFile(f) && count < 9999) {
             count++;
             String newName = name + "."+ count + ext;
             f = new File(f.getParent(), newName);
        }
        return f;
     }
     
     private boolean createNewFile(File f) {
          try {
                return f.createNewFile();
          }
          catch (IOException ignored) {
               return false;
          }
     }


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
     
}

