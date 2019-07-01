package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import getPlan.getPlan;

public class funtionPlan {
	static Connection con;

	public funtionPlan() throws Exception {
		con = dbCon.getConnection();
	}

	public static void monPlan(getPlan gp) throws Exception {
		String sql = "INSERT INTO MONDAYPLAN(PLAN) VALUES(?)";

		PreparedStatement ps1 = con.prepareStatement(sql);
		ps1.setString(1, gp.getPlan());
		int r1 = ps1.executeUpdate();
		ps1.close();
	}

	public void tuesPlan(getPlan gp) throws Exception {
		String sql = "INSERT INTO TUESDAYPLAN(PLAN) VALUES(?)";

		PreparedStatement ps1 = con.prepareStatement(sql);
		ps1.setString(1, gp.getPlan());
		int r1 = ps1.executeUpdate();
		ps1.close();
	}

	public void wednesPlan(getPlan gp) throws Exception {
		String sql = "INSERT INTO WEDNESDAYPLAN(PLAN) VALUES(?)";

		PreparedStatement ps1 = con.prepareStatement(sql);
		ps1.setString(1, gp.getPlan());
		int r1 = ps1.executeUpdate();
		ps1.close();

	}

	public void thursPlan(getPlan gp) throws Exception {
		String sql = "INSERT INTO THURSDAYPLAN(PLAN) VALUES(?)";

		PreparedStatement ps1 = con.prepareStatement(sql);
		ps1.setString(1, gp.getPlan());
		int r1 = ps1.executeUpdate();
		ps1.close();

	}

	public void friPlan(getPlan gp) throws Exception {
		String sql = "INSERT INTO FRIDAYPLAN(PLAN) VALUES(?)";

		PreparedStatement ps1 = con.prepareStatement(sql);
		ps1.setString(1, gp.getPlan());
		int r1 = ps1.executeUpdate();
		ps1.close();

	}

	public void saturPlan(getPlan gp) throws Exception {
		String sql = "INSERT INTO SATURDAYPLAN(PLAN) VALUES(?)";

		PreparedStatement ps1 = con.prepareStatement(sql);
		ps1.setString(1, gp.getPlan());
		int r1 = ps1.executeUpdate();
		ps1.close();

	}

	public void sunPlan(getPlan gp) throws Exception {
		String sql = "INSERT INTO SUNDAYPLAN(PLAN) VALUES(?)";

		PreparedStatement ps1 = con.prepareStatement(sql);
		ps1.setString(1, gp.getPlan());
		int r1 = ps1.executeUpdate();
		ps1.close();

	}

	public void monDelete(getPlan gp) throws SQLException {
		String sql = "DELETE FROM MONDAYPLAN WHERE PLAN = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, gp.getPlan());
		ps.executeUpdate();// 실행
		ps.close();

	}

	public void tuesDelete(getPlan gp) throws Exception {
		String sql = "DELETE FROM TUESDAYPLAN WHERE PLAN = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, gp.getPlan());
		ps.executeUpdate();// 실행
		ps.close();
	}

	public void wednesDelete(getPlan gp) throws Exception {
		String sql = "DELETE FROM WEDNESDAYPLAN WHERE PLAN = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, gp.getPlan());
		ps.executeUpdate();// 실행
		ps.close();
	}

	public void thursDelete(getPlan gp) throws Exception {
		String sql = "DELETE FROM THURSDAYPLAN WHERE PLAN = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, gp.getPlan());
		ps.executeUpdate();// 실행
		ps.close();
	}

	public void friDelete(getPlan gp) throws Exception {
		String sql = "DELETE FROM FRIDAYPLAN WHERE PLAN = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, gp.getPlan());
		ps.executeUpdate();// 실행
		ps.close();
	}

	public void saturDelete(getPlan gp) throws Exception {
		String sql = "DELETE FROM SATURDAYPLAN WHERE PLAN = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, gp.getPlan());
		ps.executeUpdate();// 실행
		ps.close();
	}

	public void sunDelete(getPlan gp) throws Exception {
		String sql = "DELETE FROM SUNDAYPLAN WHERE PLAN = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, gp.getPlan());
		ps.executeUpdate();// 실행
		ps.close();
	}

