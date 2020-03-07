package ru.job4j.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportEngineTest {

    private  final  String  dateTimeFormat = "yyyy-MM-dd HH:mm:ss.SS";
    private final DateFormat dateFormat = new SimpleDateFormat(dateTimeFormat);


    @Ignore
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);

        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(dateFormat.format(worker.getHired().getTime())).append(";")
                .append(dateFormat.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());

        String actual = engine.generate(em -> true);
        System.out.println(actual);
        assertThat(actual, is(expect.toString()));
    }

    @Test
    public void whenImprovedGeneratedAndOneEmployer() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);

        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE html>")
                .append(System.lineSeparator())
                .append("<html>")
                .append(System.lineSeparator())
                .append("<head>")
                .append(System.lineSeparator())
                .append("<meta charset='utf-8'>")
                .append(System.lineSeparator())
                .append("</head>")
                .append(System.lineSeparator())
                .append("<body> ")
                .append(System.lineSeparator())
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append((int) worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("</body>")
                .append(System.lineSeparator())
                .append("</html>")
                .append(System.lineSeparator());

        String actual = engine.generate(em -> true);

        assertThat(actual, is(expect.toString()));
    }

    @Test
    public void whenImprovedGeneratedAndTwoEmployer() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker1 = new Employer("Ivan", now, now, 100);
        Employer worker2 = new Employer("Boris", now, now, 150);
        store.add(worker1);
        store.add(worker2);
        ReportEngine engine = new ReportEngine(store);

        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE html>")
                .append(System.lineSeparator())
                .append("<html>")
                .append(System.lineSeparator())
                .append("<head>")
                .append(System.lineSeparator())
                .append("<meta charset='utf-8'>")
                .append(System.lineSeparator())
                .append("</head>")
                .append(System.lineSeparator())
                .append("<body> ")
                .append(System.lineSeparator())
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append("; ")
                .append((int) worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append("; ")
                .append((int) worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("</body>")
                .append(System.lineSeparator())
                .append("</html>")
                .append(System.lineSeparator());

        String actual = engine.generate(em -> true);

        assertThat(actual, is(expect.toString()));
    }
}