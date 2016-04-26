package com.zhenapp.controller.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TScriptInfoCustom;
import com.zhenapp.po.Custom.TTbaccountInfoCustom;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.service.ScriptInfoService;
import com.zhenapp.service.TbaccountInfoService;
import com.zhenapp.service.WebInfoService;

@Controller
@RequestMapping(value = "/util")
public class upload {
	
	
	@Autowired
	private WebInfoService webInfoService;
	@Autowired
	private ScriptInfoService scriptInfoService;
	@Autowired
	private TbaccountInfoService tbaccountInfoService;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	/*
	 * 上传web页面图片信息
	 */
	@RequestMapping(value = "/uploadwebinfo")
	public @ResponseBody
	ModelAndView uploadwebinfo(HttpServletRequest request,
			@RequestParam("files") MultipartFile[] files) throws Exception {
		ModelAndView mv = new ModelAndView();
		// 判断file数组不能为空并且长度大于0
		if (files != null && files.length > 0) {
			String webwww = request.getServerName();

			TWebInfoCustom tWebInfoCustom = webInfoService
					.findWebBywebwww(webwww);
			if (tWebInfoCustom != null) {
				tWebInfoCustom.setWebwww(webwww);

				// 循环获取file数组中得文件
				for (int i = 0; i < files.length; i++) {
					MultipartFile file = files[i];
					// 原始名称
					String originalFilename = file.getOriginalFilename();
					// 上传图片
					if (file != null && originalFilename != null
							&& originalFilename.length() > 0) {
						// 存储图片的物理路径
						String pic_path = request.getSession()
								.getServletContext().getRealPath("/")
								+ "bootstrap\\img\\index\\";
						// 新的图片名称
						String newFileName = UUID.randomUUID()
								+ originalFilename.substring(originalFilename
										.lastIndexOf("."));
						// 新图片
						File newFile = new File(pic_path + newFileName);
						// 将内存中的数据写入磁盘
						file.transferTo(newFile);

						if (i == 0) {
							tWebInfoCustom.setLogo(newFileName);
						} else if (i == 1) {
							tWebInfoCustom.setCarousel01(newFileName);
						} else if (i == 2) {
							tWebInfoCustom.setCarousel02(newFileName);
						} else if (i == 3) {
							tWebInfoCustom.setCarousel03(newFileName);
						} else if (i == 4) {
							tWebInfoCustom.setBg01(newFileName);
						} else if (i == 5) {
							tWebInfoCustom.setBg02(newFileName);
						}
					}
				}
			}
			HttpSession session = request.getSession();
			tWebInfoCustom.setUpdateuser(session.getAttribute("usernick")
					.toString());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String updatetime = sdf.format(new Date());
			tWebInfoCustom.setUpdatetime(updatetime);
			webInfoService.updateWebBywebwww(tWebInfoCustom);
		}
		mv.setViewName("/page/upload/webEdit.jsp");
		return mv;
	}

	/*
	 * 上传脚本信息
	 */
	@RequestMapping(value = "/uploadscript")
	public @ResponseBody
	ModelAndView uploadscript(HttpServletRequest request,
			@RequestParam("file") MultipartFile file) throws Exception {
		TScriptInfoCustom tScriptInfoCustom = new TScriptInfoCustom();
		HttpSession session = request.getSession();
		String usernick = session.getAttribute("usernick").toString();

		String time = sdf.format(new Date());
		ModelAndView mv = new ModelAndView();
		// 原始名称
		String originalFilename = file.getOriginalFilename();
		// 上传图片
		if (file != null && originalFilename != null
				&& originalFilename.length() > 0) {
			// 存储图片的物理路径
			// String pic_path =
			// request.getSession().getServletContext().getRealPath("/") +
			// "page/other/scriptfile/";
			String pic_path = "C:/webfile/scriptfile/";
			// 新的图片名称
			String newFileName = UUID.randomUUID()
					+ originalFilename.substring(originalFilename
							.lastIndexOf("."));
			// 新图片
			File newFile = new File(pic_path + newFileName);
			// 将内存中的数据写入磁盘
			file.transferTo(newFile);
			tScriptInfoCustom.setScriptpath(pic_path + newFileName);
			tScriptInfoCustom.setScriptname(originalFilename);
			tScriptInfoCustom.setCreatetime(time);
			tScriptInfoCustom.setCreateuser(usernick);
			tScriptInfoCustom.setUpdateuser(usernick);
			tScriptInfoCustom.setUpdatetime(time);
			tScriptInfoCustom.setScriptid(UUID.randomUUID().toString());
			scriptInfoService.insertScript(tScriptInfoCustom);
		}
		mv.setViewName("/page/other/uploadscript.jsp");
		return mv;
	}

