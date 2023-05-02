package Mybatisfw.ex01;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
   //회원 정보 목록 메서드 (MemberVO 클래스 활용)
/*   public List<MemberVO> selectAllMemberList(){
      sqlMapper=getInstance();
      SqlSession session=sqlMapper.openSession();
      List<MemberVO> memberList=session.selectList("mapper.member.selectAllMemberList");   //mapper.member 맵퍼의 네임스페이스 이름
      //↑ DB에서 조회된 목록을 MemberVO에 현재 담고있는상태
      return memberList;
   }*/
   //회원 정보 목록 메서드 (HashMap 클래스 활용)
   public List<HashMap<String, String>> selectAllMemberList(){
      sqlMapper=getInstance();
      SqlSession session=sqlMapper.openSession();
      List<HashMap<String, String>> memberList=session.selectList("mapper.member.selectAllMemberList");   //mapper.member 맵퍼의 네임스페이스 이름
      //↑ DB에서 조회된 목록을 MemberVO에 현재 담고있는상태
      return memberList;
   }
}