	public ArrayList monSearch(String str) throws Exception {
		String sql = "SELECT PLAN FROM MONDAYPLAN WHERE PLAN LIKE '%" + str + "%'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList data = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("PLAN"));
			data.add(temp);
		}
		rs.close();
		ps.close();

		return data;
	}

	public ArrayList tuesSearch(String str) throws SQLException {
		String sql = "SELECT PLAN FROM TUESDAYPLAN WHERE PLAN LIKE '%" + str + "%'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList data = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("PLAN"));
			data.add(temp);
		}
		rs.close();
		ps.close();

		return data;
	}

	public ArrayList wednesSearch(String str) throws SQLException {
		String sql = "SELECT PLAN FROM WEDNESDAYPLAN WHERE PLAN LIKE '%" + str + "%'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList data = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("PLAN"));
			data.add(temp);
		}
		rs.close();
		ps.close();

		return data;
	}

	public ArrayList thursSearch(String str) throws SQLException {
		String sql = "SELECT PLAN FROM THURSDAYPLAN WHERE PLAN LIKE '%" + str + "%'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList data = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("PLAN"));
			data.add(temp);
		}
		rs.close();
		ps.close();

		return data;
	}

	public ArrayList friSearch(String str) throws SQLException {
		String sql = "SELECT PLAN FROM FRIDAYPLAN WHERE PLAN LIKE '%" + str + "%'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList data = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("PLAN"));
			data.add(temp);
		}
		rs.close();
		ps.close();

		return data;
	}

	public ArrayList saturSearch(String str) throws SQLException {
		String sql = "SELECT PLAN FROM SATURDAYPLAN WHERE PLAN LIKE '%" + str + "%'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList data = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("PLAN"));
			data.add(temp);
		}
		rs.close();
		ps.close();

		return data;
	}

	public ArrayList sunSearch(String str) throws SQLException {
		String sql = "SELECT PLAN FROM SUNDAYPLAN WHERE PLAN LIKE '%" + str + "%'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList data = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("PLAN"));
			data.add(temp);
		}
		rs.close();
		ps.close();

		return data;
	}

	public getPlan monSelect(String no) throws Exception {
		// jtable에서 클릭한 레코드의 정보를 Video 타입으로 저장해서 return
		getPlan gp = new getPlan();
		String sql = "SELECT * FROM MONDAYPLAN WHERE PLAN = '" + no + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			gp.setPlan(rs.getString("PLAN"));
		}
		rs.close();
		ps.close();

		return gp;
	}

	public getPlan tuesSelect(String no) throws Exception {
		getPlan gp = new getPlan();
		String sql = "SELECT * FROM TUESDAYPLAN WHERE PLAN = '" + no + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			gp.setPlan(rs.getString("PLAN"));
		}
		rs.close();
		ps.close();

		return gp;
	}

	public getPlan wednesSelect(String no) throws Exception {
		getPlan gp = new getPlan();
		String sql = "SELECT * FROM WEDNESDAYPLAN WHERE PLAN = '" + no + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			gp.setPlan(rs.getString("PLAN"));
		}
		rs.close();
		ps.close();

		return gp;
	}

	public getPlan thursSelect(String no) throws Exception {
		getPlan gp = new getPlan();
		String sql = "SELECT * FROM THURSDAYPLAN WHERE PLAN = '" + no + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			gp.setPlan(rs.getString("PLAN"));
		}
		rs.close();
		ps.close();

		return gp;
	}

	public getPlan friSelect(String no) throws Exception {
		getPlan gp = new getPlan();
		String sql = "SELECT * FROM FRIDAYPLAN WHERE PLAN = '" + no + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			gp.setPlan(rs.getString("PLAN"));
		}
		rs.close();
		ps.close();

		return gp;
	}

	public getPlan saturSelect(String no) throws Exception {
		getPlan gp = new getPlan();
		String sql = "SELECT * FROM SATURDAYPLAN WHERE PLAN = '" + no + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			gp.setPlan(rs.getString("PLAN"));
		}
		rs.close();
		ps.close();

		return gp;
	}

	public getPlan sunSelect(String no) throws Exception {
		getPlan gp = new getPlan();
		String sql = "SELECT * FROM SUNDAYPLAN WHERE PLAN = '" + no + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			gp.setPlan(rs.getString("PLAN"));
		}
		rs.close();
		ps.close();

		return gp;
	}
}
