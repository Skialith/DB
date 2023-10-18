package testweb1.dao;
import java.io.InputStream;
import testweb1.vo.*;
public interface UserDAO {
  //Register method
  public int insertByRegister (UserInfo userinfo,RobotInfo robotinfo)throws Exception;
  //query userinfo by id
  public UserInfo queryUserById (int id)throws Exception;
  public int queryIdByUser (UserInfo userinfo)throws Exception;
  //Query robot information method
  public RobotInfo queryByRobotInfo (RobotInfo robotinfo)throws Exception;
  //Query the robot name from the user information
  public String queryRobotById (int id)throws Exception;
  //login method
  public UserInfo queryByUserInfo (UserInfo userinfo)throws Exception;
  //update username
  public int updatedUsernameByUserInfo(UserInfo userinfo,UpdatedUserInfo updateduserinfo)throws Exception;
  //update password
  public void updatedPasswordByUserInfo(UserInfo userinfo,UpdatedUserInfo updateduserinfo)throws Exception;
  //delete account
  public int deleteByUserInfo (UserInfo userinfo)throws Exception;
  //upload img
  public int uploadImg (RobotInfo robotinfo,InputStream is)throws Exception;
  //create records when login
  public void insertRecordsByRobotInfo (String robotname)throws Exception;
  //modify path that record_imgs saved in
  public void updatedAddress (RobotInfo robotinfo,UpdatedAddress updatedAddress)throws Exception;
  public void updatedAddress2 (RobotInfo robotinfo,UpdatedAddress updatedAddress)throws Exception;
  //update robotname
  public void updatedRobotname(String robotname,UpdatedRobotname updatedrobotname)throws Exception;
  public int queryNumByRobot (String robotname)throws Exception;
}
