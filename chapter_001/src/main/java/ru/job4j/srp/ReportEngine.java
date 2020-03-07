package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportEngine {

//    private  final  String  dateTimeFormat = "yyyy-MM-dd HH:mm:ss.SS";
//    private final DateFormat dateFormat = new SimpleDateFormat(dateTimeFormat);

    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append(this.addHtmlToBeginning())
                .append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append("; ")
                    .append((int) employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        text.append(addHtmlToTail());
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

}
