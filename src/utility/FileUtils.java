package utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
	public static BufferedWriter bw = null;
	public static FileWriter fw = null;

	public static void writeFile(String object, String log) {
		try {
			File file = new File("./resources/log.txt");

			// kiểm tra nếu file chưa có thì tạo file mới
			if (!file.exists()) {
				file.createNewFile();
			}
			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currrentTime = dateFormat.format(date);
			bw.write("time:" + currrentTime + "\r\n");
			bw.write("title:" + object + "\r\n");
			bw.write(log + "\r\n");
			bw.write("------------------------------------------\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
