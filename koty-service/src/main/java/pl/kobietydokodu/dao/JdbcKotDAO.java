package pl.kobietydokodu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import pl.kobietydokodu.domain.Kot;

import javax.sql.DataSource;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

@Configuration
@ImportResource("classpath:beans.xml")
public class JdbcKotDAO implements KotDAOInterf {

    @Autowired
    private DataSource dataSource;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Kot getKotById(Integer jid) {
Kot kot = new Kot();
        try
    {
        Connection myConObject = dataSource.getConnection();

        if (myConObject != null) {
            String sqlSelect = "SELECT * FROM koty WHERE id = ?";
            PreparedStatement myStatObject = myConObject.prepareStatement(sqlSelect);
            myStatObject.setInt(1, jid);
            ResultSet myResultObject = myStatObject.executeQuery();
            if (myResultObject.next()) {
                kot.setId(myResultObject.getLong("id"));
                kot.setName(myResultObject.getString("name"));
                kot.setDateOfBirth(myResultObject.getDate("dateOfBirth"));
                kot.setWeight(myResultObject.getFloat("weight"));
                kot.setCatOwner(myResultObject.getNString("catOwner"));
            }
            myConObject.close();
        }
    }
        catch(SQLException e) {
            System.out.println("Opps, error in connecting or executing query");
            e.printStackTrace();
        }
return kot;
    }

    public Long getMaxId() {
        Long maxid = null;
        try {
            Connection myConObject = dataSource.getConnection();
            if (myConObject != null) {
                String sqlSelect = "SELECT MAX(id) FROM koty";
                Statement myStatObject = myConObject.createStatement();
                ResultSet myResultObject = myStatObject.executeQuery(sqlSelect);
                if (myResultObject.next()) {
                    maxid = myResultObject.getLong(1);
                    System.out.println("zwrócony maxid = " + maxid);
                }
                myConObject.close();
            }
        }
            catch(SQLException e) {
                e.printStackTrace();
            }
            return maxid;
    }

    @Override
    public boolean dodajKota(Kot kot) {
        boolean isCatSaved = false;
        try {
            Connection myConObject = dataSource.getConnection();
            if (myConObject != null) {

                String sqlInsert = "INSERT INTO koty (id, name, dateOfBirth, weight, catOwner) "
                        + "VALUES (?, ?, ?, ?, ?)";

                Date date = Date.valueOf(sdf.format(kot.getDateOfBirth()));
                PreparedStatement myStatObject3 = myConObject.prepareStatement(sqlInsert);
                myStatObject3.setLong(1, kot.getId());
                myStatObject3.setString(2, kot.getName());
                myStatObject3.setDate(3, date);
                myStatObject3.setFloat(4, kot.getWeight());
                myStatObject3.setString(5, kot.getCatOwner());
                int rowsNr = myStatObject3.executeUpdate();
                if (rowsNr > 0) {
                    isCatSaved = true;
                }
            }
                myConObject.close();
        }
        catch(SQLException e) {
                e.printStackTrace();
            }
        return isCatSaved;
    }
    
    public List<Kot> getList() {
        List<Kot> koty = new ArrayList<Kot>();
        try{
            Connection myConObject = dataSource.getConnection();
            if (myConObject != null) {
                String sqlSelect = "SELECT * FROM koty";
                Statement myStatObject = myConObject.createStatement();
                ResultSet myResultObject = myStatObject.executeQuery(sqlSelect);
                while (myResultObject.next()) {
                    Kot kot = new Kot();
                    kot.setId(myResultObject.getLong(1));
                    kot.setName(myResultObject.getString("name"));
                    kot.setDateOfBirth(myResultObject.getDate("dateOfBirth"));
                    kot.setWeight(myResultObject.getFloat("weight"));
                    kot.setCatOwner(myResultObject.getString("catOwner"));
                    koty.add(kot);
                }
                myConObject.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return koty;
    }

    public List<Kot> getListByOwner(String person) {
        List<Kot> koty = new ArrayList<Kot>();
        try{
            Connection myConObject = dataSource.getConnection();
            if (myConObject != null) {
                String sqlSelect = "SELECT * FROM koty where catOwner = ?";
                PreparedStatement myStatObject = myConObject.prepareStatement(sqlSelect);
                myStatObject.setString(1, person);
                ResultSet myResultObject = myStatObject.executeQuery();

                while (myResultObject.next()) {
                    Kot kot = new Kot();
                    kot.setId(myResultObject.getLong(1));
                    kot.setName(myResultObject.getString("name"));
                    kot.setDateOfBirth(myResultObject.getDate("dateOfBirth"));
                    kot.setWeight(myResultObject.getFloat("weight"));
                    kot.setCatOwner(myResultObject.getString("catOwner"));
                    koty.add(kot);
                }
                myConObject.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return koty;
    }


    public boolean isCatNew(String name, String person) {
        boolean isCatNew = true;
        try {
            Connection myConObject = dataSource.getConnection();
            if (myConObject != null) {
                String sqlCheck = "SELECT id FROM koty where name = ? and catOwner = ?";
                PreparedStatement myStatObjec1 = myConObject.prepareStatement(sqlCheck);
                myStatObjec1.setString(1, name);
                myStatObjec1.setString(2, person);
                ResultSet myResultObject1 = myStatObjec1.executeQuery();
                if (myResultObject1.next()) {
                    isCatNew = false;
                }
                myConObject.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return isCatNew;
    }

                public void usunKota(int id) {
                    try {
                        Connection myConOdject = dataSource.getConnection();
                        String sqlDelete = "Delete from koty where id = ?";
                        PreparedStatement myStatement = myConOdject.prepareStatement(sqlDelete);
                        myStatement.setInt(1, id);
                        int rowsNr = myStatement.executeUpdate();
                        if (rowsNr > 0) {
                        }
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
}
