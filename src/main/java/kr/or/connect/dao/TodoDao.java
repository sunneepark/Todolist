package kr.or.connect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.config.ApplicationConfig;
import kr.or.connect.dto.TodoDto;

public class TodoDao {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<TodoDto> getTodos(){
		List<TodoDto> list = new ArrayList<TodoDto>();
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Connection conn = ac.getBean(Connection.class);
		
		String sql_select="select id, title, name, sequence, type, regdate"
				+ " from todo "
				+ "order by regdate desc";
		
				try {
					ps = conn.prepareStatement(sql_select);
					rs = ps.executeQuery();

					while(rs.next()) {
						TodoDto role = new TodoDto(rs.getLong("id"),rs.getString("title"),
								rs.getString("name"),rs.getInt("sequence"),rs.getString("type"),rs.getString("regdate"));
						list.add(role);
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					if (ps != null) {
						try {
							ps.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
		
		return list;
	}
	public int addTodo(TodoDto td) {
		int insertCount=0;
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Connection conn = ac.getBean(Connection.class);
		
		try {
			String sql_insert = "insert into todo(title, name, sequence) values(?,?,?)";
			
			ps = conn.prepareStatement(sql_insert);
			
			ps.setString(1, td.getTitle());
			ps.setString(2, td.getName());
			ps.setInt(3, td.getSequence());
			
			insertCount = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return insertCount;
	}
	public int updateTodo(TodoDto td) {
		int updateCount=0;
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Connection conn = ac.getBean(Connection.class);
		
		try {
			String sql_update = "UPDATE todo set TYPE = ? where id = ?";
			
			ps = conn.prepareStatement(sql_update);
			
			ps.setString(1, td.getType());
			ps.setLong(2, td.getId());
			
			updateCount = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return updateCount;
	}
}
