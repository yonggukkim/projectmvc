package spring;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

public class MemberDao {
	// 의존객체
	private JdbcTemplate jdbcTemplate;
	// 의존객체 주입
	@Autowired
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = 
				new JdbcTemplate(dataSource);
	}
	public Member selectByEmail(String email) {
		String sql = 
				"select * from MEMBER where EMAIL = ?";
		List<Member> results =
				jdbcTemplate.query(sql,
						new MemberRowMapper() ,email);
		return results.isEmpty()? null: results.get(0);
	}
	public Member selectById(Long id) {
		String sql = 
				"select * from MEMBER where ID = ?";
		List<Member> results =
				jdbcTemplate.query(sql,
						new MemberRowMapper() , id);
		return results.isEmpty()? null: results.get(0);
	}
	public List<Member> selectByRegisterDate(Date from, Date to) {
		String sql = "select * from member where regdate between ? and ? order by regdate desc";
		List<Member> results = jdbcTemplate.query(sql, new MemberRowMapper(), from, to);
		return results;
	}
	public void insert(final Member member) {
		jdbcTemplate.update(new PreparedStatementCreator(){	
			String sql ="insert into Member(id,email,password,"
					+ "name, regdate) "
					+ " values(?,?,?,?,?)";
			public PreparedStatement 
					createPreparedStatement(Connection con) 
							throws SQLException{
				PreparedStatement pstmt = 
						con.prepareStatement(sql);
				pstmt.setLong(1, member.getId());
				pstmt.setString(2, member.getEmail());
				pstmt.setString(3, member.getPassword());
				pstmt.setString(4, member.getName());
				pstmt.setTimestamp(5,
						new Timestamp(
						member.getRegisterDate().getTime()
						));
				return pstmt;
			}
		});
		//TODO 구현해야함
	}
	public void update(Member member) {
		//TODO 구현해야함
		String sql = "update member set name=?, password=? "
				+ " where email=?";
		jdbcTemplate.update(sql,member.getName(),
				member.getPassword(),
				member.getEmail());
	}
	public Collection<Member> selectAll() {
		String sql = "select * from member";
		List<Member> results = 
				jdbcTemplate.query(sql,new MemberRowMapper());
		//TODO 구현해야함
		return results;
	}
	public int count() {
		//TODO 구현해야함
		String sql="select count(*) from member";
		Integer count = jdbcTemplate.queryForObject(sql, 
				Integer.class);
		return (Integer) count;
	}
	String sql;
	public int fileInsert(BoaderFile boaderFile) {
		sql = "insert into boaderfile(write_num, filesize, original_file, stored_file_name) values(?,?,?,?)";
		int i = jdbcTemplate.update(sql, boaderFile.getWriteNum(), boaderFile.getFilesize(), boaderFile.getOriginalFile(), boaderFile.getStoredFileName());
		return i;
		/*public void fileInsert(final BoaderFile boaderFile) {
		  sql = "insert into boaderfile(write_num, filesize, original_file, stored_file_name) values(?,?,?,?)";
		  jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, boaderFile.getWriteNum());
					pstmt.setLong(2, boaderFile.getFilesize());
					pstmt.setString(3, boaderFile.getOriginalFile());
					pstmt.setString(4, boaderFile.getStoredFileName());
					return pstmt;
				}
			}
		);*/
	}
}

class MemberRowMapper implements RowMapper<Member> {
	public Member mapRow(ResultSet rs, int rowNum) 
			throws SQLException{
		Member member = new Member(rs.getString("EMAIL"),
				rs.getString("PASSWORD"),
				 rs.getString("NAME"),
				 rs.getTimestamp("REGDATE") );
		
		member.setId(rs.getLong("ID"));
		return member;
	}
}
