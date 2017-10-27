/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.be;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pgn
 */
public class Student extends Person
{

    private List<GradeInfo> gradeReport;
    private String education;

    public Student(int id, String name, String education)
    {
        super(id, name);
        this.education = education;
        gradeReport = new ArrayList<>();
    }

    public List<GradeInfo> getGradeReport()
    {
        return gradeReport;
    }

    public String getEducation()
    {
        return education;
    }

    public double getAverageGrade()
    {
        double avg = 0.0;
        double sum = 0.0;
        for (GradeInfo gradeInfo : gradeReport)
        {
            sum += gradeInfo.getGrade();
        }
        avg = sum / gradeReport.size();
        return avg;
    }

    public int getGrade(String subject)
    {
        for (GradeInfo gradeInfo : gradeReport)
        {
            if (subject.equalsIgnoreCase(gradeInfo.getSubject()))
            {
                return gradeInfo.getGrade();
            }
        }
        return -1;
    }

    public void addGrade(GradeInfo grade)
    {
        gradeReport.add(grade);
    }

    @Override
    public String toString()
    {
        return super.toString() + " " + education + " " + getAverageGrade();
    }

    
    
}
