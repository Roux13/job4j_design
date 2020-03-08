package ru.job4j.srp;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportEngine {

    private final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss.SS";
    private final DateFormat dateFormat = new SimpleDateFormat(dateTimeFormat);
    private final String standardTitle = "Name; Hired; Fired; Salary;";
    private final String hrTitle = "Name; Salary;";
    private final DecimalFormat salaryFormat = new DecimalFormat("###,###.##");

    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append(standardTitle)
                .append(System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(dateFormat.format(employer.getHired().getTime())).append(";")
                    .append(dateFormat.format(employer.getFired().getTime())).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public String accountantGenerate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append(standardTitle)
                .append(System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(dateFormat.format(employer.getHired().getTime())).append(";")
                    .append(dateFormat.format(employer.getFired().getTime())).append(";")
                    .append(salaryFormat.format(employer.getSalary())).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public String hrGenerate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append(hrTitle)
                .append(System.lineSeparator());
        for (Employer employer : this.sortEmployer(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public String generateHtml(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append(this.addHtmlToBeginning())
                .append(generate(filter))
                .append(addHtmlToTail());
        return text.toString();
    }

    private String addHtmlToBeginning() {
        StringBuilder htmlBeginning = new StringBuilder()
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
                .append(System.lineSeparator());
        return htmlBeginning.toString();
    }

    private String addHtmlToTail() {
        StringBuilder htmlTail = new StringBuilder()
                .append("</body>")
                .append(System.lineSeparator())
                .append("</html>")
                .append(System.lineSeparator());
        return htmlTail.toString();
    }

    private List<Employer> sortEmployer(Predicate<Employer> filter) {
        return store.findBy(filter).stream()
                .sorted((em1, em2) -> (int) (em2.getSalary() - em1.getSalary()))
                .collect(Collectors.toList());

    }
}
