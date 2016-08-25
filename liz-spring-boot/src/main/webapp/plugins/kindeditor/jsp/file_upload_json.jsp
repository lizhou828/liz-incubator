<%@page import="com.shangkang.tools.PropertyHelper"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="com.shangkang.bo.FileUpload"%>
<%@page import="com.shangkang.tools.UtilHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.io.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="org.json.simple.*"%>
<%@ page
	import="org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper"%>
<%
	/**
	 * KindEditor JSP
	 * 
	 * 本JSP程序是演示程序，建议不要直接在实际项目中使用。
	 * 如果您确定直接使用本程序，使用之前请仔细确认相关安全设置。
	 * 
	 */

	//文件保存目录路径
	String urlPath = "include/images/imageTools/image/";
    String typeScope = "gif,jpg,jpeg,png,bmp";
    Long maxSize = 3000000000l;
    
    String moduleid  = request.getParameter("moduleid");
    
    String ms = getProperty(moduleid, FileUpload.FILE_SAVE_SIZE);
    String ts = getProperty(moduleid, FileUpload.FILE_SAVE_TYPE);
	String sp = getProperty(moduleid, FileUpload.FILE_SAVE_DIR);
    
    if(!UtilHelper.isEmpty(sp))
    	urlPath = sp;
    if(!UtilHelper.isEmpty(ts))
    	typeScope = ts;
    if(!UtilHelper.isEmpty(ms))
    	maxSize = Long.parseLong(ms);
    
    typeScope = typeScope.replace("image/", "").replace("file/", "").toUpperCase();

	String savePath = request.getSession().getServletContext()
			.getRealPath("/")
			+ urlPath;

	response.setContentType("text/html; charset=UTF-8");

	if (!ServletFileUpload.isMultipartContent(request))
	{
		out.println(getError("请选择文件。"));
		return;
	}
	
	//检查目录
	File uploadDir = new File(savePath);
	if (!uploadDir.isDirectory())
	{
		uploadDir.mkdirs();
	}
	
	//检查目录写权限
	if (!uploadDir.canWrite())
	{
		out.println(getError("上传目录没有写权限。"));
		return;
	}

	MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) request;
	//获得上传的文件名  
	String fileName = wrapper.getFileNames("imgFile")[0];
	//imgFile
	//获得文件过滤器  
	File file = wrapper.getFiles("imgFile")[0];
	//检查扩展名  
	String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
	if (!Arrays.<String> asList(typeScope.split(","))
			.contains(fileExt.toUpperCase()))
	{
		out.println(getError("上传文件扩展名是不允许的扩展名。\n只允许"
				+ typeScope + "格式。"));
		return;
	}
	//检查文件大小  
	if (file.length() > maxSize)
	{
		out.println(getError("上传文件大小超过限制。"));
		return;
	}
	//重构上传图片的名称   
	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	String newImageFileName = df.format(new Date());
	String newImgName = newImageFileName +  "." + fileExt;
	byte[] buffer = new byte[1024];
	//获取文件输出流  
	FileOutputStream fos = new FileOutputStream(savePath + "/"
			+ newImgName);
	
	//获取内存中当前文件输入流  
	InputStream in = new FileInputStream(file);
	
	
	String newImgSavePath = savePath + "/" + newImgName;
	try
	{
		int num = 0;
		while ((num = in.read(buffer)) > 0)
		{
			fos.write(buffer, 0, num);
		}
		fos.close();
		
	} catch (Exception e)
	{
		e.printStackTrace(System.err);
	} finally
	{
		in.close();
		fos.close();
	}
	//发送给 KE  
	JSONObject obj = new JSONObject();
	obj.put("error", 0);
	obj.put("url", savePath + "/" + newImgName);
	///zswz/attached/image/20111129/  image 20111129195421_593.jpg  
	out.println(obj.toJSONString());
	//System.out.println("检查目录写权限2");
%>
<%!private String getError(String message)
	{
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj.toJSONString();
	}
	
	/**
	 * 到资源文件获得值
	 * @param moduleId
	 * @param property
	 * @return
	 */
	public String getProperty(String moduleId, String property)
	{
		String value = PropertyHelper.getProperty("upload.properties", "upload." + moduleId + "." + property);
		
		if(value == null)
			value = PropertyHelper.getProperty("upload.properties", "upload.default." + property);
		
		return value;
	}
	%>