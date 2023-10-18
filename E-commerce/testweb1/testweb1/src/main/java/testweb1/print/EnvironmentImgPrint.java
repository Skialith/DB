package testweb1.print;


import java.util.ArrayList;

import org.apache.commons.lang3.tuple.Pair;

import testweb1.vo.RobotInfo;



public interface EnvironmentImgPrint {
	public Pair<ArrayList, String> printEnvironmentByRecord (RobotInfo robotinfo,String defaultpath)throws Exception;
}
