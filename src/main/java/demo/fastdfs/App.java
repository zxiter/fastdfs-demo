package demo.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class App
{
	/**
	 * 注意:test是找不到配置文件的,要用main
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpload() throws Exception
	{
		// 1、把FastDFS提供的jar包添加到工程中
		// 2、初始化全局配置。加载一个配置文件。

		//String config = this.getClass().getResource("/").getPath() + "fdfs_client.conf";
		String config = "";
		ClientGlobal.init(config);
		// 3、创建一个TrackerClient对象。
		TrackerClient trackerClient = new TrackerClient();
		// 4、创建一个TrackerServer对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 5、声明一个StorageServer对象，null。
		StorageServer storageServer = null;
		// 6、获得StorageClient对象。
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 7、直接调用StorageClient对象方法上传文件即可。
		String[] strings = storageClient.upload_file("C:\\Users\\Lucky\\Desktop\\点餐1.jpg", "jpg", null);
		for (String string : strings)
		{
			System.out.println(string);
		}
	}

	public static void main(String[] args) throws Exception
	{
		FastDFSClient client = new FastDFSClient("classpath:fdfs_client.conf");
		String uploadFile = client.uploadFile("C:\\Users\\Lucky\\Desktop\\点餐1.jpg", "jpg");
		System.out.println(uploadFile);//返回的是文件的
	}
}
