package testweb1.print;


import java.util.ArrayList;

import testweb1.vo.RobotInfo;



public interface RecordPrint {
	public ArrayList printByRecord (RobotInfo robotinfo, int image_num)throws Exception;
}
