package com.rgsystem.report;

import com.rgsystem.database.Database;
import com.rgsystem.database.SQLDatabase;
import com.rgsystem.report.reports.DailySalesReport;
import com.rgsystem.report.reports.UserSignupsReport;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ReportFactoryTest {

    //test cases
    // 1. if the report type is is daily sales -> should return an object of DailySalesReport class
    @Test
    public void  should_return_DailySalesReport_object_when_report_type_is_daily_sales(){

        Database database = new SQLDatabase();

        Period period = new Period("2021-09-01", "2021-10-01");

        ReportFactory factory = new ReportFactory(database, period);
        Report report = factory.getInstance("daily-sales");

        //verify that the Report object is an instance of DailySalesReport class
        assertThat(report, instanceOf(DailySalesReport.class));

    }

    //test cases
    // 1. if the report type is is user signups -> should return an object of UserSignupsReport class
    @Test
    public void  should_return_UserSignupsReport_object_when_report_type_is_user_signups(){

        Database database = new SQLDatabase();

        Period period = new Period("2021-09-01", "2021-10-01");

        ReportFactory factory = new ReportFactory(database, period);
        Report report = factory.getInstance("user-signups");

        //verify that the Report object is an instance of DailySalesReport class
        assertThat(report, instanceOf(UserSignupsReport.class));

    }

}