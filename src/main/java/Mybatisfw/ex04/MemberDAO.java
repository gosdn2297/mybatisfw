package Mybatisfw.ex04;

import java.io.Reader;
import java.util.List;
import java.util.Map;

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
   //회원 정보 목록 메서드 (MemberVO 클래스 활용)
   public List<MemberVO> selectAllMemberList(){
         sqlMapper=getInstance();
         SqlSession session=sqlMapper.openSession();
         List<MemberVO> memberList=session.selectList("mapper.member.selectAllMemberList");   //mapper.member 맵퍼의 네임스페이스 이름
         //↑ DB에서 조회된 목록을 MemberVO에 현재 담고있는상태
         return memberList;
   }
   //ID로 회원 검색
   public MemberVO selectMemberById(String id) {
	   sqlMapper=getInstance();
	   SqlSession session=sqlMapper.openSession();
	   MemberVO memberVO=session.selectOne("mapper.member.selectMemberById", id);
	   return memberVO;
   }
   //이름으로 회원 검색
   public List<MemberVO> selectMemberByName(String name) {
	   sqlMapper=getInstance();
	   SqlSession session=sqlMapper.openSession();
	   List<MemberVO> memberList=session.selectList("mapper.member.selectMemberByName", name);
	   return memberList;
   }
   //회원 등록
   public void insertMember(MemberVO memberVO) {
	   sqlMapper=getInstance();
	   SqlSession session=sqlMapper.openSession();
	   session.insert("mapper.member.insertMember",memberVO);
	   session.commit();//insert나 update 변화가 있으면 반드시 commit
   }
   public void insertMember2(Map<String,String> memberMap) {
	   sqlMapper=getInstance();
	   SqlSession session=sqlMapper.openSession();
	   session.insert("mapper.member.insertMember2",memberMap);
	   session.commit();//insert나 update 변화가 있으면 반드시 commit
   }
   //회원수정
   public void updateMember(MemberVO memberVO) {
	   sqlMapper=getInstance();
	   SqlSession session=sqlMapper.openSession();
	   session.update("mapper.member.updateMember",memberVO);
	   session.commit();//insert나 update 변화가 있으면 반드시 commit
   }
   //회원 삭제
   public void delMember(String id) {
	   sqlMapper=getInstance();
	   SqlSession session=sqlMapper.openSession();
	   session.delete("mapper.member.delMember",id);
	   session.commit();
   }
   //동적 조회
   public List<MemberVO> searchMember(MemberVO memberVO) {
	   sqlMapper=getInstance();
	   SqlSession session=sqlMapper.openSession();
	   List<MemberVO> list=session.selectList("mapper.member.searchMember",memberVO);
	   return list;
   }
}