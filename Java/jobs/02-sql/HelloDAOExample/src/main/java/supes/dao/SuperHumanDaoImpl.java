package supes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import supes.model.SuperHuman;

public class SuperHumanDaoImpl implements SuperHumanDao {

	/*
	 * For ORACLE DBMS specifically the pattern is:
	 * "jdbc:oracle:thin:@[endpoint]:[port]:[database-name]"
	 * 
	 * private static String url= "jdbc:oracle:thin:@localhost:1521:xe";
	 */
	private static String url = "jdbc:oracle:thin:@revychan.c4wt8faaxlgp.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "superhuman";
	private static String password = "p4ssw0rd";

	@Override
	public int insertSuperHuman(SuperHuman sh) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SuperHuman> selectAllSuperHumans() {
		List<SuperHuman> supes = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM superhumans";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				supes.add(new SuperHuman(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supes;
	}

	@Override
	public SuperHuman selectSuperHumanById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuperHuman selectSuperHumanByName(String name) {
		List<SuperHuman> supes = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM superhumans" + " WHERE shuman_name=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				supes.add(new SuperHuman(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}

			if (supes.size() == 1)
				return supes.get(0);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SuperHuman> selectSuperHumansByBounty(int bounty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateSuperHuman(SuperHuman sh) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSuperHuman(SuperHuman sh) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void joinExamplePrint(String name) {
		List<SuperHuman> supes = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * " + 
					"FROM superhumans A " + 
					"INNER JOIN shuman_spower_junction B " + 
					"ON A.shuman_id = B.my_shuman_id " + 
					"INNER JOIN superpowers C " + 
					"ON C.spower_id = B.my_spower_id "+
					"WHERE shuman_name = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println();
				System.out.println(rs.getString(2)+ " "+
				   rs.getInt(3)+ " "+ rs.getString(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
