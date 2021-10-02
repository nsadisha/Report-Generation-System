package com.rgsystem.report;

import com.rgsystem.database.Database;
import com.rgsystem.report.reports.DailySalesReport;
import com.rgsystem.report.reports.UserSignupsReport;

public class ReportFactory {
    private final Database database;
    private final Period period;

    public ReportFactory(Database database, Period period){
        this.database = database;
        this.period = period;
    }

    public Report getInstance(String type) {
        Report report = null;
            if (type.equals("daily-sales")) {
                report = new DailySalesReport(this.database, this.period, "Daily Sales Report");
            }else if(type.equals("user-signups")){
                report = new UserSignupsReport(this.database, this.period, "User Signups Report");
            }

        return report;
    }
}