	/*
	 * 上传淘宝账号信息
	 */
	@RequestMapping(value = "/uploadTbaccount", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody
	ModelAndView uploadTbaccount(HttpServletRequest request,
			@RequestParam("file") MultipartFile file) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String time = sdf.format(new Date());
		HttpSession session = request.getSession();
		String usernick = session.getAttribute("usernick").toString();
		ModelAndView mv = new ModelAndView();
		// 原始名称
		String originalFilename = file.getOriginalFilename();
		// 上传图片
		if (file != null && originalFilename != null
				&& originalFilename.length() > 0) {
			// 存储图片的物理路径
			String pic_path = request.getSession().getServletContext()
					.getRealPath("/")
					+ "page/other/tbaccount/";
			// 新的图片名称
			String newFileName = UUID.randomUUID()
					+ originalFilename.substring(originalFilename
							.lastIndexOf("."));
			// 新图片
			File newFile = new File(pic_path + newFileName);
			// 将内存中的数据写入磁盘
			file.transferTo(newFile);

			Reader reader = new InputStreamReader(new FileInputStream(newFile));
			String str = "";
			int tempchar;
			while ((tempchar = reader.read()) != -1) {
				// 对于windows下，\r\n这两个字符在一起时，表示一个换行。
				// 但如果这两个字符分开显示时，会换两次行。
				// 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
				if (((char) tempchar) != '\r') {
					str = str + (char) tempchar;
				}
			}
			reader.close();
			System.out.println(str);
			String[] strarr = str.split("\n");
			for (int i = 0; i < strarr.length; i++) {
				String[] tbaccount = strarr[i].split("\\|");

				TTbaccountInfoCustom tTbaccountInfoCustom = new TTbaccountInfoCustom();
				tTbaccountInfoCustom.setTbaccountid(UUID.randomUUID()
						.toString());
				tTbaccountInfoCustom.setTbaccountname(tbaccount[0]);
				tTbaccountInfoCustom.setTbaccountpwd(tbaccount[1]);
				if (tbaccount.length > 2) {
					tTbaccountInfoCustom.setTbaccountphoneid(tbaccount[2]);
				}
				tTbaccountInfoCustom.setCreatetime(time);
				tTbaccountInfoCustom.setCreateuser(usernick);
				tTbaccountInfoCustom.setUpdatetime(time);
				tTbaccountInfoCustom.setUpdateuser(usernick);
				tbaccountInfoService.insertTbaccount(tTbaccountInfoCustom);
			}

		}
		mv.setViewName("/page/pagestates/info.jsp");
		return mv;
	}

	@RequestMapping(value = "/downloadFile/{scriptid}")
	public void downloadFile(@PathVariable(value="scriptid") String scriptid, HttpServletResponse response,HttpServletRequest request)  {
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		try {
			
			TScriptInfoCustom tScriptInfoCustom = scriptInfoService.findScriptByid(scriptid);
			
			request.setCharacterEncoding("UTF-8");  
	        BufferedInputStream bis = null;  
	        BufferedOutputStream bos = null;  
	  
	        //获取下载文件路径
	        String downLoadPath = tScriptInfoCustom.getScriptpath();
	  
	        //获取文件的长度
	        long fileLength = new File(downLoadPath).length();  

	        //设置文件输出类型
	        response.setContentType("application/octet-stream");  
	        response.setHeader("Content-disposition", "attachment; filename="  
	                + new String(tScriptInfoCustom.getScriptname().getBytes("utf-8"), "ISO8859-1")); 
	        //设置输出长度
	        response.setHeader("Content-Length", String.valueOf(fileLength));  
	        //获取输入流
	        bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
	        //输出流
	        bos = new BufferedOutputStream(response.getOutputStream());  
	        byte[] buff = new byte[2048];  
	        int bytesRead;  
	        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
	            bos.write(buff, 0, bytesRead);  
	        }  
	        //关闭流
	        bis.close();  
	        bos.close();  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
