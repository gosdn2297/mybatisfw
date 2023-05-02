package Mybatisfw.ex02;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Mybatisfw.ex01.MemberVO;

public class MemberDAO {
   private static SqlSessionFactory sqlMapper=null;
    //DB연결
   public static SqlSessionFactory getInstance() {
      if(sqlMapper == null) {
         try {
            String resource="mybatis/SqlMapConfig.xml"; //DB설정해놓은 파일가져오기
            Reader reader=Resources.getResourceAsReader(resource); //DB가져오기 reader는 io임포트고 Resources는 org.apache.ibatis.io.Resources인거 확인하기
            sqlMapper=new SqlSessionFactoryBuilder().build(reader);
         } catch (Exception e) {
            System.out.println("DB연결중 에러");
            e.printStackTrace();
         }
      }
      return sqlMapper;
   }
   //회원 이름 찾기
   public String selectName() {
	   sqlMapper=getInstance();
	   SqlSession session=sqlMapper.openSession();
	   String name=session.selectOne("mapper.member.selectName");
	   return name;
   }
   public String selectPwd () {
	   sqlMapper=getInstance();
	   SqlSession session=sqlMapper.openSession();
	   String pwd=session.selectOne("mapper.member.selectPwd");
	   return pwd;
   }
}