<%@page import="com.shangkang.constant.ApplicationConstant"%>
<%@page import="com.shangkang.utils.ImageUtils"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="com.shangkang.utils.GraphicsMagick"%>
<%@page import="com.shangkang.bo.PhotoUpload"%>
<%@page import="com.shangkang.bo.FileUpload"%>
<%@page import="com.shangkang.tools.PropertyHelper"%>
<%@page import="com.shangkang.tools.UtilHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.io.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
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
    String typeScope = "gif,jpg,jpeg,png,bmp,jpg";
    Long maxSize = 3000000000l;
    
    String moduleid  = request.getParameter("moduleid");
    
    String ms = getProperty(moduleid, FileUpload.FILE_SAVE_SIZE);
    String ts = getProperty(moduleid, FileUpload.FILE_SAVE_TYPE);
	String sp = getProperty(moduleid, FileUpload.FILE_SAVE_DIR);
    
    if(!UtilHelper.isEmpty(sp))
    	urlPath = sp;
    if(!UtilHelper.isEmpty(ts)) {
    	typeScope = ts;
    	typeScope = typeScope.replaceAll("media/.+","");
    }
    if(!UtilHelper.isEmpty(ms))
    	maxSize = Long.parseLong(ms);
    
    typeScope = typeScope.replace("image/", "").toUpperCase();

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

	//创建文件夹
	/* SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	String ymd = sdf.format(new Date());
	savePath += ymd + "/";
	File dirFile = new File(savePath);
	if (!dirFile.exists())
	{
		dirFile.mkdirs();
	} */

	MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) request;
	//获得上传的文件名  
	String fileName = wrapper.getFileNames("imgFile")[0];
	//imgFile
	//获得文件过滤器  
	File file = wrapper.getFiles("imgFile")[0];
	//检查扩展名  
	String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1)
			.toLowerCase();
	if (!Arrays.<String> asList(typeScope.split(","))
			.contains(fileExt.toUpperCase()))
	{
		out.println(getError("上传文件扩展名是不允许的扩展名。\n只允许"
				+ typeScope.substring(0,typeScope.length() - 1) + "格式。"));
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
	FileOutputStream fos = new FileOutputStream(savePath + "/" + newImgName);
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
		//只有图片才调用此方法
		String newImgSavePathRgb = ImageUtils.convertCMYKtoRGB(newImgSavePath, fileExt, savePath, newImageFileName, false);
		if(!newImgSavePathRgb.equals(newImgSavePath))
		{
			newImgName = newImageFileName + ApplicationConstant.CMYK_RGB_IMG_SUFFIX +  "." + fileExt;
			newImgSavePath = newImgSavePathRgb;
		}
		if(PhotoUpload.MOD_PHOTO.equals(moduleid)){
			String PRESS_IMG = ServletActionContext.getServletContext().getRealPath("/include/images/logo.jpg");
			GraphicsMagick.pressImage(PRESS_IMG, newImgSavePath, 1, 0.1f, -45);
			
			GraphicsMagick.resize(newImgSavePath, PhotoUpload.PHOTO_IMG_SUFFIX, 150, 150);
		}
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
	obj.put("url", request.getContextPath() + sp + "/" + newImgName);
	obj.put("message", "文件" + fileName +"上传成功");
	obj.put("fileType", fileExt);
	obj.put("title", fileName);
	out.println(obj.toJSONString());
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