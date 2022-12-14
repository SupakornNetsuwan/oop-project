package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectModel {

    private Subject subject;
    private ArrayList<Subject> subjectList;
    private final Connection con = Connect.ConnectDB();
    private ResultSet result = null;
    private PreparedStatement statement = null;
    private PreparedStatement statement2 = null;
    private String sql;
    private int QuantityStudent = 0;

    public SubjectModel() {
        subjectList = new ArrayList<Subject>();
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(ArrayList<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public boolean addSubject(String subjectName, String subjectID, String professorName, String detail) {
        try {
            statement = con.prepareStatement("INSERT INTO subject (name, subject_id, professor_fullname, details) VALUES (?, ?, ?, ?)");
            statement.setString(1, subjectName);
            statement.setString(2, subjectID);
            statement.setString(3, professorName);
            statement.setString(4, detail);
            statement.executeUpdate();
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return false;
        }
    }

    public boolean deleteSubject(String realId) {
        try {
            statement = con.prepareStatement("DELETE FROM subject WHERE id=(?)");
            statement.setString(1, realId);
            statement.executeUpdate();
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return false;
        }
    }

    public void readSubject() {
        sql = "SELECT * FROM subject";
        try {
            statement = con.prepareStatement(sql);
            result = statement.executeQuery();
            while (result != null && result.next()) {
                QuantityStudent = 0;
                subject = new Subject();
                subject.setIdDB(result.getInt("id"));
                subject.setName(result.getString("name"));
                subject.setId(result.getString("subject_id"));
                subject.setProfessorName(result.getString("professor_fullname"));
                subject.setDetail(result.getString("details"));

                statement2 = con.prepareStatement("SELECT * FROM student_in_subject WHERE subject = ?");
                statement2.setString(1, String.valueOf(result.getInt("id")));
                ResultSet result2 = statement2.executeQuery();
                while (result2 != null && result2.next()) {
                    QuantityStudent++;
                }
                subject.setQuantityStudent(QuantityStudent);
                subjectList.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object[][] getSubjects() {
        readSubject();
        Object[][] recordsForTableContent = new Object[subjectList.size()][6];
        for (int i = 0; i < subjectList.size(); i++) {
            Object[] eachSubject = {false, subjectList.get(i).getName(), subjectList.get(i).getId(), subjectList.get(i).getProfessorName(), subjectList.get(i).getQuantityStudent(), subjectList.get(i).getIdDB()};
            recordsForTableContent[i] = eachSubject;
        }
        subjectList.clear();
        return recordsForTableContent;
    }

}
