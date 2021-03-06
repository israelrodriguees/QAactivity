package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://node78438-env-3081414.jelastic.saveincloud.ne:3306/dbreferals";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = " mern58SJEt";

	/**
	 * Connect.
	 *
	 * @return the connection
	 */
	private Connection connect() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Connection test.
	 */
	// connection test
	public void connectionTest() {
		try {
			Connection con = connect();
			System.out.println(con);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Insert referral.
	 *
	 * @param referral the referral
	 */
	// CRUD - CREATE
	public void insertReferral(JavaBeans referral) {
		String create = "insert into referals (firstnameref,lastnameref,prole,mainphone,email,"
				+ "hearaboutus,refnumber,datebirth,lovetodo,primarydiagnosis,seconddiagnosis,weekhours,"
				+ "reasonref,fundingbody,tierredraty,preflocation,acomneeds,startdate) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			// Open connection
			Connection con = connect();

			// Prepare query to execute in our DB
			PreparedStatement pst = con.prepareStatement(create);

			// Substitute the parameters for the content in our variables
			pst.setString(1, referral.getFirstname());
			pst.setString(2, referral.getLastname());
			pst.setString(3, referral.getWrole());
			pst.setString(4, referral.getWphone());
			pst.setString(5, referral.getWemail());
			pst.setString(6, referral.getWhear());
			pst.setString(7, referral.getWrefnumber());
			pst.setString(8, referral.getWdatebirth());
			pst.setString(9, referral.getWtodo());
			pst.setString(10, referral.getWpdiagnosis());
			pst.setString(11, referral.getWsdiagnosis());
			pst.setString(12, referral.getWeekhours());
			pst.setString(13, referral.getWreasonref());
			pst.setString(14, referral.getWfunding());
			pst.setString(15, referral.getWdraty());
			pst.setString(16, referral.getWplocation());
			pst.setString(17, referral.getWacomneeds());
			pst.setString(18, referral.getWdatestart());

			// Execute query and insert data in our database
			pst.executeUpdate();

			// Close connection with our database
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * List referrals.
	 *
	 * @return the array list
	 */
	// CRUD - READ
	public ArrayList<JavaBeans> listReferrals() {
		// Create an object to access the class JavaBeans
		ArrayList<JavaBeans> referrals = new ArrayList<>();
		String read = "select * from referals order by enquirynumber";

		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			// Loop to execute while there is referrals
			while (rs.next()) {
				// Variables to aux the data the we receive from db
				String eqnumber = rs.getString(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String role = rs.getString(4);
				String phone = rs.getString(5);
				String email = rs.getString(6);
				String hear = rs.getString(7);
				String refnumber = rs.getString(8);
				String birthdate = rs.getString(9);
				String todo = rs.getString(10);
				String pdiag = rs.getString(11);
				String sdiag = rs.getString(12);
				String whours = rs.getString(13);
				String reason = rs.getString(14);
				String fbody = rs.getString(15);
				String draty = rs.getString(16);
				String plocation = rs.getString(17);
				String acomneeds = rs.getString(18);
				String startdate = rs.getString(19);

				// Full the arraylist
				referrals.add(new JavaBeans(eqnumber, fname, lname, role, phone, email, hear, refnumber, birthdate,
						todo, pdiag, sdiag, whours, reason, fbody, draty, plocation, acomneeds, startdate));
			}
			con.close();
			return referrals;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Select referral.
	 *
	 * @param referral the referral
	 */
	// CRUD - UPDATE RECORD
	public void selectReferral(JavaBeans referral) {
		String read2 = "select * from referals where enquirynumber = ?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, referral.getEnqnumber());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// Set JavaBeans Variables
				referral.setEnqnumber(rs.getString(1));
				referral.setFirstname(rs.getString(2));
				referral.setLastname(rs.getString(3));
				referral.setWrole(rs.getString(4));
				referral.setWphone(rs.getString(5));
				referral.setWemail(rs.getString(6));
				referral.setWhear(rs.getString(7));
				referral.setWrefnumber(rs.getString(8));
				referral.setWdatebirth(rs.getString(9));
				referral.setWtodo(rs.getString(10));
				referral.setWpdiagnosis(rs.getString(11));
				referral.setWsdiagnosis(rs.getString(12));
				referral.setWeekhours(rs.getString(13));
				referral.setWreasonref(rs.getString(14));
				referral.setWfunding(rs.getString(15));
				referral.setWdraty(rs.getString(16));
				referral.setWacomneeds(rs.getString(17));
				referral.setWdatestart(rs.getString(18));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Update referral.
	 *
	 * @param referral the referral
	 */
	public void updateReferral(JavaBeans referral) {
		String update = "update referals set firstnameref=?,lastnameref=?,prole=?,mainphone=?,email=?,"
				+ "hearaboutus=?,refnumber=?,datebirth=?,lovetodo=?,primarydiagnosis=?,seconddiagnosis=?,weekhours=?,"
				+ "reasonref=?,fundingbody=?,tierredraty=?,preflocation=?,acomneeds=?,startdate=? where enquirynumber=?";
		
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(update);
			
			// Substitute the "?" for the JavaBeans content
			pst.setString(1, referral.getFirstname());
			pst.setString(2, referral.getLastname());
			pst.setString(3, referral.getWrole());
			pst.setString(4, referral.getWphone());
			pst.setString(5, referral.getWemail());
			pst.setString(6, referral.getWhear());
			pst.setString(7, referral.getWrefnumber());
			pst.setString(8, referral.getWdatebirth());
			pst.setString(9, referral.getWtodo());
			pst.setString(10, referral.getWpdiagnosis());
			pst.setString(11, referral.getWsdiagnosis());
			pst.setString(12, referral.getWeekhours());
			pst.setString(13, referral.getWreasonref());
			pst.setString(14, referral.getWfunding());
			pst.setString(15, referral.getWdraty());
			pst.setString(16, referral.getWplocation());
			pst.setString(17, referral.getWacomneeds());
			pst.setString(18, referral.getWdatestart());
			pst.setString(19, referral.getEnqnumber());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
				
	}
	
	/**
	 * Delete referral.
	 *
	 * @param referral the referral
	 */
	// CRUD DELETE 
	public void deleteReferral(JavaBeans referral) {
		String delete = "delete from referals where enquirynumber=?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(delete);
			System.out.println(delete);
			pst.setInt(1, Integer.parseInt(referral.getEnqnumber()));
			
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

