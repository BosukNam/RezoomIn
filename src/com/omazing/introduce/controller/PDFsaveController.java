package com.omazing.introduce.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.html.simpleparser.StyleSheet;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * PDF문서를 작성하는 컨트롤러
 * @author nam
 */
@Controller
public class PDFsaveController {
	
	/**
	 * 자기소개서 미리보기 PDF문서를 작성하는 메소드
	 * @param request 요청객체
	 * @param response 응답객체
	 * @param html HTML로 작성된 미리보기 컨텐츠
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/PDF_i.do", method=RequestMethod.POST)
	public void makeIntroducePDF(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("html") String html) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String file = request.getSession().getServletContext().getRealPath("/introduce.pdf");
		  
		  PdfWriter pdfWriter = null;       
		  
		  try{
		  
		    //create a new document   
		    Document document = new Document();       
		      
		    //get Instance of the PDFWriter    
		    pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(file));         
		    document.setPageSize(PageSize.A4);      
		    document.open();        
		    HTMLWorker htmlWorker = new HTMLWorker(document);
		    
		    
		    HashMap<String,Object> interfaceProps = new HashMap<String,Object>();
		     
		   
		    StyleSheet styles = new StyleSheet();
		    
		   
//		    DefaultFontProvider dfp=new DefaultFontProvider("//users//nam//Downloads//malgun.ttf"); // 남보석 컴퓨터 절대경로
		    DefaultFontProvider dfp=new DefaultFontProvider(request.getSession().getServletContext().getRealPath("/resources/css/malgun.ttf"));
		    //폰트 파일 설정 (한글 나오게 하기 위해 설정 필요함
		    interfaceProps.put(HTMLWorker.FONT_PROVIDER,dfp);

		    
		    StringBuffer sb = new StringBuffer();
		    sb.append("<h1 style=\"font-weight: bold;\">자기소개서</h1><br>"); // PDF_i url로 왔을 경우,, 각각 접근 url마다 맞는 제목 달아줘야함~~
		       sb.append(html);
		    
		    System.out.println("html:"+sb.toString());
		    
		    StringReader strReader = new StringReader(sb.toString());
		    List<Element> objects = htmlWorker.parseToList(strReader, styles, interfaceProps);
		    
		    for (int k = 0; k < objects.size(); ++k){
		     document.add((Element) objects.get(k));
		    }
		    document.close();   
		    //close the writer    
		    pdfWriter.close();
		    
		    
		 // create file. 
			File f = new File(file);
			
			// set for download excel file.
			String contentType = request.getContentType();
			response.setContentType("x-msdownload");
			
		    if (contentType == null) {
		        if (request.getHeader("user-agent").indexOf("MSIE 5.5") != -1)
		            response.setContentType("doesn/matter;");
		        else
		            response.setContentType("application/octet-stream");
		    } else {
		        response.setContentType(contentType);
		    }
		    
		    response.setHeader("Content-Transfer-Encoding:", "binary");
		    response.setHeader("Content-Disposition", "attachment;filename=" + "introduce.pdf" + ";"); // 이부분도~~
		    response.setHeader("Content-Length", "" + f.length());
		    response.setHeader("Pragma", "no-cache;");
		    response.setHeader("Expires", "-1;");

		    byte b[] = new byte[1024];
			BufferedInputStream fin = new BufferedInputStream(new FileInputStream(f));
			BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());

			try{
				int read = 0;
				while ((read = fin.read(b)) != -1)
				{
					outs.write(b,0,read);
				}

			}catch (Exception e){
			}finally{
				if (outs!=null) outs.close();
				if (fin!=null) fin.close();
			}
			
			try{
				if (f.exists()) f.delete();
			}catch(Exception e){}    

		  }catch(Exception e){
		   e.printStackTrace();
		  }
	}
	
	/**
	 * 이력서 미리보기 PDF문서를 작성하는 메소드
	 * @param request 요청객체
	 * @param response 응답객체
	 * @param html HTML로 작성된 미리보기 컨텐츠
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/PDF_r.do", method=RequestMethod.POST)
	public void makeResumePDF(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("html") String html) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String file = request.getSession().getServletContext().getRealPath("/resume.pdf");
		  
		  PdfWriter pdfWriter = null;       
		  
		  try{
		  
		    //create a new document   
		    Document document = new Document();       
		      
		    //get Instance of the PDFWriter    
		    pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(file));         
		    document.setPageSize(PageSize.A4);      
		    document.open();        
		    HTMLWorker htmlWorker = new HTMLWorker(document);
		    
		    
		    HashMap<String,Object> interfaceProps = new HashMap<String,Object>();
		     
		   
		    StyleSheet styles = new StyleSheet();
		    
		   
//		    DefaultFontProvider dfp=new DefaultFontProvider("//users//nam//Downloads//malgun.ttf"); // 남보석 컴퓨터 절대경로
		    DefaultFontProvider dfp=new DefaultFontProvider(request.getSession().getServletContext().getRealPath("/resources/css/malgun.ttf"));
		    //폰트 파일 설정 (한글 나오게 하기 위해 설정 필요함
		    interfaceProps.put(HTMLWorker.FONT_PROVIDER,dfp);

		    
		    StringBuffer sb = new StringBuffer();
		    sb.append("<h1 style=\"font-weight: bold;\">이력서</h1><br>"); // PDF_i url로 왔을 경우,, 각각 접근 url마다 맞는 제목 달아줘야함~~
		       sb.append(html);
		    
		    System.out.println("html:"+sb.toString());
		    
		    StringReader strReader = new StringReader(sb.toString());
		    List<Element> objects = htmlWorker.parseToList(strReader, styles, interfaceProps);
		    
		    for (int k = 0; k < objects.size(); ++k){
		     document.add((Element) objects.get(k));
		    }
		    document.close();   
		    //close the writer    
		    pdfWriter.close();
		    
		    
		 // create file. 
			File f = new File(file);
			
			// set for download excel file.
			String contentType = request.getContentType();
			response.setContentType("x-msdownload");
			
		    if (contentType == null) {
		        if (request.getHeader("user-agent").indexOf("MSIE 5.5") != -1)
		            response.setContentType("doesn/matter;");
		        else
		            response.setContentType("application/octet-stream");
		    } else {
		        response.setContentType(contentType);
		    }
		    
		    response.setHeader("Content-Transfer-Encoding:", "binary");
		    response.setHeader("Content-Disposition", "attachment;filename=" + "resume.pdf" + ";"); // 이부분도~~
		    response.setHeader("Content-Length", "" + f.length());
		    response.setHeader("Pragma", "no-cache;");
		    response.setHeader("Expires", "-1;");

		    byte b[] = new byte[1024];
			BufferedInputStream fin = new BufferedInputStream(new FileInputStream(f));
			BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());

			try{
				int read = 0;
				while ((read = fin.read(b)) != -1)
				{
					outs.write(b,0,read);
				}

			}catch (Exception e){
			}finally{
				if (outs!=null) outs.close();
				if (fin!=null) fin.close();
			}
			
			try{
				if (f.exists()) f.delete();
			}catch(Exception e){}    

		  }catch(Exception e){
		   e.printStackTrace();
		   
		  }
	}
	
}
