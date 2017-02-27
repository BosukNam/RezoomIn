package com.omazing.introduce.controller;
import java.io.IOException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactoryImp;
import com.itextpdf.text.pdf.BaseFont;
 
/**
 * 폰트 지원 클래스
 * @author nam
 */
public class DefaultFontProvider extends FontFactoryImp {
	/**
	 * 기본폰트
	 */
 private String _default;
 /**
  * 오버로딩 생성자
  * @param def 정의된 폰트
  */
 public DefaultFontProvider(String def) {
  _default = def;
 }
 // I believe this is the correct override, but there are quite a few others.
 /**
  * 폰트를 가져오는 재정의 된 메소드
  */
 public Font getFont(String fontname,String encoding, boolean embedded, float size,int style, BaseColor color) {
  try {
   return new Font(BaseFont.createFont(_default, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 9, style, BaseColor.BLACK);
  } catch (DocumentException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  return null;
 }
}