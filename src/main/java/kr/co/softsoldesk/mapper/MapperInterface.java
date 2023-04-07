package kr.co.softsoldesk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.softsoldesk.beans.JdbcBean;

public interface MapperInterface {
	// 컬럼(오라클)명과 Bean의 변수이름이 같으면 생략
	/*
	 @Results({
	 	@Result(column = "int_data", property = "int_data"),
	 	@Result(column = "str_data", property = "str_data") 
	 })
	 */
	
	//#{attribute} : 속성명(아무이름이나 가능)을 써서 바인딩 / jdbcBean의 객체를 통해 .set 메서드를 통해 설정된 값을 가져옴
	@Insert("insert into jdbc_table (int_data, str_data) values (#{int_data}, #{str_data})")
	void insert_data(JdbcBean bean);
	
	@Select("select int_data, str_data from jdbc_table")
	List<JdbcBean> select_data();
	
	@Update("update jdbc_table set int_data = #{int_data} where str_data = #{str_data}")
	void update_data(JdbcBean bean);
		
	@Delete("delete from jdbc_table where int_data = #{int_data}")
	void delete_data(int int_data);
	
}
