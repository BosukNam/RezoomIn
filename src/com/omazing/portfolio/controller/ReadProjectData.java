package com.omazing.portfolio.controller;
/*package com.omazing.yj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omazing.yj.test.ProjectInfoDAO;





*//**
 * Servlet implementation class ReadProjectData
 *//*
public class ReadProjectData extends HttpServlet {

   private static final long serialVersionUID = 1L;

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	  request.setCharacterEncoding("utf-8");
	      response.setCharacterEncoding("utf-8");
	      String memberID="dydwn90";
	      
	      String state = request.getParameter("state");
	      String flag = request.getParameter("flag");
	     
    	  if(state.trim().equals("update")){
    		  if(flag.trim().equals("프로젝트 내용")){
    	      String checked = request.getParameter("checked");
    	      String project_no = request.getParameter("project_no");
	    	      
    		  UseSkillDAO usDAO = new UseSkillDAO();
	    		  
    		  System.out.println(checked);
    		  StringTokenizer checkToken = new StringTokenizer(checked);
	    		

		 	  usDAO.deleteUseSkil(Integer.parseInt(project_no));  
    		  while(checkToken.hasMoreTokens()){
    			  ;
    			 	usDAO.insertUseSkill(new UseSkillDTO(Integer.parseInt(checkToken.nextToken("/")), Integer.parseInt(project_no),"")); 
    		  } 
    	    }
	      }else if(state.trim().equals("search")){
	    	  if(flag.trim().equals("미리보기")){
	    		  
	    		  //수상경력 불러오기
	    		  AwardDAO awardDAO = new AwardDAO();
	    		  AwardDTO[] vo= awardDAO.selectAwardAll(memberID);
	    		  if(vo.length!=0){
	    			  ArrayList<AwardDTO> volist = new ArrayList<AwardDTO>(Arrays.asList(vo));
	    			  request.setAttribute("Award", volist);

	    		  }
	    		  //사용자 개인정보 불러오기
	    		  	PersonalInfoDAO personalInfoDAO = new PersonalInfoDAO();
					PersonalInfoDTO personalInfoVO = personalInfoDAO.selectPersonalInfoByID(memberID);
					
					String[] all = personalInfoVO.getAll();
					PersonalInfoBean personalBean = new PersonalInfoBean(all[1], all[2],
							all[3], all[4],  all[5], all[6], all[7]);
					
					request.setAttribute("profile", personalBean);
					
				  //프로그램 소개
		            ProgramContentDAO programIntroDAO = new ProgramContentDAO();
		            Map<Integer, ProgramContentDTO> data = programIntroDAO.selectProgramIntroByID(memberID, "projectIntro");
		            request.setAttribute("projectIntro", data);
				            
				  //개발 환경         
				  
				         
				  //라이브러리
				   LibraryDAO library=new LibraryDAO();
	               LibraryDTO selectLibrary = library.selectLibraryByID(memberID);
	               request.setAttribute("library", selectLibrary);
	               //프로그래밍 기술
				   ProgrammingSkillDAO proDAO = new ProgrammingSkillDAO();
				   Map<Integer,ProfileBean> list = proDAO.selectProgrammingSkillByID(memberID);
				   if(list.size()!=0)
					   request.setAttribute("programmingSkill", list);            
				   //UML 설계문서            	
				   System.out.println(list);
				   //차트
				   ChartDAO chartDAO=new ChartDAO();
				   ChartDTO chartVO=chartDAO.selectChartVOByRegitserNO(20);
				    if(chartVO!=null){
		           		 String[] items=new String[]{"","","","",""};
		           		 String[] datas=new String[]{"","","","",""};
		              
//		           		 StringTokenizer token_items=new StringTokenizer(chartVO.getItem(),"$");
//		           		 StringTokenizer token_datas=new StringTokenizer(chartVO.getData(),"/");
		           		 int i=0;
		           		 while(token_items.hasMoreTokens()&&token_datas.hasMoreTokens()&&i<5){
		           			 items[i]=token_items.nextToken();
		           			 datas[i]=token_datas.nextToken();
		           			 System.out.println("item : "+items[i]);
		           			 System.out.println("data : "+datas[i]);
		           		 }
		           		 request.setAttribute("chartItem", items);
		           		 request.setAttribute("chartData", datas);
		           		 
				    } 

		          //주요 역할 및 담당
		           String content = request.getParameter("content");
	               MajorRoleAndTransactionDAO mratDAO=new MajorRoleAndTransactionDAO();
	               Map<Integer, MajorRoleAndTransactionDTO> cDTO=mratDAO.selectMajorRoleAndTransactionByID(memberID);
				   request.setAttribute("MRAT", cDTO);           
	               
	               RequestDispatcher view = request.getRequestDispatcher("resources/views/showPortfolio.jsp");
	               view.forward(request,response);
	               
	    	  }else if("project".equals(flag)){
	    		  ProjectInfoDAO dao = new ProjectInfoDAO();
	    		  int register_no = dao.selectLatestRegisterNo("yeeee4");
	    		  
	    		  request.setAttribute("register_no", register_no);
	    		  RequestDispatcher view = request.getRequestDispatcher("resources/views/project.jsp");
	              view.forward(request,response);
	    	  }
	      }
    	  
	      
   }
   *//**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    *//*
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
      String memberID="dydwn90";
      //flag 종류 : intro, major_role, content
      String flag = "";
      String state = "";
      String content = "";
      String category = "";
      String picture = "";
      String registerNo = "";
       이미지 파일을 업로드 설정 및 처리
      int maxSize = 5 * 1024 * 1024;
	  String path = request.getServletContext().getRealPath("/");
	    
	  StringTokenizer token = new StringTokenizer(request.getContentType());
		
	  System.out.println(request.getContentType());
	
	  if(token.nextToken(";").equals("multipart/form-data")){
		  MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "UTF-8", new MyFileRenamePolicy(memberID));
		  if(mRequest.getFile("uploadfile")!=null){
			  picture = mRequest.getFile("uploadfile").toString();
		  }
		  content = mRequest.getParameter("content");
		  state = mRequest.getParameter("state");
		  flag = mRequest.getParameter("flag");
		  category = mRequest.getParameter("category");
		  registerNo = mRequest.getParameter("registerNo");
	  }
	  else{
		  flag=request.getParameter("flag");
		  state=request.getParameter("state");
		  category = request.getParameter("category");
	  }
		
      ////////////////////////
		
		
		
      System.out.println("post content : "+content);
      System.out.println("picture : "+picture);
      System.out.println("state : "+state);
      System.out.println("flag : "+flag);
      System.out.println("category : "+category);
      
      
      PrintWriter out=response.getWriter();
      JSONArray jdata=new JSONArray();
      JSONObject obj=null;
      if("search".equals(state.trim())){
         if("개 요".equals(flag.trim())){
        	
        	System.out.println(state);
            ProgramContentDAO programIntroDAO = new ProgramContentDAO();
            Map<Integer, ProgramContentDTO> data = programIntroDAO.selectProgramIntroByID(memberID, "projectIntro");
            if(!data.isEmpty()){
               content = request.getParameter("content");
               Collection<ProgramContentDTO> info_values=data.values();
               Iterator<ProgramContentDTO> info=info_values.iterator();
               ProgramContentDTO programIntro_info=info.next();
               obj=new JSONObject();
               obj.put("category", "projectIntro");
               obj.put("registerNo",programIntro_info.getRegisterNo());
               obj.put("content", programIntro_info.getContent());
               obj.put("picture", programIntro_info.getPicture());
               jdata.add(obj);
            }
            
            
            String field  = request.getParameter("field");   
            ProgrammingSkillDAO proDAO = new ProgrammingSkillDAO();
            Iterator<ProgrammingSkillDTO> list = proDAO.selectProgrammingSkillByField(memberID, field).values().iterator();
            while(list.hasNext()){
                  obj = new JSONObject();
                  ProgrammingSkillDTO dto = list.next();
                  obj.put("category", "developmentTool");
                  obj.put("type", dto.getType());
                  obj.put("name", dto.getName());
                  obj.put("rank", dto.getRank());
                  obj.put("field", dto.getField());
                  jdata.add(obj);
               }
               
            }
            else if("프로젝트 내용".equals(flag)){
            	if("Library".equals(category)){
            		LibraryDAO library=new LibraryDAO();
                    LibraryDTO selectLibrary = library.selectLibraryByID(memberID);
                    obj=new JSONObject();
                    obj.put("registerNo", selectLibrary.getRegisterNo());
                    obj.put("content", selectLibrary.getContent());
                    obj.put("picture", selectLibrary.getPicture());
                    jdata.add(obj);
               }
                     
               ArchitectureDAO architectureDAO=new ArchitectureDAO();
               Map<Integer, ArchitectureDTO> architectureMap= architectureDAO.selectArchitectureByID(memberID);
               if(!architectureMap.isEmpty()){
                  Collection<ArchitectureDTO> architectureCollection=architectureMap.values();
                  Iterator architecture=architectureCollection.iterator();
                  while(architecture.hasNext()){
                     ArchitectureDTO aDTO=(ArchitectureDTO)architecture.next();
                     obj=new JSONObject();
                     obj.put("registerNo", aDTO.getRegisterNo());
                     obj.put("content", aDTO.getContent());
                     obj.put("type", aDTO.getArchitectureType());
                     
                     jdata.add(obj);
                  }
               
               }
                  //아키텍처 contentCategory 분류해서 보내는 방법 생각하기
            	else if("useSkill".equals(category)){
            		String field  = request.getParameter("field");   
            		System.out.println("뭐야"+field);
                    ProgrammingSkillDAO proDAO = new ProgrammingSkillDAO();
                    Iterator<ProgrammingSkillDTO> list = proDAO.selectProgrammingSkillByField("yeeee4", field).values().iterator();
                          
                    while(list.hasNext()){
                          obj = new JSONObject();
                          ProgrammingSkillDTO dto = list.next();
                          obj.put("register_no", dto.getRegisterNo());
                          obj.put("name", dto.getName());
                          System.out.println(dto.getRegisterNo());
                          jdata.add(obj);
                    }
            	}
            	else if("systemArchitecture".equals(category)){
            		String config =request.getParameter("config");
            		String sort = request.getParameter("sort");
            		
            		System.out.println("config : " +config);
            		System.out.println("sort : " + sort);
            		
            	}
            }else if("차트".equals(flag)){
           	 registerNo=request.getParameter("registerNo");
           	 ChartDAO chartDAO=new ChartDAO();
           	 ChartVO chartVO=chartDAO.selectChartVOByRegitserNO(Integer.parseInt(registerNo));
           	 if(chartVO!=null){
           		 String[] items=new String[]{"","","","",""};
           		 String[] datas=new String[]{"","","","",""};
           		 
           		 obj=new JSONObject();
           		 obj.put("table_type", chartVO.getType());
           		 jdata.add(obj);
           		 StringTokenizer token_items=new StringTokenizer(chartVO.getItem(),"$");
           		 StringTokenizer token_datas=new StringTokenizer(chartVO.getData(),"/");
           		 int i=0;
           		 while(token_items.hasMoreTokens()&&token_datas.hasMoreTokens()&&i<5){
           			 items[i]=token_items.nextToken();
           			 datas[i]=token_datas.nextToken();
           			 System.out.println("item : "+items[i]);
           			 System.out.println("data : "+datas[i]);
           			 obj=new JSONObject();
           			 obj.put("table_item", items[i]);
           			 obj.put("table_data", datas[i++]);
           			 jdata.add(obj);
           		 }
           	 }
           	 
          }else{
               content = request.getParameter("content");
               MajorRoleAndTransactionDAO mratDAO=new MajorRoleAndTransactionDAO();
               Collection<MajorRoleAndTransactionDTO> cDTO=mratDAO.selectMajorRoleAndTransactionByID(memberID).values();
               if(!cDTO.isEmpty()){
                     Iterator<MajorRoleAndTransactionDTO> iDTO=cDTO.iterator();
                     MajorRoleAndTransactionDTO mratDTO=iDTO.next();
                  
                     obj=new JSONObject();
                     obj.put("content", mratDTO.getContent());
                     obj.put("registerNo", mratDTO.getRegisterNo());
                     jdata.add(obj);      
               }
          }
         out.println(jdata);
         out.flush();
         try{
            out.close();
         }catch(Exception e){
               
         }
      }
      else if("delete".equals(state))
      {
    	//삭제
          category=request.getParameter("category");
          registerNo=request.getParameter("registerNo");
          String msg="-1";
          boolean check = false;
          if("개 요".equals(flag)){
             if("projectIntro".equals(category)){
             	System.out.println(category);
             	
             	ProgramContentDAO programIntroDAO = new ProgramContentDAO();
             	check=programIntroDAO.deleteProgramIntroDTO(Integer.parseInt(registerNo));
             }
             
             else if("developmentTool".equals(category)){
             	ProgramContentDAO programIntroDAO = new ProgramContentDAO();
             	check=programIntroDAO.deleteProgramIntroDTO(Integer.parseInt(registerNo));
             }
          }else if("프로젝트 내용".equals(flag)){
         	 if("userDefinedContent".equals(category)){
              	ProgramContentDAO programIntroDAO = new ProgramContentDAO();
              	System.out.println(registerNo);
             	check=programIntroDAO.deleteProgramIntroDTO(Integer.parseInt(registerNo));
             	System.out.println(check);
         	 }
          }else if("차트".equals(flag)){
         	 System.out.println(registerNo);
         	 //projectIntro에 차트만 있었는 경우 projectIntro도 삭제 해야함
         	 check=true;
         	 //차트만 삭제하는 경우
         	 msg="CHART-DELETE";
          }else{
         	 if("majorRoleAndTransaction".equals(category)){
         		 System.out.println(category);
         		 
         		 MajorRoleAndTransactionDAO majorRoleDAO= new MajorRoleAndTransactionDAO();
         		 majorRoleDAO.deleteMajorRoleAndTransaction(Integer.parseInt(registerNo));
         	 }
          }
          if(!check){
         	 msg="0";
          }
          out.println(msg);
          out.flush();
          try{
         	 out.close();
          }catch(Exception e){
             
          }
    	 category=request.getParameter("category");
         registerNo=request.getParameter("registerNo");
         check = false;
         if("개 요".equals(flag)){
            if("projectIntro".equals(category)){
            	System.out.println("projectIntro");
               ProgramContentDAO programIntroDAO = new ProgramContentDAO();
               check=programIntroDAO.deleteProgramIntroDTO(Integer.parseInt(registerNo));
               
            }
            
         }else if("프로젝트 내용".equals(flag)){
        	 if("library".equals(category)){
        		 LibraryDAO liDAO = new LibraryDAO();
        		 File file = new File(liDAO.selectPictureByID(memberID));
     			try{
     				file.delete();
     			}catch(Exception e){
     				e.printStackTrace();
     			}
        		 check = liDAO.deleteLibrary(Integer.parseInt(registerNo));
        	 }
         }
         if(check){
         out.println("SUCCESS");
         }
         else{
        	 out.println("FAIL");
         }
         out.flush();
         try{
         out.close();
         }catch(Exception e){
            
         }
      }
      else if("insert".equals(state)){
    	  //등록
    	  category=request.getParameter("category");
    	  int check=-1;
    	  if("개 요".equals(flag)){
    		  //등록-개요
    		  if("projectIntro".equals(category)){
    			  picture=request.getParameter("picture");
    			  content=request.getParameter("content");
    			  ProgramContentDAO programIntroDAO = new ProgramContentDAO();
    			  ProgramContentDTO programIntro=new ProgramContentDTO(-1,memberID,picture, content,"projectIntro");
    			  check=programIntroDAO.insertProgramIntro(programIntro);
 
    			  out.println("programIntro: "+check);
    			  		
    		  } else if("developmentTool".equals(category)){
              	
              } 
    		  
    	  }else if("프로젝트 내용".equals(flag)){
		if("library".equals(category)){
        		 LibraryDAO liDAO = new LibraryDAO();
        		 LibraryDTO library = new LibraryDTO(-1, memberID, picture, content);
        		 check = liDAO.insertLibrary(library);
        		 out.println(check);
        	
        	 }else if("systemArchitecture".equals(category)){
           		String config =request.getParameter("config");
          		String sort = request.getParameter("sort");
          		
          		System.out.println("config : " +config);
          		System.out.println("sort : " + sort);
          		
          	 }
    		  //등록-프로젝트 내용\
    	 if("userDefinedContent".equals(category)){
    			  picture=request.getParameter("picture");
    			  content=request.getParameter("content");
    			  ProgramContentDAO programIntroDAO = new ProgramContentDAO();
    			  ProgramContentDTO programIntro=new ProgramContentDTO(-1,memberID,picture, content,"projectContent");
    			  check=programIntroDAO.insertProgramIntro(programIntro);
    			  System.out.println(check);
    	     }
    	  }else if("차트".equals(flag)){
    		  
    	  } else{
    		  //등록-프로젝트 주요 역할 및 담당
    		  if("majorRoleAndTransaction".equals(category)){
    			  content=request.getParameter("content");
    			  MajorRoleAndTransactionDAO majorRoleDAO=new MajorRoleAndTransactionDAO();
    			  MajorRoleAndTransactionDTO majorRoleDTO=new MajorRoleAndTransactionDTO(-1, memberID, content);
    			  check=majorRoleDAO.insertMajorRoleAndTransaction(majorRoleDTO);
    		  }
    	  }
    	  out.println(check);
    	  out.flush();
    	  try{
    		  out.close();
    	  }catch(Exception e){}
      }
      else{
    	//수정
    	  category=request.getParameter("category");
    	  registerNo=request.getParameter("registerNo");
    	  boolean check=false;
    	  if("개 요".equals(flag)){
    		  if("projectIntro".equals(category)){
	              picture=request.getParameter("picture");
	              content=request.getParameter("content");
	              ProgramContentDAO programIntroDAO = new ProgramContentDAO();
	              ProgramContentDTO programIntro=new ProgramContentDTO(Integer.parseInt(registerNo),memberID, picture, content ,"projectIntro");
	              check=programIntroDAO.updateProgramIntro(programIntro);
	              if(check){
	            	  out.println(registerNo);                  
	              } else{
	            	  out.println("-1");
	              }		
    		  
    		  }else if("developmentTool".equals(category)){
    			  
    		}
         }else if("프로젝트 내용".equals(flag)){
              if("library".equals(category)){
                 LibraryDAO liDAO = new LibraryDAO();
                 LibraryDTO liDTO = new LibraryDTO(Integer.parseInt(registerNo),memberID, picture,content);
                 System.out.println(picture);
                 if(!picture.equals("")){
                    File file = new File(liDAO.selectPictureByID(memberID));
                    try{
                       file.delete();
                       check = liDAO.updateLibrary(liDTO);
                    }catch(Exception e){
                       e.printStackTrace();
                    }
                 }
                 else
                    check = liDAO.updateContent(liDTO);
              }else if("userDefinedContent".equals(category)){
	              picture=request.getParameter("picture");
	              content=request.getParameter("content");
	              ProgramContentDAO programIntroDAO = new ProgramContentDAO();
	              ProgramContentDTO programIntro=new ProgramContentDTO(Integer.parseInt(registerNo),memberID, picture, content ,"projectContent");
	              check=programIntroDAO.updateProgramIntro(programIntro);
	             
        	  }
         
         } else if("차트".equals(flag)){
        	 String[] items = request.getParameterValues("item");
        	 String[] datas = request.getParameterValues("data");
        	 for(String item: items){
        		 System.out.println("item : "+item);
        	 }
        	 for(String data:datas){
        		 System.out.println("data : "+data);
        	 }
        	 System.out.println("registerNo : "+registerNo);
        	 System.out.println("category : "+category);
         }else{
        	 
        	 //주요 역할 및 담당
        	 if("majorRoleAndTransaction".equals(category)){
        		 content=request.getParameter("content");
        		 MajorRoleAndTransactionDAO majorRoleDAO=new MajorRoleAndTransactionDAO();
        		 MajorRoleAndTransactionDTO majorRoleDTO=new MajorRoleAndTransactionDTO(Integer.parseInt(registerNo), memberID, content);
        		 check=majorRoleDAO.updateMajorRoleAndTransaction(majorRoleDTO);
        		
        	 }
         }
    	 if(check){
 			 out.println(registerNo);
 		 }else{
 			 out.println("-1");
 		 }
         out.flush();
         try{
        	 out.close();
         }catch(Exception e){}
      }
	  response.setCharacterEncoding("utf-8");
	  PrintWriter out=response.getWriter();
	  String memberId="yeeee4";

	  ProjectInfoDAO piDAO=new ProjectInfoDAO();
	  //out.println(piDAO.insertProjectInfo("yeeee4", null));
	  //out.println(piDAO.selectLatestRegisterNo(memberId));
	  //out.println(piDAO.deleteProjectInfoByRegisterNo(4));
	  //out.println("update_name : "+piDAO.updateProjectName(1, "프로젝트제목"));
	  //out.println("project_intro : "+piDAO.updateIsProjectIntro(1, "1"));
	  //out.println("develop_tool : "+piDAO.updateIsDevelopTool(1, "1"));
	  //out.println("Role_And_Task : "+piDAO.updateIsRoleAndTask(1, "1"));
	  //out.println("use_tech_languate : "+piDAO.updateIsUseTechLanguage(1, "1"));
	  out.println("library : "+piDAO.updateIsLibrary(1, "1"));
	  out.println("software : "+piDAO.updateIsSoftwareArchitecture(1, "1"));
	  out.println("system : "+piDAO.updateIsSystemArchitecture(1, "1"));
	  out.println("user_define_content : "+piDAO.updateIsUserDefineContent(1, "1"));
	  out.println("project_date : "+piDAO.updateProjectDate(1, "20170101","20170131"));
	  out.println("project_people_no : "+piDAO.updatePeopleNo(1, 2));
	  
	  
	  //ProgramContentDAO content = new ProgramContentDAO();
	  //select-projectNo
	  Map<Integer,ProgramContentDTO> pc = content.selectProgramContentByProjectNo(1);
	  Set<Integer> set=pc.keySet();
	  Iterator<Integer> iterator=set.iterator();
	  while(iterator.hasNext()){
		  out.println(pc.get(iterator.next()));
	  }
	  //select-projectNo, content
	  Map<Integer,ProgramContentDTO> pc = content.selectProgramContentByProjectNo(1,new ProgramContentCategoryDTO("pc2","userdefined"));
	  Set<Integer> set=pc.keySet();
	  Iterator<Integer> iterator=set.iterator();
	  while(iterator.hasNext()){
		  out.println(pc.get(iterator.next()));
	  }
	  //select-registerNo
	  ProgramContentDTO pc=content.selectProgramContentByRegisterNo(2);
	  out.println(pc);
	  //out.println(content.insertProgramContent(new ProgramContentDTO(-1, 1, "","없음", "0", new ProgramContentCategoryDTO("pc2", "userdefined"))));
	  //out.println(content.selectLatestRegisterNo(1, new ProgramContentCategoryDTO("pc2", "userdefined")));
	  //update
	  //out.println(content.updateProgramContent(new ProgramContentDTO(7,1,"이미지","이미지경로","0",new ProgramContentCategoryDTO("pc2", "userdefined"))));
	  //ProgramContentCategoryDAO ppcDAO=new ProgramContentCategoryDAO();
	  Map<String,String> map=ppcDAO.selectProgramContentCategory();
	  Set<String> set=map.keySet();
	  Iterator<String> iterator=set.iterator();
	  while(iterator.hasNext()){
		  out.println(map.get(iterator.next()));
	  }
	  ProgramContentCategoryDTO pcc=ppcDAO.selectProgramContenCodeByCategory("intro");
	  out.println(pcc);
	  
	  ProgramContentCategoryDTO pcc=ppcDAO.selectProgramContentCategoryByCode("pc2");
	  out.println(pcc);
	  //ChartDAO chartDAO=new ChartDAO();
	  //out.println(chartDAO.selectChartByProgramContentNo(2));
	  //out.println(chartDAO.selectChartByRegisterNo(1));
	  //out.println(chartDAO.insertChart(new ChartDTO(0,2,new ChartCategoryDTO("ch1","bar"),"경로아직")));
	  //out.println(chartDAO.selectLatestRegisterNo(2));
	  
	  RoleAndTaskDAO rat=new RoleAndTaskDAO();
	  RoleAndTaskDTO dto=rat.selectRoleAndTaskByProjectNo(1);
	  out.println(dto);
	  
	  Map<Integer, RoleAndTaskDTO> map=rat.selectRoleAndTaskByRegisterNo(1);
	  Set<Integer> set=map.keySet();
	  Iterator<Integer> iterator=set.iterator();
	  
	  while(iterator.hasNext()){
		  out.println(map.get(iterator.next()));
	  }
	  
	  out.println(rat.insertRoleAndTask(new RoleAndTaskDTO(0,1,"주요역할 없음","담당업무없음")));
	  out.println(rat.selectLatestRegisterNo(1));
	  
	  //out.println(piDAO.deleteProjectInfoByRegisterNo(1));
	  ProjectInfoDAO pi=new ProjectInfoDAO();
	  //out.println(pi.deleteRolaAndTask(2));
	  out.println(pi.selectProjectInfo(7));
	  
	  out.flush();
	  
	  
   } 
   
}

*/
      
