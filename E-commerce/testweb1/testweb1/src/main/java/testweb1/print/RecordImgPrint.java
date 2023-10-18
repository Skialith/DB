package testweb1.print;


import java.util.ArrayList;

import org.apache.commons.lang3.tuple.Pair;

import testweb1.vo.RobotInfo;



public interface RecordImgPrint {
	public Pair<ArrayList, String> printImgByRecord (RobotInfo robotinfo,String defaultpath)throws Exception;
	public void updateRecordsByNum (int num)throws Exception;
}
