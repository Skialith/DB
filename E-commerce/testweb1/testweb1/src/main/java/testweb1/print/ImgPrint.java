package testweb1.print;

import java.io.InputStream;

import testweb1.vo.RobotInfo;

public interface ImgPrint {
	public String query_getImgBlob(String robotname)throws Exception;
}
